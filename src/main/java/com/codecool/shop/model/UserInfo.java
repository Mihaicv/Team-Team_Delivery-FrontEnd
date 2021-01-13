package com.codecool.shop.model;

import org.graalvm.compiler.lir.LIRInstruction;

public class UserInfo {
    int counter;
    int id;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    String bilingAddress;
    String shippingAddress;

    public UserInfo(){
        counter++;
        id = counter;
    }

    public UserInfo(int id, String firstName, String lastName, String email,  String bilingAddress, String shippingAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.bilingAddress = bilingAddress;
        this.shippingAddress = shippingAddress;
        phoneNumber ="1" ;
    }

    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBilingAddress() {
        return bilingAddress;
    }

    public void setBilingAddress(String bilingAddress) {
        this.bilingAddress = bilingAddress;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
