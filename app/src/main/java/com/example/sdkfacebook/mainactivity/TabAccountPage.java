package com.example.sdkfacebook.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sdkfacebook.MainActivity;
import com.example.sdkfacebook.R;

public class TabAccountPage extends Fragment {
    LinearLayout linearLayout,logout;
    TextView txtedit;
    View row;
    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        row=inflater.inflate(R.layout.activity_tab_account_page, null);//container, false);
        txtedit=row.findViewById(R.id.txtedit);
        logout=row.findViewById(R.id.logout);

        linearLayout = row.findViewById(R.id.linearLayoutSetting);
        SettingAccount_();
        Logout();

                return row;
    }

    private void Logout() {
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void SettingAccount_() {
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),SettingAccount.class);
                startActivity(intent);
            }
        });
    }


}

