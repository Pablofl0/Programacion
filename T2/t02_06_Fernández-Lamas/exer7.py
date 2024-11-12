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


#Definición validación longitud y números.
def validacion_lon_letra(DNI):
    """Fucnión que valida la longitud y, si el último dígito es una letra.

    Args:
        DNI (str): número del DNI.

    Raises:
        ValueError: si los valores introducidos no son válidos.
        ValueError: si los valores introducidos no son válidos.
    """
    if len(DNI) != 9:
        return False
    elif not(ord(DNI[8])<=90 or ord(DNI[8])>=65):
        return False
    else: 
        return True
        
#Definición validación letra.    
def validacion_num(DNI):
    """Función que valida si si son números los 8 primeros dígitos.

    Args:
        DNI (str): número del DNI.

    Raises:
        ValueError: si los valores introducidos no son válidos.
    """
    for numeroDNI in DNI[0:8]:
        codigo_dni=ord(numeroDNI)
        if not((codigo_dni)<=57 or (codigo_dni)>=48):
            return False
    return True

#Definición código de control. 
def control(DNI):
    """Función que comprueba si la letra del DNI coincide con el código de control.

    Args:
        DNI (str): número del DNI

    Raises:
        ValueError: si los valores introducidos no son válidos.
    """
    if validacion_lon_letra(DNI)==True and validacion_num(DNI)==True:
        resto=int(DNI[:8])%23
        letras_control='TRWAGMYFPDXBNJZSQVHLCKE'
        if letras_control[resto] != DNI[8]:
            return False
        else:
            return True
    else:
        return False
    
#Se pueden hacer las validaciones todas juntas o no, pero al llamarlas es mejor crear una función que las llame a todas.
def comprobar_DNI(DNI):
    if not validacion_lon_letra(DNI):
        return False
    elif not validacion_num(DNI):
        return False
    #elif not control(DNI):
    #    return False
    else: 
        return True
        

#Petición de DNI y muestra de resultado.
while True:
    DNI=input("Introduce el DNI: ")
    if comprobar_DNI(DNI):
        print("Válido")
        break
    elif not comprobar_DNI(DNI):
        print("Inválido")
        print(validacion_num(DNI))