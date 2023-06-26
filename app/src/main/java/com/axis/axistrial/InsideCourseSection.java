package com.axis.axistrial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.axistrial.R;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class InsideCourseSection extends AppCompatActivity {

    ArrayList<DataModelClassForCourse> arrayListtable,arrayList;
    TextView titleheading,titlecollege;
    ImageView titleimage;
    //String urluvn_filter="https://axisoverseascareers.in/api/university/filter";
    String course_name,unv_name,university_name;
    ArrayList<UCourse_fee> arrayListfee;
    ArrayList<UCentrance>arrayListEnterance;
    ArrayList<UCourseeligibilty> arrayListElg;
    ArrayList<UnvdataClass> arrayList_Unv_details;
    ArrayList<Unv_Procedure> arrayList_Unv_Procedure;
    TabLayout tabLayout1;
    ViewPager viewPager1;
    JSONArray jsonArray1,jsonArray6;
    JSONObject jsonObject1,jsonObjectProcedure;
    ViewPagerAdapter1 viewPagerAdapter1;
    SQLDB sqldb;
    String from3;
    String currencysymbol="$";
    String from4;






    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inside_course_section);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }


       sqldb = new SQLDB(this);
        viewPager1 = findViewById(R.id.view_pager1);
        tabLayout1= findViewById(R.id.tabs1);
        titlecollege=findViewById(R.id.collegename_in_course_id);
        titleheading=findViewById(R.id.coursename_inside_course);



        Bundle extra=getIntent().getExtras();
        currencysymbol=extra.getString("currencysymbol1");
        if(extra.getString("book_mark_deleted")!=null) {

            course_name=extra.getString("course_name_2");

            Log.w("inside fggg","insideee boookkk");
            from3="bookmark_deleted";
            from4=extra.getString("book_deleted");

            /// COURSE DETAILS
            arrayListtable=new ArrayList<>();
            arrayListtable=sqldb.getcourse_details_single_course_name(course_name);



            titleheading.setText(arrayListtable.get(0).getCourse_name());
            university_name=arrayListtable.get(0).getUniversity_name();
            Log.w("university namellll",university_name);
            titlecollege.setText(university_name);
            //sendUnvDetails(university_name);


            ///UNV DATACLASS




            /// UNV PROCEDURE

            arrayList_Unv_Procedure=new ArrayList<>();
            arrayList_Unv_Procedure=sqldb.getUnv_Procedure_bookmark1(university_name);



            ////UNIVERSITY Entrance

            arrayListEnterance=new ArrayList<>();
            arrayListEnterance=sqldb.getentrance_single_bookmark1(course_name);

            /// COURSE ELIGIBILITY
            arrayListElg=new ArrayList<>();
            arrayListElg=sqldb.geteligibility_single_bookmark1(course_name);



            ////COURSE FEE

            arrayListfee=new ArrayList<>();
            arrayListfee=sqldb.getcourse_fee_single_bookmark1(course_name);

            unv_name=arrayListtable.get(0).getUniversity_name();

            titleimage=findViewById(R.id.image_in_coursemm);




            arrayList_Unv_details=new ArrayList<>();
            arrayList_Unv_details=sqldb.getUnv_singledetails_bookmark1(university_name);

        }


       else  if(extra.getString("book_mark")!=null) {

            course_name=extra.getString("course_name_2");

       Log.w("inside fggg","insideee boookkk");
       from3="bookmark";

            /// COURSE DETAILS
            arrayListtable=new ArrayList<>();
            arrayListtable=sqldb.getcourse_details_single_course_name(course_name);



            titleheading.setText(arrayListtable.get(0).getCourse_name());
            university_name=arrayListtable.get(0).getUniversity_name();
            Log.w("university namellll",university_name);
            titlecollege.setText(university_name);
            //sendUnvDetails(university_name);


            ///UNV DATACLASS




            /// UNV PROCEDURE

            arrayList_Unv_Procedure=new ArrayList<>();
            arrayList_Unv_Procedure=sqldb.getUnv_Procedure_bookmark(university_name);



            ////UNIVERSITY Entrance

            arrayListEnterance=new ArrayList<>();
            arrayListEnterance=sqldb.getentrance_single(course_name);

            /// COURSE ELIGIBILITY
            arrayListElg=new ArrayList<>();
            arrayListElg=sqldb.geteligibility_single(course_name);



            ////COURSE FEE

            arrayListfee=new ArrayList<>();
            arrayListfee=sqldb.getcourse_fee_single(course_name);

            unv_name=arrayListtable.get(0).getUniversity_name();

            titleimage=findViewById(R.id.image_in_coursemm);




            arrayList_Unv_details=new ArrayList<>();
            arrayList_Unv_details=sqldb.getUnv_singledetails_bookmark(university_name);

        } else{
            course_name=extra.getString("course_name");
            Log.w("course_nameeeee",course_name);

           from3="safe";



            /// COURSE DETAILS
            arrayListtable=new ArrayList<>();
            arrayListtable=sqldb.getcourse_details_single_course_name(course_name);
            if (arrayListtable.get(0).getCourse_name()!=null){
                titleheading.setText(arrayListtable.get(0).getCourse_name());


            }
            university_name=arrayListtable.get(0).getUniversity_name();

            if (arrayListtable.get(0).getUniversity_name()!=null){
                Log.w("university namellll",university_name);
                titlecollege.setText(university_name);


            }






            //sendUnvDetails(university_name);


            ///UNV DATACLASS




            /// UNV PROCEDURE

            arrayList_Unv_Procedure=new ArrayList<>();
            arrayList_Unv_Procedure=sqldb.getUnv_Procedure(university_name);



            ////UNIVERSITY Entrance

            arrayListEnterance=new ArrayList<>();
            arrayListEnterance=sqldb.getentrance_single(course_name);

            /// COURSE ELIGIBILITY
            arrayListElg=new ArrayList<>();
            arrayListElg=sqldb.geteligibility_single(course_name);



            ////COURSE FEE

            arrayListfee=new ArrayList<>();
            arrayListfee=sqldb.getcourse_fee_single(course_name);
            if (arrayListtable.get(0).getUniversity_name()!=null){
                unv_name=arrayListtable.get(0).getUniversity_name();

            }



            titleimage=findViewById(R.id.image_in_coursemm);




            arrayList_Unv_details=new ArrayList<>();
            arrayList_Unv_details=sqldb.getUnv_singledetails(university_name);
        }


        Log.w("ummuuummmuummmu",university_name);
        Log.w("yyyyyyyyyyyyyyyy", String.valueOf(arrayList_Unv_details.size()));
        if(arrayList_Unv_details.get(0).getBanner()!=null){
            Glide.with(this).load(arrayList_Unv_details.get(0).getBanner()).into(titleimage);

        }

       
     





        viewPagerAdapter1 = new ViewPagerAdapter1(getSupportFragmentManager(),arrayListtable,arrayListfee,arrayListEnterance,arrayListElg,course_name,university_name,arrayList_Unv_details,arrayList_Unv_Procedure,from3,currencysymbol,from4);
        viewPager1.setAdapter(viewPagerAdapter1);
        viewPager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));
        tabLayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager1.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });
        tabLayout1.setupWithViewPager(viewPager1);




    }








    public void getadmissionCourse(View view) {
      Intent i=new Intent(InsideCourseSection.this,GetAdmissionEx.class);
      i.putExtra("unvname",unv_name);
      i.putExtra("coursename",course_name);
      startActivity(i);

    }
    public void clickinuniversity(View v){
        //v.getTag();
        Intent i=new Intent(getApplicationContext(),InsideUniversity.class);
        i.putExtra("univ_name", unv_name);
        //i.putExtra("course_name",course_name);
        startActivity(i);


    }
}