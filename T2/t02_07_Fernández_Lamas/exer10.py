#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
A ordenación por burbulla é un algoritmo de ordenación simple pero ineficiente para listas pequenas. 
Funciona comparando elementos adxacentes na lista e intercambiándoos se están na orde incorrecta (é dicir,
se o primeiro elemento é maior que o segundo). Este proceso repítese varias veces ata que toda a lista está ordenada.

Cada “burbulla” (elemento grande) “sube” ata a súa posición correcta, movéndose cara ao final da lista en cada pasada.

Escribe unha función en Python burbulla(lista: List) -> List que implante o algoritmo de ordenación por burbulla para 
ordenar unha lista de números de menor a maior.
"""

__author__ = "Pablo Fernández Lamas"

#Def validacion del número pedido.
def validacion(número_pedir):
    """Función que valida el número pedido.

    Args:
        número_pedir (int): número pedido.

    Raises:
        ValueError: si el tipo del número es entero.
    """
    if type(número_pedir) is not int:
        raise ValueError
    else: 
        pass

#Def ordenar la lista.
def ordenar(lista):
    """Función que ordena la lista de números entregados por el usuario

    Args:
        lista (list): lista de números sin ordenar.

    Returns:
        list: lista con los números ordenados.
    """
    
    modificado=True
    while modificado:
        i=0
        modificado=False
        while i<(len(lista)-1):
            if lista[i] == lista[i+1]:
                i+=1
            elif lista[i] < lista[i+1]:
                i+=1
            elif lista[i] > lista[i+1]:
                reemplazo=lista[i]
                lista[i]=lista[i+1]
                lista[i+1]=reemplazo
                i+=1
                modificado=True



#Inicializando variable.
lista=[]

#Petición de números.
while True:
    número_pedir=(str(input("Introduzca un número: ")))
    if número_pedir=="listo":
        break
    else:
        try:
            numero_int=int(número_pedir	)
            validacion(numero_int)
            lista.append((numero_int))
        except ValueError:
            print("Error. Entrada no válida.")

#Muestra de la lista de números ordenada.
print(ordenar(lista))