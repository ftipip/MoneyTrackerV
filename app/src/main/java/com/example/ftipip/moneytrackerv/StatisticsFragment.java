package com.example.ftipip.moneytrackerv;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ftipip on 04.09.2015.
 */
public class StatisticsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.statistics_fragment, container, false);
        getActivity().setTitle(R.string.nav_drawer_statistics);
        return view;
    }
}
