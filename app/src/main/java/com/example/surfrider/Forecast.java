package com.example.surfrider;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Forecast {

    private int probarain;
    private int weather;
    private int tmin;
    private int tmax;

    protected Forecast(Parcel in) {
        probarain = in.readInt();
        weather = in.readInt();
        tmin = in.readInt();
        tmax = in.readInt();
    }

    public int getProbarain() {
        return probarain;
    }

    public int getWeather() {
        return weather;
    }

    public int getTmin() {
        return tmin;
    }

    public int getTmax() {
        return tmax;
    }

}
