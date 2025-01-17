#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Realiza a implantación da función descifra_cesar(texto: str, desprazamento: int): str nun script que descifre unha cadea cifrada con cifrado César. 
Lanza tamén excepción ValueError se os argumentos da función son do tipo de datos inválidos.

O propio script debe utilizar dita función para descifrar un texto introducido polo usuario para mostrar o texto descifrado por pantalla. 
O usuario tamén indicará por teclado o desprazamento.
"""

__author__ = "Pablo Fernández Lamas"

#Definición valores válidos.
def validacion(texto,desplazamiento):
    """Función que valida los datos a utilizar.

    Args:
        texto (str): cadena de texto.
        desplazamiento (int): valor del desplazamiento.

    Raises:
        ValueError: si los valores introducidos no son válidos.
        ValueError: si los valores introducidos no son válidos.
        ValueError: si los valores introducidos no son válidos.
    """
    if type(texto) is not (str):
        raise ValueError
    elif type(desplazamiento) is not (int):
        raise ValueError
    elif desplazamiento < 0:
        raise ValueError
    else: 
        pass



#Definición descifrado Cesar.
def cifrado_Cesar(texto,desplazamiento):
    """Función que descifra texto mediante el método César.

    Args:
        texto (cadena): cadena de texto.
        desplazamiento (int): valor del desplazamiento.

    Returns:
        Cadena de texto: texto descifrado.
    """
    validacion(texto,desplazamiento)
    texto=texto.lower()
    cifrado=""
    for letra in texto:
        codigo = ord(letra)
        desplazamiento_int=int(desplazamiento)
        while desplazamiento_int>26:
                desplazamiento_int -= 26
        if codigo<=122 and codigo>=97:
            newcodigo = codigo - desplazamiento_int
            if newcodigo < 97:
                codigo_grandes=newcodigo+26
                cifrado += chr(codigo_grandes)
            cifrado += chr(newcodigo)
        else:
            cifrado += letra
    return cifrado

#Pidiendo datos y mostrando resultado.
try:
    texto = str(input("Introduce un texto: "))
    desplazamiento = int(input("Introduce el desplazamiento (mayor que 0) requerido: "))
    cifrado_final=cifrado_Cesar(texto,desplazamiento)
    print("El texto cifrado es " + str(cifrado_final) + ".")
except ValueError:
    print("Error. Entrada no válida.")

 