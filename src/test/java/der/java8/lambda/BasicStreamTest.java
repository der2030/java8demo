package der.java8.lambda;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.contains;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
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

    /**
     * get count numbers in the list
     */
    @Test
    public void streamCountTest(){
        List<String> names= Arrays.asList("derrick","lin","rose","mark","tim");
        long count=names.stream().count();
        assertThat(count,equalTo(5L));
    }

    /**
     * multiple each element by 3.0
     */
    @Test
    public void streamMapTest1(){
        List<Double> num=Arrays.asList(1.0,3.0,5.0,7.0,8.0,9.0);
        Function<Double,Double> multiple=n->n*3.0;

        List<Double> res=num.stream()
                .map(multiple)
                .collect(Collectors.toList());
        assertThat(res,contains(3.0,9.0,15.0,21.0,24.0,27.0));
    }

    /**
     * multiple each element by 3.0 and convert it to String
     */
    @Test
    public  void streamMapTest2(){
        List<Double> num=Arrays.asList(1.0,3.0,5.0,7.0,8.0,9.0);
        Function<Double,Double> multiple=n->n*3.0;
        Function<Double,String> convertToString=n->String.valueOf(n);
        List<String> res=num.stream()
                .map(multiple)
                .map(convertToString)
                .collect(Collectors.toList());
        assertThat(res,contains("3.0","9.0","15.0","21.0","24.0","27.0"));
    }

    /**
     * check if there is number which is greater than 20
     */
    @Test
    public void streamMatchTest1(){
        List<Integer> numList=Arrays.asList(17,23,6,11,7,5);
        boolean res=numList.stream()
                .anyMatch(num->num>20);
        assertThat(res,is(true));
    }

    /**
     * check if each element is pair
     */
    @Test
    public void streamMatchTest2(){
        List<Integer> numList=Arrays.asList(10,20,30,40,50,60);
        boolean res=numList.stream()
                .allMatch(num->num%2==0);
        assertThat(res,is(true));
    }

    /**
     * reduce the list of numbers
     */
    @Test
    public void streamReduceTest(){
        List<Integer> numList=Arrays.asList(10,20,30,40,50,60);
        Optional<Integer> res=numList.stream()
                .reduce((n1,n2)->n1+n2);

        assertThat(res.isPresent(),is(true));
        assertThat(res.get(),equalTo(210));
    }

}
