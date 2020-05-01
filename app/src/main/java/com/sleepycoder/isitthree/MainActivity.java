package com.sleepycoder.isitthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv_number, tv_lives;
    Button btn_yes, btn_no;

    int number = -1;
    int lives = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_number = findViewById(R.id.number);
        tv_lives = findViewById(R.id.tv_lives);
        btn_yes = findViewById(R.id.btn_yes);
        btn_no = findViewById(R.id.btn_no);

        tv_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number == -1 || lives == 0) {
                    generate_number();
                    lives = 3;
                    tv_lives.setText("Lives: " + lives);
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
                }else{
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
                    tv_number.setText("Start");
                }else{
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
