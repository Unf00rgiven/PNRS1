package ognjen.stojisavljevic.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StatisticActivity extends AppCompatActivity {

    private ListView list;
    private Adapter adapter;
    private String[] results;
    private String username;
    PlayerDBHelper dbHelper;
    Map<String, String[]> map = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);

        list = findViewById(R.id.list);
        adapter = new Adapter(this);
        list.setAdapter(adapter);

        dbHelper = new PlayerDBHelper(this);
        Intent intent = getIntent();
        username = intent.getStringExtra("Username");

        results = dbHelper.readResultForPlayer(username);
        map = dbHelper.dataBase();

        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            adapter.addElement(new Element(entry.getKey(), entry.getKey() + "@gmail.com", Collections.max(Arrays.asList(entry.getValue())), Collections.min(Arrays.asList(entry.getValue()))));
        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(StatisticActivity.this, DetailsActivity.class);
                Element e = (Element) adapter.getItem(i);
                intent.putExtra("username",e.getUsername());
                startActivity(intent);
            }
        });

    }
}