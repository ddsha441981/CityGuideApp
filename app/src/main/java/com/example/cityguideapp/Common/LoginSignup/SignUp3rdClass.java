package com.example.cityguideapp.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.cityguideapp.R;
import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

public class SignUp3rdClass extends AppCompatActivity {

    //Variables
    TextInputLayout signUpPhoneNumber;
    CountryCodePicker countryCodePicker;
    ScrollView scrollViewAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*****************************For Action bar Disappearing*****************************/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up3rd_class);


        /******************Hooks*********************/
       /* backBtn = findViewById(R.id.signup_back_button);
        login = findViewById(R.id.signup_login_button);
        next = findViewById(R.id.signup_next_button);
        titleText = findViewById(R.id.signup_title_text);
*/
       scrollViewAnimation = findViewById(R.id.signup_3rdScreen_scrollview);
        signUpPhoneNumber = findViewById(R.id.signup_phone_number);
        countryCodePicker = findViewById(R.id.country_code_picker);
    }

    /******************To Jump Next Sign Up Screen Verify Otp Screen*********************/
    public void callVerifyOTPScreen(View view) {

        if(!phoneNumberValidate()){
            return;
        }

        //get data from previous activity by using intent
        String _name = getIntent().getStringExtra("fullname");
        String _username = getIntent().getStringExtra("username");
        String _email = getIntent().getStringExtra("email");
        String _password = getIntent().getStringExtra("password");
        String _gender = getIntent().getStringExtra("gender");
        String _date = getIntent().getStringExtra("date");

        //get phoneNumber entered by user
        String _getUserEnteredPhoneNumber = signUpPhoneNumber.getEditText().getText().toString().trim();
        String _phoneNo = "+"+countryCodePicker.getFullNumber()+_getUserEnteredPhoneNumber;

        Intent intent = new Intent(getApplicationContext(), VerifyOTP.class);
        //set data of previous activity to store into database
        intent.putExtra("fullname",_name);
        intent.putExtra("username",_username);
        intent.putExtra("email",_email);
        intent.putExtra("password",_password);
        intent.putExtra("gender",_gender);
        intent.putExtra("date",_date);
        intent.putExtra("phoneNo",_phoneNo);

        /******************Add Animations Transitions *********************/
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(scrollViewAnimation, "transition_otp_screen");
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp3rdClass.this, pairs);

            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }

    public boolean phoneNumberValidate(){
      String  val = signUpPhoneNumber.getEditText().getText().toString().trim();
      if(val.isEmpty()) {
          signUpPhoneNumber.setError("Field can not be empty");
          return false;
      }else{
          signUpPhoneNumber.setError(null);
          signUpPhoneNumber.setErrorEnabled(true);
          return true;
      }
    }

}
