#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Escribe un script que faga o cambio de divisas tanto de euros a libras e viceversa. 
Crea un menú para que o usuario escolla o cambio que desexa realizar e a continuación 
introducirá o valor da moeda correspondente para realizar o cambio de divisas. 1 € son 1,10 libras.


"""

__author__ = "Pablo Fernández Lamas"

# Escogiendo el cambio que el usuario desea realizar.
print("Elige una de las siguientes opciones:")
print("\ta) De divisas a euros.")
print("\tb) De euros a divisas.")
opción = input("> ")


#Obteniendo cantidad de euros o divisas a cambiar.
if opción == 'a':
    print("Se eligió la opción a.")
    libras = float(input("Introduzca la cantidad de libras:"))
    libras_euros=libras/1.10
    print(libras, "libras son", libras_euros, "euros.")
elif opción == 'b':
    print("Se eligió la opción b.")
    euros = float(input("Introduzca la cantidad de euros:"))
    euros_libras=euros*1.10
    print(euros, "euros son", euros_libras, "libras.")
else:
    print("Salimos del programa...")