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

def formato(numero_aleatorio):
    """Función que pasa los números a 4 dígitos.

    Args:
        numero_aleatorio (int): número entero entre 1 y 9999.

    Returns:
        int: número entero entre 1 y 9999 con 4 dígitos.
    """
    numero_aleatorio_str=str(numero_aleatorio)
    while len(numero_aleatorio_str)<4:
        numero_aleatorio_str="0" + numero_aleatorio_str
    return numero_aleatorio_str



#Pidiendo datos y mostrando resultado.
n_ganadores=int(input("Introduzca el número de ganadores: "))
lista_premiados=premiados(n_ganadores)
for n in lista_premiados:
    print("El número premiado es: " + formato(n) + ".")