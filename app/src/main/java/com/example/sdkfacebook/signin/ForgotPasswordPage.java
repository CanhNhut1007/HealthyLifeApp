package com.example.sdkfacebook.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.sdkfacebook.R;

public class ForgotPasswordPage extends AppCompatActivity {

    ImageButton imageButtonBackRP;
    EditText edtEmailRP;
    Button btContinueRP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_page);
        Mapping();

        BackSignInPage();
        GoToForgotPasswordEmailPage();
    }

    private void Mapping() {
        imageButtonBackRP = (ImageButton) findViewById(R.id.imageButtonBackRP);
        edtEmailRP = (EditText) findViewById(R.id.editTextEmailRP);
        btContinueRP = (Button) findViewById(R.id.buttonRPContinue);
    }

    private void BackSignInPage() {
        imageButtonBackRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();;
            }
        });
    }

    private void GoToForgotPasswordEmailPage() {
        btContinueRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPasswordPage.this, ForgotPasswordEmailPage.class);
                intent.putExtra("EmailRP", edtEmailRP.getText().toString());
                startActivity(intent);

            }
        });
    }
}
