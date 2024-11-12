#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
A ordenación por burbulla é un algoritmo de ordenación simple pero ineficiente para listas pequenas. 
Funciona comparando elementos adxacentes na lista e intercambiándoos se están na orde incorrecta (é dicir,
se o primeiro elemento é maior que o segundo). Este proceso repítese varias veces ata que toda a lista está ordenada.

Cada “burbulla” (elemento grande) “sube” ata a súa posición correcta, movéndose cara ao final da lista en cada pasada.

Escribe unha función en Python burbulla(lista: List) -> List que implante o algoritmo de ordenación por burbulla para 
ordenar unha lista de números de menor a maior.
"""

__author__ = "Pablo Fernández Lamas"



def contar_frecuencia(lista):
    """
    Conta a frecuencia de cada unha das palabras nunha lista

    Args:
        lista (list): lista de palabras

    Returns:
        dict: diccionario onde as chaves son as palabras e o seu valor o número de ocurrencias

    """
    # Creamos un dicionario baleiro
    contador = {}

    # Recorremos a lista
    for palabra in lista:
        # COmprobamos se hai unha clave que sexa a palabra da lista 
        if palabra in contador:
            # Aumentamos en 1 o contador da palabra
            contador[palabra] = contador[palabra] + 1
        else:
            # Como non existe a clave coa palabra, creamola e asignamoslle o valor 1
            contador[palabra] = 1

    return contador

lista_palabras = ['mazá', 'banana', 'mazá', 'laranxa', 'banana', 'mazá']

print(contar_frecuencia(lista_palabras))