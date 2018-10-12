package com.alicagatay.predictthenumber;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Random;

import static com.alicagatay.predictthenumber.util.UserUtil.deneme;
import static com.alicagatay.predictthenumber.util.UserUtil.downArrow;
import static com.alicagatay.predictthenumber.util.UserUtil.incorrect;
import static com.alicagatay.predictthenumber.util.UserUtil.interval;
import static com.alicagatay.predictthenumber.util.UserUtil.preText;
import static com.alicagatay.predictthenumber.util.UserUtil.trial2;
import static com.alicagatay.predictthenumber.util.UserUtil.upArrow;
import static com.alicagatay.predictthenumber.util.UserUtil.*;

public class MainActivity3 extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;

    Random rand = new Random();
    int random_num;
    int num;
    boolean digit1Filled = false;
    Toast toast;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        upArrow = findViewById(R.id.up_arrow);
        downArrow = findViewById(R.id.down_arrow);
        incorrect = findViewById(R.id.Incorrect);

        upArrow.setVisibility(View.INVISIBLE);
        downArrow.setVisibility(View.INVISIBLE);
        incorrect.setVisibility(View.INVISIBLE);


        interval = findViewById(R.id.interval);
        preText = findViewById(R.id.textView5);
        deneme = findViewById(R.id.textView7);
        previous = findViewById((R.id.textView6));
        digit1 = findViewById(R.id.digit1);
        digit2 = findViewById(R.id.digit2);


        deneme.setVisibility(View.INVISIBLE);
        interval.setVisibility(View.VISIBLE);
        preText.setVisibility(View.INVISIBLE);


        random_num = rand.nextInt(99);
        trial2 = 1;
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);     //  Fixed Portrait orientation
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3717986943475136/8846406541");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


    }

    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }

    public void onButtonClick(View v) {


        deneme.setVisibility(View.VISIBLE);
        interval.setVisibility(View.INVISIBLE);
        preText.setVisibility(View.VISIBLE);
            if (v == findViewById(R.id.enter)) {



                if(digit1.getText().toString().isEmpty()){
                    toast = Toast.makeText(getApplicationContext(), "Please enter a number!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                    return;
                }
                num = Integer.parseInt(digit1.getText().toString() + digit2.getText().toString());
                digit1Filled = false;
                if (num != random_num) {
                    digit1.setText("");
                    digit2.setText("");
                    previous.setVisibility(TextView.VISIBLE);
                    previous.setText(Integer.toString(num));
                    deneme.setText(Integer.toString(trial2));
                    trial2++;
                    if (num > random_num) {
                        downArrow.setVisibility(View.VISIBLE);
                        upArrow.setVisibility(View.INVISIBLE);
                        incorrect.setVisibility(View.VISIBLE);
                    } else if (num < random_num) {
                        downArrow.setVisibility(View.INVISIBLE);
                        upArrow.setVisibility(View.VISIBLE);
                        incorrect.setVisibility(View.VISIBLE);
                    }
                }

            } else if (v == findViewById(R.id.button2)) {
                if(digit1Filled == false){
                    digit1.setText("0");
                    digit2.setText("");
                    digit1Filled = true;
                } else if(digit1Filled == true){
                    digit2.setText("0");
                    digit1Filled = false;
                }
            } else if (v == findViewById(R.id.button3)) {
                if(digit1Filled == false){
                    digit1.setText("1");
                    digit2.setText("");
                    digit1Filled = true;
                } else if(digit1Filled == true){
                    digit2.setText("1");
                    digit1Filled = false;
                }
            } else if (v == findViewById(R.id.button4)) {
                if(digit1Filled == false){
                    digit1.setText("2");
                    digit2.setText("");
                    digit1Filled = true;
                } else if(digit1Filled == true){
                    digit2.setText("2");
                    digit1Filled = false;
                }
            } else if (v == findViewById(R.id.button5)) {
                if(digit1Filled == false){
                    digit1.setText("3");
                    digit2.setText("");
                    digit1Filled = true;
                } else if(digit1Filled == true){
                    digit2.setText("3");
                    digit1Filled = false;
                }
            } else if (v == findViewById(R.id.button6)) {
                if(digit1Filled == false){
                    digit1.setText("4");
                    digit2.setText("");
                    digit1Filled = true;
                } else if(digit1Filled == true){
                    digit2.setText("4");
                    digit1Filled = false;
                }
            } else if (v == findViewById(R.id.button7)) {
                if(digit1Filled == false){
                    digit1.setText("5");
                    digit2.setText("");
                    digit1Filled = true;
                } else if(digit1Filled == true){
                    digit2.setText("5");
                    digit1Filled = false;
                }
            } else if (v == findViewById(R.id.button8)) {
                if(digit1Filled == false){
                    digit1.setText("6");
                    digit2.setText("");
                    digit1Filled = true;
                } else if(digit1Filled == true){
                    digit2.setText("6");
                    digit1Filled = false;
                }
            } else if (v == findViewById(R.id.button9)) {
                if(digit1Filled == false){
                    digit1.setText("7");
                    digit2.setText("");
                    digit1Filled = true;
                } else if(digit1Filled == true){
                    digit2.setText("7");
                    digit1Filled = false;
                }
            } else if (v == findViewById(R.id.button10)) {
                if(digit1Filled == false){
                    digit1.setText("8");
                    digit2.setText("");
                    digit1Filled = true;
                } else if(digit1Filled == true){
                    digit2.setText("8");
                    digit1Filled = false;
                }
            } else if (v == findViewById(R.id.button11)) {
                if(digit1Filled == false){
                    digit1.setText("9");
                    digit2.setText("");
                    digit1Filled = true;
                } else if(digit1Filled == true){
                    digit2.setText("9");
                    digit1Filled = false;
                }
            }
        ShowPopup();
    }

    void ShowPopup() {

         if(num == random_num){
             downArrow.setVisibility(View.INVISIBLE);
             upArrow.setVisibility(View.INVISIBLE);
             incorrect.setVisibility(View.INVISIBLE);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Congratulations! You finished the level in " + trial2 + " trials.");
            builder.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //Toast.makeText(MainActivity3.this, "Ad", Toast.LENGTH_LONG).show();
                    NextLevel();
                    mInterstitialAd.show();
                }
            }).show();

        }
    }



    public void NextLevel(){
        startActivity(new Intent(MainActivity3.this, MainActivity4.class));
    }
}


