package com.example.layoutactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private EditText editText;
    private Button dugme1;
    private Button dugme2;
    private Button dugme3;
    private Button dugme4;
    private Button dugme5;
    private Button dugme6;
    private Button dugme7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textview);
        dugme1 = findViewById(R.id.button1);
        dugme2 = findViewById(R.id.button2);
        dugme3 = findViewById(R.id.button3);
        dugme4 = findViewById(R.id.button4);
        dugme5 = findViewById(R.id.button5);
        dugme6 = findViewById(R.id.button6);
        dugme6 = findViewById(R.id.button6);
        dugme7 = findViewById(R.id.button7);


        dugme1.setOnClickListener(this);
        dugme2.setOnClickListener(this);
        dugme3.setOnClickListener(this);
        dugme4.setOnClickListener(this);
        dugme5.setOnClickListener(this);
        dugme6.setOnClickListener(this);
        dugme7.setOnClickListener(this);

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button1:
                textView.setText(editText.getText().toString());
                break;
            case R.id.button2:
                dugme2.setBackgroundColor(Color.RED);
                break;
            case R.id.button3:
                dugme1.setVisibility(view.INVISIBLE);
                dugme2.setVisibility(view.INVISIBLE);
                dugme3.setVisibility(view.INVISIBLE);
                dugme4.setVisibility(view.INVISIBLE);
                dugme5.setVisibility(view.INVISIBLE);
                break;
            case R.id.button4:
                dugme1.setEnabled(false);
                dugme2.setEnabled(false);
                dugme3.setEnabled(false);
                dugme4.setEnabled(false);
                dugme6.setEnabled(false);
                break;
            case R.id.button5:
                dugme1.setEnabled(true);
                dugme2.setEnabled(true);
                dugme3.setEnabled(true);
                dugme4.setEnabled(true);
                dugme6.setEnabled(true);
                break;
            case R.id.button6:
                dugme1.setVisibility(view.VISIBLE);
                dugme2.setVisibility(view.VISIBLE);
                dugme3.setVisibility(view.VISIBLE);
                dugme4.setVisibility(view.VISIBLE);
                dugme5.setVisibility(view.VISIBLE);
                break;
            case R.id.button7:
                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                startActivity(intent);

        }
    }
}


