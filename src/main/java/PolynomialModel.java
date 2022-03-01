import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class PolynomialModel {
    //to do make these private
    public Polynomial firstOperand;
    public Polynomial secondOperand;
    public Polynomial finalResult=new Polynomial();

    public void addOrSubtractPolynomials(char typeOfOp) {
        finalResult.getComponents().addAll(firstOperand.getComponents());
        finalResult.getComponents().addAll(secondOperand.getComponents());
        Collections.sort(finalResult.getComponents());
        Monomial previous=new Monomial(-1,0);
        ArrayList<Monomial> toBeRemoved = new ArrayList<>();
        for(Monomial z: finalResult.getComponents())
        {
            if(z.getDeg()==previous.getDeg())
            {   if(typeOfOp == '+')
                    previous.setCoeff(previous.getCoeff() + z.getCoeff());
                else if (typeOfOp == '-')
                    previous.setCoeff(previous.getCoeff() - z.getCoeff());
                toBeRemoved.add(z);
            }
            else
                previous=z;
        }
        for (Monomial z:toBeRemoved) {
            finalResult.getComponents().remove(z);
        }
    }
    public void addPolynomials(){addOrSubtractPolynomials('+');}
    public void subtractPolynomials(){addOrSubtractPolynomials('-');}

}








