package com.axis.axistrial;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.axistrial.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import de.hdodenhof.circleimageview.CircleImageView;

public class FirstPageInsideCoursee extends AppCompatActivity {
    CircleImageView selectflag;
    ImageView immmm,fliterimg;
    View view;
    int flag=0;
    ArrayAdapter<String> adapter;
    String urluvn_filter="https://axisoverseascareers.in/api/university/filter";
    String url="https://axisoverseascareers.in/api/course";
    RecyclerView recyclerView;
    JSONArray jsonArray2,jsonArray3,jsonArray4,jsonArray5,jsonArray6,jsonArrayEnt,jsonArrayElg,jsonArrayCfee;
    ArrayList<DataModelClassForCourse> arrayListcourse,arrayListcourseSearch;
    ArrayList<String>arrayListtable;
    AdapterclassForCourse adapterclassForCourse;
    JSONObject jsonObjectcourse,jsonObjectunv,jsonObjectProcedurey,jsonObject1y;
    LinearLayoutManager linearLayoutManager;
    ArrayList<String > arrayList;
    ArrayList<DataModelClassForCourse>arrayListF;
    JSONArray jsonArraycourse,jsonArrayunv,jsonArray6y,jsonArray1y;
    SQLDB sqldb;
    ProgressBar pg1;
    View progressBar;
    SwipeRefreshLayout swipeRefreshLayout;
    ArrayList<UnvdataClass>arrayListUnv;
    RelativeLayout blurlayout;
    int Totalchild,current,showing,totalget,jsonsize;
    Boolean isscrolling=false,fill=true,set1=false,flagrefresh=true,insidefilter=false;
    ArrayList<String> list;
    Set<String> set;
    Button search_button1;
    AutoCompleteTextView autoCompleteTextView;
    String university_namey;


    ArrayList<UnvdataClass>arrayListSearch;
    ArrayList<String>arrayListfacility;
    ArrayList<String>arrayListAffliation;
    ArrayList<String>arrayListProcedure;
    ArrayList<String>arrayListFeed;
    ArrayList<String> arrayListRank;
    ArrayList<String>arrayListAccomodation;
    JSONArray jsonArray1;
    JSONArray jsonAccom,jsonInAccom;
    JSONObject jsonObject1,jsonobject2,jsonobject3,jsonobject4,jsonobject5,jsonobject6,jsonObject7,jsonObjectFeed,jsonObjectProcedure,jsonObjectAccom,jsonObjectInAccom;

    String urluvn_filter_course_name="https://axisoverseascareers.in/api/course/filter_coursename";
    String url_coursename="https://axisoverseascareers.in/api/course/course_name";
    String course_name;
    int count;
    CircleImageView circleImageViewup;
    JSONObject currencyobj;
    String currencyvalue;
    ArrayList<String> currencyval;

    @Override
    public void onBackPressed() {
        Intent i=new Intent(FirstPageInsideCoursee.this,BottomNavEx.class);
        startActivity(i);

    }



