package exercise1;

import exercise1.model.Book;
import exercise1.model.Library;

public class Main {
    public static void main(String[] args) {

        Library bookCollection = new Library();

        Book b1 = new Book("Mimic");
        Book b2 = new Book("The Sun");
        Book b3 = new Book("Coffee");

        bookCollection.addBook(b1);
        bookCollection.addBook(b2);
        bookCollection.addBook(b3);

        System.out.println("Displaying Book List\n" + bookCollection.getBooks());

        bookCollection.removeBook(b1);
        System.out.println("Displaying with remove item\n" + bookCollection.getBooks());

        bookCollection.addBookByIndex(0,b1);
        System.out.println("Displaying with added by index\n" + bookCollection.getBooks());

        bookCollection.removeByTitle("The Sun");
        System.out.println("Displaying with remove by title\n" + bookCollection.getBooks());

    }
}
