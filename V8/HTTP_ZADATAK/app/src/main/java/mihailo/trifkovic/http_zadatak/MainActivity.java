package mihailo.trifkovic.http_zadatak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText enteredCity;
    TextView showTemp, showHum, showPress, showDesc;
    Button btn1;
    HttpHelper httpHelper;

    public static String API_KEY = "8113823054a3e9e1c51e7643324abb3c";
    public static String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredCity = findViewById(R.id.editText);
        btn1 = findViewById(R.id.button1);
        showTemp = findViewById(R.id.showTemp);
        showHum = findViewById(R.id.showHum);
        showPress = findViewById(R.id.showPress);
        showDesc = findViewById(R.id.showDesc);
        httpHelper = new HttpHelper();

        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String location = String.valueOf(enteredCity.getText());
        String FINALURL = BASE_URL + location + "&appid=" + API_KEY + "&units=metric";

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    JSONObject jsonObject = httpHelper.getJSONObjectFromURL(FINALURL);
                    JSONObject main = jsonObject.getJSONObject("main");
                    JSONArray weather = jsonObject.getJSONArray("weather");
                    JSONObject JSONweather = weather.getJSONObject(0);  // ocekuje JSON objekat kao element pa se mora indeksirati
                    double temp = main.getDouble("temp");
                    double hum = main.getDouble("humidity");
                    double press = main.getDouble("pressure");
                    String description = JSONweather.getString("description");

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showTemp.setText(String.valueOf(temp));
                            showHum.setText(String.valueOf(hum));
                            showPress.setText(String.valueOf(press));
                            showDesc.setText(String.valueOf(description));
                        }
                    });

                } catch (IOException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showTemp.setText("");
                            showHum.setText("");
                            showPress.setText("");
                            showDesc.setText("");
                            Toast toast = Toast.makeText(getApplicationContext(), "No data for this city", Toast.LENGTH_LONG);
                            toast.show();
                        }
                    });

                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}