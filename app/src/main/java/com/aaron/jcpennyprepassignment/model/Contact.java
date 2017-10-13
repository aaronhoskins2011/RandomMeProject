package com.aaron.jcpennyprepassignment.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aaron on 10/11/17.
 */

public class Contact implements Parcelable {
    String firstName;
    String lastName;
    String middleName;
    String streetLocation;
    String cityLocation;
    String stateLocation;
    String postalCode;
    String eMailAddress;
    String dateOfBirth;
    String imageThumbnailLocation;
    String imageMidSizedLocation;
    String imageLargeSizedLocation;
    String landPhoneNumber;
    String cellPhoneNumber;

    public Contact(String firstName, String lastName, String middleName, String streetLocation, String cityLocation, String stateLocation, String postalCode, String eMailAddress, String dateOfBirth, String imageThumbnailLocation, String imageMidSizedLocation, String imageLargeSizedLocation, String landPhoneNumber, String cellPhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.streetLocation = streetLocation;
        this.cityLocation = cityLocation;
        this.stateLocation = stateLocation;
        this.postalCode = postalCode;
        this.eMailAddress = eMailAddress;
        this.dateOfBirth = dateOfBirth;
        this.imageThumbnailLocation = imageThumbnailLocation;
        this.imageMidSizedLocation = imageMidSizedLocation;
        this.imageLargeSizedLocation = imageLargeSizedLocation;
        this.landPhoneNumber = landPhoneNumber;
        this.cellPhoneNumber = cellPhoneNumber;
    }
    public Contact(Result passedResult){
        this.firstName = passedResult.getName().getFirst();
        this.lastName = passedResult.getName().getLast();
        this.middleName = passedResult.getName().getTitle();
        this.streetLocation = passedResult.getLocation().getStreet();
        this.cityLocation = passedResult.getLocation().getCity();
        this.stateLocation = passedResult.getLocation().getState();
        this.postalCode = String.valueOf(passedResult.getLocation().getPostcode());
        this.eMailAddress = passedResult.getEmail();
        this.dateOfBirth = passedResult.getDob();
        this.imageThumbnailLocation = passedResult.getPicture().getThumbnail();
        this.imageMidSizedLocation = passedResult.getPicture().getMedium();
        this.imageLargeSizedLocation = passedResult.getPicture().getLarge();
        this.landPhoneNumber = passedResult.getPhone();
        this.cellPhoneNumber = passedResult.getCell();
    }

    protected Contact(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        middleName = in.readString();
        streetLocation = in.readString();
        cityLocation = in.readString();
        stateLocation = in.readString();
        postalCode = in.readString();
        eMailAddress = in.readString();
        dateOfBirth = in.readString();
        imageThumbnailLocation = in.readString();
        imageMidSizedLocation = in.readString();
        imageLargeSizedLocation = in.readString();
        landPhoneNumber = in.readString();
        cellPhoneNumber = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getStreetLocation() {
        return streetLocation;
    }

    public void setStreetLocation(String streetLocation) {
        this.streetLocation = streetLocation;
    }

    public String getCityLocation() {
        return cityLocation;
    }

    public void setCityLocation(String cityLocation) {
        this.cityLocation = cityLocation;
    }

    public String getStateLocation() {
        return stateLocation;
    }

    public void setStateLocation(String stateLocation) {
        this.stateLocation = stateLocation;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String geteMailAddress() {
        return eMailAddress;
    }

    public void seteMailAddress(String eMailAddress) {
        this.eMailAddress = eMailAddress;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getImageThumbnailLocation() {
        return imageThumbnailLocation;
    }

    public void setImageThumbnailLocation(String imageThumbnailLocation) {
        this.imageThumbnailLocation = imageThumbnailLocation;
    }

    public String getImageMidSizedLocation() {
        return imageMidSizedLocation;
    }

    public void setImageMidSizedLocation(String imageMidSizedLocation) {
        this.imageMidSizedLocation = imageMidSizedLocation;
    }

    public String getImageLargeSizedLocation() {
        return imageLargeSizedLocation;
    }

    public void setImageLargeSizedLocation(String imageLargeSizedLocation) {
        this.imageLargeSizedLocation = imageLargeSizedLocation;
    }

    public String getLandPhoneNumber() {
        return landPhoneNumber;
    }

    public void setLandPhoneNumber(String landPhoneNumber) {
        this.landPhoneNumber = landPhoneNumber;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public Contact() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(middleName);
        parcel.writeString(streetLocation);
        parcel.writeString(cityLocation);
        parcel.writeString(stateLocation);
        parcel.writeString(postalCode);
        parcel.writeString(eMailAddress);
        parcel.writeString(dateOfBirth);
        parcel.writeString(imageThumbnailLocation);
        parcel.writeString(imageMidSizedLocation);
        parcel.writeString(imageLargeSizedLocation);
        parcel.writeString(landPhoneNumber);
        parcel.writeString(cellPhoneNumber);
    }
}
