package com.example.sdkfacebook.changeinformation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sdkfacebook.R;

public class About_healthlife_activity extends Fragment {
    View row;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        row=inflater.inflate(R.layout.activity_about_healthlife_activity, container, false);
        return row;
    }
}
