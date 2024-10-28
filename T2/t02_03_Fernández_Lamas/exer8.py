#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Escribe un script que reciba un enteiro (n) maior ou igual a 1 e ofreza o resultado da seguinte suma: 1 + 1/2 + 1/3 + … 1/n
"""

__author__ = "Pablo Fernández Lamas"

# Pidiendo 'n' y realizando suma.
n=float(input("Introduzca un número entero mayor o igual a 1:"))
suma=0
i=1
if n >= 1:
    while i <= n:
        suma=suma+(1/i)
        i=i+1
print("El resultado de la suma es", suma, ".")
