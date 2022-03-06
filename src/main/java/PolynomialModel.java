import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class PolynomialModel {

    private Polynomial result=new Polynomial();
    private Polynomial rem = new Polynomial();


    public Polynomial addPolynomial(Polynomial firstOperand, Polynomial secondOperand) {
        Polynomial finalResult = new Polynomial();
        finalResult.getComponents().addAll(firstOperand.getComponents());
        finalResult.getComponents().addAll(secondOperand.getComponents());
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
        finalResult.getComponents().removeAll(toBeRemoved);
        finalResult.cleanUp();
        return finalResult;
    }

    public Polynomial subtractPolynomial(Polynomial firstOperand, Polynomial secondOperand){return addPolynomial(firstOperand,secondOperand.negate());}
    public Polynomial integratePolynomial(Polynomial firstOperand){
        Polynomial finalResult = new Polynomial();
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
        finalResult.cleanUp();
        finalResult.getComponents().add(new Monomial(-1,1));
        return finalResult;
    }
    public Polynomial derivePolynomial(Polynomial firstOperand){
        Polynomial finalResult = new Polynomial();
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
        finalResult.cleanUp();
        return finalResult;
    }
    public Polynomial multiplyPolynomial(Polynomial firstOperand,Polynomial secondOperand){
        Polynomial finalResult = new Polynomial();
        for (Monomial e: firstOperand.getComponents()) {
            for (Monomial f: secondOperand.getComponents()) {
                finalResult.getComponents().add(new Monomial(e.getDeg() + f.getDeg(), e.getCoeff() * f.getCoeff()));
            }
        }
        Collections.sort(finalResult.getComponents());
        finalResult.mergeDuplicateExponents();
        return finalResult;
    }
    public ArrayList<Polynomial> dividePolynomial(Polynomial firstOperand, Polynomial secondOperand) throws IncorrectInputException{
        Polynomial remainder;
        Polynomial finalResult=new Polynomial();
        if(secondOperand.printPolynomial().equals("0")) throw new IncorrectInputException("Can't divide by zero!!");
        int degDiff = firstOperand.getDeg()-secondOperand.getDeg();
        while(degDiff>=0 &&  (firstOperand.getDeg()!=-1) && (secondOperand.getDeg()!=-1)){
            double coeffDiff = firstOperand.getComponents().get(0).getCoeff()/secondOperand.getComponents().get(0).getCoeff();
            Polynomial auxPolynomial = new Polynomial();
            auxPolynomial.getComponents().add(new Monomial(degDiff,coeffDiff));
            finalResult.getComponents().add(new Monomial(degDiff,coeffDiff));
            firstOperand=subtractPolynomial(firstOperand,multiplyPolynomial(secondOperand,auxPolynomial));
            degDiff = firstOperand.getDeg()-secondOperand.getDeg();
        }
        remainder = firstOperand;
        ArrayList<Polynomial> listResults = new ArrayList<>();
        listResults.add(finalResult);
        listResults.add(remainder);
        return listResults;
    }
    public void resetResult(){
        this.result=new Polynomial();
        this.rem=new Polynomial();
    }

    public void setResult(Polynomial result){
        this.result=result;
    }

    public void setResult(ArrayList<Polynomial> result){
        this.result=result.get(0);
        this.rem = result.get(1);
    }

    public Polynomial getResult() {
        return result;
    }

    public Polynomial getRem() {
        return rem;
    }

}








