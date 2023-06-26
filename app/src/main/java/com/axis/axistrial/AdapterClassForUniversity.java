package com.axis.axistrial;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.CursorIndexOutOfBoundsException;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.axistrial.R;


import java.util.ArrayList;

public class AdapterClassForUniversity extends RecyclerView.Adapter<AdapterClassForUniversity.ViewHolder> {
    LayoutInflater inflater;
    FirstPageInsideUniversity context;
    ArrayList<UnvdataClass> unvdetails;
    String university_name;
   String unv_name;
   SQLDB sqldb;


    public AdapterClassForUniversity(FirstPageInsideUniversity ctx, ArrayList<UnvdataClass> unvdetailss){
        this.inflater=LayoutInflater.from(ctx);
        context=ctx;
        unvdetails=unvdetailss;


    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=inflater.inflate(R.layout.universityrecycle,parent,false);
        sqldb=new SQLDB(context);

        return new ViewHolder(view);
    }

    public void delete_unique_bookmark(String university_name){

        sqldb.getWritableDatabase().execSQL("delete from univ_details_bookmark where university_name in ("+'"'+university_name+'"'+")");

        sqldb.getWritableDatabase().execSQL("delete from university_fees_bookmark where university_name in ("+'"'+university_name+'"'+")");

        sqldb.getWritableDatabase().execSQL("delete from affiliation_bookmark where university_name in ("+'"'+university_name+'"'+")");

        sqldb.getWritableDatabase().execSQL("delete from facility_bookmark where university_name in ("+'"'+university_name+'"'+")");

        sqldb.getWritableDatabase().execSQL("delete from ranking_bookmark where university_name in ("+'"'+university_name+'"'+")");

        sqldb.getWritableDatabase().execSQL("delete from unv_accom_bookmark where university_name in ("+'"'+university_name+'"'+")");

        sqldb.getWritableDatabase().execSQL("delete from unv_feed_bookmark where university_name in ("+'"'+university_name+'"'+")");

        sqldb.getWritableDatabase().execSQL("delete from unv_procedure_bookmark where university_name in ("+'"'+university_name+'"'+")");


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {


        holder.unvTitle.setText(unvdetails.get(position).getUniversity_name());
        holder.unvLocation.setText(unvdetails.get(position).getCity());
        holder.unvEstd.setText(unvdetails.get(position).getEstablished());
        holder.unvRating.setText(unvdetails.get(position).getRating());
        holder.linuniversity.setTag(unvdetails.get(position).getUniversity_name());
        holder.saveunv.setTag(unvdetails.get(position).getUniversity_name());
        Glide.with(context).load(unvdetails.get(position).getLogo()).centerInside().into(holder.unvImg);
        unv_name=unvdetails.get(position).getUniversity_name();
        //get_filter_course();
        int countvalue;
        countvalue= sqldb.count_UniversityDetails_bookmark(unvdetails.get(position).getUniversity_name());
        Log.w("INSIDE ADAP UNIVNAME",unvdetails.get(position).getUniversity_name());
        if (countvalue>0){
            Log.w("Enterd COUNT", String.valueOf(countvalue));

            holder.saveunv.setImageResource(R.drawable.bookmark1);


        }else{
            holder.saveunv.setImageResource(R.drawable.bookmark3);
        }

        holder.saveunv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                university_name=unvdetails.get(position).getUniversity_name();
                int countvalue;
                countvalue= sqldb.count_UniversityDetails_bookmark(unvdetails.get(position).getUniversity_name());
             if (countvalue>0){

                    holder.saveunv.setImageResource(R.drawable.bookmark3);


                    delete_unique_bookmark(university_name);

                }else{
                    // checkBookmark=true;
                 holder.saveunv.setImageResource(R.drawable.bookmark1);

               AsyncTask2 asyncTask=new AsyncTask2();
                    asyncTask.execute();


                }
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,LoadingActivity.class);

                    i.putExtra("univ_name",unvdetails.get(position).getUniversity_name());

                    v.getContext().startActivity(i);


            }
        });


    }
    class    AsyncTask2 extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... voids) {

            sqldb.getWritableDatabase().execSQL("insert into univ_details_bookmark select * from  univ_details group by university_name having  university_name in ("+'"'+university_name+'"'+")");
            sqldb.getWritableDatabase().execSQL("insert into affiliation_bookmark select * from  affiliation where university_name in ("+'"'+university_name+'"'+")");
            sqldb.getWritableDatabase().execSQL("insert into facility_bookmark select * from  facility where university_name in ("+'"'+university_name+'"'+")");
            sqldb.getWritableDatabase().execSQL("insert into ranking_bookmark select * from  ranking where university_name in ("+'"'+university_name+'"'+")");
            sqldb.getWritableDatabase().execSQL("insert into unv_feed_bookmark select * from  unv_feed where university_name in ("+'"'+university_name+'"'+")");
            sqldb.getWritableDatabase().execSQL("insert into unv_procedure_bookmark select * from  unv_procedure where university_name in ("+'"'+university_name+'"'+")");
            sqldb.getWritableDatabase().execSQL("insert into unv_accom_bookmark select * from  unv_accom where university_name in ("+'"'+university_name+'"'+")");

            return null;
        }
    }

    @Override
    public int getItemCount() {
        return unvdetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        TextView unvTitle,unvLocation,unvEstd,unvRating;
        ImageView unvImg,saveunv;
        Button aboutbutton;
        LinearLayout linuniversity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            aboutbutton=itemView.findViewById(R.id.inbutton);
            unvTitle=itemView.findViewById(R.id.unvTitle);
            unvLocation=itemView.findViewById(R.id.unvLocation);
            unvEstd=itemView.findViewById(R.id.unvESTD);
            unvRating=itemView.findViewById(R.id.unvRating);
            unvImg=itemView.findViewById(R.id.circleimg_inUnv1);
            linuniversity=itemView.findViewById(R.id.linerainuniversity);
            saveunv=itemView.findViewById(R.id.save_unv);

        }

    }

}