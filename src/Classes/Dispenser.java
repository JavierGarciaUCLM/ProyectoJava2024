package Classes;



public class Dispenser   {




    public Medicine[][] dispenser;




    public Dispenser() {
        this.dispenser = new Medicine[20][15];

        for (int i=0; i< 20;i++){
            for(int j=0; j<15;j++){

                dispenser[i][j] = new Medicine();}
            }
        }





    public int[] findMedicine(String name,String nameCompany) {



        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 15; j++) {
                String nameMedicine=dispenser[i][j].getNameMedicine();
                String namecompany=dispenser[i][j].getManufacturer();

                if (nameMedicine.equals(name) && dispenser[i][j].units>0 && namecompany.equals(nameCompany)) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; // Not found.
    }


    public int takeMedicine(String name,int x,String nameCompany){

        int numberMedicine=0;
        for (int i = 0; i < 20; i++) {
            for (int j = 14; j >=0; --j) {
                String nameMedicine=dispenser[i][j].getNameMedicine();
                String namecompany=dispenser[i][j].getManufacturer();
                if (nameMedicine.equals(name) && namecompany.equals(nameCompany)&&dispenser[i][j].units>0) {

                    do{
                        dispenser[i][j].units=dispenser[i][j].units -1;
                        numberMedicine++;
                    }while(x>numberMedicine && dispenser[i][j].units>0);

                }
            }
        }

        return numberMedicine;

    }

    public void refillStockAll(int amount,String name,String company){



        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 15; j++) {
                String nameMedicine=dispenser[i][j].getNameMedicine();
                String namecompany=dispenser[i][j].getManufacturer();
                if (nameMedicine.equals(name)&& namecompany.equals(company)){

                dispenser[i][j].units = dispenser[i][j].units + amount;

                }

            }
        }

    }
    public void refillOneMedicine(int amount,int x,int y){





        dispenser[x][y].units = dispenser[x][y].units + amount;

    }







}
