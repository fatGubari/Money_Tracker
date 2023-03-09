package com.example.money_tracker;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class ForgetPasswordActivity extends AppCompatActivity {
    EditText for_password,for_email;
    Button change;
    DB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        for_password = findViewById(R.id.for_password);
        for_email = findViewById(R.id.for_email);
        change = findViewById(R.id.change);
        db = new DB(getApplicationContext());

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check_changed_password() == 1 && ChangePassword()==1){

                    Snackbar.make(view, "Do not Forget the Password", Snackbar.LENGTH_LONG)
                            .setAction("OK", new View.OnClickListener(){
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                    startActivity(intent);
                                }
                            }).show();
                }
                else {
                    Toast.makeText(ForgetPasswordActivity.this, "Not Valid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public int check_changed_password(){
        String pass = for_password.getText().toString();
        char[] check = pass.toCharArray();
        int number=0;
        int valid = 0;
        if(for_password.length()<=8){
            for(int i=0;i<for_password.length();i++){
                if (check[i]>= 'A' && check[i] <= 'Z'){
                    valid = 1;
                }
                if(check[i]>= 'a' && check[i] <= 'z'){
                    valid = 1;
                }
                else if(check[i]>= '0' && check[i] <= '9'){
                    number++;
                }
            }
        }
        if(number>=2){
            valid =1;
        }
        else {
            valid =0;
            AlertDialog.Builder alert = new AlertDialog.Builder(ForgetPasswordActivity.this);
            alert.setTitle("Confirm Delete");
            alert.setMessage("Your Password Should Contain 8 Characters of Letters \n " +
                    "At Least One Capital Letter \n And At Least Two Digit");

            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            alert.setCancelable(false);
            alert.create();
            alert.show();
        }
        return valid;
    }

    public int ChangePassword(){
        int valid ;
        if (db.getEmail().equals(for_email.getText().toString())){
            db.ForgetPassword(for_email.getText().toString(),for_password.getText().toString());
            valid = 1;
        }
        else{
            valid = 0;
        }
        return  valid;
    }
}