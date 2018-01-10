package mobil.commerce.travelmate.objects;

import android.os.Parcelable;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by eiked on 13.12.2017.
 */

public class RouteObject implements Serializable {

    private String name;
    private DateFormat date;
    private ArrayList<DiaryObject> diaryList = new ArrayList<>();
    private DiaryObject diaryObject;

    public RouteObject(String name) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateFormat getDate() {
        return date;
    }

    public void setDate(DateFormat date) {
        this.date = date;
    }

    public void addDiaryObject(Calendar date, String text) {
        diaryList.add(new DiaryObject(date, text));
    }

    public ArrayList<DiaryObject> getDiaryList() {
        return diaryList;
    }

    public DiaryObject getDiaryObject() {
        return diaryObject;
    }

    public void setDiaryObject(DiaryObject diaryObject) {
        this.diaryObject = diaryObject;
    }
}
