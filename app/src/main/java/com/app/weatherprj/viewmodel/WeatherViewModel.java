package com.app.weatherprj.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.app.weatherprj.Api;
import com.app.weatherprj.pojo.WeatherResPojo;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherViewModel extends ViewModel {
    private MutableLiveData<WeatherResPojo> weatherList;

    public LiveData<WeatherResPojo> getForecast() {
        if (weatherList == null) {
            weatherList = new MutableLiveData<WeatherResPojo>();

            loadForecast();
        }
        return weatherList;
    }

    private void loadForecast() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Map<String,String> params = new HashMap<>();
        params.put("q","Tanuku");
        params.put("appid",Api.API_KEY);

        Api api = retrofit.create(Api.class);
        Call<WeatherResPojo> call = api.getForecast(params);

        call.enqueue(new Callback<WeatherResPojo>() {
            @Override
            public void onResponse(Call<WeatherResPojo> call, Response<WeatherResPojo> response) {
                Log.d("url",call.request().url().toString());
                weatherList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<WeatherResPojo> call, Throwable t) {

            }
        });
    }
}
