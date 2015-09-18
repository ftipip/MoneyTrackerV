package com.example.ftipip.moneytrackerv;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import com.example.ftipip.moneytrackerv.database.models.Expenses;

public class ExpensesAdapter extends RecyclerView.Adapter<ExpensesAdapter.CardViewHolder> {

    private List<Expenses> expenses;

    public ExpensesAdapter() {
    }

    public ExpensesAdapter(List<Expenses> expenses) {
        this.expenses = expenses;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expense_list_item, parent, false);
        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        Expenses expense = expenses.get(position);
        holder.textTitle.setText(expense.name);
        holder.dateTitle.setText(expense.date);
        holder.sumTitle.setText(expense.price);
        holder.categoryTitle.setText(expense.categories.toString());
    }

    @Override
    public int getItemCount() {
        return expenses == null ? 0 : expenses.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
        protected TextView textTitle;
        protected TextView sumTitle;
        protected TextView dateTitle;
        protected TextView categoryTitle;

        public CardViewHolder(View itemView) {
            super(itemView);
            textTitle = (TextView) itemView.findViewById(R.id.title);
            dateTitle = (TextView) itemView.findViewById(R.id.date);
            sumTitle = (TextView) itemView.findViewById(R.id.sum);
            categoryTitle = (TextView) itemView.findViewById(R.id.category);
        }
    }
}