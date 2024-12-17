#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Deséxase saber os días que faltan para que remate o ano. Polo tanto, escribe unha función que que reciba como parámetros:

O mes en número (1, 2, 3,... ata 12)
O día do mes en número (Dependendo do mes poden ser 28, 30 ou 31 días). Consideramos que o ano non é bisesto.
A función debe devolver os días que faltan para rematar o ano.

Comproba o tipo de datos dos parámetros, así como que se os seus valores son válidos. En caso contrario lanza unha excepción ValueError.

Aquí tes unha táboa cos días de cada mes.
"""

__author__ = "Pablo Fernández Lamas"

#Función que calcula los días faltantes en el año.
#El día introducido ya ha pasado, se empieza a contar desde el siguiente.
def calculo(mes,dia):
    """Función que devuelve los días que faltan para acabar el año.

    Args:
        mes (int): mes del año.
        dia (int): día del mes.

    Raises:
        ValueError: si mes no es entero.
        ValueError: si dia no es entero.
        ValueError: si es un mes no válido.
        ValueError: si es un día no válido en un mes con 31 días.
        ValueError: si es un día no válido en un mes con 30 días.
        ValueError: si es un día no válido en un mes con 28 días.

    Returns:
        int: días que faltan para acabar el año.
    """
    if type(mes) is not int:
        raise ValueError
    if type(dia) is not int:
        raise ValueError
    if mes<1 or mes>12:
        raise ValueError
    if mes in [1,3,5,7,8,10,12] and (dia<1 or dia>31):
        raise ValueError
    if mes in [4,6,9,11] and (dia<1 or dia>30):
        raise ValueError
    if mes == 2 and ((dia<1 or dia>28)):
        raise ValueError
    dias_por_mes = [31,28,31,30,31,30,31,31,30,31,30,31]
    dias_totales = 0
    ano = 365
    for i in dias_por_mes[0:(mes-1)]:
        dias_totales += i
    dias_totales += dia
    dias_faltantes = ano - dias_totales
    return dias_faltantes

#Programa principal.
try:
    print(calculo(9,15))
except ValueError:
    print("Error.")