package com.example.gsb_visite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView; // Ajout de cette importation

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdpater extends RecyclerView.Adapter<RecyclerViewAdpater.RecyclerViewHolder> {
    private ArrayList<Praticien> recyclerViewList;

    public RecyclerViewAdpater(ArrayList<Praticien> recyclerViewList) {
        this.recyclerViewList = recyclerViewList;
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNomPraticien; // Correction ici
        public TextView textViewPrenomPraticien; // Correction ici

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNomPraticien = itemView.findViewById(R.id.textViewNomPraticien);
            textViewPrenomPraticien = itemView.findViewById(R.id.textViewPrenomPraticien);
        }
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_praticiens, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.textViewNomPraticien.setText(recyclerViewList.get(position).getNom());
        holder.textViewPrenomPraticien.setText(recyclerViewList.get(position).getPrenom());
    }

    @Override
    public int getItemCount() {
        return recyclerViewList.size();
    }
}