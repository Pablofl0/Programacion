#!/usr/bin/env python
# -*- coding: utf-8 -*-

from flaskwebgui import FlaskUI
from flask import Flask
from flask import render_template


#TODO: Cargar ficheiro de datos JSON

# Creamos a aplicación de Flask
app = Flask(__name__)

# Metemos a ruta princial
@app.route("/")
def index_page():
    return render_template("index.html")


# Iniciamos a aplicación 
if __name__ == "__main__":
    # Creamos a aplicación de escritorio cunha ventá de 500x500
    FlaskUI(app=app, server="flask").run()