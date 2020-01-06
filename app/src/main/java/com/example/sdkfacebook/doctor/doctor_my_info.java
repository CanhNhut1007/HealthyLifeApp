package com.example.sdkfacebook.doctor;

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

public class doctor_my_info extends Fragment {

    View row;
    EditText aboutbirday, edtSex;
    Calendar C;
    DatePickerDialog dpd;
    Button getSex;
//    ExpandableListView expandableListView;
//    ExpandableListAdapter expandableListAdapter;
//    List<String> expandableListTitle;
//    HashMap<String, List<String>> expandableListDetail;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        row=inflater.inflate(R.layout.activity_doctor_my_info, container, false);

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

        final Spinner spinnersex = row.findViewById(R.id.spinner_sex);
        ArrayAdapter<String> adaptersex = new ArrayAdapter<String >(getActivity(), android.R.layout.simple_list_item_1 ,getResources().getStringArray(R.array.sex));
        adaptersex.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnersex.setAdapter(adaptersex);

        getSex = row.findViewById(R.id.getsex);
        edtSex = row.findViewById(R.id.edtsex);

        getSex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text =spinnersex.getSelectedItem().toString();
                edtSex.setText(text);
            }
        });

        return row;
    }
}


