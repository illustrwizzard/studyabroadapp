package com.axis.axistrial;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.example.axistrial.R;

import java.util.ArrayList;


public class InsideUniversityAccommodationTab extends Fragment {


    ArrayList<Un_Accomodation> arrayListAcc,arrayListaccomm;
    GridLayout gridLayout;
    String university_name;
    RecyclerView recyclerView;
    String gtett;
    String from;
    public InsideUniversityAccommodationTab( String university_name,String from) {
        this.university_name=university_name;
        this.from=from;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SQLDB sqldb =new SQLDB(getContext());
//        arrayListAcc= new ArrayList<>();
//        arrayListAcc=sqldb.getUnvAccomodation_single(university_name);
        arrayListaccomm=new ArrayList<>();
        if(from.equals("book_mark")){
            arrayListaccomm=sqldb.get_unvAcc_bookmark(university_name);
        }else if(from.equals("book_mark_deleted")){

            arrayListaccomm=sqldb.get_unvAcc_bookmark1(university_name);

        }



        else{
            arrayListaccomm=sqldb.get_unvAcc(university_name);
        }


        Log.w("size  accomodationarray", String.valueOf(arrayListaccomm.size()));


        Log.w("universityNamename",university_name);
        for (int i=0;i<arrayListaccomm.size();i++){
            Log.w("first data ", String.valueOf(arrayListaccomm.get(i).getHst_name()));

        }


        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.inside_university_accommodation_tab, container, false);
        gridLayout=view.findViewById(R.id.gridlayout_in_acc_university);
        recyclerView=view.findViewById(R.id.recyclerview_in_accomodation_page);


        if (arrayListaccomm!=null){
        AdapterforAccomodationUniversity accomodationUniversity=new AdapterforAccomodationUniversity(container.getContext(),arrayListaccomm);

        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        recyclerView.setAdapter(accomodationUniversity);
        }
        Log.w("ennnnnnnnn","ennnnterd");

        return view;

    }
}