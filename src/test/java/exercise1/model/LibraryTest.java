package exercise1.model;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    @Test
    void testBooksListIsNotNull() {
        Library lib = new Library();
        assertNotNull(lib.getBooks());
    }

    @Test
    void testBooksListSizeAfterAddingBook() {
        Library lib = new Library();
        Book b1 = new Book("title1");
        Book b2 = new Book("title2");
        lib.addBook(b1);
        lib.addBook(b2);

        Book expected = b1;
        Book actual = lib.getBooks().get(0);

        assertEquals(expected, actual, "Book should be in position 0");
        assertEquals("title1", actual.getTitle(), "Title should match 'title1'");
    }

    @Test
    void testBookInCorrectPosition() {
        Library library = new Library();

        Book b1 = new Book("The Hobbit");
        Book b2 = new Book("Dune");

        library.addBook(b1);
        library.addBook(b2);

        Book firstBook = library.getBooks().get(0);
        assertEquals("The Hobbit", firstBook.getTitle(), "Expected 'The Hobbit' at position 0");


        Book secondBook = library.getBooks().get(1);
        assertEquals("Dune", secondBook.getTitle(), "Expected 'Dune' at position 1");
    }

    @Test
    void testNoDuplicateBookTitles() {
        Library library = new Library();
        Book b1 = new Book("The Hobbit");
        Book b2 = new Book("Dune");
        Book b3 = new Book("The Hobbit");

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        Set<String> titles = new HashSet<>();
        boolean hasDuplicate = false;
        for (Book book : library.getBooks()) {
            if (titles.contains(book.getTitle())) {
                hasDuplicate = true;
                break;
            }
        }
        assertFalse(hasDuplicate, "Book titles should be unique");
    }

    @Test
    void testGetBookTitleByPosition() {
        Library library = new Library();
        Book b1 = new Book("The Hobbit");
        Book b2 = new Book("Dune");
        library.addBook(b1);
        library.addBook(b2);
        Book bookPosition1 = library.getBooks().get(0);
        assertNotNull(bookPosition1, "Book at position 0 should not be null");
        assertEquals("The Hobbit", bookPosition1.getTitle(), "Title should match 'The Hobbit'");
    }

    @Test
    void testAddBookModifiesList() {
        Library library = new Library();
        Book newBook = new Book("The Sun");

        assertEquals(0, library.getBooks().size(), "Library should start empty");

        library.addBook(newBook);

        assertEquals(1, library.getBooks().size(), "Library should contain one book after adding");

        assertTrue(library.getBooks().contains(newBook), "The added book should be in the library");
    }

    @Test
    void testRemoveBookFromLibrary() {
        Library library = new Library();
        Book b1 = new Book("The Sun");
        Book b2 = new Book("Coffee");
        library.addBook(b1);
        library.addBook(b2);
        Book bookPosition1 = library.getBooks().get(0);
        library.removeBook(bookPosition1);
        assertEquals(1, library.getBooks().size(), "Library should contain one book after removing");
        assertFalse(library.getBooks().contains(bookPosition1), "The book should not be in the library");
    }

    @Test
    void testBooksAreAlphabeticallyOrdered() {
        Library library = new Library();

        library.addBook(new Book("Zelda"));
        library.addBook(new Book("Animal Farm"));
        library.addBook(new Book("Moby Dick"));


        library.getBooks().sort(Comparator.comparing(Book::getTitle));

        List<Book> books = library.getBooks();

        assertEquals("Animal Farm", books.get(0).getTitle());
        assertEquals("Moby Dick", books.get(1).getTitle());
        assertEquals("Zelda", books.get(2).getTitle());
    }

}