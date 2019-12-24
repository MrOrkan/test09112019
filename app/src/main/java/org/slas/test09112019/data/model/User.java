package org.slas.test09112019.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.slas.test09112019.constants.ViewType;
import org.slas.test09112019.presentation.base.adapter.RecyclerItem;

public class User implements RecyclerItem, Parcelable {

    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Login login;
    private Dob dob;
    private Registered registered;
    private String phone;
    private String cell;
    private Id id;
    private Picture picture;
    private String nat;

    private User() {
    }

    protected User(Parcel in) {
        gender = in.readString();
        name = in.readParcelable(Name.class.getClassLoader());
        email = in.readString();
        phone = in.readString();
        cell = in.readString();
        nat = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getGender() {
        return gender;
    }

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public Login getLogin() {
        return login;
    }

    public Dob getDob() {
        return dob;
    }

    public Registered getRegistered() {
        return registered;
    }

    public String getPhone() {
        return phone;
    }

    public String getCell() {
        return cell;
    }

    public Id getId() {
        return id;
    }

    public Picture getPicture() {
        return picture;
    }

    public String getNat() {
        return nat;
    }

    public static Builder getNewBuilder(){
        return new User().new Builder();
    }

    public class Builder{

        private Builder() {
        }

        public Builder setGender(String gender){
            User.this.gender = gender;
            return this;
        }

        public Builder setName(Name name){
            User.this.name = name;
            return this;
        }

        public Builder setLocation(Location location){
            User.this.location = location;
            return this;
        }

        public Builder setEmail(String email){
            User.this.email = email;
            return this;
        }

        public Builder setLogin(Login login){
            User.this.login = login;
            return this;
        }

        public Builder setDob(Dob dob){
            User.this.dob = dob;
            return this;
        }

        public Builder setRegistered(Registered registered){
            User.this.registered = registered;
            return this;
        }

        public Builder setPhone(String phone){
            User.this.phone = phone;
            return this;
        }

        public Builder setCell(String cell){
            User.this.cell = cell;
            return this;
        }

        public Builder setId(Id id){
            User.this.id = id;
            return this;
        }

        public Builder setPicture(Picture picture){
            User.this.picture = picture;
            return this;
        }

        public Builder setNat(String nat){
            User.this.nat = nat;
            return this;
        }

        public User build(){
            return User.this;
        }
    }

    @Override
    public Integer getViewType() {
        return ViewType.USER_VIEW_TYPE;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(gender);
        parcel.writeParcelable(name, i);
        parcel.writeParcelable(location, i);
        parcel.writeString(email);
        parcel.writeParcelable(login, i);
        parcel.writeParcelable(dob, i);
        parcel.writeParcelable(registered, i);
        parcel.writeString(phone);
        parcel.writeString(cell);
        parcel.writeParcelable(id, i);
        parcel.writeParcelable(picture, i);
        parcel.writeString(nat);
    }


}
