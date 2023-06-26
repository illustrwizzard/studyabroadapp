package com.axis.axistrial;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;

public class UnvdataClass implements Parcelable {
    private JSONArray accomodation;

    private  String University_name;
    private String location ;
    private String Established;
    private String Rating;
    private String img;
    private  String status;
    private String sector ;
    private String banner;
    private String logo;
    private String city;
    private  String about;
    private String country ;
    private String contact;
    private String email;
    private String website;
    private  String ranking_name;
    private String ranking ;
    private String facilities;
    private String unv_fees_coursename;
    private String unv_fess_coursefee;
    private  String unv_accomodation_acc_name;
    private String unv_accomodation_room_type ;
    private String unv_accomoadtion_duration;
    private String unv_accomodation_fee;
    private JSONArray university_accommadation;
    private JSONArray university_details;
    private JSONArray university_facility;


    public UnvdataClass(String university_name,String rating,String estd,String status,String sector,String about,String banner,String logo,String location,String city,String country,String contact,String email,String website){

        this.University_name=university_name;
        this.Rating=rating;
        this.Established=estd;
        this.status=status;
        this.sector=sector;
        this.about=about;
        this.banner=banner;
        this.logo=logo;
        this.city=city;
        this.location=location;
        this.country=country;
        this.contact=contact;
        this.email=email;
        this.website=website;

    }






    public UnvdataClass(String university_name, String city, String estd, String rating, String logo) {

        this.University_name=university_name;

        this.city=city;
        this.Established=estd;
        this.Rating=rating;
        this.logo=logo;

    }

    public UnvdataClass(String string) {
        University_name=string;
    }

    public static final Creator<UnvdataClass> CREATOR = new Creator<UnvdataClass>() {
        @Override
        public UnvdataClass createFromParcel(Parcel in) {
            return new UnvdataClass(in);
        }

        @Override
        public UnvdataClass[] newArray(int size) {
            return new UnvdataClass[size];
        }
    };

    public JSONArray getUniversity_facility() {
        return university_facility;
    }

    private JSONArray university_ranking;
    private JSONArray university_affiliation;

    public JSONArray getUniversity_accommadation() {
        return university_accommadation;
    }

    public JSONArray getUniversity_details() {
        return university_details;
    }

    public JSONArray getUniversity_ranking() {
        return university_ranking;
    }

    public JSONArray getUniversity_affiliation() {
        return university_affiliation;
    }
    public UnvdataClass(String university_name, String location, String established, String rating) {
        University_name = university_name;
        this.location = location;
        Established = established;
        Rating = rating;

    }



    public UnvdataClass(String university_name, String location, String established, String rating, String img,JSONArray accomodation) {
        University_name = university_name;
        this.location = location;
        Established = established;
        Rating = rating;
        this.img=img;
        this.accomodation=accomodation;
    }

    protected UnvdataClass(Parcel in) {
        University_name = in.readString();
        location = in.readString();
        Established = in.readString();
        Rating = in.readString();
        img = in.readString();
        status = in.readString();
        sector = in.readString();
        banner = in.readString();
        logo = in.readString();
        city = in.readString();
        about = in.readString();
        country = in.readString();
        contact = in.readString();
        email = in.readString();
        website = in.readString();
        ranking_name = in.readString();
        ranking = in.readString();
        facilities = in.readString();
        unv_fees_coursename = in.readString();
        unv_fess_coursefee = in.readString();
        unv_accomodation_acc_name = in.readString();
        unv_accomodation_room_type = in.readString();
        unv_accomoadtion_duration = in.readString();
        unv_accomodation_fee = in.readString();
    }



    public UnvdataClass(JSONArray university_accommadation) {
        accomodation=university_accommadation;
    }

    public UnvdataClass(JSONArray accommadation, String university_name, JSONArray university_details, JSONArray university_ranking, JSONArray university_affiliation,JSONArray university_facility) {

        this.accomodation=accommadation;
        University_name=university_name;
        this.university_details=university_details;
        this.university_affiliation=university_affiliation;
        this.university_ranking=university_ranking;
        this.university_facility=university_facility;

    }


    public JSONArray getAccomodation() {
        return accomodation;
    }

    public void setAccomodation(JSONArray accomodation) {
        this.accomodation = accomodation;
    }
// GETTER/////////

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getRanking_name() {
        return ranking_name;
    }

    public void setRanking_name(String ranking_name) {
        this.ranking_name = ranking_name;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }





    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getUnv_fees_coursename() {
        return unv_fees_coursename;
    }

    public void setUnv_fees_coursename(String unv_fees_coursename) {
        this.unv_fees_coursename = unv_fees_coursename;
    }

    public String getUnv_fess_coursefee() {
        return unv_fess_coursefee;
    }

    public void setUnv_fess_coursefee(String unv_fess_coursefee) {
        this.unv_fess_coursefee = unv_fess_coursefee;
    }

    public String getUnv_accomodation_acc_name() {
        return unv_accomodation_acc_name;
    }

    public void setUnv_accomodation_acc_name(String unv_accomodation_acc_name) {
        this.unv_accomodation_acc_name = unv_accomodation_acc_name;
    }

    public String getUnv_accomodation_room_type() {
        return unv_accomodation_room_type;
    }

    public void setUnv_accomodation_room_type(String unv_accomodation_room_type) {
        this.unv_accomodation_room_type = unv_accomodation_room_type;
    }

    public String getUnv_accomoadtion_duration() {
        return unv_accomoadtion_duration;
    }

    public void setUnv_accomoadtion_duration(String unv_accomoadtion_duration) {
        this.unv_accomoadtion_duration = unv_accomoadtion_duration;
    }

    public String getUnv_accomodation_fee() {
        return unv_accomodation_fee;
    }

    public void setUnv_accomodation_fee(String unv_accomodation_fee) {
        this.unv_accomodation_fee = unv_accomodation_fee;
    }

    public String getUniversity_name() {
        return University_name;
    }

    public String getLocation() {
        return location;
    }

    public String getEstablished() {
        return Established;
    }

    public String  getRating() {
        return Rating;
    }

    public String getImg() {
        return img;
    }

    public void setUniversity_name(String university_name) {
        University_name = university_name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEstablished(String established) {
        Established = established;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public void setImg(String img) {
        this.img = img;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(University_name);
        dest.writeString(location);
        dest.writeString(Established);
        dest.writeString(Rating);
        dest.writeString(img);
        dest.writeString(status);
        dest.writeString(sector);
        dest.writeString(banner);
        dest.writeString(logo);
        dest.writeString(city);
        dest.writeString(about);
        dest.writeString(country);
        dest.writeString(contact);
        dest.writeString(email);
        dest.writeString(website);
        dest.writeString(ranking_name);
        dest.writeString(ranking);
        dest.writeString(facilities);
        dest.writeString(unv_fees_coursename);
        dest.writeString(unv_fess_coursefee);
        dest.writeString(unv_accomodation_acc_name);
        dest.writeString(unv_accomodation_room_type);
        dest.writeString(unv_accomoadtion_duration);
        dest.writeString(unv_accomodation_fee);
    }
}