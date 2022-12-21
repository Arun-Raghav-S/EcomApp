package com.example.majorproject1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
public class LOGIN extends AppCompatActivity {
    private  DatabaseHelper databaseHelper;
    TextInputLayout email_lay,pass_lay;
    TextInputEditText usermail,password;
    private InputValidation inputValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        email_lay=(TextInputLayout)findViewById(R.id.loginmail);
        pass_lay=(TextInputLayout)findViewById(R.id.loginpass);
        usermail=(TextInputEditText)findViewById(R.id.lomail);
        password=(TextInputEditText)findViewById(R.id.password);
        databaseHelper=new DatabaseHelper(LOGIN.this);
        inputValidation=new InputValidation(LOGIN.this);
        pass_lay.setBoxBackgroundColor(ContextCompat.getColor(this,R.color.purple_200));
        TextView signup=(TextView)findViewById(R.id.signup);
        Button loginbtn = (Button)  findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail=usermail.getText().toString().trim();
                String pass=password.getText().toString().trim();
                if(!inputValidation.isInputEditTextFilled(usermail,email_lay,"Enter Valid Email"))
                {return;}
                if(!inputValidation.isInputEditTextEmail(usermail,email_lay,"Enter Valid Email"))
                {return;}
                if(!inputValidation.isInputEditTextFilled(password,pass_lay,"Enter Password"))
                {return;}
                if (!databaseHelper.checkUser(mail)){
                    usermail.setError("Email Id does not exist");
                    return;
                }
             if(!databaseHelper.checkPassword(mail,pass)){
                   password.setError("Wrong Password");
                   return;
                }
                String name=databaseHelper.name(mail);
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                emptyInputEditText();
                SharedPreferences sharedPreferences=getSharedPreferences("Sharedpref",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("email",mail);
                editor.putString("name",name);
                editor.apply();
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
            }
        });
    }
    private void emptyInputEditText(){
        usermail.setText(null);
        password.setText(null);
    }


}
