package der.java8.lambda;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

/**
* @FileName:BookFilterTest
* @Description:
* @Author: Derrick Ye
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookFilterTest {

    @Test
    public void filterTest(){
        List<Book> bookList= Arrays.asList(new Book(1L,"Java in Action","Java",10,33.7),
                new Book(2L,"Springboot in Action","Java",5,103.9),
                new Book(3L,"SpringCloud in Action","Java",2,127.7),
                new Book(4L,"Jquery in Action","JavaScript",12,23.8),
                new Book(5L,"Angular in Action","JavaScript",10,51.6));


        List<Book> booksByCategory=BookFilter.filterByBooks(bookList,(Book b)->"Java".equals(b.getBookcategory()));
        assertThat(booksByCategory,notNullValue());
        booksByCategory.stream().forEach(book -> {
            System.out.println(book.getBookcategory()+":"+book.getBookname());
        });

        List<Book> booksByPrice=BookFilter.filterByBooks(bookList,(Book b)->b.getBookprice()>50);
        assertThat(booksByPrice,notNullValue());
        System.out.println("List all books that cost large than 50:");
        booksByPrice.stream().forEach(book -> {
            System.out.println(book.getBookname()+":"+book.getBookprice());
        });
    }

}
