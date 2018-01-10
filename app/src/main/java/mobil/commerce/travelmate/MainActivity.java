package mobil.commerce.travelmate;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import mobil.commerce.travelmate.objects.AllRoutes;
import mobil.commerce.travelmate.objects.RouteObject;

public class MainActivity extends AppCompatActivity{

    private static final String TAG = "MainActivity";

    private static final int ERROR_DIALOG_REQUEST = 9000;

    //public static ArrayList<RouteObject> routes = AllRoutes.routes;
    private boolean mLocationPermissionsGranted;
    private final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(isServicesOK()){
            getLocationPermission();

            addExampleRoutes();
            init();
        }
    }


    private void getLocationPermission(){
         /*
         * Request location permission, so that we can get the location of the
         * device. The result of the permission request is handled by a callback,
         * onRequestPermissionsResult.
         */
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mLocationPermissionsGranted = true;
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
    }

    /**
     * Handles the result of the request for location permissions.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        mLocationPermissionsGranted = false;
        switch (requestCode) {
            case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mLocationPermissionsGranted = true;
                }
            }
        }
    }
    private void init(){
        Button btnMap = (Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra("planer", false);
                startActivity(intent);
            }
        });

        ListView routeListView = (ListView) findViewById(R.id.listView_routes);
        String[] routenames = new String[AllRoutes.routes.size()];
        for(int i = 0; i < routenames.length; i++) {
            routenames[i] = AllRoutes.routes.get(i).getName();
        }

        ListAdapter routesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, routenames);
        routeListView.setAdapter(routesAdapter);

        routeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent3 = new Intent(MainActivity.this, MapsActivity.class);
                intent3.putExtra("route", i);
                intent3.putExtra("planer", true);
                startActivity(intent3);
            }
        });

    }

    private void addExampleRoutes() {
        AllRoutes.routes.clear();
        AllRoutes.routes.add(new RouteObject("Süd-Amerika"));
        AllRoutes.routes.add(new RouteObject("Schweden"));
        AllRoutes.routes.add(new RouteObject("Thailand"));

    }

    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);

        if(available == ConnectionResult.SUCCESS){
            //everything is fine and the user can make map requests
            Log.d(TAG, "isServicesOK: Google Play Services is working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //an error occured but we can resolve it
            Log.d(TAG, "isServicesOK: an error occured but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    // handle click events for action bar items
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.reisetagebuch:
                Intent intent = new Intent(this, TravelDiary.class );
                startActivity(intent);
                return true;

            case R.id.meineRouten:
                Intent intent1= new Intent(this, MyRoutes.class);
                startActivity(intent1);
                return true;

            case R.id.gefährten:
                Intent intent2= new Intent(this, Mates.class);
                startActivity(intent2);
                return true;

            case R.id.routenplanung:
                Intent intent3 = new Intent(this, RoutePlaner.class);
                startActivity(intent3);
                return true;



            default:
                return super.onOptionsItemSelected(item);


        }

    }
}


