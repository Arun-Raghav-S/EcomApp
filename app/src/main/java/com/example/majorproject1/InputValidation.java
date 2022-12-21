package com.example.majorproject1;

import android.content.Context;
import android.util.Patterns;


import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class InputValidation {
    private Context context;
    public InputValidation(Context context) {
        this.context = context;
    }
    public boolean isInputEditTextFilled(TextInputEditText textInputEditText, TextInputLayout textInputLayout,String message){
        String value=textInputEditText.getText().toString().trim();
        if(value.isEmpty()) {
            textInputLayout.setError(message);
            return false;
        }
        else{
            textInputLayout.setErrorEnabled(false);
        }
       return true;
    }
    public boolean isInputEditTextEmail(TextInputEditText textInputEditText,TextInputLayout textInputLayout,String message){
        String value=textInputEditText.getText().toString().trim();
        if(value.isEmpty()|| !Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            textInputLayout.setError(message);
            return false;
        }
        else{
            textInputLayout.setErrorEnabled(false);

        }
        return true;
    }
    public boolean isInputEditTextMatches(TextInputEditText textInputEditText1,TextInputEditText textInputEditText2,TextInputLayout textInputLayout,String message){
        String value1= textInputEditText1.getText().toString().trim();
        String value2= textInputEditText2.getText().toString().trim();
        if(value1.isEmpty()){
            textInputLayout.setError("Enter Password");
            return  false;
        }
        if(value2.isEmpty()){
            textInputLayout.setError("Confirm Password");
            return  false;
        }
        if(!value1.contentEquals(value2)){
            textInputLayout.setError(message);
            return  false;
        }else{
            textInputLayout.setErrorEnabled(false);
        }
        return true;
    }
}
