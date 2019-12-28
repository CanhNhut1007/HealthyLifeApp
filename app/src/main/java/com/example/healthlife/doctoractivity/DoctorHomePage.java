package com.example.healthlife.doctoractivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.healthlife.MainActivity;
import com.example.healthlife.R;
import com.google.android.material.navigation.NavigationView;

import static android.view.View.VISIBLE;

public class DoctorHomePage extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;
    private ActionBar actionbar;
    TableLayout tableLayout;
    ConstraintLayout lnresult;
    TextView txthi, txtSearch;
    Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home_page);
        SetNavigation();
        Mapping();
        Search();
    }

    public void SetNavigation()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbarhome);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayouthome);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        final NavigationView navigationView = (NavigationView) findViewById(R.id.navigationhome);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.homedoctor)
                {
                    Intent intent = new Intent(DoctorHomePage.this, DoctorHomePage.class);
                    startActivity(intent);
                }
                else if (id == R.id.listpatient)
                {
                    Intent intent = new Intent(DoctorHomePage.this, DoctorListPatientPage.class);
                    startActivity(intent);
                }
                else if (id == R.id.notificationdoctor)
                {
                    Intent intent = new Intent(DoctorHomePage.this, DoctorNotificationPage.class);
                    startActivity(intent);
                }
                else if (id == R.id.accountdoctor)
                {
                    Intent intent = new Intent(DoctorHomePage.this, DoctorAccountPage.class);
                    startActivity(intent);
                }
                else if (id == R.id.profiledoctor)
                {
                    Intent intent = new Intent(DoctorHomePage.this, DoctorProfilePage.class);
                    startActivity(intent);
                }
                else if (id == R.id.settingdoctor)
                {
                    Intent intent = new Intent(DoctorHomePage.this, DoctorSettingPage.class);
                    startActivity(intent);
                }
                else if (id == R.id.supportdoctor)
                {
                    Intent intent = new Intent(DoctorHomePage.this, DoctorSupportPage.class);
                    startActivity(intent);
                }
                else if (id == R.id.logoutdoctor)
                {
                    Intent intent = new Intent(DoctorHomePage.this, MainActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });
    }

    public void Mapping()
    {
        txthi= (TextView) findViewById(R.id.txthi);
        txtSearch= (TextView) findViewById(R.id.txtsearch);
        lnresult=(ConstraintLayout) findViewById(R.id.result);
        btnSearch= (Button) findViewById(R.id.btnSearch);
    }

    private void Search() {
        showresult();
    }

    private void showresult() {
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lnresult.setVisibility(VISIBLE);
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
