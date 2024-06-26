package Classes;

import javax.swing.*;

public class Pharmacy extends JFrame {

    public Dispenser[] dispensers;
    private Medicine[] medicamentosDispensados;
    private int contadorMedicamentos=0;


    public Pharmacy(Dispenser[] dispensers) {
        this.dispensers = new Dispenser[4];
        for (int i = 0; i < this.dispensers.length; i++) {
            this.dispensers[i] = new Dispenser(); // Inicializa cada Dispenser
        }
        medicamentosDispensados = new Medicine[1000];
    }

    public Medicine[] getMedicamentosDispensados() {
        return medicamentosDispensados;
    }

    public int getContadorMedicamentos() {
        return contadorMedicamentos;
    }

    public int[] findPositions(String name, String nameCompany) {




        int[] isThere = {-1, -1, -1};


        for (int i = 0; i < 4; i++) {
            int[] positions = dispensers[i].findMedicine(name,nameCompany);

            if (positions[0] != -1) {// Medicina encontrada

                isThere[0] = i;
                isThere[1] = positions[0];
                isThere[2] = positions[1];

                return isThere;


            }
        }

        return isThere;

    }
    public int dispendMedicicine(String name,int amount,String nameCompany){

        for (int i = 0; i < 4; i++) {

            int x=dispensers[i].takeMedicine(name,amount,nameCompany);
            amount=amount-x;

            if(amount==0){
                return 0;
            }

        }return amount;


    }
    public void refillStockAll(String name,String company,int amount){

        for (int i=0; i<4;i++){
            dispensers[i].refillStockAll(amount,name,company);
        }

    }
    public void refillOneMedicine(String name,int amount,String nameCompany){

        int[] position=findPositions(name,nameCompany);

        int z=position[0];
        int x=position[1];
        int y= position[2];

        dispensers[z].refillOneMedicine(amount,x,y);

    }



    public void agregarMedicamentoDispensado(Medicine medicamento, int cantidad) {


        for (int i = 0; i < contadorMedicamentos; i++) {
            if (medicamentosDispensados[i].nameMedicine.equals(medicamento.nameMedicine) && medicamentosDispensados[i].manufacturer.equals(medicamento.manufacturer)) {
                medicamentosDispensados[i].units += cantidad;
                return;
            }
        }

        // Agrega un nuevo medicamento
        if (contadorMedicamentos < medicamentosDispensados.length) {
            medicamentosDispensados[contadorMedicamentos] = medicamento;
            medicamentosDispensados[contadorMedicamentos].units=cantidad;
            contadorMedicamentos++;
        }
    }



}