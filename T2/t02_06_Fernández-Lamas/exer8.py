#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Queremos realizar un programa que calcule o índice dunha chave para un dicionario utilizando o algoritmo de hashing por folding. 
O programa recibirá en orde os seguintes parámetros: tamaño da táboa, número de división por folding e a chave.
"""

__author__ = "Pablo Fernández Lamas"

#Función de hashing.
def hashing(palabra,folding,tamaño):
    """Función que realiza el hashing.

    Args:
        palabra (str): palabra a codificar.
        folding (int): divisiçon por folding.
        tamaño (int): tamaño tabla de hashing.

    Raises:
        ValueError: si el tipo de la variable no coincide.
        ValueError: si el tipo de la variable no coincide.
        ValueError: si el tipo de la variable no coincide.

    Returns:
        int: índice en la tabla de hash.
    """
    if type(tamaño) is not int:
        raise ValueError
    elif type(folding) is not int:
        raise ValueError
    elif type(palabra) is not str:
        raise ValueError
    cifras=""
    suma=0
    palabra = palabra.lower()
    for letra in palabra:
        codigo=ord(letra)
        cifras+=str(codigo)
    while cifras != "":
        suma+=int(cifras[:folding])
        cifras=cifras.replace(cifras[:folding], "",1)
    indice=suma % int(tamaño)
    return indice
    


#Petición de datos y muestra de resultado.
try:
    tamaño=int(input("Introduce el tamaño de la tabla: "))
    folding=int(input("Introduce el número de división por folding: "))
    palabra=input("Introduce la entrada que deseas: ")
    llave=float(input("Introduce la llave correspondiente para cada entrada del diccionario: "))
    indice_final=hashing(palabra,folding,tamaño)
    print("El índice de la palabra '" + str(palabra) + "' es " + str(indice_final) + ".")
except ValueError:
    print("Error. Dato no válido.")