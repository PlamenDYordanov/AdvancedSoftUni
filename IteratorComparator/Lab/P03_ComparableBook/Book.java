package P03_ComparableBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Book implements Comparable<Book>  {
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
    public int compareTo(Book book) {
        int result = this.getTitle().compareTo(book.getTitle());
        if (result == 0){
            result = Integer.compare(this.getYear(), book.getYear());
        }
        return result;

    }

}
