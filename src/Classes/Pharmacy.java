package Classes;

import javax.swing.*;

public class Pharmacy extends JFrame {

    public Dispenser[] dispensers;


    public Pharmacy(Dispenser[] dispensers) {
        this.dispensers = new Dispenser[4];
        for (int i = 0; i < this.dispensers.length; i++) {
            this.dispensers[i] = new Dispenser(); // Inicializa cada Dispenser
        }
    }








    public int[] findPositions(String name) {




        int[] isThere = {-1, -1, -1};


        for (int i = 0; i < 4; i++) {
            int[] positions = dispensers[i].findMedicine(name);

            if (positions[0] != -1) {// Medicina encontrada

                isThere[0] = i;
                isThere[1] = positions[0];
                isThere[2] = positions[1];

                return isThere;


            }
        }

        return isThere;

    }




















}