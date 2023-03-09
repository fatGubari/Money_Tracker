package com.example.money_tracker;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class ChartFragment extends Fragment {
    PieChart pieChart,pieChart2;
    PieEntry pieEntry , pieEntry2,pieEntry3;
    ArrayList<String> arrayList,arrayList2,arrayList3;
    DB db;
    int in,ex,cat=1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart, container, false);
        pieChart2 = view.findViewById(R.id.pieChart2);
        pieChart = view.findViewById(R.id.pieChart);
        arrayList = new ArrayList<String>();
        arrayList2 = new ArrayList<String>();
        arrayList3 = new ArrayList<String>();
        db = new DB(getActivity());
        ArrayList<PieEntry> pieEntries = new ArrayList<>();
        ArrayList<PieEntry> pieEntries2 = new ArrayList<>();

        arrayList.clear();
        arrayList.addAll(db.getType());
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equals("Income")){
                in++;
            }
            if (arrayList.get(i).equals("Expenses")){
                ex++;
            }

        }
        pieEntry = new PieEntry(in, "Income");
        pieEntry2 = new PieEntry(ex, "Expenses");
        pieEntries.add(pieEntry);
        pieEntries.add(pieEntry2);
        PieDataSet pieDataSet = new PieDataSet(pieEntries,"Type");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.setData(new PieData(pieDataSet));
        pieChart.setCenterText("Transaction Types");
        pieChart.animateXY(5000,5000);
        pieChart.getDescription().setEnabled(false);

        arrayList2.addAll(db.getCategory());
        arrayList3.addAll(db.getAllCat());
        for (int i = 0; i < arrayList3.size(); i++) {
            for (int j = 0; j < arrayList2.size(); j++) {
                if (arrayList3.get(i).equals(arrayList2.get(j))){
                    cat++;
                }
            }
            pieEntry3 = new PieEntry(cat, arrayList3.get(i));
            pieEntries2.add(pieEntry3);
        }

        PieDataSet pieDataSet2 = new PieDataSet(pieEntries2,"Category");
        pieDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart2.setData(new PieData(pieDataSet2));
        pieChart2.setCenterText("Transaction Category");
        pieChart2.animateY(5000);
        pieChart2.getDescription().setEnabled(false);

        return view;
    }
}