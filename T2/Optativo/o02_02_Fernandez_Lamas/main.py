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
from time import sleep


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

#Delay 1 segundo.
sleep(1)

#Usuario saca a su pokemon.
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

#Delay 2 segundos.
sleep(2)

#Rival saca a su pokemon.
print(f"El rival sacó a {pok_elegir[indice_rival]['Nombre']}.")
#Delay 1 segundo.
sleep(1)
print(f"¡A por todas, {pok_elegir[indice_rival]['Nombre']}!")

#Delay 2 segundos.
sleep(2)

#Comienzo del combate.
juego = True
while juego:
    try:
        print(f"¿Qué ataque quieres que realice {pok_elegir[indice_usuario]['Nombre']}(Nv.{pok_elegir[indice_usuario]['Nivel']}) a {pok_elegir[indice_rival]['Nombre']}(Nv.{pok_elegir[indice_rival]['Nivel']})?")
        reserva = {}
        #Delay 1 segundo entre pregunta y muestra del primer movimiento.
        sleep(1)
        for indice,ataque in enumerate(pok_elegir[indice_usuario]['Ataques']):
            reserva[f'{indice}'] = ataque['Nombre']
            #Delay de 1 segundo entre muestra de movimientos.
            sleep(1)
            print(f'{indice+1} - {ataque['Nombre']} ({ataque['PP now']}/{ataque['PP máx']})')
        opcion = int(input('> '))
        #Delay 2 segundos.
        sleep(2)
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
        print(f"{pok_elegir[indice_usuario]['Nombre']}(Nv.{pok_elegir[indice_usuario]['Nivel']}) usó {reserva[str(opcion-1)]}.")
        daño = (dano_ataque(pok_elegir[indice_usuario],opcion,pok_elegir[indice_rival]))
        pok_elegir[indice_rival]['PS now'] -= daño
        #Delay 2 segundos.
        sleep(2)
        #Pokemon rival debilitado.
        if pok_elegir[indice_rival]['PS now'] <= 0:
            pok_elegir[indice_rival]['PS now'] = 0
            print(f'Vida {pok_elegir[indice_rival]['Nombre']}(Nv.{pok_elegir[indice_rival]['Nivel']}): {pok_elegir[indice_rival]['PS now']}/{pok_elegir[indice_rival]['PS máx']}.')
            #Delay 1 segundo.
            sleep(1)
            print(f"{pok_elegir[indice_rival]['Nombre']} enemigo ha sido debilitado.")
            #Delay 2 segundos.
            sleep(2)
            print("¡Has ganado el combate!")
            #Para acabar el while.
            break
        #Pokemon rival vivo, se sigue combatiendo.
        else:
            print(f"{pok_elegir[indice_usuario]['Nombre']} dañó a {pok_elegir[indice_rival]['Nombre']} {daño} puntos de salud.")
            #Delay 1 segundo.
            sleep(1)
            print(f'Vida {pok_elegir[indice_rival]['Nombre']}(Nv.{pok_elegir[indice_rival]['Nivel']}): {pok_elegir[indice_rival]['PS now']}/{pok_elegir[indice_rival]['PS máx']}.')
        
        
        #Delay 2 segundos.
        sleep(2)
        #Movimiento escogido rival.
        print(f"{pok_elegir[indice_rival]['Nombre']}(Nv.{pok_elegir[indice_rival]['Nivel']}) usó {pok_elegir[indice_rival]['Ataques'][opcion_rival - 1]['Nombre']}.")
        daño = (dano_ataque(pok_elegir[indice_rival],opcion_rival,pok_elegir[indice_usuario]))
        pok_elegir[indice_usuario]['PS now'] -= daño
        #Delay 2 segundos.
        sleep(2)
        #Pokemon usuario debilitado.
        if pok_elegir[indice_usuario]['PS now'] <= 0:
            pok_elegir[indice_usuario]['PS now'] = 0
            print(f'Vida {pok_elegir[indice_usuario]['Nombre']}(Nv.{pok_elegir[indice_usuario]['Nivel']}): {pok_elegir[indice_usuario]['PS now']}/{pok_elegir[indice_usuario]['PS máx']}.')
            #Delay 1 segundo.
            sleep(1)
            print(f"{pok_elegir[indice_usuario]['Nombre']} ha sido debilitado.")
            #Delay 2 segundos.
            sleep(2)
            print("¡Tu rival ha ganado el combate!")
            #Para acabar el while.
            break
        #Pokemon rival vivo, se sigue combatiendo.
        else:
            print(f"{pok_elegir[indice_rival]['Nombre']} dañó a {pok_elegir[indice_usuario]['Nombre']} {daño} puntos de salud.")
            #Delay 1 segundo.
            sleep(1)
            print(f'Vida {pok_elegir[indice_usuario]['Nombre']}(Nv.{pok_elegir[indice_usuario]['Nivel']}): {pok_elegir[indice_usuario]['PS now']}/{pok_elegir[indice_usuario]['PS máx']}.')
    
    #Excepciones.
    except TypeError:
            print("Movimiento sin PP.")
    except ValueError:
        print("Error. Elige uno de los ataques mostrados.")
    