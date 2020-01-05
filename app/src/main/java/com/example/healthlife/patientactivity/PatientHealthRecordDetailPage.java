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

public class PatientHealthRecordDetailPage extends AppCompatActivity {

    String healthrecordid;
    RequestQueue requestQueue;
    TextView txtHealthRecordID, txtDate, txtEmployeeID, txtDescription, txtDiagnosis, txtResult, txtNotes, txtTotalFee;
    String URL_GETHEALTHRECORD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_health_record_detail_page);
        requestQueue = Volley.newRequestQueue(this);
        Mapping();
    }

    public void Mapping()
    {
        txtHealthRecordID = (TextView) findViewById(R.id.textViewHealthRecordIDHRDe_p);
        txtDate = (TextView) findViewById(R.id.textViewDateHRDe_p);
        txtEmployeeID = (TextView) findViewById(R.id.textViewEmployeeIDHRDe_p);
        txtDescription = (TextView) findViewById(R.id.textViewDescriptionHRDe_p);
        txtDiagnosis = (TextView) findViewById(R.id.textViewDiagnosisHRDe_p);
        txtResult = (TextView) findViewById(R.id.textViewResultHRDe_p);
        txtNotes = (TextView) findViewById(R.id.textViewNotesHRDe_p);
        txtTotalFee = (TextView) findViewById(R.id.textViewTotalFeeHRDe_p);
        Intent intent = getIntent();
        healthrecordid = intent.getStringExtra("HealthRecordID");
        Toast.makeText(PatientHealthRecordDetailPage.this, healthrecordid, Toast.LENGTH_SHORT).show();

        ViewHealthRecord();
    }

    public void ViewHealthRecord()
    {
        URL_GETHEALTHRECORD = Utils.GET_HEALTHRECORD_DETAIL + healthrecordid;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL_GETHEALTHRECORD, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    txtHealthRecordID.setText(response.getString("HealthRecordID"));
                    txtDate.setText(response.getString("HealthRecorDateTime"));
                    txtEmployeeID.setText(response.getString("EmployeeID"));
                    txtDescription.setText(response.getString("Description"));
                    txtDiagnosis.setText(response.getString("Diagnosis"));
                    txtResult.setText(response.getString("Result"));
                    txtNotes.setText(response.getString("Notes"));
                    txtTotalFee.setText(response.getString("TotalFee"));

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
