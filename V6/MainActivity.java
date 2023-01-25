package com.example.vezba6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView list;
    Button button;
    EditText editText;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list);
        Task task = new Task(this);
        listView.setAdapter(adapter);

        button = findViewById(R.id.dodaj);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String taskName = editText.getText().toString();
        adapter.addTask(taskName);
    }
}