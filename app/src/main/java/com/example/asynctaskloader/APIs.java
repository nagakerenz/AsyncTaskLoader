package com.example.asynctaskloader;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIs {
    static String BASE_URL = "https://api.thedogapi.com/";

    @GET("v1/breeds")
    Call<List<DogsResult>> getProduct();


}
