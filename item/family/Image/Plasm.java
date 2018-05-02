package item.family.Image;

public class Plasm extends item.Electrodomestic{

    private double inches;
    private String resolution;
    private String frequency;

    public Plasm(String code) {
        super(code);
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
