#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Queremos realizar un programa que calcule o índice dunha chave para un dicionario utilizando o algoritmo de hashing por folding. 
O programa recibirá en orde os seguintes parámetros: tamaño da táboa, número de división por folding e a chave.
"""

__author__ = "Pablo Fernández Lamas"

#Función de validación.
def validacion(tamaño,folding,palabra):
    """Función que valida los datos a utilizar.

    Args:
        tamaño (int): tamaño de la tabla.
        folding (int): divisor de folding.
        palabra (str): entrada del diccionario.

    Raises:
        ValueError: si los valores introducidos no son válidos.
        ValueError: si los valores introducidos no son válidos.
        ValueError: si los valores introducidos no son válidos.

    Returns:
        True: boolean.
    """
    if type(tamaño) is not int:
        raise ValueError
    elif type(folding) is not int:
        raise ValueError
    elif type(palabra) is not str:
        raise ValueError
    else:
        return True



#Función de hashing.
def hashing(palabra,folding):
    """Función que calcula el índice de hash para cada entrada del diccionario.

    Args:
        palabra (str): entrada del diccionario
        folding (int): divisor de folding.

    Returns:
        indice: indice de hash para la entrada.
    """
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
    i=0
    while i<int(tamaño):
        palabra=input("Introduce la entrada que deseas: ")
        llave=float(input("Introduce la llave correspondiente para cada entrada del diccionario: "))
        indice_final=hashing(palabra,folding)
        validacion(tamaño,folding,palabra)
        print("El índice de la palabra '" + str(palabra) + "' es " + str(indice_final) + ".")
        #No tener en cuenta.
        #if validacion(tamaño,folding,palabra):
        #    i+=1
        #else:
        #    i+=0
    print("La tabla está completa.")
except ValueError:
    print("Error. Dato no válido.")