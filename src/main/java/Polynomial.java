import java.util.ArrayList;

public class Polynomial {
    private ArrayList<Monomial> components;

    public Polynomial(ArrayList<Monomial> components) {
        this.components = components;
    }
    public Polynomial() {
        this.components = new ArrayList<Monomial>();
    }
    public ArrayList<Monomial> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<Monomial> components) {
        this.components = components;
    }
    public int getDeg(){
        return this.components.get(0).getDeg();
    }
}
