import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class PolynomialMultiplicationTest {
    private PolynomialModel pCalcModel = new PolynomialModel();

    @Test//Multiply by zero
    public void test1(){
        Polynomial firstOp = null;
        Polynomial secondOp = null;
        try {
            firstOp = new Polynomial("0");
            secondOp = new Polynomial("7X^2-7X+3");
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
        assertEquals("0",pCalcModel.multiplyPolynomial(firstOp,secondOp).printPolynomial());
    }
    @Test
    public void test2(){
        Polynomial firstOp = null;
        Polynomial secondOp = null;
        try {
            firstOp = new Polynomial("0");
            secondOp = new Polynomial("7X^2-7X+3");
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
        assertEquals("0",pCalcModel.multiplyPolynomial(secondOp,firstOp).printPolynomial());
    }
    @Test//scalar
    public void test3(){
        Polynomial firstOp = null;
        Polynomial secondOp = null;
        try {
            firstOp = new Polynomial("3");
            secondOp = new Polynomial("X^2-2X+3");
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
        assertEquals("3X^2-6X+9",pCalcModel.multiplyPolynomial(firstOp,secondOp).printPolynomial());
    }
    @Test//negative scalar reverse
    public void test4(){
        Polynomial firstOp = null;
        Polynomial secondOp = null;
        try {
            firstOp = new Polynomial("X^2-2X+3");
            secondOp = new Polynomial("-3");
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
        assertEquals("-3X^2+6X-9",pCalcModel.multiplyPolynomial(secondOp,firstOp).printPolynomial());
    }
    @Test//self multiply
    public void test5(){
        Polynomial firstOp = null;
        try {
            firstOp = new Polynomial("X-4");
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
        assertEquals("X^2-8X+16",pCalcModel.multiplyPolynomial(firstOp,firstOp).printPolynomial());
    }
    @Test//complex example
    public void test6(){
        Polynomial firstOp = null;
        Polynomial secondOp = null;
        try {
            firstOp = new Polynomial("2X^3+X+X^0");
            secondOp = new Polynomial("X^2-2X+3");
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
        assertEquals("2X^5-4X^4+7X^3-X^2+X+3",pCalcModel.multiplyPolynomial(firstOp,secondOp).printPolynomial());
    }
}
