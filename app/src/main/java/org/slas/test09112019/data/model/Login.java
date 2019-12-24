package org.slas.test09112019.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Login implements Parcelable {

    private String username;
    private String password;
    private String salt;
    private String md5;
    private String sha1;
    private String sha256;

    public Login(String username, String password, String salt, String md5, String sha1, String sha256) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.md5 = md5;
        this.sha1 = sha1;
        this.sha256 = sha256;
    }

    protected Login(Parcel in) {
        username = in.readString();
        password = in.readString();
        salt = in.readString();
        md5 = in.readString();
        sha1 = in.readString();
        sha256 = in.readString();
    }

    public static final Creator<Login> CREATOR = new Creator<Login>() {
        @Override
        public Login createFromParcel(Parcel in) {
            return new Login(in);
        }

        @Override
        public Login[] newArray(int size) {
            return new Login[size];
        }
    };

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    public String getSha256() {
        return sha256;
    }

    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(username);
        parcel.writeString(password);
        parcel.writeString(salt);
        parcel.writeString(md5);
        parcel.writeString(sha1);
        parcel.writeString(sha256);
    }
}
