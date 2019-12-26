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
import com.example.sdkfacebook.mainactivity.PageAdapterSetting;
import com.google.android.material.tabs.TabLayout;

public class doctor_main_activity extends AppCompatActivity{
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_main_activity);

        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("My Patient"));
        tabLayout.addTab(tabLayout.newTab().setText("My Infomation"));
        tabLayout.addTab(tabLayout.newTab().setText("Accout"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pagerdoctorpage);
        PageAdapterSetting pageAdapterSetting=new PageAdapterSetting(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapterSetting);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
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
