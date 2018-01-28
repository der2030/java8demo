package der.java8.lambda;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
* @FileName:DefaultMethodTest
* @Description:
* @Author: Derrick Ye
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DefaultMethodTest {

    /**
     * calculate long-term loan using LongTermLoanService
     * @throws Exception
     */
    @Test
    public void testLongTermLoan()throws Exception{
        LongTermLoanService ltls=new LongTermLoanService();
        double loan=10000;
        double finalLoan=ltls.calculateLoan(loan);
        assertThat(finalLoan).isEqualTo(10500);
        System.out.println(finalLoan);
    }

    /**
     * calculate short-term loan using ShortTermLoanService
     * @throws Exception
     */
    @Test
    public void testShortTermLoan()throws Exception{
        ShortTermLoanService stls=new ShortTermLoanService();
        double loan=10000;
        double finalLoan=stls.calculateLoan(loan);
        assertThat(finalLoan).isEqualTo(10800);
        System.out.println(finalLoan);
    }

}

interface LoanService{
    double interest();
    default double calculateLoan(double loan){
        return loan+(loan*interest());
    }
}

class LongTermLoanService implements LoanService{

    @Override
    public double interest() {
        return 0.05;
    }
}

class ShortTermLoanService implements LoanService{

    @Override
    public double interest() {
        return 0.08;
    }
}
