package week6.assigment_problems;

public class BookInventory {

    String title;
    String author;
    int copiesAvailable;

    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    public void printEntry() {
        System.out.println(
            title + " | " + author + " | Copies: " + copiesAvailable
        );
    }

    public static void main(String[] args) {

        BookInventory[] books = {
            new BookInventory("Java Programming", "James Gosling", 10),
            new BookInventory("Data Structures", "Mark Allen", 7),
            new BookInventory("Operating Systems", "William Stallings", 5),
            new BookInventory("Computer Networks", "Andrew Tanenbaum", 8)
        };

        for (BookInventory book : books) {
            book.printEntry();
        }
    }
}