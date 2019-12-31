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

public class DoctorCustomExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    EditText expandedListTVContent;
    String accountid;

    private List<String> expandableListHeader;
    private HashMap<String, List<InfoClass>> expandableListDetail;

    public DoctorCustomExpandableListAdapter(Context context, List<String> expandableListTitle,
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
                    final String URL = Utils.UPDATE_ABOUT_DOCTOR + accountid;
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                    View mView = inflater.inflate(R.layout.doctor_profile_about, null);
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
                                    params.put("Name", mName.getText().toString());
                                    params.put("Birthday", mBirthday.getText().toString());
                                    params.put("IdentifyCard", mIdentifyCard.getText().toString());
                                    params.put("Gender", mGender.getText().toString());
                                    params.put("Phone", mPhone.getText().toString());

                                    return params;
                                }
                            };
                            RequestQueue requestQueue = Volley.newRequestQueue(context);
                            requestQueue.add(postRequest);
                            //UpdateAbout(mName.getText().toString(), mBirthday.getText().toString(), mIdentifyCard.getText().toString(), mGender.getText().toString(), mPhone.getText().toString());
                            dialog.dismiss();
                        }
                    });
                }
                else if (listHeaderTV.getText().toString().equals("Educational Background"))
                {
                    final String URL = Utils.UPDATE_EDUCATIONAL_DOCTOR + accountid;
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                    View mView = inflater.inflate(R.layout.doctor_profile_educational, null);
                    final EditText mDegree = (EditText) mView.findViewById(R.id.edtDegreeUpEdu);
                    final EditText mSpeciality = (EditText) mView.findViewById(R.id.edtSpecialityUpEdu);
                    final EditText mSchool = (EditText) mView.findViewById(R.id.edtSchoolUpEdu);
                    final EditText mYear = (EditText) mView.findViewById(R.id.edtYearUpEdu);
                    Button mSave = (Button) mView.findViewById(R.id.btnDoctorProfileEdu);


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
                                    params.put("Degree", mDegree.getText().toString());
                                    params.put("Speciality", mSpeciality.getText().toString());
                                    params.put("MedicalSchool", mSchool.getText().toString());
                                    params.put("YearDegree", mYear.getText().toString());

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
                else if (listHeaderTV.getText().toString().equals("License"))
                {
                    final String URL = Utils.UPDATE_LISENCE_DOCTOR + accountid;
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                    View mView = inflater.inflate(R.layout.doctor_profile_license, null);
                    final EditText mNumber = (EditText) mView.findViewById(R.id.edtLisenceNumberUpLi);
                    final EditText mCountry = (EditText) mView.findViewById(R.id.edtCountryUpLi);
                    final EditText mLisenceEXP = (EditText) mView.findViewById(R.id.edtLisenceEXPUpLi);
                    Button mSave = (Button) mView.findViewById(R.id.btnDoctorProfileLi);


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
                                    params.put("LicenseNumber", mNumber.getText().toString());
                                    params.put("LicenseCountry", mCountry.getText().toString());
                                    params.put("LicenseEXP", mLisenceEXP.getText().toString());

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

    public void UpdateAbout(final String name, final String birthday, final String identify, final String gender, final String phone)
    {
        String URL = Utils.UPDATE_ABOUT_DOCTOR + accountid;


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
                params.put("Name", name);
                params.put("Birthday", birthday);
                params.put("IdentifyCard", identify);
                params.put("Gender", gender);
                params.put("Phone", phone);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(postRequest);

    }
}



