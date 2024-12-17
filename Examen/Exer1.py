#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Un radar de tramo consta de dous radares fixos separados por unha certa distancia. Se un vehículo percorre dita distancia nunha velocidade media permitida a maior,
este vehículo recibirá unha multa.

Escribe unha función que reciba 3 parámetros:

Distancia en metros entre dous radares fixos.
Velocidade máxima permitida en quilómetros/hora.
Número de segundos que tardou o vehículo en recorrer o tramo entre os dous radares.
A función debe devolver verdadeiro se o vehículo debe recibir unha multa, e falso se non é así.

Comproba o tipo de datos dos parámetros, así como que se os seus valores son válidos. En caso contrario lanza unha excepción ValueError.
"""

__author__ = "Pablo Fernández Lamas"

#Función de radar de multas.
def radar(distancia,tiempo,vmax):
    """Función que devuelve verdadero si el vehículo debe recibir una multa y, falso si no debe recibirla.

    Args:
        distancia (int/float): distancia en metros.
        tiempo (int/float): tiempo en segundos.
        vmax (int/float): velocidad máxima en km/hora.

    Raises:
        ValueError: si la distancia no es un número entero o decimal.
        ValueError: si el tiempo no es un número entero o decimal.
        ValueError: si la velocidad máxima no es un número entero o decimal.

    Returns:
        boolean: True o False.
    """
    if (type(distancia) is not float) and (type(distancia) is not int):
        raise ValueError
    if (type(tiempo) is not float) and (type(tiempo) is not int): #Pueden ser 2.5 segundos.
        raise ValueError
    if (type(vmax) is not float) and (type(vmax) is not int):
        raise ValueError
    distancia_km = (distancia/1000)
    tiempo_horas = (tiempo / 3600)
    vvehiculo = distancia_km / tiempo_horas
    if vvehiculo > vmax:
        return True
    return False

#Programa principal.
try:
    print(radar(100,5.0,60))
    print(radar(10,1,60.0))
except ValueError:
    print('Error.')
