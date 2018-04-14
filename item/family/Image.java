package item.family;

public class Image extends item.Electrodomestic{

    private double inches;
    private String resolution;
    private String frequency;

    public Image(String code, String name, double boughtPrice, double sellPrice, int quantity, String familyCode) {
        super(code, name, boughtPrice, sellPrice, quantity, familyCode);
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
