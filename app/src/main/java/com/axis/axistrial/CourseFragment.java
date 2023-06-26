package com.axis.axistrial;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.axistrial.R;
import com.squareup.picasso.Picasso;


public class CourseFragment extends Fragment {
    ImageView courseimg,unimg,onlineimg;
    CardView coursecard,universitycard,onlinecardview;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.course_fragment, container, false);
        courseimg=view.findViewById(R.id.courseTitleimg);
        unimg=view.findViewById(R.id.universityTitleimg);
        onlineimg=view.findViewById(R.id.OnlineTitleimg);
        onlinecardview=view.findViewById(R.id.upcomingonlinecourseid);
        onlinecardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Available Soon", Toast.LENGTH_SHORT).show();
            }
        });

        String imageUri = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSG_hqEQ-ZCT-rGtOSajeJA7sT5cDvKkcGBtA&usqp=CAU";
        Picasso.get().load(imageUri).into(courseimg);

        String imageUri1 = "https://media.istockphoto.com/photos/historic-college-building-in-cambridge-united-kingdom-picture-id611591082?k=20&m=611591082&s=612x612&w=0&h=pkHJpOSVs0Oddivkaxrs7NO2Y2dC9nP93yJ6_UV0Om0=";
        Picasso.get().load(imageUri1).into(unimg);

        String imageUri2 = "https://media.istockphoto.com/photos/student-learning-at-home-with-online-lesson-picture-id1213470238?k=20&m=1213470238&s=612x612&w=0&h=L6Qd9gO4769vCgkF9ah-mj24RttnTw2oDGRPfozbk2k=";
        Picasso.get().load(imageUri2).into(onlineimg);





        coursecard=view.findViewById(R.id.course_card_id);
        universitycard=view.findViewById(R.id.university_card_id);

        universitycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),FirstPageInsideUniversity.class);
                startActivity(intent);
            }
        });
        coursecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getContext(),FirstPageInsideCoursee.class);
                startActivity(i);

            }
        });
        return view;
    }
}