#!/usr/bin/env python
# -*- coding: utf-8 -*-

import json
from flaskwebgui import FlaskUI
from flask import Flask
from flask import render_template
from flask import request
from math import ceil
from itertools import islice
import os
os.environ["MOZ_ENABLE_WAYLAND"] = "0"



#TODO: Cargar ficheiro de datos JSON

# Cargar o ficheiro de datos JSON antes de crear a aplicación Flask
with open("mobiles_dataset.json", "r") as f:
    data = json.load(f)


# Creamos a aplicación de Flask
app = Flask(__name__, template_folder='./templates')

# Metemos a ruta princial
@app.route("/")
def index_page():
    #pagina_actual = request.args.get("pagina", default=1, type=int)
    # Collemos a páxina se se pasa por parámetro
    parametros_get = request.args
    if "paxina" in parametros_get:
        paxina = int(parametros_get["paxina"])
    else:
        paxina = 1

    #elementos_por_paxina = 10
    #datos_paxinados = list(islice(data, elementos_por_paxina))  # Selecciona os primeiros 10 elementos

    #return render_template("index.html", data=datos_paxinados)

    
    elementos_por_paxina = 10
    #pagina_actual = request.args.get("pagina", default=1, type=int)

    # Calcular número total de páxinas
    n_paxinas = ceil(len(data) / elementos_por_paxina)

    # Extraer os elementos para a páxina actual
    #inicio = (pagina_actual - 1) * elementos_por_paxina
    #fin = inicio + elementos_por_paxina
    #datos_paxinados = data[inicio:fin]
    
    return render_template("index.html",data=data, n_paxinas=n_paxinas, paxina=paxina, islice=islice)


# Iniciamos a aplicación 
if __name__ == "__main__":
    # Creamos a aplicación de escritorio cunha ventá de 500x500
    FlaskUI(app=app, server="flask").run()

