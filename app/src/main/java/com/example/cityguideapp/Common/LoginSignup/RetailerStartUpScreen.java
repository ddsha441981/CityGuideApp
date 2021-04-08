package com.example.cityguideapp.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.cityguideapp.R;

public class RetailerStartUpScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*****************************For Action bar Disappearing*****************************/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_start_up_screen);

        /*****************************Hooks*****************************/
    }

    /*****************************For Login*****************************/
    public void callLoginScreen(View view){

        Intent intent = new Intent(getApplicationContext(),Login.class);
        Pair[] pairs = new Pair[1];
        //if you have don't need button of hooks then you can apply this method
        pairs[0] = new Pair<View,String>(findViewById(R.id.login_btn),"transition_login");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions activityOptions =  ActivityOptions.makeSceneTransitionAnimation(RetailerStartUpScreen.this,pairs);
            startActivity(intent,activityOptions.toBundle());
        }
        else{

            startActivity(intent);
        }

    }
    /*****************************For SignUp Screen*****************************/
    public void callSignUpScreen(View view){


        Intent intent = new Intent(getApplicationContext(),SignUp.class);

       Pair[] pairs = new Pair[1];
        //if you have don't need button of hooks then you can apply this method
        pairs[0] = new Pair<View,String>(findViewById(R.id.signup_btn),"transition_signup");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions activityOptions =  ActivityOptions.makeSceneTransitionAnimation(RetailerStartUpScreen.this,pairs);
            startActivity(intent,activityOptions.toBundle());
        }
        else{

            startActivity(intent);
        }
    }

}
