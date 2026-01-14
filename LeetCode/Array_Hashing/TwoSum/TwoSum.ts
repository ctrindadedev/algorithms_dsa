//Receber um array de números
//Receber um target
//Definir o primeiro elemento do array como pivô
//Se elemento 1 + n elemento do array = target
//return
//Else
//definir o segundo elemento como pivô e percorrer apenas os elementos sucessores

//First Solution
function twoSum(nums: number[], target: number): number[] {
  for (let i = 0; i < nums.length; i++) {
    for (let j = i + 1; j < nums.length; j++) {
      if (nums[j] === target - nums[i]) {
        return [i, j];
      }
    }
  }
  return [];
}

//Second Solution (Hash Table)
function twoSumHash(nums: number[], target: number): any[] {
  const map: Map<number, number> = new Map();
  for (let i = 0; i < nums.length; i++) {
    //Hashear o valor de cada indice
    map.set(nums[i], i);
  }
  for (let i = 0; i < nums.length; i++) {
    const complement = target - nums[i];
    if (map.has(complement) && map.get(complement) !== i) {
      return [i, map.get(complement)];
    }
  }
  return [];
}
