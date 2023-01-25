package rad.sa.listama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lista);

        KarakterAdapter characterAdapter = new KarakterAdapter(this);
        characterAdapter.AddCharacter(new Character());
        listView.setAdapter(characterAdapter);


    }
}