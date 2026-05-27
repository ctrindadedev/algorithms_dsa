/* 
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1

 */

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1

Each element in the array appears twice except for one element which appears only once.
 */

//O que eu tinha pensado (Errado, pois aqui o crescimento é O(n))
function singleNumberOn(nums: number[]): number {
    const mapaFrequenciaNumbers = new Map<number, number>();

    for (let i = 0; i < nums.length; i++) {
        const numeroAtual = nums[i];

        if (mapaFrequenciaNumbers.has(numeroAtual)) {
            const contagemAtual = mapaFrequenciaNumbers.get(numeroAtual)!;
            mapaFrequenciaNumbers.set(numeroAtual, contagemAtual + 1);
        } else {
            mapaFrequenciaNumbers.set(numeroAtual, 1);
        }
    }

    // @ts-ignore
    for (const [chave, valor] of mapaFrequenciaNumbers) {
        if (valor === 1) {
            return chave;
        }
    }
    return 0;
}

//Solução correta (Operador XOR)
function singleNumberO1(nums: number[]): number {
        let resultado = 0;

        for (let i = 0; i < nums.length; i++) {
            resultado ^= nums[i];
        }

        return resultado;
    }

