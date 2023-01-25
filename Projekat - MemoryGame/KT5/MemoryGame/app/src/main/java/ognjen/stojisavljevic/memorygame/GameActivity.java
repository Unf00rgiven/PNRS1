package ognjen.stojisavljevic.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView[] image;
    private Button[] button;
    private Button startbutton;
    private Button statisticbutton;
    private int startStopCounter = 0;
    private int buttoncoutner;
    private boolean[] hit;
    private double points = 0;
    private int gameID = 1;
    private String username;
    PlayerDBHelper dbHelper;
    int flag;
    Random r;
    String postURL = "http://192.168.152.51:3000/score";
    HttpHelper httpHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        button = new Button[16];
        image = new ImageView[16];
        Intent intent = getIntent();
        username = intent.getStringExtra("username");

        dbHelper = new PlayerDBHelper(this);
        httpHelper = new HttpHelper();


        image[0] = findViewById(R.id.image1);
        image[1] = findViewById(R.id.image2);
        image[2] = findViewById(R.id.image3);
        image[3] = findViewById(R.id.image4);
        image[4] = findViewById(R.id.image5);
        image[5] = findViewById(R.id.image6);
        image[6] = findViewById(R.id.image7);
        image[7] = findViewById(R.id.image8);
        image[8] = findViewById(R.id.image9);
        image[9] = findViewById(R.id.image10);
        image[10] = findViewById(R.id.image11);
        image[11] = findViewById(R.id.image12);
        image[12] = findViewById(R.id.image13);
        image[13] = findViewById(R.id.image14);
        image[14] = findViewById(R.id.image15);
        image[15] = findViewById(R.id.image16);

        button[0] = findViewById(R.id.button1);
        button[1] = findViewById(R.id.button2);
        button[2] = findViewById(R.id.button3);
        button[3] = findViewById(R.id.button4);
        button[4] = findViewById(R.id.button5);
        button[5] = findViewById(R.id.button6);
        button[6] = findViewById(R.id.button7);
        button[7] = findViewById(R.id.button8);
        button[8] = findViewById(R.id.button9);
        button[9] = findViewById(R.id.button10);
        button[10] = findViewById(R.id.button11);
        button[11] = findViewById(R.id.button12);
        button[12] = findViewById(R.id.button13);
        button[13] = findViewById(R.id.button14);
        button[14] = findViewById(R.id.button15);
        button[15] = findViewById(R.id.button16);

        for(Button button : button){
            button.setOnClickListener(this);
            button.setEnabled(false);
        }

        for(ImageView image : image){
            image.setVisibility(View.INVISIBLE);
        }

        startbutton = findViewById(R.id.startButton);
        statisticbutton = findViewById(R.id.statisticButton);

        hit = new boolean[16];

        for(boolean hit : hit){
            hit = false;
        }


        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] imagesID = {R.drawable.bole, R.drawable.ogi, R.drawable.anja, R.drawable.dule, R.drawable.trile, R.drawable.pako, R.drawable.uki, R.drawable.rajko,
                        R.drawable.bole, R.drawable.ogi, R.drawable.anja, R.drawable.dule, R.drawable.trile, R.drawable.pako, R.drawable.uki, R.drawable.rajko};
                r = new Random();
                int k = 0;
                while(k < 16){
                    int index = r.nextInt(imagesID.length);
                    int id = imagesID[index];
                    if(id != 0)
                    {
                        image[k].setImageResource(id);
                        imagesID[index] = 0;
                        k++;
                    }

                }
                startStopCounter++;
                if( startStopCounter %2 != 0)
                {
                    startbutton.setBackgroundColor(Color.BLUE);
                    startbutton.setText("RESTART");

                    for(View button: button){
                        button.setEnabled(true);
                    }

                }
                else
                {
                    startbutton.setBackgroundColor(Color.RED);
                    startbutton.setText("START");
                    gameID ++;

                    for(int i = 0; i < 16; i++)
                    {
                        if(hit[i] == false) points = -1;
                    }


                    Element game = new Element(gameID, username, username + "@gmail.com", String.valueOf((int)points));
                    dbHelper.insert(game);

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                JSONObject jsonObject = new JSONObject();
                                jsonObject.put("username", username);
                                jsonObject.put("score", (int)points);
                                flag = httpHelper.postJSONObjectFromURL(postURL, jsonObject);
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            if(flag == 201){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast toast = Toast.makeText(getApplicationContext(), "Points sent", Toast.LENGTH_LONG);
                                        toast.show();
                                    }
                                });
                            } else if(flag == 400){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast toast = Toast.makeText(getApplicationContext(), "Points not sent", Toast.LENGTH_LONG);
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

                    for (int i = 0; i < 16; i++)
                    {
                        button[i].setEnabled(false);
                        image[i].setVisibility(View.INVISIBLE);
                        button[i].setVisibility(View.VISIBLE);
                        hit[i] = false;
                    }

                    points = 0;
                }
            }
        });

        statisticbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dbHelper.dataBase() != null) {
                    Intent intent = new Intent(GameActivity.this, StatisticActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(buttoncoutner <= 1)
        {
            switch (view.getId())
            {
                case R.id.button1:
                    image[0].setVisibility(View.VISIBLE);
                    button[0].setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button2:
                    image[1].setVisibility(View.VISIBLE);
                    button[1].setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button3:
                    image[2].setVisibility(View.VISIBLE);
                    button[2].setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button4:
                    image[3].setVisibility(View.VISIBLE);
                    button[3].setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button5:
                    image[4].setVisibility(View.VISIBLE);
                    button[4].setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button6:
                    image[5].setVisibility(View.VISIBLE);
                    button[5].setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button7:
                    image[6].setVisibility(View.VISIBLE);
                    button[6].setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button8:
                    image[7].setVisibility(View.VISIBLE);
                    button[7].setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button9:
                    image[8].setVisibility(View.VISIBLE);
                    button[8].setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button10:
                    image[9].setVisibility(View.VISIBLE);
                    button[9].setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button11:
                    image[10].setVisibility(View.VISIBLE);
                    button[10].setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button12:
                    image[11].setVisibility(View.VISIBLE);
                    button[11].setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button13:
                    image[12].setVisibility(View.VISIBLE);
                    button[12].setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button14:
                    image[13].setVisibility(View.VISIBLE);
                    button[13].setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button15:
                    image[14].setVisibility(View.VISIBLE);
                    button[14].setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;
                case R.id.button16:
                    image[15].setVisibility(View.VISIBLE);
                    button[15].setVisibility(View.INVISIBLE);
                    buttoncoutner++;
                    break;

            }
        }
        if(buttoncoutner == 2)
        {
            buttoncoutner = 0;

            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    if (image[i].getVisibility() == View.VISIBLE && image[j].getVisibility() == View.VISIBLE && hit[i] == false && hit[j] == false && i != j) {
                        if (image[i].getDrawable().getConstantState().equals(image[j].getDrawable().getConstantState())) {
                            hit[i] = true;
                            hit[j] = true;
                            points += 5;
                        }
                        else points -= 0.5;
                    }
                }
            }

            for (int i = 0; i < 16; i++) {
                button[i].setEnabled(false);
            }

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 16; i++) {
                        if (hit[i] == false) {
                            image[i].setVisibility(View.INVISIBLE);
                            button[i].setVisibility(View.VISIBLE);
                        }

                    }
                    for (int i = 0; i < 16; i++) {
                        button[i].setEnabled(true);
                    }
                }
            }, 500);

        }

    }
}