package P19IteratorsAndComparators.P02Library;

import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        //нова библиотека
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibraryIterator();
    }

    //Създаваме private class, който да имплементира итератор обхождащ книги(<Book>)
    private class LibraryIterator implements Iterator<Book> {
        private int count = 0;
        @Override
        public boolean hasNext() {
            return count < books.length;
        }

        @Override
        public Book next() {
            return books[count++];
        }
    }
}
