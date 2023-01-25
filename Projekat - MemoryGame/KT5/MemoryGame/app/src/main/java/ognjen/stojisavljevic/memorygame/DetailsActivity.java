package ognjen.stojisavljevic.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class DetailsActivity extends AppCompatActivity {

    private ListView list;
    private ArrayAdapter<String> adapter;
    private TextView user;
    private String username;
    private String[] results;
    PlayerDBHelper dbHelper;
    HttpHelper httpHelper;
    String playerURL = "http://192.168.152.51:3000/score/?username=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        list = findViewById(R.id.carrylist);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(adapter);
        user = findViewById(R.id.username2);

        Intent intent = getIntent();
        httpHelper = new HttpHelper();
        dbHelper = new PlayerDBHelper(this);
        username = intent.getStringExtra("username");
        playerURL = playerURL + username;
        results = dbHelper.readResultForPlayer(username);

        new Thread(new Runnable() {
            @Override
            public void run() {
                JSONArray jsonArray = new JSONArray();
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonArray = httpHelper.getJSONArrayFromURL(playerURL);
                    if(jsonArray == null)
                    {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                Toast toast = Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG);
                                toast.show();
                                Log.d("NE RADI", "ERROR");
                            }
                        });
                    }
                    String[] score = new String[jsonArray.length()];
                    for(int i = 0; i < jsonArray.length(); i++)
                    {
                        jsonObject = jsonArray.getJSONObject(i);
                        score[i] = String.valueOf(jsonObject.getInt("score"));
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            for(int i = 0; i < score.length; i++)
                            {
                                adapter.add(score[i]);
                            }
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        user.setText(username);

    }
}