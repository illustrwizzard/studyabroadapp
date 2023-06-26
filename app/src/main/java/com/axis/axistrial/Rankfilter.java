package com.axis.axistrial;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.axistrial.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Rankfilter extends Fragment {
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<UnvdataClass> arrayList;
    ArrayList<String> arrayList1;
    SQLDB sqldb;
    Set<String> set;
    ArrayList<String> list;
    HashMap<String,String > Rating_map;
    Intent i;
    String ratingtemp1="";

    String Rating_values="";




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_rankfilter, container, false);
        sqldb=new SQLDB(getContext());
        Rating_map= new HashMap<>();
        arrayList=new ArrayList<>();
       arrayList=sqldb.getuniv_details();
       arrayList1=new ArrayList<>();
       for (int i=0;i<arrayList.size();i++){
           arrayList1.add(arrayList.get(i).getRating());
       }

        set = new HashSet<>();
        list= new ArrayList<>();

        for(int i = 0;i<arrayList1.size();i++){

            set.add(arrayList1.get(i));

        }
        list.addAll(set);






        listView=view.findViewById(R.id.listview_filter);
        adapter=new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_multiple_choice, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String rating= (String) parent.getItemAtPosition(position);
                String ratingtemp="";

                if(Rating_map.containsKey(rating)){
                    Rating_map.remove(rating);
                }else{

                Rating_map.put(rating,rating +",");}
                Log.w("kssaaaaaaaaaaaaaa", String.valueOf(Rating_map.size()));
                for(String x:Rating_map.values()){
                    ratingtemp=ratingtemp+x;
                }
                ratingtemp1=ratingtemp;



                Log.w("sizwwwwwwwwwwww",ratingtemp);


                Toast.makeText(getContext(),rating, Toast.LENGTH_SHORT).show();
//                Intent i=new Intent();
//                i.putExtra()
            }

        });




        return view;
    }



}