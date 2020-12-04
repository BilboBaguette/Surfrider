package com.example.surfrider;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CityApi {

    @GET("forecast/daily/0?token=f03a657e2877eadc8d875a1da60955bdbc42c3586ec95e1b79b719d96ef7ca9f")
    Call<ApiResponse> getCityResponse();

}
