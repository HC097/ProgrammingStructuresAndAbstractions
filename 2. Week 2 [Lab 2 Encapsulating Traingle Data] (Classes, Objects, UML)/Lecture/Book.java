public class Book{//check out umlet tool

    private String title;
    private String author;
    private String isbn;

    public Book (String myAuthor, String myTitle, String myISBN) {
        this.author = myAuthor;
        this.title = myTitle;
        this.isbn = myISBN;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getISBN() {
        return this.isbn;
    }
}
