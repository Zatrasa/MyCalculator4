package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public Calculator calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calc = new Calculator();

        TextView res_text = findViewById(R.id.res_text);
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);
        Button button0 = findViewById(R.id.button_0);
        Button button_plus = findViewById(R.id.button_plus);
        Button button_minus = findViewById(R.id.button_minus);
        Button button_sub = findViewById(R.id.button_sub);
        Button button_div = findViewById(R.id.button_div);
        Button button_res = findViewById(R.id.button_res);
        Button button_point = findViewById(R.id.button_point);
//        button1.setOnClickListener(v -> {
//            calc.setCur_val("1");
//            res_text.setText(calc.getCur_val());
//        });
        Button_init(button1, res_text, "1");
        Button_init(button2, res_text, "2");
        Button_init(button3, res_text, "3");
        Button_init(button4, res_text, "4");
        Button_init(button5, res_text, "5");
        Button_init(button6, res_text, "6");
        Button_init(button7, res_text, "7");
        Button_init(button8, res_text, "8");
        Button_init(button9, res_text, "9");
        Button_init(button0, res_text, "0");
        Button_action_init(button_plus, res_text, '+');
        Button_action_init(button_minus, res_text, '-');
        Button_action_init(button_sub, res_text, '*');
        Button_action_init(button_div, res_text, '/');
        Button_result_init(button_res, res_text);
        Button_point_init(button_point, res_text);
    }

    public void Button_point_init(Button but, TextView txt) {
        but.setOnClickListener(v -> {
            calc.addPoint();
            txt.setText(calc.getCur_val());
        });
    }

    public void Button_init(Button but, TextView txt, String str) {
        but.setOnClickListener(v -> {
            calc.addCur_val(str);
            txt.setText(calc.getCur_val());
        });
    }

    public void Button_action_init(Button but, TextView txt, char chr) {
        but.setOnClickListener(v -> {
            calc.setAction_char(chr);
            calc.setPrev_val(calc.getCur_val());
            calc.setCur_val("");
            txt.setText(calc.getCur_val());
        });
    }

    public void Button_result_init(Button but, TextView txt) {
        but.setOnClickListener(v -> {
            char act_ch = calc.getAction_char();
            if (act_ch != ' ') {
                Math_action(act_ch);
                calc.setAction_char(' ');
                calc.setPrev_val("");
                txt.setText(calc.getCur_val());
                calc.setCur_val("");
            }
        });
    }

    public void Math_action(char act_ch) {
        switch (act_ch) {
            case ('+'):
                calc.setCur_val(String.valueOf(Double.parseDouble(calc.getPrev_val()) + Double.parseDouble(calc.getCur_val())));
                break;
            case ('-'):
                calc.setCur_val(String.valueOf(Double.parseDouble(calc.getPrev_val()) - Double.parseDouble(calc.getCur_val())));
                break;
            case ('*'):
                calc.setCur_val(String.valueOf(Double.parseDouble(calc.getPrev_val()) * Double.parseDouble(calc.getCur_val())));
                break;
            case ('/'):
                calc.setCur_val(String.valueOf(Double.parseDouble(calc.getPrev_val()) / Double.parseDouble(calc.getCur_val())));
                break;
        }
    }
}


