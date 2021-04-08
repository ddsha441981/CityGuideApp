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
import android.widget.TextView;
import android.widget.Toast;

import com.example.cityguideapp.R;
import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {

    //Variables
    ImageView backBtn;
    Button login, next;
    TextView titleText;

    //Get data Variables
    TextInputLayout fullname, username, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*****************************For Action bar Disappearing*****************************/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_sign_up);

        /******************Hooks*********************/
        backBtn = findViewById(R.id.signup_back_button);
        login = findViewById(R.id.signup_login_button);
        next = findViewById(R.id.signup_next_button);
        titleText = findViewById(R.id.signup_title_text);

        /******************validation Hooks*********************/
        fullname = findViewById(R.id.signup_fullname);
        username = findViewById(R.id.signup_username);
        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);


    }

    /******************To Jump Next Sign Up Screen*********************/
    public void callNextSignUpScreen(View view) {

        //calling validation method here
        if(!validateFullname() | !validateUsername() | !validateEmail() | !validatePassword()){
            return;
        }

        //get data from textInput Layout
        String _fullname = fullname.getEditText().getText().toString();
        String _username = username.getEditText().getText().toString();
        String _email = email.getEditText().getText().toString();
        String _password = password.getEditText().getText().toString();

        Intent intent = new Intent(getApplicationContext(), SignUp2ndClass.class);

        //Pass the data to next Activity
        intent.putExtra("fullname",_fullname);
        intent.putExtra("username",_username);
        intent.putExtra("email",_email);
        intent.putExtra("password",_password);


        /******************Add Animations Transitions *********************/
        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View, String>(backBtn, "transition_back_arrow_btn");
        pairs[1] = new Pair<View, String>(next, "transition_next_btn");
        pairs[2] = new Pair<View, String>(login, "transition_login_btn");
        pairs[3] = new Pair<View, String>(titleText, "transition_title_text");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);

            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }


    /******************Validation for Sign Up Screen*********************/

    private boolean validateFullname() {
        String val = fullname.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            fullname.setError("Field can not be empty");
            return false;

        } else {
            fullname.setError(null);
            fullname.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateUsername() {
        String val = username.getEditText().getText().toString().trim();
        String checkSpaces = "\\A\\w{1,20}\\z";
        if (val.isEmpty()) {
            username.setError("Field can not be empty");
            return false;

        } else if (val.length() > 20) {
            username.setError("Username is too big!!!");
            return false;

        } else if (!val.matches(checkSpaces)) {
            username.setError("White spaces are not allowed!!");
            return false;

        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmail() {
        String val = email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()) {
            email.setError("Field can not be empty");
            return false;

        } else if (!val.matches(checkEmail)) {
            email.setError("Invaild Email!!");
            return false;

        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = password.getEditText().getText().toString().trim();
        String chackPassword = "^" +
                "(?=.*[a-zA-Z])" +
                "(?=.*[@#$%^&+=])" +
                "(?=\\S+$)" +
                ".{4,}" +
                "$";
        if (val.isEmpty()) {
            password.setError("Field can not be empty");
            return false;

        } else if (!val.matches(chackPassword)) {
            password.setError("Password should contains 4 characters");
            return false;

        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }


}
