package Classes;

import Classes.Medicine;

public class Dispenser   {




    public Medicine[][] dispenser;




    public Dispenser() {
        this.dispenser = new Medicine[3][3];

        for (int i=0; i< dispenser.length;i++){
            for(int j=0; j< dispenser.length;j++){
                dispenser[i][j]= new Medicine();
            }
        }



    }

    public int[] findMedicine(String name) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (dispenser[i][j] != null && dispenser[i][j].nameMedicine.equals(name)&& dispenser[i][j].nameMedicine != null && dispenser[i][j].units>0) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; // No encontrada
    }







}
