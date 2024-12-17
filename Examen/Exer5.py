#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
 Débese realizar unha aplicación para xestionar as vivendas que ten a disposición unha inmobiliaria. 
 Para cada vivenda débese saber a dirección na que se encontra, se esta está en venta ou en alugamento e o prezo de venta ou alugamento en cada caso.

A aplicación constará do seguinte menú:

a) Ingresar datos vivenda


b) Eliminar datos vivenda

Débese mostrar unha lista de vivendas nun menú e seleccionar a vivenda a eliminar segundo o índice co seguinte formato: 
<índice>) <dirección>. <venta|alugamento> - <prezo> €.


c) Modificar estado de venta a alugamento, ou viceversa

Débese mostrar unha lista de vivendas nun menú e seleccionar a vivenda a eliminar segundo o índice co seguinte formato: 
<índice>) <dirección>. <venta|alugamento> - <prezo> €.


d) Mostrar vivendas en alugamento

Débese mostrar co seguinte formato: <índice>) <dirección>. <venta|alugamento> - <prezo> €.


e) Ver o prezo de alugamento máis repetido.

En caso de empate de prezos, indica o máis baixo.
Pista: utiliza dicionarios para realizar dito cálculo.
Se non hai vivendas de alugamento devolve None


f) Ver o prezo de venta máis repetido.

En caso de empate de prezos, indica o máis baixo.
Pista: reutiliza funcións.
Se non hai vivendas en venda devolve None


