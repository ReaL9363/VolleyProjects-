package com.example.android.volleyjsonarray;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ReaL PC on 11/20/2016.
 */

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.MyViewHolder> {

    private List<Doctor> doctorsList;

    public DoctorAdapter(List<Doctor> doctorsList) {
        this.doctorsList = doctorsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(itemView);

        return myViewHolder;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgDoctor;
        TextView tvName, tvDesignation, tvDescription;

        public MyViewHolder(View itemView) {
            super(itemView);
            imgDoctor = (ImageView) itemView.findViewById(R.id.imgDoctor);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvDesignation = (TextView) itemView.findViewById(R.id.tvDesignation);
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Doctor doctor = doctorsList.get(position);
        holder.tvName.setText(doctor.getName());
        //holder.tvDesignation.setText(doctor.g);
        // holder.imgDoctor.setImageResource();

    }

    @Override
    public int getItemCount() {
        return doctorsList.size();
    }


}
