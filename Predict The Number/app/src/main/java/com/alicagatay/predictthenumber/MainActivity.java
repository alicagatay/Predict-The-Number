/**
 * PredictTheNumber version 1
 * A game created by Ali Çağatay
 * August 2018
 */

/**
 * MainActivity Class version 1
 */

/**
 * The aim of the game is to predict numbers between different ranges. In the game there are
 * 4 different levels and in each level the the range increases.
 */

/**
 * The main package of the game.
 */
package com.alicagatay.predictthenumber;


/**
 * The imports for the MainActivity class.
 */
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.multidex.MultiDex;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;



/**
 * The MainActivity class is the main page that appears when we launch our application.
 * This page contains 1 panel that shows the point of the user and 2 buttons, 1 to start
 * the game and the other to
 */
public class MainActivity extends AppCompatActivity{



    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


    @Override

    /**
     * The onCreate method is used to open the application page when the user launched it.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // With the help of getUserName method in the SaveSharedPreference class, the program
        // applies the username it obtains in the last session to the username variable.
        String username = SaveSharedPreference.getUserName(this);

        // With the help of getUserPoint method in the SaveSharedPreference class, the program
        // applies the point it obtains in the last session to the userPoint variable.
        String userPoint = SaveSharedPreference.getUserPoint(this);

        // Setting the page view of activity_main.xml to our class.
        setContentView(R.layout.activity_main);

        // Setting a TextView variable to the trialTotal button in activity_main.xml.
        TextView deneme = findViewById(R.id.trialTotal);

        // Setting the text of the TextView variable deneme.
        deneme.setText(userPoint);

        // Setting the orientation of the game to portrait.
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);





        /**
         * The algorithm used to understand if user registered in to app before.
         */
        // If not, register the user into the game.
        if (SaveSharedPreference.getUserName(MainActivity.this).length() == 0) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Please login into system in order to save your stats.");
            builder.setCancelable(false);
            builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getApplicationContext(), "Ad!", Toast.LENGTH_SHORT);
                    Login();
                }
            }).show();
        }
        // If yes, display a welcome message to the user.
        else if (SaveSharedPreference.getUserName(MainActivity.this).length() > 0) {
            Toast toast = Toast.makeText(getApplicationContext(), "Welcome back " + username + ".", Toast.LENGTH_LONG);
            toast.show();

        }
    }


    @Override
    /**
     * This method disables the usage of back button in the game.
     */
    public void onBackPressed() {


    }
        /**
         * The method that helps the program to operate a function when the user presses on a button.
         */
        public void onButtonClick (View v){
            // If the user presses on start, operate the NextLevel function.
            // Else if the user presses on instructions, operate Instructions
            // function.
            if (v == findViewById(R.id.start)) {
                NextLevel();
            } else if (v == findViewById(R.id.instructions)) {
                Instructions();
            }
        }

        /**
         * The method that will help program to continue with the next level.
         */
        public void NextLevel () {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        }


        /**
         * The method that will help program to display the instructions.
         */
        public void Instructions () {
            startActivity(new Intent(MainActivity.this, Instructions.class));
        }


        /**
         * The method that will help program to display the login form to the user.
         */
        public void Login () {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }

