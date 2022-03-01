import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private ArrayList<Monomial> components= new ArrayList<>();

    public Polynomial(ArrayList<Monomial> components) {
        this.components = components;
    }
    public Polynomial() {
        this.components = new ArrayList<>();
    }

    public Polynomial(String toExtract) throws IncorrectInputException{
        Pattern polyFinder = Pattern.compile("([+-]?\\d?[^-+]+)");
        Matcher polyMatcher = polyFinder.matcher(toExtract);
        while (polyMatcher.find()) {
            if(characterRepeats('x',polyMatcher.group(1)) == false && characterRepeats('^',polyMatcher.group(1)) == false){
                char lastElement=polyMatcher.group(1).charAt(polyMatcher.group(1).length()-1);
                if(lastElement == '^')
                    throw new IncorrectInputException("Expecting exponent!");
                else if(lastElement == '+' || lastElement == '-')
                    throw new IncorrectInputException("Expecting operand!");
                else
                    this.components.add(new Monomial(polyMatcher.group(1)));
            }
            else throw new IncorrectInputException("Invalid Input (Can't have expressions such as X^2X)!");
        }
    }
    public ArrayList<Monomial> getComponents() {
        return components;
    }

    //to do check if used in the end
    public void setComponents(ArrayList<Monomial> components) {
        this.components = components;
    }
    public int getDeg(){
        return this.components.get(0).getDeg();
    }
    public void removeDuplicateMonomials(){
        Monomial previous=new Monomial(-1,0);
        ArrayList<Monomial> toBeRemoved = new ArrayList<>();
        for(Monomial z: this.getComponents())
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
            this.getComponents().remove(z);
        }
    }
    public boolean characterRepeats(char x,String toCheck){
        int repetitionCounter=0;
        for (int i = 0; i < toCheck.length(); i++) {
            if(x == toCheck.charAt(i)) {
                repetitionCounter++;
                if(repetitionCounter >=2) return true;
            }

        }
        return false;
    }
    public String printPolynomial(){
        String toPrint =new String();
        for (Monomial e:this.components ) {
            System.out.println(e.getCoeff()+"x^"+e.getDeg());

        }
        return toPrint;
    }
}
