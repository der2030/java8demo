package der.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
* @FileName:BookFilter
* @Description:
* @Author: Derrick Ye
*/
public class BookFilter {

    public static List<Book> filterByBooks(List<Book> books,Predicate<Book> pBooks){
        List<Book> bookList=new ArrayList<>();
        for(Book book:books){
            if(pBooks.test(book))
                bookList.add(book);
        }
        return bookList;
    }
}
