import Classes.Dispenser;
import Classes.Pharmacy;
import Classes.Medicine;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
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

    private Pharmacy farmacia; // Referencia a Pharmacy

    public MainFrame(Pharmacy farmacia) {
        this.farmacia = farmacia; // Inicializar la farmacia
        setContentPane(mainPanel);
        setTitle("Pharmacy");
        setSize(980, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // Añadir un ActionListener al botón buttonInformationFlyer
        buttonInformationFlyer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String companyName = textFieldMedicine.getText(); // Obtiene el texto del campo textFieldCompanyName

                System.out.println("main: "+companyName);

                int[] positionmedicamento = farmacia.findPositions(companyName);
                if (positionmedicamento[0] != -1) {
                    int p = positionmedicamento[0];
                    int i = positionmedicamento[1];
                    int j = positionmedicamento[2];

                    Medicine medicamentoEncontrado = farmacia.dispensers[p].dispenser[i][j];
                    if (medicamentoEncontrado != null) {
                        xTextArea.setText("Name: "+medicamentoEncontrado.getNameMedicine()+"\nManufacturer:"+medicamentoEncontrado.getManufacturer()+"\nUnits:"+medicamentoEncontrado.getUnits());

                    } else {
                        xTextArea.setText("Medicamento no encontrado.");
                    }
                } else {
                    xTextArea.setText("Medicamento no encontrado.");
                }
            }
        });
        viewDispenser1RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xTextArea.setText(""); // Limpiar el área de texto antes de agregar nuevos nombres
                for (int i = 0; i < 3; i++) {
                    for (int j = 2; j >= 0; --j) {
                        String word1 = farmacia.dispensers[0].dispenser[i][j].getNameMedicine();
                        String word2 = farmacia.dispensers[0].dispenser[i][j].getManufacturer();
                        xTextArea.append("Name Medicine: "+word1 +"           "+"Manufacturer: " +word2 + "\n");


                    }
                }
            }
        });
        viewDispenser2RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xTextArea.setText(""); // Limpiar el área de texto antes de agregar nuevos nombres
                for (int i = 0; i < 3; i++) {
                    for (int j = 2; j >= 0; --j) {
                        String word1 = farmacia.dispensers[1].dispenser[i][j].getNameMedicine();
                        String word2 = farmacia.dispensers[1].dispenser[i][j].getManufacturer();
                        xTextArea.append("Name Medicine: "+word1 +"           "+"Manufacturer: " +word2 + "\n");


                    }
                }
            }
        });
        viewDispenser3RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xTextArea.setText(""); // Limpiar el área de texto antes de agregar nuevos nombres
                for (int i = 0; i < 3; i++) {
                    for (int j = 2; j >= 0; --j) {
                        String word1 = farmacia.dispensers[2].dispenser[i][j].getNameMedicine();
                        String word2 = farmacia.dispensers[2].dispenser[i][j].getManufacturer();
                        xTextArea.append("Name Medicine: "+word1 +"           "+"Manufacturer: " +word2 + "\n");


                    }
                }
            }
        });
        viewDispenser4RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xTextArea.setText(""); // Limpiar el área de texto antes de agregar nuevos nombres
                for (int i = 0; i < 3; i++) {
                    for (int j = 2; j >= 0; --j) {
                        String word1 = farmacia.dispensers[3].dispenser[i][j].getNameMedicine();
                        String word2 = farmacia.dispensers[3].dispenser[i][j].getManufacturer();
                        xTextArea.append("Name Medicine: "+word1 +"           "+"Manufacturer: " +word2 + "\n");


                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            Dispenser[] dispensers = new Dispenser[4];
            // Inicializa cada Dispenser aquí
            // dispensers[0] = new Dispenser().....segun los que se necesiten si añades mas hay que cambiarlos en la definicion new Dispenser[x];

            for(int i=0;i<3;i++){
                dispensers[i]= new Dispenser();//aqui se inicializan los Dispensadores
          }


            Pharmacy farmacia = new Pharmacy(dispensers);



            new MainFrame(farmacia).setVisible(true);

            //Aqui se pueden rellenar manualmente los dispensadores,por defecto estan vacios y no seran contados a la hora de buscar.Ejm


            farmacia.dispensers[0].dispenser[0][0]= new Medicine(1,"adios","hola","con",3);
            farmacia.dispensers[0].dispenser[0][1]= new Medicine(2,"adios","que","hecho",3);
            farmacia.dispensers[0].dispenser[0][2]= new Medicine(3,"adios","tal","roncola",3);
            farmacia.dispensers[0].dispenser[1][0]= new Medicine(4,"adios","estas","de",3);
            farmacia.dispensers[0].dispenser[1][1]= new Medicine(5,"adios","yo","poco",3);
            farmacia.dispensers[0].dispenser[1][2]= new Medicine(6,"adios","bastante","un",3);
            farmacia.dispensers[0].dispenser[2][0]= new Medicine(7,"adios","bien","cola",3);
            farmacia.dispensers[0].dispenser[2][1]= new Medicine(8,"adios","hola","y",3);
            farmacia.dispensers[0].dispenser[2][2]= new Medicine(9,"adios","hola","ron",3);






        });
    }
}
















