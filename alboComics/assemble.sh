 #!/bin/bash
echo 'Starting server...'
mvn clean install
mvn spring-boot:run
echo 'Server started...'