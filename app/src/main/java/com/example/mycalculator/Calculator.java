package com.example.mycalculator;

public class Calculator {
    private double res;
    private  String cur_val;
    private  String prev_val;
    private char action_char;

    public Calculator() {
        this.res = 0;
        this.cur_val = "";
        this.prev_val = "";
        this.action_char = ' ';
    }

    public String getPrev_val() {
        return prev_val;
    }

    public void setPrev_val(String prev_val) {
        this.prev_val = prev_val;
    }

    public char getAction_char() {
        return action_char;
    }

    public void setAction_char(char action_char) {
        this.action_char = action_char;
    }

    public double getRes() {
        return res;
    }

    public void setRes(double res) {
        this.res = res;
    }

    public String getCur_val() {
        return cur_val;
    }

    public void setCur_val(String cur_val) {
        this.cur_val = cur_val;
    }

    public void addCur_val(String cur_val) {
        this.cur_val = this.cur_val+cur_val;
    }

    public void addPoint(){
        if(this.getCur_val().equals("")){
            this.setCur_val("0.");
        }
        else{
            if (this.getCur_val().indexOf('.')==-1) {
                this.addCur_val(".");
            }
        }


    }

}
