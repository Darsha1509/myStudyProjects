package com.example.dasha.tourgidapp;

/**
 * Created by Dasha on 04.09.2017.
 */

public class Institution {
    private String mAddress;
    private String mBusinessHours;

    public Institution(String address, String businessHours) {
        mAddress = address;
        mBusinessHours = businessHours;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public void setBusinessHours(String businessHours) {
        mBusinessHours = businessHours;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getBusinessHours() {
        return mBusinessHours;
    }
}
