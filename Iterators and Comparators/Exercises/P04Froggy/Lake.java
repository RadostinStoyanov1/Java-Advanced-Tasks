package P20IteratorsAndComparators_Exercise.P04Froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {

    private Integer[] elements;

    public Lake(Integer... elements) {
        this.elements = elements;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FrogIterator();
    }

    public Integer[] getElements() {
        return elements;
    }

    private class FrogIterator implements Iterator<Integer> {

        private int evenIndex = 0;
        private int oddIndex = 1;
        private int totalCount = 0;
        private int counter = 0;

        private int getIndex() {
            int limit = elements.length % 2 == 0 ? elements.length / 2 - 1: elements.length / 2;
            if (counter <= limit) {
                counter++;
                totalCount++;
                int index = evenIndex;
                evenIndex += 2;
                return index;
            }
            counter++;
            totalCount++;
            int index = oddIndex;
            oddIndex += 2;
            return index;
        }

        private int index;
        @Override
        public boolean hasNext() {
            return totalCount < elements.length;
        }

        @Override
        public Integer next() {
            return elements[this.getIndex()];
        }

    }
}
