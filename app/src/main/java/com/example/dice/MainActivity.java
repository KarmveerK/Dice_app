package com.example.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imgDice;
    private Random rng = new Random();
    Vibrator dice_vibrator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dice_vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);

        imgDice = findViewById(R.id.imgDice);
        imgDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                YoYo.with(Techniques.Tada)
                        .duration(400)
                        .repeat(1)
                        .playOn(findViewById(R.id.imgDice));
                dice_vibrator.vibrate(50);

                rollDice();

            }
        });
    }
    private void rollDice() {
        int randomNumber = rng.nextInt(6) + 1 ;
        TextView txtView = findViewById(R.id.txtView);
        switch (randomNumber) {
            case 1 :
                imgDice.setImageResource(R.drawable.dice1);
                txtView.setText("YOU GOT A 1 !");
                break;
            case 2:
                imgDice.setImageResource(R.drawable.dice2);
                txtView.setText("YOU GOT A 2 !");
                break;
            case 3:
                imgDice.setImageResource(R.drawable.dice3);
                txtView.setText("YOU GOT A 3 !");
                break;
            case 4:
                imgDice.setImageResource(R.drawable.dice4);
                txtView.setText("YOU GOT A 4 !");
                break;
            case 5:
                imgDice.setImageResource(R.drawable.dice5);
                txtView.setText("YOU GOT A 5 !");
                break;
            case 6:
                imgDice.setImageResource(R.drawable.dice6);
                txtView.setText("YOU GOT A 6 !");
                break;


        }
    }
}