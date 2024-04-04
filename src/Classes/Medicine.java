package Classes;

public class Medicine {

    int id;
    String indications;
    String manufacturer;
    String nameMedicine;
    int units;


    public Medicine(){}

    /**
     * Constructor of Medicine
     * @param id
     * @param indications
     * @param manufacturer
     * @param units
     */
    public Medicine(int id, String indications, String manufacturer,String nameMedicine, int units) {

        this.id = id;
        this.indications = indications;
        this.manufacturer = manufacturer;
        this.units = units;
        this.nameMedicine = nameMedicine;


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

    public void setId(int id) {
        this.id = id;
    }

    public void setIndications(String indications) {
        this.indications = indications;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setUnits(int units) {
        this.units = units;
    }
}
