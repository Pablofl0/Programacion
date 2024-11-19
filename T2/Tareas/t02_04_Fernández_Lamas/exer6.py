#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Escribe un script que pida o nome de usuario e contrasinal ao usuario. 
Indica se o inicio de sesión é correcto. O nome de usuario correcto sería “python” e o contrasinal “pip”. 
Crea a función login(usuario: str, contrasinal: str) -> boolean para realizar esta operación.
"""

__author__ = "Pablo Fernández Lamas"



#Definición usuario y contraseña.
def login_uc(usuario_pedir,contraseña_pedir):
    """Función que comprueba si el usuario y la contraseña pedidos coinciden con las credenciales establecidas.

    Args:
        usuario_pedir (str): usuario.
        contraseña_pedir (str): contraseña.

    Returns:
        str: verdadero o falso.
    """
    usu= (usuario_pedir == usuario)
    con = (contraseña_pedir == contraseña)
    if usu and con:
        return True
    else:
        return False

#Estableciendo credenciales.
usuario="python"
contraseña="pip"


# Pidiendo credenciales.
usuario_pedir = str(input("Introduzca el usuario:"))
contraseña_pedir = str(input("Introduzca la contraseña:"))

# Comprobando credenciales.
if login_uc(usuario_pedir,contraseña_pedir):
    print("Credenciales correctas. Inicio de sesión realizado correctamente.")
else:
    print("Inicio de sesión fallido.") 