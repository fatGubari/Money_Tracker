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

import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {
    EditText password, re_password, email;
    Button create;
    DB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        password = findViewById(R.id.su_password);
        re_password = findViewById(R.id.su_repassword);
        email = findViewById(R.id.su_email);
        create = findViewById(R.id.create);
        db = new DB(getApplicationContext());
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check_account_password()==1 && check_account_email()==1){
                    db.addInfo(email.getText().toString(),password.getText().toString());
                    Toast.makeText(SignUpActivity.this, "Great", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public int check_account_password(){
        String pass = password.getText().toString();
        char[] check = pass.toCharArray();
        int number=0;
        int valid = 0;
        if(password.length()<=8){
            for(int i=0;i<password.length();i++){
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
            AlertDialog.Builder alert = new AlertDialog.Builder(SignUpActivity.this);
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
        if (!re_password.getText().toString().equals(password.getText().toString())) {
            valid=0;

            AlertDialog.Builder alert = new AlertDialog.Builder(SignUpActivity.this);
            alert.setTitle("Confirm Delete");
            alert.setMessage("Your Passwords Should be Match");

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

    public int check_account_email(){
        int valid =0;
        String email_validate = email.getText().toString();
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +"(?:[a-zA-Z0-9-]+\\.)+[a-z" +"A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (pat.matcher(email_validate).matches()==false){
            Toast.makeText(this, "Email must be valid", Toast.LENGTH_SHORT).show();
            valid =0;
        }
        else if (pat.matcher(email_validate).matches()==true){
            valid =1;
        }
        return valid;
    }
}