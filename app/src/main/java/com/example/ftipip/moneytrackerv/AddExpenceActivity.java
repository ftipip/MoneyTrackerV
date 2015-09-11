package com.example.ftipip.moneytrackerv;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.StringRes;

/**
 * Created by ftipip on 10.09.2015.
 */
@EActivity(R.layout.activity_add_expense)
public class AddExpenceActivity extends AppCompatActivity {

    @ViewById
    Toolbar toolbar;

    @OptionsItem(android.R.id.home)
    void back() {
        onBackPressed();
    }

    @StringRes(R.string.title_add_expence_activity)
    String title;

    @AfterViews
    void ready() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        setTitle(title);
    }
}
