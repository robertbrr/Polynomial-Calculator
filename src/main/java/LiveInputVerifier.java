import javax.swing.*;

public class LiveInputVerifier {
    private JTextField textField;

    public LiveInputVerifier(JTextField textField) {
        this.textField = textField;
    }

    public void setField(char toBeAdded) {
        textField.setText(textField.getText() + toBeAdded);
    }

    public void inputCheckerAndAdder(char toBeAdded) {
        if (textField.getText().length() == 0) {
            if (Character.isDigit(toBeAdded) || toBeAdded == 'X' || toBeAdded == '-' || toBeAdded == '+')
                setField(toBeAdded);
        } else {
            char lastChar = textField.getText().charAt(textField.getText().length() - 1);
            if (lastChar == 'X') {
                if (toBeAdded == '^' || toBeAdded == '+' || toBeAdded == '-') {
                    setField(toBeAdded);
                }
            } else if (lastChar == '^') {
                if (Character.isDigit(toBeAdded)) {
                    setField(toBeAdded);
                }
            } else if (lastChar == '+' || lastChar == '-') {
                if (Character.isDigit(toBeAdded) || toBeAdded == 'X') {
                    setField(toBeAdded);
                }
            } else if (Character.isDigit(lastChar)) {
                if (toBeAdded != '^')
                    setField(toBeAdded);
            }
        }
    }

    public void deleteLastCharFromField(){
        if(textField.getText().length() != 0)
            textField.setText(textField.getText().substring(0,textField.getText().length()-1));
    }
    public void clear(){
        textField.setText("");
    }
}
