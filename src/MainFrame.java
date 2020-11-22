import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Calculate");
        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel jPanel1 = new JPanel() {
            public Dimension getPreferredSize() {
                return new Dimension(800, 80);
            }
        };

        add(jPanel1, BorderLayout.NORTH);
        jPanel1.setLayout(new BorderLayout());
        JTextField textField = new JTextField();
        DigitButtonListener controller = new DigitButtonListener(textField);
        jPanel1.add(textField, BorderLayout.CENTER);

        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new GridLayout(4, 5));
        add(jPanel2);
        JButton jButton;
        for (int i = 0; i < 3; i++) {
            jButton = new JButton(String.valueOf(7 + i));
            jButton.addActionListener(new DigitButtonListener(textField));
            jPanel2.add(jButton);
        }
        jButton = new JButton("-");
        jButton.addActionListener(new DigitButtonListener(textField));
        jPanel2.add(jButton);
        jButton = new JButton("C");
        jButton.addActionListener(new ClearButtonListener(textField));
        jPanel2.add(jButton);

        for (int i = 0; i < 3; i++) {
            jButton = new JButton(String.valueOf(4 + i));
            jButton.addActionListener(new DigitButtonListener(textField));
            jPanel2.add(jButton);
        }
        jButton = new JButton("+");
        jButton.addActionListener(new DigitButtonListener(textField));
        jPanel2.add(jButton);
        jButton = new JButton("(");
        jButton.addActionListener(new DigitButtonListener(textField));
        jPanel2.add(jButton);

        for (int i = 0; i < 3; i++) {
            jButton = new JButton(String.valueOf(1 + i));
            jButton.addActionListener(new DigitButtonListener(textField));
            jPanel2.add(jButton);
        }
        jButton = new JButton("/");
        jButton.addActionListener(new DigitButtonListener(textField));
        jPanel2.add(jButton);
        jButton = new JButton(")");
        jButton.addActionListener(new DigitButtonListener(textField));
        jPanel2.add(jButton);

        jButton = new JButton("0");
        jButton.addActionListener(new DigitButtonListener(textField));
        jPanel2.add(jButton);
        jButton = new JButton(".");
        jButton.addActionListener(new DigitButtonListener(textField));
        jPanel2.add(jButton);
        jButton = new JButton("=");
        jButton.addActionListener(new CodeCalculate(textField));
        jPanel2.add(jButton);
        jButton = new JButton("*");
        jButton.addActionListener(new DigitButtonListener(textField));
        jPanel2.add(jButton);
        jButton = new JButton("Ans");
        jButton.addActionListener(new DigitButtonListener(textField));
        jPanel2.add(jButton);


        setVisible(true);

        new ClearButtonListener(textField);
    }

    public static class ClearButtonListener implements ActionListener {
        private JTextField inputField;

        public ClearButtonListener(JTextField textField) {
            this.inputField = textField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            inputField.setText("");
        }
    }
}
