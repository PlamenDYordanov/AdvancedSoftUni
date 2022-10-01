package P04_BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book bookOne, Book bookTwo) {
        int result = bookOne.getTitle().compareTo(bookTwo.getTitle());
        if (result == 0){
            result = Integer.compare(bookOne.getYear(), bookTwo.getYear());
        }
        return result;
    }
}
