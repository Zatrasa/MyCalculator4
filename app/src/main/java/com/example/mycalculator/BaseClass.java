package com.example.mycalculator;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class BaseClass extends AppCompatActivity {

    private static final String NameSharedPreference = "MyCalculator";
    private static final String Theme_Param = "MY_THEME";

    protected static final int LightStyle = 0;
    protected static final int PurpleStyle = 1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(GetThemeById(getCodeStyle(LightStyle)));
    }

    protected int GetThemeById(int codeStyle){
        switch(codeStyle){
            case LightStyle:
                return R.style.MyStyle;
            case PurpleStyle:
                return R.style.MyStylePurple;
            default:
                return R.style.MyStyle;
        }
    }

    protected int getCodeStyle(int codeStyle){
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        return sharedPref.getInt(Theme_Param, codeStyle);
    }

    // Сохранение настроек
    protected void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(Theme_Param, codeStyle);
        editor.apply();
    }
}
