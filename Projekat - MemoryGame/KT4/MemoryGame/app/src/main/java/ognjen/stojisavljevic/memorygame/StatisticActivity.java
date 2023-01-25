package ognjen.stojisavljevic.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
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
    private Button refresh;
    PlayerDBHelper dbHelper;
    HttpHelper httpHelper;
    Map<String, String[]> map = new HashMap<>();
    String getURL = "http://192.168.1.117:3000/score";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);

        list = findViewById(R.id.list);
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        adapter = new Adapter(this, username);
        list.setAdapter(adapter);

        httpHelper = new HttpHelper();
        dbHelper = new PlayerDBHelper(this);


        results = dbHelper.readResultForPlayer(username);
        map = dbHelper.dataBase();

        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            adapter.addElement(new Element(entry.getKey(), entry.getKey() + "@gmail.com",
                    Collections.max(Arrays.asList(entry.getValue())), Collections.min(Arrays.asList(entry.getValue()))));
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

        refresh = findViewById(R.id.refreshbuttuon);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        JSONArray jsonArray = new JSONArray();
                        JSONObject jsonObject = new JSONObject();
                        dbHelper.deleteBase();
                        String username;
                        String gameID;
                        String score;
                        try {
                            jsonArray = httpHelper.getJSONArrayFromURL(getURL);
                            if(jsonArray == null)
                            {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {

                                        Toast toast = Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG);
                                        toast.show();
                                    }
                                });
                            }
                            for(int i = 0; i < jsonArray.length(); i++)
                            {
                                jsonObject = jsonArray.getJSONObject(i);
                                gameID = jsonObject.getString("_id");
                                username = jsonObject.getString("username");
                                score = String.valueOf(jsonObject.getInt("score"));

                                dbHelper.insert(new Element(0, username, username + "@gmail.com", score));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter.delete();
                                map = dbHelper.dataBase();

                                for (Map.Entry<String, String[]> entry : map.entrySet()) {
                                    adapter.addElement(new Element(entry.getKey(), entry.getKey() + "@gmail.com",
                                            Collections.max(Arrays.asList(entry.getValue())), Collections.min(Arrays.asList(entry.getValue()))));
                                }
                            }
                        });

                    }
                }).start();
            }
        });
    }
}