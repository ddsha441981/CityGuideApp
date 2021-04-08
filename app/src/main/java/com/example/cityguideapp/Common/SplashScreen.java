package com.example.cityguideapp.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cityguideapp.R;
import com.example.cityguideapp.User.UserDashBoard;

public class SplashScreen extends AppCompatActivity {

    //Hold the time of SplashScreen
    private static int SPLASH_SCREEN_TIMEOUT = 5000;

    //Variables
    ImageView backgroundImage;
    TextView poweredByLine;

    //Animation
    Animation sideAnimation, bottomAnimation;
    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // For action bar disappear when splash screen running
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        /***********************************Hooks*************************************************/
        backgroundImage = findViewById(R.id.background_image);
        poweredByLine = findViewById(R.id.powered_by_line);

        /***********************************Animation Hooks*************************************************/
        sideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        /***********************************Apply Animation to element*************************************************/
        backgroundImage.setAnimation(sideAnimation);
        poweredByLine.setAnimation(bottomAnimation);

        /***********************************Splash Screen Jump to Next Activity*************************************************/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                /*******************New User Use or Exist User for onBoarding Screen***************************/
                onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
                boolean isFirstIme = onBoardingScreen.getBoolean("firstTime", true);

                if (isFirstIme) {

                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();

                    Intent intent = new Intent(SplashScreen.this, OnBoardingScreen.class);
                    startActivity(intent);
                    //Toast.makeText(SplashScreen.this,"Successfully Redirect to DashBoard Screen", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Intent intent = new Intent(SplashScreen.this, UserDashBoard.class);
                    startActivity(intent);
                    //Toast.makeText(SplashScreen.this,"Successfully Redirect to DashBoard Screen", Toast.LENGTH_SHORT).show();
                    finish();
                }


            }
        }, SPLASH_SCREEN_TIMEOUT);
    }
}
