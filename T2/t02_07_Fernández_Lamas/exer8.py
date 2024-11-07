#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Crea un script que pida as notas dun exame dos alumnos dunha clase para procesalos. 
Tódalas notas téñense que ir almacenando nunha lista. Mostra un menú que se mostre continuamente ata que o usuario seleccione a opción saír. 
As entradas do menú son:

a) Engadir nota
b) Ver media
c) Ver número de aprobados
d) Ver máxima nota
e) Eliminar nota Primeiro debes de mostrar un menú onde mostres para cada índice da lista, a súa nota. O usuario indicará o índice da nota a eliminar.
f) Saír
Para poder realizar cada acción do menú, implanta as seguintes funcións:

engadir_nota(lista: list[float], nota: float).

Comproba que a lista sexa unha lista, senón lanza excepción ValueError.
Se a nota é un valor inválido, lanza a excepción ValueError.
mostrar_notas(lista: list[float])

Comproba que a lista sexa unha lista, senón lanza excepción ValueError.
Débese mostrar neste formato: índice: nota. Exemplo:
0 : nota1
1 : nota2
...
media_notas(lista: list[float]) -> float

Comproba que a lista sexa unha lista, senón lanza excepción ValueError.
numero_aprobados(lista list[float]) -> int

Comproba que a lista sexa unha lista, senón lanza excepción ValueError.
maxima_nota(lista: list[float]) -> float

Comproba que a lista sexa unha lista, senón lanza excepción ValueError.
eliminar_nota(lista: list[float], indice: int)

Comproba que a lista sexa unha lista, senón lanza excepción ValueError.
Se o índice non é válido lanza excepción ValueError.
"""

__author__ = "Pablo Fernández Lamas"

# Escogiendo el cambio que el usuario desea realizar.
print("Elige una de las siguientes opciones:")
print("\ta) Añadir nota.")
print("\tb) Ver media.")
print("\tc) Ver número de aprobados.")
print("\td) Ver máxima nota.")
print("\te) Eliminar nota.")
print("\tf) Salir.")
opción = input("> ")


#Opción a).
notas = []
# Imos metendo tódlas notas
while True:
    
    # Collemos unha nota ou a palabra fin
    nota_str = input()

    # Comprobamos se e a nota fin
    if nota_str == "fin":
        break

    # Comprobamos se e un número
    try:
        nota = int(nota_str)
    except:
        continue

    # Comprobamos que a nota estea entre 0 e 10
    if 0 <= nota and nota <= 10:
        notas.append(nota)
    else:
        print()

# Realizamos a suma de todalas notas
suma = 0
for nota in notas:
    suma = suma + nota

# Dividimos entre o numero de notas
media = suma / len(notas)

print(media)







#Opción
for indice, valor in enumerate(lista):
    print(f"Índice: {indice}, Valor: {valor}")