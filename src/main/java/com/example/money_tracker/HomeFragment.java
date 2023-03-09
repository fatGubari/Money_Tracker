package com.example.money_tracker;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HomeFragment extends Fragment {
    Button addTransaction,chartBottom,showTransaction,addCat,calculator,showInEx,history,imageSaved;
    String typeD,date;
    ArrayAdapter<String> spinnerAdapter;
    ArrayList<String> spinnerList;
    Spinner spinnerCat;
    ArrayList<Transaction> arrayList;
    TransactionAdapter transactionAdapter;
    DB db;

    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        addTransaction=view.findViewById(R.id.addB);
        chartBottom = view.findViewById(R.id.chartB);
        showTransaction = view.findViewById(R.id.showB);
        addCat= view.findViewById(R.id.catB);
        calculator = view.findViewById(R.id.calB);
        showInEx = view.findViewById(R.id.show_in_exB);
        history = view.findViewById(R.id.historyB);
        imageSaved = view.findViewById(R.id.imageSaved);

        arrayList = new ArrayList<Transaction>();
        db = new DB(getActivity());
        transactionAdapter = new TransactionAdapter(arrayList,getActivity());

        addTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.activity_add_transaction);
                dialog.getWindow().setLayout(900,1200);
                EditText moneyD = dialog.findViewById(R.id.moneyD);
                EditText noteD = dialog.findViewById(R.id.noteD);
                RadioGroup radioGroup = dialog.findViewById(R.id.radio);
                Button create = dialog.findViewById(R.id.create);

                spinnerCat = dialog.findViewById(R.id.categoryD);
                spinnerList = new ArrayList<String>();
                spinnerList.add("Choose A Category");
                spinnerList.addAll(db.getAllCat());

                spinnerAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item,spinnerList);
                spinnerCat.setAdapter(spinnerAdapter);
                create.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                switch (i){
                                    case R.id.incomeD: typeD = "Income";
                                        break;
                                    case R.id.expensesD: typeD = "Expenses";
                                        break;
                                }
                            }
                        });
                        radioGroup.clearCheck();

                        Transaction transaction = new Transaction();
                        SimpleDateFormat dateFormat=new SimpleDateFormat("d-MM-yyyy");
                        date=dateFormat.format(new Date());

                        Toast.makeText(getActivity(), date, Toast.LENGTH_SHORT).show();
                        if (typeD.equals("Income")){
                             transaction = new Transaction(moneyD.getText().toString(),noteD.getText().toString()
                                    ,typeD,spinnerCat.getSelectedItem().toString(),R.drawable.income,date);
                            transactionAdapter.notifyItemInserted(arrayList.size());
                            db.addTransaction(transaction);

                            arrayList.add(transaction);
                            dialog.hide();
                        }
                        else if (typeD.equals("Expenses")){
                            transaction = new Transaction(moneyD.getText().toString(),noteD.getText().toString()
                                    ,typeD,spinnerCat.getSelectedItem().toString(), R.drawable.expenses,date);
                            db.addTransaction(transaction);
                            transactionAdapter.notifyItemInserted(arrayList.size());
                            arrayList.add(0,transaction);
                            dialog.hide();
                        }
                    }
                });
                dialog.create();
                dialog.show();
            }
        });

        chartBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((FontActivity) getActivity()).replaceFragment(new ChartFragment());
            }
        });

        showTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((FontActivity) getActivity()).replaceFragment(new RecyclerFragment());
            }
        });

        addCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.add_category);
                dialog.getWindow().setLayout(900,800);
                EditText new_cat = dialog.findViewById(R.id.NewCat);
                Spinner cat_sp = dialog.findViewById(R.id.NewCatSp);
                Button createCat = dialog.findViewById(R.id.createCat);

                ArrayAdapter<String> catAdapter;
                ArrayList<String> List;

                List = new ArrayList<String>();
                List.addAll(db.getAllCat());
                catAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item,List);
                cat_sp.setAdapter(catAdapter);

                createCat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String category_new = new_cat.getText().toString();
                        db.addCategory(category_new);
                        dialog.hide();
                    }
                });
                dialog.create();
                dialog.show();
            }
        });

        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((FontActivity) getActivity()).replaceFragment(new CalculatorFragment());
            }
        });

        showInEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((FontActivity) getActivity()).replaceFragment(new IncomeExpensesFragment());
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((FontActivity) getActivity()).replaceFragment(new HistoryFragment());
            }
        });

        imageSaved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((FontActivity) getActivity()).replaceFragment(new ImageFragment());
            }
        });
        return view;
    }
}