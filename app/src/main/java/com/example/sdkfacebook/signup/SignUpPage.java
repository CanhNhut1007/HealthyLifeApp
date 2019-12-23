package com.example.sdkfacebook.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sdkfacebook.R;
import com.example.sdkfacebook.signin.SignInPage;

public class SignUpPage extends AppCompatActivity {

    ImageButton imageButtonBack;
    EditText edtEmail, edtPassword;
    CheckBox checkBox;
    TextView txtSignInAcount;
    Button btContinueSu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        Mapping();

        BackMainPage();
        GoToSignIn();
        GoToVerification();
    }

    private void Mapping() {
        imageButtonBack = (ImageButton) findViewById(R.id.imageButtonBackSu);
        edtEmail = (EditText) findViewById(R.id.editTextEmailSu);
        edtPassword = (EditText) findViewById(R.id.editTextPasswordSu);
        checkBox = (CheckBox) findViewById(R.id.checkboxPolicy);
        txtSignInAcount = (TextView) findViewById(R.id.textViewSignInAcount);
        btContinueSu = (Button) findViewById(R.id.buttonContinueSu);
    }

    private void BackMainPage() {
        imageButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void GoToSignIn() {
        txtSignInAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpPage.this, SignInPage.class);
                startActivity(intent);
            }
        });
    }

    private void GoToVerification() {
        btContinueSu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpPage.this, VerificationPage.class);
                intent.putExtra("EmailVt", edtEmail.getText().toString());
                startActivity(intent);
            }
        });
    }
}
