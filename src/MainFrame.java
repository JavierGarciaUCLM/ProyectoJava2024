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



                int[] positionmedicamento = farmacia.findPositions(companyName);
                if (positionmedicamento[0] != -1) {
                    int p = positionmedicamento[0];
                    int i = positionmedicamento[1];
                    int j = positionmedicamento[2];

                    Medicine medicamentoEncontrado = farmacia.dispensers[p].dispenser[i][j];
                    if (medicamentoEncontrado != null) {
                        xTextArea.setText(medicamentoEncontrado.getIndications());


                    } else {
                        xTextArea.setText("Medicamento no encontrado o agotado.");
                    }
                } else {
                    xTextArea.setText("Medicamento no encontrado o agotado");
                }
            }
        });
        viewDispenser1RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xTextArea.setText(""); // Limpiar el área de texto antes de agregar nuevos nombres
                for (int i = 0; i < 20; i++) {
                    for (int j = 14; j >= 0; --j) {
                        if(farmacia.dispensers[0].dispenser[i][j].getId()!=-1){
                        String word1 = farmacia.dispensers[0].dispenser[i][j].getNameMedicine();
                        String word2 = farmacia.dispensers[0].dispenser[i][j].getManufacturer();
                        xTextArea.append("Name Medicine: "+word1 +"           "+"Manufacturer: " +word2 + "\n");


                    }
                    }
                }
            }
        });
        viewDispenser2RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xTextArea.setText(""); // Limpiar el área de texto antes de agregar nuevos nombres
                for (int i = 0; i < 20; i++) {
                    for (int j = 14; j >= 0; --j) {
                        if(farmacia.dispensers[1].dispenser[i][j].getId()!=-1){
                            String word1 = farmacia.dispensers[1].dispenser[i][j].getNameMedicine();
                            String word2 = farmacia.dispensers[1].dispenser[i][j].getManufacturer();
                            xTextArea.append("Name Medicine: "+word1 +"           "+"Manufacturer: " +word2 + "\n");


                        }


                    }
                }
            }
        });
        viewDispenser3RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xTextArea.setText(""); // Limpiar el área de texto antes de agregar nuevos nombres
                for (int i = 0; i < 20; i++) {
                    for (int j = 14; j >= 0; --j) {
                        if(farmacia.dispensers[2].dispenser[i][j].getId()!=-1){
                            String word1 = farmacia.dispensers[2].dispenser[i][j].getNameMedicine();
                            String word2 = farmacia.dispensers[2].dispenser[i][j].getManufacturer();
                            xTextArea.append("Name Medicine: "+word1 +"           "+"Manufacturer: " +word2 + "\n");


                        }


                    }
                }
            }
        });
        viewDispenser4RadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xTextArea.setText(""); // Limpiar el área de texto antes de agregar nuevos nombres
                for (int i = 0; i < 20; i++) {
                    for (int j = 14; j >= 0; --j) {
                        if(farmacia.dispensers[3].dispenser[i][j].getId()!=-1){
                            String word1 = farmacia.dispensers[3].dispenser[i][j].getNameMedicine();
                            String word2 = farmacia.dispensers[3].dispenser[i][j].getManufacturer();
                            xTextArea.append("Name Medicine: "+word1 +"           "+"Manufacturer: " +word2 + "\n");
                        }


                    }
                }
            }
        });
        buttonMedicine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String nameMedicine=textFieldMedicine.getText();
                int amount=Integer.parseInt(textFieldNumItems.getText());
                String nameCompany=textFieldCompanyName.getText();
                int cantidadRestante=farmacia.dispendMedicicine(nameMedicine, amount);


                    if (cantidadRestante == 0) {

                        xTextArea.setText("Cantidad sacada correctamente");

                    } else {xTextArea.setText("Cantidad insuficiente en almacen,rellenando automaticamente.\n\nCantidad Restante: "+cantidadRestante);
                    farmacia.refillStockAll(nameMedicine,nameCompany,5);
                    }                                //aumentan todos los medicamentos con este nombre en  10


            }
        });
        buttonRefill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nameCompany=textFieldCompanyName.getText();
                String nameMedicine=textFieldMedicine.getText();
                int amount=Integer.parseInt(textFieldNumItems.getText());

                farmacia.refillOneMedicine(nameMedicine,amount);

                xTextArea.setText("rellenado corectamente");

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


            farmacia.dispensers[0].dispenser[0][1]= new Medicine(2,"for fever","Johnson & Johnson","Ibuprofen",23);
            farmacia.dispensers[0].dispenser[0][2]= new Medicine(3,"for infection","Bayer","Amoxicillin",34);
            farmacia.dispensers[0].dispenser[0][3]= new Medicine(4,"for upset stomach","Pfizer","Omeprazole",37);
            farmacia.dispensers[0].dispenser[0][4]= new Medicine(5,"for anxiety","Johnson & Johnson","Diazepam",30);
            farmacia.dispensers[0].dispenser[0][5]= new Medicine(6,"for allergies","AstraZeneca","Loratadine",83);
            farmacia.dispensers[0].dispenser[0][6]= new Medicine(7,"for inflammation","Bayer","Aspirin",73);
            farmacia.dispensers[0].dispenser[0][7]= new Medicine(8,"for diabetes","Pfizer","Ciprofloxacin",63);
            farmacia.dispensers[0].dispenser[0][8]= new Medicine(9,"for cholesterol","AstraZeneca","Atorvastatin",35);
            farmacia.dispensers[0].dispenser[0][9] = new Medicine(10, "for allergies", "Sanofi", "Cetirizine", 23);
            farmacia.dispensers[0].dispenser[0][10] = new Medicine(11, "for pain", "Takeda", "Tramadol", 83);
            farmacia.dispensers[0].dispenser[0][11] = new Medicine(12, "for cholesterol", "AstraZeneca", "Rosuvastatin", 12);
            farmacia.dispensers[0].dispenser[0][12] = new Medicine(13, "for stomach ache", "Johnson & Johnson", "Pantoprazole", 20);
            farmacia.dispensers[0].dispenser[0][13] = new Medicine(14, "for depression", "Bayer", "Escitalopram", 34);
            farmacia.dispensers[0].dispenser[0][14] = new Medicine(15, "for depression", "Merck", "Fluoxetine", 76);




            farmacia.dispensers[1].dispenser[0][0]= new Medicine(1,"for pain","Bayer","Paracetamol",32);
            farmacia.dispensers[1].dispenser[0][1]= new Medicine(2,"for fever","Johnson & Johnson","Ibuprofen",23);
            farmacia.dispensers[1].dispenser[0][2]= new Medicine(3,"for infection","AstraZeneca","Amoxicillin",34);
            farmacia.dispensers[1].dispenser[0][3]= new Medicine(4,"for anxiety","AstraZeneca","Diazepam",30);
            farmacia.dispensers[1].dispenser[0][4]= new Medicine(5,"for upset stomach","Pfizer","Omeprazole",37);
            farmacia.dispensers[1].dispenser[0][5]= new Medicine(6,"for inflammation","Bayer","Aspirin",73);
            farmacia.dispensers[1].dispenser[0][6]= new Medicine(7,"for allergies","Pfizer","Loratadine",83);
            farmacia.dispensers[1].dispenser[0][7]= new Medicine(8,"for cholesterol","Johnson & Johnson","Atorvastatin",35);
            farmacia.dispensers[1].dispenser[0][8]= new Medicine(9,"for diabetes","Pfizer","Ciprofloxacin",63);
            farmacia.dispensers[1].dispenser[0][9] = new Medicine(10, "for allergies", "Sanofi", "Cetirizine", 23);
            farmacia.dispensers[1].dispenser[0][10] = new Medicine(11, "for cholesterol", "AstraZeneca", "Rosuvastatin", 12);
            farmacia.dispensers[1].dispenser[0][11] = new Medicine(12, "for depression", "Bayer", "Escitalopram", 34);
            farmacia.dispensers[1].dispenser[0][12] = new Medicine(13, "for depression", "Merck", "Fluoxetine", 76);
            farmacia.dispensers[1].dispenser[0][13] = new Medicine(14, "for pain", "Takeda", "Tramadol", 83);
            farmacia.dispensers[1].dispenser[0][14] = new Medicine(15, "for stomach ache", "Johnson & Johnson", "Pantoprazole", 20);



            farmacia.dispensers[2].dispenser[0][0]= new Medicine(1,"for pain","Bayer","Paracetamol",32);
            farmacia.dispensers[2].dispenser[0][1]= new Medicine(2,"for fever","Pfizer","Ibuprofen",23);
            farmacia.dispensers[2].dispenser[0][2]= new Medicine(3,"for allergies","Pfizer","Loratadine",83);
            farmacia.dispensers[2].dispenser[0][3]= new Medicine(4,"for inflammation","Bayer","Aspirin",73);
            farmacia.dispensers[2].dispenser[0][4]= new Medicine(5,"for diabetes","Johnson & Johnson","Ciprofloxacin",63);
            farmacia.dispensers[2].dispenser[0][5]= new Medicine(6,"for infection","Johnson & Johnson","Amoxicillin",34);
            farmacia.dispensers[2].dispenser[0][6]= new Medicine(7,"for anxiety","AstraZeneca","Diazepam",30);
            farmacia.dispensers[2].dispenser[0][7]= new Medicine(8,"for upset stomach","Pfizer","Omeprazole",37);
            farmacia.dispensers[2].dispenser[0][8]= new Medicine(9,"for cholesterol","Johnson & Johnson","Atorvastatin",35);
            farmacia.dispensers[2].dispenser[0][9]= new Medicine(10,"for cholesterol","AstraZeneca","Rosuvastatin",12);
            farmacia.dispensers[2].dispenser[0][10]= new Medicine(11,"for allergies","Sanofi","Cetirizine",23);
            farmacia.dispensers[2].dispenser[0][11]= new Medicine(12,"for depression","Bayer","Escitalopram",34);
            farmacia.dispensers[2].dispenser[0][12]= new Medicine(13,"for depression","Merck","Fluoxetine",76);
            farmacia.dispensers[2].dispenser[0][13]= new Medicine(14,"for stomach ache","Johnson & Johnson","Pantoprazole",20);
            farmacia.dispensers[2].dispenser[0][14]= new Medicine(15,"for pain","Takeda","Tramadol",83);



            farmacia.dispensers[3].dispenser[0][0] = new Medicine(1, "for anxiety", "AstraZeneca", "Diazepam", 30);
            farmacia.dispensers[3].dispenser[0][1] = new Medicine(2, "for inflammation", "Bayer", "Aspirin", 73);
            farmacia.dispensers[3].dispenser[0][2] = new Medicine(3, "for fever", "Pfizer", "Ibuprofen", 23);
            farmacia.dispensers[3].dispenser[0][3] = new Medicine(4, "for pain", "Bayer", "Paracetamol", 32);
            farmacia.dispensers[3].dispenser[0][4] = new Medicine(5, "for upset stomach", "Pfizer", "Omeprazole", 37);
            farmacia.dispensers[3].dispenser[0][5] = new Medicine(6, "for infection", "Johnson & Johnson", "Amoxicillin", 34);
            farmacia.dispensers[3].dispenser[0][6] = new Medicine(7, "for cholesterol", "Johnson & Johnson", "Atorvastatin", 35);
            farmacia.dispensers[3].dispenser[0][7] = new Medicine(8, "for allergies", "Pfizer", "Loratadine", 83);
            farmacia.dispensers[3].dispenser[0][8] = new Medicine(9, "for diabetes", "Johnson & Johnson", "Ciprofloxacin", 63);
            farmacia.dispensers[3].dispenser[0][9] = new Medicine(10, "for cholesterol", "AstraZeneca", "Rosuvastatin", 12);
            farmacia.dispensers[3].dispenser[0][10] = new Medicine(11, "for allergies", "Sanofi", "Cetirizine", 23);
            farmacia.dispensers[3].dispenser[0][11] = new Medicine(12, "for depression", "Bayer", "Escitalopram", 34);
            farmacia.dispensers[3].dispenser[0][12] = new Medicine(13, "for depression", "Merck", "Fluoxetine", 76);
            farmacia.dispensers[3].dispenser[0][13] = new Medicine(14, "for stomach ache", "Johnson & Johnson", "Pantoprazole", 20);
            farmacia.dispensers[3].dispenser[0][14] = new Medicine(15, "for pain", "Takeda", "Tramadol", 83);






        });
    }
}
















