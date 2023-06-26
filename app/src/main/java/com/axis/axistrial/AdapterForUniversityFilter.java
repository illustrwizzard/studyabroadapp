package com.axis.axistrial;

import android.annotation.SuppressLint;
import android.content.Intent;
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

public class AdapterForUniversityFilter extends RecyclerView.Adapter<AdapterForUniversityFilter.ViewHolder>{

    LayoutInflater inflater;
    FromUniversityFilter context;
    ArrayList<UnvdataClass> unvdetails;

    String unv_name,university_namey;

    public AdapterForUniversityFilter(FromUniversityFilter context, ArrayList<UnvdataClass> unvdetails) {
        this.inflater=LayoutInflater.from(context);
        this.context = context;
        this.unvdetails = unvdetails;

    }


    @NonNull
    @Override
    public AdapterForUniversityFilter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.university_recyclefilter,parent,false);
       // sqldb=new SQLDB(context);


        return new ViewHolder(view);
    }








    @Override
    public void onBindViewHolder(@NonNull AdapterForUniversityFilter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.unvTitle.setText(unvdetails.get(position).getUniversity_name());
        holder.unvLocation.setText(unvdetails.get(position).getCity());
        holder.unvEstd.setText(unvdetails.get(position).getEstablished());
        holder.unvRating.setText(unvdetails.get(position).getRating());
        holder.linuniversity.setTag(unvdetails.get(position).getUniversity_name());
        holder.saveunv.setTag(unvdetails.get(position).getUniversity_name());
        Glide.with(context).load(unvdetails.get(position).getLogo()).centerInside().into(holder.unvImg);
        unv_name=unvdetails.get(position).getUniversity_name();
       // get_filter_course();


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,LoadingActivity.class);

//////////////////////////////////////////////////////////////////////////////////////////////////

                i.putExtra("univ_name",unvdetails.get(position).getUniversity_name());
                i.putExtra("fromunvfilter","unv");
                // i.putExtra("univ_rank",arrayListRank);


                v.getContext().startActivity(i);
//////////////////////////////////////////////////////////////////////////////////////////////////

            }
        });




    }

    @Override
    public int getItemCount() {
        return unvdetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView unvTitle,unvLocation,unvEstd,unvRating;
        ImageView unvImg,saveunv;
        Button aboutbutton;
        LinearLayout linuniversity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            aboutbutton=itemView.findViewById(R.id.inbutton2);
            unvTitle=itemView.findViewById(R.id.unvTitle2);
            unvLocation=itemView.findViewById(R.id.unvLocation2);
            unvEstd=itemView.findViewById(R.id.unvESTD2);
            unvRating=itemView.findViewById(R.id.unvRating2);
            unvImg=itemView.findViewById(R.id.circleimg_inUnv12);
            linuniversity=itemView.findViewById(R.id.linerainuniversity2);
            saveunv=itemView.findViewById(R.id.save_unv2);

        }
    }
}
