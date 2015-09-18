package com.example.ftipip.moneytrackerv;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.example.ftipip.moneytrackerv.database.models.Categories;
import com.example.ftipip.moneytrackerv.database.models.Expenses;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpensesFragment extends Fragment {

    private ExpensesAdapter expensesAdapter;
    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle(R.string.nav_drawer_expenses);

        addcategoriesDataBase();

        final View view = inflater.inflate(R.layout.expenses_fragment, container, false);

        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), 1, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_content);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(expensesAdapter);

        expensesAdapter = new ExpensesAdapter(getDataList());

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(recyclerView, "pressed", Snackbar.LENGTH_SHORT).show();
                Intent openActivityIntent = new Intent(getActivity(),AddExpenseActivity_.class);
                getActivity().startActivity(openActivityIntent);
            }
        });

        Bundle args = getArguments();
        if (args != null){
            Boolean showSnackbar = args.getBoolean("showSnackbar");
            if (showSnackbar){
                Snackbar.make(recyclerView, getActivity().getTitle() + " selected", Snackbar.LENGTH_SHORT).show();
            }
            args.clear();
        }
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getLoaderManager().restartLoader(0, null, new LoaderManager.LoaderCallbacks<List<Expenses>>() {
            @Override
            public Loader<List<Expenses>> onCreateLoader(int id, Bundle args) {
                final AsyncTaskLoader<List<Expenses>> loader = new AsyncTaskLoader<List<Expenses>>(getActivity()){

                    @Override
                    public List<Expenses> loadInBackground() {
                        return getDataList();
                    }
                };
                loader.forceLoad();

                return loader;
            }

            @Override
            public void onLoadFinished(Loader<List<Expenses>> loader, List<Expenses> data) {
                recyclerView.setAdapter(new ExpensesAdapter(getDataList()));
            }

            @Override
            public void onLoaderReset(Loader<List<Expenses>> loader) {

            }
        });
    }

    private List<Expenses> getDataList(){
        return new Select().from(Expenses.class).execute();
    }

    private void addcategoriesDataBase() {
        //new Delete().from(Expenses.class).execute();
        if(new Select().from(Categories.class).execute().size() == 0) {
            new Categories("Social").save();
            new Categories("Fun").save();
            new Categories("Clothes").save();
            new Categories("Food").save();
        }
    }
}