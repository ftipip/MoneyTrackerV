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


public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "MMainActivity";
    private View container;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (View) findViewById(R.id.frame_container);

        /*if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new ExpensesFragment()).commit();}*/

        Log.d(LOG_TAG, "onCreate");

        initToolbar();
        setNavigationDrawer();
    }

    private void initToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setNavigationDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener((new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                getFragment(menuItem);
                //Snackbar.make(container, menuItem.getTitle() + " pressed", Snackbar.LENGTH_SHORT).show();
                return false;
            }
        }));
    }

    private void getFragment(MenuItem menuItem) {
        Fragment fragment;

        switch (menuItem.getItemId()) {
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
