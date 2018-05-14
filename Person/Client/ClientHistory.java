package Person.Client;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author ashh412
 */
public class ClientHistory implements Serializable {

    private static final long serialVersionUID = -2873344211410398459L;

    private Date date;
    private String note;

    /**
     * 
     * @param date
     * @param note 
     */
    public ClientHistory(Date date, String note) {
        this.date = date;
        this.note = note;
    }
/**
 * 
 * @return 
 */
    public Date getDate() {
        return date;
    }
/**
 * 
 * @param date 
 */
    public void setDate(Date date) {
        this.date = date;
    }
/**
 * 
 * @return 
 */
    public String getNote() {
        return note;
    }
/**
 * 
 * @param note 
 */
    public void setNote(String note) {
        this.note = note;
    }

}
