import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class PolynomialView extends JFrame {
    private PolynomialModel pCalcModel;

    private JTextField firstOpField = new JTextField(33);
    private JTextField secondOpField = new JTextField(33);
    private JTextField resultField = new JTextField(33);

    private JButton addB = new JButton("ADD");
    private JButton subtractB = new JButton("SUBTRACT");
    private JButton multiplyB = new JButton("MULTIPLY");
    private JButton divideB = new JButton("DIVIDE");
    private JButton deriveB = new JButton("DERIVE");
    private JButton integrateB = new JButton("INTEGRATE");

    private ArrayList<JButton> digitB = new ArrayList<>();//buttons with numbers 0-9
    private JButton variableB = new JButton("X");
    private JButton powerB = new JButton("^");
    private JButton plusB = new JButton("+");
    private JButton minusB = new JButton("-");
    private JButton deleteB = new JButton("del");
    private JButton clearB = new JButton("clear");

    private LiveInputVerifier firstOpChecker;
    private LiveInputVerifier secondOpChecker;

    PolynomialView(PolynomialModel pCalcModel){
        this.setSize(415,655);
        this.setResizable(false);
        this.pCalcModel=pCalcModel;

        firstOpChecker= new LiveInputVerifier(firstOpField);
        secondOpChecker = new LiveInputVerifier(secondOpField);

        digitB.add(new JButton("0"));
        digitB.add(new JButton("1"));
        digitB.add(new JButton("2"));
        digitB.add(new JButton("3"));
        digitB.add(new JButton("4"));
        digitB.add(new JButton("5"));
        digitB.add(new JButton("6"));
        digitB.add(new JButton("7"));
        digitB.add(new JButton("8"));
        digitB.add(new JButton("9"));

        //make keyboard buttons not focusable (in order to keep focus on text fields)
        for (JButton e: this.digitB)
            e.setFocusable(false);
        this.plusB.setFocusable(false);
        this.minusB.setFocusable(false);
        this.variableB.setFocusable(false);
        this.powerB.setFocusable(false);
        this.deleteB.setFocusable(false);
        this.clearB.setFocusable(false);
        this.addB.setFocusable(false);
        this.multiplyB.setFocusable(false);
        this.subtractB.setFocusable(false);
        this.integrateB.setFocusable(false);
        this.deriveB.setFocusable(false);

        //make fields non-editable from the regular keyboard
        firstOpField.setEditable(false);
        secondOpField.setEditable(false);
        resultField.setEditable(false);

        firstOpField.setPreferredSize(new Dimension(100,30));
        secondOpField.setPreferredSize(new Dimension(100,30));
        resultField.setPreferredSize(new Dimension(100,100));

        //the main panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout());
        contentPanel.add(new JLabel("First Operand: "));
        contentPanel.add(firstOpField);
        contentPanel.add(new JLabel("Second Operand: "));
        contentPanel.add(secondOpField);
        contentPanel.add(new JLabel("Result: "));
        contentPanel.add(resultField);

        //panel containing operations to be performed
        addB.setPreferredSize(new Dimension(100,50));
        JPanel operationPanel = new JPanel();
        operationPanel.setLayout(new GridLayout(2,3,4,4));
        operationPanel.add(addB);
        operationPanel.add(multiplyB);
        operationPanel.add(deriveB);
        operationPanel.add(subtractB);
        operationPanel.add(divideB);
        operationPanel.add(integrateB);
        contentPanel.add(operationPanel);

        //panel containing input buttons for the user
        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setSize(300,500);
        keyboardPanel.setLayout(new GridLayout(6,3,4,4));
        digitB.get(0).setPreferredSize(new Dimension(100,50));
        for (JButton e:this.digitB)
            keyboardPanel.add(e);
        keyboardPanel.add(variableB);
        keyboardPanel.add(powerB);
        keyboardPanel.add(plusB);
        keyboardPanel.add(minusB);
        keyboardPanel.add(deleteB);
        keyboardPanel.add(clearB);
        contentPanel.add(keyboardPanel);


        this.setContentPane(contentPanel);
        this.setTitle("Polynomial Calc");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public LiveInputVerifier getFocusedTextFieldChecker(){
        if (this.secondOpField.isFocusOwner())
            return this.secondOpChecker;
        else if (this.firstOpField.isFocusOwner())
            return this.firstOpChecker;
        else return null;
    }

    public void addSelfValueInserterActionListener(ActionListener actionListener){
        for (JButton e: this.digitB) {
            e.addActionListener(actionListener);
        }
        this.plusB.addActionListener(actionListener);
        this.minusB.addActionListener(actionListener);
        this.variableB.addActionListener(actionListener);
        this.powerB.addActionListener(actionListener);
    }

    public void addPerformOperationActionListener(ActionListener actionListener){
        this.addB.addActionListener(actionListener);
        this.subtractB.addActionListener(actionListener);
        this.multiplyB.addActionListener(actionListener);
        this.divideB.addActionListener(actionListener);
    }

    public void addPerformOperationForSingleOperandActionListener(ActionListener actionListener){
        this.integrateB.addActionListener(actionListener);
        this.deriveB.addActionListener(actionListener);
    }

    public void addDeleteCharActionListener(ActionListener actionListener){
        this.deleteB.addActionListener(actionListener);
    }
    public void addClearFieldActionListener(ActionListener actionListener){
        this.clearB.addActionListener(actionListener);
    }

    public void addHighlightTextFieldFocusListener(FocusListener focusListener){
        this.firstOpField.addFocusListener(focusListener);
        this.secondOpField.addFocusListener(focusListener);
    }

    public String getFirstOp() {
        return firstOpField.getText();
    }
    public String getSecondOp() {
        return secondOpField.getText();
    }
    public void setResult() {
        if(pCalcModel.getRem().printPolynomial().equals("0"))
            this.resultField.setText(pCalcModel.getResult().printPolynomial());
        else
            this.resultField.setText(pCalcModel.getResult().printPolynomial()+"  Rem: "+ pCalcModel.getRem().printPolynomial());
    }
    public void setErrorResult(){
        this.resultField.setText("Err");
    }
}
