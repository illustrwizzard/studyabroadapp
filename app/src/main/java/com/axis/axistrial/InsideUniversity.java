package com.axis.axistrial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.database.CursorIndexOutOfBoundsException;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.axistrial.R;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class InsideUniversity extends AppCompatActivity {

    String url="https://app.axisjobs.in/api/university";
    String urluvn_filter="https://axisoverseascareers.in/api/university/filter";
    ArrayList<UnvdataClass> arrayList,arraydetails;
    TextView TXT1,TXT2,TXT3,gotowebid;
    Boolean checkBookmark=false,delete_bookmark=false;
    String from;

    String from2;
    TextView unv_name;
    String university_name, Course_id;
    ArrayList<UnivRank>arrayListRanking;
    ArrayList<String>RankArray;
    ArrayList<UnivAff> arrayListaffli;
    ArrayList<UnivFac> arrayfacility;
    ArrayList<Unv_Feed>arrayListFeed;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    SQLDB sqldb;
    CircleImageView imgTitle;
    ImageView imageBanner;
    ImageView save_unv1;
    ArrayList<DataModelClassForCourse>arrayListcourse_name;
    String course_name;
    int countvalue;
    String from4;



    @Override
    public void onBackPressed() {
        Bundle extra=getIntent().getExtras();
        if(extra.getString("univ_name_bookmark")!=null&extra.getString("univ_name")!=null){

            Intent i = new Intent(getApplicationContext(),BottomNavEx.class);
            startActivity(i);


        }
      else  if(extra.getString("unv_from_course")!=null){

           Log.w("ENTERED FRIST","YP");

            Intent i = new Intent(getApplicationContext(),FirstPageInsideCoursee.class);
            startActivity(i);

        }
       else if (extra.getString("univ_name")!=null){
           Log.w("ENTERED SECOND","YP");
            Intent i = new Intent(getApplicationContext(),FirstPageInsideUniversity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }
        else{
           Log.w("ENTERED THIRD","YP");
            finish();
        }

    }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inside_university_about_tab);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        }
        save_unv1=findViewById(R.id.save_unv1);
        sqldb=new SQLDB(this);
        Bundle extra=getIntent().getExtras();


        if(extra.getString("univ_name_bookmark")!=null&extra.getString("deleted")!=null){
            university_name=extra.getString("univ_name_bookmark");
            Course_id = extra.getString("course_id");
            from="book_mark_deleted";
            from2="book_mark_deleted";
            //from4="book_deleted";
            Log.w("univvvvvNAME",university_name);
            setDataInCourse(university_name);


            arraydetails=new ArrayList<>();

            arraydetails=sqldb.getuniv_details_single_bookmark1(university_name);

            Log.w("mmmmmmm44444444mm",arraydetails.get(0).getCountry());

            arrayListRanking=new ArrayList<>();
            arrayListRanking=sqldb.getUnivRanking_single_bookmark1(university_name);



            arrayListaffli=new ArrayList<>();
            arrayListaffli=sqldb.getaffiliation_single_bookmark1(university_name);

            arrayfacility=new ArrayList<>();
            arrayfacility=sqldb.getfacility_single_bookmark1(university_name);
            arrayListFeed=new ArrayList<>();
            arrayListFeed=sqldb.getUnv_Feed_bookmark1(university_name);
            Log.w("arraylistfeed", String.valueOf(arrayListFeed.size()));







            Log.w("its here.........","jjj..................jjjjjj");





        }



       else if(extra.getString("univ_name_bookmark")!=null&extra.getString("univ_name")!=null){
            university_name=extra.getString("univ_name_bookmark");
            Course_id = extra.getString("course_id");
            from="book_mark";
            from2="book_mark";
            Log.w("univvvvvNAME",university_name);
            setDataInCourse(university_name);


            arraydetails=new ArrayList<>();

            arraydetails=sqldb.getuniv_details_single_bookmark(university_name);

            Log.w("mmmmmmmmm",arraydetails.get(0).getCountry());

            arrayListRanking=new ArrayList<>();
            arrayListRanking=sqldb.getUnivRanking_single_bookmark(university_name);



            arrayListaffli=new ArrayList<>();
            arrayListaffli=sqldb.getaffiliation_single_bookmark(university_name);

            arrayfacility=new ArrayList<>();
            arrayfacility=sqldb.getfacility_single_bookmark(university_name);
            arrayListFeed=new ArrayList<>();
            arrayListFeed=sqldb.getUnv_Feed_bookmark(university_name);/////





            Log.w("its here.........","jjj.........hhhhhhhhj");





        }



        else if (extra.getString("univ_name")!=null){
            university_name=extra.getString("univ_name");
            Course_id=extra.getString("course_id");


            from="safe";
            from2="safe";






            arraydetails=new ArrayList<>();

            arraydetails=sqldb.getuniv_details_single(university_name);

            Log.w("mmmmmmmmm666",arraydetails.get(0).getCountry());

            arrayListRanking=new ArrayList<>();
            arrayListRanking=sqldb.getUnivRanking_single(university_name);



            arrayListaffli=new ArrayList<>();
            arrayListaffli=sqldb.getaffiliation_single(university_name);

            arrayfacility=new ArrayList<>();
            arrayfacility=sqldb.getfacility_single(university_name);
            arrayListFeed=new ArrayList<>();
            arrayListFeed=sqldb.getUnv_Feed(university_name);/////NOTED

        }






        imageBanner=findViewById(R.id.imagebannerUnv);




        TXT1=findViewById(R.id.University_name_Title);
        TXT2=findViewById(R.id.location_in_universitytitle);
        TXT3=findViewById(R.id.estd_in_university);
        gotowebid=findViewById(R.id.gotowebid);
        imgTitle=findViewById(R.id.circle_imageView_in_universitytitle);
        Glide.with(this).load(arraydetails.get(0).getLogo()).into(imgTitle);
        Glide.with(this).load(arraydetails.get(0).getBanner()).into(imageBanner);

        TXT1.setText(arraydetails.get(0).getUniversity_name());
        TXT2.setText(arraydetails.get(0).getLocation());
        TXT3.setText(arraydetails.get(0).getEstablished());
        gotowebid.setText(arraydetails.get(0).getWebsite());
        gotowebid.setMovementMethod(LinkMovementMethod.getInstance());


        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tabs);

        ////UNIVERSITY SAVE

        countvalue= sqldb.count_UniversityDetails_bookmark(university_name);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),arraydetails,arrayListaffli,arrayListRanking,arrayfacility,university_name,arrayListFeed,from,from2,checkBookmark,countvalue,from4);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
               viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setDataInCourse(String university_name) {

        RequestQueue que = Volley.newRequestQueue(getApplicationContext());

        StringRequest request = new StringRequest(Request.Method.POST, urluvn_filter, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsn =jsonObject.getJSONArray("university");
                    Log.w("responsedata",response);

                    Log.w("jssonnnnnn",jsn.getJSONObject(0).getJSONArray("university_details").getJSONObject(0).getString("country"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {

                Map<String,String> map=new HashMap<String, String>();
                map.put("unv_name",'"'+university_name+'"');
                map.put("country","");
                map.put("rating","");
                map.put("city","");

                return map;
            }
        };
        que.add(request);





    }



}