package com.example.cityguideapp.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cityguideapp.R;

public class SetNewPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_password);
    }

    public void callSuccessFullyForgetPasswordChanged(View view){

        Intent intent = new Intent(getApplicationContext(),ForgetPasswordSuccessMessage.class);
        startActivity(intent);
    }
}
