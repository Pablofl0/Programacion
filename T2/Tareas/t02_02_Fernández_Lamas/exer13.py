#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Escribe un script que calcule o salario dun traballador. 
O programa recibirá as horas traballadas ao día e os € por hora dese traballo por parte do usuario. 
A continuación preguntaralle ao usuario se a tarifa é en bruto ou en neto. A partir da súa resposta calcula o salario mensual neto.

Os días laborables ao mes son 22.
Se o usuario indica que o custe da hora é en bruto, indícalle ao usuario que introduza o IRPF para poder calcularlle o salario neto.
"""

__author__ = "Pablo Fernández Lamas"

# Pidiendo horas trabajadas y tarifa por hora.
horas = float(input("Introduzca las horas trabajadas al día:"))
tarifa = float(input("Introduzca la tarifa por hora trabajada:"))
print("Elige una de las siguientes opciones:")
print("\ta) Salario bruto.")
print("\tb) Salario neto.")
opción = input("> ")

sal_bruto=22*tarifa*horas


# Comprobando credenciales.
if opción == 'a':
    irpf= float(input("Introduzca el IRPF:"))
    irpf_final=irpf/100
    salario_neto=sal_bruto - (sal_bruto*irpf_final)
    print("El salario neto es", salario_neto, ".")
else:
    salario_neto=sal_bruto
    print("El salario neto es", salario_neto, ".")