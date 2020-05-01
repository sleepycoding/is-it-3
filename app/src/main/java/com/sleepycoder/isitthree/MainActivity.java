package com.sleepycoder.isitthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv_number, tv_lives, tv_message;
    ImageButton btn_yes, btn_no;

    int number = -1;
    int lives = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_number = findViewById(R.id.number);
        tv_lives = findViewById(R.id.tv_lives);
        tv_message = findViewById(R.id.tv_message);
        btn_yes = findViewById(R.id.btn_yes);
        btn_no = findViewById(R.id.btn_no);

        tv_message.setText("Press Start to play");

        tv_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number == -1 || lives == 0) {
                    generate_number();
                    lives = 3;
                    tv_lives.setText("Lives: " + lives);
                    tv_message.setText("Is the number a multiple of three?");
                    btn_yes.setVisibility(View.VISIBLE);
                    btn_no.setVisibility(View.VISIBLE);
                    tv_lives.setVisibility(View.VISIBLE);
                }
            }
        });

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number == -1 || lives == 0)
                    return;
                if (number % 3 == 0) {
                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    lives--;
                    tv_lives.setText("Lives: " + lives);
                    Toast.makeText(MainActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                }
                if (lives == 0) {
                    tv_number.setText("Start");
                    tv_message.setText("You have lost.\nPress start to play again");
                    btn_yes.setVisibility(View.GONE);
                    btn_no.setVisibility(View.GONE);
                    tv_lives.setVisibility(View.GONE);
                } else {
                    generate_number();
                }
            }
        });
        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number == -1 || lives == 0)
                    return;
                if (number % 3 != 0) {
                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    lives--;
                    tv_lives.setText("Lives: " + lives);
                    Toast.makeText(MainActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                }
                if (lives == 0) {
                    tv_message.setText("You have lost.\nPress start to play again");
                    tv_number.setText("Start");
                    btn_yes.setVisibility(View.GONE);
                    btn_no.setVisibility(View.GONE);
                    tv_lives.setVisibility(View.GONE);
                } else {
                    generate_number();
                }
            }
        });
    }

    public void generate_number() {
        number = (int) (Math.random() * 100);
        tv_number.setText(String.valueOf(number));
    }
}
