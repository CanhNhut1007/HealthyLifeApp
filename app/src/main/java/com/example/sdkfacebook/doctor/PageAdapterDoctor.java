package com.example.sdkfacebook.doctor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.sdkfacebook.doctor.doctor_home_page;
import com.example.sdkfacebook.doctor.doctor_my_patient;


public class PageAdapterDoctor extends FragmentStatePagerAdapter {
    int counttab;

    public PageAdapterDoctor(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.counttab=behavior;
    }

    @Override
    public int getCount() {
        return counttab;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Home";
            case 1:return "My Patient";
            case 2:return "My Infomation";
            case 3:return "Accout";
        }
        return super.getPageTitle(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                doctor_home_page doctorHomePage = new doctor_home_page();
                return doctorHomePage;


            case  1:
                doctor_my_patient doctorMyPatient=new doctor_my_patient();
                return doctorMyPatient;


            case 2:
                doctor_my_info doctorMyInfo=new doctor_my_info();
                return doctorMyInfo;

            case 3:
                doctor_accout doctorAccout=new doctor_accout();
                return doctorAccout;

            default:
                return null;
        }
    }}
