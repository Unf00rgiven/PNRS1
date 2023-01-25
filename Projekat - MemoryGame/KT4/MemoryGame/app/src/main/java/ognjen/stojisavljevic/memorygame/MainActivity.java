package ognjen.stojisavljevic.memorygame;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    int flag;
    HttpHelper httpHelper = new HttpHelper();
    String postURL = "http://192.168.1.117:3000/auth/signin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText username = findViewById(R.id.edittextUsername);
        EditText password = findViewById(R.id.edittextPassword);
        Button loginbutton = findViewById(R.id.buttonLogin);
        Button registerbutton = findViewById(R.id.buttonRegister);



        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = new JSONObject();
                            jsonObject.put("username", user);
                            jsonObject.put("password", pass);
                            flag = httpHelper.postJSONObjectFromURL(postURL, jsonObject);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        if(flag == 201){
                            Intent intent = new Intent(MainActivity.this, GameActivity.class);
                            intent.putExtra("username", user);
                            startActivity(intent);
                        } else if(flag == 400){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast toast = Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_LONG);
                                    toast.show();
                                }
                            });
                        } else if(flag == -1) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast toast = Toast.makeText(getApplicationContext(), "Connection failed", Toast.LENGTH_LONG);
                                    toast.show();
                                }
                            });
                        }

                    }
                }).start();
            }
        });

        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}