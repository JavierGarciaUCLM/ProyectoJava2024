package Classes;

import Classes.Medicine;

public class Dispenser   {




    public Medicine[][] dispenser;




    public Dispenser(int i) {
        this.dispenser = new Medicine[3][3];
        dispenser[2][3]= new Medicine(1,"Hola hola","tarazona","paracetamol",5);


    }

    public int[] findMedicine(String name) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (dispenser[i][j] != null && dispenser[i][j].nameMedicine.equals(name) && dispenser[i][j].units<0) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; // No encontrada
    }







}
