package com.example.sdkfacebook.changeinformation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.sdkfacebook.R;

public class change_password_activity extends Fragment {
    View row;
    ImageButton imageButtonBack;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        row=inflater.inflate(R.layout.activity_change_password_activity,container,false);

        imageButtonBack = row.findViewById(R.id.imageButtonBackPass);
        imageButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        return row;
    }
}
