package com.example.gsb_visite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gsb_visite.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.buttonConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.Email.getText().toString();
                String password = binding.Password.getText().toString();
                Visiteur visiteur = new Visiteur(email,password);
                GSBservice service = RetrofitClientInstence.RetrofitClientInstance.getRetrofitInstance().create(GSBservice.class);
                Call<Visiteur> call = service.loginVisiteur(visiteur);



                call.enqueue(new Callback<Visiteur>() {
                    @Override
                    public void onResponse(Call<Visiteur> call, Response<Visiteur> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(MainActivity.this, "connection reussi", Toast.LENGTH_SHORT).show();
                            response.body();
                        }else{
                            Toast.makeText(MainActivity.this, "Erreur de réponse de l'API", Toast.LENGTH_SHORT).show();
                        }

                        Intent intent = new Intent(MainActivity.this, AccueilActivity.class);
                        intent.putExtra("token", response.body().getToken());
                        intent.putExtra("visiteurId", response.body().getVisiteurId());
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Visiteur> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Une erreur est survenue !", Toast.LENGTH_SHORT).show();
                    }
                });
                }


        });



    }
}