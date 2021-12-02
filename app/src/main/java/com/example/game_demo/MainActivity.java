package com.example.game_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //0 for zero , 1 for cross , 2 for empty ,
    int activePlayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int [][] winingPosition ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameActive =true;


    public void fade(View view){
        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if(gameState[tappedCounter] == 2 && gameActive) {

            gameState[tappedCounter] = activePlayer;

            counter.setTranslationY(-1500);

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.zero);

                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.cross);

                activePlayer = 0;
            }
            counter.animate().translationYBy(1500).setDuration(300);

            for (int[] winingPosition : winingPosition) {
                if (gameState[winingPosition[0]] == gameState[winingPosition[1]] && gameState[winingPosition[1]] == gameState[winingPosition[2]] && gameState[winingPosition[0]] != 2) {

                    gameActive = false;

                    String winner = "";

                    if (activePlayer == 1) {
                        winner = "zero";
                    } else {
                        winner = "cross";
                    }

                    Button playAgain = (Button) findViewById(R.id.playAgainButton);
                    TextView message = (TextView) findViewById(R.id.message);

                    message.setText(winner + "has won");
                    message.setVisibility(view.VISIBLE);

                    playAgain.setVisibility(view.VISIBLE);

                }

            }

        }

    }

    public void play(View view){

        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
        TextView message = (TextView) findViewById(R.id.message);

        message.setVisibility(view.INVISIBLE);

        playAgainButton.setVisibility(view.INVISIBLE);


        androidx.gridlayout.widget.GridLayout gridLayout = (androidx.gridlayout.widget.GridLayout) findViewById(R.id.gridLayout);


        for (int i =0; i <gridLayout.getChildCount(); i++ ){
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }

        for (int j=0; j<gameState.length;j++){
            gameState[j]=2;
        }

         activePlayer = 0;
         gameActive =true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






       }
}