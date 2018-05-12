package Person.Client;

import java.io.Serializable;
import java.util.Date;

public class ClientHistory implements Serializable {

    private static final long serialVersionUID = -2873344211410398459L;

    private Date date;
    private String note;

    public ClientHistory(Date date, String note) {
        this.date = date;
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
