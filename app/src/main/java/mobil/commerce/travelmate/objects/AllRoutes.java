package mobil.commerce.travelmate.objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by eiked on 05.01.2018.
 */

public class AllRoutes implements Serializable{

    public static ArrayList<RouteObject> routes = new ArrayList<>();

    public static void saveRoutes(){
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("/sdcard/save_object.bin")));
            oos.writeObject(AllRoutes.routes); //
            oos.flush(); // flush the stream to insure all of the information was written to 'save_object.bin'
            oos.close();// close the stream
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void loadRoutes(){
        {
            try
            {
                File f = new File("/sdcard/save_object.bin");
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                Object o = ois.readObject();
                AllRoutes.routes = (ArrayList<RouteObject>) o;
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }

        }
    }

}
