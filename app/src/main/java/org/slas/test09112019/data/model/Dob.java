package org.slas.test09112019.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Dob implements Parcelable {

    private String date;
    private int age;

    public Dob(String date, int age) {
        this.date = date;
        this.age = age;
    }

    protected Dob(Parcel in) {
        date = in.readString();
        age = in.readInt();
    }

    public static final Creator<Dob> CREATOR = new Creator<Dob>() {
        @Override
        public Dob createFromParcel(Parcel in) {
            return new Dob(in);
        }

        @Override
        public Dob[] newArray(int size) {
            return new Dob[size];
        }
    };

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(date);
        parcel.writeInt(age);
    }
}
