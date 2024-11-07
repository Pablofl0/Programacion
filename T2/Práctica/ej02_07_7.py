#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Escribe unha función en Python `buscar(lista: List, obxectivo)` que implante o algoritmo de busca binaria que devolva o índice do obxectivo ou `-1` en caso de non se atopar o valor obxectivo.
"""

__author__ = "Manuel Ramón Varela López"


def buscar(lista, obxectivo):
    inicio = 0
    fin = len(lista) - 1
    
    # Metres que o inicio sexa menor a fin, seguimos buscando
    while inicio <= fin:
        medio = (inicio + fin) // 2  # Calculamos o índice do medio
        
        if lista[medio] == obxectivo:  # Se atopamos o obxectivo
            return medio
        elif lista[medio] < obxectivo:  # Se o obxectivo é máis grande que o valor do medio, modificamos o valor de inicio
            inicio = medio + 1
        else:  # Se o obxectivo é máis pequeno que o valor medio, modificamos o valor do final
            fin = medio - 1
    
    return None  # Se o obxectivo non está na lista

