package com.example.money_tracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerFragment extends Fragment {
    ArrayList<Transaction> arrayList;
    RecyclerView recyclerView;
    TransactionAdapter transactionAdapter;
    DB db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        recyclerView = view.findViewById(R.id.recycle);
        arrayList = new ArrayList<Transaction>();
        transactionAdapter = new TransactionAdapter(arrayList,getActivity());
        recyclerView.setAdapter(transactionAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        db = new DB(getActivity());
        Data();
        return view;
    }

    public void Data(){
        arrayList.clear();
        arrayList.addAll(db.getAll());
        transactionAdapter.notifyItemInserted(arrayList.size());
    }
}