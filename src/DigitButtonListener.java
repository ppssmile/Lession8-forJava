import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigitButtonListener implements ActionListener {
    private JTextField textField;

    public DigitButtonListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        StringBuffer sb = new StringBuffer(textField.getText());
        JButton jb = (JButton)e.getSource();
        sb.append(jb.getText());
        textField.setText(sb.toString());
    }
}
