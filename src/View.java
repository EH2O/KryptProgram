import javax.swing.*;

public class View {
    private JPanel panel;
    private JCheckBox checkBox1;
    private JButton crypt;
    private JTextField FileIn;
    private JPasswordField FileOut;
    private JTextField key;



    public JPanel getPanel() {
        return panel;
    }


    public String getFileIn() {
        return FileIn.getText();
    }
    public String getFileOut() {
        return FileOut.getText();
    }
    public boolean isOn() {
        return checkBox1.isSelected();
    }

    public String getKey() {
        return key.getText();
    }
    public void setCryptListener(ActionListener cryptListener) {
        crypt.addActionListener(cryptListener);
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("View");
        frame.setContentPane(new View().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
