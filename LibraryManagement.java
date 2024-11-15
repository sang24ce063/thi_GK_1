import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagement {
    private ArrayList<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("Book List:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void addBook() {
        System.out.print("Enter book ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter book name: ");
        String name = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        System.out.print("Enter publisher name: ");
        String publisher = scanner.nextLine();

        books.add(new Book(id, name, author, publisher));
        System.out.println("Book added successfully.");
    }

    public void updateBookById() {
        System.out.print("Enter book ID to update: ");
        String id = scanner.nextLine();
        Book book = findBookById(id);

        if (book != null) {
            System.out.print("Enter new book name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new author name: ");
            String author = scanner.nextLine();
            System.out.print("Enter new publisher name: ");
            String publisher = scanner.nextLine();

            book.setName(name);
            book.setAuthor(author);
            book.setPublisher(publisher);
            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private Book findBookById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }
}
