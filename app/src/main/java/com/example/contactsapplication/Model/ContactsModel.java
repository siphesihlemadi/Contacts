package com.example.contactsapplication.Model;

public class ContactsModel {
    String contactName;
    String phoneNumber;

    public ContactsModel(String contactName, String phoneNumber) {
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
