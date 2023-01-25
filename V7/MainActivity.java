package com.example.databaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    StudentAdapter adapter;
    StudentDbHelper dbHelper;
    private final String DB_NAME = "students.db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAdd = findViewById(R.id.button_add);
        //Button buttonNew = findViewById(R.id.button_new_act);
        buttonAdd.setOnClickListener(this);
        //dretgdregbuttonNew.setOnClickListener(this);

        adapter = new StudentAdapter(this);
        ListView lista = findViewById(R.id.list_students);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(this);

        dbHelper = new StudentDbHelper(this, DB_NAME, null, 1);

        Student[] students = dbHelper.readStudents();
        adapter.update(students);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Student student = (Student) adapter.getItem(i);
        dbHelper.delete(student.getIndex());
        adapter.remove(student);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_add) {
            Student student = new Student(getInput(R.id.firstname),
                    getInput(R.id.lastname), getInput(R.id.indexnumber));
            dbHelper.insert(student);
            adapter.add(student);
        }
    }

    public String getInput(int id) {
        EditText edit = findViewById(id);
        return edit.getText().toString();
    }
}