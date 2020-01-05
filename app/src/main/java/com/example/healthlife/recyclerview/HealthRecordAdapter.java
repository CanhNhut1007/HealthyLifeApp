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
import com.example.healthlife.patientactivity.PatientHealthRecordDetailPage;

import java.util.ArrayList;

public class HealthRecordAdapter extends RecyclerView.Adapter<HealthRecordAdapter.ViewHolder> {

    ArrayList<HealthRecord> ListHealthRecord;
    Context context;

    public HealthRecordAdapter(ArrayList<HealthRecord> listHealthRecord, Context context) {
        ListHealthRecord = listHealthRecord;
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
        holder.txtHealthRecordID.setText(ListHealthRecord.get(position).getHealthRecordID());
        holder.txtEmployeeID.setText(ListHealthRecord.get(position).getEmployeeID());
        holder.txtDate.setText(ListHealthRecord.get(position).getDate());
        holder.imageView.setImageResource(ListHealthRecord.get(position).getImageView());
        final String healthrecord = ListHealthRecord.get(position).getHealthRecordID();
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PatientHealthRecordDetailPage.class);
                intent.putExtra("HealthRecordID", healthrecord);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ListHealthRecord.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
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
