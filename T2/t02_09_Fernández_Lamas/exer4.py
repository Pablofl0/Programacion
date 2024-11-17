#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""Desenvolva un script para determinar se unha cadea de caracteres (palabra/frase) é palíndromo, é dicir,
se se pode ler igual de esquerda a dereita que de dereita a esquerda. Un exemplo de palíndromo é a palabra “radar”.

Desenvolva a seguinte función recursiva:

Función palindromo: cos parámetros de entrada que considere preciso para resolver de forma recursiva se unha palabra/frase 
é palíndromo. O valor de retorno será True ou False en función do caso. (Exemplo:“radar” é palíndromo, polo tanto,
a función devolverá True).
Nese mesmo script proba a función obtendo unha palabra ou frase por teclado e mostra por pantalla Palídromo se é un palñindromo 
e Non palíndromo en caso contrario.

"""

__author__ = "Pablo Fernández Lamas"


def palindromo(palabra):
    """Función que comprueba si la palabra es políndroma o no.

    Args:
        palabra (str): palabra a estudiar.

    Returns:
        boolean: True o False.
    """
    if len(palabra) == 1:
        return True
    else:
        primero = palabra[0]
        ultimo = palabra[-1]
        resto_palabra = palabra[1:-1]
        if primero == ultimo:  
            return palindromo(resto_palabra)
        else: 
            return False
        
palabra_mayus = str(input("Introduzca una palabra: "))
palabra = palabra_mayus.lower()
if palindromo(palabra):
    print("Palíndromo")
else:
    print("No palíndromo")