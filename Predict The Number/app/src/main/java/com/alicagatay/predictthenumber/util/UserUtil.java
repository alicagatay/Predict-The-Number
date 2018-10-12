package com.alicagatay.predictthenumber.util;

import android.widget.ImageView;
import android.widget.TextView;

import com.alicagatay.predictthenumber.R;
import com.alicagatay.predictthenumber.User;

public class UserUtil {
    //The variable that will keep our user
    public static User myUser;

    //The number of trials that the user obtained in level 1
    public static int trial1;

    //The number of trials that the user obtained in level 2
    public static int trial2;

    //The number of trials that the user obtained in level 3
    public static int trial3;

    //The number of trials that the user obtained in level 4
    public static int trial4;

    //The number of trials that the user obtained at the end of the game
    public static int trialTotal;

    //The number that the user previously enters
    public static int prevPoint;

    //Up arrow image
    public static ImageView upArrow;

    //Down arrow image
    public static ImageView downArrow;

    //The incorrect text
    public static TextView incorrect;

    //The last number that we entered
    public static TextView deneme;

    //The last number that we entered
    public static TextView previous;
    public static TextView preText;

    //First digit of the number that we wrote
    public static TextView digit1;

    //Second digit of the number that we wrote
    public static TextView digit2;

    //Third digit of the number that we wrote
    public static TextView digit3;

    //Fourth digit of the number that we wrote
    public static TextView digit4;

    //Interval of the level
    public static TextView interval;
}

