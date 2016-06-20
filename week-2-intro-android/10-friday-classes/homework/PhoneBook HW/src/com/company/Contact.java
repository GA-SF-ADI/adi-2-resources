package com.company;

/**
 * Created by kitty on 6/19/16.
 */
public class Contact {

    private String mFirstName;
    private String mLastName;
    private String mMobile;
    private String mHome;

    public Contact(String mFirstName, String mLastName, String mMobile, String mHome) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mMobile = mMobile;
        this.mHome = mHome;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getmMobile() {
        return mMobile;
    }

    public void setmMobile(String mMobile) {
        this.mMobile = mMobile;
    }

    public String getmHome() {
        return mHome;
    }

    public void setmHome(String mHome) {
        this.mHome = mHome;
    }


}
