public class PolynomialModel {
    private Polynomial currentResult;

    public void addPolynomials(Polynomial toAdd) {
        Polynomial tempResult = new Polynomial();
        Polynomial biggerGrade = toAdd;
        Polynomial lowerGrade = currentResult;
        if (currentResult.getDeg() > toAdd.getDeg()) {
            biggerGrade = currentResult;
            lowerGrade = toAdd;
        }
        int prevDeg= biggerGrade.getDeg();
        boolean added;
        for (Monomial y : biggerGrade.getComponents()) {
            added=false;
            for (Monomial z : lowerGrade.getComponents()) {
                if (z.getDeg() == y.getDeg()) {
                    tempResult.getComponents().add(new Monomial(z.getDeg(), z.getCoeff() + y.getCoeff())); added=true;
                    break;
                } else if (z.getDeg() < y.getDeg()) {
                    tempResult.getComponents().add(new Monomial(y.getDeg(), y.getCoeff()));added=true;
                }
                else
                    if(z.getDeg()<prevDeg)
                        tempResult.getComponents().add(new Monomial(z.getDeg(), z.getCoeff()));added=true;
                }
            if(added==false)
                tempResult.getComponents().add(y);
            }
        currentResult=tempResult;
        }
    }





