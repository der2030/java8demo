package der.java8.lambda;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
* @FileName:BasicStreamTest
* @Description:
* @Author: Derrick Ye
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BasicStreamTest {

    @Test
    public void basicStreamTest(){

        // generate String stream
        Stream<String> stream = Stream.of("Java 8", "Stream", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        // create 10 numbers
        Stream.iterate(0, n -> n + 3)
                .limit(10)
                .forEach(System.out::println);

        // create random stream of doubles
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);
        //calculate cofibonnaci
        IntSupplier fib = new IntSupplier(){
            private int previous = 0;
            private int current = 1;
            public int getAsInt(){
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return this.previous;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::println);

    }

    @Test
    public void getLowPriceBooknamesTest(){
        List<String> booknames=BasicStream.getLowPriceBooknames(Book.bookList);
        assertThat(booknames,notNullValue());
        booknames.forEach(bookname->System.out.println(bookname));
    }
}
