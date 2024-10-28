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
def validacion():
    if type(texto)!= (str):
        raise ValueError
    elif type(texto)!=():
        raise ValueError
    
prueba



#Definición cifrado Cesar.
def cifrado_Cesar(texto):
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
        if codigo<=122 and codigo>=97:
            newcodigo = codigo + 5
            if newcodigo > 122:
                codigo = newcodigo - 26
                cifrado += chr(codigo)
            else:
                cifrado += chr(newcodigo)
        else:
            cifrado += letra
    return cifrado



texto = input("Introduce un texto: ")
cifrado_final=cifrado_Cesar(texto)
print(cifrado_final)

 