package com.example.cityguideapp.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cityguideapp.R;

import java.util.Calendar;

public class SignUp2ndClass extends AppCompatActivity {


    //Variables
    ScrollView scrollView2ndScreenAnimation;
    RadioGroup radioGroup;
    RadioButton selectedGender;
    DatePicker datePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*****************************For Action bar Disappearing*****************************/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up2nd_class);


        /******************Hooks*********************/

        scrollView2ndScreenAnimation = findViewById(R.id.signup_srollview_3rd_signup_screen);
        radioGroup = findViewById(R.id.radio_group);
        datePicker = findViewById(R.id.age_picker);

    }


    /******************To Jump Next Sign Up Screen*********************/
    public void call3rdSignUpScreen(View view) {
        //validate before calling next activity
        if (!validateGender() | !validateAge()) {
            return;
        }

        selectedGender = findViewById(radioGroup.getCheckedRadioButtonId());
        String _gender = selectedGender.getText().toString();
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();
        String _date = day + "/" + month + "/" + year;

        //`data get from signupScreen using intent
        String _name = getIntent().getStringExtra("fullname");
        String _username = getIntent().getStringExtra("username");
        String _email = getIntent().getStringExtra("email");
        String _password = getIntent().getStringExtra("password");

        Intent intent = new Intent(getApplicationContext(), SignUp3rdClass.class);

        //pass the data next screen
        intent.putExtra("fullname",_name);
        intent.putExtra("username",_username);
        intent.putExtra("email",_email);
        intent.putExtra("password",_password);
        intent.putExtra("gender",_gender);
        intent.putExtra("date",_date);

        /******************Add Animations Transitions *********************/
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(scrollView2ndScreenAnimation, "transition_3rd_signup_screen");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp2ndClass.this, pairs);

            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }

    /******************Validation for 2nd Signup Screen*********************/
    private boolean validateGender() {

        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please Select Gender", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private boolean validateAge() {

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int userAge = datePicker.getYear();
        int isAgeVaild = currentYear - userAge;

        if (isAgeVaild < 14) {
            Toast.makeText(this, "You are not eligible to apply", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

}
