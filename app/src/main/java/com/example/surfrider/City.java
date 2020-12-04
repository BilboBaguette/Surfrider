package com.example.surfrider;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class City {

    private String insee;
    private String name;
    private int cp;
    private float latitude;
    private float longitude;
    private float altitude;

    protected City(Parcel in) {
        insee = in.readString();
        name = in.readString();
    }

    /*public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };*/

    public String getInsee() {
        return insee;
    }

    public String getName() { return name; }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(insee);
        dest.writeString(name);
        dest.writeInt(cp);
        dest.writeFloat(latitude);
        dest.writeFloat(longitude);
        dest.writeFloat(altitude);
    }
}
