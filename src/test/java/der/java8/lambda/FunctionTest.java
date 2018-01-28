package der.java8.lambda;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
* @FileName:BasicLambdaTest
* @Description:
* @Author: Derrick Ye
*/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FunctionTest {

    /**
     * convert number as string to Integer
     * @throws Exception
     */
    @Test
    public void testFunction1()throws Exception{
        Function<String, Integer> convertToInteger = data -> Integer.valueOf(data);
        Integer num = convertToInteger.apply("77");
        assertThat(num).isEqualTo(77);
    }

    /**
     * convert number as String to Integer and multiple it
     * @throws Exception
     */
    @Test
    public void testFunction2() throws Exception{
        Function<String,Integer> convertToInteger=data->Integer.valueOf(data);
        Function<Integer,Integer> multiple=num->num*10;
        Integer result=convertToInteger.andThen(multiple).apply("7");
        assertThat(result).isEqualTo(70);
    }

}
