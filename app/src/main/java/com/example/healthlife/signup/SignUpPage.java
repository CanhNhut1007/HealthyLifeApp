package com.example.healthlife.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.healthlife.R;
import com.example.healthlife.Utils;
import com.example.healthlife.signin.SignInPage;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignUpPage extends AppCompatActivity {

    String URL_SIGNUP = "http://10.45.159.177/android/SignUp.php";

    ImageButton imageButtonBack;
    EditText edtEmail, edtPassword, edtConrifmPassword;
    CheckBox checkBox;
    TextView txtSignInAcount, txtError;
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

    private void GoToVerification() {
        btContinueSu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(SignUpPage.this, VerificationPage.class);
                intent.putExtra("EmailVt", edtEmail.getText().toString());
                startActivity(intent);*/
                //if (edtPassword.getText().toString().equals(edtConrifmPassword.getText().toString()))
                if (!isEmailValid(edtEmail.getText().toString()))
                {
                    txtError.setText("");
                    Toast.makeText(getApplicationContext(), "Please enter your mail again!", Toast.LENGTH_LONG).show();
                    //Verification();
                }
                else if (!edtPassword.getText().toString().equals(edtConrifmPassword.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(), "Password and Confirm Password aren't the same. Please enter again!", Toast.LENGTH_LONG).show();
                    //txtError.setText("Password and Confirm Password aren't the same. Please enter again");
                    edtPassword.setText("");
                    edtConrifmPassword.setText("");
                }
                else if (!checkBox.isChecked())
                {
                    Toast.makeText(getApplicationContext(), "Please check Policy!", Toast.LENGTH_LONG).show();
                }
                else
                    {
                        Toast.makeText(getApplicationContext(), "Sign up success!", Toast.LENGTH_LONG).show();
                        Verification();
                }

            }
        });
    }

    boolean isEmailValid(CharSequence email) {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }

    private void Verification() {

        Map<String, String> params = new HashMap();
        params.put("email", edtEmail.getText().toString());
        params.put("pass", edtPassword.getText().toString());

        JSONObject jsonObject = new JSONObject(params);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, Utils.REGISTER_URL, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //Toast.makeText(getApplication(), response+"", Toast.LENGTH_SHORT).show();
                String accountid  = null;
                try {
                    accountid = response.getString("AccountID");
                    Intent intent = new Intent(SignUpPage.this, VerificationPage.class);
                    intent.putExtra("EmailVt", edtEmail.getText().toString());
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SignUpPage.this, error+". Loi roi", Toast.LENGTH_SHORT).show();
            }
        }) /*{
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap();
                params.put("email", edtEmail.getText().toString());
                params.put("pass", edtPassword.getText().toString());
                return params;
            }
        }*/;
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);

        /*StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_SIGNUP, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplication(), response, Toast.LENGTH_SHORT).show();
                JSONObject obj;

                try {
                    obj = new JSONObject(response);

                    String accountid  = obj.getString("AccountID");
                    Intent intent = new Intent(SignUpPage.this, VerificationPage.class);
                    intent.putExtra("EmailVt", edtEmail.getText().toString());
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SignUpPage.this, error+"", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                String Email = edtEmail.getText().toString();
                String Pass = edtPassword.getText().toString();
                params.put("email", Email);
                params.put("pass", Pass);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);*/
    }
}
