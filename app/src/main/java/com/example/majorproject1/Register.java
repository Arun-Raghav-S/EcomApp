package com.example.majorproject1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Register extends AppCompatActivity
{
    Button Signup;
    private  DatabaseHelper databaseHelper;
    private InputValidation inputValidation;
    User user;
    TextInputLayout name_lay,email_lay,pass_lay,conf_lay;
    TextInputEditText name,email,pass,conf;
    TextView already;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        already=(TextView) findViewById(R.id.already);
        Signup=(Button) findViewById(R.id.register);
        name_lay=(TextInputLayout)findViewById(R.id.namelay);
        email_lay=(TextInputLayout)findViewById(R.id.maillay);
        pass_lay=(TextInputLayout)findViewById(R.id.passlay);
        conf_lay=(TextInputLayout)findViewById(R.id.conflay);
        name=(TextInputEditText)findViewById(R.id.name);
        email=(TextInputEditText)findViewById(R.id.mail);
        pass=(TextInputEditText)findViewById(R.id.pass);
        conf=(TextInputEditText)findViewById(R.id.conf);
        databaseHelper=new DatabaseHelper(Register.this);
        inputValidation=new InputValidation(Register.this);
        user=new User();
        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),LOGIN.class);
                startActivity(intent);
            }
        });
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!inputValidation.isInputEditTextFilled(name,name_lay,"Enter Full Name"))
                {return;}
                if(!inputValidation.isInputEditTextFilled(email,email_lay,"Enter Valid Email"))
                {return;}
                if(!inputValidation.isInputEditTextEmail(email,email_lay,"Enter Valid Email"))
                {return;}
                if(!inputValidation.isInputEditTextMatches(pass,conf,conf_lay,"Passwords Do not Match"))
                {return;}
                if(!databaseHelper.checkUser(email.getText().toString().trim())){
                    user.setName(name.getText().toString().trim());
                    user.setEmail(email.getText().toString().trim());
                    user.setPassword(pass.getText().toString().trim());
                    databaseHelper.addUser(user);
                    Toast.makeText(Register.this,"Signup Successful",Toast.LENGTH_LONG).show();
                    emptyInputEditText();
                    Intent intent=new Intent(getApplicationContext(),LOGIN.class);


                    startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(),"Account Already Exists",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void emptyInputEditText(){
        name.setText(null);
        email.setText(null);
        pass.setText(null);
        conf.setText(null);

    }
}
