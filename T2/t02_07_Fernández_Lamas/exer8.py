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

#Def validación.
def validacion_nota(nota):
    if type(nota) is not float:
        return False
    if not (0 <= nota and nota <= 10):
        return False
    return True

#Def validacion_indice.
def validacion_indice(indice,notas):
    if type(indice) is not int:
        return False
    elif not(0<=indice and indice<=(len(notas)-1)):
        return False
    else:
        return True

#Def añadir_nota.
def añadir_nota(nota,notas):
    if validacion_nota(nota) == True:
        notas.append(nota)
    else:
        raise ValueError
    return notas
    
#Def mostrar_nota.
def mostrar_nota(notas):
    #indices=[]
    for indice, valor in enumerate(notas):
        #indices.append(indice)
        lista_notas=(f"{indice}:{valor}")
        #return indice,lista_notas
        return lista_notas

#Def ver_media.
def ver_media(notas):
    suma = 0
    for cualificacion in notas:
        suma += cualificacion
    media=suma/len(notas)
    return media


#Def ver_numero_aprobados.
def ver_numero_aprobados(nota,notas):
    aprobados=0
    for nota in notas:
        if nota >= 5:
            aprobados += 1
    return aprobados

#Def ver_maximanota.
def ver_maximanota(notas):
    notas.sort()
    maximo=notas[:-1]
    return maximo


#Def eliminar_nota.
def eliminar_nota(indice,notas):
    if validacion_indice==True:
        del notas[indice]
    return notas

#Inicializando variables.
notas=[]

#Estableciendo ejecución de programa según opción escogida.
while True:
    try:
        # Escogiendo el cambio que el usuario desea realizar.
        print("Elige una de las siguientes opciones:")
        print("\ta) Añadir nota.")
        print("\tb) Ver media.")
        print("\tc) Ver número de aprobados.")
        print("\td) Ver máxima nota.")
        print("\te) Eliminar nota.")
        print("\tf) Salir.")
        opción = input("> ")
        opción.lower()
        if opción=='a':
            nota=float(input("Introduzca nota: "))
            añadir_nota(nota,notas)
            print(notas)
        elif opción=='b':
            print("La media de las notas es " + str(ver_media(notas)) + ".")
        elif opción=='c':
            print("El número de aprobados es " + str(ver_numero_aprobados(nota,notas)) + ".")
        elif opción=='d':
            print("La máxima nota es " + str(ver_maximanota(notas)) + ".")
        elif opción=='e':
            print(mostrar_nota(notas))
            indice=int(input("Introduzca el índice correspondiente a la nota que desea eliminar: "))
            eliminar_nota(indice)
        elif opción=='f':
            break
    except ValueError:
        print("Error.")

#Llamando a funciones con valores.
#indices_notas,tabla_indice_nota=mostrar_nota(notas)


