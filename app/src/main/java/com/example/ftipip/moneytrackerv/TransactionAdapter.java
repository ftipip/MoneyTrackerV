package com.example.ftipip.moneytrackerv;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ftipip on 28.08.2015.
 */
public class TransactionAdapter extends ArrayAdapter {

    private List<Transaction> transactions;

    public TransactionAdapter(Context context, List<Transaction> transactions) {
        super(context, 0, transactions);
        this.transactions = transactions;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Transaction transaction = (Transaction) getItem(position);

        //RelativeLayout lis_item = (RelativeLayout) convertView.findViewById(R.id.list_item);
        //lis_item.setBackgroundColor(Color.parseColor("#F2BEBE"));

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView textTitle = (TextView) convertView.findViewById(R.id.title);
        TextView textSum = (TextView) convertView.findViewById(R.id.sum);
        TextView textDate = (TextView) convertView.findViewById(R.id.date);

        textTitle.setText(transaction.title);
        textSum.setText(String.valueOf(transaction.sum));
        textDate.setText(String.valueOf(transaction.date));

        return convertView;
    }
}
