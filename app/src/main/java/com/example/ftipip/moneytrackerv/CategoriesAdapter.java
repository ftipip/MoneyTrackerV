package com.example.ftipip.moneytrackerv;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ftipip.moneytrackerv.database.models.Categories;
import com.example.ftipip.moneytrackerv.database.models.Expenses;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CardViewHolder> {

    private List<Categories> categories;

    public CategoriesAdapter() {
    }

    public CategoriesAdapter(List<Categories> categories) {
        this.categories = categories;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_item, parent, false);
        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        Categories category = categories.get(position);
        holder.textTitle.setText(category.name);
    }

    @Override
    public int getItemCount() {
        return categories == null ? 0 : categories.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
        protected TextView textTitle;

        public CardViewHolder(View itemView) {
            super(itemView);
            textTitle = (TextView) itemView.findViewById(R.id.title);
        }
    }
}