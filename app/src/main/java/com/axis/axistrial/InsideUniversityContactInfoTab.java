package com.axis.axistrial;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.axistrial.R;

import java.util.ArrayList;


public class InsideUniversityContactInfoTab extends Fragment {
    TextView clocation,cphone,cemail,clink;
    String ilocation,icontact,iwebsite,iemail;
    ImageView phoneimg,locimg,mailimg,websiteimg;
    ArrayList<UnvdataClass> arraydetails;
    SQLDB sqldb;
    String university_name;
    String from;

    public InsideUniversityContactInfoTab(ArrayList<UnvdataClass> arraydetails,String university_name,String from) {
        this.arraydetails=arraydetails;
        this.university_name=university_name;
this.from=from;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.inside_university_contact_info_tab, container, false);



        sqldb=new SQLDB(getContext());
        arraydetails=new ArrayList<>();
        if(from.equals("book_mark")){
            arraydetails=sqldb.getuniv_details_single_bookmark(university_name);
            if (arraydetails.size()>0){
                clocation=view.findViewById(R.id.location_in_university_contact_info);
                cphone=view.findViewById(R.id.phone_number_in_contacttab);
                cemail=view.findViewById(R.id.email_in_university_info);
                clink=view.findViewById(R.id.link_in_university_contact_info);



                clocation.setText(arraydetails.get(0).getLocation());
                clink.setText(arraydetails.get(0).getWebsite());
                cemail.setText(arraydetails.get(0).getEmail());
                cphone.setText(arraydetails.get(0).getContact());


                phoneimg=view.findViewById(R.id.phoneimg_in_cc);
                phoneimg.setImageResource(R.drawable.phoneup);
                locimg=view.findViewById(R.id.locationimg_in_cc);
                mailimg=view.findViewById(R.id.mailimg);
                websiteimg=view.findViewById(R.id.websiteimg);
                locimg.setImageResource(R.drawable.location_new);
                mailimg.setImageResource(R.drawable.mailup);
                websiteimg.setImageResource(R.drawable.globe);

            }

        }else if(from.equals("book_mark_deleted")){

            arraydetails=sqldb.getuniv_details_single_bookmark1(university_name);
            if (arraydetails.size()>0){
                clocation=view.findViewById(R.id.location_in_university_contact_info);
                cphone=view.findViewById(R.id.phone_number_in_contacttab);
                cemail=view.findViewById(R.id.email_in_university_info);
                clink=view.findViewById(R.id.link_in_university_contact_info);



                clocation.setText(arraydetails.get(0).getLocation());
                clink.setText(arraydetails.get(0).getWebsite());
                cemail.setText(arraydetails.get(0).getEmail());
                cphone.setText(arraydetails.get(0).getContact());


                phoneimg=view.findViewById(R.id.phoneimg_in_cc);
                phoneimg.setImageResource(R.drawable.phoneup);
                locimg=view.findViewById(R.id.locationimg_in_cc);
                mailimg=view.findViewById(R.id.mailimg);
                websiteimg=view.findViewById(R.id.websiteimg);
                locimg.setImageResource(R.drawable.location_new);
                mailimg.setImageResource(R.drawable.mailup);
                websiteimg.setImageResource(R.drawable.globe);

            }

        }



        else{
            arraydetails=sqldb.getuniv_details_single(university_name);


            if (arraydetails.size()>0){
                clocation=view.findViewById(R.id.location_in_university_contact_info);
                cphone=view.findViewById(R.id.phone_number_in_contacttab);
                cemail=view.findViewById(R.id.email_in_university_info);
                clink=view.findViewById(R.id.link_in_university_contact_info);



                clocation.setText(arraydetails.get(0).getLocation());
                clink.setText(arraydetails.get(0).getWebsite());
                cemail.setText(arraydetails.get(0).getEmail());
                cphone.setText(arraydetails.get(0).getContact());


                phoneimg=view.findViewById(R.id.phoneimg_in_cc);
                phoneimg.setImageResource(R.drawable.phoneup);
                locimg=view.findViewById(R.id.locationimg_in_cc);
                mailimg=view.findViewById(R.id.mailimg);
                websiteimg=view.findViewById(R.id.websiteimg);
                locimg.setImageResource(R.drawable.location_new);
                mailimg.setImageResource(R.drawable.mailup);
                websiteimg.setImageResource(R.drawable.globe);

            }
        }


        return  view;
    }
}