package com.example.money_tracker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class IncomeExpensesFragment extends Fragment {

    ArrayList<Transaction> arrayList;
    RecyclerView recyclerView;
    TransactionAdapter transactionAdapter;
    DB db;
    Button expenses,income;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_income_expenses, container, false);

        recyclerView = view.findViewById(R.id.recycleIE);
        arrayList = new ArrayList<Transaction>();
        transactionAdapter = new TransactionAdapter(arrayList,getActivity());
        recyclerView.setAdapter(transactionAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        db = new DB(getActivity());

        income = view.findViewById(R.id.incomeB);
        expenses = view.findViewById(R.id.expensesB);

        income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Income();
            }
        });

        expenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Expenses();
            }
        });

        return view;
    }

    public void Income(){
        arrayList.clear();
        transactionAdapter.notifyDataSetChanged();
        arrayList.addAll(db.getIncome());
        transactionAdapter.notifyItemChanged(arrayList.size());
        transactionAdapter.notifyItemInserted(arrayList.size());
    }

    public void Expenses(){
        arrayList.clear();
        transactionAdapter.notifyDataSetChanged();
        arrayList.addAll(db.getExpenses());
        transactionAdapter.notifyItemChanged(arrayList.size());
        transactionAdapter.notifyItemInserted(arrayList.size());
    }
}