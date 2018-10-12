package com.alicagatay.predictthenumber;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import static com.alicagatay.predictthenumber.util.UserUtil.prevPoint;
import static com.alicagatay.predictthenumber.util.UserUtil.trialTotal;

public class SaveSharedPreference
{
    static final String PREF_USER_NAME= "username";
    static final String PREF_USER_POINT = "userpoint";

    static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setUserName(Context ctx, String userName) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_USER_NAME, userName);
        editor.commit();
        trialTotal = 0;
        setUserPoint(ctx, String.valueOf(trialTotal));

    }

    public static String getUserName(Context ctx) {
        return getSharedPreferences(ctx).getString(PREF_USER_NAME, "");
    }

    public static void setUserPoint(Context ctx, String userPoint) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_USER_POINT, userPoint);
        editor.commit();
        prevPoint = Integer.valueOf(userPoint);

    }

    public static String getUserPoint(Context ctx) {
        return getSharedPreferences(ctx).getString(PREF_USER_POINT, "");
    }
}