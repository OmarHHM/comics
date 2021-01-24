 #!/bin/bash

cd alboComicsScheduler

echo 'Starting Job...'

mvn clean install
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Djdk.tls.client.protocols=TLSv1.2" &

echo 'Job started...' 
echo -e "\n"
echo -e "\n"
echo -e "\n"

cd ..

cd alboComics

echo 'Starting API...'

mvn clean install
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Djdk.tls.client.protocols=TLSv1.2" &

echo 'API Started...'
echo -e "\n"
echo -e "\n"
echo -e "\n"
