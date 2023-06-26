package com.axis.axistrial;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.axistrial.R;


public class AboutpageInAbout extends Fragment {
    Button gotoeduDetails,gotoworkDetails;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_account_about, container, false);
        gotoeduDetails=view.findViewById(R.id.gotoeduDetails_id);
        gotoworkDetails=view.findViewById(R.id.gotoworkDetails_id);


        gotoeduDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),EducationDetailsInAbout.class);
                startActivity(i);

            }
        });

        gotoworkDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getContext(),WorkDetailsInAbout.class);
                startActivity(in);

            }
        });


        return  view;
    }
}