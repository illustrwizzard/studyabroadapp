package com.axis.axistrial;

import android.os.Parcel;
import android.os.Parcelable;

public class DataModelClassForCourse implements Parcelable {


    private String course_name ;
    private String course;
    private String year;
    private String time;

    private  String total_fee;
    private String syllabus ;
    private  String university_name;


    public DataModelClassForCourse(String course_name) {
        this.course_name = course_name;
    }

    public DataModelClassForCourse(String university_name, String course_name, String course, String year, String time,  String total_fee, String syllabus) {
        this.university_name=university_name;

        this.course_name = course_name;
        this.course = course;
        this.year = year;
        this.time = time;

        this.total_fee = total_fee;
        this.syllabus = syllabus;

    }

    public DataModelClassForCourse( String course_name, String course, String year,  String time, String total_fee, String syllabus) {

        this.course_name=course_name;

        this.time=time;
        this.course=course;

        this.year=year;

        this.total_fee=total_fee;
        this.syllabus=syllabus;



    }


    protected DataModelClassForCourse(Parcel in) {
        course_name = in.readString();
        course = in.readString();
        year = in.readString();
        time = in.readString();
        total_fee = in.readString();
        syllabus = in.readString();
        university_name = in.readString();
    }

    public static final Creator<DataModelClassForCourse> CREATOR = new Creator<DataModelClassForCourse>() {
        @Override
        public DataModelClassForCourse createFromParcel(Parcel in) {
            return new DataModelClassForCourse(in);
        }

        @Override
        public DataModelClassForCourse[] newArray(int size) {
            return new DataModelClassForCourse[size];
        }
    };

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }


    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(course_name);
        dest.writeString(course);
        dest.writeString(year);
        dest.writeString(time);
        dest.writeString(total_fee);
        dest.writeString(syllabus);
        dest.writeString(university_name);
    }
}
