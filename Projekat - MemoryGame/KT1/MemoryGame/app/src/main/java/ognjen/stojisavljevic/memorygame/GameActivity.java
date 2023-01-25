package ognjen.stojisavljevic.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    private Button dugme1;
    private Button dugme2;
    private Button dugme3;
    private Button dugme4;
    private Button dugme5;
    private Button dugme6;
    private Button dugme7;
    private Button dugme8;
    private Button dugme9;
    private Button dugme10;
    private Button dugme11;
    private Button dugme12;
    private Button dugme13;
    private Button dugme14;
    private Button dugme15;
    private Button dugme16;
    private Button startbutton;
    private Button statisticbutton;

    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;
    private ImageView image6;
    private ImageView image7;
    private ImageView image8;
    private ImageView image9;
    private ImageView image10;
    private ImageView image11;
    private ImageView image12;
    private ImageView image13;
    private ImageView image14;
    private ImageView image15;
    private ImageView image16;

    private int startcounter = 0;
    private int buttoncoutner = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        dugme1 = findViewById(R.id.button1);
        dugme2 = findViewById(R.id.button2);
        dugme3 = findViewById(R.id.button3);
        dugme4 = findViewById(R.id.button4);
        dugme5 = findViewById(R.id.button5);
        dugme6 = findViewById(R.id.button6);
        dugme7 = findViewById(R.id.button7);
        dugme8 = findViewById(R.id.button8);
        dugme9 = findViewById(R.id.button9);
        dugme10 = findViewById(R.id.button10);
        dugme11 = findViewById(R.id.button11);
        dugme12 = findViewById(R.id.button12);
        dugme13 = findViewById(R.id.button13);
        dugme14 = findViewById(R.id.button14);
        dugme15 = findViewById(R.id.button15);
        dugme16 = findViewById(R.id.button16);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);
        image10 = findViewById(R.id.image10);
        image11 = findViewById(R.id.image11);
        image12 = findViewById(R.id.image12);
        image13 = findViewById(R.id.image13);
        image14 = findViewById(R.id.image14);
        image15 = findViewById(R.id.image15);
        image16 = findViewById(R.id.image16);

        dugme1.setOnClickListener(this);
        dugme2.setOnClickListener(this);
        dugme3.setOnClickListener(this);
        dugme4.setOnClickListener(this);
        dugme5.setOnClickListener(this);
        dugme6.setOnClickListener(this);
        dugme7.setOnClickListener(this);
        dugme8.setOnClickListener(this);
        dugme9.setOnClickListener(this);
        dugme10.setOnClickListener(this);
        dugme11.setOnClickListener(this);
        dugme12.setOnClickListener(this);
        dugme13.setOnClickListener(this);
        dugme14.setOnClickListener(this);
        dugme15.setOnClickListener(this);
        dugme16.setOnClickListener(this);

        startbutton = findViewById(R.id.startButton);
        statisticbutton = findViewById(R.id.statisticButton);



        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(startcounter == 0)
            {
                dugme1.setEnabled(true);
                dugme2.setEnabled(true);
                dugme3.setEnabled(true);
                dugme4.setEnabled(true);
                dugme5.setEnabled(true);
                dugme6.setEnabled(true);
                dugme7.setEnabled(true);
                dugme8.setEnabled(true);
                dugme9.setEnabled(true);
                dugme10.setEnabled(true);
                dugme11.setEnabled(true);
                dugme12.setEnabled(true);
                dugme13.setEnabled(true);
                dugme14.setEnabled(true);
                dugme15.setEnabled(true);
                dugme16.setEnabled(true);
                startbutton.setBackgroundColor(Color.BLUE);
                startbutton.setText("RESTART");
                startcounter++;
            }
            else if(startcounter == 1)
            {
                startbutton.setBackgroundColor(Color.RED);
                startbutton.setText("START");
                startcounter = 0;
                dugme1.setEnabled(false);
                dugme2.setEnabled(false);
                dugme3.setEnabled(false);
                dugme4.setEnabled(false);
                dugme5.setEnabled(false);
                dugme6.setEnabled(false);
                dugme7.setEnabled(false);
                dugme8.setEnabled(false);
                dugme9.setEnabled(false);
                dugme10.setEnabled(false);
                dugme11.setEnabled(false);
                dugme12.setEnabled(false);
                dugme13.setEnabled(false);
                dugme14.setEnabled(false);
                dugme15.setEnabled(false);
                dugme16.setEnabled(false);
                image1.setVisibility(View.INVISIBLE);
                dugme1.setVisibility(View.VISIBLE);
                image2.setVisibility(View.INVISIBLE);
                dugme2.setVisibility(View.VISIBLE);
                image3.setVisibility(View.INVISIBLE);
                dugme3.setVisibility(View.VISIBLE);
                image4.setVisibility(View.INVISIBLE);
                dugme4.setVisibility(View.VISIBLE);
                image5.setVisibility(View.INVISIBLE);
                dugme5.setVisibility(View.VISIBLE);
                image6.setVisibility(View.INVISIBLE);
                dugme6.setVisibility(View.VISIBLE);
                image7.setVisibility(View.INVISIBLE);
                dugme7.setVisibility(View.VISIBLE);
                image8.setVisibility(View.INVISIBLE);
                dugme8.setVisibility(View.VISIBLE);
                image9.setVisibility(View.INVISIBLE);
                dugme9.setVisibility(View.VISIBLE);
                image10.setVisibility(View.INVISIBLE);
                dugme10.setVisibility(View.VISIBLE);
                image11.setVisibility(View.INVISIBLE);
                dugme11.setVisibility(View.VISIBLE);
                image12.setVisibility(View.INVISIBLE);
                dugme12.setVisibility(View.VISIBLE);
                image13.setVisibility(View.INVISIBLE);
                dugme13.setVisibility(View.VISIBLE);
                image14.setVisibility(View.INVISIBLE);
                dugme14.setVisibility(View.VISIBLE);
                image15.setVisibility(View.INVISIBLE);
                dugme15.setVisibility(View.VISIBLE);
                image16.setVisibility(View.INVISIBLE);
                dugme16.setVisibility(View.VISIBLE);

            }


            }
        });

        statisticbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameActivity.this, StatisticActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(buttoncoutner < 2)
        {
            switch (view.getId())
            {
                case R.id.button1:
                    image1.setVisibility(View.VISIBLE);
                    dugme1.setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button2:
                    image2.setVisibility(View.VISIBLE);
                    dugme2.setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button3:
                    image3.setVisibility(View.VISIBLE);
                    dugme3.setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button4:
                    image4.setVisibility(View.VISIBLE);
                    dugme4.setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button5:
                    image5.setVisibility(View.VISIBLE);
                    dugme5.setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button6:
                    image6.setVisibility(View.VISIBLE);
                    dugme6.setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button7:
                    image7.setVisibility(View.VISIBLE);
                    dugme7.setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button8:
                    image8.setVisibility(View.VISIBLE);
                    dugme8.setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button9:
                    image9.setVisibility(View.VISIBLE);
                    dugme9.setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button10:
                    image10.setVisibility(View.VISIBLE);
                    dugme10.setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button11:
                    image11.setVisibility(View.VISIBLE);
                    dugme11.setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button12:
                    image12.setVisibility(View.VISIBLE);
                    dugme12.setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button13:
                    image13.setVisibility(View.VISIBLE);
                    dugme13.setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button14:
                    image14.setVisibility(View.VISIBLE);
                    dugme14.setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button15:
                    image15.setVisibility(View.VISIBLE);
                    dugme15.setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button16:
                    image16.setVisibility(View.VISIBLE);
                    dugme16.setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;

            }
        }
        else if(buttoncoutner == 2)
        {
            buttoncoutner = 0;
            image1.setVisibility(View.INVISIBLE);
            dugme1.setVisibility(View.VISIBLE);
            image2.setVisibility(View.INVISIBLE);
            dugme2.setVisibility(View.VISIBLE);
            image3.setVisibility(View.INVISIBLE);
            dugme3.setVisibility(View.VISIBLE);
            image4.setVisibility(View.INVISIBLE);
            dugme4.setVisibility(View.VISIBLE);
            image5.setVisibility(View.INVISIBLE);
            dugme5.setVisibility(View.VISIBLE);
            image6.setVisibility(View.INVISIBLE);
            dugme6.setVisibility(View.VISIBLE);
            image7.setVisibility(View.INVISIBLE);
            dugme7.setVisibility(View.VISIBLE);
            image8.setVisibility(View.INVISIBLE);
            dugme8.setVisibility(View.VISIBLE);
            image9.setVisibility(View.INVISIBLE);
            dugme9.setVisibility(View.VISIBLE);
            image10.setVisibility(View.INVISIBLE);
            dugme10.setVisibility(View.VISIBLE);
            image11.setVisibility(View.INVISIBLE);
            dugme11.setVisibility(View.VISIBLE);
            image12.setVisibility(View.INVISIBLE);
            dugme12.setVisibility(View.VISIBLE);
            image13.setVisibility(View.INVISIBLE);
            dugme13.setVisibility(View.VISIBLE);
            image14.setVisibility(View.INVISIBLE);
            dugme14.setVisibility(View.VISIBLE);
            image15.setVisibility(View.INVISIBLE);
            dugme15.setVisibility(View.VISIBLE);
            image16.setVisibility(View.INVISIBLE);
            dugme16.setVisibility(View.VISIBLE);
        }

    }
}