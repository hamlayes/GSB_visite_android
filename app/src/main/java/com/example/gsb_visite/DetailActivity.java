package com.example.gsb_visite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gsb_visite.databinding.ActivityAccueilBinding;
import com.example.gsb_visite.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;

    private RecyclerView recyclerViewVisites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        recyclerViewVisites = findViewById(R.id.recyclerView);
        recyclerViewVisites.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        Praticien praticien = (Praticien) intent.getSerializableExtra("praticien");


        if (praticien != null) {
            binding.nomP.setText(praticien.getNom());
            binding.prenomP.setText(praticien.getPrenom());
            binding.tel.setText(praticien.getTel());
            binding.mailP.setText(praticien.getEmail());
            binding.rue.setText(praticien.getRue());
            binding.ville.setText(praticien.getVille());
            binding.cp.setText(praticien.getCode_postale());
        }

        recyclerViewVisites.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerViewVisites, new RecyclerViewClickListener(){
            @Override
            public void onClick(View view, int position) {
                //afficher les visite dans le recyclerview

            }
        }));

    }
}