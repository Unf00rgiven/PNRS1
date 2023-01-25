package mmilica.httpexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.Iterator;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private HttpHelper httpHelper;
    private ArrayAdapter<String> mListAdapter;
    public static String BASE_URL = "https://dog.ceo";
    public static String GET_ALL_DOGS = BASE_URL + "/api/breeds/list/all";
    public static String TYPE = "hound";
    public static String GET_ONE = BASE_URL + "/api/breed/" + TYPE + "/list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        httpHelper = new HttpHelper();
        mListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        ListView list = findViewById(R.id.lista);
        list.setAdapter(mListAdapter);

        findViewById(R.id.getAll).setOnClickListener(this);
        findViewById(R.id.getOne).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.getAll:
                if (!mListAdapter.isEmpty()) mListAdapter.clear();
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            JSONObject jsonobject = httpHelper.getJSONObjectFromURL(GET_ALL_DOGS);
                            JSONObject message = jsonobject.getJSONObject("message");

                            Iterator<String> iter = message.keys();
                            while (iter.hasNext()) {
                                final String key = iter.next();
                                try {
                                    JSONArray values = message.getJSONArray(key);
                                    for (int i = 0; i < values.length(); i++) {
                                        final String value = values.getString(i);
                                        runOnUiThread(new Runnable() {
                                            public void run() {
                                                mListAdapter.add(key.toUpperCase() + ": " + value);
                                            }
                                        });
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
            case R.id.getOne:
                if (!mListAdapter.isEmpty()) mListAdapter.clear();
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            JSONObject jsonobject = httpHelper.getJSONObjectFromURL(GET_ONE);
                            JSONArray message = jsonobject.getJSONArray("message");
                            for (int i = 0; i < message.length(); i++) {
                                final String value = message.getString(i);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        mListAdapter.add(value);
                                    }
                                });
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
            default:
                break;
        }
    }
}
