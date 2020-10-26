package org.besidescollege.domain.common;

public class Address {
    String houseNumber;
    String streetName;
    String city;
    String pinCode;

    // Required for deserialize
    public Address() {
    }

    public Address(String houseNumber, String streetName, String city, String pinCode) {
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.city = city;
        this.pinCode = pinCode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

}
