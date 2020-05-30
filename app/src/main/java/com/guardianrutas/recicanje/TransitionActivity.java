package com.guardianrutas.recicanje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class TransitionActivity extends AppCompatActivity {

    Button btnTransition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

        btnTransition   = (Button)findViewById(R.id.btnTransition);

        btnTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TransitionActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();


            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(TransitionActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();

            }
        },3000);

    }
}
