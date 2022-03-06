public class PolynomialMVC {
    public static void main(String[] args){
        PolynomialModel pCalcModel = new PolynomialModel();
        PolynomialView pCalcView = new PolynomialView(pCalcModel);
        PolynomialController pCalcController = new PolynomialController(pCalcView,pCalcModel);
        pCalcView.setVisible(true);
    }
}
