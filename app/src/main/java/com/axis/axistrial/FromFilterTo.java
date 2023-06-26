package com.axis.axistrial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.axistrial.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FromFilterTo extends AppCompatActivity {
    ArrayList<filterdataClass> arrayListUCEligibility, arrayListUCentrance, arrayListUcFee;
    ArrayList<DataModelClassForCourse> arrayListCourseDetails, arrF;
    RecyclerView recyclerView;
    ArrayList<String> arr, arrayList;
    ProgressBar p1,p2;
    JSONArray jsonAccom,jsonInAccom,jsonArray3,jsonArray2;
    LinearLayoutManager linearLayoutManager;
    Boolean isscrolling = false, fill = true,acess=true;
    int Totalchild, current, showing, totalget = 0;
    AdapterClassForFilter adapterforfilter;
    ArrayList<DataModelClassForCourse> arrayListcourse;
    String urluvn_filter = "https://axisoverseascareers.in/api/course/course_all";
    String urluvn_filter1="https://axisoverseascareers.in/api/university/filter";
    String temp,university_namey;
    String Loc_splited = "";
    ArrayList<UnvdataClass>arrayListSearch;
    ArrayList<String>arrayListfacility;
    ArrayList<String>arrayListAffliation;
    ArrayList<String>arrayListProcedure;
    ArrayList<String>arrayListFeed;
    ArrayList<String> arrayListRank;
    ArrayList<String>arrayListAccomodation;
    JSONArray jsonArray1,jsonArray4,jsonArray5,jsonArray6;
    SwipeRefreshLayout swipe1;
    JSONObject jsonObject1,jsonobject2,jsonobject3,jsonobject4,jsonobject5,jsonobject6,jsonObject7,jsonObjectFeed,jsonObjectProcedure,jsonObjectAccom,jsonObjectInAccom;



    JSONArray jsonArray, jsonArrayunv;
    JSONArray  jsonArrayEnt, jsonArrayElg, jsonArrayCfee;
    JSONObject jsonObjectProcedurey, jsonObject1y;
    JSONArray jsonArray6y, jsonArray1y;
    JSONObject jsonObjectcourse;
    SQLDB sqldb;
    String[] loc_spilt;
    String test;
    String test2;
    String[] a;
    ImageView first_page_course_backbtn1,openfilterincourse1;
    int count;


    String urluvn_filter_course_name="https://axisoverseascareers.in/api/course/filter_coursename";
    String url_coursename="https://axisoverseascareers.in/api/course/course_name";
    String course_name;

    ArrayList<String> list;
    Set<String> set;
    Button search_button1;
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapter;
    JSONObject currencyobj;
    String currencyvalue;
    ArrayList<String> currencyval;



    @Override
    public void onBackPressed() {
   Intent i=new Intent(FromFilterTo.this,FirstPageInsideCoursee.class);
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
                    adapterforfilter.notifyDataSetChanged();




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








    public void splitmyid() throws Exception {
        if(temp.length()>1) {
            try {
                if (temp.length() > 6) {

                    a = temp.split(",", 6);
                    Log.w("hereeeee", a[0]);
                    Log.w("hereeeee12", a[1]);
                    Log.w("hereeeee12", a[2]);
                    Log.w("hereeeee12", a[3]);
                    Log.w("hereeeee12", a[4]);
                    Log.w("hereeeee23", a[5]);
                    int b = temp.indexOf(a[5]);
                    temp = temp.substring(b);
                    Log.w("ypppp", temp);
                    add_data();

                } else if (temp.length() > 5) {
                    a = temp.split(",", 6);
                    Log.w("hereeeee", a[0]);
                    Log.w("hereeeee12", a[1]);
                    Log.w("hereeeee12", a[2]);
                    Log.w("hereeeee12", a[3]);
                    Log.w("hereeeee12", a[4]);

                    int b = temp.indexOf(a[4]);
                    temp = temp.substring(b);
                    Log.w("ypppp", temp);
                    add_data();


                } else if (temp.length() > 4) {
                    a = temp.split(",", 6);
                    Log.w("hereeeee", a[0]);
                    Log.w("hereeeee12", a[1]);
                    Log.w("hereeeee12", a[2]);
                    Log.w("hereeeee12", a[3]);

                    int b = temp.indexOf(a[3]);
                    temp = temp.substring(b);
                    Log.w("ypppp", temp);
                    add_data();


                } else if (temp.length() > 3) {
                    a = temp.split(",", 6);
                    Log.w("hereeeee", a[0]);
                    Log.w("hereeeee12", a[1]);
                    Log.w("hereeeee12", a[2]);


                    int b = temp.indexOf(a[2]);
                    temp = temp.substring(b);
                    Log.w("ypppp", temp);
                    add_data();


                } else if (temp.length() > 2) {
                    a = temp.split(",", 6);
                    Log.w("hereeeee", a[0]);
                    Log.w("hereeeee12", a[1]);


                    int b = temp.indexOf(a[1]);
                    temp = temp.substring(b);
                    Log.w("ypppp", temp);
                    add_data();


                } else if (temp.length() > 1) {
                    a = temp.split(",", 6);
                    Log.w("hereeeee", a[0]);


                    int b = temp.indexOf(a[0]);
                    temp = temp.substring(b);
                    Log.w("ypppp", temp);
                    add_data();
                } else {
                    Log.w("fgfgf", "lenth small");
                    add_data();
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                Log.w("fgfgfg", e);
                temp=null;

                p2.setVisibility(View.GONE);
            }


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_filter_to);

        set = new HashSet<>();
        list= new ArrayList<>();
        getall_course_name();


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        swipe1=findViewById(R.id.swipe1);
        swipe1.setEnabled(false);


        autoCompleteTextView=findViewById(R.id.search_text11);




        arrayList=new ArrayList<>();
        //arrayListcourseSearch=sqldb.getcourse_details();



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







        arrayListUCEligibility = new ArrayList<>();
        arrayListCourseDetails = new ArrayList<>();
        arrayListUCentrance = new ArrayList<>();
        arrayListUcFee = new ArrayList<>();
        arrF = new ArrayList<>();
        sqldb = new SQLDB(this);
        sqldb.deletetable();
        currencyval=new ArrayList<>();
        p1=findViewById(R.id.progressBar311);
        p2= findViewById(R.id.progressBar11);
        p2.setVisibility(View.GONE);
        arrayListcourse = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerviewfor_coursepage1);
        first_page_course_backbtn1=findViewById(R.id.first_page_course_backbtn1);
        openfilterincourse1=findViewById(R.id.openfilterincourse1);
        first_page_course_backbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iii=new Intent(FromFilterTo.this,FirstPageInsideCoursee.class);
                startActivity(iii);
            }
        });
        openfilterincourse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FromFilterTo.this,Filterpage_inside_course.class);
                startActivity(i);
            }
        });


        adapterforfilter = new AdapterClassForFilter(getApplicationContext(), arrayListcourse,currencyval);


        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterforfilter);


        Intent extra = getIntent();
        temp = extra.getStringExtra("arrayList");



        // loc_spilt=temp.split(",");
        try {
            splitmyid();
        } catch (Exception e) {
            e.printStackTrace();
        }


        ///// loop


        ///

        for (int i = 0; i < 6; i++) {


            for (int k = 0; k < a.length; k++) {

                Loc_splited = Loc_splited + '"' + a[k] + '"' + ',';

            }

            Loc_splited = Loc_splited.substring(0, Loc_splited.length() - 1);


        }
        get_filterFirst(Loc_splited);




        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {

                    isscrolling = true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                current = linearLayoutManager.getChildCount();
                Totalchild = linearLayoutManager.getItemCount();
                showing = linearLayoutManager.findFirstVisibleItemPosition();



                if (isscrolling & (current + showing == Totalchild-1)&acess) {
                    p2.setVisibility(View.VISIBLE);


                        try {
                            splitmyid();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        acess = false;

                        isscrolling = false;
                        fill = false;
                        //acess=false;


                        try {
                            // Thread.sleep(2000);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        totalget = linearLayoutManager.getItemCount();

                        Log.w("", "entered scroll");
//                    if (totalget < arr.size()) {
//                        try {
//                            add_data(totalget);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }

                }
            }
        });

    }

    public void add_data() throws Exception {


        try {
            for (int i = 0; i < 6; i++) {


                for (int k = 1; k < a.length; k++) {

                    Loc_splited = Loc_splited + '"' + a[k] + '"' + ',';

                }

                Loc_splited = Loc_splited.substring(0, Loc_splited.length() - 1);


            }

        } catch (ArrayIndexOutOfBoundsException e) {

            fill = true;

        }
        get_filter(Loc_splited);


        fill = true;








}


    public void get_filter(String courseid)  {



            RequestQueue que = Volley.newRequestQueue(getApplicationContext());


            StringRequest request = new StringRequest(Request.Method.POST, urluvn_filter, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.w("new responseee", response);
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        // arrayListcourse = new ArrayList<>();
                        JSONArray jsn = jsonObject.getJSONArray("course");
                        for (int i = 0; i <5; i++) {
                            jsonObjectcourse = jsn.getJSONObject(i);
                            jsonArrayunv = jsonObjectcourse.getJSONArray("university");
                            // jsonArrayunv= jsonObjectcourse.getJSONArray("university");
                            sqldb.insertcourse_details(jsonObjectcourse.getJSONArray("university").getJSONObject(0).getString("university_name"), jsonObjectcourse.getString("course_name"),
                                    jsonObjectcourse.getString("course"), jsonObjectcourse.getString("year"), jsonObjectcourse.getString("time"),
                                    jsonObjectcourse.getString("total_fee"), jsonObjectcourse.getString("syllabus"));


                            // temp=temp+jsonObjectcourse.getString("course_id")+",";

                            university_namey = jsonObjectcourse.getJSONArray("university").getJSONObject(0).getString("university_name");
                            Log.w("universitynameyyyyy", university_namey);
                            sendUnvDetails(university_namey);


                            //////// course_feeeee
                            jsonArrayCfee = jsonObjectcourse.getJSONArray("course_fee");
                            arrayList = new ArrayList<>();
                            for (int l = 0; l < jsonArrayCfee.length(); l++) {
                                arrayList.add(jsonArrayCfee.getJSONObject(l).getString("term"));
                                arrayList.add(jsonArrayCfee.getJSONObject(l).getString("fee_head"));
                                arrayList.add(jsonArrayCfee.getJSONObject(l).getString("amount"));

                            }
                            arrayListUcFee.add(new filterdataClass(arrayList));


                            if (arrayList.size() == 30) {
                                sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"), arrayList.get(0), arrayList.get(1), arrayList.get(2), arrayList.get(3), arrayList.get(4), arrayList.get(5)
                                        , arrayList.get(6), arrayList.get(7), arrayList.get(8), arrayList.get(9), arrayList.get(10), arrayList.get(11), arrayList.get(12), arrayList.get(13), arrayList.get(14), arrayList.get(15), arrayList.get(16), arrayList.get(17)
                                        , arrayList.get(18), arrayList.get(19), arrayList.get(20), arrayList.get(21), arrayList.get(22), arrayList.get(23), arrayList.get(24), arrayList.get(25), arrayList.get(26), arrayList.get(27), arrayList.get(28), arrayList.get(29)
                                );
                            } else if (arrayList.size() == 27) {
                                sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"), arrayList.get(0), arrayList.get(1), arrayList.get(2), arrayList.get(3), arrayList.get(4), arrayList.get(5)
                                        , arrayList.get(6), arrayList.get(7), arrayList.get(8), arrayList.get(9), arrayList.get(10), arrayList.get(11), arrayList.get(12), arrayList.get(13), arrayList.get(14), arrayList.get(15), arrayList.get(16), arrayList.get(17)
                                        , arrayList.get(18), arrayList.get(19), arrayList.get(20), arrayList.get(21), arrayList.get(22), arrayList.get(23), arrayList.get(24), arrayList.get(25), arrayList.get(26));

                            } else if (arrayList.size() == 24) {
                                sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"), arrayList.get(0), arrayList.get(1), arrayList.get(2), arrayList.get(3), arrayList.get(4), arrayList.get(5)
                                        , arrayList.get(6), arrayList.get(7), arrayList.get(8), arrayList.get(9), arrayList.get(10), arrayList.get(11), arrayList.get(12), arrayList.get(13), arrayList.get(14), arrayList.get(15), arrayList.get(16), arrayList.get(17)
                                        , arrayList.get(18), arrayList.get(19), arrayList.get(20), arrayList.get(21), arrayList.get(22), arrayList.get(23));

                            } else if (arrayList.size() == 21) {
                                sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"), arrayList.get(0), arrayList.get(1), arrayList.get(2), arrayList.get(3), arrayList.get(4), arrayList.get(5)
                                        , arrayList.get(6), arrayList.get(7), arrayList.get(8), arrayList.get(9), arrayList.get(10), arrayList.get(11), arrayList.get(12), arrayList.get(13), arrayList.get(14), arrayList.get(15), arrayList.get(16), arrayList.get(17)
                                        , arrayList.get(18), arrayList.get(19), arrayList.get(20));

                            } else if (arrayList.size() == 18) {
                                sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"), arrayList.get(0), arrayList.get(1), arrayList.get(2), arrayList.get(3), arrayList.get(4), arrayList.get(5)
                                        , arrayList.get(6), arrayList.get(7), arrayList.get(8), arrayList.get(9), arrayList.get(10), arrayList.get(11), arrayList.get(12), arrayList.get(13), arrayList.get(14), arrayList.get(15), arrayList.get(16), arrayList.get(17)
                                );

                            } else if (arrayList.size() == 15) {
                                sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"), arrayList.get(0), arrayList.get(1), arrayList.get(2), arrayList.get(3), arrayList.get(4), arrayList.get(5)
                                        , arrayList.get(6), arrayList.get(7), arrayList.get(8), arrayList.get(9), arrayList.get(10), arrayList.get(11), arrayList.get(12), arrayList.get(13), arrayList.get(14)
                                );

                            } else if (arrayList.size() == 12) {
                                sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"), arrayList.get(0), arrayList.get(1), arrayList.get(2), arrayList.get(3), arrayList.get(4), arrayList.get(5)
                                        , arrayList.get(6), arrayList.get(7), arrayList.get(8), arrayList.get(9), arrayList.get(10), arrayList.get(11)
                                );

                            } else if (arrayList.size() == 9) {
                                sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"), arrayList.get(0), arrayList.get(1), arrayList.get(2), arrayList.get(3), arrayList.get(4), arrayList.get(5)
                                        , arrayList.get(6), arrayList.get(7), arrayList.get(8)
                                );

                            } else if (arrayList.size() == 6) {
                                sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"), arrayList.get(0), arrayList.get(1), arrayList.get(2), arrayList.get(3), arrayList.get(4), arrayList.get(5)

                                );

                            } else if (arrayList.size() == 3) {
                                sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"), arrayList.get(0), arrayList.get(1), arrayList.get(2)

                                );

                            } else {
                                sqldb.insertcoursefee(jsonObjectcourse.getString("course_name"));
                            }


                            /////ENTRANCE

                            jsonArrayEnt = jsonObjectcourse.getJSONArray("entrance");
                            arrayList = new ArrayList<>();
                            for (int l = 0; l < jsonArrayEnt.length(); l++) {
                                arrayList.add(jsonArrayEnt.getJSONObject(l).getString("exam_name"));


                            }
                            arrayListUCentrance.add(new filterdataClass(arrayList));


                            if (arrayList.size() == 6) {
                                sqldb.insertenterance(jsonObjectcourse.getString("course_name"), arrayList.get(0), arrayList.get(1), arrayList.get(2), arrayList.get(3), arrayList.get(4), arrayList.get(5));
                            } else if (arrayList.size() == 5) {
                                sqldb.insertenterance(jsonObjectcourse.getString("course_name"), arrayList.get(0), arrayList.get(1), arrayList.get(2), arrayList.get(3), arrayList.get(4));
                            } else if (arrayList.size() == 4) {
                                sqldb.insertenterance(jsonObjectcourse.getString("course_name"), arrayList.get(0), arrayList.get(1), arrayList.get(2), arrayList.get(3));
                            } else if (arrayList.size() == 3) {
                                sqldb.insertenterance(jsonObjectcourse.getString("course_name"), arrayList.get(0), arrayList.get(1), arrayList.get(2));
                            } else if (arrayList.size() == 2) {
                                sqldb.insertenterance(jsonObjectcourse.getString("course_name"), arrayList.get(0), arrayList.get(1));
                            } else if (arrayList.size() == 1) {
                                sqldb.insertenterance(jsonObjectcourse.getString("course_name"), arrayList.get(0));
                            } else {
                                sqldb.insertenterance(jsonObjectcourse.getString("course_name"));
                            }


                            //////////////////////////ELIGIBILITY/////////////////////////////


                            jsonArrayElg = jsonObjectcourse.getJSONArray("eligibility");
                            arrayList = new ArrayList<>();
                            for (int l = 0; l < jsonArrayElg.length(); l++) {
                                arrayList.add(jsonArrayElg.getJSONObject(l).getString("exam_name"));
                                arrayList.add(jsonArrayElg.getJSONObject(l).getString("score"));
                            }
                            arrayListUCEligibility.add(new filterdataClass(arrayList));

                            if (arrayList.size() == 12) {
                                sqldb.inserteligibility(jsonObjectcourse.getString("course_name"), arrayList.get(0), arrayList.get(1), arrayList.get(2), arrayList.get(3), arrayList.get(4), arrayList.get(5), arrayList.get(6), arrayList.get(7), arrayList.get(8), arrayList.get(9), arrayList.get(10), arrayList.get(11));

                            } else if (arrayList.size() == 10) {
                                sqldb.inserteligibility(jsonObjectcourse.getString("course_name"), arrayList.get(0), arrayList.get(1), arrayList.get(2), arrayList.get(3), arrayList.get(4), arrayList.get(5), arrayList.get(6), arrayList.get(7), arrayList.get(8), arrayList.get(9));

                            } else if (arrayList.size() == 8) {
                                sqldb.inserteligibility(jsonObjectcourse.getString("course_name"), arrayList.get(0), arrayList.get(1), arrayList.get(2), arrayList.get(3), arrayList.get(4), arrayList.get(5), arrayList.get(6), arrayList.get(7));

                            } else if (arrayList.size() == 6) {
                                sqldb.inserteligibility(jsonObjectcourse.getString("course_name"), arrayList.get(0), arrayList.get(1), arrayList.get(2), arrayList.get(3), arrayList.get(4), arrayList.get(5));

                            } else if (arrayList.size() == 4) {
                                sqldb.inserteligibility(jsonObjectcourse.getString("course_name"), arrayList.get(0), arrayList.get(1), arrayList.get(2), arrayList.get(3));

                            } else if (arrayList.size() == 2) {
                                sqldb.inserteligibility(jsonObjectcourse.getString("course_name"), arrayList.get(0), arrayList.get(1));

                            } else {
                                sqldb.inserteligibility(jsonObjectcourse.getString("course_name"));

                            }


                            try {
                                currencyobj=jsonObjectcourse.getJSONObject("currency");
                                currencyval.add(currencyobj.getString("symbol"));
                            }catch (JSONException e){

                            }


                            DataModelClassForCourse dataModelClassForCourse = new DataModelClassForCourse(jsonArrayunv.getJSONObject(0).getString("university_name"), jsonObjectcourse.getString("course_name"), jsonObjectcourse.getString("course"), jsonObjectcourse.getString("year"), jsonObjectcourse.getString("time"),
                                    jsonObjectcourse.getString("total_fee"), jsonObjectcourse.getString("syllabus"));

                            arrayListcourse.add(dataModelClassForCourse);
                            Log.w("sizewwwwwwwwww12", String.valueOf(arrayListcourse.size()));
                            adapterforfilter.notifyDataSetChanged();
                            a = null;
                            Loc_splited = "";
                            loc_spilt = null;

                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    p2.setVisibility(View.GONE);

                    acess = true;
                    // Log.w("dfdfdfd",response);


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.w("erorrrrrrrrrrrrrrrrr", error);

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {


                    Map<String, String> map = new HashMap<String, String>();
                    map.put("course_id", courseid);


                    return map;
                }
            };
            que.add(request);


        }


    private void sendUnvDetails(String university_namey) {
        int countcheck = sqldb.count_UniversityDetails(university_namey);
        if (countcheck > 0) {
            Log.w("sjjsjsjsjjsjsjs", "skippppppppppppppppp");


        } else {


            RequestQueue que = Volley.newRequestQueue(getApplicationContext());

            StringRequest request = new StringRequest(Request.Method.POST, urluvn_filter1, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {


                    try {
                        JSONObject jsonObjectr = new JSONObject(response);
                        JSONArray jsn = jsonObjectr.getJSONArray("university");
                        JSONObject jsonObject = jsn.getJSONObject(0);
                        jsonArray1y = jsonObject.getJSONArray("university_details");
                        for (int j = 0; j < jsonArray1y.length(); j++) {
                            jsonObject1y = jsonArray1y.getJSONObject(j);

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



















////
//
//
//

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


    public void get_filterFirst(String courseid)  {
        RequestQueue que = Volley.newRequestQueue(getApplicationContext());

        StringRequest request = new StringRequest(Request.Method.POST, urluvn_filter, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.w("firest rsponseee",response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                   // arrayListcourse = new ArrayList<>();
                    JSONArray jsn =jsonObject.getJSONArray("course");
                    for(int i = 0;i<6;i++){
                        jsonObjectcourse = jsn.getJSONObject(i);
                        jsonArrayunv= jsonObjectcourse.getJSONArray("university");
                        // jsonArrayunv= jsonObjectcourse.getJSONArray("university");
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
                        arrayListUcFee.add(new filterdataClass(arrayList));







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
                        arrayListUCentrance.add(new filterdataClass(arrayList));


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
                        arrayListUCEligibility.add(new filterdataClass(arrayList));

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




                        DataModelClassForCourse dataModelClassForCourse = new DataModelClassForCourse(jsonArrayunv.getJSONObject(0).getString("university_name"), jsonObjectcourse.getString("course_name"), jsonObjectcourse.getString("course"), jsonObjectcourse.getString("year"), jsonObjectcourse.getString("time"),
                                jsonObjectcourse.getString("total_fee"), jsonObjectcourse.getString("syllabus"));

                        arrayListcourse.add(dataModelClassForCourse);
                        Log.w("sizewwwwwwwwww", String.valueOf(arrayListcourse.size()));


//                        adapterforfilter= new AdapterClassForFilter(getApplicationContext(),arrayListcourse);
//                        linearLayoutManager=new LinearLayoutManager(getApplicationContext());
//                        recyclerView.setLayoutManager(linearLayoutManager);
//                        recyclerView.setAdapter(adapterforfilter);
                        Loc_splited="";
                        a=null;
                        loc_spilt=null;
                        acess=true;


                    }




                } catch (JSONException e) {
                    e.printStackTrace();
                }
                p1.setVisibility(View.GONE);
                adapterforfilter.notifyDataSetChanged();







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



                Map<String,String> map=new HashMap<String, String>();
                map.put("course_id", courseid);


                return map;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(4000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        que.add(request);


    }
}