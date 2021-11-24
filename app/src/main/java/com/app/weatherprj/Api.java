package com.app.weatherprj;

import com.app.weatherprj.pojo.WeatherResPojo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface Api {
    String BASE_URL = "https://api.openweathermap.org/";
    String API_KEY = "071ccac0274458e77d1005b0ba2c7a64";

    @GET("data/2.5/forecast")
    Call<WeatherResPojo> getForecast(@QueryMap Map<String, String> params);
}
