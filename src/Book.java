import java.time.Year;

public class Book {
    // Fields (private)
    private int id;
    private static int idGen = 1;
    private String title;
    private String author;
    private int year;
    private boolean available;

    // Default constructor
    public Book() {
        this.id = idGen++;
        this.available = true;
    }

    // Constructor with parameters
    public Book(String title, String author, int year) {
        this(); // calls default constructor
        setTitle(title);
        setAuthor(author);
        setYear(year);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }

    // Setters with validation
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title must not be null or empty");
        }
        this.title = title;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author must not be null or empty");
        }
        this.author = author;
    }

    public void setYear(int year) {
        int currentYear = Year.now().getValue();
        if (year < 1500 || year > currentYear) {
            throw new IllegalArgumentException("Year must be between 1500 and " + currentYear);
        }
        this.year = year;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Method to mark book as borrowed
    public void markAsBorrowed() {
        this.available = false;
    }

    // Method to mark book as returned
    public void markAsReturned() {
        this.available = true;
    }

    // Override toString()
    @Override
    public String toString() {
        String status = available ? "Available" : "Borrowed";
        return String.format("Book[id=%d, title='%s', author='%s', year=%d, status=%s]",
                id, title, author, year, status);
    }
}