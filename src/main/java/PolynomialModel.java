import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class PolynomialModel {
    private Polynomial firstOperand;
    private Polynomial secondOperand;
    private Polynomial finalResult=new Polynomial();

    public void setFirstOperand(Polynomial firstOperand) {
        this.firstOperand = firstOperand;
    }
    public void setSecondOperand(Polynomial secondOperand) {
        this.secondOperand = secondOperand;
    }
    public void addOrSubtractPolynomials(char typeOfOp) {
        finalResult.getComponents().addAll(firstOperand.getComponents());
        Polynomial toAdd;
        if(typeOfOp == '+')
            toAdd = secondOperand;
        else
            toAdd = secondOperand.negate();
        finalResult.getComponents().addAll(toAdd.getComponents());
        Collections.sort(finalResult.getComponents());
        Monomial previous=new Monomial(-1,0);
        ArrayList<Monomial> toBeRemoved = new ArrayList<>();
        for(Monomial z: finalResult.getComponents())
        {
            if(z.getDeg()==previous.getDeg())
            {
                previous.setCoeff(previous.getCoeff() + z.getCoeff());
                toBeRemoved.add(z);
            }
            else
                previous=z;
        }
        for (Monomial z:toBeRemoved) {
            finalResult.getComponents().remove(z);
        }
    }
    public void addPolynomial(){addOrSubtractPolynomials('+');}
    public void subtractPolynomial(){addOrSubtractPolynomials('-');}
    public void integratePolynomial(){
       finalResult.getComponents().addAll(firstOperand.getComponents());
        for (Monomial e: finalResult.getComponents()) {
            if(e.getCoeff()!=0)
            {
                if(e.getDeg() == 0)
                    e.setDeg(1);
                else{
                    e.setDeg(e.getDeg()+1);
                    e.setCoeff(e.getCoeff()/(double)e.getDeg());
                }
            }
        }
    }
    public void derivePolynomial(){
        finalResult.getComponents().addAll(firstOperand.getComponents());
        for (Monomial e: finalResult.getComponents()) {
            if(e.getCoeff()!=0)
            {
                if(e.getDeg() == 0)
                    e.setCoeff(0);
                else{
                    e.setCoeff(e.getCoeff()*e.getDeg());
                    e.setDeg(e.getDeg()-1);
                }
            }
        }
    }
    public void multiplyPolynomial(){
        for (Monomial e: firstOperand.getComponents()) {
            for (Monomial f: secondOperand.getComponents()) {
                this.finalResult.getComponents().add(new Monomial(e.getDeg() + f.getDeg(), e.getCoeff() * f.getCoeff()));
            }
        }
        Collections.sort(this.finalResult.getComponents());
        this.finalResult.removeDuplicateMonomials();
    }
    public void dividePolynomial(){}
    public void resetResult(){
        this.finalResult=new Polynomial();
    }
    public String getResult(){
        return this.finalResult.printPolynomial();
    }
}








