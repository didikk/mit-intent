package me.didik.helloworld.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import me.didik.helloworld.SessionManager;

/**
 * Created by didik on 12/13/16.
 */

public class Person implements Parcelable {
    private String email;
    private String password;

    public Person(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.email);
        dest.writeString(this.password);
    }

    protected Person(Parcel in) {
        this.email = in.readString();
        this.password = in.readString();
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public static void printSessionManager(){
        Log.d("isisession", SessionManager.getInstance().getEmail());
    }
}
