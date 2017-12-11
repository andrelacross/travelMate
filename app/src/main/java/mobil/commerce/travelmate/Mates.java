package mobil.commerce.travelmate;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

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
        ImageButton btn_add = findViewById(R.id.btn_mate_add);

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

    }

    private void loadMates() {
        mates.add(new MateObject("Name1", "name1@123.de"));
        mates.add(new MateObject("Name2", "name2@abc.de"));
        mates.add(new MateObject("Name3", "name3@xyz.de"));
    }

}
