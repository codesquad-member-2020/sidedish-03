#!/bin/bash
echo "===== Check update =====>"

export JASYPT_PASSWORD="sidedish";
export GITHUB_CLIENT_ID="bed01aae4e0ea3bebf24";
export GITHUB_CLIENT_SECRET="a6a4a7e18bbddd855c868c2bdf0d280219d42e35";

# check update
cd sidedish-03/BE
git fetch
now=`git rev-parse HEAD`
origin=`git rev-parse origin/master`

echo "[*] now : $now"
echo "[*] origin : $origin"

if [ $now == $origin ]; then
        echo "Already up to date"
else
        # shutdown server
        /home/ubuntu/apache-tomcat-9.0.34/bin/shutdown.sh

        # merge and build
        echo "***** BUILD START *****"
        git pull
        ./gradlew build -x test

        # remove old data
        rm -rf /home/ubuntu/apache-tomcat-9.0.34/webapps/ROOT
        rm -rf /home/ubuntu/apache-tomcat-9.0.34/webapps/ROOT.war

        # move to WEBROOT
        cp ./build/libs/ROOT.war /home/ubuntu/apache-tomcat-9.0.34/webapps/

        # restart tomcat
        sleep 5
        /home/ubuntu/apache-tomcat-9.0.34/bin/startup.sh

        echo "***** SERVER RESTARTED ***** "
fi
