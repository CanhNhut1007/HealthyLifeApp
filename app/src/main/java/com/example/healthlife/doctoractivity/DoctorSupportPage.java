package com.example.healthlife.doctoractivity;

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

public class DoctorSupportPage extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;
    private ActionBar actionbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_support_page);
        SetNavigation();
    }

    public void SetNavigation()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbarsupport);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayoutsupport);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();;
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        final NavigationView navigationView = (NavigationView) findViewById(R.id.navigationsupport);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.homedoctor)
                {
                    Intent intent = new Intent(DoctorSupportPage.this, DoctorHomePage.class);
                    startActivity(intent);
                }
                else if (id == R.id.listpatient)
                {
                    Intent intent = new Intent(DoctorSupportPage.this, DoctorListPatientPage.class);
                    startActivity(intent);
                }
                else if (id == R.id.notificationdoctor)
                {
                    Intent intent = new Intent(DoctorSupportPage.this, DoctorNotificationPage.class);
                    startActivity(intent);
                }
                else if (id == R.id.accountdoctor)
                {
                    Intent intent = new Intent(DoctorSupportPage.this, DoctorAccountPage.class);
                    startActivity(intent);
                }
                else if (id == R.id.profiledoctor)
                {
                    Intent intent = new Intent(DoctorSupportPage.this, DoctorProfilePage.class);
                    startActivity(intent);
                }
                else if (id == R.id.settingdoctor)
                {
                    Intent intent = new Intent(DoctorSupportPage.this, DoctorSettingPage.class);
                    startActivity(intent);
                }
                else if (id == R.id.supportdoctor)
                {
                    Intent intent = new Intent(DoctorSupportPage.this, DoctorSupportPage.class);
                    startActivity(intent);
                }
                else if (id == R.id.logoutdoctor)
                {
                    Intent intent = new Intent(DoctorSupportPage.this, MainActivity.class);
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
