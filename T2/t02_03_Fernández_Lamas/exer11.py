#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Escribe un script que calcule o mínimo común múltiplo de dous números introducidos polo usuario.
"""

__author__ = "Pablo Fernández Lamas"

#Introducción de los números.
a=int(input("Introduzca un número entero:"))
b=int(input("Introduzca otro número entero:"))
flag = True

#Estableciendo el mayor de ambos.
if a>b:
    i=a
else:
    i=b

#Realizando cálculo.
while flag:
    num1=i%a
    num2=i%b
    if (num1!=0 or num2!=0):
        i=i+1 
    else:
        flag = False
        print("El mínimo común múltiplo de", a, "y", b, "es", i, ".")
    
   