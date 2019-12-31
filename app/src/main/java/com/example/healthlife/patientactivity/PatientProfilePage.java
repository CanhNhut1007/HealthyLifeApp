package com.example.healthlife.patientactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.healthlife.MainActivity;
import com.example.healthlife.R;
import com.example.healthlife.Utils;
import com.example.healthlife.listview.CustomExpandableListAdapter;
import com.example.healthlife.listview.InfoClass;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PatientProfilePage extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;
    private ActionBar actionbar;
    String accountid;

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListHeader;
    HashMap<String, List<InfoClass>> expandableListDetail;
    RequestQueue requestQueue;
    String URL_EMAIL, URL_PROFILE, URL_EMERGENCY, URL_INSURANCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_profile_page);
        requestQueue = Volley.newRequestQueue(this);
        SetNavigation();
        Mapping();
    }

    public void SetNavigation()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbarprofile_p);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayoutprofile_p);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        setSupportActionBar(toolbar);
        actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        Intent intent = getIntent();
        accountid = intent.getStringExtra("AccountID");
        Toast.makeText(PatientProfilePage.this, accountid, Toast.LENGTH_SHORT).show();

        final NavigationView navigationView = (NavigationView) findViewById(R.id.navigationprofile_p);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.homepatient)
                {
                    Intent intent = new Intent(PatientProfilePage.this, PatientHomePage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.myrecord)
                {
                    Intent intent = new Intent(PatientProfilePage.this, PatientMyRecordPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.notificationpatient)
                {
                    Intent intent = new Intent(PatientProfilePage.this, PatientNotificationPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.accountpatient)
                {
                    Intent intent = new Intent(PatientProfilePage.this, PatientAccountPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.profilepatient)
                {
                    Intent intent = new Intent(PatientProfilePage.this, PatientProfilePage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.settingpatient)
                {
                    Intent intent = new Intent(PatientProfilePage.this, PatientSettingPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.supportpatient)
                {
                    Intent intent = new Intent(PatientProfilePage.this, PatientSupportPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.logoutpatient)
                {
                    Intent intent = new Intent(PatientProfilePage.this, MainActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });
    }

    public void Mapping()
    {
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView_p);
        dataPumpGetData();
        expandableListHeader = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(PatientProfilePage.this, expandableListHeader, expandableListDetail, accountid);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(PatientProfilePage.this,
                        expandableListHeader.get(groupPosition) + "Child Click",
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(PatientProfilePage.this,
                        expandableListHeader.get(groupPosition) + "Group Click",
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(PatientProfilePage.this,
                        expandableListHeader.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(PatientProfilePage.this,
                        expandableListHeader.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        PatientProfilePage.this,
                        expandableListHeader.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });
    }

    private void dataPumpGetData() {
        final List<String> listHeader = new ArrayList<String>();
        listHeader.add("About");
        listHeader.add("Contact Infomation");
        listHeader.add("Emergency contact");
        listHeader.add("Insurance");

        expandableListDetail= new HashMap<>();
        final List<InfoClass> listInfoAbout = new ArrayList<>();
        final List<InfoClass> listInfoContact = new ArrayList<>();
        final List<InfoClass> listInfoEmergency = new ArrayList<>();
        final List<InfoClass> listInfoInsurance = new ArrayList<>();

        URL_EMAIL = Utils.GET_EMAIL_PATIENT + accountid;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_EMAIL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) { ;
                listInfoContact.add(new InfoClass("Email",response));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);

        URL_PROFILE = Utils.GET_PATIENTPROFILE + accountid;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL_PROFILE, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    listInfoAbout.add(new InfoClass("Name",response.getString("PatientName")));
                    listInfoAbout.add(new InfoClass("Identify Card",response.getString("IdentifyCard")));
                    listInfoAbout.add(new InfoClass("Day of Birth",response.getString("DayOfBirth")));
                    listInfoAbout.add(new InfoClass("Gender",response.getString("Gender")));
                    listInfoContact.add(new InfoClass("Phone Number", response.getString("PhoneNumber")));
                    listInfoContact.add(new InfoClass("Address", response.getString("Address")));
                    listInfoContact.add(new InfoClass("District", response.getString("District")));
                    listInfoContact.add(new InfoClass("City/Province", response.getString("City")));
                    listInfoContact.add(new InfoClass("Country/Region", response.getString("Country")));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(jsonObjectRequest);


        URL_EMERGENCY = Utils.GET_PATIENTEMERGENCY + accountid;
        JsonObjectRequest jsonObjectRequest1 = new JsonObjectRequest(Request.Method.GET, URL_EMERGENCY, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    listInfoEmergency.add(new InfoClass("Name",response.getString("EmergencyContactName")));
                    listInfoEmergency.add(new InfoClass("Phone Number", response.getString("EmergencyPhoneNumber")));
                    listInfoEmergency.add(new InfoClass("Relationship", response.getString("RelationShip")));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(jsonObjectRequest1);


        URL_INSURANCE = Utils.GET_PATIENTINSURANCE + accountid;
        JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.GET, URL_INSURANCE, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    listInfoInsurance.add(new InfoClass("Health Insurance Card Code",response.getString("HealthInsuranceCardCode")));
                    listInfoInsurance.add(new InfoClass("Hospital Register",response.getString("HospitalRegister")));
                    listInfoInsurance.add(new InfoClass("Health Insurance MFD",response.getString("HealthInsuranceMFD")));
                    listInfoInsurance.add(new InfoClass("Health Insurance EXP",response.getString("HealthInsuranceEXP")));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(jsonObjectRequest2);






        expandableListDetail.put(listHeader.get(0), listInfoAbout);
        expandableListDetail.put(listHeader.get(1), listInfoContact);
        expandableListDetail.put(listHeader.get(2), listInfoEmergency);
        expandableListDetail.put(listHeader.get(3), listInfoInsurance);
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
