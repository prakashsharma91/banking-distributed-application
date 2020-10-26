package org.besidescollege.domain.account;

import org.besidescollege.domain.common.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "accounts")
public class Account {

    @Id
    String id;
    String name;
    Address address;
    String phone;
    String phoneAlternate;

    public Account() {
    }

    public Account(String name, Address address, String phone, String phoneAlternate) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.phoneAlternate = phoneAlternate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoneAlternate() {
        return phoneAlternate;
    }

    public void setPhoneAlternate(String phoneAlternate) {
        this.phoneAlternate = phoneAlternate;
    }

    @Override
    public String toString() {
        return "Account [address=" + address + ", id=" + id + ", name=" + name + ", phone=" + phone
                + ", phoneAlternate=" + phoneAlternate + "]";
    }
}
