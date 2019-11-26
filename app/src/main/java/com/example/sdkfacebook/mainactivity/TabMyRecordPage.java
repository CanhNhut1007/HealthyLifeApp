package com.example.sdkfacebook.mainactivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sdkfacebook.R;

public class TabMyRecordPage extends Fragment {

    String arr[]={
            "Hàng điện tử",
            "Hàng hóa chất",
            "Hàng gia dụng"};

    TextView selection;
    Spinner spin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tab_my_record_page, container, false);
        String arr[]={
                "Hàng điện tử",
                "Hàng hóa chất",
                "Hàng gia dụng"};

        TextView selection = (TextView) view.findViewById(R.id.selection);
        Spinner spin = (Spinner) view.findViewById(R.id.spinner1);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, arr);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spin.setAdapter(adapter);
        //spin.setOnItemSelectedListener(new MyProcessEvent());

        return view;
    }

    private class MyProcessEvent implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            selection.setText(arr[position]);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            selection.setText("");
        }
    }

}

