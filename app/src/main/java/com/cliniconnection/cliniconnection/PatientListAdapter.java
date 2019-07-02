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

public class PatientListAdapter extends RecyclerView.Adapter<PatientListAdapter.PatientViewHolder> {

    public class PatientViewHolder extends RecyclerView.ViewHolder{

    private final TextView patientItem;
        public PatientViewHolder(@NonNull View itemView) {
            super(itemView);
            patientItem = itemView.findViewById(R.id.textView);
        }

    }


    private final LayoutInflater mInflater;
    private List<Patient> name = Collections.emptyList();
    PatientListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public PatientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.enter_patient_info, parent, false);
        return new PatientViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientViewHolder holder, int position) {
        Patient current = name.get(position);
        holder.patientItem.setText(current.getName());
    }

    void setPatient(List<Patient> patient) {
        name = patient;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return name.size();
    }


}
