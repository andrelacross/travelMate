package mobil.commerce.travelmate.objects;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;

/**
 * Created by eiked on 13.12.2017.
 */

public class DiaryObject implements Serializable{

    private String name;
    private String entry = "";
    private Calendar date;
    private String text;

    public DiaryObject(Calendar date, String text) {
        this.date = date;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
}
