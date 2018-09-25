package com.example.somethingcoolapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button rockButton;
    private Button paperButton;
    private Button scissorsButton;

    private TextView cpuPlayer;
    private TextView playerChoice;
    private ImageView gameResult;

    private MediaPlayer winSound;
    private MediaPlayer loseSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cpuPlayer = findViewById(R.id.cpuPlayer);
        playerChoice = findViewById(R.id.playerChoice);
        gameResult = findViewById(R.id.gameResult);

        rockButton = findViewById(R.id.rockButton);
        paperButton = findViewById(R.id.paperButton);
        scissorsButton = findViewById(R.id.scissorsButton);

        winSound = MediaPlayer.create(this, R.raw.success_sound);
        loseSound = MediaPlayer.create(this, R.raw.fail_buzzer);

        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playGame(0);
            }
        });

        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playGame(1);
            }
        });

        scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playGame(2);
            }
        });
    }

    private void playGame (int played)
    {
        int cpu = (int) (Math.random() * 3);
        System.out.println(cpu);

        if (cpu == 0)
        {
            cpuPlayer.setText("CPU: Rock");
        }
        else if (cpu == 1)
        {
            cpuPlayer.setText("CPU: Paper");
        }
        else if (cpu == 2)
        {
            cpuPlayer.setText("CPU: Scissors");
        }
        else
        {
            cpuPlayer.setText(cpu);
        }

        if (played == 0)
        {
            playerChoice.setText("You: Rock");
        }
        else if (played == 1)
        {
            playerChoice.setText("You: Paper");
        }
        else
        {
            playerChoice.setText("You: Scissor");
        }

        if (cpu == played)
        {
            showTie();
        }
        else if (cpu - 1 == played || (cpu == 0 && played == 2))
        {
            showLose();
        }
        else
        {
            showWin();
        }
    }

    private void showLose ()
    {
        loseSound.start();
        gameResult.setImageResource(R.drawable.defeat);
    }

    private void showWin ()
    {
        winSound.start();
        gameResult.setImageResource(R.drawable.victory);
    }

    private void showTie ()
    {
        loseSound.start();
        gameResult.setImageResource(R.drawable.tie);
    }
}
