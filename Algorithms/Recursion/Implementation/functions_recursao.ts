//Função recursiva que conte de `n` até 0.
function contador(n: number): string {
  if (n === 0) {
    //Caso Base
    return "Fim da contagem";
  }
  console.log(n);
  return contador(n - 1);
}
console.log(contador(10));

//Implemente uma função que calcule o fatorial de um número.
function fatorial(n: number): number {
  if (n === 1) {
    // Essa é a condição de parada da recursão, conhecida como caso base.
    return 1;
  }
  return n * fatorial(n - 1); //Essa é a recursão, a função retorna o valor de n multiplicado pelo fatorial de (n - 1). Então ela chama a si mesma com um valor menor (n - 1).
}
console.log(fatorial(8));

//Implemente uma função que calcule o n-ésimo termo da sequência de Fibonacci.
function Fibonacci(n: number): number {
  if (n <= 1) {
    return n;
  }
  return Fibonacci(n - 1) + Fibonacci(n - 2);
}
console.log(Fibonacci(8)); //Saída será o elemento que corresponde a um fibonacci de 8 elementos

//Crie uma função que some todos os números de um array usando recursão.
//o primeiro elemento do array (array[0]) é somado ao resultado da soma do restante do array, obtido com array.slice(1), que remove o primeiro elemento.
function somaArray(array: number[]): number {
  if (array.length === 0) return 0; // Caso base
  return array[0] + somaArray(array.slice(1)); // Chamada recursiva
  //A lógica do slice é a mesma da função do palindromo, já que slice(1) irá retornar o array começando a partir do indice 1
  //Soma os elementos de trás para frente
}

//Escreva uma função para verificar se uma palavra é um palíndromo usando recursão.
function Palindromo(palavra: string): string {
  //Recomposição:   Concatena da direita para a esquerda
  if (palavra === "") {
    return "";
  }
  //palavra.slice(1) retorna a string sem o primeiro caractere, começando do índice 1 até o final. No retorno, ela soma o primeiro caractere atual (palavra[0]) ao resultado da chamada recursiva.
  return Palindromo(palavra.slice(1)) + palavra[0];
}
function ehpalindromo(palavra: string, Palindromo: string): string {
  if (palavra === Palindromo) {
    return `A palavra ${palavra} é um palindromo`;
  }
  return `A palavra ${palavra} não é um palindromo`;
}
console.log(ehpalindromo("ana", Palindromo("ana")));