package com.example.sdkfacebook.mainactivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.sdkfacebook.changeinformation.About_healthlife_activity;
import com.example.sdkfacebook.changeinformation.change_email_activity;
import com.example.sdkfacebook.changeinformation.change_password_activity;

public class PageAdapterSetting extends FragmentStatePagerAdapter {
    int counttab;

    public PageAdapterSetting(@NonNull FragmentManager fm, int behavior) {
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
                return "Your Email";
            case 1:return "Your Password";
            case 2:return "About HealthLife";
    }
        return super.getPageTitle(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
            change_email_activity change=new change_email_activity();
            return change;

            case  1:                 change_password_activity change1=new change_password_activity();
            return change1;

            case 2:
                About_healthlife_activity change3=new About_healthlife_activity();
                return change3;



            default:
                return null;
    }
}}
