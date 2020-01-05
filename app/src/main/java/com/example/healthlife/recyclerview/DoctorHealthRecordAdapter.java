package com.example.healthlife.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthlife.R;
import com.example.healthlife.doctoractivity.DoctorHealthRecordPage;

import java.util.ArrayList;

public class DoctorHealthRecordAdapter extends RecyclerView.Adapter<DoctorHealthRecordAdapter.ViewHolder> {

    ArrayList<DoctorHealthRecord> ListDoctorHealthRecord;
    Context context;

    public DoctorHealthRecordAdapter(ArrayList<DoctorHealthRecord> listDoctorHealthRecord, Context context) {
        ListDoctorHealthRecord = listDoctorHealthRecord;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.recyclerview_healthrecord_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.mAccountEmployeeID = ListDoctorHealthRecord.get(position).getAccountEmployeeID();
        holder.mAccountPatientID = ListDoctorHealthRecord.get(position).getAccountPatientID();
        holder.txtHealthRecordID.setText(ListDoctorHealthRecord.get(position).getHealthRecordID());
        holder.txtEmployeeID.setText(ListDoctorHealthRecord.get(position).getEmployeeID());
        holder.txtDate.setText(ListDoctorHealthRecord.get(position).getDate());
        holder.imageView.setImageResource(ListDoctorHealthRecord.get(position).getImageView());
        final String healthrecordid = ListDoctorHealthRecord.get(position).getHealthRecordID();
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DoctorHealthRecordPage.class);
                intent.putExtra("AccountEmployeeID", holder.mAccountEmployeeID);
                intent.putExtra("AccountPatientID", holder.mAccountPatientID);
                intent.putExtra("HealthRecordID",healthrecordid);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ListDoctorHealthRecord.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        String mAccountEmployeeID;
        String mAccountPatientID;
        TextView txtHealthRecordID;
        TextView txtEmployeeID;
        TextView txtDate;
        ImageView imageView;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtHealthRecordID = (TextView) itemView.findViewById(R.id.textViewHealthRecordID);
            txtEmployeeID = (TextView) itemView.findViewById(R.id.textViewEmployeeIDHR);
            txtDate = (TextView) itemView.findViewById(R.id.textViewDateHR);
            imageView = (ImageView) itemView.findViewById(R.id.circleImageViewHR);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayoutHealthRecord);
        }


    }
}
