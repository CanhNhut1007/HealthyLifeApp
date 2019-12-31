package com.example.healthlife.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.healthlife.R;
import com.example.healthlife.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    EditText expandedListTVContent;
    String accountid;

    private List<String> expandableListHeader;
    private HashMap<String, List<InfoClass>> expandableListDetail;

    public CustomExpandableListAdapter(Context context, List<String> expandableListTitle,
                                       HashMap<String, List<InfoClass>> expandableListDetail, String account_id){
        this.context = context;
        this.expandableListHeader = expandableListTitle;
        this.expandableListDetail = expandableListDetail;
        this.accountid = account_id;
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.expandableListDetail.get(this.expandableListHeader.get(listPosition)).get(expandedListPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.list_item, parent, false);
        }
        TextView expandedListTVTitle = (TextView) convertView.findViewById(R.id.expandedListItemTitle);
        expandedListTVContent = (EditText) convertView.findViewById(R.id.expandedListItemContent);
        expandedListTVTitle.setText(((InfoClass) getChild(listPosition, expandedListPosition)).getTitle());
        expandedListTVContent.setText(((InfoClass) getChild(listPosition, expandedListPosition)).getContent());
        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return this.expandableListDetail.get(this.expandableListHeader.get(listPosition)).size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.expandableListHeader.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return this.expandableListHeader.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(final int listPosition, final boolean isExpanded, View convertView, final ViewGroup parent) {
        if(convertView==null){
            LayoutInflater layoutInflater=LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.list_group, parent, false);
        }
        final TextView listHeaderTV = (TextView) convertView.findViewById(R.id.listHeader);
        listHeaderTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // frag.expandandcollapse(isExpanded,groupPosition);
                if (isExpanded) ((ExpandableListView) parent).collapseGroup(listPosition);
                else ((ExpandableListView) parent).expandGroup(listPosition, true);
            }
        });
        final Button btnChange = convertView.findViewById(R.id.btn_Change);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                expandedListTVContent.setEnabled(true);

                if (listHeaderTV.getText().toString().equals("About"))
                {
                    final String URL = Utils.UPDATE_ABOUT_PATIENT + accountid;
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                    View mView = inflater.inflate(R.layout.patient_profile_about, null);
                    final EditText mName = (EditText) mView.findViewById(R.id.edtNameUp_p);
                    final EditText mBirthday = (EditText) mView.findViewById(R.id.edtBirthdayUp_p);
                    final EditText mIdentifyCard = (EditText) mView.findViewById(R.id.edtIdentifyCardUp_p);
                    final EditText mGender = (EditText) mView.findViewById(R.id.edtGenderUp_p);
                    Button mSave = (Button) mView.findViewById(R.id.btnPatientProfileAbout);


                    mBuilder.setView(mView);
                    final AlertDialog dialog = mBuilder.create();
                    dialog.show();
                    mSave.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            StringRequest postRequest = new StringRequest(Request.Method.POST, URL,
                                    new Response.Listener<String>()
                                    {
                                        @Override
                                        public void onResponse(String response) {
                                            // response
                                            Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
                                        }
                                    },
                                    new Response.ErrorListener()
                                    {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            // error
                                            Toast.makeText(context, "Error! Please again!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                            ) {
                                @Override
                                protected Map<String, String> getParams()
                                {
                                    Map<String, String>  params = new HashMap<String, String>();
                                    params.put("PatientName", mName.getText().toString());
                                    params.put("DayOfBirth", mBirthday.getText().toString());
                                    params.put("IdentifyCard", mIdentifyCard.getText().toString());
                                    params.put("Gender", mGender.getText().toString());

                                    return params;
                                }
                            };
                            RequestQueue requestQueue = Volley.newRequestQueue(context);
                            requestQueue.add(postRequest);
                            //Verification(mName.getText().toString(), mBirthday.getText().toString(), mIdentifyCard.getText().toString(), mGender.getText().toString(), mPhone.getText().toString());
                            dialog.dismiss();
                        }
                    });
                }
                else if (listHeaderTV.getText().toString().equals("Contact Infomation"))
                {
                    final String URL = Utils.UPDATE_CONTACT_PATIENT + accountid;
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                    View mView = inflater.inflate(R.layout.patient_profile_contact_information, null);
                    final EditText mPhone = (EditText) mView.findViewById(R.id.edtPhoneUp_p);
                    final EditText mAddress = (EditText) mView.findViewById(R.id.edtAddressUp_p);
                    final EditText mDistrict = (EditText) mView.findViewById(R.id.edtDistrictUp_p);
                    final EditText mCity = (EditText) mView.findViewById(R.id.edtCityUp_p);
                    final EditText mCountry = (EditText) mView.findViewById(R.id.edtCountryUp_p);
                    Button mSave = (Button) mView.findViewById(R.id.btnPatientProfileCon);


                    mBuilder.setView(mView);
                    final AlertDialog dialog = mBuilder.create();
                    dialog.show();
                    mSave.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            StringRequest postRequest = new StringRequest(Request.Method.POST, URL,
                                    new Response.Listener<String>()
                                    {
                                        @Override
                                        public void onResponse(String response) {
                                            // response
                                            Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
                                        }
                                    },
                                    new Response.ErrorListener()
                                    {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            // error
                                            Toast.makeText(context, "Error! Please again!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                            ) {
                                @Override
                                protected Map<String, String> getParams()
                                {
                                    Map<String, String>  params = new HashMap<String, String>();
                                    params.put("PhoneNumber", mPhone.getText().toString());
                                    params.put("Address", mAddress.getText().toString());
                                    params.put("District", mDistrict.getText().toString());
                                    params.put("City", mCity.getText().toString());
                                    params.put("Country", mCountry.getText().toString());

                                    return params;
                                }
                            };
                            RequestQueue requestQueue = Volley.newRequestQueue(context);
                            requestQueue.add(postRequest);
                            //Verification(mName.getText().toString(), mBirthday.getText().toString(), mIdentifyCard.getText().toString(), mGender.getText().toString(), mPhone.getText().toString());
                            dialog.dismiss();
                        }
                    });
                }
                else if (listHeaderTV.getText().toString().equals("Emergency contact"))
                {
                    final String URL = Utils.UPDATE_EMERGENCY_PATIENT + accountid;
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                    View mView = inflater.inflate(R.layout.patient_profile_emergency, null);
                    final EditText mName = (EditText) mView.findViewById(R.id.edtNameEmUp_p);
                    final EditText mPhone = (EditText) mView.findViewById(R.id.edtPhoneEmUp_p);
                    final EditText mRelationship = (EditText) mView.findViewById(R.id.edtRelationshipEmUp_p);
                    Button mSave = (Button) mView.findViewById(R.id.btnPatientProfileEmer);


                    mBuilder.setView(mView);
                    final AlertDialog dialog = mBuilder.create();
                    dialog.show();
                    mSave.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            StringRequest postRequest = new StringRequest(Request.Method.POST, URL,
                                    new Response.Listener<String>()
                                    {
                                        @Override
                                        public void onResponse(String response) {
                                            // response
                                            Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
                                        }
                                    },
                                    new Response.ErrorListener()
                                    {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            // error
                                            Toast.makeText(context, "Error! Please again!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                            ) {
                                @Override
                                protected Map<String, String> getParams()
                                {
                                    Map<String, String>  params = new HashMap<String, String>();
                                    params.put("EmergencyContactName", mName.getText().toString());
                                    params.put("EmergencyPhoneNumber", mPhone.getText().toString());
                                    params.put("RelationShip", mRelationship.getText().toString());

                                    return params;
                                }
                            };
                            RequestQueue requestQueue = Volley.newRequestQueue(context);
                            requestQueue.add(postRequest);
                            //Verification(mName.getText().toString(), mBirthday.getText().toString(), mIdentifyCard.getText().toString(), mGender.getText().toString(), mPhone.getText().toString());
                            dialog.dismiss();
                        }
                    });
                }
                else if (listHeaderTV.getText().toString().equals("Insurance"))
                {
                    final String URL = Utils.UPDATE_INSURANCE_PATIENT + accountid;
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                    View mView = inflater.inflate(R.layout.patient_profile_insurance, null);
                    final EditText mCardCode = (EditText) mView.findViewById(R.id.edtInsuranceCordUp_p);
                    final EditText mHospital = (EditText) mView.findViewById(R.id.edtHospitalRegisterUp_p);
                    final EditText mMFD = (EditText) mView.findViewById(R.id.edtMFDUp_p);
                    final EditText mEXP = (EditText) mView.findViewById(R.id.edtEXPUp_p);
                    Button mSave = (Button) mView.findViewById(R.id.btnPatientProfileIns);


                    mBuilder.setView(mView);
                    final AlertDialog dialog = mBuilder.create();
                    dialog.show();
                    mSave.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            StringRequest postRequest = new StringRequest(Request.Method.POST, URL,
                                    new Response.Listener<String>()
                                    {
                                        @Override
                                        public void onResponse(String response) {
                                            // response
                                            Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
                                        }
                                    },
                                    new Response.ErrorListener()
                                    {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            // error
                                            Toast.makeText(context, "Error! Please again!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                            ) {
                                @Override
                                protected Map<String, String> getParams()
                                {
                                    Map<String, String>  params = new HashMap<String, String>();
                                    params.put("HealthInsuranceCardCode", mCardCode.getText().toString());
                                    params.put("HospitalRegister", mHospital.getText().toString());
                                    params.put("HealthInsuranceMFD", mMFD.getText().toString());
                                    params.put("HealthInsuranceEXP", mEXP.getText().toString());

                                    return params;
                                }
                            };
                            RequestQueue requestQueue = Volley.newRequestQueue(context);
                            requestQueue.add(postRequest);
                            //Verification(mName.getText().toString(), mBirthday.getText().toString(), mIdentifyCard.getText().toString(), mGender.getText().toString(), mPhone.getText().toString());
                            dialog.dismiss();
                        }
                    });
                }

            }
        });
        listHeaderTV.setText(expandableListHeader.get(listPosition));
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expendedListPosition) {
        return true;
    }
}


