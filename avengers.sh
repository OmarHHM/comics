#!/bin/bash

echo 'Bienvenido, ¿qué desea realizar? Digite el número'
echo  "1=Consultar editores,escritores y coloristas." 
echo  "2=Consultar personajes relacionados a un superheroe."
echo  "Al terminar presione enter."

read valor

endpoint=''

if [[ $valor = 1 ]]
then
	endpoint="colaborators"
elif [[ $valor = 2 ]]
	then
		endpoint="characters"
else
	echo 'El valor indicado no es correcto.'
	exit 0
fi

echo  '¿Qué superheroe desea consultar?'
echo  '1=Iron Man' 
echo  '2=Capitán América'
echo  'Al terminar presione enter.'
read superheroeId
echo  'Consultando datos, espere un momento...'
	
if [[ $superheroeId = 1 ]] 	
then
	response=$(curl -X GET --header 'Accept: application/json' "http://localhost:8080/marvel/"$endpoint"/ironman")
	echo $response
	echo -e "\n"
	echo -e "\n"
	echo -e "\n"
	echo 'Obteniendo los datos de Iron Man...'		
elif [[ $superheroeId = 2 ]] 
	then
		response=$(curl -X GET --header 'Accept: application/json' "http://localhost:8080/marvel/"$endpoint"/capamerica")
		echo $response
		echo -e "\n"
		echo -e "\n"
		echo -e "\n"
		echo 'Obteniendo los datos de Iron Man...'	
		echo -e "\n"
		echo 'Gracias por usar la aplicación Albo Comics'	
else	
	echo 'El valor indicado no es correcto.'
	exit 0
fi	