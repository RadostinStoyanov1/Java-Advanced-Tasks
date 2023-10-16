package P20IteratorsAndComparators_Exercise.P03StackIterator;

import java.util.Iterator;

public class StackIterator implements Iterable<Integer> {
    private Integer[] elements;
    private int currentIndex;

    public StackIterator() {
        this.elements = new Integer[20];
        currentIndex = 0;
    }

    public void push(int element) {
        this.elements[this.currentIndex] = element;
        currentIndex++;
    }

    public Integer pop() {
        try {
            Integer element = this.elements[currentIndex - 1];
            this.elements[currentIndex - 1] = null;
            currentIndex--;
            return element;
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new IllegalStateException("No elements");
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<Integer> {
        private int index = currentIndex;
        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public Integer next() {
            return elements[--index];
        }
    }
}
