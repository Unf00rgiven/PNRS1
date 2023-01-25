package ognjen.stojisavljevic.memorygame;

import static android.widget.AdapterView.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class StatisticActivity extends AppCompatActivity {

    private ListView list;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);

        list = findViewById(R.id.list);
        adapter = new Adapter(this);
        list.setAdapter(adapter);

        Element e1 = new Element("Direktor", "direktornovegodine@gmail.com", 20, 1);
        adapter.addElement(e1);
        e1.addRez(10);
        e1.addRez(3);
        e1.addRez(14);
        e1.addRez(2);
        e1.addRez(4);
        e1.addRez(20);
        e1.addRez(2);
        e1.addRez(16);
        e1.addRez(5);
        e1.addRez(1);
        //adapter.addElement(e1);

        Element e2 = new Element("Ognjen", "stojisavljevic00@gmail.com", 20, 10);
        adapter.addElement(e2);
        e2.addRez(10);
        e2.addRez(3);
        e2.addRez(14);
        e2.addRez(2);
        e2.addRez(4);
        e2.addRez(20);
        e2.addRez(2);
        e2.addRez(16);
        e2.addRez(5);
        e2.addRez(1);

        Element e3 = new Element("Vojvoda", "sadinaremoji@gmail,com", 18, 2);
        adapter.addElement(e3);
        e3.addRez(10);
        e3.addRez(3);
        e3.addRez(14);
        e3.addRez(2);
        e3.addRez(4);
        e3.addRez(20);
        e3.addRez(2);
        e3.addRez(16);
        e3.addRez(5);
        e3.addRez(1);

        Element e4 = new Element("Marija", "serifovic@gmail.com", 18, 4);
        adapter.addElement(e4);
        e4.addRez(10);
        e4.addRez(3);
        e4.addRez(14);
        e4.addRez(2);
        e4.addRez(4);
        e4.addRez(20);
        e4.addRez(2);
        e4.addRez(16);
        e4.addRez(5);
        e4.addRez(1);

        Element e5 = new Element("Aleksandar", "zanasudcecu@gmail.com", 16, 6);
        adapter.addElement(e5);
        e5.addRez(10);
        e5.addRez(3);
        e5.addRez(14);
        e5.addRez(2);
        e5.addRez(4);
        e5.addRez(20);
        e5.addRez(2);
        e5.addRez(16);
        e5.addRez(5);
        e5.addRez(1);

        Element e6 = new Element("MisaVacic", "somiV@gmail.com", 20, 16);
        adapter.addElement(e6);
        e6.addRez(10);
        e6.addRez(3);
        e6.addRez(14);
        e6.addRez(2);
        e6.addRez(4);
        e6.addRez(20);
        e6.addRez(2);
        e6.addRez(16);
        e6.addRez(5);
        e6.addRez(1);

        Element e7 = new Element("Knez", "milos@gmail.com", 20, 0);
        adapter.addElement(e7);
        e7.addRez(10);
        e7.addRez(3);
        e7.addRez(14);
        e7.addRez(2);
        e7.addRez(4);
        e7.addRez(20);
        e7.addRez(2);
        e7.addRez(16);
        e7.addRez(5);
        e7.addRez(1);

        Element e8 = new Element("Serif", "konjevic1963@gmail.com", 12, 2);
        adapter.addElement(e8);
        e8.addRez(10);
        e8.addRez(3);
        e8.addRez(14);
        e8.addRez(2);
        e8.addRez(4);
        e8.addRez(20);
        e8.addRez(2);
        e8.addRez(16);
        e8.addRez(5);
        e8.addRez(1);

        Element e9 = new Element("Goran", "sicvecTVtiktok@gmail.com", 14, 2);
        adapter.addElement(e9);
        e9.addRez(10);
        e9.addRez(3);
        e9.addRez(14);
        e9.addRez(2);
        e9.addRez(4);
        e9.addRez(20);
        e9.addRez(2);
        e9.addRez(16);
        e9.addRez(5);
        e9.addRez(1);

        Element e10 = new Element("NemanjaStefan", "stefan1109@raska.com", 20, 8);
        adapter.addElement(e10);
        e10.addRez(10);
        e10.addRez(3);
        e10.addRez(14);
        e10.addRez(2);
        e10.addRez(4);
        e10.addRez(20);
        e10.addRez(2);
        e10.addRez(16);
        e10.addRez(5);
        e10.addRez(1);

        list.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(StatisticActivity.this, DetailsActivity.class);
                Element e = (Element) adapter.getItem(i);
                intent.putExtra("name",e.getUsername());
                intent.putIntegerArrayListExtra("list", adapter.resultsList(e.getUsername()));
                startActivity(intent);
            }
        });

    }
}