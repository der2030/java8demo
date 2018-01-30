package der.java8.lambda;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
* @FileName:SupplierTest
* @Description:
* @Author: Derrick Ye
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SupplierTest {

    /**
     * get the string using Supplier
     */
    @Test
    public void testSupplier1(){
        Supplier<String> str=()->"java8 in action";
        String res=str.get();
        assertThat(res).isEqualTo("java8 in action");
    }

    /**
     * get 20 ranom numbers which are larger than 30 using Supplier
     */
    @Test
    public void testSupplier2(){
        Supplier<Integer> num=()-> RandomNum.getNum();

        List<Integer> numList= Stream.generate(num)
                .filter(number->number>30)
                .limit(20)
                .collect(Collectors.toList());

        numList.forEach(n->System.out.println(n));

    }


}

class RandomNum{
    public static Integer getNum(){
        return new Random().nextInt(100);
    }
}
