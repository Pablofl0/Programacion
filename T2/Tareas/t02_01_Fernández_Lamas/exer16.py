#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Escribe un script que pida ao usuario o seu nome e apelidos por separado e mostra a seguinte mensaxe por pantalla: O usuario <apelido1> <apelido 2>, <nome> rexistrouse correctamente
""" 

__author__ = "Pablo Fernández Lamas"  

#Pedindo nome e apelidos.
nome = (input("Introduza o seu nome:"))
apelido1 = (input("Introduza o primeiro apelido:"))
apelido2 = (input("Introduza o segundo apelido:"))

#Mostrando resultado.
print("O usuario ", apelido1, apelido2 + ",", nome,"resxistrouse correctamente.")