package com.example.healthlife.doctoractivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.healthlife.R;
import com.example.healthlife.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DoctorHealthRecordPage extends AppCompatActivity {

    String accountemployeeid;
    String accountpatientid;
    String healthrecordid;

    RequestQueue requestQueue;
    TextView txtHealthRecordID, txtDate, txtEmployeeID, txtDescription, txtDiagnosis, txtResult, txtNotes, txtPatientView, txtTotalFee;
    TextView txtPatientName;
    String URL_GETNAME, URL_GETEMPLOYEEID, URL_GETHEALTHRECORD;
    ImageButton imageButtonUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_health_record_page);
        requestQueue = Volley.newRequestQueue(this);
         Mapping();
         UpdateHealthRecord();
    }

    public void Mapping()
    {
        txtPatientName = (TextView) findViewById(R.id.txtPatientNameHRDe);
        txtHealthRecordID = (TextView) findViewById(R.id.textViewHealthRecordIDHRDe);
        txtDate = (TextView) findViewById(R.id.textViewDateHRDe);
        txtEmployeeID = (TextView) findViewById(R.id.textViewEmployeeIDHRDe);
        txtDescription = (TextView) findViewById(R.id.textViewDescriptionHRDe);
        txtDiagnosis = (TextView) findViewById(R.id.textViewDiagnosisHRDe);
        txtResult = (TextView) findViewById(R.id.textViewResultHRDe);
        txtNotes = (TextView) findViewById(R.id.textViewNotesHRDe);
        txtPatientView = (TextView) findViewById(R.id.textViewPatientViewHRDe);
        txtTotalFee = (TextView) findViewById(R.id.textViewTotalFeeHRDe);
        imageButtonUpdate = (ImageButton) findViewById(R.id.imageButtonEditHealthRecord);
        Intent intent = getIntent();
        accountemployeeid = intent.getStringExtra("AccountEmployeeID");
        accountpatientid = intent.getStringExtra("AccountPatientID");
        healthrecordid = intent.getStringExtra("HealthRecordID");
        //Toast.makeText(DoctorHealthRecordPage.this, "ID Doctor: "+accountemployeeid + "|| ID Patient: " + accountpatientid + "|| HealthRecord ID: " + healthrecordid,Toast.LENGTH_SHORT).show();
        URL_GETNAME = Utils.GET_PATIENT_NAME + accountpatientid;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_GETNAME, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) { ;
                txtPatientName.setText("Patient: " + response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);

        ViewHealthRecord();
        VisibleButton();
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
                    txtPatientView.setText(response.getString("PatientView"));
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

    public void VisibleButton()
    {
        URL_GETEMPLOYEEID = Utils.GET_EMPLOYEEID + healthrecordid;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_GETEMPLOYEEID, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) { ;
                if (txtEmployeeID.getText().toString().equals(response))
                {
                    imageButtonUpdate.setVisibility(View.VISIBLE);
                    Toast.makeText(DoctorHealthRecordPage.this, "Hide Button Success!", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }

    public void UpdateHealthRecord()
    {
        imageButtonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(DoctorHealthRecordPage.this);
                View mView = getLayoutInflater().inflate(R.layout.edit_health_record, null);
                final EditText mDescription = (EditText) mView.findViewById(R.id.edtDescriptionEdit);
                final EditText mDiagnosis = (EditText) mView.findViewById(R.id.edtDiagnosisEdit);
                final EditText mResult = (EditText) mView.findViewById(R.id.edtResultEdit);
                final EditText mNotes = (EditText) mView.findViewById(R.id.edtNotesEdit);
                final EditText mPatientView = (EditText) mView.findViewById(R.id.edtPatientViewEdit);
                final EditText mTotalFee = (EditText) mView.findViewById(R.id.edtTotalFeeEdit);
                Button mSave = (Button) mView.findViewById(R.id.btnSaveAddRecord);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                mSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Verification(mDescription.getText().toString(), mDiagnosis.getText().toString(), mResult.getText().toString(), mNotes.getText().toString(), mPatientView.getText().toString(), mTotalFee.getText().toString());
                        dialog.dismiss();
                    }
                });
            }

            private void Verification(final String mDescription, final String mDiagnosis, final String mResult, final String mNotes, final String mPatientView, final String mTotalFee ) {

                String URL = Utils.EDIT_HEALTHRECORD + healthrecordid;

                StringRequest postRequest = new StringRequest(Request.Method.POST, URL,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response) {
                                // response
                                Toast.makeText(DoctorHealthRecordPage.this, response, Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // error
                                Toast.makeText(DoctorHealthRecordPage.this, "Error! Please again!", Toast.LENGTH_SHORT).show();
                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String>  params = new HashMap<String, String>();
                        params.put("Description", mDescription);
                        params.put("Diagnosis", mDiagnosis);
                        params.put("Result", mResult);
                        params.put("Notes", mNotes);
                        params.put("PatientView", mPatientView);
                        params.put("TotalFee", mTotalFee);

                        return params;
                    }
                };
                requestQueue.add(postRequest);
            }
        });
    }
}
