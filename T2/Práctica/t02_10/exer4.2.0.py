#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Os números 17, 341 y 62 teñen en común que a suma dos seus díxitos dan o mesmo valor, 8. Hai moitos outros números así; de todos eles, o 17 é o máis pequeno.

Implanta un programa que recibirá por teclado un número entre 1 e 1000 e a continuación se mostre o número decimal máis pequeno que as súas cifras sumen a mesma 
cantidade que a suma das cifras do número introducido por teclado.

Por exemplo, se o usuario introduce o número 92, deberase imprimir o número 29.
"""

__author__ = "Pablo Fernández Lamas"


#Def validación número entrante.
def validacion_entrante(n_entrante):
    """Función que valida el número entrante.

    Args:
        n_entrante (int): número entrante.
    Returns:
        boolean: True o False.
    """
    if type(n_entrante) is not int:
        return False
    elif not(n_entrante>=0 and n_entrante<=1000):
        return False
    return True

#Def sustraendo.
def sustraendo(suma_e):
    if suma_e <= 9:
        sustraendo_final = suma_e
    else: 
        sustraendo_final = 9
    return sustraendo_final


#Def programa que encuentra la solución.
def programa(n_entrante):
    """Función que calcula la solución.

    Args:
        n_entrante (int): número entrante.

    Raises:
        ValueError: si el valor es incorrecto.

    Returns:
        int: solución.
    """
    if not(validacion_entrante(n_entrante)):
        raise ValueError
    n_entrante_str = str(n_entrante)
    suma_e = 0
    for c in n_entrante_str:
        suma_e = suma_e + int(c)
    numero_calc = ''
    while suma_e > 0:
        sust = sustraendo(suma_e)
        suma_e -= sust
        numero_calc += str(sust)
    numero_final = numero_calc[::-1]
    return numero_final



#Pidiendo número y mostrando solución.
try:
    n_entrante = int(input("Introduzca un número ente 1 y 1000: "))
    sol = programa(n_entrante)
    print(f"La solución es {sol}.")
except ValueError:
    print("Entrada no válida.")