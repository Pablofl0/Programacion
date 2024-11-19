#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Escribe un script que pide ao usuario por teclado os coeficientes dunha ecuación de segundo grao e calcula a solución.
Comproba se hai unha solución, dúas ou ningunha. Dependendo do caso, mostra as solucións que corresponda.
"""

__author__ = "Pablo Fernández Lamas"

# Pidiendo coeficientes de la ecuación de segundo grado.
a = float(input("Indica el coeficiente a:"))
b = float(input("Indica el coeficiente b:"))
c = float(input("Indica el coeficiente c:"))

#Obteniendo valor del discriminante.
disc  = (b**2-(4*a*c))

#Deduciendo soluciones según el valor del discriminante.
if (disc < 0):
    print("Esta ecuación no tiene solución.")
elif (disc == 0):
    sol=(-b)/(2*a)
    sol_str=str(sol)
    print("La solución es única y es ", sol, ".")
else:
    x1 = (-b+(disc**(1/2)))/(2*a)
    x2 = (-b-(disc**(1/2)))/(2*a)
    x1_str=str(x1)
    x2_str=str(x2)
    print("Existen dos soluciones que son ", x1, "y", x2, ".")