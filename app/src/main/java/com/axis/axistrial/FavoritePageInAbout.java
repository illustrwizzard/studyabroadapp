package com.axis.axistrial;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.axistrial.R;

import java.util.ArrayList;


public class FavoritePageInAbout extends Fragment {
    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;
    AdapterForFav adapter;
    ArrayList<UnvdataClass>arrayListUnv;
    SQLDB sqldb;







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_favorite_page_in_about, container, false);
        recyclerView=view.findViewById(R.id.savefav);
        sqldb=new SQLDB(getContext());
        arrayListUnv=new ArrayList<>();
        arrayListUnv=sqldb.getuniv_details_bookmark();
        AsyncTaskb asyncTask=new AsyncTaskb();
        asyncTask.execute();


        linearLayoutManager=new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(linearLayoutManager);
        adapter=new AdapterForFav(getContext(),arrayListUnv);

        recyclerView.setAdapter(adapter);


        return view;
    }

    class    AsyncTaskb extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... voids) {

            sqldb.getWritableDatabase().execSQL("insert into univ_details_bookmark1 select * from  univ_details_bookmark ");
            sqldb.getWritableDatabase().execSQL("insert into affiliation_bookmark1 select * from  affiliation_bookmark ");
            sqldb.getWritableDatabase().execSQL("insert into facility_bookmark1 select * from  facility_bookmark ");
            sqldb.getWritableDatabase().execSQL("insert into ranking_bookmark1 select * from  ranking_bookmark ");
            sqldb.getWritableDatabase().execSQL("insert into unv_feed_bookmark1 select * from  unv_feed_bookmark ");
            sqldb.getWritableDatabase().execSQL("insert into unv_procedure_bookmark1 select * from  unv_procedure_bookmark ");
            sqldb.getWritableDatabase().execSQL("insert into unv_accom_bookmark1 select * from  unv_accom_bookmark ");

            return null;
        }
    }

}