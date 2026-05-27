//Solução correta (Operador XOR)
function singleNumberO1(nums: number[]): number {
    let resultado = 0;

    for (let i = 0; i < nums.length; i++) {
        resultado ^= nums[i];
    }

    return resultado;
}
