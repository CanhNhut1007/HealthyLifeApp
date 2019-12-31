package com.example.healthlife.signin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthlife.R;
import com.example.healthlife.doctoractivity.DoctorHomePage;
import com.example.healthlife.signup.SignUpPage;

//import com.example.sdkfacebook.mainactivity.MainHealthLifePage;

public class SignInPage extends AppCompatActivity {

    String URL_SIGNIN = "http://10.45.159.177/android/SignIn.php";

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
        //GoToForgotPasswordPage();
        GoToMainHealthLifePage();

        //Login();

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

    /*private void GoToForgotPasswordPage() {
        txtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInPage.this, ForgotPasswordPage.class);
                startActivity(intent);
            }
        });
    }*/

    private void GoToMainHealthLifePage() {
        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInPage.this, DoctorHomePage.class);
                intent.putExtra("AccountID", "ID00000001");
                //intent.putExtra("AccountID", "ID00000004");
                startActivity(intent);
            }
        });
    }

    private void Login() {
        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=edtEmail.getText().toString();
                String pass_word=edtPassword.getText().toString();
                String type="login";


            }
        });
    }



}

