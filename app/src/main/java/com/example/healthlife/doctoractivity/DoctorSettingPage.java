package com.example.healthlife.doctoractivity;

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

public class DoctorSettingPage extends AppCompatActivity {

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
        setContentView(R.layout.activity_doctor_setting_page);
        requestQueue = Volley.newRequestQueue(this);
        SetNavigation();
        Mapping();
        UpdateEmail();
        UpdatePassword();
    }

    public void SetNavigation()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbarsetting);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayoutsetting);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();;
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        Intent intent = getIntent();
        accountid = intent.getStringExtra("UserID");


        final NavigationView navigationView = (NavigationView) findViewById(R.id.navigationsetting);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.homedoctor)
                {
                    Intent intent = new Intent(DoctorSettingPage.this, DoctorHomePage.class);
                    intent.putExtra("UserID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.listpatient)
                {
                    Intent intent = new Intent(DoctorSettingPage.this, DoctorListPatientPage.class);
                    intent.putExtra("UserID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.notificationdoctor)
                {
                    Intent intent = new Intent(DoctorSettingPage.this, DoctorNotificationPage.class);
                    intent.putExtra("UserID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.accountdoctor)
                {
                    Intent intent = new Intent(DoctorSettingPage.this, DoctorAccountPage.class);
                    intent.putExtra("UserID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.profiledoctor)
                {
                    Intent intent = new Intent(DoctorSettingPage.this, DoctorProfilePage.class);
                    intent.putExtra("UserID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.settingdoctor)
                {
                    Intent intent = new Intent(DoctorSettingPage.this, DoctorSettingPage.class);
                    intent.putExtra("UserID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.supportdoctor)
                {
                    Intent intent = new Intent(DoctorSettingPage.this, DoctorSupportPage.class);
                    intent.putExtra("UserID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.logoutdoctor)
                {
                    Intent intent = new Intent(DoctorSettingPage.this, MainActivity.class);
                    startActivity(intent);
                }

                return true;
            }
        });
    }

    public void Mapping()
    {
        String URL_GET_EMAILDOCTOR = Utils.GET_EMAIL_DOCTOR + accountid;
        txtEmail = (TextView) findViewById(R.id.textViewCurrentEmailDoctorSetting);
        linearLayoutEmail = (LinearLayout) findViewById(R.id.linearLayoutDoctorSettingEmail);
        linearLayoutPass = (LinearLayout) findViewById(R.id.linearLayoutDoctorSettingPass);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_GET_EMAILDOCTOR, new Response.Listener<String>() {
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
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(DoctorSettingPage.this);
                View mView = getLayoutInflater().inflate(R.layout.doctor_setting_email, null);
                final EditText mEmail = (EditText) mView.findViewById(R.id.edtEmailSetEm);
                final EditText mPass = (EditText) mView.findViewById(R.id.edtPassSetEm);
                Button mSave = (Button) mView.findViewById(R.id.btnSaveDoctorEmail);

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

                String URL = Utils.UPDATE_EMAIL_DOCTOR + accountid;

                if (!isEmailValid(email) || pass.equals("")){
                    Toast.makeText(DoctorSettingPage.this, "Email or Password incorrect! Please enter again!", Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(DoctorSettingPage.this, "Error", Toast.LENGTH_SHORT).show();
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
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(DoctorSettingPage.this);
                View mView = getLayoutInflater().inflate(R.layout.doctor_setting_pass, null);
                final EditText mPass = (EditText) mView.findViewById(R.id.edtCurrentPassSetPa);
                final EditText mNewPass = (EditText) mView.findViewById(R.id.edtNewPassSetPa);
                final EditText mConfirmPass = (EditText) mView.findViewById(R.id.edtConfirmPassSetPa);
                Button mSave = (Button) mView.findViewById(R.id.btnSaveDoctorPass);

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

                String URL = Utils.UPDATE_PASS_DOCTOR + accountid;

                if (pass.equals("") || newpass.equals("") || confirmpass.equals("") || !newpass.equals(confirmpass)){
                    Toast.makeText(DoctorSettingPage.this, "Incorrect! Please enter again!", Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(DoctorSettingPage.this, error+". Loi roi", Toast.LENGTH_SHORT).show();
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
