import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class PolynomialIntegrationTest {
    private PolynomialModel pCalcModel = new PolynomialModel();


    @Test//Integral of zero
    public void test1(){
        Polynomial operand = null;
        try {
            operand = new Polynomial("0");
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
        assertEquals("C",pCalcModel.integratePolynomial(operand).printPolynomial());
    }
    @Test//Integral of positive constant
    public void test2(){
        Polynomial operand = null;
        try {
            operand = new Polynomial("1");
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
        assertEquals("X+C",pCalcModel.integratePolynomial(operand).printPolynomial());
    }
    @Test//Integral of negative constant
    public void test3(){
        Polynomial operand = null;
        try {
            operand = new Polynomial("-4");
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
        assertEquals("-4X+C",pCalcModel.integratePolynomial(operand).printPolynomial());
    }

    @Test//degree 1
    public void test4(){
        Polynomial operand = null;
        try {
            operand = new Polynomial("15X");
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
        assertEquals("7,50X^2+C",pCalcModel.integratePolynomial(operand).printPolynomial());
    }
    @Test//complex test
    public void test5(){
        Polynomial operand = null;
        try {
            operand = new Polynomial("10X^6+4X^3-X^2+5");
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
        assertEquals("1,43X^7+X^4-0,33X^3+5X+C",pCalcModel.integratePolynomial(operand).printPolynomial());
    }
}
