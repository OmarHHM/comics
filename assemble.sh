 #!/bin/bash

cd alboComicsScheduler

echo 'Starting Job...'

mvn clean install
mvn spring-boot:run &

echo 'Job started...' 
echo -e "\n"
echo -e "\n"
echo -e "\n"
cd ..
cd ..

cd alboComics

echo 'Starting API...'

mvn clean install
mvn spring-boot:run &

echo 'API Started...'
echo -e "\n"
echo -e "\n"
echo -e "\n"
exit 0