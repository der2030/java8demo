package der.java8.lambda;
import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.function.Predicate;

/**
* @FileName:PredicateTest
* @Description:
* @Author: Derrick Ye
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PredicateTest {

    /**
     * check that the string is larger than 10
     */
    @Test
    public void testPredicate1(){
        Predicate<String>  str=s->s.length()>10;
        boolean res=str.test("Java8 in action ");
        assertThat(res).isTrue();
    }

    /**
     * check that the string is larger than 10 and negate it
     */
    @Test
    public void testPredicate2(){
        Predicate<String>  str=s->s.length()>10;
        boolean res=str.negate().test("Java8 in action ");
        assertThat(res).isFalse();
    }

    /**
     * check that the string is larger than 10 and less than 20
     */
    @Test
    public void testPredicate3(){
        Predicate<String>  str1=s1->s1.length()>10;
        Predicate<String> str2=s2-> s2.length()<20;
        boolean res=str1.and(str2).test("java8 in action");
        assertThat(res).isTrue();
    }
}
