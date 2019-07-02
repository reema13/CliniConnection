package com.cliniconnection.cliniconnection;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cliniconnection.cliniconnection.DataBase.Patient.Patient;

import java.util.Collections;
import java.util.List;

public class PatientListAdapter extends RecyclerView.Adapter<PatientListAdapter.ViewHolder> {

    List<Patient> patientList;

    public PatientListAdapter(List<Patient> patientList) {
        this.patientList = patientList;
    }

    @Override
    public PatientListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.enter_patient_info,parent,false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(PatientListAdapter.ViewHolder holder, int position) {
        holder.name.setText(patientList.get(position).getName());
        holder.status.setText(patientList.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return patientList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView status;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.patient_name);
            status= itemView.findViewById(R.id.patient_status);
        }
    }
}