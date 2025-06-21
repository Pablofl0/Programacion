#!/usr/bin/env python
# -*- coding: utf-8 -*-

from flaskwebgui import FlaskUI
from flask import Flask
from flask import render_template, request
from itertools import islice
import csv
import json

def get_json_data():
    with open("mobiles_dataset.csv", "r") as arq_csv:
        lector = csv.DictReader(arq_csv)
        csv_filtrado = filter(lambda m: m["Launched Year"] == "2024", lector)
        csv_convertido = list(map(lambda c: {**c,
                                            "Launched Year": int(c["Launched Year"]),
                                            "RAM": float(c["RAM"].replace("GB", "")),
                                            "Mobile Weight": float(c["Mobile Weight"].replace("g", "")),
                                            "Battery Capacity": float(c["Battery Capacity"].replace("mAh", "").replace(",",".")),
                                            "Screen Size": float(c["Screen Size"].replace("inches", "").strip()),
                                            "Launched Price (USA)": float(c["Launched Price (USA)"].replace(",", "").split(" ")[1]),
                                            "Launched Price (UE)": float(c["Launched Price (USA)"].replace(",", "").split(" ")[1])*0.89
                                    },csv_filtrado))
        with open("mobiles_dataset.json", "w") as arq_json:
            json.dump(csv_convertido, arq_json, indent=4, ensure_ascii=False)
    return csv_convertido

datos_dict = get_json_data()

# Creamos a aplicación de Flask
app = Flask(__name__, template_folder='./templates')
paxina=1
# Metemos a ruta princial
@app.route("/")
def index_page():
    parametros_get = request.args
    if "paxina" in parametros_get:
        paxina = int(parametros_get["paxina"])
    else:
        paxina = 1
    return render_template("index.html", datos=datos_dict, paxina=paxina, n_paxinas=int(len(datos_dict)/10), islice=islice)

@app.route("/peso/")
def por_peso():
    parametros_get = request.args
    if "paxina" in parametros_get:
        paxina = int(parametros_get["paxina"])
    else:
        paxina = 1
    return render_template("index.html", datos=sorted(datos_dict, key=lambda x: x["Mobile Weight"], reverse=True), paxina=paxina, n_paxinas=int(len(datos_dict)/10), islice=islice)

@app.route("/prezo/")
def por_prezo():
    parametros_get = request.args
    if "paxina" in parametros_get:
        paxina = int(parametros_get["paxina"])
    else:
        paxina = 1
    return render_template("index.html", datos=sorted(datos_dict, key=lambda x: x["Launched Price (UE)"], reverse=True), paxina=paxina, n_paxinas=int(len(datos_dict)/10), islice=islice)


# Iniciamos a aplicación 
if __name__ == "__main__":
    # Creamos a aplicación de escritorio cunha ventá de 500x500
    FlaskUI(app=app, server="flask").run()
