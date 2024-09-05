package com.example.practice.data;

import com.orm.SugarRecord;

public class ContactModel extends SugarRecord {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    String name;
    String family;
    String phone;

    public ContactModel() {
    }

    public ContactModel(String name, String family, String phone) {
        this.name = name;
        this.family = family;
        this.phone = phone;
    }
}
