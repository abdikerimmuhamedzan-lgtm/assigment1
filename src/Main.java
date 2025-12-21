public class Main {
    public static void main(String[] args) {
        System.out.println("  Assignment 1: Classes and Methods Demo  ");

        System.out.println(" TASK 1: Rectangle Class Demo");
        System.out.println("1. Default constructor:");
        Rectangle rect1 = new Rectangle();
        System.out.println("   " + rect1);

        System.out.println("\n2. Parameterized constructor (width=5.5, height=3.2):");
        Rectangle rect2 = new Rectangle(5.5, 3.2);
        System.out.println("   " + rect2);

        System.out.println("\n3. Testing setters (changing to width=10, height=7):");
        rect2.setWidth(10);
        rect2.setHeight(7);
        System.out.println("   " + rect2);

        System.out.println("\n4. Testing validation (trying negative width):");
        try {
            Rectangle invalidRect = new Rectangle(-5, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("   ✓ Exception caught: " + e.getMessage());
        }
        System.out.println("\n5. Multiple rectangles with unique IDs:");
        Rectangle rect3 = new Rectangle(2, 3);
        Rectangle rect4 = new Rectangle(8, 4);
        System.out.println("   " + rect3);
        System.out.println("   " + rect4);

        System.out.println("\n\nTASK 2: Book Class Demo");
        System.out.println("1. Creating books:");
        Book book1 = new Book("1984", "George Orwell", 1949);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);

        System.out.println("   " + book1);
        System.out.println("   " + book2);
        System.out.println("   " + book3);

        System.out.println("\n2. Borrowing a book (1984):");
        book1.markAsBorrowed();
        System.out.println("   " + book1);
        System.out.println("\n3. Returning the book:");
        book1.markAsReturned();
        System.out.println("   " + book1);
        System.out.println("\n4. Testing validation (empty title):");
        try {
            Book invalidBook = new Book("", "Author", 2000);
        } catch (IllegalArgumentException e) {
            System.out.println("   ✓ Exception caught: " + e.getMessage());
        }

        System.out.println("\n5. Testing validation (invalid year):");
        try {
            Book invalidBook = new Book("Book", "Author", 1400);
        } catch (IllegalArgumentException e) {
            System.out.println("   ✓ Exception caught: " + e.getMessage());
        }
        System.out.println("\n6. Testing getters:");
        System.out.println("   Book ID: " + book2.getId());
        System.out.println("   Title: " + book2.getTitle());
        System.out.println("   Author: " + book2.getAuthor());
        System.out.println("   Year: " + book2.getYear());
        System.out.println("   Available: " + book2.isAvailable());

        System.out.println("\n\n TASK 3: Library Application");
        System.out.println("Starting LibraryApp with interactive menu...\n");
        LibraryApp app = new LibraryApp();
        app.run();
    }
}