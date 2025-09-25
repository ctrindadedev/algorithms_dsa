//Grafos
//Grafos, uma estrutura de dados que pode parecer complicada à primeira vista, mas é incrivelmente poderosa e prática.

//Os grafos são usados para modelar relações e conexões. Eles aparecem em redes sociais, rotas de GPS, sistemas de recomendação e até no funcionamento da internet.

//Um **grafo** é uma coleção de **nós** (ou vértices) conectados por **arestas**. Essas conexões podem ser direcionadas ou não, e cada aresta pode ter um peso associado.

//Dicas Importantes
//Escolha a Representação Correta:
// Use lista de adjacência para grafos esparsos e matriz de adjacência para grafos densos
// Evite Loops Infinitos:
//Sempre acompanhe os nós visitados para evitar percorrer o mesmo nó repetidamente
//Aplique o Grafo em Problemas Reais:  
//Em rotas de GPS, redes sociais e algoritmos de recomendação.
//Exemplo no mundo real:
// Rede Social:Cada pessoa é um nó, e cada conexão (amizade) é uma aresta.
// Mapa de Rotas:Cada cidade é um nó, e as estradas entre elas são as arestas.

//Termos Importantes:
// Vértices (Nós):Os pontos do grafo.
// Arestas: As conexões entre os vértices.
// Grafo Direcionado: As arestas têm uma direção.
// Grafo Não Direcionado: As arestas são bidirecionais.


//Representar um Grafo no Código:
//Usando Lista de Adjacência
//É a forma mais comum de representar grafos. Cada nó tem uma lista de nós conectados a ele.
const grafo: { [key: number]: number[] } = {
  1: [2, 5],
  2: [1, 4, 3],
  3: [2, 4],
  4: [2, 3, 5, 6],
  5: [1, 4],
  6: [4]
};

//Usando Matriz de Adjacência:
//É uma matriz que indica quais nós estão conectados.
const matrizAdjacencia: number[][] = [
  [0, 1, 1, 0], // A
  [1, 0, 0, 1], // B
  [1, 0, 0, 1], // C
  [0, 1, 1, 0]  // D
];

console.log(matrizAdjacencia[0][1]); // Saída: 1 (A está conectado a B)

//Explorando um Grafo
//Busca em Profundidade (DFS - Depth First Search): Explora o máximo de profundidade antes de voltar.
function buscaEmProfundidade(grafo: { [key: number]: number[] }, no: number, visitados: Set<number> = new Set<number>()): void {
  if (visitados.has(no)) return;
  console.log(no);
  visitados.add(no);
  grafo[no].forEach(vizinho => buscaEmProfundidade(grafo, vizinho, visitados));
}

buscaEmProfundidade(grafo, 1);

//Busca em Largura (BFS - Breadth First Search):
//Explora todos os nós no mesmo nível antes de descer.
function buscaEmLargura(grafo: { [key: number]: number[] }, inicio: number): void {

  const visitados = new Set<number>();
  const fila: number[] = [inicio];

  while (fila.length > 0) {
    const no = fila.shift()!; // O '!' afirma que 'no' não será nulo, pois o loop garante que a fila não está vazia.
    if (!visitados.has(no)) {
      console.log(no);
      visitados.add(no);
      fila.push(...grafo[no]);
    }
  }
}

buscaEmLargura(grafo, 1);


//Rede Social:
// Simule conexões entre amigos:
const redeSocial: { [key: string]: string[] } = {
  Alice: ["Bob", "Carol"],
  Bob: ["Alice", "David"],
  Carol: ["Alice", "Eve"],
  David: ["Bob"],
  Eve: ["Carol"]
};

console.log(redeSocial["Alice"]); // Saída: ['Bob', 'Carol']

//Desafios