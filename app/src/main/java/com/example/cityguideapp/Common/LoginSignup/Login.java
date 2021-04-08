package com.example.cityguideapp.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

import com.example.cityguideapp.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*****************************For Action bar Disappearing*****************************/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_retailer_login);
    }


    public void callForgetPasswordScreen(View view){



        Intent intent = new Intent(getApplicationContext(),MakeSelection.class);

        Pair[] pairs = new Pair[1];
        //if you have don't need button of hooks then you can apply this method
        pairs[0] = new Pair<View,String>(findViewById(R.id.forget_password_id),"transition_forget_password");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions activityOptions =  ActivityOptions.makeSceneTransitionAnimation(Login.this,pairs);
            startActivity(intent,activityOptions.toBundle());
        }
        else{

            startActivity(intent);
        }
    }
}
