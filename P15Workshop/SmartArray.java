package P15Workshop;

import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 4; //constant
    private int[] data; //the array where we will store elements
    private int size; //the number of really added elements
    private int capacity; //the current capacity of the array "data"

    public SmartArray() {
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    public void add(int element) {
        if (this.size == this.capacity) {
            resize();
        }
        this.data[this.size] = element;
        this.size++;
    }

    private void resize() {
        this.capacity *= 2;
        int[] copyArray = new int[this.capacity];
        for (int i = 0; i < data.length; i++) {
            copyArray[i] = this.data[i];
        }
        this.data = copyArray;
    }

    public int get(int index) {
        checkIndex(index);
        return this.data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException(
            String.format("Ehooo, Index %d is out of bounds for length %d", index, this.size));
        }
    }

    public int remove(int index) {
        checkIndex(index);
        int element = this.data[index];
        shiftLeft(index);
        this.size--;
        if (this.size <= this.capacity / 4) {
            shrink();
        }
        return element;
    }

    private void shrink() {
        this.capacity /= 2;
        int[] copyArr = new int[this.capacity];
        for (int i = 0; i < this.size; i++) {
            copyArr[i] = this.data[i];
        }
        this.data = copyArr;
    }

    private void shiftLeft(int index) {
        if (index != this.size - 1) {
            for (int i = index; i < this.size; i++) {
                this.data[i] = this.data[i + 1];
            }
        }
        this.data[this.size - 1] = 0;
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void add(int index, int element) {
        checkIndex(index);
        if (index == this.size - 1) {
            add(this.data[this.size - 1]);
            this.data[this.size - 2] = element;
        } else {
            if (this.size == this.capacity) {
                resize();
            } else {
                shiftRight(index);
                this.size++;
                this.data[index] = element;
            }
        }
    }

    private void shiftRight(int index) {
        for (int i = this.size; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }
}
