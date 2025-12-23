public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1: Rectangle ");
        Rectangle rect1 = new Rectangle();
        Rectangle rect2 = new Rectangle(5.5, 3.2);

        System.out.println(rect1);
        System.out.println(rect2);
        System.out.println("Area: " + rect2.area());
        System.out.println("Perimeter: " + rect2.perimeter());

        try {
            Rectangle invalid = new Rectangle(-5, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation works: " + e.getMessage());
        }

        System.out.println("\n Task 2: Book ");
        Book book1 = new Book("1984", "George Orwell", 1949);
        Book book2 = new Book("Harry Potter", "J.K. Rowling", 1997);

        System.out.println(book1);
        System.out.println(book2);

        book1.markAsBorrowed();
        System.out.println("After borrow: " + book1);

        book1.markAsReturned();
        System.out.println("After return: " + book1);
        try {
            Book invalid = new Book("", "Author", 2000);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation works: " + e.getMessage());
        }
    }
}