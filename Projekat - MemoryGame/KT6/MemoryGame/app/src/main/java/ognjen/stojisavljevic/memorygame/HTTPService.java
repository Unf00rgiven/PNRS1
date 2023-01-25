package ognjen.stojisavljevic.memorygame;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.security.Provider;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HTTPService extends Service {

    public boolean mRun = true;
    PlayerDBHelper dbHelper;
    HttpHelper httpHelper;
    String getURL = "http://192.168.152.51:3000/score";
    static boolean DataUpdated = false;
    static boolean RefreshEnabled = true;

    @Override
    public void onCreate() {
        super.onCreate();
        dbHelper = new PlayerDBHelper(this);
        httpHelper = new HttpHelper();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mRun) {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    RefreshEnabled = false;
                    JSONArray jsonArray = new JSONArray();
                    JSONObject jsonObject = new JSONObject();
                    dbHelper.deleteBase();
                    String username;
                    String gameID;
                    String score;
                    try {
                        jsonArray = httpHelper.getJSONArrayFromURL(getURL);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            jsonObject = jsonArray.getJSONObject(i);
                            gameID = jsonObject.getString("_id");
                            username = jsonObject.getString("username");
                            score = String.valueOf(jsonObject.getInt("score"));

                            dbHelper.insert(new Element(0, username, username + "@gmail.com", score));
                        }
                        DataUpdated = true;
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    RefreshEnabled = true;
                }
            }
        }).start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service is starting", Toast.LENGTH_SHORT).show();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "Service is done", Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean DataUpdate(){
        return DataUpdated;
    }

    public void SetData(){
        DataUpdated = false;
    }

    public boolean RefreshButton(){
        return RefreshEnabled;
    }

}
