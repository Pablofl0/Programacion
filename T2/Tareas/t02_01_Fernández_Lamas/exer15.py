#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Escribe un script que pida ao usuario os coeficientes dunha ecuación de segundo grao e calcula as dúas solucións. Mostra as dúas solucións por pantalla.
""" 

__author__ = "Pablo Fernández Lamas"  

#Pedindo os coeficientes.
a = float(input("Introduza o coeficiente a:"))
b = float(input("Introduza o coeficiente b:"))
c = float(input("Introduza o coeficiente c:"))

#Calculando solucións.
x1 = (-b+((b**2-(4*a*c))**(1/2)))/(2*a)
x2 = (-b-((b**2-(4*a*c))**(1/2)))/(2*a)

#Mostrando resultado.
print("As solucións para a ecuación de segundo grao son", x1, "e", x2)