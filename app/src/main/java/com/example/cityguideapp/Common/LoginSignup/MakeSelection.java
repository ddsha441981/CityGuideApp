package com.example.cityguideapp.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.cityguideapp.R;

public class MakeSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*****************************For Action bar Disappearing*****************************/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_make_selection);
    }

    /************Forget Password Via OTP *********************/

    public void callOTPScreenForforGetPassword(View view){

        Toast.makeText(this, "We Working for this Page!!!!", Toast.LENGTH_SHORT).show();

       /* Intent intent = new Intent(getApplicationContext(),VerifyOTP.class);

        Pair[] pairs = new Pair[1];
        //if you have don't need button of hooks then you can apply this method
        pairs[0] = new Pair<View,String>(findViewById(R.id.make_selection_via_mobile),"makeSelectionViaMobileTrans");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions activityOptions =  ActivityOptions.makeSceneTransitionAnimation(MakeSelection.this,pairs);
            startActivity(intent,activityOptions.toBundle());
        }
        else{

            startActivity(intent);
        }*/

    }

    /******************Forget Password Via Email Calling Method *******************/

    public void callForgetPasswordViaEmail(View view){

        Intent intent = new Intent(getApplicationContext(),ForgetPassword.class);

        Pair[] pairs = new Pair[1];
        //if you have don't need button of hooks then you can apply this method
        pairs[0] = new Pair<View,String>(findViewById(R.id.make_selection_via_email),"transition_forget_password_via_email");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions activityOptions =  ActivityOptions.makeSceneTransitionAnimation(MakeSelection.this,pairs);
            startActivity(intent,activityOptions.toBundle());
        }
        else{

            startActivity(intent);
        }

    }
}
