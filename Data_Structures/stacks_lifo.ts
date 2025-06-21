//Desafios Pilhas

//Implemente uma pilha que gerencie o atendimento de clientes em um restaurante que atende primeiro quem chega por ultimo.
class FilaCliente{
    clientes: string[];

    constructor(){
        this.clientes = [];
    }
    push(nome: string): void {
        this.clientes.push(nome);
    }
    pop(): string | undefined {
        if (this.isEmpty() === true) {
            console.log("A fila de clientes está vazia!");
        }
        return this.clientes.pop();
    }
    peek(): void {
        if (this.isEmpty() === true)
        {
            console.log("Todos clientes já foram atendidos!");
        }
        else {
            console.log(`Agora está na vez do cliente ${this.clientes[this.clientes.length-1]}`);
        }
    }

    isEmpty(): boolean {
        return this.clientes.length === 0;
    }
}
const filaRestaurante = new FilaCliente();
filaRestaurante.push("Caio");
filaRestaurante.push("Augusto");
filaRestaurante.peek();
filaRestaurante.pop();
filaRestaurante.pop();
filaRestaurante.peek();
filaRestaurante.pop();

//Crie uma pilha que armazene músicas em uma playlist e remova a música quando for tocada.
class Playlist{
    playlist: string[];

    constructor(){
        this.playlist = [];
    }
    adicionar(musica: string): void {
        this.playlist.push(musica);
        console.log(`A música ${musica} foi adicionada e será tocada a seguir!`);
    }
    remover(): string | undefined {
        // CORRIGIDO: Chamada de método this.isEmpty()
        if(this.isEmpty() === true){
            console.log("Não há músicas na sequência.");
        }
        else{
            console.log(`A musica ${this.playlist[this.playlist.length-1]} foi removida da sequência.`);
            return this.playlist.pop();
        }
        return undefined;
    }
    tocar(): void {
        if (this.isEmpty() === true)
        {
            console.log("Todas as músicas já foram tocadas.");
        }
        else {
            console.log(`Tocando ${this.playlist[this.playlist.length-1]}! Aumenta o som!`);
            // Adicionado pop() aqui também para remover a música após tocar
            this.playlist.pop();
        }
    }
    isEmpty(): boolean {
        return this.playlist.length === 0;
    }
}
const hiphop = new Playlist();
hiphop.adicionar("Stuff");
hiphop.adicionar("NightFelas");
hiphop.adicionar("90210");
hiphop.adicionar("Like That");
hiphop.remover();
hiphop.tocar();
hiphop.tocar();
hiphop.tocar();
hiphop.tocar();

//Crie uma função que use uma pilha para verificar se uma string é um palíndromo.
class VerificadorDePalindromo {

    public verificar(palavra: string): void {
        const pilha: string[] = [];

        // Empurra cada caractere da palavra na pilha
        for (let i = 0; i < palavra.length; i++) {
            pilha.push(palavra[i]);
        }

        // Retira os caracteres da pilha para formar a palavra reversa
        let palavraReversa = "";
        while (pilha.length > 0) {
            palavraReversa += pilha.pop();
        }

        // Compara a palavra original com a reversa
        if (palavra === palavraReversa) {
            console.log(`A palavra "${palavra}" é um palíndromo.`);
        } else {
            console.log(`A palavra "${palavra}" não é um palíndromo.`);
        }
    }
}

const verificador = new VerificadorDePalindromo();
verificador.verificar("arara");
verificador.verificar("nini");
verificador.verificar("javascript");


//Escreva uma função que converta números decimais para binários usando pilhas.