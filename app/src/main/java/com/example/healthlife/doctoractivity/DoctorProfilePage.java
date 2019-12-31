package com.example.healthlife.doctoractivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.healthlife.MainActivity;
import com.example.healthlife.R;
import com.example.healthlife.Utils;
import com.example.healthlife.listview.DoctorCustomExpandableListAdapter;
import com.example.healthlife.listview.InfoClass;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorProfilePage extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;
    private ActionBar actionbar;
    RequestQueue requestQueue;
    ImageButton imageButtonEditAbout, imageButtonEditEdu, imageButtonEditLicense;
    String accountid;

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListHeader;
    HashMap<String, List<InfoClass>> expandableListDetail;
    String URL_EMAIL, URL_PROFILE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profile_page);
        requestQueue = Volley.newRequestQueue(this);
        SetNavigation();
        Mapping();
        //EditAbout();
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
        Intent intent = getIntent();
        accountid = intent.getStringExtra("AccountID");


        final NavigationView navigationView = (NavigationView) findViewById(R.id.navigationprofile);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if (id == R.id.homedoctor)
                {
                    Intent intent = new Intent(DoctorProfilePage.this, DoctorHomePage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.listpatient)
                {
                    Intent intent = new Intent(DoctorProfilePage.this, DoctorListPatientPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.notificationdoctor)
                {
                    Intent intent = new Intent(DoctorProfilePage.this, DoctorNotificationPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.accountdoctor)
                {
                    Intent intent = new Intent(DoctorProfilePage.this, DoctorAccountPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.profiledoctor)
                {
                    Intent intent = new Intent(DoctorProfilePage.this, DoctorProfilePage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.settingdoctor)
                {
                    Intent intent = new Intent(DoctorProfilePage.this, DoctorSettingPage.class);
                    intent.putExtra("AccountID", accountid);
                    startActivity(intent);
                }
                else if (id == R.id.supportdoctor)
                {
                    Intent intent = new Intent(DoctorProfilePage.this, DoctorSupportPage.class);
                    intent.putExtra("AccountID", accountid);
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

    public void Mapping()
    {
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        dataPumpGetData();
        expandableListHeader = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new DoctorCustomExpandableListAdapter(DoctorProfilePage.this, expandableListHeader, expandableListDetail, accountid);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(DoctorProfilePage.this,
                        expandableListHeader.get(groupPosition) + "Child Click",
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(DoctorProfilePage.this,
                        expandableListHeader.get(groupPosition) + "Group Click",
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(DoctorProfilePage.this,
                        expandableListHeader.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(DoctorProfilePage.this,
                        expandableListHeader.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        DoctorProfilePage.this,
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
        listHeader.add("Educational Background");
        listHeader.add("License");


        expandableListDetail= new HashMap<>();
        final List<InfoClass> listInfoAbout = new ArrayList<>();
        final List<InfoClass> listInfoEducational = new ArrayList<>();
        final List<InfoClass> listInfoLicense = new ArrayList<>();


        URL_PROFILE = Utils.GET_DOCTORPROFILE + accountid;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL_PROFILE, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    listInfoAbout.add(new InfoClass("Employee Name",response.getString("EmployeeName")));
                    listInfoAbout.add(new InfoClass("Date of Birth",response.getString("DayOfBirth")));
                    listInfoAbout.add(new InfoClass("Identify Card",response.getString("IdentifyCard")));
                    listInfoAbout.add(new InfoClass("Gender",response.getString("Gender")));
                    listInfoAbout.add(new InfoClass("Phone Number",response.getString("PhoneNumber")));
                    listInfoEducational.add(new InfoClass("Degree", response.getString("Degree")));
                    listInfoEducational.add(new InfoClass("Speciality", response.getString("Speciality")));
                    listInfoEducational.add(new InfoClass("Medical School", response.getString("MedicalSchool")));
                    listInfoEducational.add(new InfoClass("Year of Degree", response.getString("YearOfDegree")));
                    listInfoLicense.add(new InfoClass("License Number",response.getString("LicenseNumber")));
                    listInfoLicense.add(new InfoClass("License Contry", response.getString("LicenseCountry")));
                    listInfoLicense.add(new InfoClass("License EXP", response.getString("LicenseEXP")));
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


        expandableListDetail.put(listHeader.get(0), listInfoAbout);
        expandableListDetail.put(listHeader.get(1), listInfoEducational);
        expandableListDetail.put(listHeader.get(2), listInfoLicense);
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
                        dialog.dismiss();
                    }
                });
            }

            private void Verification(final String name, final String birthday, final String identify, final String gender, final String phone) {

                String URL = Utils.UPDATE_ABOUT_DOCTOR + accountid;

                StringRequest postRequest = new StringRequest(Request.Method.POST, URL,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response) {
                                // response
                                Toast.makeText(getApplication(), response, Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // error
                                Toast.makeText(DoctorProfilePage.this, error+". Loi roi", Toast.LENGTH_SHORT).show();
                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String>  params = new HashMap<String, String>();
                        params.put("Name", name);
                        params.put("Birthday", birthday);
                        params.put("IdentifyCard", identify);
                        params.put("Gender", gender);
                        params.put("Phone", phone);

                        return params;
                    }
                };
                requestQueue.add(postRequest);

                /*Map<String, String> params = new HashMap();
                params.put("Name", name);
                params.put("Birthday", birthday);
                params.put("IdentifyCard", identify);
                params.put("Gender", gender);
                params.put("Phone", phone);
                //Toast.makeText(DoctorProfilePage.this, name +":" +birthday+":"+identify+":"+gender+":"+phone, Toast.LENGTH_SHORT).show();

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


                requestQueue.add(jsonObjectRequest);*/


            }
        });
    }

    public void EditEducational()
    {
        imageButtonEditEdu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(DoctorProfilePage.this);
                View mView = getLayoutInflater().inflate(R.layout.doctor_profile_educational, null);
                final EditText mDegree = (EditText) mView.findViewById(R.id.edtDegreeUpEdu);
                final EditText mSpeciality = (EditText) mView.findViewById(R.id.edtSpecialityUpEdu);
                final EditText mSchool = (EditText) mView.findViewById(R.id.edtSchoolUpEdu);
                final EditText mYear = (EditText) mView.findViewById(R.id.edtYearUpEdu);
                Button mSave = (Button) mView.findViewById(R.id.btnDoctorProfileEdu);
                SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
                final String date = sdf.format(mYear.getText());


                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                mSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Verification(mDegree.getText().toString(), mSpeciality.getText().toString(), mSchool.getText().toString(), mYear.getText().toString());
                        dialog.dismiss();
                    }
                });
            }

            private void Verification(String degree, String speciality, String school, String year) {

                String URL = Utils.UPDATE_ABOUT_DOCTOR + accountid;

                Map<String, String> params = new HashMap();
                params.put("Degree", degree);
                params.put("Speciality", speciality);
                params.put("School", school);
                params.put("YearDegree", year);
                //Toast.makeText(DoctorProfilePage.this, name +":" +birthday+":"+identify+":"+gender+":"+phone, Toast.LENGTH_SHORT).show();

                JSONObject jsonObject = new JSONObject(params);
                Toast.makeText(DoctorProfilePage.this, jsonObject.toString(), Toast.LENGTH_SHORT).show();

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
