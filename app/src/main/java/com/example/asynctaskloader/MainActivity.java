package com.example.asynctaskloader;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvProducts;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_dogs);
        rvProducts = findViewById(R.id.rvProducts);
        getProducts();
    }

    private void getProducts() {
        Call<List<DogsResult>> apiCall = RetrofitClient.getInstance().getApis().getProduct();
        apiCall.enqueue(new Callback<List<DogsResult>>() {
            @Override
            public void onResponse(Call<List<DogsResult>> call, Response<List<DogsResult>> response) {
                List<DogsResult> dogsResults = response.body();
                Toast.makeText(MainActivity.this,"Dogs Found",Toast.LENGTH_SHORT).show();
                setAdapter(dogsResults);
            }

            @Override
            public void onFailure(Call<List<DogsResult>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setAdapter(List<DogsResult> dogsResults) {
        rvProducts.setLayoutManager(new LinearLayoutManager(this));
        RVRetrofitAdapter rvRetrofitAdapter =  new RVRetrofitAdapter(this, dogsResults);
        rvProducts.setAdapter(rvRetrofitAdapter);
    }
}