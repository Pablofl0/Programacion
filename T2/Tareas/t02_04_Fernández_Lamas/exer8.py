#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
A avaliación deste módulo é a seguinte: 15% de tarefas, 20% exame teórico e 65% exame práctico. 
Escribe un script que lle pedirá ao usuario as súas tres notas sobre 10. Indicaralle por pantalla se obtivo Sobresaliente, Notable, Ben, Suficiente ou Insuficiente.

Deduce o número necesario de funcións e defíneas.
"""

__author__ = "Pablo Fernández Lamas"

#Definicón nota.
def nota_num(tarefas,teo,prac):
	"""Función que calcula la nota final.

	Args:
		tarefas (float): nota tareas.
		prac (float): nota prácticas.

	Returns:
		float: Nota final
	"""
	tarefas_porcentaxe = tarefas*0.15
	teo_porcentaxe = teo*0.2
	prac_porcentaxe = prac*0.65
	nota_final = tarefas_porcentaxe+teo_porcentaxe+prac_porcentaxe
	return nota_final

#Definición paso de número a texto.
def calificacion_numero_a_texto(nota):
	"""Función que pasa la nota de número a texto.

	Returns:
		str: nota.
	"""
	if nota > 10 or nota < 0:
		return None
	elif nota >= 9:
		return "Sobresaliente"
	elif nota >= 7:
		return "Notable"
	elif nota >= 6:
		return "Bien"
	elif nota >= 5:
		return "Suficiente"
	else:
		return "Insuficiente"


#Pidiendo las notas.
tarefas = float(input("Introduzca la nota de las tareas:"))
teo = float(input("Introduzca la nota del examen teórico:"))
prac = float(input("Introduzca la nota del examen práctico:"))

#Mostrando a nota final.
nota=nota_num(tarefas,teo,prac)
print("La nota final es " + str(nota) + ".")