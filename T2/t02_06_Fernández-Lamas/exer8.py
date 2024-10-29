#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Queremos realizar un programa que calcule o índice dunha chave para un dicionario utilizando o algoritmo de hashing por folding. 
O programa recibirá en orde os seguintes parámetros: tamaño da táboa, número de división por folding e a chave.
"""

__author__ = "Pablo Fernández Lamas"

def hashing():
     


#Petición de datos y muestra de resultado.
try:
    tamaño=input("Introduce el tamaño de la tabla: ")
    folding=input("Introduce el número de división por folding: ")
    i=0
    while i<tamaño:
        palabra=input("Introduce la entrada que deseas: ")
        llave=input("Introduce la llave correspondiente para cada entrada del diccionario: ")
        i+=1
except ValueError:
    print("Error. Dato no válido.")