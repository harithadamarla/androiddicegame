package com.example.haritha.dicegame;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int score;
    Random rand;
    TextView rollResult;
    Button rollButton;
    int die1;
    int die2;
    int die3;

    ArrayList<Integer> dice;
    ArrayList<ImageView> diceImageViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        score=0;
        Toast.makeText(getApplicationContext(),"Welcome to the game",Toast.LENGTH_SHORT).show();
        rollResult=findViewById(R.id.rollResult);
        rollButton=findViewById(R.id.rollButton);

        rand=new Random();
        dice=new ArrayList();

        ImageView die1image=findViewById(R.id.die1Image);
        ImageView die2image=findViewById(R.id.die2Image);
        ImageView die3image=findViewById(R.id.die3Image);

        diceImageViews =new ArrayList<ImageView>();
        diceImageViews.add(die1image);
        diceImageViews.add(die2image);
        diceImageViews.add(die3image);
    }
    public void rollDice(View v){


        int die1=rand.nextInt(6)+1;
        int die2=rand.nextInt(6)+1;
        int die3=rand.nextInt(6)+1;

        dice.clear();
        dice.add(die1);
        dice.add(die2);
        dice.add(die3);

        String randomValue="You rolled a \t"+die1+"\t a \t"+die2+"\t a \t"+die3;
        rollResult.setText(randomValue);

        for(int i=0;i<3;i++){
                String imageName="dice"+dice.get(i)+".png";
                try{

                    InputStream stream=getAssets().open(imageName);
                    Drawable d= Drawable.createFromStream(stream,null);
                    diceImageViews.get(i).setImageDrawable(d);
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
        }




        Toast.makeText(getApplicationContext(),randomValue,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
