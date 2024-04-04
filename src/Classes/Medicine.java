package Classes;

public class Medicine {

    int id;
    String indications;
    String manufacturer;
    String nameMedicine="Paracetamol";
    int units;


    public Medicine(){}

    /**
     * Constructor of Medicine
     * @param id
     * @param indications
     * @param manufacturer
     * @param units
     */

    public Medicine(int id, String indications, String manufacturer, String nameMedicine, int units) {
        this.id = id;
        this.indications = indications; // Usar el argumento
        this.manufacturer = manufacturer; // Usar el argumento
         // Asegurarse de asignar nameMedicine correctamente
        this.units = units;
    }


    public int getId() {
        return id;
    }

    public String getIndications() {
        return indications;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getUnits() {
        return units;
    }

    public String getNameMedicine(){return nameMedicine; }

    public void setId(int id) {
        this.id = id;
    }

    public void setIndications(String indications) {
        this.indications = indications;
    }

    public void setName(String nameMedicine) {
        this.nameMedicine = nameMedicine;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setUnits(int units) {
        this.units = units;
    }
}
