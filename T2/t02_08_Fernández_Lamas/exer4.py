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

dicionario = {'a': 1, 'b': 2, 'c': 3}

for clave, valor in dicionario.items():
    print(clave, valor)