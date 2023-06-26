package com.axis.axistrial;

import android.os.Parcel;
import android.os.Parcelable;

public class ApplicationDetailsDataClass implements Parcelable {
    String passportNumber;
    String martialStatus;
    String visaReject;
    String qualification;
    String markObt;
    String markPercent;
    String IELTSmark;
    String TOEFLmark;
    String comm_medium;
    String comm_id;

    public ApplicationDetailsDataClass(String passportNumber, String martialStatus, String visaReject, String qualification, String markObt, String markPercent, String IELTSmark, String TOEFLmark, String comm_medium, String comm_id) {
        this.passportNumber = passportNumber;
        this.martialStatus = martialStatus;
        this.visaReject = visaReject;
        this.qualification = qualification;
        this.markObt = markObt;
        this.markPercent = markPercent;
        this.IELTSmark = IELTSmark;
        this.TOEFLmark = TOEFLmark;
        this.comm_medium = comm_medium;
        this.comm_id = comm_id;
    }

    protected ApplicationDetailsDataClass(Parcel in) {
        passportNumber = in.readString();
        martialStatus = in.readString();
        visaReject = in.readString();
        qualification = in.readString();
        markObt = in.readString();
        markPercent = in.readString();
        IELTSmark = in.readString();
        TOEFLmark = in.readString();
        comm_medium = in.readString();
        comm_id = in.readString();
    }

    public static final Creator<ApplicationDetailsDataClass> CREATOR = new Creator<ApplicationDetailsDataClass>() {
        @Override
        public ApplicationDetailsDataClass createFromParcel(Parcel in) {
            return new ApplicationDetailsDataClass(in);
        }

        @Override
        public ApplicationDetailsDataClass[] newArray(int size) {
            return new ApplicationDetailsDataClass[size];
        }
    };

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }

    public String getVisaReject() {
        return visaReject;
    }

    public void setVisaReject(String visaReject) {
        this.visaReject = visaReject;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getMarkObt() {
        return markObt;
    }

    public void setMarkObt(String markObt) {
        this.markObt = markObt;
    }

    public String getMarkPercent() {
        return markPercent;
    }

    public void setMarkPercent(String markPercent) {
        this.markPercent = markPercent;
    }

    public String getIELTSmark() {
        return IELTSmark;
    }

    public void setIELTSmark(String IELTSmark) {
        this.IELTSmark = IELTSmark;
    }

    public String getTOEFLmark() {
        return TOEFLmark;
    }

    public void setTOEFLmark(String TOEFLmark) {
        this.TOEFLmark = TOEFLmark;
    }

    public String getComm_medium() {
        return comm_medium;
    }

    public void setComm_medium(String comm_medium) {
        this.comm_medium = comm_medium;
    }

    public String getComm_id() {
        return comm_id;
    }

    public void setComm_id(String comm_id) {
        this.comm_id = comm_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(passportNumber);
        dest.writeString(martialStatus);
        dest.writeString(visaReject);
        dest.writeString(qualification);
        dest.writeString(markObt);
        dest.writeString(markPercent);
        dest.writeString(IELTSmark);
        dest.writeString(TOEFLmark);
        dest.writeString(comm_medium);
        dest.writeString(comm_id);
    }
}
