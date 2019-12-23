package com.example.sdkfacebook.tab_my_record;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.sdkfacebook.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class TabMyRecordPage extends Fragment {

    View row;
    EditText aboutbirday;
    Calendar C;
    DatePickerDialog dpd;
//    ExpandableListView expandableListView;
//    ExpandableListAdapter expandableListAdapter;
//    List<String> expandableListTitle;
//    HashMap<String, List<String>> expandableListDetail;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        row=inflater.inflate(R.layout.activity_tab_my_record_page, container, false);

        aboutbirday=row.findViewById(R.id.aboutBirthday);
        aboutbirday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                C = Calendar.getInstance();
                int day = C.get(Calendar.DAY_OF_MONTH);
                int month = C.get(Calendar.MONTH);
                int year = C.get(Calendar.YEAR);

                dpd = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {
                        aboutbirday.setText(mYear +"-"+ (mMonth+1)+"-"+mDay);
                    }
                },day, month, year);
                dpd.show();
            }
        });

        Spinner spinnerlanguage = row.findViewById(R.id.spinner_language);
        ArrayAdapter<String> adapterlanguage = new ArrayAdapter<String >(getActivity(), android.R.layout.simple_list_item_1 ,getResources().getStringArray(R.array.language));
        adapterlanguage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerlanguage.setAdapter(adapterlanguage);

        Spinner spinnersex = row.findViewById(R.id.spinner_sex);
        ArrayAdapter<String> adaptersex = new ArrayAdapter<String >(getActivity(), android.R.layout.simple_list_item_1 ,getResources().getStringArray(R.array.sex));
        adaptersex.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnersex.setAdapter(adaptersex);

//        expandableListView = row.findViewById(R.id.expandableListView);
//        expandableListDetail = ExpandableListDataPump.getData();
//        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
//        expandableListAdapter = new CustomExpandableListAdapter(getActivity(), expandableListTitle, expandableListDetail);
//        expandableListView.setAdapter(expandableListAdapter);
//        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getActivity(),
//                        expandableListTitle.get(groupPosition) + " List Expanded.",
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
//
//            @Override
//            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getActivity(),
//                        expandableListTitle.get(groupPosition) + " List Collapsed.",
//                        Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v,
//                                        int groupPosition, int childPosition, long id) {
//                Toast.makeText(
//                        getActivity(),
//                        expandableListTitle.get(groupPosition)
//                                + " -> "
//                                + expandableListDetail.get(
//                                expandableListTitle.get(groupPosition)).get(
//                                childPosition), Toast.LENGTH_SHORT
//                ).show();
//                return false;
//            }
//        });
//
        return row;
    }
}

