package com.example.healthlife.doctoractivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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
import com.android.volley.toolbox.Volley;
import com.example.healthlife.MainActivity;
import com.example.healthlife.R;
import com.example.healthlife.Utils;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DoctorProfilePage extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;
    private ActionBar actionbar;
    RequestQueue requestQueue;
    ImageButton imageButtonEditAbout, imageButtonEditEdu, imageButtonEditLicense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile_page);
        requestQueue = Volley.newRequestQueue(this);
        SetNavigation();
        
        EditAbout();
    }

    public void SetNavigation()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbarprofile);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayoutprofile);
        imageButtonEditAbout = (ImageButton) findViewById(R.id.imageButtonEditAbout);
        imageButtonEditEdu = (ImageButton) findViewById(R.id.imageButtonEditEdu);
        imageButtonEditLicense = (ImageButton) findViewById(R.id.imageButtonEditLicense);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();;
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        final NavigationView navigationView = (NavigationView) findViewById(R.id.navigationprofile);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.homedoctor)
                {
                    Intent intent = new Intent(DoctorProfilePage.this, DoctorHomePage.class);
                    startActivity(intent);
                }
                else if (id == R.id.listpatient)
                {
                    Intent intent = new Intent(DoctorProfilePage.this, DoctorListPatientPage.class);
                    startActivity(intent);
                }
                else if (id == R.id.notificationdoctor)
                {
                    Intent intent = new Intent(DoctorProfilePage.this, DoctorNotificationPage.class);
                    startActivity(intent);
                }
                else if (id == R.id.accountdoctor)
                {
                    Intent intent = new Intent(DoctorProfilePage.this, DoctorAccountPage.class);
                    startActivity(intent);
                }
                else if (id == R.id.profiledoctor)
                {
                    Intent intent = new Intent(DoctorProfilePage.this, DoctorProfilePage.class);
                    startActivity(intent);
                }
                else if (id == R.id.settingdoctor)
                {
                    Intent intent = new Intent(DoctorProfilePage.this, DoctorSettingPage.class);
                    startActivity(intent);
                }
                else if (id == R.id.supportdoctor)
                {
                    Intent intent = new Intent(DoctorProfilePage.this, DoctorSupportPage.class);
                    startActivity(intent);
                }
                else if (id == R.id.logoutdoctor)
                {
                    Intent intent = new Intent(DoctorProfilePage.this, MainActivity.class);
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

    public void EditAbout()
    {
        imageButtonEditAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(DoctorProfilePage.this);
                View mView = getLayoutInflater().inflate(R.layout.doctor_profile_about, null);
                final EditText mName = (EditText) mView.findViewById(R.id.edtNameUp);
                final EditText mBirthday = (EditText) mView.findViewById(R.id.edtBirthdayUp);
                final EditText mIdentifyCard = (EditText) mView.findViewById(R.id.edtIdentifyCardUp);
                final EditText mGender = (EditText) mView.findViewById(R.id.edtGenderUp);
                final EditText mPhone = (EditText) mView.findViewById(R.id.edtPhoneUp);
                Button mSave = (Button) mView.findViewById(R.id.btnDoctorProfileAbout);


                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                mSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                            Verification(mName.getText().toString(), mBirthday.getText().toString(), mIdentifyCard.getText().toString(), mGender.getText().toString(), mPhone.getText().toString());
                    }
                });
            }

            private void Verification(String name, String birthday, String identify, String gender, String phone) {

                String URL = Utils.UPDATE_ABOUT + "ID00000001";

                Map<String, String> params = new HashMap();
                params.put("Name", name);
                params.put("Birthday", birthday);
                params.put("IdentifyCard", identify);
                params.put("Gender", gender);
                params.put("Phone", phone);

                JSONObject jsonObject = new JSONObject(params);

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonObject, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(getApplication(), response+"", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DoctorProfilePage.this, error+". Loi roi", Toast.LENGTH_SHORT).show();
                    }
                }) ;


                requestQueue.add(jsonObjectRequest);

            }
        });
    }
}
