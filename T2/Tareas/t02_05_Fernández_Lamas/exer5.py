#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Escribe unha función calcular_desconto_irpf(soldo_bruto: float/int, irpf: int) -> float nun script o soldo bruto e o IRPF en tanto por cen. 
Comproba que estes dous valores son números, que o soldo é maior que 0 e que o IRPF é un valor válido. 
Se algunha destas condicións non se cumpre, lanza a excepción ValueError. 
O propio script deberá recibir estes datos por teclado, e utilizar a función creada para calcular o desconto do IRPF. Captura a excepción que lanza a función.


"""

__author__ = "Pablo Fernández Lamas"


#Definición función que calula descuento IRPF.
def sueldo_IRPF(sueldob,por_IRPF):
    """
    Calcula el descuento del IRPF.

    Args:
        sueldob (float): suelo bruto.
        por_IRPF (float): porcentaje (entre 0 y 100) del IRPF.

    Returns:
        float: el valor del descuento del IRPF.

    Raises:
        ValueError: si el valor introducido del sueldo bruto no es positivo o no es un número y, si el valor del IRPF no está entre 0 y 100 o no es un número.
    """
    if not((type(sueldob) is (float)) or (type(sueldob) is (int))):
        raise ValueError
    elif type(por_IRPF) is not int:
          raise ValueError
    elif sueldob < 0:
        raise ValueError
    elif (0>por_IRPF) or (por_IRPF>100):
        raise ValueError
    else:
        IRPF_final=(por_IRPF/100)*sueldob
        return IRPF_final

#Petición sueldo bruto y porcentaje del IRPF y, muestra de resultado.
try:
    sueldob=float(input("Introduce el sueldo bruto:"))
    por_IRPF=int(input("Introduce el porcentaje de IRPF:"))
    desc_IRPF=sueldo_IRPF(sueldob,por_IRPF)
    print("El descuento del IRPF es " + str(desc_IRPF) +".")
except ValueError:
    print("Error: entrada no válida.") 

    
    

