import javax.swing.*;

public class Monomial implements Comparable {
    private int deg;
    private double coeff;

    public Monomial(int deg, double coeff) {
        this.deg = deg;
        this.coeff = coeff;
    }
    public Monomial(String s) {
        if(!s.contains("x")){
            this.coeff=Double.parseDouble(s);
            this.deg = 0;
        }
        else
        {
            int xPosition = s.indexOf('x');
            String left = s.substring(0,xPosition);
            String right = new String();

            if(xPosition == s.length()-1) this.deg=1;
            else {
                right = s.substring(xPosition+2);
                this.deg = Integer.parseInt(right);
            }

            if(xPosition == 0)
                this.coeff=1;
            else{
                this.coeff = Double.parseDouble(left);
            }



        }
    }

    public int getDeg() {
        return deg;
    }

    //to do check if used in the end
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
        Monomial tmp=(Monomial) o;
        if(this.getDeg()>tmp.getDeg()) return -1;
        else if(this.getDeg()<tmp.getDeg()) return 1;
        return 0;
    }
}
