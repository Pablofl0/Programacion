#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""Crea un ficheiro main.py onde realizarás o programa principal. O xogo neste momento tan só debe:

O xogador terá como pokemon a Charmander e o rival a Bulbasur.

O xogador escollerá un ataque (comprobar que non esgotou o número de intentos dese ataque) e realizarao ao rival 
(restaráselle a vitalidade ao rival).

O xogador seguirá escollendo e realizando ataques ata que o pokemon rival esgote a vitalidade. Cando isto se produza 
indicaralle ao xogador que gañou e rematará o programa.

O pokemon rival non realizará ningún ataque.
"""

__author__ = "Pablo Fernández Lamas"

from pokemons import charmander,bulbasaur

from xogo import dano_ataque

from math import trunc





print("Adelante Charmander.")
print("¡Char, char!")
print("El rival sacó a Bulbaaur.")
print("¡A por todas, Bulbasaur!")
juego = True
while juego:
    try:
        print("¿Qué ataque debe realizar Charmander?")
        reserva = {}
        for indice,ataque in enumerate(charmander['Ataques']):
            reserva[f'{indice}'] = ataque['Nombre']
            print(f'{indice+1} - {ataque['Nombre']}')
        opcion = int(input('> '))
        if not(opcion > 0 and opcion <= len(charmander['Ataques'])):
            raise ValueError
    except ValueError:
        print("Error. Elige uno de los ataques mostrados.")
    print(f"Charmander usó {reserva[str(opcion-1)]}.")
    daño = trunc(dano_ataque(charmander,opcion,bulbasaur))
    bulbasaur['PS now'] -= daño
    if bulbasaur['PS now'] <= 0:
        print("Bulbasaur ha sido debilitado.")
        bulbasaur['PS now'] = 0
        juego = False
        print("¡Has ganado el combate!")
    else:
        print(f"Charmander dañó a Bulbasaur {daño} puntos de salud.")
    print(f'Vida Bulbasaur: {bulbasaur['PS now']}/{bulbasaur['PS máx']}.')