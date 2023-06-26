package com.axis.axistrial;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.axistrial.R;

import java.util.ArrayList;


public class InsideUniversityFeedTab extends Fragment {
    ArrayList<Unv_Feed> feedarray;
    RecyclerView recyclerView1;
    String university_name;
    String from;

    public InsideUniversityFeedTab(ArrayList<Unv_Feed> arraydetails, String university_name, String from) {
        this.feedarray=arraydetails;
        this.university_name=university_name;
        this.from=from;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
          Log.w("wwwwggggggg","entergf=");



        View vi= inflater.inflate(R.layout.inside_university_feed_tab, container, false);
        SQLDB sqldb=new SQLDB(getContext());

        recyclerView1=vi.findViewById(R.id.recycler_for_feedtab_in_university);
        if(from.equals("book_mark")){
            feedadapter feedadapter =new feedadapter(container.getContext(), sqldb.getUnv_Feed_bookmark(university_name),from);
            recyclerView1.setAdapter(feedadapter);
            recyclerView1.setLayoutManager(new LinearLayoutManager(container.getContext()));
        }else if(from.equals("book_mark_deleted")){

            feedadapter feedadapter =new feedadapter(container.getContext(), sqldb.getUnv_Feed_bookmark1(university_name),from);
            recyclerView1.setAdapter(feedadapter);
            recyclerView1.setLayoutManager(new LinearLayoutManager(container.getContext()));

        }


        else{
            feedadapter feedadapter =new feedadapter(container.getContext(), sqldb.getUnv_Feed(university_name),from);
            recyclerView1.setAdapter(feedadapter);
            recyclerView1.setLayoutManager(new LinearLayoutManager(container.getContext()));
        }


        return vi;
    }
}