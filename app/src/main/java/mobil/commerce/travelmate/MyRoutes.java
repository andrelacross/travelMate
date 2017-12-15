package mobil.commerce.travelmate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import mobil.commerce.travelmate.objects.RouteObject;

/**
 * Created by andre on 04.12.17.
 */

public class MyRoutes extends Activity {

    private RouteObject route;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myroutes);

    }


}
