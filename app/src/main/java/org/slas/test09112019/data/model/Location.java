package org.slas.test09112019.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable {

    private Street street;
    private String city;
    private String state;
    private String country;
    private String postCode;

    public Location(Street street, String city, String state, String country, String postCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postCode = postCode;
    }

    protected Location(Parcel in) {
        city = in.readString();
        state = in.readString();
        country = in.readString();
        postCode = in.readString();
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(city);
        parcel.writeString(state);
        parcel.writeString(country);
        parcel.writeString(postCode);
    }
}
