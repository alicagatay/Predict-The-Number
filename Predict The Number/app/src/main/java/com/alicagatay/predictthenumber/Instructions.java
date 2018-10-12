package com.alicagatay.predictthenumber;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Instructions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
    }

    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }

    public void onButtonClick(View v) {
        if (v == findViewById(R.id.home)) {
            HomeLevel();
        } else if (v == findViewById(R.id.start)) {
            StartLevel();
        }
    }




    public void HomeLevel(){
        startActivity(new Intent(Instructions.this, MainActivity.class));
    }


    public void StartLevel(){
        startActivity(new Intent(Instructions.this, MainActivity2.class));
    }
}
