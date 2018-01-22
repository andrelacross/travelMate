package mobil.commerce.travelmate;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import mobil.commerce.travelmate.objects.MateObject;

/**
 * Created by andre on 04.12.17.
 */

public class Mates extends Activity{

    private ArrayList<MateObject> mates = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mates);
        loadMates();
        init();
    }

    public void init() {
        ListView matesListView = (ListView) findViewById(R.id.mates_listView);
        Button btn_add = findViewById(R.id.btn_mate_add);

        String[] mateNames = new String[mates.size()];
        for(int i = 0; i < mates.size(); i++){
            mateNames[i] = mates.get(i).getName();
            System.out.println(mateNames[i]);
        }
        ListAdapter matesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, mateNames);
        matesListView.setAdapter(matesAdapter);

        matesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String contact = mates.get(i).getContact();
                Toast.makeText(Mates.this, contact, Toast.LENGTH_LONG).show();
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Mates.this);
                View mView = getLayoutInflater().inflate(R.layout.search_mate_dialog, null);
                final EditText search_name = (EditText) mView.findViewById(R.id.input_name);
                final Button btn_ok = (Button) mView.findViewById(R.id.btn_ok);
                btn_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(Mates.this, "looking for " + search_name.getText(), Toast.LENGTH_LONG).show();
                        Toast.makeText(Mates.this, "No match", Toast.LENGTH_LONG).show();
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

    }

    private void loadMates() {
        //Beispielfreunde laden
        mates.add(new MateObject("Rikkert Biemans", "rikkert@123.de"));
        mates.add(new MateObject("Richard Batsbak", "richard@abc.de"));
        mates.add(new MateObject("Gerrie van Boven", "gerrie3@xyz.de"));
    }

    private void saveMates() {

    }

}
