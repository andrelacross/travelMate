package mobil.commerce.travelmate.objects;

import android.os.Parcelable;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;

/**
 * Created by eiked on 13.12.2017.
 */

public class RouteObject implements Serializable {

    private String name;
    private DateFormat date;
    private ArrayList<DiaryObject> diaryList = new ArrayList<>();

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

    public void addDiaryEtry(String diaryname) {
        diaryList.add(new DiaryObject(diaryname));
    }

    public DiaryObject getDiary(int index){
        return diaryList.get(index);
    }

    public ArrayList getDiaryList() {
        return diaryList;
    }

}
