package P01_Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Book implements Iterable<Book>  {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.authors = new ArrayList<>(Arrays.asList(authors));
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setAuthors(String... authors) {

    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public Iterator<Book> iterator() {
        return null;
    }


    public class  Library<Book> implements Iterable<Book> {
        private Book[] books;

        public Library(Book... books) {
            this.books = books;
        }


        @Override
        public Iterator<Book> iterator() {
            return new LibIterator();
        }
        public class LibIterator implements Iterator<Book>{

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Book next() {
                return null;
            }
        }
    }
}
