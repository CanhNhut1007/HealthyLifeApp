package com.example.healthlife.patientactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.healthlife.MainActivity;
import com.example.healthlife.R;
import com.example.healthlife.Utils;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PatientSettingPage extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;
    private ActionBar actionbar;
    RequestQueue requestQueue;
    String accountid;

    TextView txtEmail;
    LinearLayout linearLayoutEmail, linearLayoutPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_setting_page);
        requestQueue = Volley.newRequestQueue(this);
        SetNavigation();
        Mapping();
        UpdateEmail();
        UpdatePassword();
    }

    public void SetNavigation()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbarsetting_p);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayoutsetting_p);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        Intent intent = getIntent();
        accountid = intent.getStringExtra("UserID");
        Toast.makeText(PatientSettingPage.this, accountid, Toast.LENGTH_SHORT).show();

        final NavigationView navigationView = (NavigationView) findViewById(R.id.navigationsetting_p);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.homepatient)
                {
                    Intent intent = new Intent(PatientSettingPage.this, PatientHomePage.class);
                    intent.putExtra("UserID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.myrecord)
                {
                    Intent intent = new Intent(PatientSettingPage.this, PatientMyRecordPage.class);
                    intent.putExtra("UserID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.notificationpatient)
                {
                    Intent intent = new Intent(PatientSettingPage.this, PatientNotificationPage.class);
                    intent.putExtra("UserID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.accountpatient)
                {
                    Intent intent = new Intent(PatientSettingPage.this, PatientAccountPage.class);
                    intent.putExtra("UserID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.profilepatient)
                {
                    Intent intent = new Intent(PatientSettingPage.this, PatientProfilePage.class);
                    intent.putExtra("UserID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.settingpatient)
                {
                    Intent intent = new Intent(PatientSettingPage.this, PatientSettingPage.class);
                    intent.putExtra("UserID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.supportpatient)
                {
                    Intent intent = new Intent(PatientSettingPage.this, PatientSupportPage.class);
                    intent.putExtra("UserID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.logoutpatient)
                {
                    Intent intent = new Intent(PatientSettingPage.this, MainActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });
    }

    public void Mapping()
    {
        String URL_GET_EMAILPATIENT = Utils.GET_EMAIL_PATIENT + accountid;
        txtEmail = (TextView) findViewById(R.id.textViewCurrentEmailPatientSetting);
        linearLayoutEmail = (LinearLayout) findViewById(R.id.linearLayoutPatientSettingEmail);
        linearLayoutPass = (LinearLayout) findViewById(R.id.linearLayoutPatientSettingPass);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_GET_EMAILPATIENT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) { ;
                txtEmail.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }

    public void UpdateEmail()
    {
        linearLayoutEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(PatientSettingPage.this);
                View mView = getLayoutInflater().inflate(R.layout.patient_setting_email, null);
                final EditText mEmail = (EditText) mView.findViewById(R.id.edtEmailSetEm_p);
                final EditText mPass = (EditText) mView.findViewById(R.id.edtPassSetEm_p);
                Button mSave = (Button) mView.findViewById(R.id.btnSavePatientEmail);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                mSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Verification(mEmail.getText().toString(), mPass.getText().toString());
                        dialog.dismiss();
                    }
                });
            }

            private void Verification(String email, String pass) {

                String URL = Utils.UPDATE_EMAIL_PATIENT + accountid;

                if (!isEmailValid(email) || pass.equals("")){
                    Toast.makeText(PatientSettingPage.this, "Email or Password incorrect! Please enter again!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Map<String, String> params = new HashMap();
                    params.put("NewEmail", email);
                    params.put("Password", pass);

                    JSONObject jsonObject = new JSONObject(params);

                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonObject, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Toast.makeText(getApplication(), response+"", Toast.LENGTH_SHORT).show();
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(PatientSettingPage.this, "Error!", Toast.LENGTH_SHORT).show();
                        }
                    }) ;
                    requestQueue.add(jsonObjectRequest);
                }
            }
        });
    }

    public void UpdatePassword()
    {
        linearLayoutPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(PatientSettingPage.this);
                View mView = getLayoutInflater().inflate(R.layout.patient_setting_pass, null);
                final EditText mPass = (EditText) mView.findViewById(R.id.edtCurrentPassSetPa_p);
                final EditText mNewPass = (EditText) mView.findViewById(R.id.edtNewPassSetPa_p);
                final EditText mConfirmPass = (EditText) mView.findViewById(R.id.edtConfirmPassSetPa_p);
                Button mSave = (Button) mView.findViewById(R.id.btnSavePatientPass);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                mSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Verification(mPass.getText().toString(), mNewPass.getText().toString(), mConfirmPass.getText().toString());
                        dialog.dismiss();
                    }
                });
            }

            private void Verification(String pass, String newpass, String confirmpass) {

                String URL = Utils.UPDATE_PASS_PATIENT + accountid;

                if (pass.equals("") || newpass.equals("") || confirmpass.equals("") || !newpass.equals(confirmpass)){
                    Toast.makeText(PatientSettingPage.this, "Incorrect! Please enter again!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Map<String, String> params = new HashMap();
                    params.put("NewPassword", newpass);

                    JSONObject jsonObject = new JSONObject(params);

                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonObject, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Toast.makeText(getApplication(), response+"", Toast.LENGTH_SHORT).show();
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(PatientSettingPage.this, error+". Loi roi", Toast.LENGTH_SHORT).show();
                        }
                    }) ;
                    requestQueue.add(jsonObjectRequest);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
