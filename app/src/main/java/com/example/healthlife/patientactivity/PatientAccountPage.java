package com.example.healthlife.patientactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.healthlife.MainActivity;
import com.example.healthlife.R;
import com.example.healthlife.Utils;
import com.google.android.material.navigation.NavigationView;

public class PatientAccountPage extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;
    private ActionBar actionbar;
    String accountid;

    TextView txtPatientName, txtEditProfile;
    LinearLayout linearLayoutSetting, linearLayoutSupport, linearLayoutLogout;
    RequestQueue requestQueue;
    String URL_GETNAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_account_page);
        requestQueue = Volley.newRequestQueue(this);
        SetNavigation();
        Mapping();
        GoToProfile();
        GoToSetting();
        GoToSupport();
        GoToLogout();
    }

    public void SetNavigation()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbaraccount_p);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayoutaccount_p);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        Intent intent = getIntent();
        accountid = intent.getStringExtra("UserID");
        Toast.makeText(PatientAccountPage.this, accountid, Toast.LENGTH_SHORT).show();

        final NavigationView navigationView = (NavigationView) findViewById(R.id.navigationaccount_p);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.homepatient)
                {
                    Intent intent = new Intent(PatientAccountPage.this, PatientHomePage.class);
                    intent.putExtra("UserID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.myrecord)
                {
                    Intent intent = new Intent(PatientAccountPage.this, PatientMyRecordPage.class);
                    intent.putExtra("UserID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.notificationpatient)
                {
                    Intent intent = new Intent(PatientAccountPage.this, PatientNotificationPage.class);
                    intent.putExtra("UserID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.accountpatient)
                {
                    Intent intent = new Intent(PatientAccountPage.this, PatientAccountPage.class);
                    intent.putExtra("UserID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.profilepatient)
                {
                    Intent intent = new Intent(PatientAccountPage.this, PatientProfilePage.class);
                    intent.putExtra("UserID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.settingpatient)
                {
                    Intent intent = new Intent(PatientAccountPage.this, PatientSettingPage.class);
                    intent.putExtra("UserID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.supportpatient)
                {
                    Intent intent = new Intent(PatientAccountPage.this, PatientSupportPage.class);
                    intent.putExtra("UserID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.logoutpatient)
                {
                    Intent intent = new Intent(PatientAccountPage.this, MainActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });
    }

    public void Mapping()
    {
        txtPatientName = (TextView) findViewById(R.id.textViewPatientNamePatientAccount);
        txtEditProfile = (TextView) findViewById(R.id.textViewEditProfilePatientAccount);
        linearLayoutSetting = (LinearLayout) findViewById(R.id.linearLayoutSettingPatientAccount);
        linearLayoutSupport = (LinearLayout) findViewById(R.id.linearLayoutSupportPatientAccount);
        linearLayoutLogout = (LinearLayout) findViewById(R.id.linearLayoutLogoutPatientAccount);

        URL_GETNAME = Utils.GET_PATIENT_NAME + accountid;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_GETNAME, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) { ;
                txtPatientName.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }

    public void GoToProfile()
    {
        txtEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PatientAccountPage.this, PatientProfilePage.class);
                intent.putExtra("UserID", accountid);
                startActivity(intent);
            }
        });
    }

    public void GoToSetting()
    {
        linearLayoutSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PatientAccountPage.this, PatientSettingPage.class);
                intent.putExtra("UserID", accountid);
                startActivity(intent);
            }
        });
    }

    public void GoToSupport()
    {
        linearLayoutSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PatientAccountPage.this, PatientSupportPage.class);
                intent.putExtra("UserID", accountid);
                startActivity(intent);
            }
        });
    }

    public void GoToLogout()
    {
        linearLayoutLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PatientAccountPage.this, MainActivity.class);
                startActivity(intent);
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
}
