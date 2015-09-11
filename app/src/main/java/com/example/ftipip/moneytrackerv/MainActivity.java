package com.example.ftipip.moneytrackerv;


import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "MMainActivity";

    @ViewById(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @ViewById(R.id.frame_container)
    View container;

    @ViewById(R.id.toolbar)
    Toolbar toolbar;

    @ViewById(R.id.navigation_view)
    NavigationView navigationView;


    @AfterViews
    void ready() {
        initToolbar();
        setNavigationDrawer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new ExpensesFragment()).commit();}
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            //actionBar.setHomeAsUpIndicator();
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setNavigationDrawer() {
        navigationView.setNavigationItemSelectedListener((new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                getFragment(menuItem);
                //Snackbar.make(container, menuItem.getTitle() + " pressed", Snackbar.LENGTH_SHORT).show();
                return false;
            }
        }));
    }

    private void getFragment(MenuItem menuItem) {
        Fragment fragment;

        switch (menuItem.getItemId()){
            case R.id.drawer_expenses:
                fragment = new ExpensesFragment();
                break;
            case R.id.drawer_categories:
                fragment = new CategoriesFragment();
                break;
            case R.id.drawer_statistics:
                fragment = new StatisticsFragment();
                break;
            case R.id.drawer_settings:
                fragment = new SettingsFragment();
                break;
            default:
                fragment = new ExpensesFragment();
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment).addToBackStack(null).commit();
        menuItem.setChecked(true);
        drawerLayout.closeDrawers();
    }


    @Override
    protected void onResume() {
        Log.d(LOG_TAG, "onResume");
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        Log.d(LOG_TAG, "onDestroy");
        super.onDestroy();
    }
}
