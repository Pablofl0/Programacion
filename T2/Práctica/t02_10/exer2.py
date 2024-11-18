#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
AS matrículas están compostas por dúas partes. A primeira consiste nun número decimal de 4 díxitos que se vai incrementando de 
un en un. CAndo se chega ao último valor 9999, reiniciase a conta en 0000 e incrementase a segunda parte, que contén letras.

A segunda parte consiste en 3 letras consecutivas, excluíndo as vogais e a letra Ñ. Cando, tras recorrer tódolos números, 
increméntase a letra, pasase a seguinte do alfabeto na letra situada máis a dereita, saltándose as vogais e a letra Ñ. 
Se se acaba o abecedario, vólvese ao principio Be incrementase a letra anterior con este mesmo procedemento.

Crea unha función seguinte_matricula(matricula: str) -> str que devolva a seguinte matrícula a que se pasa por valor. 
O formato da matrícula é o seguinte: 0000BBB. Se se recibe a última matrícula devolvese o valor None.
"""

__author__ = "Pablo Fernández Lamas"