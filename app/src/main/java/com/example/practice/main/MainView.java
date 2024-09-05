package com.example.practice.main;

import com.example.practice.data.ContactModel;
import java.util.List;

public interface MainView {
    void setItems(List<ContactModel> contacts);
}
