package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView nLista;
    Button nSumbitButton;
    EditText neditText;
    TextView ntext1;
    ArrayAdapter<String> nListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nLista = findViewById(R.id.lista1);
        nSumbitButton = findViewById(R.id.button1);
        neditText = findViewById(R.id.edittex1);
        ntext1 = findViewById(R.id.textview1);

        nListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1);
        nLista.setAdapter(nListAdapter);

        nSumbitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textEnter = neditText.getText().toString();
                nListAdapter.add(textEnter);
            }
        });

        nLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });




    }
}