#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Escribe un script que pida o nome de usuario e contrasinal ao usuario. 
Indica se o inicio de sesión é correcto. O nome de usuario sería “python” e o contrasinal “pip”.


"""

__author__ = "Pablo Fernández Lamas"

#Estableciendo credenciales.
usuario="python"
contraseña="pip"

# Pidiendo credenciales.
usuario_pedir = str(input("Introduzca el usuario:"))
contraseña_pedir = str(input("Introduzca la contraseña:"))


# Comprobando credenciales.
if usuario_pedir == usuario and contraseña_pedir == contraseña:
    print("Credenciales correctas. Inicio de sesión realizado correctamente.")
else:
    print("Inicio de sesión fallido.") 
