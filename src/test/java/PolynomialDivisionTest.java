import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PolynomialDivisionTest {
    private PolynomialModel pCalcModel = new PolynomialModel();

    @Test//Denominator is zero
    public void test1(){
        Polynomial firstOp;
        Polynomial secondOp;
        try {
            firstOp = new Polynomial("0");
            secondOp = new Polynomial("7X^2-7X+3");
            String result = pCalcModel.dividePolynomial(firstOp, secondOp).get(0).printPolynomial();
            String rem = pCalcModel.dividePolynomial(firstOp, secondOp).get(1).printPolynomial();
            if (!rem.equals("0"))
                result+=" Rem: "+rem;
            assertEquals("0",result);
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
    }
    @Test//divide by scalar
    public void test2() {
        Polynomial firstOp;
        Polynomial secondOp;
        try {
            firstOp = new Polynomial("X^2-2X+3");
            secondOp = new Polynomial("3");
            String result = pCalcModel.dividePolynomial(firstOp, secondOp).get(0).printPolynomial();
            String rem = pCalcModel.dividePolynomial(firstOp, secondOp).get(1).printPolynomial();
            if (!rem.equals("0"))
                result+=" Rem: "+rem;
            assertEquals("0,33X^2-0,67X+1", result);
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
    }
    @Test//divide by scalar
    public void test3() {
        Polynomial firstOp;
        Polynomial secondOp;
        try {
            firstOp = new Polynomial("4X^2-2X+7");
            secondOp = new Polynomial("-2");
            String result = pCalcModel.dividePolynomial(firstOp, secondOp).get(0).printPolynomial();
            String rem = pCalcModel.dividePolynomial(firstOp, secondOp).get(1).printPolynomial();
            if (!rem.equals("0"))
                result+=" Rem: "+rem;
            assertEquals("-2X^2+X-3,50", result);
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
    }
    @Test//division with no remainder
    public void test4() {
        Polynomial firstOp;
        Polynomial secondOp;
        try {
            firstOp = new Polynomial("4X^2-4X+1");
            secondOp = new Polynomial("2X-1");
            String result = pCalcModel.dividePolynomial(firstOp, secondOp).get(0).printPolynomial();
            String rem = pCalcModel.dividePolynomial(firstOp, secondOp).get(1).printPolynomial();
            if (!rem.equals("0"))
                result+=" Rem: "+rem;
            assertEquals("2X-1", result);
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
    }
    @Test//division with no remainder
    public void test5() {
        Polynomial firstOp;
        Polynomial secondOp;
        try {
            firstOp = new Polynomial("6X^2-8X+2");
            secondOp = new Polynomial("2X-2");
            String result = pCalcModel.dividePolynomial(firstOp, secondOp).get(0).printPolynomial();
            String rem = pCalcModel.dividePolynomial(firstOp, secondOp).get(1).printPolynomial();
            if (!rem.equals("0"))
                result+=" Rem: "+rem;
            assertEquals("3X-1", result);
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
    }
    @Test//same degree
    public void test6() {
        Polynomial firstOp;
        Polynomial secondOp;
        try {
            firstOp = new Polynomial("6X^2-5X+1");
            secondOp = new Polynomial("2X^2-2");
            String result = pCalcModel.dividePolynomial(firstOp, secondOp).get(0).printPolynomial();
            String rem = pCalcModel.dividePolynomial(firstOp, secondOp).get(1).printPolynomial();
            if (!rem.equals("0"))
                result+=" Rem: "+rem;
            assertEquals("3 Rem: -5X+7", result);
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
    }
    @Test//division with X
    public void test7() {
        Polynomial firstOp;
        Polynomial secondOp;
        try {
            firstOp = new Polynomial("11X^2-3X+12");
            secondOp = new Polynomial("X");
            String result = pCalcModel.dividePolynomial(firstOp, secondOp).get(0).printPolynomial();
            String rem = pCalcModel.dividePolynomial(firstOp, secondOp).get(1).printPolynomial();
            if (!rem.equals("0"))
                result+=" Rem: "+rem;
            assertEquals("11X-3 Rem: 12", result);
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
    }


}
