package mobil.commerce.travelmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                Intent intent= new Intent(this, TravelDiary.class );
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


