#!/bin/bash
echo "===== Check update =====>"

# 경로는 개인에 맞게 수정필요
# check update
cd /Users/idion/Downloads/sidedish-03/BE || exit 1
git fetch
now=$(git rev-parse HEAD)
origin=$(git rev-parse origin/master)

echo "[*] now : $now"
echo "[*] origin : $origin"

if [ "$now" == "$origin" ]; then
        echo "Already up to date"
else
        # merge and build
        echo "***** BUILD START *****"
        git pull
        ./gradlew build -x test

        # move to WEBROOT
        scp -i /Users/idion/awskey/ubuntu1804mysql57testdbserver.pem ./build/libs/ROOT.war ubuntu@15.165.21.99:/home/ubuntu/apache-tomcat-9.0.34/webapps/ROOT.war

        echo "ROOT.war Successfully Uploaded"

        # move to FE directory
        cd ../FE/sidedish || exit 1

        # npm install
        echo "npm install..."
        npm install > /dev/null 2>&1

        # npm build
        echo "npm build start"
        npm run build > /dev/null 2>&1
        echo "npm build done"

        echo "Upload FE"
        scp -i /Users/idion/awskey/ubuntu1804mysql57testdbserver.pem -r ./build/* ubuntu@15.165.21.99:/var/www/html/ > /dev/null 2>&1

        echo "Jobs Done"

fi
