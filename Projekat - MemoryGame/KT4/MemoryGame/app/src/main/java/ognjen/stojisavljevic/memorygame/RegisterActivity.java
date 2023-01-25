package ognjen.stojisavljevic.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class RegisterActivity extends AppCompatActivity{

    HttpHelper httpHelper = new HttpHelper();
    String postURL = "http://192.168.1.117:3000/auth/signup";
    int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button register = findViewById(R.id.registerRegisterButton);
        EditText username = findViewById(R.id.registerEditTextUsername);
        EditText password = findViewById(R.id.registerEditTextPassword);
        EditText email = findViewById(R.id.registerEditTextEmail);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user,pass, mail;
                user = String.valueOf(username.getText());
                pass = String.valueOf(password.getText());
                mail = String.valueOf(email.getText());

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = new JSONObject();
                            jsonObject.put("username", user);
                            jsonObject.put("password", pass);
                            jsonObject.put("email", mail);
                            flag = httpHelper.postJSONObjectFromURL(postURL, jsonObject);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        if(flag == 201){
                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else if(flag == 400){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast toast = Toast.makeText(getApplicationContext(), "Invalid data", Toast.LENGTH_LONG);
                                    toast.show();
                                }
                            });
                        } else if(flag == -1){
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
    }
}