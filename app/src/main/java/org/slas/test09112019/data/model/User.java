package org.slas.test09112019.data.model;

public class User {

    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Login login;
    private String dob;
    private String registered;
    private String phone;
    private String cell;
    private Id id;
    private Picture picture;

    private User() {
    }

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

    public String getDob() {
        return dob;
    }

    public String getRegistered() {
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

        public Builder setDob(String dob){
            User.this.dob = dob;
            return this;
        }

        public Builder setRegistered(String registered){
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
    }
}
