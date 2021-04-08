package com.example.cityguideapp.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

import com.example.cityguideapp.R;

public class ForgetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*****************************For Action bar Disappearing*****************************/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_forget_password);
    }

    /*****************************After Enter Email Set New Password Via Email*****************************/
    public void callSetNewPasswordViaEmail(View view){

        Intent intent = new Intent(getApplicationContext(),SetNewPassword.class);

        Pair[] pairs = new Pair[1];
        //if you have don't need button of hooks then you can apply this method
        pairs[0] = new Pair<View,String>(findViewById(R.id.newset_forget_password_via_email),"new_set_transition_forget_password_via_email");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions activityOptions =  ActivityOptions.makeSceneTransitionAnimation(ForgetPassword.this,pairs);
            startActivity(intent,activityOptions.toBundle());
        }
        else{

            startActivity(intent);
        }
    }
}
