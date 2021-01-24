# API Comics
API con conexión a Marvel para obtener información sobre Irón Man y Capitán América consta de un job que se ejecuta al iniciar el proyecto y despues cada día a las 0 hrs, esto con la finalidad de actualizar la información en la base de datos de mongo que se encuentra alojado en un cluster de Mongo Atlas.
El API provee dos endpoints en el cual se podrá realizar la consulta de su superheroe favorito (Iron Man, Capitan America).
- colaborators 
  - Nos provee la información de los editores, escritores y coloristas que actuaron en los comics donde aparece nuestro personaje (Iron Man, Capitan America).
- characters
  - Nos provee los nombres de los personajes que se han relacionado con nuestro personaje principal (Iron Man , Capitan America), asi como los titulos de los comics en donde interactuaron.

## Requisitos
 - Java 11 o superior.
 - Maven 3.6.3 o superior
## Instalación.
 
 - Clone el proyecto o bien descargue el código.
 ```
 git clone https://github.com/OmarHHM/comics.git
 ```
 - En caso de usar linux, dar permisos a la carpeta creada, abra una terminal e ingrese a la ruta del proyecto "ruta"/comics, puede ejecutar el siguiente comando.
 ```
 sudo chmod 775 -R alboComics/
 sudo chmod 775 -R alboComicsScheduler/
 ```
 - Para arrancar el servidor abra una terminal de linux o bash en windows e ingrese a la ruta "ruta"/comics/ y ejecute el archivo assemble.sh
 ```
 ./assemble.sh
 ```
   Espere un momento antes de seguir con el siguiente paso.
 - Para probar el API abra una terminal linux o bash en windows e ingrese a la ruta /comics/ y ejecute el archivo avengers.sh
 ```
 ./avengers.sh
```
- Una vez ejecutado los pasos anteriores y sin tener errores, puede visualizar y probar el servicio en la consola de swagger, ingrese ala URL http:suDominio.com/marvel/swagger-ui.html
 - Para finalizar el servidor debe cerrar las terminales o consolas abiertas, abra una nueva consola e ingrese a la ruta del proyecto "ruta"/comics, ejecute el siguiente comando.
 ```
 ./stopServer.sh
 ```
 - Los logs de cada proyecto aparecen en la carpeta log correspondiente.
 ```
  alboComics/log
  alboComicsScheduler/log
 ```
