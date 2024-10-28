#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Escribe un script que elixirá no seu comezo un número ao azar entre 1 e 25. 
A continuación o usuario introducirá números por teclado ata que acerte o número seleccionado ao azar. 
Cada vez que se introduza un número incorrecto, o script proporcionaralle pistas ao usuario: “o número e maior” ou “o número é menor”. 
Unha vez que o usuario acerte o número, indicaráselle por pantalla se gañou o xogo ou non. Para gañar, o usuario deberá acertar o número en menos de 5 intentos.

Para obter o número ao azar utiliza o seguinte código:
"""

__author__ = "Pablo Fernández Lamas"

#Eligindo número al azar.
import random
numero_aleatorio = random.randint(1, 25)

#Introducción de los números.
i=0
flag = True
while flag:
    i=i+1
    a=int(input("Introduzca un número entero entre el 1 y el 25 (ambos incluidos):"))
    if a==numero_aleatorio:
        flag = False
        print("El número sacado al azar ha sido el " + str(numero_aleatorio) + ".")        
    elif not(a>=1 and a<=25):
        print("¡Error! Ese número no pertenece al intervalo deseado.")
    elif a<numero_aleatorio:
        print("El número es mayor que " + str(a) + " .")
    elif a>numero_aleatorio:
        print("El número es menor que " + str(a) + " .")                    

if i<5:
    print("¡Has ganado!")
else:
    print("¡Has perdido!")