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


def ordenar(lista):
    i=1
    while True:
        lista_ordenada=lista.sort()
        if lista_ordenada == lista:
            break
        else:
            if lista[i] == lista[i+1]:
                i+=1
            elif lista[i] < lista[i+1]:
                i+=1
            elif lista[i] > lista[i+1]:
                i+=1
                lista[i]=lista[i+1]
                lista[i+1]=lista[i]



#Inicializando variable.
lista=[]


while True:
    número_pedir=int(input("Introduzca un número: "))
    lista.append(número_pedir)