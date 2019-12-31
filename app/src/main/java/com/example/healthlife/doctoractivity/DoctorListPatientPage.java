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

public class DoctorListPatientPage extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;
    private ActionBar actionbar;
    String accountid;

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<Patient> arrayList;
    PatientAdapter patientAdapter;
    RequestQueue requestQueue;
    String URL_LISTPATIENT = Utils.GET_LIST_PATIENT + "ID00000001";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list_patient_page);
        requestQueue = Volley.newRequestQueue(this);
        SetNavigation();
        ViewPatient();
    }

    public void SetNavigation()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbarlistpatient);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayoutlistpatient);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();;
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        Intent intent = getIntent();
        accountid = intent.getStringExtra("AccountID");


        final NavigationView navigationView = (NavigationView) findViewById(R.id.navigationlistpatient);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.homedoctor)
                {
                    Intent intent = new Intent(DoctorListPatientPage.this, DoctorHomePage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.listpatient)
                {
                    Intent intent = new Intent(DoctorListPatientPage.this, DoctorListPatientPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.notificationdoctor)
                {
                    Intent intent = new Intent(DoctorListPatientPage.this, DoctorNotificationPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.accountdoctor)
                {
                    Intent intent = new Intent(DoctorListPatientPage.this, DoctorAccountPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.profiledoctor)
                {
                    Intent intent = new Intent(DoctorListPatientPage.this, DoctorProfilePage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.settingdoctor)
                {
                    Intent intent = new Intent(DoctorListPatientPage.this, DoctorSettingPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.supportdoctor)
                {
                    Intent intent = new Intent(DoctorListPatientPage.this, DoctorSupportPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.logoutdoctor)
                {
                    Intent intent = new Intent(DoctorListPatientPage.this, MainActivity.class);
                    startActivity(intent);
                }

                return true;
            }
        });
    }

    private void ViewPatient() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewListPatient);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        arrayList = new ArrayList<>();
        /*arrayList.add(new Patient("123", "chau", "123", "pi09", R.drawable.ic_account_circle_black_24dp));
        arrayList.add(new Patient("123", "chau", "123", "pi09", R.drawable.ic_account_circle_black_24dp));
        arrayList.add(new Patient("123", "chau", "123", "pi09", R.drawable.ic_account_circle_black_24dp));
        arrayList.add(new Patient("123", "chau", "123", "pi09", R.drawable.ic_account_circle_black_24dp));
        arrayList.add(new Patient("123", "chau", "123", "pi09", R.drawable.ic_account_circle_black_24dp));
        arrayList.add(new Patient("123", "chau", "123", "pi09", R.drawable.ic_account_circle_black_24dp));
        arrayList.add(new Patient("123", "chau", "123", "pi09", R.drawable.ic_account_circle_black_24dp));
        arrayList.add(new Patient("123", "chau", "123", "pi09", R.drawable.ic_account_circle_black_24dp));
        arrayList.add(new Patient("123", "chau", "123", "pi09", R.drawable.ic_account_circle_black_24dp));
        arrayList.add(new Patient("123", "chau", "123", "pi09", R.drawable.ic_account_circle_black_24dp));
        arrayList.add(new Patient("123", "chau", "123", "pi09", R.drawable.ic_account_circle_black_24dp));
        arrayList.add(new Patient("123", "chau", "123", "pi09", R.drawable.ic_account_circle_black_24dp));
        patientAdapter = new PatientAdapter(arrayList, getApplicationContext());
        recyclerView.setAdapter(patientAdapter);*/

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_LISTPATIENT, new Response.Listener<String>() {
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
