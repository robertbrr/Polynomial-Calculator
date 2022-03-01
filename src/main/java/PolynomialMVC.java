import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolynomialMVC {
    public static void main(String[] args) {
        PolynomialModel pCalcModel = new PolynomialModel();
        PolynomialView pCalcView = new PolynomialView(pCalcModel);
        PolynomialController pCalcController = new PolynomialController(pCalcView,pCalcModel);
        pCalcView.setVisible(true);

        Polynomial x=new Polynomial();
        x.getComponents().add(new Monomial(5,4));
        x.getComponents().add(new Monomial(3,7));
        x.getComponents().add(new Monomial(1,12));

        Polynomial y=new Polynomial();
        y.getComponents().add(new Monomial(4,4));
        y.getComponents().add(new Monomial(3,6));
        y.getComponents().add(new Monomial(2,2));
        y.getComponents().add(new Monomial(2,-6));
        y.getComponents().add(new Monomial(0,11));

        Polynomial p = new Polynomial();
        try {
           p = new Polynomial("-x^2-3x^5+6");
        }
        catch(IncorrectInputException e){
            System.out.println("no");
        }
        System.out.println(p.printPolynomial());
        System.out.println(Integer.parseInt("x^55"));
       // pCalcModel.firstOperand=x;
       // pCalcModel.secondOperand=y;

        //pCalcModel.subtractPolynomials();
       // y.removeDuplicateMonomials();
       // for (Monomial t:y.getComponents()) {

        //    System.out.print((int)t.getCoeff()+"x^"+t.getDeg()+"+");
       // }
    }
}
