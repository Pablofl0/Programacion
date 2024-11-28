#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""Crea un ficheiro pokemons.py no que definiras dous dicionarios: un para Charmander e outro para Bulbasur completando os 
seguintes conxunto chaves-valor:

Nome do pokemon.

Tipo: Para Charmander será lume e para Bulbasur planta.

Nivel: entre 1 e 99.

Vitalidade Máxima: escolle calquera valor que consideres.

Vitalidade actual: nun primeiro momento debe ser igual a vitalidade máxima.

Ataques: lista de ataques. Cada ataque será un dicionario cos seguintes campos:

Nome: nome do ataque.

Tipo: poderá ser de calquera tipo definido (lume, planta, normal, etc.)

Poder: escolle calquera valor que consideres.

Número de ataques máximos: refírese as veces que se pode utilizar un ataque.

Número de ataques restantes: nun primeiro momento debe ser igual a ao número de ataques máximos.
"""

__author__ = "Pablo Fernández Lamas"


#Datos de Charmander.
charmander = {
    'Nombre' : 'Charmander',
    'Tipo1' : 'Fuego',
    'Tipo2' : '',
    'Nivel' : 5,
    'PS máx' : 40,
    'PS now' : 40,
    'Ataques' : [
        {
            'Nombre' : 'Arañazo',
            'Tipo' : 'Normal',
            'Poder' : 40,
            'PP máx' : 35,
            'PP now' : 35,
        },
        {
            'Nombre' : 'Látigo',
            'Tipo' : 'Normal',
            'Poder' : 0,
            'PP máx' : 30,
            'PP now' : 30,
        },
        {
            'Nombre' : 'Ascuas',
            'Tipo' : 'Fuego',
            'Poder' : 40,
            'PP máx' : 25,
            'PP now' : 25,
        }
    ]
}


#Datos de Bulbasaur.
bulbasaur = {
    'Nombre' : 'Bulbasaur',
    'Tipo1' : 'Planta',
    'Tipo2' : 'Veneno',
    'Nivel' : 5,
    'PS máx' : 40,
    'PS now' : 40,
    'Ataques' : [
        {
            'Nombre' : 'Placaje',
            'Tipo' : 'Normal',
            'Poder' : 40,
            'PP máx' : 35,
            'PP now' : 35,
        },
        {
            'Nombre' : 'Grúñido',
            'Tipo' : 'Normal',
            'Poder' : 0,
            'PP máx' : 30,
            'PP now' : 30,
        },
        {
            'Nombre' : 'Latigo Cepa',
            'Tipo' : 'Planta',
            'Poder' : 45,
            'PP máx' : 25,
            'PP now' : 25,
        }
    ]
}