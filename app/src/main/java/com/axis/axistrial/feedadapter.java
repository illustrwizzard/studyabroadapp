package com.axis.axistrial;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.axistrial.R;

import java.util.ArrayList;

public class feedadapter extends RecyclerView.Adapter<feedadapter.ViewHolder> {

    ArrayList<Unv_Feed> unidata;
    Context cc1;
    String from;


    public feedadapter(Context context, ArrayList<Unv_Feed> feedarray,String from) {
        cc1=context;
        this.unidata=feedarray;
        this.from=from;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_for_feed_tab_in_university,parent,false);
       return new ViewHolder(v);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.t1.setText((Html.fromHtml(unidata.get(position).getUniversity_name())));
       holder.t2.setText((Html.fromHtml(unidata.get(position).getFeed())));
        Log.w("TTT",unidata.get(position).getFeed());
        Glide.with(cc1).load(unidata.get(position).getFeed_image()).into(holder.img1);
        holder.r1.setTag(unidata.get(position).getFeed());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(from.equals("book_mark_deleted")){
                    Log.w(".....Entered.. Entered ","lllllllll");
                    Intent i=new Intent(cc1,FeedDisplayActivity.class);
                    i.putExtra("feedname", unidata.get(position).getFeed());
                    i.putExtra("from_where",from);
                    v.getContext().startActivity(i);

                }else{
                    Intent i=new Intent(cc1,FeedDisplayActivity.class);
                    i.putExtra("feedname", unidata.get(position).getFeed());
                    i.putExtra("from_where",from);
                    v.getContext().startActivity(i);

                }

            }
        });





    }

    @Override
    public int getItemCount() {
        return unidata.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView t1,t2;
        ImageView img1;
        RelativeLayout r1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 =itemView.findViewById(R.id.txtuniversityname);
            t2 =itemView.findViewById(R.id.txtuniversitydis);
            img1 = itemView.findViewById(R.id.imguni);
            r1=itemView.findViewById(R.id.feedlay_id);
        }
    }
}