    public   void getall_course_name(){
        RequestQueue que = Volley.newRequestQueue(getApplicationContext());
        StringRequest request =  new StringRequest(Request.Method.POST, url_coursename, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsn = jsonObject.getJSONArray("course_name");
                    for(int i = 0 ;i<jsn.length();i++){


                        set.add(jsn.getJSONObject(i).getString("course_name"));

                    }
                    list.addAll(set);
                    adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        que.add(request);


    }






    public void set_course_search(String courseid)  {
        RequestQueue que = Volley.newRequestQueue(getApplicationContext());
        arrayListcourse.clear();

        StringRequest request = new StringRequest(Request.Method.POST, urluvn_filter_course_name, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.w("new responseee",response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsn =jsonObject.getJSONArray("course");
                    for(int i = 0;i<jsn.length();i++){
                        jsonObjectcourse = jsn.getJSONObject(i);
                        jsonArrayunv= jsonObjectcourse.getJSONArray("university");
                        sqldb.insertcourse_details(jsonObjectcourse.getJSONArray("university").getJSONObject(0).getString("university_name"),jsonObjectcourse.getString("course_name"),
                                jsonObjectcourse.getString("course"),jsonObjectcourse.getString("year"),jsonObjectcourse.getString("time"),
                                jsonObjectcourse.getString("total_fee"),jsonObjectcourse.getString("syllabus"));


                        // temp=temp+jsonObjectcourse.getString("course_id")+",";

                        university_namey=jsonObjectcourse.getJSONArray("university").getJSONObject(0).getString("university_name");
                        Log.w("universitynameyyyyy",university_namey);
                        sendUnvDetails(university_namey);




                        //////// course_feeeee
                        jsonArrayCfee= jsonObjectcourse.getJSONArray("course_fee");
                        arrayList=new ArrayList<>();
                        for(int l =0;l<jsonArrayCfee.length();l++){
                            arrayList.add(jsonArrayCfee.getJSONObject(l).getString("term"));
                            arrayList.add(jsonArrayCfee.getJSONObject(l).getString("fee_head"));
                            arrayList.add(jsonArrayCfee.getJSONObject(l).getString("amount"));

                        }


                        if(arrayList.size()==30){
                            sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)
                                    ,arrayList.get(6), arrayList.get(7),arrayList.get(8), arrayList.get(9),arrayList.get(10), arrayList.get(11),arrayList.get(12), arrayList.get(13),arrayList.get(14), arrayList.get(15),arrayList.get(16), arrayList.get(17)
                                    ,arrayList.get(18), arrayList.get(19),arrayList.get(20), arrayList.get(21),arrayList.get(22), arrayList.get(23),arrayList.get(24), arrayList.get(25),arrayList.get(26), arrayList.get(27),arrayList.get(28), arrayList.get(29)
                            );
                        }
                        else  if(arrayList.size()==27){
                            sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)
                                    ,arrayList.get(6), arrayList.get(7),arrayList.get(8), arrayList.get(9),arrayList.get(10), arrayList.get(11),arrayList.get(12), arrayList.get(13),arrayList.get(14), arrayList.get(15),arrayList.get(16), arrayList.get(17)
                                    ,arrayList.get(18), arrayList.get(19),arrayList.get(20), arrayList.get(21),arrayList.get(22), arrayList.get(23),arrayList.get(24), arrayList.get(25),arrayList.get(26));

                        }
                        else  if(arrayList.size()==24){
                            sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)
                                    ,arrayList.get(6), arrayList.get(7),arrayList.get(8), arrayList.get(9),arrayList.get(10), arrayList.get(11),arrayList.get(12), arrayList.get(13),arrayList.get(14), arrayList.get(15),arrayList.get(16), arrayList.get(17)
                                    ,arrayList.get(18), arrayList.get(19),arrayList.get(20), arrayList.get(21),arrayList.get(22), arrayList.get(23));

                        }
                        else  if(arrayList.size()==21){
                            sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)
                                    ,arrayList.get(6), arrayList.get(7),arrayList.get(8), arrayList.get(9),arrayList.get(10), arrayList.get(11),arrayList.get(12), arrayList.get(13),arrayList.get(14), arrayList.get(15),arrayList.get(16), arrayList.get(17)
                                    ,arrayList.get(18), arrayList.get(19),arrayList.get(20));

                        }
                        else  if(arrayList.size()==18){
                            sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)
                                    ,arrayList.get(6), arrayList.get(7),arrayList.get(8), arrayList.get(9),arrayList.get(10), arrayList.get(11),arrayList.get(12), arrayList.get(13),arrayList.get(14), arrayList.get(15),arrayList.get(16), arrayList.get(17)
                            );

                        }
                        else  if(arrayList.size()==15){
                            sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)
                                    ,arrayList.get(6), arrayList.get(7),arrayList.get(8), arrayList.get(9),arrayList.get(10), arrayList.get(11),arrayList.get(12), arrayList.get(13),arrayList.get(14)
                            );

                        }
                        else  if(arrayList.size()==12){
                            sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)
                                    ,arrayList.get(6), arrayList.get(7),arrayList.get(8), arrayList.get(9),arrayList.get(10), arrayList.get(11)
                            );

                        }
                        else  if(arrayList.size()==9){
                            sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)
                                    ,arrayList.get(6), arrayList.get(7),arrayList.get(8)
                            );

                        }
                        else  if(arrayList.size()==6){
                            sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)

                            );

                        }
                        else  if(arrayList.size()==3){
                            sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2)

                            );

                        }else {
                            sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"));
                        }





                        /////ENTRANCE

                        jsonArrayEnt= jsonObjectcourse.getJSONArray("entrance");
                        arrayList=new ArrayList<>();
                        for(int l =0;l<jsonArrayEnt.length();l++){
                            arrayList.add(jsonArrayEnt.getJSONObject(l).getString("exam_name"));


                        }


                        if(arrayList.size()==6){
                            sqldb.insertenterance(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3),arrayList.get(4),arrayList.get(5));
                        }else if(arrayList.size()==5){
                            sqldb.insertenterance(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3),arrayList.get(4));
                        }else if(arrayList.size()==4){
                            sqldb.insertenterance(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3));
                        }else if(arrayList.size()==3){
                            sqldb.insertenterance(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2));
                        }else if(arrayList.size()==2){
                            sqldb.insertenterance(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1));
                        }else if(arrayList.size()==1){
                            sqldb.insertenterance(jsonObjectcourse.getString("course_name"),arrayList.get(0));
                        }else {
                            sqldb.insertenterance(jsonObjectcourse.getString("course_name"));
                        }



                        //////////////////////////ELIGIBILITY/////////////////////////////



                        jsonArrayElg= jsonObjectcourse.getJSONArray("eligibility");
                        arrayList=new ArrayList<>();
                        for(int l =0;l<jsonArrayElg.length();l++){
                            arrayList.add(jsonArrayElg.getJSONObject(l).getString("exam_name"));
                            arrayList.add(jsonArrayElg.getJSONObject(l).getString("score"));
                        }
                        // arrayListUCEligibility.add(new filterdataClass(arrayList));

                        if (arrayList.size()==12){
                            sqldb.inserteligibility(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3),arrayList.get(4),arrayList.get(5),arrayList.get(6),arrayList.get(7),arrayList.get(8),arrayList.get(9),arrayList.get(10),arrayList.get(11));

                        }else if (arrayList.size()==10){
                            sqldb.inserteligibility(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3),arrayList.get(4),arrayList.get(5),arrayList.get(6),arrayList.get(7),arrayList.get(8),arrayList.get(9));

                        }else if (arrayList.size()==8){
                            sqldb.inserteligibility(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3),arrayList.get(4),arrayList.get(5),arrayList.get(6),arrayList.get(7));

                        }else if (arrayList.size()==6){
                            sqldb.inserteligibility(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3),arrayList.get(4),arrayList.get(5));

                        }else if (arrayList.size()==4){
                            sqldb.inserteligibility(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3));

                        }else if (arrayList.size()==2){
                            sqldb.inserteligibility(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1));

                        }else {
                            sqldb.inserteligibility(jsonObjectcourse.getString("course_name"));

                        }


                        try {
                            currencyobj=jsonObjectcourse.getJSONObject("currency");
                            currencyval.add(currencyobj.getString("symbol"));
                        }catch (JSONException e){

                        }








                    }
                    DataModelClassForCourse dataModelClassForCourse = new DataModelClassForCourse(jsonArrayunv.getJSONObject(0).getString("university_name"), jsonObjectcourse.getString("course_name"), jsonObjectcourse.getString("course"), jsonObjectcourse.getString("year"), jsonObjectcourse.getString("time"),
                            jsonObjectcourse.getString("total_fee"), jsonObjectcourse.getString("syllabus"));
                    arrayListcourse.add(dataModelClassForCourse);
                    linearLayoutManager=new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    adapterclassForCourse=new AdapterclassForCourse(FirstPageInsideCoursee.this,arrayListcourse,arrayListUnv,currencyval);
                    recyclerView.setAdapter(adapterclassForCourse);
                    //adapterclassForCourse.notifyDataSetChanged();




                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.w("erorrrrrrrrrrrrrrrrr",error);

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {


                Log.w("insideee course_id",courseid);
                Map<String,String> map=new HashMap<String, String>();
                map.put("course_name", courseid);


                return map;
            }
        };
        que.add(request);


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.first_page_inside_course);
        recyclerView=findViewById(R.id.recyclerviewfor_coursepage);
        set = new HashSet<>();
        list= new ArrayList<>();

        sqldb=new SQLDB(this);
        sqldb.deletetable();
        currencyval=new ArrayList<>();
        getall_course_name();
        circleImageViewup=findViewById(R.id.circleimage11_in_course);
      //  Glide.with(this).load("https://media-exp1.licdn.com/dms/image/C4D0BAQH1WPAYy209hA/company-logo_200_200/0/1592584270579?e=2147483647&v=beta&t=3MLf7Yd59Ii37F1547dXM9SM25VPw0xOv7RA5AtfT44").into(circleImageViewup);


        fliterimg=findViewById(R.id.openfilterincourse);
        fliterimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),Filterpage_inside_course.class);
                startActivity(i);

            }
        });

        immmm=findViewById(R.id.first_page_course_backbtn);
        immmm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii=new Intent(FirstPageInsideCoursee.this,BottomNavEx.class);
                startActivity(ii);
            }
        });


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        autoCompleteTextView=findViewById(R.id.search_text1);




        arrayListF=new ArrayList<>();
        arrayListcourseSearch=sqldb.getcourse_details();



       adapter
                = new ArrayAdapter<String>(
                this,
                R.layout.autoc_filter,
                list);

        // Give the suggestion after 1 words.
        autoCompleteTextView.setThreshold(1);

        // Set the adapter for data as a list
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setTextColor(Color.BLACK);


        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for(String x:list){
                    Log.w("jooooooooo", x);
                    if(x.equals(autoCompleteTextView.getText().toString())){

                        course_name='"'+x+'"';
                        set_course_search(course_name);

                        Log.w("jokkkkkkkkkkk", String.valueOf(count));


                    }

                    Log.w("jo", String.valueOf(count));
                    count= count+1;
                }

                count=0;

                autoCompleteTextView.setText("");
            }
        });








        ////progress bar
        pg1=findViewById(R.id.progressBar31);
        progressBar= findViewById(R.id.progressBar1);
        progressBar.setVisibility(View.INVISIBLE);



        arrayListUnv=new ArrayList<>();
        arrayListcourse=new ArrayList<>();

        getcoursejson(0);

        arrayListUnv=new ArrayList<>();

        arrayListcourse=new ArrayList<>();

        arrayListUnv=sqldb.getuniv_details();


        Log.w("universitydata", String.valueOf(arrayListUnv.size()));




        swipeRefreshLayout=findViewById(R.id.swipe);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onRefresh() {
                if (insidefilter==false){
                    if(flagrefresh){
                        Totalchild=0;current=0;showing=0;totalget=0;jsonsize=0;
                        arrayListcourse.clear();
                        adapterclassForCourse.notifyDataSetChanged();
                        set1=false;
                        isscrolling=false;
                        fill=true;
                        progressBar.setVisibility(View.INVISIBLE);
                        pg1.setVisibility(View.VISIBLE);

                        getcoursejson(0);

                        flagrefresh=false;
                        swipeRefreshLayout.setRefreshing(false);}

                }else{
                    flagrefresh=false;
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        });

        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapterclassForCourse=new AdapterclassForCourse(FirstPageInsideCoursee.this,arrayListcourse,arrayListUnv,currencyval);
        Log.w("keeeepepepepe", String.valueOf(arrayListcourse.size()));
        recyclerView.setAdapter(adapterclassForCourse);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    isscrolling=true;


                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                current= linearLayoutManager.getChildCount();
                Totalchild= linearLayoutManager.getItemCount();
                showing=linearLayoutManager.findFirstVisibleItemPosition();

                if (insidefilter==false){


                    if(isscrolling & (current+showing==Totalchild)&fill){
                        isscrolling=false;

                        fill=false;

                        progressBar.setVisibility(recyclerView.VISIBLE);
                        totalget=linearLayoutManager.getItemCount();
                        Log.w("","entered scroll");

                       getcoursejson(totalget);


                    }}





            }
        });
        Intent k = getIntent();

        if(k.getParcelableArrayListExtra("universityfilter_name")!=null){


            insidefilter = true;
            arrayListF = k.getParcelableArrayListExtra("universityfilter_name");
            totalget=arrayListF.size();
            Log.w("fffffffffff", String.valueOf(totalget));
            getfilter_data(arrayListF);


//            adapterClassForUniversity=new AdapterClassForUniversity(FirstPageInsideUniversity.this,arrayList);
//            Log.w("keeeepepepepe", String.valueOf(arrayList.size()));
//            recyclerView.setAdapter(adapterClassForUniversity);
        }
