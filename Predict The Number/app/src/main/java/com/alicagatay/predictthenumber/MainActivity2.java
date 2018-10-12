package com.alicagatay.predictthenumber;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

import static com.alicagatay.predictthenumber.util.UserUtil.downArrow;
import static com.alicagatay.predictthenumber.util.UserUtil.interval;
import static com.alicagatay.predictthenumber.util.UserUtil.preText;
import static com.alicagatay.predictthenumber.util.UserUtil.previous;
import static com.alicagatay.predictthenumber.util.UserUtil.trial1;
import static com.alicagatay.predictthenumber.util.UserUtil.upArrow;
import static com.alicagatay.predictthenumber.util.UserUtil.incorrect;
import static com.alicagatay.predictthenumber.util.UserUtil.deneme;
import static com.alicagatay.predictthenumber.util.UserUtil.digit1;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


public class MainActivity2 extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;

    Random rand = new Random();
    int random_num;
    int num;
    Toast toast;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

         upArrow = findViewById(R.id.up_arrow);
         downArrow = findViewById(R.id.down_arrow);
         incorrect = findViewById(R.id.Incorrect);

        upArrow.setVisibility(View.INVISIBLE);
        downArrow.setVisibility(View.INVISIBLE);
        incorrect.setVisibility(View.INVISIBLE);


        deneme = findViewById(R.id.textView7);
        previous = findViewById((R.id.textView6));
        digit1 = findViewById(R.id.digit1);
        interval = findViewById(R.id.interval);
        preText = findViewById(R.id.textView5);


        deneme.setVisibility(View.INVISIBLE);
        interval.setVisibility(View.VISIBLE);
        preText.setVisibility(View.INVISIBLE);



        random_num = rand.nextInt(9);
        trial1 = 1;
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

            num = Integer.parseInt(digit1.getText().toString());

            if (num != random_num) {
                    digit1.setText("");
                    previous.setVisibility(TextView.VISIBLE);
                    previous.setText(Integer.toString(num));
                    deneme.setText(Integer.toString(trial1));
                    trial1++;
                    if (num > random_num) {
                        //toast = Toast.makeText(getApplicationContext(), "Down!", Toast.LENGTH_SHORT);
                        //toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
                        //toast.show();
                        downArrow.setVisibility(View.VISIBLE);
                        upArrow.setVisibility(View.INVISIBLE);
                        incorrect.setVisibility(View.VISIBLE);


                    } else if (num < random_num) {
                        //toast = Toast.makeText(getApplicationContext(), "Up!", Toast.LENGTH_SHORT);
                        //toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
                        //toast.show();
                        upArrow.setVisibility(View.VISIBLE);
                        downArrow.setVisibility(View.INVISIBLE);
                        incorrect.setVisibility(View.VISIBLE);

                    }
                }

            } else if (v == findViewById(R.id.button2)) {
                digit1.setText("0");
            } else if (v == findViewById(R.id.button3)) {
                digit1.setText("1");
            } else if (v == findViewById(R.id.button4)) {
                digit1.setText("2");
            } else if (v == findViewById(R.id.button5)) {
                digit1.setText("3");
            } else if (v == findViewById(R.id.button6)) {
                digit1.setText("4");
            } else if (v == findViewById(R.id.button7)) {
                digit1.setText("5");
            } else if (v == findViewById(R.id.button8)) {
                digit1.setText("6");
            } else if (v == findViewById(R.id.button9)) {
                digit1.setText("7");
            } else if (v == findViewById(R.id.button10)) {
                digit1.setText("8");
            } else if (v == findViewById(R.id.button11)) {
                digit1.setText("9");
            }
        ShowPopup();
    }


    void ShowPopup() {
          if(num == random_num){
              incorrect.setVisibility(View.INVISIBLE);
              downArrow.setVisibility(View.INVISIBLE);
              upArrow.setVisibility(View.INVISIBLE);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Congratulations! You finished the level in " + trial1 + " trials.");
              builder.setCancelable(false);
              builder.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //toast = Toast.makeText(getApplicationContext(), "Ad", Toast.LENGTH_SHORT);
                    //toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
                    //toast.show();
                    NextLevel();
                    mInterstitialAd.show();
                }
            }).show();
        }
    }


    public void NextLevel(){
        startActivity(new Intent(MainActivity2.this, MainActivity3.class));
    }
}
