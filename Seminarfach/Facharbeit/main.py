import pandas as pd
import json
import numpy as np

with open('Kraftwerke.json', 'r') as file:
    data = json.load(file)

kraftwerke = pd.DataFrame([(kraftwerk['name'], kraftwerk['power'],
                              kraftwerk['company']) for kraftwerk in data["plants"]
                              if kraftwerk['country'] == 'KW-Land.Deutschland'],
                          columns = ['Name', 'Power', 'Company'])

print(kraftwerke)

kraftwerke.to_csv('Kraftwerke.csv')


blocks = pd.DataFrame(np.concatenate([
    [(block['commissioning'], block['power'], block['network'], kraftwerk['name'], kraftwerk['company'], block['status'] == 'KW-Status.in Betrieb') for block in kraftwerk['blocks']]
    for kraftwerk in data["plants"] if kraftwerk['country'] == 'KW-Land.Deutschland'
]),
columns = ['Commissioning', 'Power', 'Network', 'Name', 'Company', 'In Use']
)

print(blocks)


blocks.to_csv('Blocks.csv')