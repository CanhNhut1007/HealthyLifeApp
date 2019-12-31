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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.healthlife.R;
import com.example.healthlife.Utils;
import com.example.healthlife.recyclerview.DoctorHealthRecord;
import com.example.healthlife.recyclerview.DoctorHealthRecordAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DoctorPatientRecordPage extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<DoctorHealthRecord> arrayList;
    DoctorHealthRecordAdapter doctorhealthRecordAdapter;
    RequestQueue requestQueue;
    String accountpatientid;
    String accountemployeeid;
    TextView txtPatientName;
    String URL_GETNAME;
    ImageButton imageButtonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_patient_record_page);
        requestQueue = Volley.newRequestQueue(this);
        Mapping();
        ViewHealthRecord();
        AddHealthRecord();

    }

    public void Mapping()
    {
        txtPatientName = (TextView) findViewById(R.id.txtPatientNameDPHR);
        imageButtonAdd = (ImageButton) findViewById(R.id.imageButtonAddRecord);
        Intent intent = getIntent();
        accountpatientid = intent.getStringExtra("AccountID");
        accountemployeeid = intent.getStringExtra("AccountEmployeeID");//AccountID of Doctor
        //Toast.makeText(DoctorPatientRecordPage.this, "ID Doctor: "+accountemployeeid + "|| ID Patient: " + accountpatientid, Toast.LENGTH_SHORT).show();
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
    }

    public void ViewHealthRecord() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewListPatientRecord);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        arrayList = new ArrayList<>();

        String URL_HEALTHRECORD = Utils.GET_LIST_HEALTHRECORD + accountpatientid;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_HEALTHRECORD, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject doctorhealthrecord = array.getJSONObject(i);
                        arrayList.add(new DoctorHealthRecord(accountemployeeid, accountpatientid, doctorhealthrecord.getString("HealthRecordID"), doctorhealthrecord.getString("EmployeeID"), doctorhealthrecord.getString("HealthRecorDateTime"), R.drawable.ic_assignment_black_24dp));
                    }
                    doctorhealthRecordAdapter = new DoctorHealthRecordAdapter(arrayList, getApplicationContext());
                    recyclerView.setAdapter(doctorhealthRecordAdapter);
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

    public void AddHealthRecord()
    {
        imageButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(DoctorPatientRecordPage.this);
                View mView = getLayoutInflater().inflate(R.layout.add_health_record, null);
                final EditText mDate = (EditText) mView.findViewById(R.id.edtDateAdd);
                final EditText mDescription = (EditText) mView.findViewById(R.id.edtDescriptionAdd);
                final EditText mDiagnosis = (EditText) mView.findViewById(R.id.edtDiagnosisAdd);
                final EditText mResult = (EditText) mView.findViewById(R.id.edtResultAdd);
                final EditText mNotes = (EditText) mView.findViewById(R.id.edtNotesAdd);
                final EditText mPatientView = (EditText) mView.findViewById(R.id.edtPatientViewAdd);
                final EditText mTotalFee = (EditText) mView.findViewById(R.id.edtTotalFeeAdd);
                Button mSave = (Button) mView.findViewById(R.id.btnSaveAddRecord);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                mSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Verification(mDate.getText().toString(), mDescription.getText().toString(), mDiagnosis.getText().toString(), mResult.getText().toString(), mNotes.getText().toString(), mPatientView.getText().toString(), mTotalFee.getText().toString());
                        dialog.dismiss();
                    }
                });
            }

            private void Verification(final String mDate, final String mDescription, final String mDiagnosis, final String mResult, final String mNotes, final String mPatientView, final String mTotalFee ) {

                String URL = Utils.ADD_HEALTHRECORD + accountemployeeid + "/" + accountpatientid;

                StringRequest postRequest = new StringRequest(Request.Method.POST, URL,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response) {
                                // response
                                Toast.makeText(DoctorPatientRecordPage.this, response, Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // error
                                Toast.makeText(DoctorPatientRecordPage.this, "Error! Please again!", Toast.LENGTH_SHORT).show();
                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String>  params = new HashMap<String, String>();
                        params.put("HealthRecorDateTime", mDate);
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
