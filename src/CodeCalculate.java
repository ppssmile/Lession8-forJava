import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CodeCalculate implements ActionListener {
    private JTextField textField;

    public CodeCalculate(JTextField textField) {
        this.textField = textField;
    }

    public String simplifyString(String str) {
        StringBuilder string = new StringBuilder(str);
        while (new StringTokenizer(string.toString(), "()+-/*", true).countTokens()>1) {
            if (string.toString().lastIndexOf('(') >= 0) {
                string.replace(
                        string.lastIndexOf("("),
                        string.lastIndexOf("(")+string.substring(string.lastIndexOf("(")).indexOf(")")+1,
                        toSolveATask(string.substring(string.lastIndexOf("("), string.lastIndexOf("(")+string.substring(string.lastIndexOf("(")).indexOf(")")+1)));
            } else {
                string.replace(0, string.length(), toSolveATask(string.toString()));
            }
        }
        return string.toString();
    }

    public String toSolveATask(String str) {
        StringTokenizer st = new StringTokenizer(str, "()+-/*", true);
        StringBuilder sb = new StringBuilder();

        String[] arr = new String[st.countTokens()];
        int counter = 0;
        while (st.hasMoreTokens()) {
            str = st.nextToken();
            if (str.equals("(") || str.equals(")")) {
                continue;
            }
            arr[counter] = str;
            counter++;
            sb.append(str);
        }

        st = new StringTokenizer(sb.toString(), "+-/*", true);
        str = new String();
        String str1 = new String();

//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i].equals("*")) {
//                sb.replace(sb.indexOf("*") - arr[i-1].length(), sb.indexOf("*") + 1 + arr[i+1].length(), String.valueOf((double)Integer.parseInt(arr[i-1])*Integer.parseInt(arr[i+1])));
//                i=0;
//            }
//            if (str1.equals("/")) {
//                sb.replace(sb.indexOf("/") - arr[i-1].length(), sb.indexOf("/") + 1 + arr[i+1].length(), String.valueOf( (double) Integer.parseInt(arr[i-1]) / Integer.parseInt(arr[i+1])));
//                i=0;
//            }
//        }
        while (sb.indexOf("*") >= 0 || sb.indexOf("/")>=0 || st.hasMoreElements()) {
            str = st.nextToken();
            if (st.hasMoreTokens()) {
                str1 = st.nextToken();
            }
            if (str1.equals("*")) {
                str1 = st.nextToken();
                sb.replace(sb.indexOf("*") - str.length(), sb.indexOf("*") + 1 + str1.length(), String.valueOf(Integer.parseInt(str) * Integer.parseInt(str1)));
                st = new StringTokenizer(sb.toString(), "+-/*", true);
            }
            if (str1.equals("/")) {
                str1 = st.nextToken();
                sb.replace(sb.indexOf("/") - str.length(), sb.indexOf("/") + 1 + str1.length(), String.valueOf(Integer.parseInt(str) / Integer.parseInt(str1)));
                st = new StringTokenizer(sb.toString(), "+-/*", true);
            }
        }

        st = new StringTokenizer(sb.toString(), "+-/*", true);
        while (sb.indexOf("+")>=0 || sb.indexOf("-")>=0 || st.hasMoreTokens()){
            str = st.nextToken();
            if (st.hasMoreTokens()) {
                str1 = st.nextToken();
            }
            if (str1.equals("+")) {
                str1 = st.nextToken();
                sb.replace(sb.indexOf("+") - str.length(), sb.indexOf("+") + 1 + str1.length(), String.valueOf((Integer.parseInt(str) + Integer.parseInt(str1))));
                st = new StringTokenizer(sb.toString(), "+-/*", true);
            }
            if (str1.equals("-")) {
                str1 = st.nextToken();
                sb.replace(sb.indexOf("-") - str.length(), sb.indexOf("-") + 1 + str1.length(), String.valueOf( Integer.parseInt(str) - Integer.parseInt(str1)));
                st = new StringTokenizer(sb.toString(), "+-/*", true);
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StringBuffer sb = new StringBuffer(textField.getText());
        JButton jb = (JButton)e.getSource();
        textField.setText(simplifyString(textField.getText()));
    }
}