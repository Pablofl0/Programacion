#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
En 1994, Clifford A. Pickover puxo de manifesto a existencia dos números vampiro. Estes están ocultos estre o resto do noso sistema numérico, conservando os xenes 
de seus pais tras multiplicarse. Así, por exemplo, o número 2187 é un número vampiro, ao ter os mesmos díxitos que os deus dous proxenitores: 27 e 81 (27 · 81 = 2.187).

Os números vampiro verdadeiros cumpren catro condicións:

Teñen un número par de díxitos.

Obtéñense ao multiplicar dous números, chamados colmillos, que teñen a metade de díxitos que o orixinal.

Teñen os mesmos díxitos que os colmillos, e na mesma cantidade (aínda que en calquera orde).

Os colmillos non acaban ao mesmo tempo en 0.

Crea unha función e_vampiro(numero: int) -> Boolean que indique se un número e vampiro ou non.

Pista: necesitaras ademais unha función recursiva que calcule as combinacións posibles de números dunha certa lonxitude de díxitos a partir dos díxitos dun número.
"""

__author__ = "Pablo Fernández Lamas"

def combinacion_caracteres(caracteres, lonxitude):
	"""
	Función recursiva que devolve todalas combinacions de caracteres dunha lonxitude

	Args:
		caracteres (str): é unha cadea de caracteres das que se quitan pa facelas combinacions
		lonxitude (int): é a lonxitude das cadeas que desexamos realizar

	Returns:
		list[str]: é unha lista de cadeas con tódalas combinacions

	"""
	# Se a lonxitude e 1, devolvemos unha lista onde cada elemento e un caracter
	if lonxitude == 1:
		return [i for i in caracteres]
	else:
		# Creamos unha lista onde meteremos cada un dos caracteres
		lista_nova = []
		# Collemos o indice de cada un dos caracteres
		for i, caracter in enumerate(caracteres):
			
			# Collemos o resto de caracteres
			if i+1 < len(caracteres):
				novos_caracteres = caracteres[:i] + caracteres[i+1:]
			else:
				novos_caracteres = caracteres[:i]
			
			# Collemos as combinacion dos elementos restantes cunha lonxitude menor
			combinacions = combinacion_caracteres(novos_caracteres, lonxitude - 1)

			# Collemos cada combinacion para concatenala co caracter
			for combinacion in combinacions:
				lista_nova.append(caracter + combinacion)
		# Devolvemos todalas combinacions
		return lista_nova


def e_vampiro(vampiro):
	"""
	Función que indica se un número é un número vampiro

	Args:
		vampiro (int): o número a comprobar

	Returns:
		boolean: verdadeiro se é vampiro e falso en caso contrario
	"""
	# Collemos o numero en str
	vampiro_str = str(vampiro)
	# Collemos o número de díxitos
	n_dixitos = len(vampiro_str)

	# O numero de dixitos ten que ser par
	if n_dixitos % 2 != 0:
		return False

	# Collemos todolos posibles colmillos posibles e metemolos nunha lista
	lista_colmillos = combinacion_caracteres(vampiro_str, n_dixitos/2)

	# Eliminamos os numeros que sexan iguais (se se repiten caracteres e posible que pase)
	nova_lista_colmillos = []
	for e in lista_colmillos:
		if e not in nova_lista_colmillos:
			nova_lista_colmillos.append(e)
	
	# Recorremos cada un dos colmillos
	for i, colmillo1 in enumerate(nova_lista_colmillos):
		for e in range(i+1, len(nova_lista_colmillos)):
			colmillo2 = nova_lista_colmillos[e]
			
			multiplicacion = int(colmillo1) * int(colmillo2)
			if multiplicacion == vampiro:
				if not(colmillo1[-1] == "0" and colmillo2[-1] == "0"):
					return True

	return False



caracteres='2187'
lonxitude=4
vampiro=2187
print(combinacion_caracteres(caracteres,lonxitude))
print(e_vampiro(vampiro))