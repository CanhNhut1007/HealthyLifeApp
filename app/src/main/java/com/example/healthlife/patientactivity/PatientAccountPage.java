package com.example.healthlife.patientactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.healthlife.MainActivity;
import com.example.healthlife.R;
import com.google.android.material.navigation.NavigationView;

public class PatientAccountPage extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;
    private ActionBar actionbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_account_page);
        SetNavigation();
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

        final NavigationView navigationView = (NavigationView) findViewById(R.id.navigationaccount_p);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.homedoctor)
                {
                    Intent intent = new Intent(PatientAccountPage.this, PatientHomePage.class);
                    startActivity(intent);
                }
                else if (id == R.id.myrecord)
                {
                    Intent intent = new Intent(PatientAccountPage.this, PatientMyRecordPage.class);
                    startActivity(intent);
                }
                else if (id == R.id.notificationdoctor)
                {
                    Intent intent = new Intent(PatientAccountPage.this, PatientNotificationPage.class);
                    startActivity(intent);
                }
                else if (id == R.id.accountdoctor)
                {
                    Intent intent = new Intent(PatientAccountPage.this, PatientAccountPage.class);
                    startActivity(intent);
                }
                else if (id == R.id.profiledoctor)
                {
                    Intent intent = new Intent(PatientAccountPage.this, PatientProfilePage.class);
                    startActivity(intent);
                }
                else if (id == R.id.settingdoctor)
                {
                    Intent intent = new Intent(PatientAccountPage.this, PatientSettingPage.class);
                    startActivity(intent);
                }
                else if (id == R.id.supportdoctor)
                {
                    Intent intent = new Intent(PatientAccountPage.this, PatientSupportPage.class);
                    startActivity(intent);
                }
                else if (id == R.id.logoutdoctor)
                {
                    Intent intent = new Intent(PatientAccountPage.this, MainActivity.class);
                    startActivity(intent);
                }
                return true;
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
