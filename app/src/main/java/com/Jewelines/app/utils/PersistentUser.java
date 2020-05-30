package com.Jewelines.app.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PersistentUser {

    //common data
    private static final String PREFS_FILE_NAME = "JewelinesPersistent";
    private static final String CompairQuoteRate = "CompairQuoteRate";
    private static final String QuoteRate = "QuoteRate";
    private static final String WihtiutQuoteRate = "WihtiutQuoteRate";


    public static String getQuoteRate(final Context ctx) {
        return ctx.getSharedPreferences(PersistentUser.PREFS_FILE_NAME,
                Context.MODE_PRIVATE).getString(PersistentUser.QuoteRate, "1.3");
    }

    public static void setQuoteRate(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PersistentUser.PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(PersistentUser.QuoteRate, data);
        editor.commit();
    }


    public static String getWihtiutZipQuoteRate(final Context ctx) {
        return ctx.getSharedPreferences(PersistentUser.PREFS_FILE_NAME,
                Context.MODE_PRIVATE).getString(PersistentUser.WihtiutQuoteRate, "1.4");
    }

    public static void setWihtiutZipQuoteRate(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PersistentUser.PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(PersistentUser.WihtiutQuoteRate, data);
        editor.commit();
    }

    public static String getCompairQuoteRate(final Context ctx) {
        return ctx.getSharedPreferences(PersistentUser.PREFS_FILE_NAME,
                Context.MODE_PRIVATE).getString(PersistentUser.CompairQuoteRate, "2.0");
    }

    public static void setCompairQuoteRate(final Context ctx, final String data) {
        final SharedPreferences prefs = ctx.getSharedPreferences(
                PersistentUser.PREFS_FILE_NAME, Context.MODE_PRIVATE);
        final Editor editor = prefs.edit();
        editor.putString(PersistentUser.CompairQuoteRate, data);
        editor.commit();
    }


}
