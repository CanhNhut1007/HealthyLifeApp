package com.example.sdkfacebook.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sdkfacebook.R;

public class ForgotPasswordEmailPage extends AppCompatActivity {

    TextView txtEmailRPE;
    Button btGotItRPE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_email_page);

        Mapping();
        GetEmailFromRPPage();
        GoToResetPasswordPage();
    }

    private void Mapping() {
        txtEmailRPE = (TextView) findViewById(R.id.textViewEmailRPE);
        btGotItRPE = (Button) findViewById(R.id.buttonGotItRPE);
    }

    private void GetEmailFromRPPage() {
        Intent intent = getIntent();
        txtEmailRPE.setText(intent.getStringExtra("EmailRP"));
    }

    private void GoToResetPasswordPage() {
        btGotItRPE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPasswordEmailPage.this, ResetPasswordPage.class);
                startActivity(intent);
            }
        });
    }
}
