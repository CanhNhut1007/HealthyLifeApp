package com.example.sdkfacebook.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sdkfacebook.R;
import com.example.sdkfacebook.doctor.doctor_main_activity;
import com.example.sdkfacebook.mainactivity.MainHealthLifePage;
import com.example.sdkfacebook.signup.SignUpPage;

public class SignInPage extends AppCompatActivity {

    ImageButton imageButtonBack;
    EditText edtEmail, edtPassword;
    TextView txtForgotPassword, txtSignUpAcount;
    Button btSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);
        Mapping();

        BackMainPage();
        GoToSignUp();
        GoToForgotPasswordPage();
        GoToMainHealthLifePage();

    }

    private void Mapping() {
        imageButtonBack = (ImageButton) findViewById(R.id.imageButtonBackSi);
        edtEmail = (EditText) findViewById(R.id.editTextEmailSi);
        edtPassword = (EditText) findViewById(R.id.editTextPasswordSi);
        txtForgotPassword = (TextView) findViewById(R.id.textViewForgotPassword);
        txtSignUpAcount = (TextView) findViewById(R.id.textViewSignUpAcount);
        btSignIn = (Button) findViewById(R.id.buttonSignInSi);
    }

    private void BackMainPage() {
        imageButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void GoToSignUp() {
        txtSignUpAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInPage.this, SignUpPage.class);
                startActivity(intent);
            }
        });
    }

    private void GoToForgotPasswordPage() {
        txtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInPage.this, ForgotPasswordPage.class);
                startActivity(intent);
            }
        });
    }

    private void GoToMainHealthLifePage() {
        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = edtEmail.getText().toString();
                String e1="123";
                if(e.equals(e1))
                {
                    Intent intent = new Intent(SignInPage.this, MainHealthLifePage.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(SignInPage.this, doctor_main_activity.class);
                    startActivity(intent);
                }

            }
        });
    }
}
