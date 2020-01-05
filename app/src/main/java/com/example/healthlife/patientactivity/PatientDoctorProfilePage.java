package com.example.healthlife.patientactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.healthlife.R;
import com.example.healthlife.Utils;

import org.json.JSONException;
import org.json.JSONObject;

public class PatientDoctorProfilePage extends AppCompatActivity {

    String accountemployeeid;
    RequestQueue requestQueue;
    TextView txtEmployeeID, txtEmployeeName, txtGender, txtBirthday, txtDegree, txtSpeciality, txtMedicalSchool, txtYearDegree, txtLicenseCountry, txtLicenseEXP;
    String URL_DOCTORPROFILE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_doctor_profile_page);
        requestQueue = Volley.newRequestQueue(this);
        Mapping();
    }

    public void Mapping()
    {
        txtEmployeeID = (TextView) findViewById(R.id.textViewEmployeeIDDoctorProfile);
        txtEmployeeName = (TextView) findViewById(R.id.textViewEmployeeNameDoctorProfile);
        txtGender = (TextView) findViewById(R.id.textViewGenderDoctorProfile);
        txtBirthday = (TextView) findViewById(R.id.textViewBirthdayDoctorProfile);
        txtDegree = (TextView) findViewById(R.id.textViewDegreeDoctorProfile);
        txtSpeciality = (TextView) findViewById(R.id.textViewSpecialityDoctorProfile);
        txtMedicalSchool = (TextView) findViewById(R.id.textViewMedicalSchoolDoctorProfile);
        txtYearDegree = (TextView) findViewById(R.id.textViewYearDegreeDoctorProfile);
        txtLicenseCountry = (TextView) findViewById(R.id.textViewLicenseCountryDoctorProfile);
        txtLicenseEXP = (TextView) findViewById(R.id.textViewLicenseEXPDoctorProfile);
        Intent intent = getIntent();
        accountemployeeid = intent.getStringExtra("UserID");
        Toast.makeText(PatientDoctorProfilePage.this, accountemployeeid, Toast.LENGTH_SHORT).show();

        ViewHealthRecord();
    }

    public void ViewHealthRecord()
    {
        URL_DOCTORPROFILE = Utils.GET_DOCTOR_PROFILE + accountemployeeid;


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL_DOCTORPROFILE, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    txtEmployeeID.setText(response.getString("EmployeeID"));
                    txtEmployeeName.setText(response.getString("EmployeeName"));
                    txtGender.setText(response.getString("Gender"));
                    txtBirthday.setText(response.getString("DayOfBirth"));
                    txtDegree.setText(response.getString("Degree"));
                    txtSpeciality.setText(response.getString("Speciality"));
                    txtMedicalSchool.setText(response.getString("MedicalSchool"));
                    txtYearDegree.setText(response.getString("YearOfDegree"));
                    txtLicenseCountry.setText(response.getString("LicenseCountry"));
                    txtLicenseEXP.setText(response.getString("LicenseEXP"));

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
    }
}
