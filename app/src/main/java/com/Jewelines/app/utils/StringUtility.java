package com.Jewelines.app.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class StringUtility {

    public static final String getFirst(String string,String sepaRator) {
        String[] arrSplit = null;
        try {
             arrSplit = string.split(sepaRator);
        } catch (Exception e) {

        }
        return arrSplit[0];
    }
    public static final String getSecond(String string,String sepaRator) {
        String[] arrSplit = null;
        try {
            arrSplit = string.split(sepaRator);

        } catch (Exception e) {

        }
        return arrSplit[1];
    }
    public static final String getThird(String string,String sepaRator) {
        String[] arrSplit = null;
        try {
            arrSplit = string.split(sepaRator);
        } catch (Exception e) {

        }
        return arrSplit[2];
    }
    public static final String getFourth(String string,String sepaRator) {
        String[] arrSplit = null;
        try {
            arrSplit = string.split(sepaRator);
        } catch (Exception e) {

        }
        return arrSplit[3];
    }
    static String toCamelCase(String s){
        String[] parts = s.split("_");
        String camelCaseString = "";
        for (String part : parts){
            camelCaseString = camelCaseString + toProperCase(part);
        }
        return camelCaseString;
    }

    static String toProperCase(String s) {
        return s.substring(0, 1).toUpperCase() +
                s.substring(1).toLowerCase();
    }
}
