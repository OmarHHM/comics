#!/bin/bash
echo 'Obteniendo los datos de escritores, editores y coloristas de Iron man...'

response=$(curl -X GET --header 'Accept: application/json' 'http://localhost:8080/marvel/colaborators/ironman')
echo $response

echo -e "\n"
echo -e "\n"
echo -e "\n"

echo 'Obteniendo los datos de escritores, editores y coloristas de  Capitán América...'

response=$(curl -X GET --header 'Accept: application/json' 'http://localhost:8080/marvel/colaborators/capamerica')
echo $response

echo -e "\n"
echo -e "\n"
echo -e "\n"

echo 'Obteniendo los datos de personajes que han interactuado con  Capitán América...'

response=$(curl -X GET --header 'Accept: application/json' 'http://localhost:8080/marvel/characters/capamerica')
echo $response


echo -e "\n"
echo -e "\n"
echo -e "\n"

echo 'Obteniendo los datos de personajes que han interactuado con Iron Man...'
response=$(curl -X GET --header 'Accept: application/json' 'http://localhost:8080/marvel/characters/ironman')
echo $response

echo -e "\n"
echo -e "\n"
echo -e "\n"

echo -e "\nGracias por ocupar la espera, regrese pronto."