package Classes;

import Classes.Medicine;

public class Dispenser  {




    private Medicine[][] dispenser;
    private String[] nameVector;

    public int numberdispenser;

    public Dispenser(int i) {
        this.dispenser = new Medicine[3][3];
        this.nameVector = new String[20];
        this.numberdispenser=i;
    }

    public int[] findMedicine(String name) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (dispenser[i][j] != null && dispenser[i][j].nameMedicine.equals(name)) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; // No encontrada
    }

    public Medicine extractMedicine(String name,int nItems) {
        int pos = findMedicine(name);
        if (pos == -1) {
            return new Medicine(-1, "", "", 0);
        }
        for (int i = 0; i < dispenser.length; i++) {
            if (dispenser[i][pos] != null && dispenser[i][pos].units>0 ) {

                Medicine medicinesaved = dispenser[i][pos];
                dispenser[i][pos] = null;
                return medicinesaved;
            }
        }
        return new Medicine(-1, "", "", 0);
    }


}
