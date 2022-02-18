package com.example.userapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ModelData implements Parcelable {
    public String functionName;
    public ArrayList<String> studentList = new ArrayList<>();
    public ArrayList<String> imageList = new ArrayList<>();
    public String summery;

    public ModelData() {
    }

    protected ModelData(Parcel in) {
        functionName = in.readString();
        studentList = in.createStringArrayList();
        imageList = in.createStringArrayList();
        summery = in.readString();
    }

    public static final Creator<ModelData> CREATOR = new Creator<ModelData>() {
        @Override
        public ModelData createFromParcel(Parcel in) {
            return new ModelData(in);
        }

        @Override
        public ModelData[] newArray(int size) {
            return new ModelData[size];
        }
    };

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public ArrayList<String> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<String> studentList) {
        this.studentList = studentList;
    }

    public ArrayList<String> getImageList() {
        return imageList;
    }

    public void setImageList(ArrayList<String> imageList) {
        this.imageList = imageList;
    }

    public String getSummery() {
        return summery;
    }

    public void setSummery(String summery) {
        this.summery = summery;
    }

    public ModelData(String functionName, ArrayList<String> studentList, ArrayList<String> imageList, String summery) {
        this.functionName = functionName;
        this.studentList = studentList;
        this.imageList = imageList;
        this.summery = summery;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(functionName);
        parcel.writeStringList(studentList);
        parcel.writeStringList(imageList);
        parcel.writeString(summery);
    }
}
