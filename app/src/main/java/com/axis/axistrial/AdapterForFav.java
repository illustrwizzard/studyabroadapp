package com.axis.axistrial;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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

public class AdapterForFav extends RecyclerView.Adapter<AdapterForFav.viewholder>{
    LayoutInflater inflater;
    Context context;
    ArrayList<UnvdataClass> unvdetails;
    String unv_name;
    SQLDB sqldb;
    Intent i;
    String university_name;

    public AdapterForFav(Context ctx, ArrayList<UnvdataClass> unvdetailss) {
        this.inflater=LayoutInflater.from(ctx);
        context=ctx;
        unvdetails=unvdetailss;
    }

    @NonNull
    @Override
    public AdapterForFav.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.recyclefor_saveunv,parent,false);
        i=new Intent(context,LoadingActivity.class);
        sqldb= new SQLDB(context);
        return new viewholder(view);
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
    public void onBindViewHolder(@NonNull AdapterForFav.viewholder holder, @SuppressLint("RecyclerView") int position) {


        holder.unvTitle.setText(unvdetails.get(position).getUniversity_name());
        holder.unvLocation.setText(unvdetails.get(position).getCity());
        holder.unvEstd.setText(unvdetails.get(position).getEstablished());
        holder.unvRating.setText(unvdetails.get(position).getRating());
       // holder.linuniversity.setTag(unvdetails.get(position).getUniversity_name());
        holder.saveunv.setTag(unvdetails.get(position).getUniversity_name());

        Glide.with(context).load(unvdetails.get(position).getLogo()).centerInside().into(holder.unvImg);
        unv_name=unvdetails.get(position).getUniversity_name();


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                i.putExtra("univ_name_bookmark",unvdetails.get(position).getUniversity_name());
                i.putExtra("deleted_bookmark",unvdetails.get(position).getUniversity_name());

                v.getContext().startActivity(i);

            }
        });






        holder.saveunv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.saveunv.setImageResource(R.drawable.bookmark2);
                university_name=unvdetails.get(position).getUniversity_name();

                    delete_unique_bookmark(university_name);

            }
        });


    }




    @Override
    public int getItemCount() {
        return unvdetails.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        TextView unvTitle,unvLocation,unvEstd,unvRating;
        ImageView unvImg,saveunv;
        Button aboutbutton;

        public viewholder(@NonNull View itemView) {
            super(itemView);


            aboutbutton=itemView.findViewById(R.id.inbutton1);
            unvTitle=itemView.findViewById(R.id.unvTitle1);
            unvLocation=itemView.findViewById(R.id.unvLocation1);
            unvEstd=itemView.findViewById(R.id.unvESTD1);
            unvRating=itemView.findViewById(R.id.unvRating1);
            unvImg=itemView.findViewById(R.id.circleimg_inUnv111);
            saveunv=itemView.findViewById(R.id.save_unv1);
        }
    }
}
