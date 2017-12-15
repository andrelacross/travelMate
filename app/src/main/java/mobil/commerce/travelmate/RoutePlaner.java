package mobil.commerce.travelmate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import mobil.commerce.travelmate.objects.RouteObject;

/**
 * Created by andre on 04.12.17.
 */

public class RoutePlaner extends Activity{

    private RouteObject route;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routeplaner);

        Intent intent = getIntent();
        route = (RouteObject) intent.getSerializableExtra("route");

        Toast.makeText(RoutePlaner.this, route.getName() + " geladen", Toast.LENGTH_LONG).show();
        Log.d("myRoute", "onCreate: " + route.getName());
    }
}
