import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {
    private ArrayList<Book> books;
    private Scanner scanner;

    public LibraryApp() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;

        while (running) {
            printMenu();

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        printAllBooks();
                        break;
                    case 2:
                        addNewBook();
                        break;
                    case 3:
                        searchBooksByTitle();
                        break;
                    case 4:
                        borrowBook();
                        break;
                    case 5:
                        returnBook();
                        break;
                    case 6:
                        deleteBook();
                        break;
                    case 7:
                        System.out.println("\nThank you for using. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("\nInvalid choice! Please enter a number between 1 and 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input! Please enter a number.");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private void printMenu() {
        System.out.println("Welcome to Library App!");
        System.out.println("1. Print all books");
        System.out.println("2. Add new book");
        System.out.println("3. Search books by title");
        System.out.println("4. Borrow a book");
        System.out.println("5. Return a book");
        System.out.println("6. Delete a book by id");
        System.out.println("7. Quit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
    }

    private void printAllBooks() {
        System.out.println("\n--- All Books ---");
        if (books.isEmpty()) {
            System.out.println("No books in the library");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private void addNewBook() {
        System.out.println("\n--- Add New Book ---");

        try {
            System.out.print("Enter title: ");
            String title = scanner.nextLine();

            System.out.print("Enter author: ");
            String author = scanner.nextLine();

            System.out.print("Enter year: ");
            int year = Integer.parseInt(scanner.nextLine());

            Book newBook = new Book(title, author, year);
            books.add(newBook);

            System.out.println("\nBook successfully added!");
            System.out.println(newBook);
        } catch (NumberFormatException e) {
            System.out.println("\nError: Year must be a valid number!");
        } catch (IllegalArgumentException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }

    private void searchBooksByTitle() {
        System.out.println("\n--- Search Books by Title ---");
        System.out.print("Enter search term: ");
        String searchTerm = scanner.nextLine().toLowerCase();

        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchTerm)) {
                foundBooks.add(book);
            }
        }

        if (foundBooks.isEmpty()) {
            System.out.println("No books found matching: " + searchTerm);
        } else {
            System.out.println("\nFound " + foundBooks.size() + " book(s):");
            for (Book book : foundBooks) {
                System.out.println(book);
            }
        }
    }

    private void borrowBook() {
        System.out.println("\n--- Borrow a Book ---");

        try {
            System.out.print("Enter book id: ");
            int id = Integer.parseInt(scanner.nextLine());

            Book book = findBookById(id);

            if (book == null) {
                System.out.println("Error: Book with id " + id + " not found!");
            } else if (!book.isAvailable()) {
                System.out.println("Error: This book is already borrowed!");
            } else {
                book.markAsBorrowed();
                System.out.println("\nBook successfully borrowed!");
                System.out.println(book);
            }
        } catch (NumberFormatException e) {
            System.out.println("\nError: ID must be a valid number!");
        }
    }

    private void returnBook() {
        System.out.println("\n--- Return a Book ---");

        try {
            System.out.print("Enter book id: ");
            int id = Integer.parseInt(scanner.nextLine());

            Book book = findBookById(id);

            if (book == null) {
                System.out.println("Error: Book with id " + id + " not found!");
            } else if (book.isAvailable()) {
                System.out.println("Error: This book is not borrowed!");
            } else {
                book.markAsReturned();
                System.out.println("\nBook successfully returned!");
                System.out.println(book);
            }
        } catch (NumberFormatException e) {
            System.out.println("\nError: ID must be a valid number!");
        }
    }

    private void deleteBook() {
        System.out.println("\n--- Delete a Book ---");

        try {
            System.out.print("Enter book id: ");
            int id = Integer.parseInt(scanner.nextLine());

            Book book = findBookById(id);

            if (book == null) {
                System.out.println("Error: Book with id " + id + " not found!");
            } else {
                books.remove(book);
                System.out.println("\nBook successfully deleted!");
                System.out.println(book);
            }
        } catch (NumberFormatException e) {
            System.out.println("\nError: ID must be a valid number!");
        }
    }

    private Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LibraryApp app = new LibraryApp();
        app.run();
    }
}