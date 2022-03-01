import javax.swing.*;

public class Monomial implements Comparable {
    private int deg;
    private double coeff;

    public Monomial(int deg, double coeff) {
        this.deg = deg;
        this.coeff = coeff;
    }

    public Monomial(String s) throws IncorrectInputException {
        if (!s.contains("X")) {
            this.coeff = Double.parseDouble(s);
            this.deg = 0;
        } else {
            int xPosition = s.indexOf('X');
            String left = s.substring(0, xPosition);
            String right = new String();
            if (xPosition == s.length() - 1) this.deg = 1;
            else {
                try {
                    right = s.substring(xPosition + 2);
                    this.deg = Integer.parseInt(right);
                } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                    throw new IncorrectInputException("Bad exponent input!");
                }
            }
            if (xPosition == 0) this.coeff = 1;
            else {
                if (s.charAt(0) == '-' && xPosition == 1) this.coeff = -1;
                else if (s.charAt(0) == '+' && xPosition == 1) this.coeff = 1;
                else {
                    try {
                        this.coeff = Double.parseDouble(left);
                    } catch (NumberFormatException e) {
                        throw new IncorrectInputException("Bad coefficient input!");
                    }
                }
            }
        }
    }

    public int getDeg() {
        return deg;
    }
    public void setDeg(int deg) {
        this.deg = deg;
    }
    public double getCoeff() {
        return coeff;
    }
    public void setCoeff(double coeff) {
        this.coeff = coeff;
    }
    @Override
    public int compareTo(Object o) {
        Monomial tmp = (Monomial) o;
        if (this.deg > tmp.deg)
            return -1;
        else if (this.deg < tmp.deg)
            return 1;
        return 0;
    }
    public String print() {
        String r = "";
        String coeffString = "";
        if (coeff != 0) {
            if(coeff>0) coeffString="+";
            coeffString+=String.format("%.2f",coeff);
            if (deg == 0) r += coeffString;
            else if (deg == 1) r = r + coeffString + "X";
            else r = r + coeffString + "X^" + this.deg;
        }
        r=r.replaceAll(",00","");
        r=r.replaceAll("1X","X");
        return r;
    }
}
