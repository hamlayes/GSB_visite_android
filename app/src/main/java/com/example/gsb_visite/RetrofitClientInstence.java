package com.example.gsb_visite;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstence {
    public class RetrofitClientInstance {
        private static Retrofit retrofit;
        private static final String BASE_URL = "https://shiny-happiness-7qxqxp464jpfp5qw-3000.app.github.dev/";
        public static Retrofit getRetrofitInstance() {
            if (retrofit == null) {
                retrofit = new retrofit2.Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }
    }

}
