package com.example.gsb_visite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.gsb_visite.databinding.ActivityAccueilBinding;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccueilActivity extends AppCompatActivity {



    private ActivityAccueilBinding binding;
    private RecyclerView recyclerViewPraticiens;
    private RecyclerViewAdpater AdapterPraticiens;
    private String authorization;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAccueilBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        recyclerViewPraticiens = findViewById(R.id.praticiensView);
        recyclerViewPraticiens.setLayoutManager(new LinearLayoutManager(this));

        String token = getIntent().getStringExtra("token");
        String visiteurId = getIntent().getStringExtra("visiteurId");

        GSBservice service = RetrofitClientInstence.RetrofitClientInstance.getRetrofitInstance().create(GSBservice.class);
        Call<Visiteur> call = service.getVisiteur("Bearer " + token, visiteurId);

        call.enqueue(new Callback<Visiteur>() {
            @Override
            public void onResponse(Call<Visiteur> call, Response<Visiteur> response) {
                if (response.isSuccessful()) {
                    Visiteur visiteur = response.body();
                    String nom = visiteur.getNom();
                    binding.textViewVisiteur.setText(nom);

                    // Make the API call to getPraticiens
                }
                Call<ArrayList<Praticien>> callPraticiens = service.getPraticien("Bearer " + token);
                callPraticiens.enqueue(new Callback<ArrayList<Praticien>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Praticien>> call, Response<ArrayList<Praticien>> response) {
                        if (response.isSuccessful()) {
                            ArrayList<Praticien> praticiens = response.body();
                            AdapterPraticiens = new RecyclerViewAdpater(praticiens);
                            recyclerViewPraticiens.setAdapter(AdapterPraticiens);
                        } else {
                            // Handle the error
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Praticien>> call, Throwable t) {
                        // Handle the error
                    }
                });
            }

            @Override
            public void onFailure(Call<Visiteur> call, Throwable t) {
                // Handle the error
            }
        });

        ;}
}


