#!/usr/bin/env python
# -*- coding: utf-8 -*-

import json
from flaskwebgui import FlaskUI
from flask import Flask
from flask import render_template
import os
os.environ["MOZ_ENABLE_WAYLAND"] = "0"



#TODO: Cargar ficheiro de datos JSON

# Cargar o ficheiro de datos JSON antes de crear a aplicación Flask
with open("mobiles_dataset.json", "r") as f:
    data = json.load(f)


# Creamos a aplicación de Flask
app = Flask(__name__)

# Metemos a ruta princial
@app.route("/")
def index_page():
    return render_template("index.html",data=data)


# Iniciamos a aplicación 
if __name__ == "__main__":
    # Creamos a aplicación de escritorio cunha ventá de 500x500
    FlaskUI(app=app, server="flask", browser_path="firefox").run()
