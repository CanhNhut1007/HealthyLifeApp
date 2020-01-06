package com.example.healthlife.signin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.healthlife.R;
import com.example.healthlife.Utils;
import com.example.healthlife.patientactivity.PatientHomePage;
import com.example.healthlife.signup.SignUpPage;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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
                //Intent intent = new Intent(SignInPage.this, DoctorHomePage.class);
                //intent.putExtra("UserID", "850000002");
                //intent.putExtra("UserID", "ID00000004");
                //startActivity(intent);
                SignIn();
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

    public void SignIn()
    {
        final StringRequest postRequest = new StringRequest(Request.Method.POST, Utils.LOGIN_URL,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Toast.makeText(SignInPage.this, response, Toast.LENGTH_SHORT).show();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Intent intent = new Intent(SignInPage.this, PatientHomePage.class);
                            intent.putExtra("UserID", jsonObject.getString("UserID"));
                            startActivity(intent);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Toast.makeText(SignInPage.this, "Error! Please again!", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("email", edtEmail.getText().toString());
                params.put("pass", edtPassword.getText().toString());

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(postRequest);
    }



}

