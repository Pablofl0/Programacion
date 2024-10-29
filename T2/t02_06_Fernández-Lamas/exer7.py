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

__author__ = "Pablo Fernández Lamas"

def validacion1(DNI):
        if len(DNI) != 9:
            raise ValueError
        elif not(ord(DNI[8])<=90 or ord(DNI[8])>=65):
            raise ValueError
        
        
def validacion2(DNI):
    for numeroDNI in DNI[:8]:
        if not(ord(numeroDNI)<=57 or ord(numeroDNI)>=48):
            raise ValueError
    else:
        pass

def control(DNI):
    resto=int(DNI[:8])%23
    letras_control='TRWAGMYFPDXBNJZSQVHLCKE'
    if letras_control[resto] != DNI[8]:
        raise ValueError
    else:
        pass



try:
    DNI=input("Introduce el DNI: ")
    validacion1(DNI)
    validacion2(DNI)
    control(DNI)
    print("Válido")
except ValueError:
    print("Inválido")