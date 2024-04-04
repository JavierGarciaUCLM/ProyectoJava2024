import Classes.Dispenser;
import Classes.Pharmacy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private JTextField textFieldMedicine;
    private JButton buttonMedicine;
    private JButton buttonInformationFlyer;
    private JButton buttonRefill;
    private JButton buttonDispenseList;
    private JTextField textFieldCompanyName;

    public JTextField getTextFieldCompanyName=new JTextField(20);

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
    //El mainPanel es el panel total
    private JPanel mainPanel;
    //El logo es la imagen de las pastillas
    private JLabel logo;



    Dispenser[] dispensers= new Dispenser[4];
    Pharmacy farmacia= new Pharmacy(dispensers);



    public MainFrame(){
        //Necesitamos definir los valores de nuestro menu. Le ponemos el título de "Pharmacy". A la ventaña un tamaño
        //de 980 de ancho x 600 de alto
        setContentPane(mainPanel);
        setTitle("Pharmacy");
        setSize(980, 600);
        //El EXIT_ON_CLOSE hará que cuando el usuario cierre la ventana, también se pare el código
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Básicamente para que se vea la ventana que hemos creado
        setVisible(true);


        buttonInformationFlyer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int[] positionmedicamento = new int[3];

                positionmedicamento = farmacia.findPositions(getTextFieldCompanyName.getText());
                int p=positionmedicamento[0];
                int i=positionmedicamento[1];
                int j=positionmedicamento[2];

            }
        });


    }}

    //Se crea una instancia de la clase MainFrame y se estás almacenando en una variable llamada myFrame
    //MainFrame es una clase creada para representar la ventana principal de la farmacia

