package com.example.ftipip.moneytrackerv;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by ftipip on 04.09.2015.
 */
public class CategoriesFragment extends Fragment {

    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.categories_fragment, container, false);
        listView = (ListView) view.findViewById(R.id.categories_listview);
        ArrayList<String> adapterData = getDataList();
        getActivity().setTitle(R.string.nav_drawer_categories);
        adapter = new ArrayAdapter<>(getActivity(), R.layout.categories_item, adapterData);
        listView.setAdapter(adapter);
        return view;
    }

    private ArrayList<String> getDataList(){
        ArrayList<String> data = new ArrayList<>();
        data.add("Phone");
        data.add("Car");
        data.add("House");
        return data;
    }
}
