package com.example.ftipip.moneytrackerv;

/**
 * Created by ftipip on 28.08.2015.
 */
public class Expense {

    String title, date;
    Integer sum;

    public Expense(String title, Integer sum, String date) {
        this.title = title;
        this.sum = sum;
        this.date = date;
    }
}
