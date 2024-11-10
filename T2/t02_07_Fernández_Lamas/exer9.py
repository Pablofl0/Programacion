#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Vaise realizar un sorteo no que pode haber un número diferente de gañadores a partir dunhas rifas numeradas entre 0001 e 9999. 
Escribe un script que reciba por teclado o número de premios dispoñibles e imprima os números premiados co formato de 4 díxitos.
"""

__author__ = "Pablo Fernández Lamas"

#Importando biblioteca.
import random

#Def números premiados.
def premiados(n_ganadores):
    """Función que calcula los números premiados.

    Args:
        n_ganadores (int): número de ganadores.

    Returns:
        list: lista de números premiados.
    """
    lista=[]
    i=0
    while i < n_ganadores:
        numero_aleatorio = random.randint(1, 9999)
        if numero_aleatorio not in lista:
            i+=1
            lista.append(numero_aleatorio)
        else:
            continue
    return lista


#Pidiendo datos y mostrando resultado.
n_ganadores=int(input("Introduzca el número de ganadores: "))
lista_premiados=premiados(n_ganadores)
print(lista_premiados)