#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Escribe un script que faga o cambio de divisas tanto de euros a libras e viceversa. 
Crea un menú para que o usuario escolla o cambio que desexa realizar. Realiza unha función para cada un dos cambios:

libras_to_euros(euros: float) -> float
euros_to_libras(libras: float) -> float
Un € é igual a 1,10 libras
"""

__author__ = "Pablo Fernández Lamas"


#Definición libras a euros.
def libras_to_euros(libras):
    """Función que pasa de libras a euros.

    Args:
        libras (float): número de libras.

    Returns:
        float: número de euros.
    """
    lib_to=libras/1,10
    return lib_to

#Definición euros a libras.
def euros_to_libras(euros):
    """Función que pasa de euros a libras.

    Args:
        euros (float): número de euros.

    Returns:
        float: número de libras.
    """
    euros_to=euros*1,10
    return euros_to

# Escogiendo el cambio que el usuario desea realizar.
print("Elige una de las siguientes opciones:")
print("\ta) De divisas a euros.")
print("\tb) De euros a divisas.")
opción = input("> ")

#Obteniendo cantidad de euros o divisas a cambiar.
if opción == 'a':
    print("Se eligió la opción a.")
    libras = float(input("Introduzca la cantidad de libras:"))
    print(str(libras) + " libras son " + str(libras_to_euros(libras)) + " euros.")
elif opción == 'b':
    print("Se eligió la opción b.")
    euros = float(input("Introduzca la cantidad de euros:"))
    print(str(euros) + " euros son " + str(euros_to_libras(euros)) + " libras.")
else:
    print("Salimos del programa...")

