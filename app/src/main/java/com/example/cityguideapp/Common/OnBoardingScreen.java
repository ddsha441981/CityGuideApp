package com.example.cityguideapp.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cityguideapp.HelperClasses.SliderAdpater;
import com.example.cityguideapp.R;
import com.example.cityguideapp.User.UserDashBoard;

public class OnBoardingScreen extends AppCompatActivity {

    ViewPager viewPager;
    TextView sliderHeading, sliderDescription;
    LinearLayout dotsLayout;
    TextView[] dots;
    SliderAdpater sliderAdpater;
    Button letsGetStarted;
    Animation animation;
    int currentPos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*****************************For Action bar Disappearing*****************************/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_on_boarding_screen);

        /*****************************Hooks*****************************/
        viewPager = findViewById(R.id.slider);
        sliderHeading = findViewById(R.id.slider_heading);
        sliderDescription = findViewById(R.id.slider_desc);
        dotsLayout = findViewById(R.id.dots);
        letsGetStarted = findViewById(R.id.get_started_btn);

        /*****************************Call SliderAdapter Class*****************************/

        sliderAdpater = new SliderAdpater(this);
        viewPager.setAdapter(sliderAdpater);

        /*****************************Calling AddDots Method *****************************/
        addDots(0);
        /*****************************Calling AddOnPageChangeListener Method *****************************/
        viewPager.addOnPageChangeListener(onPageChangeListener);
    }

    private void addDots(int position) {

        dots = new TextView[4];
        //All dots remove every slide
        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            //Apply dots here
            dotsLayout.addView(dots[i]);
        }
        if (position > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    public void skip(View view){

        startActivity(new Intent(getApplicationContext(), UserDashBoard.class));
        finish();

    }

    public void next(View view){

        viewPager.setCurrentItem(currentPos + 1);
    }



    /*****************************Highlighting dots whenever slide change*****************************/
    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);

            /****************************Lets Get Started Button Hide and Show *******************/


            //to get current position of slide for next button
            currentPos = position;

            if (position == 0) {

                letsGetStarted.setVisibility(View.INVISIBLE);

            } else if (position == 1) {

                letsGetStarted.setVisibility(View.INVISIBLE);

            } else if (position == 2) {

                letsGetStarted.setVisibility(View.INVISIBLE);

            } else {

                letsGetStarted.setVisibility(View.VISIBLE);
                animation = AnimationUtils.loadAnimation(OnBoardingScreen.this,R.anim.bottom_animation);
                letsGetStarted.setAnimation(animation);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
