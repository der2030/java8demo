package der.java8.lambda;

import java.util.Arrays;
import java.util.List;

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
    private boolean special;

    public Book(Long id, String bookname, String bookcategory, int bookstock, double bookprice, boolean special) {
        this.id = id;
        this.bookname = bookname;
        this.bookcategory = bookcategory;
        this.bookstock = bookstock;
        this.bookprice = bookprice;
        this.special = special;
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

    public boolean isSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }


    public static final List<Book> bookList= Arrays.asList(new Book(1L,"Java in Action","Java",10,33.7,false),
            new Book(2L,"Springboot in Action","Java",5,103.9,true),
            new Book(3L,"SpringCloud in Action","Java",2,127.7,false),
            new Book(4L,"Jquery in Action","JavaScript",12,23.8,false),
            new Book(5L,"Angular in Action","JavaScript",10,51.6,true));


}
