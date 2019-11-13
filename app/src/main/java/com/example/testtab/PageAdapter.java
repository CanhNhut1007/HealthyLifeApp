package com.example.testtab;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {
    int counttab;

    public PageAdapter(FragmentManager fm, int counttab) {
        super(fm);
        this.counttab = counttab;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                TabHomePage tabHomePage = new TabHomePage();
                return tabHomePage;
            case 1:
                TabCarePage tabCarePage = new TabCarePage();
                return tabCarePage;
            case 2:
                TabMyRecordPage tabMyRecordPage = new TabMyRecordPage();
                return tabMyRecordPage;
            case 3:
                TabAccountPage tabAccountPage = new TabAccountPage();
                return tabAccountPage;
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Home";
            case 1:
                return "Care";
            case 2:
                return "My Record";
            case 3:
                return "Account";
            default:
                return "";
        }
    }

    @Override
    public int getCount() {
        return counttab;
    }
}

