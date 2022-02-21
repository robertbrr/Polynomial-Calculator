public class Monomial {
    private int deg;
    private double coeff;

    public Monomial(int deg, double coeff) {
        this.deg = deg;
        this.coeff = coeff;
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

    public void setCoeff(int coeff) {
        this.coeff = coeff;
    }
}
