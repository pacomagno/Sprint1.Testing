package exercise1.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }
    public ArrayList<Book> getBooks() {
        return books;
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void removeBook(Book book) {
        books.remove(book);

    }
    public void removeByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                books.remove(book);
            }
        }
    }
    public void addBookByIndex(int index, Book book) {
        books.add(index, book);
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }
    private void sortBooks() {
        books.sort(Comparator.comparing(Book::getTitle));
    }

}

