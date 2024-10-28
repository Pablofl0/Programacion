#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Escribe un *script* que pida ao usuario dous números enteiros e sumalos.
Mostra o resultado por pantalla.
""" 

__author__ = "Manuel Ramón Varela López"

# Pedimos datos ao usuario
numero1_str = input("Introduce un número enteiro: ")
numero2_str = input("Introduce outro número enteiro: ")

# Conversión de strings a enteiros
numero1 = int(numero1_str)
numero2 = int(numero2_str)

# Realizamos a suma
suma = numero1 + numero2
print(suma)