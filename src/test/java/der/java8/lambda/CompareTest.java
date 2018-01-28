package der.java8.lambda;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
* @FileName:CompareTest
* @Description:
* @Author: Derrick Ye
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CompareTest {


    /**
     * order the list of classmates by the lambda expression
     */

    @Test
    public void testCompare1()throws Exception{

        List<String> classmates= Arrays.asList("Derrick","Roy","Lily","Mike","Tony","Jim");
        Collections.sort(classmates,(String classmate1, String classmate2)->{
            return classmate1.compareTo(classmate2);
        });
        assertThat(classmates).contains("Derrick", "Jim", "Lily", "Mike", "Roy", "Tony");
        System.out.println(classmates);

    }

    /**
     * order the list of classmates without brace and return keyword
     */
    @Test
    public void testCompare2()throws Exception{
        List<String> classmates= Arrays.asList("Derrick","Roy","Lily","Mike","Tony","Jim");
        Collections.sort(classmates,(String classmate1,String classmate2)->classmate1.compareTo(classmate2));
        assertThat(classmates).contains("Derrick", "Jim", "Lily", "Mike", "Roy", "Tony");
        System.out.println(classmates);
    }

    /**
     * order the list of classmates without parameter type
     */
    @Test
    public void testCompare3()throws Exception{
        List<String> classmates= Arrays.asList("Derrick","Roy","Lily","Mike","Tony","Jim");
        Collections.sort(classmates,(classmate1,classmate2)->classmate1.compareTo(classmate2));
        assertThat(classmates).contains("Derrick", "Jim", "Lily", "Mike", "Roy", "Tony");
        System.out.println(classmates);
    }
}
