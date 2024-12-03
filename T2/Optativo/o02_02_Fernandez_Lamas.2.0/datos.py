#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Función cargar datos.
"""

__author__ = "Pablo Fernández Lamas"

import json

def cargardatos():
    with open ("pokemons.json") as pokemons:
        pok_elegir = json.load(pokemons)
    return pok_elegir

