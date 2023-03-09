package com.example.money_tracker;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    EditText password_in;
    TextView forget, signUp;
    TextInputLayout password_layout;
    Button submit;
    DB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        password_in = findViewById(R.id.si_password);
        forget = findViewById(R.id.forget_password);
        signUp = findViewById(R.id.sign_up);
        submit = findViewById(R.id.submit);
        password_layout = findViewById(R.id.si_password_til);
        db = new DB(getApplicationContext());

        password_in.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.length() >= 9){
                    password_layout.setError("Password Must Be 8 Characters");
                    password_layout.setErrorIconDrawable(null);
                }
                else {
                    password_layout.setError(null);
                }
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validatePassword()==1){
                    Intent intent = new Intent(getApplicationContext(),FontActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public int validatePassword(){
        int valid;
        if (db.getPassword().equals(password_in.getText().toString())){
            valid =1;
        }
        else{
            Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show();
            valid =0;
        }
        return valid;
    }
}