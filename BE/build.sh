#!/bin/bash
echo "===== Check update =====>"

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
        ~/apache-tomcat-9.0.34/bin/shutdown.sh

        # remove old data
        rm -rf ~/apache-tomcat-9.0.34/webapps/ROOT
        rm -rf ~/apache-tomcat-9.0.34/webapps/ROOT.war

        # merge and build
        echo "***** BUILD START *****"
        git pull
        ./gradlew build -x test

        # move to WEBROOT
        cp ./build/libs/ROOT.war ~/apache-tomcat-9.0.34/webapps/

        # restart tomcat
        ~/apache-tomcat-9.0.34/bin/startup.sh

        echo "***** SERVER RESTARTED ***** "
fi
echo "<====== End Update ====="
