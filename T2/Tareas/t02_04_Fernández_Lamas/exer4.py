#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Escribe un script que pide ao usuario os coeficientes dunha  de segundo grao e calcula a solución. 
Comproba se hai unha solución, dúas ou ningunha. Dependendo do caso, mostra as solucións que corresponda. Crea as seguintes funcións:

Unha función que calcule o : descriminante(a: float, b: float, c: float) -> float

Unha función que calcule o número de solucións: numero_solucions(a: float, b: float, c: float) -> int. Debe utilizar internamente descriminante().

Unha para calcular a solución cando esta é única: solucion_unica(a: float, b: float) -> float

Unha para calcular as dúas solucións: culcula_duas_solucions (a: float, b: float, c: float) -> (float, float). Esta debe devolver las dos soluciones. 
Debe utilizar internamente descriminante().
"""

__author__ = "Pablo Fernández Lamas"

#Definición discrminante.
def discriminante(a,b,c):
    """Función que calcula discriminante.

    Args:
        a (float): valor .
        b (float): valor .
        c (float): valor .

    Returns:
        float: valor discriminante.
    """
    disc=(b**2)-(4*a*c)
    return disc

#Definición número de soluciones.
def num_soluciones(a,b,c):
    """Función que calcula número de soluciones de una ecuación de segundo grado.

    Args:
        a (float): valor coeficiente a.
        b (float): valor coeficiente b.
        c (float): valor coeficiente c.

    Returns:
        int: número de soluciones de la ecuación.
    """
    if discriminante(a,b,c) == 0:
        return 1
    elif discriminante(a,b,c) < 0:
        return 0
    elif discriminante(a,b,c) > 0: 
        return 2
    
#Definición  solución única.
def sol_unica(a,b):
    """Función que calcula la solución si es única.

    Args:
        a (float): valor coeficiente a.
        b (float): valor coeficiente b.

    Returns:
        float: solución ecuación.
    """
    sol1=-b/(2*a)
    return sol1

#Definición  solución doble.
def sol_doble(a,b,c):
    """Función que calcula la solución si es doble.

    Args:
        a (float): valor coeficiente a.
        b (float): valor coeficiente b.
        c (float): valor coeficiente c.

    Returns:
        float: soluciones ecuación.
    """
    sol_pos=((-b)+(discriminante(a,b,c))*(1/2))/(2*a)
    sol_neg=((-b)-(discriminante(a,b,c))*(1/2))/(2*a)
    return sol_pos, sol_neg


# Pidiendo coeficientes de la  de segundo grado.
a = float(input("Indica el coeficiente a:"))
b = float(input("Indica el coeficiente b:"))
c = float(input("Indica el coeficiente c:"))
res_pos,res_neg=sol_doble(a,b,c)



if num_soluciones(a,b,c)==2:
    print("Existen 2 soluciones para esta , las cuales son " + str(res_pos) + " y " + str(res_neg) + ".")
elif num_soluciones(a,b,c)==1:
    print("Existe una única solución, la cual es " + str(sol_unica(a,b)) + ".")
elif num_soluciones(a,b,c)==0:
    print("No existen soluciones reales para esta .")
