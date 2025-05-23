//Receber um array de números
//Receber um target
//Definir o primeiro elemento do array como pivô
//Se elemento 1 + n elemento do array = target
//return
//Else
//definir o segundo elemento como pivô e percorrer apenas os elementos sucessores

//First Solution
function twoSum(nums: number[], target: number): number[] {
  for (let index: number = 0; index < nums.length; index++) {
    let solution: number[] = [];
    let pivo: number = nums[index];
    if (pivo + nums[index + 1] == target) {
      solution.push(index, index + 1);
      return solution;
    }
  }
}
