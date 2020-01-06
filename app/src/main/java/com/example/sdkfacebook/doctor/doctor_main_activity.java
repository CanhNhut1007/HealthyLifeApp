package com.example.sdkfacebook.doctor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sdkfacebook.R;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.Toolbar;

import com.example.sdkfacebook.R;
import com.example.sdkfacebook.mainactivity.PageAdapter;
import com.example.sdkfacebook.mainactivity.PageAdapterSetting;
import com.google.android.material.tabs.TabLayout;

public class doctor_main_activity extends AppCompatActivity{
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_main_activity);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayoutdoctor);
        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("My Patient"));
        tabLayout.addTab(tabLayout.newTab().setText("My Information"));
        tabLayout.addTab(tabLayout.newTab().setText("Account"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPagerDoctor = (ViewPager) findViewById(R.id.pagerdoctorpage);
        PageAdapterDoctor pageAdapterDoctor = new PageAdapterDoctor(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPagerDoctor.setAdapter(pageAdapterDoctor);
        viewPagerDoctor.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerDoctor.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
