package com.example.surfrider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ApiResponse city;
    private Gson gson;

    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
        gson = new GsonBuilder()
                .setLenient()
                .create();
        makeApiCall();
    }

    static final String BASE_URL = "https://api.meteo-concept.com/api/";
    private void makeApiCall(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        final CityApi CityApi = retrofit.create(CityApi.class);

        Call<ApiResponse> call = CityApi.getCityResponse();

        call.enqueue(new Callback<ApiResponse>() {

            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {

                if (response.isSuccessful() && response.body() != null) {
                    city = response.body();
                    System.out.println(city.getForecast().getProbarain());

                    Toast.makeText(getApplicationContext(),city.getCity().getInsee(), Toast.LENGTH_SHORT).show();
                } else {
                    showError();
                }
            }
            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void showError() {
        Toast.makeText(getApplicationContext(), "API Error", Toast.LENGTH_SHORT).show();
    }


}