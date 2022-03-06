import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class PolynomialDerivativeTest {
    private PolynomialModel pCalcModel = new PolynomialModel();


    @Test//derivative of zero
    public void test1(){
        Polynomial operand = null;
        try {
            operand = new Polynomial("0");
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
        assertEquals("0",pCalcModel.derivePolynomial(operand).printPolynomial());
    }
    @Test//pozitive constant derivative
    public void test2(){
        Polynomial operand = null;
        try {
            operand = new Polynomial("1");
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
        assertEquals("0",pCalcModel.derivePolynomial(operand).printPolynomial());
    }
    @Test//negative constant derivative
    public void test3(){
        Polynomial operand = null;
        try {
            operand = new Polynomial("-8");
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
        assertEquals("0",pCalcModel.derivePolynomial(operand).printPolynomial());
    }

    @Test//degree 1
    public void test4(){
        Polynomial operand = null;
        try {
            operand = new Polynomial("7X");
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
        assertEquals("7",pCalcModel.derivePolynomial(operand).printPolynomial());
    }
    @Test//complex test
    public void test5(){
        Polynomial operand = null;
        try {
            operand = new Polynomial("5X^5-3X^3-6X^2+2X-18");
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
        assertEquals("25X^4-9X^2-12X+2",pCalcModel.derivePolynomial(operand).printPolynomial());
    }
}
