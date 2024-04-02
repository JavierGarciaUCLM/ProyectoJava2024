package Classes;

public class Pharmacy {

    public Dispenser[] dispensers;

    public Pharmacy(Dispenser[] dispensers) {
        this.dispensers = new Dispenser[4];
    }


    public int[] findMedicine(String name, int pos1, int pos2){
        int[] isThere = {-1, -1, -1};
        for(int i = 0; i < 4; i++){
            int[] positions = dispensers[i].findMedicine(name);
            if(positions[0] != -1 && Dispenser[i].dispenser.unit){ // Medicina encontrada
                isThere[0] = i; // Dispenser donde se encontro
                isThere[1] = positions[0]; // Posición i
                isThere[2] = positions[1]; // Posición j
                return isThere;
            }
        }
        return isThere;

    }


    }

