#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Escribe un script que pida ao usuario 3 números e móstralle por pantalla a media dos 3 números.
""" 

__author__ = "Pablo Fernández Lamas"  

#Pedindo números.
num1 = float(input("Introduza o primeiro número:"))
num2 = float(input("Introduza o segundo número:"))
num3 = float(input("Introduza o terceiro número:"))

#Calculando a media.
media = (num1+num2+num3)/3

#Mostrando resultado.
print("A media dos tres números é", media,".")