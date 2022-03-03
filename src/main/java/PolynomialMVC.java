import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolynomialMVC {
    public static void main(String[] args){
        PolynomialModel pCalcModel = new PolynomialModel();
        PolynomialView pCalcView = new PolynomialView(pCalcModel);
        PolynomialController pCalcController = new PolynomialController(pCalcView,pCalcModel);
        pCalcView.setVisible(true);
        try {
            pCalcModel.dividePolynomial(new Polynomial("X^2"), new Polynomial("X-1"));

        }catch (IncorrectInputException e) {
            System.out.println(" ");
        }
    }
}
