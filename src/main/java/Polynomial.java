import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private ArrayList<Monomial> components = new ArrayList<>();

    public Polynomial() {
        this.components = new ArrayList<>();
    }

    public Polynomial(String toExtract) throws IncorrectInputException {
        if (toExtract.length() == 0) throw new IncorrectInputException("One of the operands is null!");
        Pattern polyExpressionExtractor = Pattern.compile("[+-]?\\d?X?[^-+]+");
        Matcher polyMonomialExceptionMatcher = polyExpressionExtractor.matcher(toExtract);
        while (polyMonomialExceptionMatcher.find()) {
            char lastElement = toExtract.charAt(toExtract.length()-1);
            if (lastElement == '^')
                throw new IncorrectInputException("Expecting exponent!");
            else if (lastElement == '+' || lastElement == '-')
                throw new IncorrectInputException("Expecting operand!");
            else
                this.components.add(new Monomial(polyMonomialExceptionMatcher.group()));
        }
        this.cleanUp();
        Collections.sort(this.getComponents());
        this.mergeDuplicateExponents();
    }

    public ArrayList<Monomial> getComponents() {
        return components;
    }
    public int getDeg() {
        for (Monomial e: components ) {
            if(e.getCoeff()!=0)
                return e.getDeg();
        }
        return -1;
    }
    public void mergeDuplicateExponents() {
        Monomial previous = new Monomial(-1, 0);
        ArrayList<Monomial> toBeRemoved = new ArrayList<>();
        for (Monomial z : this.getComponents()) {
            if (z.getDeg() == previous.getDeg()) {
                previous.setCoeff(previous.getCoeff() + z.getCoeff());
                toBeRemoved.add(z);
            } else
                previous = z;
        }
        for (Monomial z : toBeRemoved) {
            this.getComponents().remove(z);
        }
    }
    public Polynomial negate() {
        Polynomial r = new Polynomial();
        for (Monomial e : this.components) {
            r.getComponents().add(new Monomial(e.getDeg(), -e.getCoeff()));
        }
        return r;
    }
    public void cleanUp(){
        ArrayList<Monomial> toBeRemoved = new ArrayList<>();
        for (Monomial e: components) {
            if(e.getCoeff() == 0)
                toBeRemoved.add(e);
        }
        components.removeAll(toBeRemoved);
    }
    public String printPolynomial() {
        String toPrint = new String();
        for (Monomial e : this.components) {
            toPrint += e.print();
        }
        if (toPrint.length() == 0)
            toPrint = "0";
        if (toPrint.charAt(0) == '+')
        return
                toPrint.substring(1);
        else
            return toPrint;
    }
}
