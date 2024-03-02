import javax.swing.*;

public class MainFrame extends JFrame{
    private JTextField textFieldMedicine;
    private JButton buttonMedicine;
    private JButton buttonInformationFlyer;
    private JButton buttonRefill;
    private JButton buttonDispenseList;
    private JTextField textFieldCompanyName;
    private JLabel lbMedicine;
    private JLabel lbCompanyName;
    private JLabel lbNumItems;
    private JTextField textFieldNumItems;
    private JTextArea xTextArea;
    private JLabel lbDispensers;
    private JRadioButton viewDispenser4RadioButton;
    private JRadioButton viewDispenser3RadioButton;
    private JRadioButton viewDispenser2RadioButton;
    private JRadioButton viewDispenser1RadioButton;
    private JPanel mainPanel;
    private JLabel logo;

    public MainFrame(){
        setContentPane(mainPanel);
        setTitle("Pharmacy");
        setSize(980, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args){
        MainFrame myFrame = new MainFrame();

    }
}
