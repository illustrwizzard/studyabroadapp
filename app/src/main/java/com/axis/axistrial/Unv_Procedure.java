package com.axis.axistrial;

public class Unv_Procedure {
    String university_name;
    String apply;
    String visa;
    String service;
    String documents;
    public Unv_Procedure(String university_name,String apply,String visa,String service,String documents) {

        this.university_name=university_name;
        this.apply=apply;
        this.visa=visa;
        this.service=service;
        this.documents=documents;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    public String getApply() {
        return apply;
    }

    public void setApply(String apply) {
        this.apply = apply;
    }

    public String getVisa() {
        return visa;
    }

    public void setVisa(String visa) {
        this.visa = visa;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }
}
