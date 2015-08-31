package com.example.ftipip.moneytrackerv;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ftipip on 31.08.2015.
 */
public class ExpensesFragment extends Fragment {

    private ListView listView;
    private List<Transaction> data = new ArrayList<>();
    private TransactionAdapter transactionAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.expenses_fragment, container, false);

        listView = (ListView) view.findViewById(R.id.main_listview);
        List<Transaction> adapterData = getDataList();
        transactionAdapter = new TransactionAdapter(getActivity(), adapterData);
        listView.setAdapter(transactionAdapter);
        getActivity().setTitle("Phone List Fragment");

        return view;
    }

    private  List<Transaction> getDataList() {
        data.add(new Transaction("Phone", 2000, String.valueOf(new Date())));
        data.add(new Transaction("Phone", 3000, String.valueOf(new Date())));

        return data;
    }
}
