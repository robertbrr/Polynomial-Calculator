import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PolynomialController {
    private PolynomialView pCalcView;
    private PolynomialModel pCalcModel;

    public PolynomialController(PolynomialView pCalcView, PolynomialModel pCalcModel) {
        this.pCalcView = pCalcView;
        this.pCalcModel = pCalcModel;

        pCalcView.addSelfValueInserterActionListener(new SelfValueInserter());
        pCalcView.addDeleteCharActionListener(new DeleteChar());
        pCalcView.addHighlightTextFieldFocusListener(new HighlightTextField());
        pCalcView.addPerformOperationActionListener(new PerformOperation());
        pCalcView.addPerformOperationForSingleOperandActionListener(new PerformOperationForSingleOperand());
        pCalcView.addClearFieldActionListener(new ClearField());
    }

    class SelfValueInserter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton sourceButton = (JButton)e.getSource();
            try {
                pCalcView.getFocusedTextFieldChecker().inputCheckerAndAdder(sourceButton.getText().charAt(0));
            } catch (NullPointerException exception){
                JOptionPane.showMessageDialog(sourceButton,"Please select a text field");
            }
        }
    }
    class PerformOperation implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton sourceButton = (JButton)e.getSource();
            try
            {
                pCalcModel.resetResult();
                switch(sourceButton.getText()){
                    case "ADD": pCalcModel.setResult(pCalcModel.addPolynomial(new Polynomial(pCalcView.getFirstOp()),new Polynomial(pCalcView.getSecondOp())));break;
                    case "SUBTRACT":pCalcModel.setResult(pCalcModel.subtractPolynomial(new Polynomial(pCalcView.getFirstOp()),new Polynomial(pCalcView.getSecondOp())));break;
                    case "MULTIPLY":pCalcModel.setResult(pCalcModel.multiplyPolynomial(new Polynomial(pCalcView.getFirstOp()),new Polynomial(pCalcView.getSecondOp())));break;
                    case "DIVIDE" :pCalcModel.setResult(pCalcModel.dividePolynomial(new Polynomial(pCalcView.getFirstOp()),new Polynomial(pCalcView.getSecondOp())));break;
                }
                pCalcView.setResult();
            }catch (IncorrectInputException excp) {
                JOptionPane.showMessageDialog(sourceButton, excp.getMessage());
                pCalcView.setErrorResult();
            }
        }
    }
    class DeleteChar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton sourceButton = (JButton)e.getSource();
            try {
                pCalcView.getFocusedTextFieldChecker().deleteLastCharFromField();
            } catch (NullPointerException exception){
                JOptionPane.showMessageDialog(sourceButton,"Please select a text field");
            }
        }
    }
    class ClearField implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton bttn = (JButton)e.getSource();
            try{
                pCalcView.getFocusedTextFieldChecker().clear();
            }catch (NullPointerException excp)
            {
                JOptionPane.showMessageDialog(bttn,"Please select a field!");
            }
        }
    }
    class PerformOperationForSingleOperand implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton sourceButton = (JButton)e.getSource();
            try
            {
                pCalcModel.resetResult();
                switch(sourceButton.getText()){
                    case "DERIVE": pCalcModel.setResult(pCalcModel.derivePolynomial(new Polynomial(pCalcView.getFirstOp())));break;
                    case "INTEGRATE": pCalcModel.setResult(pCalcModel.integratePolynomial(new Polynomial(pCalcView.getFirstOp())));break;
                }
                pCalcView.setResult();
            }catch (IncorrectInputException excp){
                JOptionPane.showMessageDialog(sourceButton,excp.getMessage());
                pCalcView.setErrorResult();
            }
        }
    }
    class HighlightTextField implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            JTextField textField = (JTextField)e.getSource();
            textField.setBorder(new LineBorder(Color.BLACK, 1));
        }
        @Override
        public void focusLost(FocusEvent e) {
            JTextField textField = (JTextField)e.getSource();
            textField.setBorder(new JTextField().getBorder());
        }
    }

}
