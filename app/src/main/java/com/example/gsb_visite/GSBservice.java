package com.example.gsb_visite;

import android.widget.TextView;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface GSBservice {
    @POST("api/auth/login")
    Call<Visiteur> loginVisiteur(@Body Visiteur visiteur);


}
