import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PolynomialBuilderTest {

    @Test//adding same degree
    public void test1(){
        try {
            assertEquals("-X^2",new Polynomial("3X^2-4X^2").printPolynomial());
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
    }
    @Test//degree ordering
    public void test2(){
        try {
            assertEquals("-6X^7+7X^5-X^2",new Polynomial("-X^2+7X^5-6X^7").printPolynomial());
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
    }
    @Test//degree 0 elimination
    public void test3(){
        try {
            assertEquals("7X^3-4",new Polynomial("7X^3-4X^0").printPolynomial());
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
    }
    @Test//coeff 0 elimination
    public void test4(){
        try {
            assertEquals("4X^2",new Polynomial("4X^2-0X^3").printPolynomial());
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
    }
    @Test//hide 1 coefficient
    public void test5(){
        try {
            assertEquals("X^4-X^3",new Polynomial("1X^4-1X^3").printPolynomial());
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
    }

}
