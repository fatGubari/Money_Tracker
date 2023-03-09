package com.example.money_tracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarFragment extends Fragment {

    public CalendarFragment() {
       super(R.layout.fragment_calendar);
    }
    com.example.money_tracker.Transaction transaction;
    TextView calendarText;
    CalendarView calendarView;
    String date;
    public static String date_search;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calendar, container, false);
        calendarView= v.findViewById(R.id.calendarView);
        calendarText = v.findViewById(R.id.calendarText);
        transaction = new Transaction();

        SimpleDateFormat dateFormat=new SimpleDateFormat("d-MM-yyyy");
        date=dateFormat.format(new Date());
        transaction.setHistory(date);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                calendarText.setText(i2+"-"+(1+i1)+"-"+i);
                date_search = calendarText.getText().toString();
            }
        });

        return v;
    }
}


