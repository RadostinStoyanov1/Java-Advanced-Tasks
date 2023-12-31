package P20IteratorsAndComparators_Exercise.P02Collection;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator<T> implements Iterable<T> {
    private List<T> elements;
    private int currentIndex;

    public ListyIterator(T... elements) {
        this.elements = List.of(elements);
        this.currentIndex = 0;
    }

    public boolean move() {
        if (hasNext()) {
            currentIndex++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        if (this.currentIndex < elements.size() - 1) {
            return true;
        }
        return false;
    }

    public void print() {
        if (this.elements.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(this.elements.get(this.currentIndex));
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        //Iterable.super.forEach(action);
        this.elements.forEach(action);
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator();
    }

    public class CustomIterator implements Iterator<T> {
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < elements.size();
        }

        @Override
        public T next() {
            return elements.get(index++);
        }
    }
}
