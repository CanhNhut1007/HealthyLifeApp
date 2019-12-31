package com.example.healthlife.patientactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
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
import com.example.healthlife.recyclerview.HealthRecord;
import com.example.healthlife.recyclerview.HealthRecordAdapter;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PatientMyRecordPage extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;
    private ActionBar actionbar;
    String accountid;

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<HealthRecord> arrayList;
    HealthRecordAdapter healthRecordAdapter;
    RequestQueue requestQueue;
    String URL_HEALTHRECORD = Utils.GET_LIST_HEALTHRECORD + "ID00000004";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_my_record_page);
        requestQueue = Volley.newRequestQueue(this);
        SetNavigation();
        ViewHealthRecord();
    }

    public void SetNavigation()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbarmyrecord_p);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayoutmyrecord_p);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        Intent intent = getIntent();
        accountid = intent.getStringExtra("AccountID");
        Toast.makeText(PatientMyRecordPage.this, accountid, Toast.LENGTH_SHORT).show();

        final NavigationView navigationView = (NavigationView) findViewById(R.id.navigationmyrecord_p);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.homepatient)
                {
                    Intent intent = new Intent(PatientMyRecordPage.this, PatientHomePage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.myrecord)
                {
                    Intent intent = new Intent(PatientMyRecordPage.this, PatientMyRecordPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.notificationpatient)
                {
                    Intent intent = new Intent(PatientMyRecordPage.this, PatientNotificationPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.accountpatient)
                {
                    Intent intent = new Intent(PatientMyRecordPage.this, PatientAccountPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.profilepatient)
                {
                    Intent intent = new Intent(PatientMyRecordPage.this, PatientProfilePage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.settingpatient)
                {
                    Intent intent = new Intent(PatientMyRecordPage.this, PatientSettingPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.supportpatient)
                {
                    Intent intent = new Intent(PatientMyRecordPage.this, PatientSupportPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.logoutpatient)
                {
                    Intent intent = new Intent(PatientMyRecordPage.this, MainActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });
    }

    private void ViewHealthRecord() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewListHealthRecord);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        arrayList = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_HEALTHRECORD, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject healthrecord = array.getJSONObject(i);
                        arrayList.add(new HealthRecord(healthrecord.getString("HealthRecordID"), healthrecord.getString("EmployeeID"), healthrecord.getString("HealthRecorDateTime"), R.drawable.ic_assignment_black_24dp));
                    }
                    healthRecordAdapter = new HealthRecordAdapter(arrayList, getApplicationContext());
                    recyclerView.setAdapter(healthRecordAdapter);
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
