package java.main.Arrays.dynamic;

public class DynamicArray {
    /** Problem:
     * Design a Dynamic Array (aka a resizable array) class, such as an ArrayList in Java or a vector in C++.
     * Your DynamicArray class should support the following operations:
     * DynamicArray(int capacity) will initialize an empty array with a capacity of capacity, where capacity > 0.
     * int get(int i) will return the element at index i. Assume that index i is valid.
     * void set(int i, int n) will set the element at index i to n. Assume that index i is valid.
     * void pushback(int n) will push the element n to the end of the array.
     * int popback() will pop and return the element at the end of the array. Assume that the array is non-empty.
     * void resize() will double the capacity of the array.
     * int getSize() will return the number of elements in the array.
     * int getCapacity() will return the capacity of the array.
     * If we call void pushback(int n) but the array is full, we should resize the array first.
     */
    private int[] array;
    private int capacity;
    private int size;

    public DynamicArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        this.size = 0;
        this.array = new int[capacity];
    }

    public int get(int i) {
        return this.array[i];
    }

    public void set(int i, int n) {
        this.array[i] = n;
    }

    public void pushback(int n) {
        if (size == capacity) {
            resize();
        }
        this.array[size] = n;
        size++;
    }

    public int popback() {
        size--;
        return this.array[size];
    }

    private void resize() {
        this.capacity *= 2;
        int[] newArray = new int[this.capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = this.array[i];
        }

        this.array = newArray;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
