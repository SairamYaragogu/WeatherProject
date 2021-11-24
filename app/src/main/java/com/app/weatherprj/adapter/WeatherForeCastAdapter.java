package com.app.weatherprj.adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.weatherprj.MainActivity;
import com.app.weatherprj.R;
import com.app.weatherprj.databinding.WeatherItemRowBinding;
import com.app.weatherprj.pojo.WeatherResPojo;
import com.app.weatherprj.utils.Util;

public class WeatherForeCastAdapter extends RecyclerView.Adapter<WeatherForeCastAdapter.MyViewHolder> {
    Context myCtx;
    WeatherResPojo weatherResPojo;
    public WeatherForeCastAdapter(Context myCtx, WeatherResPojo weatherResPojo) {
        this.myCtx = myCtx;
        this.weatherResPojo = weatherResPojo;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WeatherItemRowBinding bindingView = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.weather_item_row,parent,false);
        return new MyViewHolder(bindingView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindingView.setData(weatherResPojo.getList().get(position));

        holder.bindingView.tvWeatherType.setText(weatherResPojo.getList().get(position).getWeather().get(0).getMain());
    }

    @Override
    public int getItemCount() {
        return weatherResPojo.getList().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        WeatherItemRowBinding bindingView;
        public MyViewHolder(@NonNull WeatherItemRowBinding bindingView) {
            super(bindingView.getRoot());
            this.bindingView = bindingView;
        }
    }
}
