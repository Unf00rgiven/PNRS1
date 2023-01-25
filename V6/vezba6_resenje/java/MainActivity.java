package com.example.customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MyAdapter(this);
        lista = findViewById(R.id.lista);
        lista.setAdapter(adapter);

        adapter.addElement(new Element("butters_stotch",
                getDrawable(R.drawable.butters_stotch)));
        adapter.addElement(new Element("ike",
                getDrawable(R.drawable.ike)));
        adapter.addElement(new Element("jimmy_valmer",
                getDrawable(R.drawable.jimmy_valmer)));
        adapter.addElement(new Element("kenny_mccormick",
                getDrawable(R.drawable.kenny_mccormick)));
        adapter.addElement(new Element("kyle_broflovski",
                getDrawable(R.drawable.kyle_broflovski)));
        adapter.addElement(new Element("mr_garrison",
                getDrawable(R.drawable.mr_garrison)));
        adapter.addElement(new Element("mr_mackey",
                getDrawable(R.drawable.mr_mackey)));
        adapter.addElement(new Element("randy_marsh",
                getDrawable(R.drawable.randy_marsh)));
        adapter.addElement(new Element("stan_marsh",
                getDrawable(R.drawable.stan_marsh)));


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Element e = (Element) adapter.getItem(i);
                adapter.removeElementByValue(e);
                Toast.makeText(MainActivity.this, e.getmText(), Toast.LENGTH_LONG).show();
            }
        });
    }
}