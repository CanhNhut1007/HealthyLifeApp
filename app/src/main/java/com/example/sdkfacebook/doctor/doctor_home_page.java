package com.example.sdkfacebook.doctor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sdkfacebook.R;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.Toolbar;

import com.example.sdkfacebook.R;
import com.example.sdkfacebook.mainactivity.PageAdapterSetting;
import com.google.android.material.tabs.TabLayout;

public class doctor_home_page extends Fragment {
    View row;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        row=inflater.inflate(R.layout.activity_doctor_home_page,null);
        return row;
    }
}


