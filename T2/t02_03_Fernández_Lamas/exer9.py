#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Escribe un script que permita obter o factorial dun número enteiro positivo introducido por teclado.
"""

__author__ = "Pablo Fernández Lamas"

# Pidiendo número entero y calculando factorial.
n=float(input("Introduzca un número entero mayor o igual a 1:"))
producto=1
i=n
while i >0:
    producto=producto*i
    i=i-1
print("El resultado del factorial es", producto, ".")