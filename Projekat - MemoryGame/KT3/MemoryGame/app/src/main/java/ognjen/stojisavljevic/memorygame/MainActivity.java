package ognjen.stojisavljevic.memorygame;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText username = findViewById(R.id.edittextUsername);
        EditText password = findViewById(R.id.edittextPassword);
        Button loginbutton = findViewById(R.id.buttonLogin);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(!TextUtils.isEmpty(user) && !TextUtils.isEmpty(pass)) {
                    Intent intent = new Intent(MainActivity.this, GameActivity.class);
                    intent.putExtra("Username", user);
                    startActivity(intent);
                }
            }
        });
    }
}