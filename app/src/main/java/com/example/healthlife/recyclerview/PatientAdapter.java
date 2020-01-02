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
import com.example.healthlife.doctoractivity.DoctorPatientRecordPage;

import java.util.ArrayList;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.ViewHolder> {

    ArrayList<Patient> ListPatient;
    Context context;

    public PatientAdapter(ArrayList<Patient> listPatient, Context context) {
        ListPatient = listPatient;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.recyclerview_patient_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.mAccountEmployeeID = ListPatient.get(position).getAccountEmployeeID();
        holder.mAccountID = ListPatient.get(position).getAccountID();
        holder.txtPatientName.setText(ListPatient.get(position).getPatientName());
        holder.txtIdentifyCard.setText(ListPatient.get(position).getIdentifyCard());
        holder.txtPatientID.setText(ListPatient.get(position).getPatientID());
        holder.imageView.setImageResource(ListPatient.get(position).getImageView());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DoctorPatientRecordPage.class);
                intent.putExtra("UserID", holder.mAccountID);
                intent.putExtra("AccountEmployeeID", holder.mAccountEmployeeID);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ListPatient.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        String mAccountEmployeeID;
        String mAccountID;
        TextView txtPatientName;
        TextView txtIdentifyCard;
        TextView txtPatientID;
        ImageView imageView;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPatientName = (TextView) itemView.findViewById(R.id.textViewPatientName);
            txtIdentifyCard = (TextView) itemView.findViewById(R.id.textViewIdentifyCard);
            txtPatientID = (TextView) itemView.findViewById(R.id.textViewPatientID);
            imageView = (ImageView) itemView.findViewById(R.id.circleImageView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayoutPatient);
        }


    }
}
