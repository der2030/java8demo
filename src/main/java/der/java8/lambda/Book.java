package der.java8.lambda;
/**
* @FileName:Book
* @Description:
* @Author: Derrick Ye
*/
public class Book {

    private Long id;
    private String bookname;
    private String bookcategory;
    private int bookstock;
    private double bookprice;

    public Book(Long id, String bookname, String bookcategory, int bookstock, double bookprice) {
        this.id = id;
        this.bookname = bookname;
        this.bookcategory = bookcategory;
        this.bookstock = bookstock;
        this.bookprice = bookprice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookcategory() {
        return bookcategory;
    }

    public void setBookcategory(String bookcategory) {
        this.bookcategory = bookcategory;
    }

    public int getBookstock() {
        return bookstock;
    }

    public void setBookstock(int bookstock) {
        this.bookstock = bookstock;
    }

    public double getBookprice() {
        return bookprice;
    }

    public void setBookprice(double bookprice) {
        this.bookprice = bookprice;
    }
}
