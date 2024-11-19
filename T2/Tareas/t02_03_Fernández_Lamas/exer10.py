#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Escribe un script no que o usuario poida introducir números enteiros por teclado ata que teclee a palabra “fin”. 
Tras finalizar a introdución de números, indícalle cal é o número máis pequeno introducido.
"""

__author__ = "Pablo Fernández Lamas"

#Creamos una bandera para saber cuando salir del bucle.
peque = None
flag = True
while(flag):
	palabra = input("Introduce un número entero:")
	# Si el usuario introduce fin, ponemos la bandera como falsa para salir del bucle.
	if palabra == 'fin':
		flag = False

	#Sino, seguimos procesando el dato que introdució el usuario.
	else:
		número = int(palabra)
		if peque==None:
			peque =número
		elif número < peque:
			peque = número

#Mostrando por pantalla el número más pequeño.
mensaje="El número más pequeño fue: " 
mensaje2="."
mensaje3="No fue introducido ningún número."
if peque == None:
	print(mensaje3)
else:
	print(mensaje + str(peque) + mensaje2)