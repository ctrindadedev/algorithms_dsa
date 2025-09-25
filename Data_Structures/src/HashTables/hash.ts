
//Criação de uma Hastable propria, entendendo como funciona cada metódo
class HashTable {
  table: ([string, any][] | undefined)[];
  size: number;

  constructor() {
    this.table = new Array(127);
    this.size = 0;
  }

  _hash(key: string): number {
    let hash = 0;
    for (let i = 0; i < key.length; i++) {
      hash += key.charCodeAt(i);
    }
    return hash % this.table.length;
  }

  set(key: string, value: any): void {
    const index = this._hash(key);
    if (this.table[index]) {
      for (let i = 0; i < this.table[index]!.length; i++) {
        if (this.table[index]![i][0] === key) {
          this.table[index]![i][1] = value;
          return;
        }
      }
      this.table[index]!.push([key, value]);
    } else {
      this.table[index] = [];
      this.table[index]!.push([key, value]);
    }
    this.size++;
  }

  get(key: string): any {
    const index = this._hash(key);
    if (this.table[index]) {
      for (let i = 0; i < this.table.length; i++) {
        if (this.table[index]![i][0] === key) {
          return this.table[index]![i][1];
        }
      }
    }
    return undefined;
  }

  remove(key: string): boolean | undefined {
    const index = this._hash(key);

    if (this.table[index] && this.table[index]!.length) {
      for (let i = 0; i < this.table.length; i++) {
        if (this.table[index]![i][0] === key) {
          this.table[index]!.splice(i, 1);
          this.size--;
          return true;
        }
      }
    } else {
      return false;
    }
  }

  display(): void {
    this.table.forEach((values, index) => {
      const chainedValues = values!.map(
          ([key, value]) => `[ ${key}: ${value} ]`
      );
      console.log(`${index}: ${chainedValues}`);
    });
  }
}