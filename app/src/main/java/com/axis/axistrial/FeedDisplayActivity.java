package com.axis.axistrial;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.axistrial.R;

import java.util.ArrayList;

public class FeedDisplayActivity extends AppCompatActivity {
    TextView feedtext,feedunv;
    ImageView feedimg,backbutton_inFeed;
    ArrayList<Unv_Feed>arrayList;
    SQLDB sqldb;
    String feedname;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_display);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        }
        feedimg=findViewById(R.id.inside_feed_image);
        feedtext=findViewById(R.id.inside_feed_text);
        feedunv=findViewById(R.id.inside_feed_unv);
        backbutton_inFeed=findViewById(R.id.backbutton_inFeed);
        backbutton_inFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
        Bundle extra=getIntent().getExtras();
        feedname=extra.getString("feedname");
        sqldb=new SQLDB(this);
        arrayList=new ArrayList<>();
        if(extra.getString("from_where").equals("book_mark")){

            arrayList=sqldb.get_feed_details_bookmark(feedname);
            feedunv.setText(arrayList.get(0).getUniversity_name());
            feedtext.setText((Html.fromHtml(arrayList.get(0).getFeed(), Html.FROM_HTML_MODE_LEGACY)));
            feedtext.setMovementMethod(LinkMovementMethod.getInstance());
            Glide.with(this).load(arrayList.get(0).getFeed_image()).into(feedimg);
        }else if(extra.getString("from_where").equals("book_mark_deleted")){

            arrayList=sqldb.get_feed_details_bookmark1(feedname);
            feedunv.setText(arrayList.get(0).getUniversity_name());
            feedtext.setText((Html.fromHtml(arrayList.get(0).getFeed(), Html.FROM_HTML_MODE_LEGACY)));
            feedtext.setMovementMethod(LinkMovementMethod.getInstance());
            Glide.with(this).load(arrayList.get(0).getFeed_image()).into(feedimg);



        } else {

            arrayList=sqldb.get_feed_details(feedname);
            feedunv.setText(arrayList.get(0).getUniversity_name());
            feedtext.setText((Html.fromHtml(arrayList.get(0).getFeed(), Html.FROM_HTML_MODE_LEGACY)));
            feedtext.setMovementMethod(LinkMovementMethod.getInstance());
            Glide.with(this).load(arrayList.get(0).getFeed_image()).into(feedimg);
        }





    }
}