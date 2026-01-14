//Desafios filas

// 1. Implemente uma fila que gerencie o atendimento de clientes em um restaurante.
class FilaMercado {
    ordem: string[];
    constructor(){
        this.ordem = [];
    }
    queue(): void {
        console.log(this.ordem)
    }
    isEmpty(): boolean {
        return this.ordem.length == 0
    }
    enqueue(cliente: string): void {
        this.ordem.push(cliente)
        console.log(`O cliente ${cliente} entrou na fila` )
    }
    dequeue(): void {
        if (this.isEmpty() === true){
            console.log("Não há mais clientes na fila.")
        }
        else{
            console.log(`Bem-vindo ao LeParaiba! O que você deseja? Senhor(a) ${this.ordem[0]}`)
            console.log(`${this.ordem[0]} foi atendido!`)
            this.ordem.shift()
        }
    }
}
let restaurante = new FilaMercado()
restaurante.enqueue("Caio")
restaurante.enqueue("Gutzz")
restaurante.dequeue()
restaurante.dequeue()

// 2. Crie uma fila que armazene músicas em uma playlist e remova a música quando for tocada.
class playlistSpot extends FilaMercado{
    playlist: string[];

    constructor(){
        super()
        this.playlist = []
    }
    adicionarMusica(nome: string): void {
        this.playlist.push(nome)
        console.log(`Música ${nome} adicionado com sucesso`)
    }
    tocarMusica(): void {
        if (this.isEmpty() === true)
        {
            console.log("A playlist está vazia. Adicione uma música na fila")
        }
        console.log(`Tocando a música ${this.playlist[0]}`)
        this.playlist.shift()
    }
    isEmpty(): boolean {
        return this.playlist.length === 0;
    }
}
const Sequencia = new playlistSpot()
Sequencia.adicionarMusica("90210")
Sequencia.adicionarMusica("4x4")
Sequencia.adicionarMusica("AT THE PARTY")
Sequencia.tocarMusica()
Sequencia.tocarMusica()

// 4. Use uma fila para implementar um sistema de envio de mensagens em lote.

// 5. Crie uma fila que armazene processos pendentes e os execute na ordem de chegada.
class Processos extends FilaMercado{
    processos: string[];

    constructor(){
        super()
        this.processos = []
    }
    isEmpty(): boolean {
        return this.processos.length == 0;
    }
    novoProcesso(nome: string): void {
        this.processos.push(nome)
        console.log(`O processo ${nome} foi adicionado na fila`)
    }
    executarProcesso(): void {
        if (this.isEmpty() == true){
            console.log(`Todos processos já foram executados`)
        }
        else{
            console.log(`Executando o processo ${this.processos[0]}`)
            this.processos.shift()
            if (this.isEmpty() == false){
                let tamanho = this.processos.length
                console.log(`Ainda faltam ${tamanho} processo(s) para serem executados.`)
            }
        }
    }
}
const papelada = new Processos()
papelada.novoProcesso("Pog")
papelada.novoProcesso("Pog1")
papelada.novoProcesso("Pog2")
for (let i = 0; i < 3; i++) {
    papelada.executarProcesso()
}