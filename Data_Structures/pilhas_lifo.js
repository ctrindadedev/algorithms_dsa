//Desafios Pilhas

//Implemente uma pilha que gerencie o atendimento de clientes em um restaurante que atende primeiro quem chega por ultimo.
class FilaCliente{
    constructor(){
        this.clientes = []
    }
push(nome){
    this.clientes.push(nome)
}
pop(){
    if (this.isEmpty() === true)
        console.log("A fila de clientes está vazia!")
    return this.clientes.pop()
}
peek(){
    if (this.isEmpty() === true)
    {
        console.log("Todos clientes já foram atendidos!")
    }
    else
    return console.log(`Agora está na vez do cliente ${this.clientes[this.clientes.length-1]}`)
}

isEmpty(){
    return this.clientes.length === 0;
}
}
const filaRestaurante = new FilaCliente
filaRestaurante.push("Caio")
filaRestaurante.push("Augusto")
filaRestaurante.peek()
filaRestaurante.pop()
filaRestaurante.pop()
filaRestaurante.peek()
filaRestaurante.pop()

//Crie uma pilha que armazene músicas em uma playlist e remova a música quando for tocada.
class Playlist{
    constructor(){
        this.playlist = []
    }
adicionar(musica){
    this.playlist.push(musica);
    console.log(`A música ${musica} foi adicionada e será tocada a seguir!`)
}
remover(){
    if(this.isEmpty === true){
        console.log("Não há músicas na sequência.")
    }
    else{
        console.log(`A musica ${this.playlist[this.playlist.length-1]} foi removida da sequência.`);
        return this.playlist.pop();
}
}
tocar(){
    if (this.isEmpty() === true)
    {
        console.log("Todas as músicas já foram tocadas.")
    }
    else
    console.log(`Tocando ${this.playlist[this.playlist.length-1]}! Aumenta o som!`)
    this.playlist.pop();

}
isEmpty(){
    return this.playlist.length === 0
}
}
const hiphop = new Playlist
hiphop.adicionar("Stuff")
hiphop.adicionar("NightFelas")
hiphop.adicionar("90210")
hiphop.adicionar("Like That")
hiphop.remover()
hiphop.tocar()
hiphop.tocar()
hiphop.tocar()
hiphop.tocar()

//Crie uma função que use uma pilha para verificar se uma string é um palíndromo.
class Reverse{
    constructor(){
        this.palavra = []
    }
reverterString(string){
    let inicial = string
    if (this.isEmpty === true){
        console.log("A string é inválida")
    }
    else
    for(let i=0; i<(string.length);i++){
        this.palavra.push(string[string.length-1-i])
}
    return this.palavra = this.palavra.join("")
}
verificadorPalindromo(string, string_contraria){
    string_contraria = this.palavra
    if (string_contraria === string){
        console.log(`A palavra ${string} é um palindromo`)
    }
    else{
        console.log(`A palavra ${string} não é um palindromo`)
    }

}
isEmpty(){
    return this.palavra.length === 0
}
}
let teste = new Reverse
inicial = "nini"
teste.reverterString(inicial)
console.log(teste.palavra)
teste.verificadorPalindromo(inicial)


//Escreva uma função que converta números decimais para binários usando pilhas.


