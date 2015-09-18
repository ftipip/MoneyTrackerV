package com.example.ftipip.moneytrackerv.database.models;

/**
 * Created by ftipip on 11.09.2015.
 */
import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Expenses")
public class Expenses extends Model {

    @Column(name = "Name")
    public String name;

    @Column(name = "Price")
    public String price;

    @Column(name = "Date")
    public String date;

    @Column(name = "Category")
    public Categories categories;

    public Expenses() {
        super();
    }

    public Expenses(String name, String price, String date, Categories categories) {
        super();
        this.name = name;
        this.price = price;
        this.date = date;
        this.categories = categories;
    }
}