# Importamos a librería
import csv
import json

# Abre o ficheiro CSV en modo lectura
with open('mobiles_dataset.csv') as arquivo_csv:
    # Crea un obxecto lector de CSV
    lector_csv = csv.DictReader(arquivo_csv)
    datos = list(lector_csv)

    # list(map(lambda x: int(x['Lauched Year']),lector_csv))

    datos = list(map(lambda d: {**d, 'Launched Year': int(d['Launched Year'])}, datos))
    datos = list(filter(lambda x: x["Launched Year"] == 2024,datos))
    datos = list(map(lambda d: {**d, 'RAM': float((d['RAM']).replace("GB", ""))},datos))
    datos = list(map(lambda d: {**d, 'Mobile Weight': float((d['Mobile Weight']).replace("g", ""))},datos))
    datos = list(map(lambda d: {**d, 'Battery Capacity': float((d['Battery Capacity']).replace("mAh", "").replace(",","."))},datos))
    datos = list(map(lambda d: {**d, 'Screen Size': float(((d['Screen Size']).replace("inches", "")))},datos))
    datos = list(map(lambda d: {**d, 'Launched Price (USA)': float(((d['Launched Price (USA)']).replace("USD", "")).replace(",","."))},datos))
    datos = list(map(lambda d: {**d, 'Launched Price (UE)': round((d['Launched Price (USA)'] * 0.90),2)},datos))


# Abre o ficheiro en modo escritura
with open('mobiles_dataset.json', 'w') as arquivo_json:
    # Escribimos o dicionario como un JSON no ficheiro
    json.dump(datos, arquivo_json)

# Abre o ficheiro en modo lectura
with open('mobiles_dataset.json', 'r') as arquivo_read_json:
    # Carga os datos do ficheiro JSON nun dicionario
    datos_read = json.load(arquivo_read_json)