package com.example.sdkfacebook.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.sdkfacebook.MainActivity;
import com.example.sdkfacebook.R;

public class ResetPasswordPage extends AppCompatActivity {

    ImageButton imageButtonRPP;
    EditText edtPasswordRPP, edtConfirmPasswordRPP;
    Button btConfirmRPP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password_page);
        Mapping();

        BackToMain();
    }

    private void Mapping() {
        imageButtonRPP = (ImageButton) findViewById(R.id.imageButtonBackRPP);
        edtPasswordRPP = (EditText) findViewById(R.id.editTextPasswordRPP);
        edtConfirmPasswordRPP = (EditText) findViewById(R.id.editTextConfirmPasswordRPP);
    }

    private void BackToMain() {
        imageButtonRPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResetPasswordPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
