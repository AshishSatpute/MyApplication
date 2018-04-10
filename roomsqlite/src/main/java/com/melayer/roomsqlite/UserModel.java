package com.melayer.roomsqlite;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by ashish on 13/2/18.
 */

@Entity
public class UserModel {
    @PrimaryKey
            @NonNull
    String emailId;
    String name;
    String contactNumber;

    public UserModel() {
        this.emailId = emailId;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
