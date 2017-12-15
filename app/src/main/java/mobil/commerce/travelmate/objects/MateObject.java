package mobil.commerce.travelmate.objects;

/**
 * Created by eiked on 11.12.2017.
 */

public class MateObject {

    private String name;
    private String contact;

    public MateObject(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
