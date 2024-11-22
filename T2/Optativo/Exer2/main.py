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


#Importando módulos.
from pokemons import charmander,bulbasaur,squirtle
from xogo import dano_ataque
from math import trunc
import random


#Función cálculo PS.
def calculo_PS(pokemon):
    vida = pokemon['PS base'] + (pokemon['Nivel']*2)
    return vida

#Lista de pokemon elegibles.
pok_elegir = [charmander,bulbasaur,squirtle]
indices = []

#Programa principal.
print("¿Con qué pokemon quieres combatir?")
for pok in pok_elegir:
    indices.append(pok_elegir.index(pok))
    print(f"{(pok_elegir.index(pok))+1} - {pok['Nombre']}")
num_elegido = int(input("> "))
indice_usuario = num_elegido - 1
print(f"Adelante {pok_elegir[indice_usuario]['Nombre']}.")
indice_rival = None
while (num_elegido - 1) == indice_rival or indice_rival == None:
    indice_rival = random.randint(0,(len(pok_elegir)-1))
#Estableciendo nivel aleatorio y calculando PS de pokemon.
nivel = random.randint(1,99)
pok_elegir[indice_usuario]['Nivel'] = nivel
pok_elegir[indice_rival]['Nivel'] = nivel
pok_elegir[indice_usuario]['PS now'] = calculo_PS(pok_elegir[indice_usuario])
pok_elegir[indice_usuario]['PS máx'] = calculo_PS(pok_elegir[indice_usuario])
pok_elegir[indice_rival]['PS now'] = calculo_PS(pok_elegir[indice_rival])
pok_elegir[indice_rival]['PS máx'] = calculo_PS(pok_elegir[indice_rival])
print(f"El rival sacó a {pok_elegir[indice_rival]['Nombre']}.")
print(f"¡A por todas, {pok_elegir[indice_rival]['Nombre']}!")
juego = True
while juego:
    try:
        print(f"¿Qué ataque quieres que realice {pok_elegir[indice_usuario]['Nombre']}?")
        reserva = {}
        for indice,ataque in enumerate(pok_elegir[indice_usuario]['Ataques']):
            reserva[f'{indice}'] = ataque['Nombre']
            print(f'{indice+1} - {ataque['Nombre']}')
        opcion = int(input('> '))
        #Opción número que no se corresponde con ningún ataque mostrado.
        if not(opcion > 0 and opcion <= len(pok_elegir[indice_usuario]['Ataques'])):
            raise ValueError
        #Ataque seleccionado que no tiene PPs.
        pok_elegir[indice_usuario]['Ataques'][int(opcion)-1]['PP now'] -= 1
        if pok_elegir[indice_usuario]['Ataques'][int(opcion)-1]['PP now'] < 0:
            raise TypeError
        #Ataque rival.
        opcion_rival = None
        while opcion_rival == None or pok_elegir[indice_rival]['Ataques'][opcion_rival - 1]['PP now'] == 0:
            opcion_rival = random.randint(1,len(pok_elegir[indice_rival]['Ataques']))   
        #Movimiento escogido ususario.
        print(f"{pok_elegir[indice_usuario]['Nombre']} usó {reserva[str(opcion-1)]}.")
        daño = (dano_ataque(pok_elegir[indice_usuario],opcion,pok_elegir[indice_rival]))
        pok_elegir[indice_rival]['PS now'] -= daño
        #Pokemon rival debilitado.
        if pok_elegir[indice_rival]['PS now'] <= 0:
            pok_elegir[indice_rival]['PS now'] = 0
            print(f'Vida {pok_elegir[indice_rival]['Nombre']}: {pok_elegir[indice_rival]['PS now']}/{pok_elegir[indice_rival]['PS máx']}.')
            print(f"{pok_elegir[indice_rival]['Nombre']} ha sido debilitado.")
            #Para acabar el while.
            juego = False
            print("¡Has ganado el combate!")
        #Pokemon rival vivo, se sigue combatiendo.
        else:
            print(f"{pok_elegir[indice_usuario]['Nombre']} dañó a {pok_elegir[indice_rival]['Nombre']} {daño} puntos de salud.")
            print(f'Vida {pok_elegir[indice_rival]['Nombre']}: {pok_elegir[indice_rival]['PS now']}/{pok_elegir[indice_rival]['PS máx']}.')
        #Movimiento escogido rival.
        print(f"{pok_elegir[indice_rival]['Nombre']} usó {pok_elegir[indice_rival]['Ataques'][opcion_rival - 1]['Nombre']}.")
        daño = (dano_ataque(pok_elegir[indice_rival],opcion_rival,pok_elegir[indice_usuario]))
        pok_elegir[indice_usuario]['PS now'] -= daño
        #Pokemon usuario debilitado.
        if pok_elegir[indice_usuario]['PS now'] <= 0:
            pok_elegir[indice_usuario]['PS now'] = 0
            print(f'Vida {pok_elegir[indice_usuario]['Nombre']}: {pok_elegir[indice_usuario]['PS now']}/{pok_elegir[indice_usuario]['PS máx']}.')
            print(f"{pok_elegir[indice_usuario]['Nombre']} ha sido debilitado.")
            #Para acabar el while.
            juego = False
            print("¡Tu rival ha ganado el combate!")
        #Pokemon rival vivo, se sigue combatiendo.
        else:
            print(f"{pok_elegir[indice_rival]['Nombre']} dañó a {pok_elegir[indice_usuario]['Nombre']} {daño} puntos de salud.")
            print(f'Vida {pok_elegir[indice_usuario]['Nombre']}: {pok_elegir[indice_usuario]['PS now']}/{pok_elegir[indice_usuario]['PS máx']}.')
    #Excepciones.
    except TypeError:
            print("Movimiento sin PP.")
    except ValueError:
        print("Error. Elige uno de los ataques mostrados.")
    