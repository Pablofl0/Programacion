#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Escribe un script que calcule o salario dun traballador. O programa recibirá por parte do usuario as horas traballadas ao día e os € por cada hora de traballo. 
A continuación preguntaralle ao usuario se a tarifa é en bruto ou en neto. A partir da súa resposta calcula o salario mensual neto.

Os días laborables ao mes son 22.
Se o usuario indica que o custe da hora é en bruto, indícalle ao usuario que introduza o IRPF en tanto por cen para poder calcularlle o salario neto.
Deduce o número necesario de funcións e defíneas.
"""

__author__ = "Pablo Fernández Lamas"

#Definición salario neto y salario bruto.
def salario_bruto(horas,tarifa):
    """Función que calcula el salario bruto.

    Args:
        horas (float): horas trabajadas.
        tarifa (float): tarifa por hora.

    Returns:
        float: salario bruto.
    """
    sal_bruto=22*tarifa*horas
    return sal_bruto

def salario_neto(horas,tarifa,irpf):
    """Función que calcula el salario neto.

    Args:
        horas (float): horas trabajadas.
        tarifa (float): tarifa por hora.
        irpf (float): irpf (entre 0 y 100).

    Returns:
        float: salario neto.
    """
    irpf_final=irpf/100
    sal_neto=salario_bruto(horas,tarifa)-(irpf_final*salario_bruto(horas,tarifa))
    return sal_neto


# Pidiendo horas trabajadas y tarifa por hora.
horas = float(input("Introduzca las horas trabajadas al día:"))
tarifa = float(input("Introduzca la tarifa por hora trabajada:"))
while True:
    print("Elige una de las siguientes opciones:")
    print("\ta) Salario bruto.")
    print("\tb) Salario neto.")
    opción = input("> ")
    # Realizando cálculo.
    if opción == 'b':
        irpf= float(input("Introduzca el IRPF:"))
        print("El salario neto es", salario_neto(horas,tarifa,irpf), ".")
        break
    elif opción == "a":
        print("El salario bruto es", salario_bruto(horas,tarifa), ".")
        break

