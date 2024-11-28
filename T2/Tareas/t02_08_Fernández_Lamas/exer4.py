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

#Def validación_nota.
def validacion_nota(nota):
    """Función que valida nota entrante.

    Args:
        nota (float): nota entrante.

    Returns:
        boolean: True o False.
    """
    if type(nota) is not float:
        return False
    if not (0 <= nota and nota <= 10):
        return False
    return True

#Def validacion_nombre.
def validacion_nombre(new_apellido,new_nombre):
    """Función que valida el nombre y apellidos entrantes.

    Args:
        new_apellido (str): apellido entrante.
        new_nombre (str): nombre entrante.

    Returns:
        boolean: True o False.
    """
    if (type(new_apellido) or type(new_nombre)) is not str:
        return False
    return True

#Def validacion_indice.
def validacion_indice(indice,alumnado):
    """Función que valida índice entrante.

    Args:
        indice (int): índice entrante.
        alumnado (list): lista con datos de alumnos.

    Returns:
        boolean: True o False.
    """
    if type(indice) is not int:
        return False
    elif not(0<=indice and indice<=(len(alumnado)-1)):
        return False
    return True


#Añadir datos alumno.
def datos_alumno(new_nombre,new_apellido,nota):
    """Función que añade los datos de un alumno a la lista alumnado.

    Args:
        new_nombre (str): nombre entrante.
        new_apellido (str): apellido entrante.
        nota (float: nota con decimales.

    Raises:
        ValueError: si el tipo de dato no es correcto.

    Returns:
        alumno: datos de un alumno.
    """
    if not (validacion_nota(nota) or validacion_nombre(new_apellido,new_nombre)):
        raise ValueError
    alumno={}
    alumno['Nombre']=new_nombre
    alumno['Apellidos']=new_apellido
    alumno['Nota']=nota
    return alumno

#Mostrar notas.
def mostrar_alumnado(alumnado):
    """Función que muestra los datos de los alumnos.

    Args:
        alumnado (list): lista con datos del alumnado.
    """
    for indice, datos in enumerate(alumnado):
        print(f"{indice}. {datos['Apellidos']}, {datos['Nombre']}: {datos['Nota']}")

#Eliminar datos alumno.
def eliminar_datos(alumnado,indice):
    """Función que elimina los datos de un alumno a elegir mediante un índice.

    Args:
        alumnado (list): lista con datos del alumnado.
        indice (int): índice del alumno.

    Raises:
        ValueError: si el tipo de dato no es correcto.

    Returns:
        alumnado: lista con datos del alumnado.
    """
    if not validacion_indice(indice,alumnado):
        raise ValueError
    alumnado.pop(indice)
    return alumnado

#Modificar nota alumno.
def modificar_nota(indice,new_nota,alumnado):
    """Función que modifica la nota de un alumno.

    Args:
        indice (int): índice del alumno.
        new_nota (float): nueva nota.
        alumnado (list): lista con datos del alumnado.

    Raises:
        ValueError: si el tipo de dato no es correcto.

    Returns:
        alumnado: lista con datos del alumnado.
    """
    if not (validacion_indice(indice,alumnado) or validacion_nota(new_nota)):
        raise ValueError
    alumnado[indice]['Nota'] = new_nota
    return alumnado

#Ver aprobados.
def ver_aprobados(alumnado):
    """Función que muestra los alumnos con nota mayor o igual a 5.

    Args:
        alumnado (list): lista con datos del alumnado.
    """
    lista = []
    aprobados = 0
    for alumno in alumnado:
        if alumno['Nota'] >= 5:
            lista.append(alumno)
            aprobados += 1
    if aprobados == 0:
        return False
    return lista

#Ver nota media.
def ver_notamedia(alumnado):
    """Función que calcula la nota media.

    Args:
        alumnado (list): lista con datos del alumnado.

    Returns:
        int: nota media.
    """
    suma = 0
    for alumno in alumnado:
        suma = suma + alumno['Nota']
    if len(alumnado) == 0:
        media = 0
    else: 
        media = suma / len (alumnado)
    return media

#Orden alfabético.
def orden(alumnado):
    """Función que ordena la lista de alumnos por orden alfabético.

    Args:
        alumnado (list): lista con datos del alumnado.

    Returns:
        list: lista con datos del alumnado ordenado alfabéticamente.
    """
    modificado=True
    while modificado:
        indice=0
        modificado=False
        while indice<(len(alumnado)-1):

            Nombre1 = (alumnado[indice]['Nombre']).lower()
            Nombre2 = (alumnado[indice + 1]['Nombre']).lower()
            Apellido1 = (alumnado[indice]['Apellidos']).lower()
            Apellido2 = (alumnado[indice + 1]['Apellidos']).lower()

            if (Apellido1 + " " + Nombre1) > (Apellido2 + " " + Nombre2):
                reemplazo = alumnado[indice]
                alumnado[indice] = alumnado[indice+1]
                alumnado[indice+1] = reemplazo
                indice+=1
                modificado = True
            else: 
                indice += 1
    return alumnado


#Inicializando variables.
alumnado=[]


#Estableciendo ejecución de programa según opción escogida.
while True:
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
            try:
                new_nombre=str(input("Introduzca el nombre: "))
                new_apellido=str(input("Introduzca los apellidos: "))
                nota=float(input("Introduzca la nota: "))
                alumno=datos_alumno(new_nombre,new_apellido,nota)
                alumnado.append(alumno)
                mostrar_alumnado(alumnado)
            except ValueError:
                print("Error. Entrada no válida.")
        elif opción=='b':
            try:
                mostrar_alumnado(alumnado)
                indice=int(input("Introduzca el índice correspondiente al alumno que desea eliminar: "))
                eliminar_datos(alumnado,indice)
                mostrar_alumnado(alumnado)
            except ValueError:
                print("Error. Entrada no válida.")
        elif opción=='c':
            try:
                mostrar_alumnado(alumnado)
                indice=int(input("Introduzca el índice correspondiente al alumno cuya nota desea modificar: "))
                new_nota=float(input("Introduzca la nota nueva: "))
                modificar_nota(indice,new_nota,alumnado)
                mostrar_alumnado(alumnado)
            except ValueError:
                print("Error. Entrada no válida.")
        elif opción=='d':
            try:
                if not ver_aprobados(alumnado):
                    print("No hay alumnos aprobados.")
                else:
                    alumnos_aprobados = ver_aprobados(alumnado)
                    mostrar_alumnado(alumnos_aprobados)
            except ValueError:
                print("Error. Entrada no válida.")
        elif opción=='e':
            try:
                orden(alumnado)
                mostrar_alumnado(alumnado)
            except ValueError:
                print("Error. Entrada no válida.")
        elif opción=='f':
            try:
                print("La nota media es " + str(ver_notamedia(alumnado)) + ".")
            except ValueError:
                print("Error. Entrada no válida.")
        elif opción=='g':
            break
        else:
            print("Error. Entrada no válida.")