g) Sair.
"""

__author__ = "Pablo Fernández Lamas"

#Def validación_lista.
def validacion_lista(lista):
    """Función que valida la lista entrante.

    Args:
        lista (list): lista.

    Returns:
        boolean: True o False.
    """
    if not(type(lista) == list):
        return False
    return True

#Def validacion_indice.
def validacion_indice(indice,inmobiliaria):
    """Función que valida índice entrante.

    Args:
        indice (int): índice entrante.
        alumnado (list): lista con datos de alumnos.

    Returns:
        boolean: True o False.
    """
    if type(indice) is not int:
        return False
    elif not(0<=indice and indice<=(len(inmobiliaria)-1)):
        return False
    return True

#Añadir datos alumno.
def datos_vivienda(new_direccion,new_estado,new_precio):
    """Función que añade los datos a la lista.

    Args:
        new_direccion (str): nombre entrante.
        new_estado (int): apellido entrante.
        new_precio (float): nota con decimales.

    Raises:
        ValueError: si el tipo de dato no es correcto.

    Returns:
        inmobiliaria: datos de una inmobiliaria.
    """
    if not((new_estado <=2) and (new_estado >= 1)):
        raise ValueError
    vivienda={}
    vivienda['Dirección']=new_direccion
    if new_estado == 1:
        vivienda['Estado'] = True
    elif new_estado == 2:
        vivienda['Estado'] = False
    vivienda['Precio']=new_precio
    return vivienda

#Mostrar notas.
def mostrar_inmobiliaria(inmobiliaria):
    """Función que muestra los datos de la inmobiliaria.

    Args:
        inmobiliaria (list): lista con datos de la inmobiliaria.

    Raises:
        ValueError: si el tipo de dato no es correcto.
    """
    if not(validacion_lista(inmobiliaria)):
        raise ValueError
    for indice, datos in enumerate(inmobiliaria):
        if datos['Estado']:
            estado_muestra = 'venta'
        else:
            estado_muestra = 'alquiler'
        print(f"<{indice}>) <{datos['Dirección']}>. <{estado_muestra}> - <{datos['Precio']}> €")


#Eliminar datos alumno.
def eliminar_datos(inmobiliaria,indice):
    """Función que elimina los datos de una vivienda a elegir mediante un índice.

    Args:
        inmobiliaria (list): lista con datos de la inmobiliaria.
        indice (int): índice de la vivienda.

    Raises:
        ValueError: si el tipo de dato no es correcto.

    Returns:
        inmobiliaria: lista con datos de la inmobiliaria.
    """
    if not(validacion_indice(indice,inmobiliaria) or validacion_lista(inmobiliaria)):
        raise ValueError
    inmobiliaria.pop(indice)

#Modificar estado vivienda.
def modificar_inmobiliaria(indice,inmobiliaria):
    """Función que modifica el estado.

    Args:
        indice (int): índice de la vivienda.
        new_estado (int): nueva nota.
        inmmobiliaria (list): lista con datos del alumnado.

    Raises:
        ValueError: si el tipo de dato no es correcto.

    Returns:
        inmobiliaria: lista con datos de la inmobiliaria.
    """
    if not (validacion_indice(indice,inmobiliaria) or validacion_lista(inmobiliaria)):
        raise ValueError
    inmobiliaria[indice]['Estado']  = not inmobiliaria[indice]['Estado'] 

#Ver alquiler.
def ver_alquiler(inmobiliaria):
    """Función que muestra los alumnos con nota mayor o igual a 5.

    Args:
        inmobilaria (list): lista con datos del alumnado.

    Raises:
        ValueError: si el tipo de dato no es correcto.

    Returns:
        list: lista de alumnos aprobados.
    """
    if not(validacion_lista(inmobiliaria)):
        raise ValueError
    lista = []
    alquiler = 0
    for inmueble in inmobiliaria:
        if not(inmueble['Estado']):
            lista.append(inmueble)
            alquiler += 1
    if alquiler == 0:
        return None
    return lista

#Ver alquiler.
def ver_venta(inmobiliaria):
    """Función que muestra los alumnos con nota mayor o igual a 5.

    Args:
        inmbiliaria (list): lista con datos del alumnado.

    Raises:
        ValueError: si el tipo de dato no es correcto.

    Returns:
        list: lista de alumnos aprobados.
    """
    if not(validacion_lista(inmobiliaria)):
        raise ValueError
    lista = []
    venta = 0
    for inmueble in inmobiliaria:
        if (inmueble['Estado']):
            lista.append(inmueble)
            venta += 1
    if venta == 0:
        return None
    return lista


#Función alquiler repetido.
def alquiler_rep(inmobiliaria):
    """Función que calcula el alquiler más repetido.

    Args:
        inmobiliaria (list): lista de viviendas

    Raises:
        ValueError: si algún dato es incorrecto.

    Returns:
        float: alguiler más repetido
    """
    if not(validacion_lista(inmobiliaria)):
        raise ValueError
    lista_alquiler = ver_alquiler(inmobiliaria)
    contadores = {}
    for dato in lista_alquiler:
        if not(dato['Precio'] in contadores):
            contadores[dato['Precio']] = 1
        else:
            contadores[dato['Precio']] += 1
    veces = list(contadores.values())
    masgrande = None
    for i in veces:
        if masgrande == None or i > masgrande:
            masgrande = i
    minimo = None
    for clave,valor in enumerate(contadores):
        if  minimo == None:
            minimo = clave
        elif valor == masgrande and clave < minimo:
            minimo = clave
    return minimo

#Función venta repetida.
def venta_rep(inmobiliaria):
    """Función que calcula el alquiler más repetido.

    Args:
        inmobiliaria (list): lista de viviendas

    Raises:
        ValueError: si algún dato es incorrecto.

    Returns:
        float: alguiler más repetido
    """
    if not(validacion_lista(inmobiliaria)):
        raise ValueError
    lista_venta = ver_venta(inmobiliaria)
    contadores = {}
    for dato in lista_venta:
        if not(dato['Precio'] in contadores):
            contadores[dato['Precio']] = 1
        else:
            contadores[dato['Precio']] += 1
    veces = list(contadores.values())
    masgrande = None
    for i in veces:
        if masgrande == None or i > masgrande:
            masgrande = i
    minimo = None
    for clave,valor in enumerate(contadores):
        if  minimo == None:
            minimo = clave
        elif valor == masgrande and clave < minimo:
            minimo = clave
    return minimo


#Inicializando variables.
inmobiliaria = []

#Estableciendo ejecución de programa según opción escogida.
while True:
        # Escogiendo el cambio que el usuario desea realizar.
        print("Elige una de las siguientes opciones:")
        print("\ta) Ingresar datos vivienda.")
        print("\tb) Eliminar datos vivienda.")
        print("\tc) Modificar estado de la vivienda.")
        print("\td) Mostrar vivivendas en alquiler.")
        print("\te) Ver el precio de alquiler más repetido.")
        print("\tf) Ver el precio de venta más repetido.")
        print("\tg) Salir.")
        opción = input("> ")
        opción.lower()
        if opción=='a':
            try:
                new_direccion=str(input("Introduzca la direccion: "))
                new_estado=int(input("Escoja el estado de su vivienda, 1(venta) o 2(alquiler): "))
                new_precio=float(input("Introduzca el precio: "))
                vivienda=datos_vivienda(new_direccion,new_estado,new_precio)
                inmobiliaria.append(vivienda)
                mostrar_inmobiliaria(inmobiliaria)
            except ValueError:
                print("Error. Entrada no válida.")
        elif opción=='b':
            try:
                mostrar_inmobiliaria(inmobiliaria)
                indice=int(input("Introduzca el índice correspondiente a la vivienda que desea eliminar: "))
                eliminar_datos(inmobiliaria,indice)
                mostrar_inmobiliaria(inmobiliaria)
            except ValueError:
                print("Error. Entrada no válida.")
        elif opción=='c':
            try:
                mostrar_inmobiliaria(inmobiliaria)
                indice=int(input("Introduzca el índice correspondiente a la vivienda cuyo estado desea modificar: "))
                modificar_inmobiliaria(indice,inmobiliaria)
                mostrar_inmobiliaria(inmobiliaria)
            except ValueError:
                print("Error. Entrada no válida.")
        elif opción=='d':
            try:
                if ver_alquiler(inmobiliaria) == None:
                    print("No hay viviendas en alquiler.")
                else:
                    viviendas_alquiler = ver_alquiler(inmobiliaria)
                    mostrar_inmobiliaria(viviendas_alquiler)
            except ValueError:
                print("Error. Entrada no válida.")
        elif opción=='e':
            try:
                alquiler_masrep = alquiler_rep(inmobiliaria)
                print(alquiler_masrep)
            except ValueError:
                print("Error. Entrada no válida.")
        elif opción=='f':
            try:
                venta_masrep = venta_rep(inmobiliaria)
                print(venta_masrep)
            except ValueError:
                print("Error. Entrada no válida.")
        elif opción=='g':
            break
        else:
            print("Error. Entrada no válida.")