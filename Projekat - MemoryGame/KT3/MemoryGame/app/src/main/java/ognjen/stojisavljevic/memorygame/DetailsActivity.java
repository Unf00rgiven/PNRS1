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
    private String username;
    private String[] results;
    PlayerDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        list = findViewById(R.id.carrylist);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(adapter);
        user = findViewById(R.id.username2);

        Intent intent = getIntent();
        dbHelper = new PlayerDBHelper(this);
        username = intent.getStringExtra("username");
        results = dbHelper.readResultForPlayer(username);

        for(int i = 0; i < results.length; i++)
        {
            adapter.add(results[i]);
        }
        user.setText(username);

    }
}