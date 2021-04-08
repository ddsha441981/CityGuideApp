package com.example.cityguideapp.User;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.cityguideapp.R;

public class AllCategories extends AppCompatActivity {

    ImageView pressBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*****************************For Action bar Disappearing*****************************/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_all_categories);

        //Hooks
        pressBackBtn = findViewById(R.id.back_pressed);
        pressBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AllCategories.super.onBackPressed();
            }
        });
    }
}
