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
import com.example.healthlife.patientactivity.PatientDoctorProfilePage;

import java.util.ArrayList;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder> {

    ArrayList<Doctor> ListDoctor;
    Context context;

    public DoctorAdapter(ArrayList<Doctor> listDoctor, Context context) {
        ListDoctor = listDoctor;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.recyclerview_doctor_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.mAccountID = ListDoctor.get(position).getAccountID();
        holder.txtEmployeeName.setText(ListDoctor.get(position).getEmployeeName());
        holder.txtSpeciality.setText(ListDoctor.get(position).getSpeciality());
        holder.txtEmployeeID.setText(ListDoctor.get(position).getEmployeeID());
        holder.imageView.setImageResource(ListDoctor.get(position).getImageView());
        final String accountid = ListDoctor.get(position).getAccountID();;
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PatientDoctorProfilePage.class);
                intent.putExtra("UserID", accountid);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ListDoctor.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        String mAccountID;
        TextView txtEmployeeName;
        TextView txtSpeciality;
        TextView txtEmployeeID;
        ImageView imageView;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtEmployeeName = (TextView) itemView.findViewById(R.id.textViewEmployeeName);
            txtSpeciality = (TextView) itemView.findViewById(R.id.textViewSpeciality);
            txtEmployeeID = (TextView) itemView.findViewById(R.id.textViewEmployeeID);
            imageView = (ImageView) itemView.findViewById(R.id.circleImageViewDoctor);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.linearLayoutDoctor);
        }


    }
}

