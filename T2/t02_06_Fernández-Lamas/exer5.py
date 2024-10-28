#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
O cifrado César é un tipo de cifrado de substitución no que unha letra do texto orixinal é substituída por outra letra que é un número fixo de posicións posteriores no alfabeto.
Por exemplo se o desprazamento é 5, a ‘a’ cifrarase coa ‘f’. Débense ignorar os espazos en branco.
Se nun desprazamento rematan as letras, volverase a comezar polo comezo do alfabeto.
Supoñer que todos os nomes están en minúsculas e están compostos só polas seguintes letras: a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z.
Realiza a implantación deste algoritmo na función cifra_cesar(texto: str, desprazamento: int): str. 
Recorda que os caracteres diferentes as letras se deben manter. Comproba se o tipo de datos introducidos son válidos, e senón é así lanza unha excepción ValueError.
O propio script debe utilizar ditas función para cifrar un texto introducido polo usuario para mostrar o texto cifrado por pantalla. 
O usuario tamén indicará por teclado o desprazamento. Ademais recorda capturar a excepción.
"""

__author__ = "Manuel Ramón Varela López"

#Definición valores válidos.
def validacion(texto,desplazamiento):
    #if type(texto)!= (str):
     #   raise ValueError
    #el
    if type(desplazamiento)!=(float):
        raise ValueError
    elif desplazamiento < 0:
        raise ValueError
    return None



#Definición cifrado Cesar.
def cifrado_Cesar(texto,desplazamiento):
    """Función que cifra texto mediante el método César.

    Args:
        texto (cadena): cadena de texto.

    Returns:
        Cadena de texto: texto cifrado.
    """
    texto=texto.lower()
    cifrado=""
    for letra in texto:
        codigo = ord(letra)
        desplazamiento_float=float(desplazamiento)
        if codigo<=122 and codigo>=97:
            newcodigo = codigo + desplazamiento_float
            newcodigo_int=int(newcodigo)
            if newcodigo_int > 122:
                codigo_grandes=newcodigo_int-122
                resto=(codigo_grandes%26)
                cifrado += chr(resto)
            else:
                cifrado += chr(newcodigo_int)
        else:
            cifrado += letra
    return cifrado


try:
    texto = input("Introduce un texto: ")
    desplazamiento = input("Introduce el desplazamiento (mayor que 0) requerido: ")
    #validacion(texto,desplazamiento)
    cifrado_final=cifrado_Cesar(texto,desplazamiento)
    print("El texto cifrado es " + str(cifrado_final) + ".")
except ValueError:
    print("Error. Entrada no válida.")

 