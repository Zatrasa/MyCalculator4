package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class SettingsActivity extends BaseClass{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_theme);

        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton)rg.getChildAt(getCodeStyle(LightStyle))).setChecked(true);

        initRgButton(findViewById(R.id.LightStyleBt),LightStyle);
        initRgButton(findViewById(R.id.PurpleStyleBt),PurpleStyle);

        Button bt_exit = findViewById(R.id.button_return);
        bt_exit.setOnClickListener(v -> {
            finish();
        });

    }

    protected void initRgButton(View bt, int codeStyle){
        bt.setOnClickListener(v -> {
            //Сохранить код темы в настройки
            setAppTheme(codeStyle);
            recreate();

        });
    }






}