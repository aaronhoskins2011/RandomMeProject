
package com.aaron.jcpennyprepassignment.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result implements Serializable, Parcelable
{

    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("login")
    @Expose
    private Login login;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("registered")
    @Expose
    private String registered;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("cell")
    @Expose
    private String cell;
    @SerializedName("id")
    @Expose
    private Id id;
    @SerializedName("picture")
    @Expose
    private Picture picture;
    @SerializedName("nat")
    @Expose
    private String nat;
    public final static Creator<Result> CREATOR = new Creator<Result>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        public Result[] newArray(int size) {
            return (new Result[size]);
        }

    }
    ;
    private final static long serialVersionUID = -544034435033413081L;

    protected Result(Parcel in) {
        this.gender = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((Name) in.readValue((Name.class.getClassLoader())));
        this.location = ((Location) in.readValue((Location.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.login = ((Login) in.readValue((Login.class.getClassLoader())));
        this.dob = ((String) in.readValue((String.class.getClassLoader())));
        this.registered = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.cell = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((Id) in.readValue((Id.class.getClassLoader())));
        this.picture = ((Picture) in.readValue((Picture.class.getClassLoader())));
        this.nat = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Result() {
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(gender);
        dest.writeValue(name);
        dest.writeValue(location);
        dest.writeValue(email);
        dest.writeValue(login);
        dest.writeValue(dob);
        dest.writeValue(registered);
        dest.writeValue(phone);
        dest.writeValue(cell);
        dest.writeValue(id);
        dest.writeValue(picture);
        dest.writeValue(nat);
    }

    public int describeContents() {
        return  0;
    }

}
