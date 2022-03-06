import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PolynomialSubtractionTest {
    private PolynomialModel pCalcModel = new PolynomialModel();

    @Test//same deg
    public void test1(){
        try {
            assertEquals("-X^3+X^2-1",pCalcModel.subtractPolynomial(new Polynomial("X^2+X^3"),new Polynomial("2X^3+1")).printPolynomial());
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2(){
        try {
            assertEquals("-7",pCalcModel.subtractPolynomial(new Polynomial("X^0"),new Polynomial("8")).printPolynomial());
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
    }
    @Test//different deg
    public void test3(){
        try {
            assertEquals("X^7-X^3-5X^2+2X+2",pCalcModel.subtractPolynomial(new Polynomial("X^7+2X+2"),new Polynomial("X^3+5X^2")).printPolynomial());
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
    }
    @Test//subtraction with null
    public void test4(){
        try {
            assertEquals("X^2+15",pCalcModel.subtractPolynomial(new Polynomial("X^2+15"),new Polynomial("0")).printPolynomial());
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
    }
    @Test//subtraction from null
    public void test5(){
        try {
            assertEquals("-X^2-13",pCalcModel.subtractPolynomial(new Polynomial("0"),new Polynomial("X^2+13")).printPolynomial());
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
    }

    @Test//negative coefficients
    public void test6(){
        try {
            assertEquals("2X^4-8X-10",pCalcModel.subtractPolynomial(new Polynomial("2X^4-6X-2"),new Polynomial("2X+8")).printPolynomial());
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
    }
    @Test//negative coefficients
    public void test7(){
        try {
            assertEquals("11X^3+2X^2-12X-1",pCalcModel.subtractPolynomial(new Polynomial("11X^3-4X-1"),new Polynomial("-2X^2+8X")).printPolynomial());
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
    }



}
