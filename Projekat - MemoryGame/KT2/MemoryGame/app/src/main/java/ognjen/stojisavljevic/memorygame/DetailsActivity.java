package ognjen.stojisavljevic.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    private ListView list;
    private ArrayAdapter<String> adapter;
    private TextView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        list = findViewById(R.id.carrylist);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(adapter);
        user = findViewById(R.id.username2);

        Intent in = getIntent();
        Bundle b = in.getExtras();

        if(b!= null){
            String name = (String) b.get("name");
            user.setText(name);
            ArrayList<String> list = b.getStringArrayList("list");
            adapter.addAll(list);
        }
    }
}