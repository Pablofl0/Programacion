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
def validacion1(DNI):
    """Fucnión que valida la longitud y, si son números los 8 primeros dígitos.

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
def validacion2(DNI):
    """Función que valida si el último dígito del DNI es una letra mayúscula.

    Args:
        DNI (str): número del DNI.

    Raises:
        ValueError: si los valores introducidos no son válidos.
    """
    for numeroDNI in DNI[:8]:
        if not(ord(numeroDNI)<=57 or ord(numeroDNI)>=48):
            return False
        else:
            return True

#Definición código de control. 
def control(DNI):
    """Función que comprueba si la letra del DNI coincide con el código de control.

    Args:
        DNI (str): número del DNI

    Raises:
        ValueError: si los valores introducidos no son válidos.
    """
    resto=int(DNI[:8])%23
    letras_control='TRWAGMYFPDXBNJZSQVHLCKE'
    if letras_control[resto] != DNI[8]:
        return False
    else:
        return True
    
#Se pueden hacer las validaciones todas juntas o no, pero al llamarlas es mejor crear una función que las llame a todas.
def comprobar_DNI():
    if validacion1(DNI)==False:
        raise ValueError
    elif validacion2(DNI)==False:
        raise ValueError
    elif control(DNI)==False:
        raise ValueError
    else: 
        pass
        

#Petición de DNI y muestra de resultado.
try:
    DNI=input("Introduce el DNI: ")
    comprobar_DNI()
    print("Válido")
except ValueError:
    print("Inválido")