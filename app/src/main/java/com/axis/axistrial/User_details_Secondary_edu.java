package com.axis.axistrial;

public class User_details_Secondary_edu {
    String Secondary_board;
    String secondary_start_year;
    String secondary_end_year;
    String secondary_grade;

    public User_details_Secondary_edu(String secondary_board, String secondary_start_year, String secondary_end_year, String secondary_grade) {
        Secondary_board = secondary_board;
        this.secondary_start_year = secondary_start_year;
        this.secondary_end_year = secondary_end_year;
        this.secondary_grade = secondary_grade;
    }

    public String getSecondary_board() {
        return Secondary_board;
    }

    public void setSecondary_board(String secondary_board) {
        Secondary_board = secondary_board;
    }

    public String getSecondary_start_year() {
        return secondary_start_year;
    }

    public void setSecondary_start_year(String secondary_start_year) {
        this.secondary_start_year = secondary_start_year;
    }

    public String getSecondary_end_year() {
        return secondary_end_year;
    }

    public void setSecondary_end_year(String secondary_end_year) {
        this.secondary_end_year = secondary_end_year;
    }

    public String getSecondary_grade() {
        return secondary_grade;
    }

    public void setSecondary_grade(String secondary_grade) {
        this.secondary_grade = secondary_grade;
    }
}
