package Classes;

import Classes.Medicine;

public class Dispenser   {




    public Medicine[][] dispenser;




    public Dispenser() {
        this.dispenser = new Medicine[3][3];

        for (int i=0; i< dispenser.length;i++){
            for(int j=0; j< dispenser.length;j++){

                dispenser[i][j] = new Medicine();}
            }
        }





    public int[] findMedicine(String name) {



        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String nameMedicine=dispenser[i][j].getNameMedicine();
                System.out.println(nameMedicine);
                if (nameMedicine.equals(name) && dispenser[i][j].units>0) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; // No encontrada
    }







}
