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
    //Whole panel
    private JPanel mainPanel;
    //Pills Image
    private JLabel logo;

    public MainFrame(){
        //Values for the menu need to be set, the title is "Pharmacy". Finally, a 980x600 window is defined.
        setContentPane(mainPanel);
        setTitle("Pharmacy");
        setSize(980, 600);
        //El EXIT_ON_CLOSE when the window closes, teh codes stops.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //This line is made so that the window created can be seen
        setVisible(true);
    }
    //An instance of the class "MainFrame" is created and then, stored in a variable called myFrame.
    //Main frame is a class created for representing the main window
    public static void main(String[] args){
        MainFrame myFrame = new MainFrame();

    }
}
