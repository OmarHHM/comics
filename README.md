# API Comics
API con conexión a Marvel para obtener información sobre  Irón Man y Capitán América.


## Requisitos
 - Java 11 o superior.
 - Maven 3.6.3 o superior
## Instalación Técnica.
 
 - Clone el proyecto o bien descargue el código.
      - git clone https://github.com/OmarHHM/comics.git
 - En caso de usar linux, dar permisos a la carpeta creada, abra una terminal e ingrese a la ruta del proyecto "ruta"/comics, puede ejecutar el siguiente comando.
      - sudo chmod 775 -R alboComics/
      - sudo chmod 775 -R alboComicsScheduler/
 - Para arrancar el servidor abra una terminal de linux o bash en windows e ingrese a la ruta "ruta"/comics/ y ejecute el archivo assemble.sh
      - ./assemble.sh      
   Espere un momento antes de seguir con el siguiente paso.
 - Para probar el API abra una terminal linux o bash en windows e ingrese a la ruta /comics/ y ejecute el archivo avengers.sh
      - ./avengers.sh
 - Una vez ejecutado los pasos anteriores y sin tener errores, puede visualizar y probar el servicio en la consola de swagger, ingrese ala URL http:suDominio.com/marvel/swagger-ui.html
 - Para finalizar el servidor debe cerrar las terminales o consolas abiertas, abra una nueva consola e ingrese a la ruta del proyecto "ruta"/comics, ejecute el siguiente comando.
      - ./stopServer.sh
 
