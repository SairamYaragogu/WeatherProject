package com.app.weatherprj;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.app.weatherprj.adapter.WeatherForeCastAdapter;
import com.app.weatherprj.databinding.ActivityMainBinding;
import com.app.weatherprj.pojo.WeatherResPojo;
import com.app.weatherprj.viewmodel.WeatherViewModel;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    WeatherForeCastAdapter weatherForeCastAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        initRecyclerView();
        observeForecast();
    }

    private void observeForecast() {
        WeatherViewModel model = ViewModelProviders.of(this).get(WeatherViewModel.class);

        model.getForecast().observe(this, new Observer<WeatherResPojo>() {
            @Override
            public void onChanged(@Nullable WeatherResPojo weatherResPojo) {
                weatherForeCastAdapter = new WeatherForeCastAdapter(MainActivity.this, weatherResPojo);
                binding.recyclerView.setAdapter(weatherForeCastAdapter);
            }
        });
    }

    private void initRecyclerView(){
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}