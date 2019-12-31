package com.example.healthlife.doctoractivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

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

public class DoctorAccountPage extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;
    private ActionBar actionbar;
    String accountid;

    TextView txtDoctorName, txtEditProfile;
    LinearLayout linearLayoutSetting, linearLayoutSupport, linearLayoutLogout;
    RequestQueue requestQueue;
    String URL_GETNAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_account_page);
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
        toolbar = (Toolbar) findViewById(R.id.toolbaraccount);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayoutaccount);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();;
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        Intent intent = getIntent();
        accountid = intent.getStringExtra("AccountID");

        final NavigationView navigationView = (NavigationView) findViewById(R.id.navigationaccount);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.homedoctor)
                {
                    Intent intent = new Intent(DoctorAccountPage.this, DoctorHomePage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.listpatient)
                {
                    Intent intent = new Intent(DoctorAccountPage.this, DoctorListPatientPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.notificationdoctor)
                {
                    Intent intent = new Intent(DoctorAccountPage.this, DoctorNotificationPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.accountdoctor)
                {
                    Intent intent = new Intent(DoctorAccountPage.this, DoctorAccountPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.profiledoctor)
                {
                    Intent intent = new Intent(DoctorAccountPage.this, DoctorProfilePage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.settingdoctor)
                {
                    Intent intent = new Intent(DoctorAccountPage.this, DoctorSettingPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.supportdoctor)
                {
                    Intent intent = new Intent(DoctorAccountPage.this, DoctorSupportPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.logoutdoctor)
                {
                    Intent intent = new Intent(DoctorAccountPage.this, MainActivity.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }

                return true;
            }
        });
    }

    public void Mapping()
    {
        txtDoctorName = (TextView) findViewById(R.id.textViewDoctorNameDA);
        txtEditProfile = (TextView) findViewById(R.id.textViewEditProfileDA);
        linearLayoutSetting = (LinearLayout) findViewById(R.id.linearLayoutSettingDA);
        linearLayoutSupport = (LinearLayout) findViewById(R.id.linearLayoutSupportDA);
        linearLayoutLogout = (LinearLayout) findViewById(R.id.linearLayoutLogoutDA);

        URL_GETNAME = Utils.GET_DOCTOR_NAME + accountid;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_GETNAME, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) { ;
                txtDoctorName.setText(response);
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
                Intent intent = new Intent(DoctorAccountPage.this, DoctorProfilePage.class);
                intent.putExtra("AccountID", accountid);
                startActivity(intent);
            }
        });
    }

    public void GoToSetting()
    {
        linearLayoutSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoctorAccountPage.this, DoctorSettingPage.class);
                intent.putExtra("AccountID", accountid);
                startActivity(intent);
            }
        });
    }

    public void GoToSupport()
    {
        linearLayoutSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoctorAccountPage.this, DoctorSupportPage.class);
                intent.putExtra("AccountID", accountid);
                startActivity(intent);
            }
        });
    }

    public void GoToLogout()
    {
        linearLayoutLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoctorAccountPage.this, MainActivity.class);
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
