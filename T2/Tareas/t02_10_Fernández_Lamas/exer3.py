#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Pasa a calculadora! é un xogo para dúas persoas no que se comeza cunha calculadora e cada xogador, de xeito alterno, 
suma un número novo, dun só díxito, ao valor acumulado ata o momento, comezando en 0. O xogador que, tras sumar o seu número, 
chegue a un resultado maior ou igual a 31 perde.

Ademais, en cada turno un xogador só pode utilizar os números situados na mesma fila ou columna que o díxito marcado polo seu 
opoñente no turno anterior, pero non pode repetir o número. Evidentemente, o número 0 non se pode utilizar nunca.

Por exemplo, imaxina que, durante unha partida, un xogador recibe aa calculadora mostrándolle o número 28, e o opoñente acaba 
de introducir o número 9. A partir da disposición dos números da calculadora, sabemos que nesta quenda unicamente poderá xogar 
os números 3, 6, 7 y 8:

Exemplo

Implanta este xogo.
"""

__author__ = "Pablo Fernández Lamas"

import random

#Def validación número recibido.
def validacion(n):
    """Función que valida el número entrante.

    Args:
        n (int): número entrante.

    Returns:
        boolean: True o False.
    """
    if type(n) is not int:
        return False
    elif not(n>0 and n<10):
        return False
    return True

#Def calculadora de números posibles.
def numeros_posibles(n):
    """Función que calcula los posibles números.

    Args:
        n (int): número entrante.

    Raises:
        ValueError: si los valores no son correctos.

    Returns:
        list: lista de números posibles.
    """
    if not(validacion(n)):
        raise ValueError
    numeros = []
    lista = '123456789'
    #Caso columna.
    i1 = n + 3
    i2 = n + 6
    while i1 > 9:
        i1 -= 9
    while i2 > 9:
        i2 -= 9
    numeros.append(int(lista[i1 - 1]))
    numeros.append(int(lista[i2 - 1]))
    #Caso fila.
    if n % 3 == 0:
        numeros.append(int(lista[n-2]))
        numeros.append(int(lista[n-3]))
    elif n % 3 == 2:
        numeros.append(int(lista[n-2]))
        numeros.append(int(lista[n]))
    elif n % 3 == 1:
        numeros.append(int(lista[n]))
        numeros.append(int(lista[n+1]))
    numeros.sort()
    return numeros





#Inicializando variables.
suma = 0
corte = 31

#Sorteando el jugador que primero empieza.
numero_aleatorio = random.randint(0,1)
if numero_aleatorio == 0:
    print("Tú serás el jugador A y tu compañero el jugador B.")
else:
    print("Tú serás el jugador B y tu compañero el jugador A.")
#Petición del primer número.
nuevo_número_B = int(input("Introduzca su primer número, jugador B: "))  
suma += nuevo_número_B

while True:
    try:
        #Pidiendo números.
        incorrecto = True
        posibles = numeros_posibles(nuevo_número_B)
        while incorrecto:
            print("Jugador A, introduzca uno de los siguientes 4 números:")
            for n in posibles:
                print(f"{n}")
            nuevo_número_A = int(input("> "))
            if nuevo_número_A in posibles:
                incorrecto = False
        suma += nuevo_número_A
        print(suma)
        #Mostrando ganador.
        if suma >= corte:
            print("Ganador jugador B.")
            break
        #Pidiendo números. 
        incorrecto = True   
        posibles = numeros_posibles(nuevo_número_A)
        while incorrecto:
            print("Jugador B, introduzca uno de los siguientes 4 números:")
            for n in posibles:
                print(f"{n}")
            nuevo_número_B = int(input("> "))
            if nuevo_número_B in posibles:
                incorrecto = False
        suma += nuevo_número_B
        print(suma)
        #Mostrando ganador.
        if suma >= corte:
            print("Ganador jugador A.")
            break
    except ValueError:
        print("Entrada no válida.")