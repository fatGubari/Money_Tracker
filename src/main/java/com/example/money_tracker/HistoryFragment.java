package com.example.money_tracker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {
    ArrayList<Transaction> arrayList;
    RecyclerView recyclerView;
    TransactionAdapter transactionAdapter;
    DB db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        recyclerView = view.findViewById(R.id.recycleH);
        arrayList = new ArrayList<Transaction>();
        db = new DB(getActivity());
        transactionAdapter = new TransactionAdapter(arrayList,getActivity());
        Data();
        recyclerView.setAdapter(transactionAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }
    public void Data(){
        arrayList.clear();
        arrayList.addAll(db.getHistory());
        transactionAdapter.notifyItemInserted(arrayList.size());
    }
}