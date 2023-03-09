package com.example.money_tracker;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ImageFragment extends Fragment {
    ArrayList<SavedImage> arrayList;
    RecyclerView recyclerView;
    ImageAdapter imageAdapter;
    DB db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);

        recyclerView = view.findViewById(R.id.recycle_photo);
        arrayList = new ArrayList<SavedImage>();
        imageAdapter = new ImageAdapter(arrayList,getActivity());
        recyclerView.setAdapter(imageAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        db = new DB(getActivity());
        Data();

        return view;
    }

    public void Data(){
        arrayList.clear();
        arrayList.addAll(db.getAllImage());
        imageAdapter.notifyItemInserted(arrayList.size());
    }
}