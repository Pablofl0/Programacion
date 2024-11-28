#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""Crea nun script unha función recursiva: anagrama(palabra1: str, palabra2: str) -> boolean que indique se unha das palabras é ou non un anagrama da outra, é dicir,
que se pode obter a partir das letras da outra sen máis que reordenalas.

Considerarase que as palabras están escritas en minúsculas, sen til nin outros signos diacríticos e sen espazos en branco ou outros caracteres distintos dos alfabéticos 
da “A” á “Z”.

Se as dúas palabras son iguais tamén se considera que son anagrama.

Nese mesmo script proba a función obtendo unha palabra por teclado e mostra por pantalla Anagrama se é un anagrama e Non anagrama en caso contrario.
"""

__author__ = "Pablo Fernández Lamas"

#Def función anagrama.
def anagrama(palabra1,palabra2):
    """Función que valida si dos palabras son un anagrama.

    Args:
        palabra1 (str): palabra número 1.
        palabra2 (str): palabra número 2.

    Returns:
        boolean: True o False.
    """
    if not(len(palabra1) == len(palabra2)):
        return False
    elif len(palabra2) == 0:
        return True
    elif not(palabra1[0] in palabra2):
        return False
    else:
        palabra2 = palabra2.replace(palabra1[0], "", 1)
        palabra1=palabra1[1:]
        return anagrama(palabra1,palabra2)


#Pidiendo datos y mostrando resultado.
palabra1 = str(input("Introduzca una palabra: "))
palabra2 = str(input("Introduzca una palabra: "))
if anagrama(palabra1,palabra2):
    print("Anagrama")
else:
    print("No anagrama")




