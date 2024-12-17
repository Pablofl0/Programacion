#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
A rima consonante é a que se produce entre dúas palabras cando as súas últimas letras coinciden a partir da vogal acentuada.

Escribe unha función que reciba dúas palabras e comprobe que existe rima consonante entre as dúas palabras. 
Supoñamos que a vogal acentuada nas dúas palabras é a última vogal.

A función devolverá verdadeiro se as palabras teñen un mínimo 5 letras e existe rima consonante entre elas, e falso en caso contrario.

Comproba o tipo de datos dos parámetros, así como que se os seus valores son válidos. En caso contrario lanza unha excepción ValueError. 
Recorda que unha palabra tan só pode estas formada por letras e non pode conter espazos.
"""

__author__ = "Pablo Fernández Lamas"

#Función que comprueba si dos palabras tienen rima consonante.
def rima(palabra1,palabra2):
    """Función que recibe dos palabras y comprueba que exista rima consonante entre ambas palabras.

    Args:
        palabra1 (str): primera palabra.
        palabra2 (str): segunda palabra.

    Raises:
        ValueError: contiene espacios o símbolos no permitidos.
        ValueError: contiene espacios o símbolos no permitidos.

    Returns:
        boolean: True o False.
    """
    palabra1_lower = palabra1.lower()
    palabra2_lower = palabra2.lower()
    vogales = 'aeiou'
    for i in palabra1_lower:
        if ord(i)<97 or ord(i)>122:
            raise ValueError
    for i in palabra2_lower:
        if ord(i)<97 or ord(i)>122:
            raise ValueError
    if (len(palabra1_lower) < 5) or (len(palabra2_lower) < 5):
        return False
    for i in palabra1_lower[::-1]:
        if i in vogales:
            indice1 = palabra1_lower[::-1].index(i)
            break
    parte_rima1 = palabra1_lower[-(indice1 + 1):]
    for i in palabra2_lower[::-1]:
        if i in vogales:
            indice2 = palabra2_lower[::-1].index(i)
            break
    parte_rima2 = palabra2_lower[-(indice2 + 1):]
    if parte_rima1 == parte_rima2:
        return True
    return False

#Programa principal.
try:
    print(rima('PerrO','HipoPotAmo'))
except ValueError:
    print("Error.")