package com.example.sdkfacebook.mainactivity;

/*import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sdkfacebook.R;

public class TabHomePage extends Fragment {
    TextView txtname;

    AutoCompleteTextView txtsearch;
    Button btnSearch;
    TableLayout tableLayout;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        addControls();
        addEvents();
        return inflater.inflate(R.layout.activity_tab_home_page, container, false);
    }

    private void addEvents() {
    }

    private void addControls() {

        //txtname=getView().findViewById(R.id.txtname);
        //txtsearch=getView().findViewById(R.id.txtsearch);
        //btnSearch=getView().findViewById(R.id.btnsearch);
        //tableLayout=getView().findViewById(R.id.tabLayout);
    }


}*/

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sdkfacebook.MainActivity;
import com.example.sdkfacebook.R;

import static android.widget.TableRow.*;

public class TabHomePage extends Fragment {
    TableLayout tableLayout;
    LinearLayout lnresult;
    TextView txthi, txtSearch;
    Button btnSearch;
    View row;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        row=inflater.inflate(R.layout.activity_tab_home_page,null);
        tableLayout=row.findViewById(R.id.tablelayout);
        addControls();
        addEvents();

        return row;


    }

    private void addEvents() {
        showresult();
    }

    private void showresult() {
        btnSearch.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                lnresult.setVisibility(VISIBLE);
            }
        });
    }

    private void addControls() {
        txthi=row.findViewById(R.id.txthi);
        txtSearch=row.findViewById(R.id.txtsearch);
        lnresult=row.findViewById(R.id.result);
        btnSearch=row.findViewById(R.id.btnSearch);
    }
}
