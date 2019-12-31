package com.example.healthlife.doctoractivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.healthlife.MainActivity;
import com.example.healthlife.R;
import com.example.healthlife.Utils;
import com.example.healthlife.recyclerview.Patient;
import com.example.healthlife.recyclerview.PatientAdapter;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DoctorHomePage extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;
    private ActionBar actionbar;
    TextView txthi, txtSearch;
    ImageButton btnSearch;
    String accountid;

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<Patient> arrayList;
    PatientAdapter patientAdapter;
    RequestQueue requestQueue;
    String URL_GETNAME;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home_page);
        requestQueue = Volley.newRequestQueue(this);
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
        Intent intent = getIntent();
        accountid = intent.getStringExtra("AccountID");
        Toast.makeText(DoctorHomePage.this, accountid, Toast.LENGTH_SHORT).show();


        final NavigationView navigationView = (NavigationView) findViewById(R.id.navigationhome);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.homedoctor)
                {
                    Intent intent = new Intent(DoctorHomePage.this, DoctorHomePage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.listpatient)
                {
                    Intent intent = new Intent(DoctorHomePage.this, DoctorListPatientPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.notificationdoctor)
                {
                    Intent intent = new Intent(DoctorHomePage.this, DoctorNotificationPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.accountdoctor)
                {
                    Intent intent = new Intent(DoctorHomePage.this, DoctorAccountPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.profiledoctor)
                {
                    Intent intent = new Intent(DoctorHomePage.this, DoctorProfilePage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.settingdoctor)
                {
                    Intent intent = new Intent(DoctorHomePage.this, DoctorSettingPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.supportdoctor)
                {
                    Intent intent = new Intent(DoctorHomePage.this, DoctorSupportPage.class);
                    intent.putExtra("AccountID", accountid);
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
        btnSearch= (ImageButton) findViewById(R.id.btnSearch);
        URL_GETNAME = Utils.GET_DOCTOR_NAME + accountid;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_GETNAME, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) { ;
                txthi.setText("Hi " + response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);

        ViewPatient();
    }

    private void ViewPatient() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewHome);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        arrayList = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Utils.GET_PATIENT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject patient = array.getJSONObject(i);
                        arrayList.add(new Patient(accountid, patient.getString("AccountID"), patient.getString("PatientName"), patient.getString("IdentifyCard"), patient.getString("PatientID"), R.drawable.ic_account_circle_black_24dp));
                    }
                    patientAdapter = new PatientAdapter(arrayList, getApplicationContext());
                    recyclerView.setAdapter(patientAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }

    private void Search()
    {
            btnSearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!txtSearch.getText().toString().equals("")) {
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        arrayList = new ArrayList<>();

                        StringRequest postRequest = new StringRequest(Request.Method.POST, Utils.SEARCH_PATIENT,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        if (response != "No Patient Found!")
                                        {
                                            try {
                                                JSONArray array = new JSONArray(response);
                                                for (int i = 0; i < array.length(); i++) {
                                                    JSONObject patient = array.getJSONObject(i);
                                                    arrayList.add(new Patient(accountid, patient.getString("AccountID"), patient.getString("PatientName"), patient.getString("IdentifyCard"), patient.getString("PatientID"), R.drawable.ic_account_circle_black_24dp));
                                                }
                                                patientAdapter = new PatientAdapter(arrayList, getApplicationContext());
                                                recyclerView.setAdapter(patientAdapter);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        else
                                        {
                                            Toast.makeText(DoctorHomePage.this, "No Patient Found!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        // error
                                        Toast.makeText(DoctorHomePage.this, error + ". Loi roi", Toast.LENGTH_SHORT).show();
                                    }
                                }
                        ) {
                            @Override
                            protected Map<String, String> getParams() {
                                Map<String, String> params = new HashMap<String, String>();
                                String Search = txtSearch.getText().toString();
                                params.put("q", Search);

                                return params;
                            }
                        };
                        requestQueue.add(postRequest);
                        txtSearch.setText("");
                    }

                    else
                    {
                        Toast.makeText(DoctorHomePage.this, "Please enter keyword!", Toast.LENGTH_SHORT).show();
                    }

                /*StringRequest stringRequest = new StringRequest(Request.Method.GET, Utils.GET_PATIENT, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(getApplication(), response, Toast.LENGTH_SHORT).show();
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject patient = array.getJSONObject(i);
                                //Toast.makeText(getApplication(), patient+"", Toast.LENGTH_SHORT).show();
                                arrayList.add(new Patient(patient.getString("AccountID"), patient.getString("PatientName"), patient.getString("IdentifyCard"), patient.getString("PatientID"), R.mipmap.ic_launcher_round));

                            }
                            patientAdapter = new PatientAdapter(arrayList, getApplicationContext());
                            recyclerView.setAdapter(patientAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                requestQueue.add(stringRequest);*/
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
