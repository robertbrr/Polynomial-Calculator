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
        for (Monomial y : biggerGrade.getComponents()) {
            for (Monomial z : lowerGrade.getComponents()) {
                if (z.getDeg() == y.getDeg()) {
                    tempResult.getComponents().add(new Monomial(z.getDeg(), z.getCoeff() + y.getCoeff()));
                    break;
                } else if (z.getDeg() < y.getDeg()) {
                    tempResult.getComponents().add(new Monomial(y.getDeg(), y.getCoeff()));
                }
                else
                    if(z.getDeg()<prevDeg)
                        tempResult.getComponents().add(new Monomial(z.getDeg(), z.getCoeff()));
                }

            }
        }
    }




