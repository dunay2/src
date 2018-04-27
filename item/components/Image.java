package item.components;

public class Image extends item.Electrodomestic{

    private double inches;
    private String resolution;
    private String frequency;

    public Image(String familyCode, String code, String name, String description, double boughtPrice, double sellPrice, int quantity) {
        super(familyCode, code, name, description, boughtPrice, sellPrice, quantity);
    }

  

    public double getInches() {
        return inches;
    }

    public void setInches(double inches) {
        this.inches = inches;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
    
}
