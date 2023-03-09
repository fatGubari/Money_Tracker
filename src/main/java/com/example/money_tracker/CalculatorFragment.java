package com.example.money_tracker;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Context;

public class CalculatorFragment extends Fragment {
    EditText solution,result;
    Button button_c,button_open,button_close,button_divide,
            button_7,button_8,button_9,button_multi,
            button_4,button_5,button_6,button_add,
            button_1,button_2,button_3,button_sub,
            button_ac,button_0,button_dot,button_equal;

    public CalculatorFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        solution = view.findViewById(R.id.solution);
        result = view.findViewById(R.id.result);

        button_c = view.findViewById(R.id.button_c);
        button_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = button_c.getText().toString();
                String dataToCalculate = solution.getText().toString();
                dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
                solution.setText(dataToCalculate);
//                String finalResult = getResult(dataToCalculate);
//                if (!finalResult.equals("error")){
//                    result.setText(finalResult);
//                }
            }
        });
        button_open = view.findViewById(R.id.button_open);
        button_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = button_open.getText().toString();
                String dataToCalculate = solution.getText().toString();
                dataToCalculate = dataToCalculate + buttonText;
                solution.setText(dataToCalculate);
                String finalResult = getResult(dataToCalculate);
                if (!finalResult.equals("error")){
                    result.setText(finalResult);
                }
            }
        });
        button_close = view.findViewById(R.id.button_close);
        button_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = button_close.getText().toString();
                String dataToCalculate = solution.getText().toString();
                dataToCalculate = dataToCalculate + buttonText;
                solution.setText(dataToCalculate);
                String finalResult = getResult(dataToCalculate);
                if (!finalResult.equals("error")){
                    result.setText(finalResult);
                }
            }
        });
        button_divide = view.findViewById(R.id.button_divide);
        button_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = button_divide.getText().toString();
                String dataToCalculate = solution.getText().toString();
                dataToCalculate = dataToCalculate + buttonText;
                solution.setText(dataToCalculate);
                String finalResult = getResult(dataToCalculate);
                if (!finalResult.equals("error")){
                    result.setText(finalResult);
                }
            }
        });

        button_7 = view.findViewById(R.id.button_7);
        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = button_7.getText().toString();
                String dataToCalculate = solution.getText().toString();
                dataToCalculate = dataToCalculate + buttonText;
                solution.setText(dataToCalculate);
                String finalResult = getResult(dataToCalculate);
                if (!finalResult.equals("error")){
                    result.setText(finalResult);
                }
            }
        });
        button_8 = view.findViewById(R.id.button_8);
        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = button_8.getText().toString();
                String dataToCalculate = solution.getText().toString();
                dataToCalculate = dataToCalculate + buttonText;
                solution.setText(dataToCalculate);
                String finalResult = getResult(dataToCalculate);
                if (!finalResult.equals("error")){
                    result.setText(finalResult);
                }
            }
        });
        button_9 = view.findViewById(R.id.button_9);
        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = button_9.getText().toString();
                String dataToCalculate = solution.getText().toString();
                dataToCalculate = dataToCalculate + buttonText;
                solution.setText(dataToCalculate);
                String finalResult = getResult(dataToCalculate);
                if (!finalResult.equals("error")){
                    result.setText(finalResult);
                }
            }
        });
        button_multi = view.findViewById(R.id.button_multi);
        button_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = button_multi.getText().toString();
                String dataToCalculate = solution.getText().toString();
                dataToCalculate = dataToCalculate + buttonText;
                solution.setText(dataToCalculate);
                String finalResult = getResult(dataToCalculate);
                if (!finalResult.equals("error")){
                    result.setText(finalResult);
                }
            }
        });

        button_4 = view.findViewById(R.id.button_4);
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = button_4.getText().toString();
                String dataToCalculate = solution.getText().toString();
                dataToCalculate = dataToCalculate + buttonText;
                solution.setText(dataToCalculate);
                String finalResult = getResult(dataToCalculate);
                if (!finalResult.equals("error")){
                    result.setText(finalResult);
                }
            }
        });
        button_5 = view.findViewById(R.id.button_5);
        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = button_5.getText().toString();
                String dataToCalculate = solution.getText().toString();
                dataToCalculate = dataToCalculate + buttonText;
                solution.setText(dataToCalculate);
                String finalResult = getResult(dataToCalculate);
                if (!finalResult.equals("error")){
                    result.setText(finalResult);
                }
            }
        });
        button_6 = view.findViewById(R.id.button_6);
        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = button_6.getText().toString();
                String dataToCalculate = solution.getText().toString();
                dataToCalculate = dataToCalculate + buttonText;
                solution.setText(dataToCalculate);
                String finalResult = getResult(dataToCalculate);
                if (!finalResult.equals("error")){
                    result.setText(finalResult);
                }
            }
        });
        button_add = view.findViewById(R.id.button_add);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = button_add.getText().toString();
                String dataToCalculate = solution.getText().toString();
                dataToCalculate = dataToCalculate + buttonText;
                solution.setText(dataToCalculate);
                String finalResult = getResult(dataToCalculate);
                if (!finalResult.equals("error")){
                    result.setText(finalResult);
                }
            }
        });

        button_1 = view.findViewById(R.id.button_1);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = button_1.getText().toString();
                String dataToCalculate = solution.getText().toString();
                dataToCalculate = dataToCalculate + buttonText;
                solution.setText(dataToCalculate);
                String finalResult = getResult(dataToCalculate);
                if (!finalResult.equals("error")){
                    result.setText(finalResult);
                }
            }
        });
        button_2 = view.findViewById(R.id.button_2);
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = button_2.getText().toString();
                String dataToCalculate = solution.getText().toString();
                dataToCalculate = dataToCalculate + buttonText;
                solution.setText(dataToCalculate);
                String finalResult = getResult(dataToCalculate);
                if (!finalResult.equals("error")){
                    result.setText(finalResult);
                }
            }
        });
        button_3 = view.findViewById(R.id.button_3);
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = button_3.getText().toString();
                String dataToCalculate = solution.getText().toString();
                dataToCalculate = dataToCalculate + buttonText;
                solution.setText(dataToCalculate);
                String finalResult = getResult(dataToCalculate);
                if (!finalResult.equals("error")){
                    result.setText(finalResult);
                }
            }
        });
        button_sub = view.findViewById(R.id.button_sub);
        button_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = button_sub.getText().toString();
                String dataToCalculate = solution.getText().toString();
                dataToCalculate = dataToCalculate + buttonText;
                solution.setText(dataToCalculate);
                String finalResult = getResult(dataToCalculate);
                if (!finalResult.equals("error")){
                    result.setText(finalResult);
                }
            }
        });

        button_ac = view.findViewById(R.id.button_ac);
        button_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = button_ac.getText().toString();
                String dataToCalculate = solution.getText().toString();
                solution.setText("");
                result.setText("");
                solution.setText(dataToCalculate);
            }
        });
        button_0 = view.findViewById(R.id.button_0);
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = button_0.getText().toString();
                String dataToCalculate = solution.getText().toString();
                dataToCalculate = dataToCalculate + buttonText;
                solution.setText(dataToCalculate);
                String finalResult = getResult(dataToCalculate);
                if (!finalResult.equals("error")){
                    result.setText(finalResult);
                }
            }
        });
        button_dot = view.findViewById(R.id.button_dot);
        button_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = button_dot.getText().toString();
                String dataToCalculate = solution.getText().toString();
                dataToCalculate = dataToCalculate + buttonText;
                solution.setText(dataToCalculate);
                String finalResult = getResult(dataToCalculate);
                if (!finalResult.equals("error")){
                    result.setText(finalResult);
                }
            }
        });
        button_equal = view.findViewById(R.id.button_equal);
        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = button_equal.getText().toString();
                String dataToCalculate = solution.getText().toString();
                solution.setText(result.getText());
                String finalResult = getResult(dataToCalculate);
                if (!finalResult.equals("error")){
                    result.setText(finalResult);
                }
            }
        });
        return view;
    }

    public String getResult(String data){
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult = context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            if (finalResult.endsWith(".0")){
                finalResult = finalResult.replace(".0","");
            }
            return finalResult;
        }
        catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
}