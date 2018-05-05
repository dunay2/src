package item.family.Image;

/**
 *
 * @author ashh412
 */
public class Plasm extends item.Electrodomestic{
    private static final long serialVersionUID = -2873344211410398459L;
    private double inches;
    private String resolution;
    private String frequency;

    /**
     *
     * @param code
     */
    public Plasm(String code) {
        super(code);
    }

    /**
     *
     * @return
     */
    public double getInches() {
        return inches;
    }

    /**
     *
     * @param inches
     */
    public void setInches(double inches) {
        this.inches = inches;
    }

    /**
     *
     * @return
     */
    public String getResolution() {
        return resolution;
    }

    /**
     *
     * @param resolution
     */
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    /**
     *
     * @return
     */
    public String getFrequency() {
        return frequency;
    }

    /**
     *
     * @param frequency
     */
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
    
}
