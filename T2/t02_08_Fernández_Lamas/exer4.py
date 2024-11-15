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


#Añadir datos alumno.
def datos_alumno(new_nombre,new_apellido,nota):
    alumno={}
    alumno['Nombre']=new_nombre
    alumno['Apellidos']=new_apellido
    alumno['Nota']=nota
    return alumno

#Mostrar notas.
def mostrar_alumnado(alumnado):
    for indice, datos in enumerate(alumnado):
        print(f"{indice}. {datos['Apellidos']}, {datos['Nombre']}: {datos['Nota']}")

#Eliminar datos alumno.
def eliminar_datos(alumnado,indice):
    alumnado.pop(indice)
    return alumnado

#Modificar nota alumno.
def modificar_nota(indice,new_nota):
    alumnado[indice]['Nota'] = new_nota
    return alumnado


#Inicializando variables.
alumnado=[]



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
            nota=float(input("Introduzca la nota: "))
            alumno=datos_alumno(new_nombre,new_apellido,nota)
            alumnado.append(alumno)
            mostrar_alumnado(alumnado)
        elif opción=='b':
            mostrar_alumnado(alumnado)
            indice=int(input("Introduzca el índice correspondiente al alumno que desea eliminar: "))
            eliminar_datos(alumnado,indice)
            mostrar_alumnado(alumnado)
        elif opción=='c':
            mostrar_alumnado(alumnado)
            indice=int(input("Introduzca el índice correspondiente al alumno cuya nota desea modificar: "))
            new_nota=float(input("Introduzca la nota nueva: "))
            modificar_nota
        #elif opción=='d':
        #elif opción=='e':
        elif opción=='f':
            break
    except ValueError:
        print("Error. Entrada no válida.") 