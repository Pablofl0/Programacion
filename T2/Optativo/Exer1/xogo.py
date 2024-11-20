#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""Crea a función dano_ataque(pokemon_atacante: Dict, ataque: Dict, pokemon_atacado: Dict) que recibe como parámetros o 
pokemon que realiza o ataque, o ataque que realiza e o pokemon receptor do ataque. Esta función deberá calcular e devolver 
o dano que realizará dito ataque. O dano realizado é igual a vitalidade que se restará ao pokemon receptor ataque) en función de:

O tipo de ataque e o tipo do pokemon que realiza o ataque. Por exemplo un ataque de tipo lume é moi efectivo contra un pokemon 
de tipo planta pero pouco contra un de tipo auga. Selecciona ditas debilidades.

O nivel do pokemon que realiza o ataque. O nivel do pokemon que recibe o ataque non influirá.

Deberá ter unha compoñente aleatoria. O dano non sempre será o mesmo repetíndose as mesmas condicións. Utiliza a librería random
"""

__author__ = "Pablo Fernández Lamas"

import random

def dano_ataque(pokemon_atacante,opcion,pokemon_atacado):
    numero_ataque = int(opcion) - 1
    #Tipo a favor:
    if pokemon_atacante['Tipo1'] == pokemon_atacante['Ataques'][numero_ataque]['Tipo'] or pokemon_atacante['Tipo2'] == pokemon_atacante['Ataques'][numero_ataque]['Tipo']:
        B = 1.5
    else:
        B = 1
    #Tabla de tipos (normal,agua,fuego,planta):
    por2 = ['23','34','42','54']
    por05 = ['32','24','43','45']
    tipos = ['','Normal','Agua','Fuego','Planta','Veneno']
    tipo_ataque = (tipos.index(pokemon_atacante['Ataques'][numero_ataque]['Tipo']))
    tipo1_pokemonrecibe = (tipos.index(pokemon_atacado['Tipo1']))
    tipo2_pokemonrecibe = (tipos.index(pokemon_atacado['Tipo2']))
    v1 = str(tipo_ataque) + str(tipo1_pokemonrecibe)
    v2 = str(tipo_ataque) + str(tipo2_pokemonrecibe)
    E = 1
    if v1 in por2:
        E *= 2
    elif v1 in por05:
        E *= (0.5)
    if v2 in por2:
        E *= 2
    elif v2 in por05:
        E *= (0.5)
    #Variación random:
    V = random.randint(85,100)
    #Nivel pokemon atacante:
    N = pokemon_atacante['Nivel']
    #Poder ataque:
    P = pokemon_atacante['Ataques'][numero_ataque]['Poder']
    if P == 0:
        daño = 0
    else:
        daño = 0.01*B*E*V*((((0.2*(N+1))*P)/25)+2)
    return daño