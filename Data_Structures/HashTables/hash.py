# Py usa {} para implementar uma tabela hash

listaTelefonica = {}
listaTelefonica["caio"] = 911
listaTelefonica["pedro"] = 190
print(listaTelefonica)

voted = {}
def jaVotou(nome):
    if voted.get(nome):
        print("Já votou!")
    else:
        voted[nome] = True
        print("Pode votar!")
jaVotou("caio")
jaVotou("caio")

