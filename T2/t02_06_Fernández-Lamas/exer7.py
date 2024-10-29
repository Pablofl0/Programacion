#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Un número de DNI ten o seguinte formato 00000000A.
Escribe un script que lle pida ao usuario o seu DNI e comprobe que sexa correcto. Para iso sigue os seguintes pasos:
Comproba a lonxitude da cadea.
Comproba que os 8 primeiros díxitos son números e o último é unha letra maiúscula. PISTA: utiliza a táboa do código ASCII.
Comproba que a letra introducida é o código de control do DNI. 
https://www.interior.gob.es/opencms/es/servicios-al-ciudadano/tramites-y-gestiones/dni/calculo-del-digito-de-control-del-nif-nie/#:~:text=Por%20ejemplo%2C%20si%20el%20n%C3%BAmero,n%C3%BAmeros%20y%20d%C3%ADgito%20de%20control.
Por último imprime Válido ou Inválido segundo corresponda.
"""

__author__ = "Manuel Ramón Varela López"

def validacion(DNI):
    if len(DNI) is not 9:
        raise ValueError
    elif for numeroDNI in DNI[:8]
    type(DNI[:8]) is not int:
        raise ValueError
    elif not(ord(DNI[8])<=90 or ord(DNI[8])>=65):
        raise ValueError

def control(DNI):
    suma=0
    for numero in DNI[:8]:
        suma += numero
    while suma > 23:
        suma -= 23
    letras_control='TRWAGMYFPDXBNJZSQVHLCKE'
    if letras_control[suma] is not DNI[8]:
        raise ValueError



try:
    DNI=input("Introduce el DNI: ")
    control(DNI)
    validacion(DNI)
    print("Válido")
except ValueError:
    print("Inválido")