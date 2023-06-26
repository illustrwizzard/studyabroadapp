package com.axis.axistrial;

public class Un_Accomodation {
    String university_name;
    String hst_name;
    String room_type;
    String duration;
    String fee;

    public Un_Accomodation(String university_name, String hst_name, String room_type, String duration, String fee) {
        this.university_name = university_name;
        this.hst_name = hst_name;
        this.room_type = room_type;
        this.duration = duration;
        this.fee = fee;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    public String getHst_name() {
        return hst_name;
    }

    public void setHst_name(String hst_name) {
        this.hst_name = hst_name;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
