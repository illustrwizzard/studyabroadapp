package com.axis.axistrial;

public class UCentrance {

    String exam_name1,exam_name2,exam_name3,exam_name4,exam_name5,exam_name6,course_name;

    public UCentrance(String course_name,String exam_name1, String exam_name2, String exam_name3, String exam_name4, String exam_name5, String exam_name6) {
        this.exam_name1 = exam_name1;
        this.exam_name2 = exam_name2;
        this.exam_name3 = exam_name3;
        this.exam_name4 = exam_name4;
        this.exam_name5 = exam_name5;
        this.exam_name6 = exam_name6;
        this.course_name=course_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getExam_name1() {
        return exam_name1;
    }

    public void setExam_name1(String exam_name1) {
        this.exam_name1 = exam_name1;
    }

    public String getExam_name2() {
        return exam_name2;
    }

    public void setExam_name2(String exam_name2) {
        this.exam_name2 = exam_name2;
    }

    public String getExam_name3() {
        return exam_name3;
    }

    public void setExam_name3(String exam_name3) {
        this.exam_name3 = exam_name3;
    }

    public String getExam_name4() {
        return exam_name4;
    }

    public void setExam_name4(String exam_name4) {
        this.exam_name4 = exam_name4;
    }

    public String getExam_name5() {
        return exam_name5;
    }

    public void setExam_name5(String exam_name5) {
        this.exam_name5 = exam_name5;
    }

    public String getExam_name6() {
        return exam_name6;
    }

    public void setExam_name6(String exam_name6) {
        this.exam_name6 = exam_name6;
    }
}
