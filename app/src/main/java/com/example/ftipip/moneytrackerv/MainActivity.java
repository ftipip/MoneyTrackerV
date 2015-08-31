package com.example.ftipip.moneytrackerv;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private ListView listView;
    private List<Transaction> data = new ArrayList<>();
    private TransactionAdapter transactionAdapter;

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.main_listview);
        List<Transaction> adapterData = getDataList();
        transactionAdapter = new TransactionAdapter(this, adapterData);
        listView.setAdapter(transactionAdapter);

        Log.d(LOG_TAG, "onCreate");
    }

    private  List<Transaction> getDataList() {
        data.add(new Transaction("Phone", 2000, String.valueOf(new Date())));
        data.add(new Transaction("Phone", 3000, String.valueOf(new Date())));

        return data;
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
