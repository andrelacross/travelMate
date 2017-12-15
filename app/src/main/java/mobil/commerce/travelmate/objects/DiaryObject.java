package mobil.commerce.travelmate.objects;

import java.io.Serializable;
import java.text.DateFormat;

/**
 * Created by eiked on 13.12.2017.
 */

public class DiaryObject implements Serializable{

    private String name;
    private String entry = "";
    private DateFormat date;

    public DiaryObject(String name) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public DateFormat getDate() {
        return date;
    }

    public void setDate(DateFormat date) {
        this.date = date;
    }
}
