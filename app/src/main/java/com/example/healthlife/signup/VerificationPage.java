package com.example.healthlife.signup;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthlife.R;
//import com.example.healthlife.WelcomePage;

public class VerificationPage extends AppCompatActivity {
    TextView txtResendLink, txtSetEmailVt;
    Button btVerification;
    EditText edtCode;
    String accountid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_page);
        Mapping();

        GetEmailVerification();
        //GoToWelcome();
    }

    private void Mapping() {
        txtResendLink = (TextView) findViewById(R.id.textViewResendLinkVt);
        txtSetEmailVt = (TextView) findViewById(R.id.textViewSetEmailVt);
        btVerification = (Button) findViewById(R.id.buttonVerificationVt);
        edtCode = (EditText) findViewById(R.id.editTextCodeVt);
    }

    private void GetEmailVerification() {
        Intent intent = getIntent();
        accountid = intent.getStringExtra("AccountID");
        txtSetEmailVt.setText("We take your security seriously. You should have received a verifiaction email from us at " + intent.getStringExtra("EmailVt") + " with an authentication code.  Please enter the code in the box below to complete the sign up process.");
    }

    /* void GoToWelcome() {
        txtResendLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VerificationPage.this, WelcomePage.class);
                startActivity(intent);
            }
        });
    }*/
}
