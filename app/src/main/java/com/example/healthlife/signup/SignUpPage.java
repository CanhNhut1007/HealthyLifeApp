package com.example.healthlife.signup;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.healthlife.R;
import com.example.healthlife.Utils;
import com.example.healthlife.patientactivity.PatientHomePage;
import com.example.healthlife.signin.SignInPage;

import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;

import com.example.healthlife.entities.AccessToken;
import com.example.healthlife.entities.ApiError;
import com.example.healthlife.network.ApiService;
import com.example.healthlife.network.RetrofitBuilder;
import com.example.healthlife.TokenManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignUpPage extends AppCompatActivity {

    private static final String TAG = "SignUpPage";

    ImageButton imageButtonBack;
    EditText edtEmail, edtPassword, edtConrifmPassword;
    CheckBox checkBox;
    TextView txtSignInAcount, txtError;
    Button btContinueSu;

    ApiService service;
    AwesomeValidation validator;
    Call<AccessToken> call;
    TokenManager tokenManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        Mapping();


        //SignIn();

        service = RetrofitBuilder.createService(ApiService.class);
        validator = new AwesomeValidation(ValidationStyle.TEXT_INPUT_LAYOUT);
        tokenManager = TokenManager.getInstance(getSharedPreferences("prefs", MODE_PRIVATE));
        setupRules();

        if(tokenManager.getToken().getAccessToken() != null){
            startActivity(new Intent(SignUpPage.this, PatientHomePage.class));
            finish();
        }

        //BackMainPage();
        GoToSignIn();
        SignIn();
    }

    private void Mapping() {
        imageButtonBack = (ImageButton) findViewById(R.id.imageButtonBackSu);
        edtEmail = (EditText) findViewById(R.id.editTextEmailSu);
        edtPassword = (EditText) findViewById(R.id.editTextPasswordSu);
        edtConrifmPassword = (EditText) findViewById(R.id.editTextConfirmPasswordSu);
        checkBox = (CheckBox) findViewById(R.id.checkboxPolicy);
        txtSignInAcount = (TextView) findViewById(R.id.textViewSignInAcount);
        btContinueSu = (Button) findViewById(R.id.buttonContinueSu);
        txtError = (TextView) findViewById(R.id.textViewErrorSu);
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



    public void SignIn(){
        btContinueSu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                String password_confirmation = edtConrifmPassword.getText().toString();

                call = service.register(email, password, password_confirmation);
                call.enqueue(new Callback<AccessToken>() {
                    @Override
                    public void onResponse(Call<AccessToken> call, retrofit2.Response<AccessToken> response) {

                        //Log.w(TAG, "onResponse: " + response);
                        Toast.makeText(SignUpPage.this, "onResponse: " + response, Toast.LENGTH_SHORT).show();
                        if (response.isSuccessful()) {
                            Toast.makeText(SignUpPage.this, "onResponse: " + response.body(), Toast.LENGTH_SHORT).show();
                            //Log.w(TAG, "onResponse: " + response.body() );
                            tokenManager.saveToken(response.body());
                            //startActivity(new Intent(SignUpPage.this, PatientHomePage.class));
                            //finish();
                        } else {
                            handleErrors(response.errorBody());
                        }

                    }

                    @Override
                    public void onFailure(Call<AccessToken> call, Throwable t) {
                        //Log.w(TAG, "onFailure: " + t.getMessage());
                        Toast.makeText(SignUpPage.this, "onFailure: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

                /*edtEmail.setError(null);
                edtPassword.setError(null);
                edtConrifmPassword.setError(null);*/

                //validator.clear();
/*
                if(validator.validate()) {
                    call = service.register(email, password,password_confirmation);
                    call.enqueue(new Callback<AccessToken>() {
                        @Override
                        public void onResponse(Call<AccessToken> call, retrofit2.Response<AccessToken> response) {

                            //Log.w(TAG, "onResponse: " + response);
                            Toast.makeText(SignUpPage.this,"onResponse: " + response,Toast.LENGTH_SHORT).show();
                            if (response.isSuccessful()) {
                                Toast.makeText(SignUpPage.this, "onResponse: " + response.body(), Toast.LENGTH_SHORT).show();
                                //Log.w(TAG, "onResponse: " + response.body() );
                                tokenManager.saveToken(response.body());
                                //startActivity(new Intent(SignUpPage.this, PatientHomePage.class));
                                //finish();
                            } else {
                                handleErrors(response.errorBody());
                            }

                        }

                        @Override
                        public void onFailure(Call<AccessToken> call, Throwable t) {
                            //Log.w(TAG, "onFailure: " + t.getMessage());
                            Toast.makeText(SignUpPage.this,"onFailure: " + t.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        */


    private void handleErrors(ResponseBody response){

        ApiError apiError = Utils.converErrors(response);

        for(Map.Entry<String, List<String>> error : apiError.getErrors().entrySet()){
            if(error.getKey().equals("email")){
                edtEmail.setError(error.getValue().get(0));
            }
            if(error.getKey().equals("password")){
                edtPassword.setError(error.getValue().get(0));
            }
            if(error.getKey().equals("password_confirmation")){
                edtConrifmPassword.setError(error.getValue().get(0));
            }
        }

    }

    public void setupRules(){

        validator.addValidation(this, R.id.editTextEmailSu, Patterns.EMAIL_ADDRESS, R.string.err_email);
        validator.addValidation(this, R.id.editTextPasswordSu,"[a-zA-Z0-9]{6,}", R.string.err_password);
        validator.addValidation(this, R.id.editTextConfirmPasswordSu, "[a-zA-Z0-9]{6,}", R.string.err_password);
    }
    /*
    boolean isEmailValid(CharSequence email) {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }

    public void SignIn()
    {
        final StringRequest postRequest = new StringRequest(Request.Method.POST, Utils.REGISTER_URL,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Toast.makeText(SignUpPage.this, response, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Toast.makeText(SignUpPage.this, "Error! Please again!" + error, Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("email", edtEmail.getText().toString());
                params.put("password", edtPassword.getText().toString());
                params.put("password_confirmation", edtConfirmPassword.getText().toString());
                return params;
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("Accept", "application/json");

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(postRequest);
    }*/
}
