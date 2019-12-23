package com.example.sdkfacebook.changeinformation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.sdkfacebook.R;

public class change_email_activity extends Fragment {
    View view;
    ImageButton imageButtonBack;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.activity_change_email_activity,container,false);

        imageButtonBack = view.findViewById(R.id.imageButtonBackEmail);
        BackMainPage();
        return view;
    }

    private void BackMainPage() {
        imageButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }
    @Nullable
    @Override
    public View getView() {
        return super.getView();
    }

    public change_email_activity() {
    }

}
