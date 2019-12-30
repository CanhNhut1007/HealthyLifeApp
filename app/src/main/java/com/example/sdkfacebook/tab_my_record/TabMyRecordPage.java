package com.example.sdkfacebook.tab_my_record;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    Button btnChange;
    EditText aboutbirday;
    Calendar C;
    DatePickerDialog dpd;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListHeader;
    HashMap<String, List<Info_class>> expandableListDetail;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        row=inflater.inflate(R.layout.activity_tab_my_record_page, container, false);

        expandableListView = row.findViewById(R.id.expandableListView);
        dataPumpGetData();
        expandableListHeader = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(getActivity(), expandableListHeader, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        btnChange = row.findViewById(R.id.btn_Change);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getActivity(),
                        expandableListHeader.get(groupPosition) + "Child Click",
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(getActivity(),
                        expandableListHeader.get(groupPosition) + "Group Click",
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getActivity(),
                        expandableListHeader.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getActivity(),
                        expandableListHeader.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getActivity(),
                        expandableListHeader.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });

        return row;
    }

    private void dataPumpGetData() {
        final List<String> listHeader = new ArrayList<String>();
        listHeader.add("About");
        listHeader.add("Contact");
        listHeader.add("Metrics");

        expandableListDetail= new HashMap<>();
        List<Info_class> listInfoAbout = new ArrayList<>();
        listInfoAbout.add(new Info_class("Name","Quyen"));
        listInfoAbout.add(new Info_class("Birthday","14/05"));
        listInfoAbout.add(new Info_class("Sex","Female"));
        listInfoAbout.add(new Info_class("Indentify card","1234"));

        List<Info_class> listInfoContact = new ArrayList<>();
        listInfoContact.add(new Info_class("Email","quyen@gmail.com"));
        listInfoContact.add(new Info_class("Phone Number", "123456789"));
        listInfoContact.add(new Info_class("Address", "UIT"));

        List<Info_class> listInfoMetric = new ArrayList<>();
        listInfoMetric.add(new Info_class("Height","160cm"));
        listInfoMetric.add(new Info_class("Weight", "123456789"));
        listInfoMetric.add(new Info_class("Address", "UIT"));
        listInfoMetric.add(new Info_class("Height","160cm"));
        listInfoMetric.add(new Info_class("Weight", "123456789"));
        listInfoMetric.add(new Info_class("Address", "UIT"));

        expandableListDetail.put(listHeader.get(0), listInfoAbout);
        expandableListDetail.put(listHeader.get(1), listInfoContact);
        expandableListDetail.put(listHeader.get(2), listInfoMetric);
    }


}

