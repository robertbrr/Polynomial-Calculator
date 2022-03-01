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
