package Classes;

public class Pharmacy {

    public Dispenser[] dispensers;
    int x;

    public Pharmacy(Dispenser[] dispensers) {
        this.dispensers = new Dispenser[4];

    }


     public int[] findPositions(String name){



       int[] isThere = {-1, -1, -1};
       int unidadesExistentes=0;



        for(int i = 0; i < 4; i++){
        int[] positions = dispensers[i].findMedicine(name);

        if(positions[0] != -1 &&){ // Medicina encontrada



         }
      }


    }



    }

