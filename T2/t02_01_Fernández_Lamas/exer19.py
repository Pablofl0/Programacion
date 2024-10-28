#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
A avaliación deste módulo é a seguinte: 15% de tarefas, 20% exame teórico e 65% exame práctico. 
Escribe un script que lle pida ao usuario as súas tres notas sobre 10 e indicaralle por pantalla a súa nota final sobre 10.
""" 

__author__ = "Pablo Fernández Lamas"  

#Pedindo as notas.
tarefas = float(input("Introduza a nota das tarefas:"))
teo = float(input("Introduza a nota do exame teórico:"))
prac = float(input("Introduza a nota do exame práctico:"))

#Calculando a nota final.
tarefas_porcentaxe = tarefas*0.15
teo_porcentaxe = teo*0.2
prac_porcentaxe = prac*0.65
nota_final = tarefas_porcentaxe+teo_porcentaxe+prac_porcentaxe

#Mostrando a nota final.
print("A nota final é " + str(nota_final) + ".")