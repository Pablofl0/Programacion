#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Escribe un script que pida ao usuario o número de quilómetros recorridos na súa última viaxe en coche, 
o consumo do coche en litros cada 100 quilómetros e o prezo en euros dun litro de combustible. 
Calcula o custo da viaxe e móstrallo ao usuario por pantalla.
""" 

__author__ = "Pablo Fernández Lamas"  

#Pedindo datos.
km = float(input("Introduza o número de kilómetros recorridos:"))
consumo = float(input("Introduza o consumo en litros do coche cada 100 kilómetros:"))
prezocomb = float(input("Introduza o prezo en euros dun litro de combustible:"))

#Calculando custo do viaxe.
gasto = km*(consumo/100)
custoviaxe = gasto*prezocomb


#Mostrando resultado.
print("O custo do viaxe foi de", custoviaxe , "euros.")