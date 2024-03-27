package com.example.gsb_visite;

import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GSBservice {
    @POST("api/auth/login")
    Call<Visiteur> loginVisiteur(@Body Visiteur visiteur);

    @GET("api/particien")
    Call<ArrayList<Praticien>> getPraticien(@Header("Authorization") String token);

    @GET("api/visiteur/{id}")
    Call<Visiteur> getVisiteur(@Header("Authorization") String token, @Path("id") String id);




}
