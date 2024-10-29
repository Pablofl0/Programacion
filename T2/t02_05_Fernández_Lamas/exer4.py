#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Escribe unha función raiz_cadrada(numero: float/int) -> float nun script que calcule a raíz cadrada dun número. 
Se o parámetro non é un número ou é negativo, lanza unha excepción chamada ValueError. 
O propio script debe recibir un número por parte do usuario e calcula a raíz cadrada dese número utilizando a función creada anteriormente. 
Captura a excepción que lanza a función.


"""

__author__ = "Pablo Fernández Lamas"

#Definición raíz cuadrada.
def raíz_cuadrada(número):
    """
    Calcula la raíz cuadrada de un número.

    Args:
        numero (float/int): el número del que se realiza la raíz cuadrada.

    Returns:
        float: el valor de la raíz cuadrada.

    Raises:
        ValueError: Si el valor introducido no es positivo o no es un número.
    """
    if not(type(número) is (float) or type(número) is int):
        raise ValueError
    elif número < 0:
        raise ValueError
    else:
        return número ** (1/2)

#Petición número y muestra de resultado.
try:
    número=float(input("Introduce un número positivo:"))
    print("La raíz es " + str(raíz_cuadrada(número)) +".")
except ValueError:
    print("Error: entrada no válida.") 

