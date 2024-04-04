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
                        xTextArea.setText(medicamentoEncontrado.getNameMedicine());

                    } else {
                        xTextArea.setText("Medicamento no encontrado.");
                    }
                } else {
                    xTextArea.setText("Medicamento no encontrado.");
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

            farmacia.dispensers[2].dispenser[2][1].setName("Hola");
            farmacia.dispensers[2].dispenser[2][1].setUnits(20);



        });
    }
}
















