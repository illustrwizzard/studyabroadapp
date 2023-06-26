package com.axis.axistrial;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class filterdataClass implements Parcelable {
    ArrayList<String> arrayList;

    public filterdataClass(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }


    protected filterdataClass(Parcel in) {
        arrayList = in.createStringArrayList();
    }

    public static final Creator<filterdataClass> CREATOR = new Creator<filterdataClass>() {
        @Override
        public filterdataClass createFromParcel(Parcel in) {
            return new filterdataClass(in);
        }

        @Override
        public filterdataClass[] newArray(int size) {
            return new filterdataClass[size];
        }
    };

    public ArrayList<String> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(arrayList);
    }
}
