#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Realiza unha aplicación co seguinte menú:

a) Ingresar datos alumno

b) Eliminar datos alumno

Débese mostrar unha lista de alumnos nun menú e seleccionar o alumno a eliminar segundo o índice co seguinte formato: indice. apelidos_alumno, nome: nota.
c) Modificar nota alumno

Débese mostrar unha lista de alumnos nun menú e seleccionar o alumno a modificar a nota o índice co seguinte formato: indice. apelidos_alumno, nome: nota.
d) Ver nomes e apelidos de alumnos aprobados

Débese mostrar co seguinte formato: indice. apelidos_alumno, nome: nota
e) Mostra alumnos alfabeticamente:

Débese mostrar co seguinte formato: indice. apelidos_alumno, nome: nota
Podes modificar a función do método da burbulla de tarefas anteriores.
f) Ver a nota media.

g) Sair.

Para cada alumno necesitaremos gardar os seguintes datos:

Nome
Apelidos
Nota con decimais.
Axuda:

A información de cada alumno almacenarase nun dicionario.
Para gardar a información de cada alumno utilizaremos unha lista.
"""

__author__ = "Pablo Fernández Lamas"


#Mostrar notas.
def mostrar_notas(alumnado):
    for nom_ape in alumnado:
        print(nom_ape, alumnado[nom_ape])


#Añadir datos alumno.
def añadir_datos(nombre,apellido):
    apellido.append(new_apellido)
    nombre.append(new_nombre)
    return nombre, apellido



#Inicializando variables.
apellido=[]
nombre=[]



#Estableciendo ejecución de programa según opción escogida.
while True:
    try:
        # Escogiendo el cambio que el usuario desea realizar.
        print("Elige una de las siguientes opciones:")
        print("\ta) Ingresar datos alumno.")
        print("\tb) Eliminar datos alumno.")
        print("\tc) Modificar nota alumno.")
        print("\td) Ver nomes e apelidos de alumnos aprobados.")
        print("\te) Mostrar alumnos alfabéticamente.")
        print("\tf) Ver la nota media.")
        print("\tg) Salir.")
        opción = input("> ")
        opción.lower()
        if opción=='a':
            new_nombre=str(input("Introduzca el nombre: "))
            new_apellido=str(input("Introduzca los apellidos: "))
            nombres,apellidos=añadir_datos(nombre,apellido)
            nom_ape={apellidos,nombres}
            alumnado={[apellidos,nombres]:"nota"}
            print(alumnado)
        elif opción=='b':
        elif opción=='c':
        elif opción=='d':
        elif opción=='e':
        elif opción=='f':
            break
    except ValueError:
        print("Error. Entrada no válida.") 