//        else if((k.getStringExtra("universityfilter_name")!=null) ){
//            Log.w("hhhhhhhhhhh","inside getstring");
//            insidefilter = true;
//
//            unvv_name= k.getStringExtra("universityfilter_name");
//            Log.w("xxxxxxxxxxxxf", unvv_name);
//
//            arrayListF=sqldb.get_mul_course_details_coursename(unvv_name);
//            totalget=arrayListF.size();
//            Log.w("fffffffffff", String.valueOf(totalget));
//            getfilter_data(arrayListF);
//
//        }


    }
    public void getfilter_data(ArrayList<DataModelClassForCourse>arrayListF){

        if (set1){


            if(totalget<=arrayListF.size()){



                for (int i = totalget; i < totalget+3; i++) {
                    if(i<=jsonsize-1){

                        //UnvdataClass unvdataClass = new UnvdataClass("university","londan","1893","5","https://gamingcentral.in/wp-content/uploads/2017/07/48c204c6061ab520d665f83ed5c0e6d0_original.png");
                        arrayListF.add(arrayListF.get(i));


                    }

                    else{
                        i=totalget+4;
                    }
                    adapterclassForCourse=new AdapterclassForCourse(FirstPageInsideCoursee.this,arrayListF,arrayListUnv,currencyval);
                    Log.w("keeeepepepepe", String.valueOf(arrayListF.size()));
                    recyclerView.setAdapter(adapterclassForCourse);

                    pg1.setVisibility(View.INVISIBLE);

                }

                fill=true;
                progressBar.setVisibility(View.INVISIBLE);






            }}
        else{
            set1=true;

            for (int i = 0; i < 5; i++) {


                //UnvdataClass unvdataClass = new UnvdataClass("university","londan","1893","5","https://gamingcentral.in/wp-content/uploads/2017/07/48c204c6061ab520d665f83ed5c0e6d0_original.png");
                arrayListF.add(arrayListF.get(i));}



            pg1.setVisibility(View.INVISIBLE);



        }
        adapterclassForCourse=new AdapterclassForCourse(FirstPageInsideCoursee.this,arrayListF,arrayListUnv,currencyval);
        Log.w("keeeepepepepe", String.valueOf(arrayListF.size()));
        recyclerView.setAdapter(adapterclassForCourse);
        flagrefresh=true;

        swipeRefreshLayout.setRefreshing(false);
        fill=true;
        progressBar.setVisibility(View.INVISIBLE);



    }


    private void sendUnvDetails(String university_namey) {
      // sqldb.deletetable();
        //sqldb.deletetable_univ();

        int countcheck = sqldb.count_UniversityDetails(university_namey);
        Log.w("sjjsCOUNT", String.valueOf(countcheck));
        if (countcheck > 0) {
            Log.w("sjjsjsjsjjsjsjs", "skippppppppppppppppp");


        } else {


            RequestQueue que = Volley.newRequestQueue(getApplicationContext());

            StringRequest request = new StringRequest(Request.Method.POST, urluvn_filter, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {


                    try {
                        JSONObject jsonObjectr = new JSONObject(response);
                        JSONArray jsn = jsonObjectr.getJSONArray("university");
                        JSONObject jsonObject = jsn.getJSONObject(0);
                        jsonArray1y = jsonObject.getJSONArray("university_details");
                        for (int j = 0; j < jsonArray1y.length(); j++) {
                            jsonObject1y = jsonArray1y.getJSONObject(j);


                            Log.w("entereddd univ detail","hererererererrerererer");
                            Log.w("entereddd univ detail",jsonObject.getString("university_name"));

                            sqldb.insertuniv_details(jsonObject.getString("university_name"), jsonObject1y.getString("rating"),
                                    jsonObject1y.getString("estd"), jsonObject1y.getString("status"), jsonObject1y.getString("sector"),
                                    jsonObject1y.getString("about"), jsonObject1y.getString("banner"), jsonObject1y.getString("logo"), jsonObject1y.getString("location"), jsonObject1y.getString("city"), jsonObject1y.getString("country"), jsonObject1y.getString("contact")
                                    , jsonObject1y.getString("email"), jsonObject1y.getString("website"));


                        }


                        jsonArray2= jsonObject.getJSONArray("university_ranking");
                        arrayListRank=new ArrayList<String>();
                        // arrayList=new ArrayList<>();
                        for(int l =0;l<jsonArray2.length();l++){
                            arrayListRank.add(jsonArray2.getJSONObject(l).getString("name"));
                            arrayListRank.add(jsonArray2.getJSONObject(l).getString("ranking"));

                        }

                        if(arrayListRank.size()==12){

                            sqldb.insertrank(jsonObject.getString("university_name"), arrayListRank.get(0), arrayListRank.get(1),arrayListRank.get(2), arrayListRank.get(3),arrayListRank.get(4), arrayListRank.get(5)
                                    ,arrayListRank.get(6), arrayListRank.get(7),arrayListRank.get(8), arrayListRank.get(9),arrayListRank.get(10), arrayListRank.get(11));

                        }
                        else if(arrayListRank.size()==10){

                            sqldb.insertrank(jsonObject.getString("university_name"), arrayListRank.get(0), arrayListRank.get(1),arrayListRank.get(2), arrayListRank.get(3),arrayListRank.get(4), arrayListRank.get(5)
                                    ,arrayListRank.get(6), arrayListRank.get(7),arrayListRank.get(8), arrayListRank.get(9));

                        }

                        else if(arrayListRank.size()==8){

                            sqldb.insertrank(jsonObject.getString("university_name"), arrayListRank.get(0), arrayListRank.get(1),arrayListRank.get(2), arrayListRank.get(3),arrayListRank.get(4), arrayListRank.get(5)
                                    ,arrayListRank.get(6), arrayListRank.get(7));

                        }
                        else  if(arrayListRank.size()==6){

                            sqldb.insertrank(jsonObject.getString("university_name"), arrayListRank.get(0), arrayListRank.get(1),arrayListRank.get(2), arrayListRank.get(3),arrayListRank.get(4), arrayListRank.get(5)
                            );

                        }else if(arrayListRank.size()==4){
                            sqldb.insertrank(jsonObject.getString("university_name"), arrayListRank.get(0), arrayListRank.get(1),arrayListRank.get(2), arrayListRank.get(3));

                        }else if(arrayListRank.size()==2){
                            sqldb.insertrank(jsonObject.getString("university_name"), arrayListRank.get(0), arrayListRank.get(1));

                        }else {
                            sqldb.insertrank(jsonObject.getString("university_name"));

                        }










                        jsonArray3= jsonObject.getJSONArray("university_affiliation");
                        arrayListAffliation=new ArrayList<>();
                        for(int z=0;z<jsonArray3.length();z++){
                            arrayListAffliation.add(jsonArray3.getJSONObject(z).getString("university_affiliated"));

                        }


                        if(arrayListAffliation.size()==6){
                            sqldb.insertaffi(jsonObject.getString("university_name"),arrayListAffliation.get(0),arrayListAffliation.get(1),arrayListAffliation.get(2),arrayListAffliation.get(3)
                                    ,arrayListAffliation.get(4),arrayListAffliation.get(5));
                        }else  if(arrayListAffliation.size()==5){
                            sqldb.insertaffi(jsonObject.getString("university_name"),arrayListAffliation.get(0),arrayListAffliation.get(1),arrayListAffliation.get(2),arrayListAffliation.get(3)
                                    ,arrayListAffliation.get(4));
                        }else  if(arrayListAffliation.size()==4){
                            sqldb.insertaffi(jsonObject.getString("university_name"),arrayListAffliation.get(0),arrayListAffliation.get(1),arrayListAffliation.get(2),arrayListAffliation.get(3));

                        }else  if(arrayListAffliation.size()==3){
                            sqldb.insertaffi(jsonObject.getString("university_name"),arrayListAffliation.get(0),arrayListAffliation.get(1),arrayListAffliation.get(2));
                        }else if(arrayListAffliation.size()==2){
                            sqldb.insertaffi(jsonObject.getString("university_name"),arrayListAffliation.get(0),arrayListAffliation.get(1));

                        }else if(arrayListAffliation.size()==1){
                            sqldb.insertaffi(jsonObject.getString("university_name"),arrayListAffliation.get(0));

                        }else {
                            sqldb.insertaffi(jsonObject.getString("university_name"));

                        }



                        jsonArray4= jsonObject.getJSONArray("facility");
                        arrayListfacility=new ArrayList<>();
                        for(int m=0;m<jsonArray4.length();m++){
                            arrayListfacility.add(jsonArray4.getJSONObject(m).getString("facilities"));

                        }

                        if (arrayListfacility.size()==6) {

                            sqldb.insertfacility(jsonObject.getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1), arrayListfacility.get(2),
                                    arrayListfacility.get(3), arrayListfacility.get(4), arrayListfacility.get(5));
                        }else if (arrayListfacility.size()==5) {

                            sqldb.insertfacility(jsonObject.getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1), arrayListfacility.get(2),
                                    arrayListfacility.get(3), arrayListfacility.get(4));
                        }else if (arrayListfacility.size()==4) {

                            sqldb.insertfacility(jsonObject.getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1), arrayListfacility.get(2),
                                    arrayListfacility.get(3));
                        }else if (arrayListfacility.size()==3) {

                            sqldb.insertfacility(jsonObject.getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1), arrayListfacility.get(2));
                        }else if (arrayListfacility.size()==2) {

                            sqldb.insertfacility(jsonObject.getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1));
                        }
                        else if(arrayListfacility.size()==1){
                            sqldb.insertfacility(jsonObject.getString("university_name"), arrayListfacility.get(0));

                        }else {
                            sqldb.insertfacility(jsonObject.getString("university_name"));

                        }




                        jsonArray5=jsonObject.getJSONArray("university_feed");
                        for (int r=0;r<jsonArray5.length();r++){
                            jsonObjectFeed=jsonArray5.getJSONObject(r);
                            sqldb.insert_unv_feed(jsonObject.getString("university_name"),jsonObjectFeed.getString("feed"),jsonObjectFeed.getString("feed_image"),jsonObjectFeed.getString("youtube"));

                        }
                        jsonArray6= jsonObject.getJSONArray("university_procedures");
                        // arrayListProcedure=new ArrayList<>();

                        for(int k=0;k<jsonArray6.length();k++){
                            jsonObjectProcedure=jsonArray6.getJSONObject(k);
                            sqldb.insert_unv_procedures(jsonObject.getString("university_name"),jsonObjectProcedure.getString("apply"),jsonObjectProcedure.getString("visa"),jsonObjectProcedure.getString("service"),jsonObjectProcedure.getString("documents"));



                        }




                        try {
                            jsonAccom = jsonObject.getJSONArray("accommodation");

                            if(jsonAccom.length()!=0) {
                                for (int p = 0; p < jsonAccom.length(); p++) {
                                    jsonObjectAccom = jsonAccom.getJSONObject(p);
                                    jsonInAccom = jsonObjectAccom.getJSONArray("accomadation_details");
                                    for (int q = 0; q < jsonInAccom.length(); q++) {
                                        jsonObjectInAccom = jsonInAccom.getJSONObject(q);
                                        sqldb.insert_un_accomodation(jsonObject.getString("university_name"), jsonObjectAccom.getString("hst_name"), jsonObjectInAccom.getString("room_type"), jsonObjectInAccom.getString("duration"), jsonObjectInAccom.getString("fee"));
                                    }
                                }
                            }else {
                                Log.w("no value","nooo value");
                                sqldb.insert_un_accomodation(jsonObject.getString("university_name"), null, null, null, null);

                            }

                        }catch (Exception e){
                            Log.w("fffffffffffffffffffff",e);

                        }







                        jsonArray6y = jsonObject.getJSONArray("university_procedures");
                        for (int k = 0; k < jsonArray6y.length(); k++) {
                            jsonObjectProcedurey = jsonArray6y.getJSONObject(k);
                            sqldb.insert_unv_procedures(jsonObject.getString("university_name"), jsonObjectProcedurey.getString("apply"), jsonObjectProcedurey.getString("visa"), jsonObjectProcedurey.getString("service"), jsonObjectProcedurey.getString("documents"));

                        }

                        Log.w("jssonnnnnn", jsn.getJSONObject(0).getJSONArray("university_details").getJSONObject(0).getString("country"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String, String> map = new HashMap<String, String>();
                    map.put("unv_name", '"' + university_namey + '"');
                    map.put("country", "");
                    map.put("rating", "");
                    map.put("city", "");

                    return map;
                }
            };

            que.add(request);


        }






    }



    private void getcoursejson(int start) {
        if(insidefilter==false) {
            if (set1) {

                RequestQueue queuecourse = Volley.newRequestQueue(this);
              StringRequest jsonObjectRequestforcourse = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        jsonsize=jsonsize+3;
                        Log.w("tttttttttttttttt",response);
                        if (totalget <= jsonsize) {

                            try {
                                JSONObject res=new JSONObject(response);
                                jsonArraycourse = res.getJSONArray("course");


                                for (int i = 0; i < 3; i++) {
                                    if (i <= jsonsize ) {
                                        jsonObjectcourse = jsonArraycourse.getJSONObject(i);
                                        jsonArrayunv= jsonObjectcourse.getJSONArray("university");
                                        sqldb.insertcourse_details(jsonObjectcourse.getJSONArray("university").getJSONObject(0).getString("university_name"),jsonObjectcourse.getString("course_name"),
                                                jsonObjectcourse.getString("course"),jsonObjectcourse.getString("year"),jsonObjectcourse.getString("time"),
                                                jsonObjectcourse.getString("total_fee"),jsonObjectcourse.getString("syllabus"));


                                        university_namey=jsonObjectcourse.getJSONArray("university").getJSONObject(0).getString("university_name");
                                        Log.w("universitynameyyyyy",university_namey);
                                        int countcheck = sqldb.count_UniversityDetails(university_namey);
                                        Log.w("sjjsCOUNT", String.valueOf(countcheck));
                                        if (countcheck  <1) {
                                            Log.w("sjjsjsjsjjsjsjs", "skippppppppppppppppp");
                                            sendUnvDetails(university_namey);

                                        }







                                        //////// course_feeeee
                                        jsonArrayCfee= jsonObjectcourse.getJSONArray("course_fee");
                                        arrayList=new ArrayList<>();
                                        for(int l =0;l<jsonArrayCfee.length();l++){
                                            arrayList.add(jsonArrayCfee.getJSONObject(l).getString("term"));
                                            arrayList.add(jsonArrayCfee.getJSONObject(l).getString("fee_head"));
                                            arrayList.add(jsonArrayCfee.getJSONObject(l).getString("amount"));

                                        }
                                        if(arrayList.size()==30){
                                            sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)
                                                    ,arrayList.get(6), arrayList.get(7),arrayList.get(8), arrayList.get(9),arrayList.get(10), arrayList.get(11),arrayList.get(12), arrayList.get(13),arrayList.get(14), arrayList.get(15),arrayList.get(16), arrayList.get(17)
                                                    ,arrayList.get(18), arrayList.get(19),arrayList.get(20), arrayList.get(21),arrayList.get(22), arrayList.get(23),arrayList.get(24), arrayList.get(25),arrayList.get(26), arrayList.get(27),arrayList.get(28), arrayList.get(29)
                                            );
                                        }
                                        else  if(arrayList.size()==27){
                                            sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)
                                                    ,arrayList.get(6), arrayList.get(7),arrayList.get(8), arrayList.get(9),arrayList.get(10), arrayList.get(11),arrayList.get(12), arrayList.get(13),arrayList.get(14), arrayList.get(15),arrayList.get(16), arrayList.get(17)
                                                    ,arrayList.get(18), arrayList.get(19),arrayList.get(20), arrayList.get(21),arrayList.get(22), arrayList.get(23),arrayList.get(24), arrayList.get(25),arrayList.get(26));

                                        }
                                        else  if(arrayList.size()==24){
                                            sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)
                                                    ,arrayList.get(6), arrayList.get(7),arrayList.get(8), arrayList.get(9),arrayList.get(10), arrayList.get(11),arrayList.get(12), arrayList.get(13),arrayList.get(14), arrayList.get(15),arrayList.get(16), arrayList.get(17)
                                                    ,arrayList.get(18), arrayList.get(19),arrayList.get(20), arrayList.get(21),arrayList.get(22), arrayList.get(23));

                                        }
                                        else  if(arrayList.size()==21){
                                            sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)
                                                    ,arrayList.get(6), arrayList.get(7),arrayList.get(8), arrayList.get(9),arrayList.get(10), arrayList.get(11),arrayList.get(12), arrayList.get(13),arrayList.get(14), arrayList.get(15),arrayList.get(16), arrayList.get(17)
                                                    ,arrayList.get(18), arrayList.get(19),arrayList.get(20));

                                        }
                                        else  if(arrayList.size()==18){
                                            sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)
                                                    ,arrayList.get(6), arrayList.get(7),arrayList.get(8), arrayList.get(9),arrayList.get(10), arrayList.get(11),arrayList.get(12), arrayList.get(13),arrayList.get(14), arrayList.get(15),arrayList.get(16), arrayList.get(17)
                                            );

                                        }
                                        else  if(arrayList.size()==15){
                                            sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)
                                                    ,arrayList.get(6), arrayList.get(7),arrayList.get(8), arrayList.get(9),arrayList.get(10), arrayList.get(11),arrayList.get(12), arrayList.get(13),arrayList.get(14)
                                            );

                                        }
                                        else  if(arrayList.size()==12){
                                            sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)
                                                    ,arrayList.get(6), arrayList.get(7),arrayList.get(8), arrayList.get(9),arrayList.get(10), arrayList.get(11)
                                            );

                                        }
                                        else  if(arrayList.size()==9){
                                            sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)
                                                    ,arrayList.get(6), arrayList.get(7),arrayList.get(8)
                                            );

                                        }
                                        else  if(arrayList.size()==6){
                                            sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)

                                            );

                                        }
                                        else  if(arrayList.size()==3){
                                            sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2)

                                            );

                                        }else {
                                            sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"));
                                        }





                                        /////ENTRANCE

                                        jsonArrayEnt= jsonObjectcourse.getJSONArray("entrance");
                                        arrayList=new ArrayList<>();
                                        for(int l =0;l<jsonArrayEnt.length();l++){
                                            arrayList.add(jsonArrayEnt.getJSONObject(l).getString("exam_name"));


                                        }
                                        if(arrayList.size()==6){
                                            sqldb.insertenterance(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3),arrayList.get(4),arrayList.get(5));
                                        }else if(arrayList.size()==5){
                                            sqldb.insertenterance(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3),arrayList.get(4));
                                        }else if(arrayList.size()==4){
                                            sqldb.insertenterance(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3));
                                        }else if(arrayList.size()==3){
                                            sqldb.insertenterance(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2));
                                        }else if(arrayList.size()==2){
                                            sqldb.insertenterance(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1));
                                        }else if(arrayList.size()==1){
                                            sqldb.insertenterance(jsonObjectcourse.getString("course_name"),arrayList.get(0));
                                        }else {
                                            sqldb.insertenterance(jsonObjectcourse.getString("course_name"));
                                        }



                                        //////////////////////////ELIGIBILITY/////////////////////////////



                                        jsonArrayElg= jsonObjectcourse.getJSONArray("eligibility");
                                        arrayList=new ArrayList<>();
                                        for(int l =0;l<jsonArrayElg.length();l++){
                                            arrayList.add(jsonArrayElg.getJSONObject(l).getString("exam_name"));
                                            arrayList.add(jsonArrayElg.getJSONObject(l).getString("score"));
                                        }
                                        if (arrayList.size()==12){
                                            sqldb.inserteligibility(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3),arrayList.get(4),arrayList.get(5),arrayList.get(6),arrayList.get(7),arrayList.get(8),arrayList.get(9),arrayList.get(10),arrayList.get(11));

                                        }else if (arrayList.size()==10){
                                            sqldb.inserteligibility(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3),arrayList.get(4),arrayList.get(5),arrayList.get(6),arrayList.get(7),arrayList.get(8),arrayList.get(9));

                                        }else if (arrayList.size()==8){
                                            sqldb.inserteligibility(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3),arrayList.get(4),arrayList.get(5),arrayList.get(6),arrayList.get(7));

                                        }else if (arrayList.size()==6){
                                            sqldb.inserteligibility(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3),arrayList.get(4),arrayList.get(5));

                                        }else if (arrayList.size()==4){
                                            sqldb.inserteligibility(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3));

                                        }else if (arrayList.size()==2){
                                            sqldb.inserteligibility(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1));

                                        }else {
                                            sqldb.inserteligibility(jsonObjectcourse.getString("course_name"));

                                        }


                                        currencyobj=jsonObjectcourse.getJSONObject("currency");
                                        currencyval.add(currencyobj.getString("symbol"));











                                        // Log.w("owowowowowowowowow", String.valueOf(jsonArrayunv.getJSONObject(0).getJSONObject("university_name")));


                                        DataModelClassForCourse dataModelClassForCourse = new DataModelClassForCourse(jsonArrayunv.getJSONObject(0).getString("university_name"), jsonObjectcourse.getString("course_name"), jsonObjectcourse.getString("course"), jsonObjectcourse.getString("year"), jsonObjectcourse.getString("time"),
                                                jsonObjectcourse.getString("total_fee"), jsonObjectcourse.getString("syllabus"));
                                        arrayListcourse.add(dataModelClassForCourse);
                                        adapterclassForCourse.notifyDataSetChanged();
                                    } else {
                                        i = totalget + 11;
                                    }

                                    pg1.setVisibility(View.INVISIBLE);
                                }

                                fill = true;
                                progressBar.setVisibility(View.INVISIBLE);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }


                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String>map=new HashMap<String,String>();
                        map.put("startcou", String.valueOf(start+1));
                        return map;
                    }
                };
                jsonObjectRequestforcourse.setRetryPolicy(new DefaultRetryPolicy(2000, 4, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                queuecourse.add(jsonObjectRequestforcourse);
            } else {


                set1 = true;
                RequestQueue queuecourse = Volley.newRequestQueue(this);
                StringRequest jsonObjectRequestforcourse = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onResponse(String response) {


                        try {
                            JSONObject res=new JSONObject(response);
                            Log.w("ttttttttttttttttnew",response);
                            jsonArraycourse = res.getJSONArray("course");

                            for (int i = 0; i <3; i++) {

                                jsonsize = jsonArraycourse.length();
                                jsonObjectcourse = jsonArraycourse.getJSONObject(i);
                                jsonArrayunv= jsonObjectcourse.getJSONArray("university");

                                sqldb.insertcourse_details(jsonObjectcourse.getJSONArray("university").getJSONObject(0).getString("university_name"),jsonObjectcourse.getString("course_name"),
                                        jsonObjectcourse.getString("course"),jsonObjectcourse.getString("year"),jsonObjectcourse.getString("time"),
                                        jsonObjectcourse.getString("total_fee"),jsonObjectcourse.getString("syllabus"));


                                university_namey=jsonObjectcourse.getJSONArray("university").getJSONObject(0).getString("university_name");
                                Log.w("universitynameyyyyy",university_namey);
                                int countcheck = sqldb.count_UniversityDetails(university_namey);
                                Log.w("sjjsCOUNT", String.valueOf(countcheck));
                                if (countcheck  <1) {
                                    Log.w("sjjsjsjsjjsjsjs", "skippppppppppppppppp");
                                    sendUnvDetails(university_namey);

                                }





                                //////// course_feeeee
                                jsonArrayCfee= jsonObjectcourse.getJSONArray("course_fee");
                                arrayList=new ArrayList<>();
                                for(int l =0;l<jsonArrayCfee.length();l++){
                                    arrayList.add(jsonArrayCfee.getJSONObject(l).getString("term"));
                                    arrayList.add(jsonArrayCfee.getJSONObject(l).getString("fee_head"));
                                    arrayList.add(jsonArrayCfee.getJSONObject(l).getString("amount"));

                                }
                                if(arrayList.size()==30){
                                    sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)
                                            ,arrayList.get(6), arrayList.get(7),arrayList.get(8), arrayList.get(9),arrayList.get(10), arrayList.get(11),arrayList.get(12), arrayList.get(13),arrayList.get(14), arrayList.get(15),arrayList.get(16), arrayList.get(17)
                                            ,arrayList.get(18), arrayList.get(19),arrayList.get(20), arrayList.get(21),arrayList.get(22), arrayList.get(23),arrayList.get(24), arrayList.get(25),arrayList.get(26), arrayList.get(27),arrayList.get(28), arrayList.get(29)
                                    );
                                }
                                else  if(arrayList.size()==27){
                                    sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)
                                            ,arrayList.get(6), arrayList.get(7),arrayList.get(8), arrayList.get(9),arrayList.get(10), arrayList.get(11),arrayList.get(12), arrayList.get(13),arrayList.get(14), arrayList.get(15),arrayList.get(16), arrayList.get(17)
                                            ,arrayList.get(18), arrayList.get(19),arrayList.get(20), arrayList.get(21),arrayList.get(22), arrayList.get(23),arrayList.get(24), arrayList.get(25),arrayList.get(26));

                                }
                                else  if(arrayList.size()==24){
                                    sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)
                                            ,arrayList.get(6), arrayList.get(7),arrayList.get(8), arrayList.get(9),arrayList.get(10), arrayList.get(11),arrayList.get(12), arrayList.get(13),arrayList.get(14), arrayList.get(15),arrayList.get(16), arrayList.get(17)
                                            ,arrayList.get(18), arrayList.get(19),arrayList.get(20), arrayList.get(21),arrayList.get(22), arrayList.get(23));

                                }
                                else  if(arrayList.size()==21){
                                    sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)
                                            ,arrayList.get(6), arrayList.get(7),arrayList.get(8), arrayList.get(9),arrayList.get(10), arrayList.get(11),arrayList.get(12), arrayList.get(13),arrayList.get(14), arrayList.get(15),arrayList.get(16), arrayList.get(17)
                                            ,arrayList.get(18), arrayList.get(19),arrayList.get(20));

                                }
                                else  if(arrayList.size()==18){
                                    sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)
                                            ,arrayList.get(6), arrayList.get(7),arrayList.get(8), arrayList.get(9),arrayList.get(10), arrayList.get(11),arrayList.get(12), arrayList.get(13),arrayList.get(14), arrayList.get(15),arrayList.get(16), arrayList.get(17)
                                    );

                                }
                                else  if(arrayList.size()==15){
                                    sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)
                                            ,arrayList.get(6), arrayList.get(7),arrayList.get(8), arrayList.get(9),arrayList.get(10), arrayList.get(11),arrayList.get(12), arrayList.get(13),arrayList.get(14)
                                    );

                                }
                                else  if(arrayList.size()==12){
                                    sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)
                                            ,arrayList.get(6), arrayList.get(7),arrayList.get(8), arrayList.get(9),arrayList.get(10), arrayList.get(11)
                                    );

                                }
                                else  if(arrayList.size()==9){
                                    sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)
                                            ,arrayList.get(6), arrayList.get(7),arrayList.get(8)
                                    );

                                }
                                else  if(arrayList.size()==6){
                                    sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2), arrayList.get(3),arrayList.get(4), arrayList.get(5)

                                    );

                                }
                                else  if(arrayList.size()==3){
                                    sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"),arrayList.get(0), arrayList.get(1),arrayList.get(2)

                                    );

                                }else {
                                    sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"));
                                }





                                /////ENTRANCE

                                jsonArrayEnt= jsonObjectcourse.getJSONArray("entrance");
                                arrayList=new ArrayList<>();
                                for(int l =0;l<jsonArrayEnt.length();l++){
                                    arrayList.add(jsonArrayEnt.getJSONObject(l).getString("exam_name"));


                                }
                                if(arrayList.size()==6){
                                    sqldb.insertenterance(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3),arrayList.get(4),arrayList.get(5));
                                }else if(arrayList.size()==5){
                                    sqldb.insertenterance(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3),arrayList.get(4));
                                }else if(arrayList.size()==4){
                                    sqldb.insertenterance(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3));
                                }else if(arrayList.size()==3){
                                    sqldb.insertenterance(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2));
                                }else if(arrayList.size()==2){
                                    sqldb.insertenterance(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1));
                                }else if(arrayList.size()==1){
                                    sqldb.insertenterance(jsonObjectcourse.getString("course_name"),arrayList.get(0));
                                }else {
                                    sqldb.insertenterance(jsonObjectcourse.getString("course_name"));
                                }



                                //////////////////////////ELIGIBILITY/////////////////////////////



                                jsonArrayElg= jsonObjectcourse.getJSONArray("eligibility");
                                arrayList=new ArrayList<>();
                                for(int l =0;l<jsonArrayElg.length();l++){
                                    arrayList.add(jsonArrayElg.getJSONObject(l).getString("exam_name"));
                                    arrayList.add(jsonArrayElg.getJSONObject(l).getString("score"));
                                }
                                if (arrayList.size()==12){
                                    sqldb.inserteligibility(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3),arrayList.get(4),arrayList.get(5),arrayList.get(6),arrayList.get(7),arrayList.get(8),arrayList.get(9),arrayList.get(10),arrayList.get(11));

                                }else if (arrayList.size()==10){
                                    sqldb.inserteligibility(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3),arrayList.get(4),arrayList.get(5),arrayList.get(6),arrayList.get(7),arrayList.get(8),arrayList.get(9));

                                }else if (arrayList.size()==8){
                                    sqldb.inserteligibility(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3),arrayList.get(4),arrayList.get(5),arrayList.get(6),arrayList.get(7));

                                }else if (arrayList.size()==6){
                                    sqldb.inserteligibility(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3),arrayList.get(4),arrayList.get(5));

                                }else if (arrayList.size()==4){
                                    sqldb.inserteligibility(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1),arrayList.get(2),arrayList.get(3));

                                }else if (arrayList.size()==2){
                                    sqldb.inserteligibility(jsonObjectcourse.getString("course_name"),arrayList.get(0),arrayList.get(1));

                                }else {
                                    sqldb.inserteligibility(jsonObjectcourse.getString("course_name"));

                                }


                                currencyobj=jsonObjectcourse.getJSONObject("currency");
                                currencyval.add(currencyobj.getString("symbol"));











                                // Log.w("owowowowowowowowow", String.valueOf(jsonArrayunv.getJSONObject(0).getJSONObject("university_name")));




                                DataModelClassForCourse dataModelClassForCourse = new DataModelClassForCourse(jsonArrayunv.getJSONObject(0).getString("university_name"), jsonObjectcourse.getString("course_name"), jsonObjectcourse.getString("course"), jsonObjectcourse.getString("year"), jsonObjectcourse.getString("time"),
                                        jsonObjectcourse.getString("total_fee"), jsonObjectcourse.getString("syllabus"));
                                arrayListcourse.add(dataModelClassForCourse);

                                adapterclassForCourse.notifyDataSetChanged();

                                pg1.setVisibility(View.INVISIBLE);

                            }

                            flagrefresh=true;

                            swipeRefreshLayout.setRefreshing(false);
                            fill=true;
                            progressBar.setVisibility(View.INVISIBLE);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


//                recyclerView.setLayoutManager(linearLayoutManager);
//                adapterclassForCourse=new AdapterclassForCourse(FirstPageInsideCoursee.this,arrayListcourse);
//                recyclerView.setAdapter(adapterclassForCourse);


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String>map=new HashMap<String,String>();
                        map.put("startcou", String.valueOf(0));
                        return map;
                    }
                };
                jsonObjectRequestforcourse.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 3, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                queuecourse.add(jsonObjectRequestforcourse);

            }

        }
    }
    /////////course jason


    class recAsYNC extends Thread {


        @Override
        public void run() {
            //getcoursejson();
            super.run();
        }
    }


}