package com.example.sdkfacebook.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.sdkfacebook.R;
import com.example.sdkfacebook.WelcomePage;

public class VerificationPage extends AppCompatActivity {
    TextView txtResendLink, txtLogOut, txtSetEmailVt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_page);
        Mapping();

        GetEmailVerification();
        GoToWelcome();
    }

    private void Mapping() {
        txtLogOut = (TextView) findViewById(R.id.textViewLogOutVt);
        txtResendLink = (TextView) findViewById(R.id.textViewResendLinkVt);
        txtSetEmailVt = (TextView) findViewById(R.id.textViewSetEmailVt);
    }

    private void GetEmailVerification() {
        Intent intent = getIntent();
        txtSetEmailVt.setText("We take your security seriously. You should have received a verifiaction email from us at " + intent.getStringExtra("EmailVt") + " with an authentication link.  Please click the link in the email to complete the sign up process.");
    }

    private void GoToWelcome() {
        txtResendLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VerificationPage.this, WelcomePage.class);
                startActivity(intent);
            }
        });
    }
}
