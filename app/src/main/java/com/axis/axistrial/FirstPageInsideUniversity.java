package com.axis.axistrial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
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
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
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

import de.hdodenhof.circleimageview.CircleImageView;

public class FirstPageInsideUniversity extends AppCompatActivity  {
    JSONObject jsonObject1,jsonObjectFeed,jsonObjectProcedure,jsonObjectAccom,jsonObjectInAccom;
    JSONArray jsonAccom,jsonInAccom;
    ImageView img;
    Boolean isscrolling=false,fill=true,set1=false,flagrefresh=true;
    CircleImageView selectflag;
    String urluvn_filter="https://axisoverseascareers.in/api/university/filter";
    TextView unvtitle;
    RelativeLayout blurlayout;
    String university_name;
    int count;
    SQLDB sqldb;
    int Totalchild,current,showing,totalget,jsonsize,filtersize;
    JSONArray jsonArray2;
    JSONArray jsonArray;
    ProgressBar pg1;
    boolean insidefilter=false;
    ArrayAdapter<String> adapter;
    View progressBar;
    SwipeRefreshLayout swipeRefreshLayout;
    View view;
    int flag=0;
    AutoCompleteTextView autoCompleteTextView;
    //url="https://axisoverseascareers.in/api/university/filter"
    String url_univ="https://axisoverseascareers.in/api/university/university_name";
        int z=0;


    ArrayList<UnvdataClass>arrayListSearch;
    ArrayList<String>arrayListfacility;
    ArrayList<String>arrayListAffliation;
    ArrayList<String>arrayListProcedure;
    ArrayList<String>arrayListFeed;
    ArrayList<String> arrayListRank;
    ArrayList<String>arrayListAccomodation;
    Boolean flagclear=true;


    ArrayList<String> list;
    Set<String> set;
    LinearLayoutManager linearLayoutManager;
   // String url="https://app.axisjobs.in/api/university";
    String url="https://axisoverseascareers.in/api/university";
    ArrayList<UnvdataClass> arrayList,arrayListF;
    RecyclerView recyclerView;
    AdapterClassForUniversity adapterClassForUniversity;
    ArrayList<String> rankarray;
    JSONArray jsonArray3;
    JSONArray jsonArray1,jsonArray4,jsonArray5,jsonArray6;



    Button aboutbutton,Btn6,showfilterpageid;
    ImageView sav_unv;





    @Override
    public void onBackPressed() {
        Intent i=new Intent(FirstPageInsideUniversity.this,BottomNavEx.class);
        startActivity(i);
    }




    public void setFlag() {
        flag=1;
        Log.w("yooo","Inside setflag");
    }
    public void get_univ_name(){
        RequestQueue queue=Volley.newRequestQueue(this);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url_univ, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsn = response.getJSONArray("university_name");
                    for (int i = 0 ;i<jsn.length();i++){

                        list.add(jsn.getJSONObject(i).getString("university_name"));



                    }




                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(request);


    }



    public void get_filter_country(String country) {
        RequestQueue que = Volley.newRequestQueue(getApplicationContext());
        sqldb.deletetable();
        arrayList.clear();
        arrayListF.clear();

        StringRequest request = new StringRequest(Request.Method.POST, urluvn_filter, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.w("ggggggggggg", response);

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsn = jsonObject.getJSONArray("university");
                    for (int i = 0; i < jsn.length(); i++) {
                        JSONObject jsonObject1 = jsn.getJSONObject(i).getJSONArray("university_details").getJSONObject(0);


                        sqldb.insertuniv_details(jsn.getJSONObject(i).getString("university_name"), jsonObject1.getString("rating"),
                                jsonObject1.getString("estd"), jsonObject1.getString("status"), jsonObject1.getString("sector"),
                                jsonObject1.getString("about"), jsonObject1.getString("banner"), jsonObject1.getString("logo"), jsonObject1.getString("location"), jsonObject1.getString("city"), jsonObject1.getString("country"), jsonObject1.getString("contact")
                                , jsonObject1.getString("email"), jsonObject1.getString("website"));


                        JSONArray jsonArray2 = jsn.getJSONObject(i).getJSONArray("university_ranking");
                        ArrayList<String> arrayListRank = new ArrayList<String>();
                        // arrayList=new ArrayList<>();
                        for (int l = 0; l < jsonArray2.length(); l++) {
                            arrayListRank.add(jsonArray2.getJSONObject(l).getString("name"));
                            arrayListRank.add(jsonArray2.getJSONObject(l).getString("ranking"));

                        }

                        if (arrayListRank.size() == 12) {

                            sqldb.insertrank(jsn.getJSONObject(i).getString("university_name"), arrayListRank.get(0), arrayListRank.get(1), arrayListRank.get(2), arrayListRank.get(3), arrayListRank.get(4), arrayListRank.get(5)
                                    , arrayListRank.get(6), arrayListRank.get(7), arrayListRank.get(8), arrayListRank.get(9), arrayListRank.get(10), arrayListRank.get(11));

                        } else if (arrayListRank.size() == 10) {

                            sqldb.insertrank(jsn.getJSONObject(i).getString("university_name"), arrayListRank.get(0), arrayListRank.get(1), arrayListRank.get(2), arrayListRank.get(3), arrayListRank.get(4), arrayListRank.get(5)
                                    , arrayListRank.get(6), arrayListRank.get(7), arrayListRank.get(8), arrayListRank.get(9));

                        } else if (arrayListRank.size() == 8) {

                            sqldb.insertrank(jsn.getJSONObject(i).getString("university_name"), arrayListRank.get(0), arrayListRank.get(1), arrayListRank.get(2), arrayListRank.get(3), arrayListRank.get(4), arrayListRank.get(5)
                                    , arrayListRank.get(6), arrayListRank.get(7));

                        } else if (arrayListRank.size() == 6) {

                            sqldb.insertrank(jsn.getJSONObject(i).getString("university_name"), arrayListRank.get(0), arrayListRank.get(1), arrayListRank.get(2), arrayListRank.get(3), arrayListRank.get(4), arrayListRank.get(5)
                            );

                        } else if (arrayListRank.size() == 4) {
                            sqldb.insertrank(jsn.getJSONObject(i).getString("university_name"), arrayListRank.get(0), arrayListRank.get(1), arrayListRank.get(2), arrayListRank.get(3));

                        } else if (arrayListRank.size() == 2) {
                            sqldb.insertrank(jsn.getJSONObject(i).getString("university_name"), arrayListRank.get(0), arrayListRank.get(1));

                        } else {
                            sqldb.insertrank(jsn.getJSONObject(i).getString("university_name"));

                        }


                        JSONArray jsonArray3 = jsn.getJSONObject(i).getJSONArray("university_affiliation");
                        ArrayList<String> arrayListAffliation = new ArrayList<>();
                        for (int z = 0; z < jsonArray3.length(); z++) {
                            arrayListAffliation.add(jsonArray3.getJSONObject(z).getString("university_affiliated"));

                        }


                        if (arrayListAffliation.size() == 6) {
                            sqldb.insertaffi(jsn.getJSONObject(i).getString("university_name"), arrayListAffliation.get(0), arrayListAffliation.get(1), arrayListAffliation.get(2), arrayListAffliation.get(3)
                                    , arrayListAffliation.get(4), arrayListAffliation.get(5));
                        } else if (arrayListAffliation.size() == 5) {
                            sqldb.insertaffi(jsn.getJSONObject(i).getString("university_name"), arrayListAffliation.get(0), arrayListAffliation.get(1), arrayListAffliation.get(2), arrayListAffliation.get(3)
                                    , arrayListAffliation.get(4));
                        } else if (arrayListAffliation.size() == 4) {
                            sqldb.insertaffi(jsn.getJSONObject(i).getString("university_name"), arrayListAffliation.get(0), arrayListAffliation.get(1), arrayListAffliation.get(2), arrayListAffliation.get(3));

                        } else if (arrayListAffliation.size() == 3) {
                            sqldb.insertaffi(jsn.getJSONObject(i).getString("university_name"), arrayListAffliation.get(0), arrayListAffliation.get(1), arrayListAffliation.get(2));
                        } else if (arrayListAffliation.size() == 2) {
                            sqldb.insertaffi(jsn.getJSONObject(i).getString("university_name"), arrayListAffliation.get(0), arrayListAffliation.get(1));

                        } else if (arrayListAffliation.size() == 1) {
                            sqldb.insertaffi(jsn.getJSONObject(i).getString("university_name"), arrayListAffliation.get(0));

                        } else {
                            sqldb.insertaffi(jsn.getJSONObject(i).getString("university_name"));

                        }


                        JSONArray jsonArray4 = jsn.getJSONObject(i).getJSONArray("facility");
                        ArrayList<String> arrayListfacility = new ArrayList<>();
                        for (int m = 0; m < jsonArray4.length(); m++) {
                            arrayListfacility.add(jsonArray4.getJSONObject(m).getString("facilities"));

                        }

                        if (arrayListfacility.size() == 6) {

                            sqldb.insertfacility(jsn.getJSONObject(i).getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1), arrayListfacility.get(2),
                                    arrayListfacility.get(3), arrayListfacility.get(4), arrayListfacility.get(5));
                        } else if (arrayListfacility.size() == 5) {

                            sqldb.insertfacility(jsn.getJSONObject(i).getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1), arrayListfacility.get(2),
                                    arrayListfacility.get(3), arrayListfacility.get(4));
                        } else if (arrayListfacility.size() == 4) {

                            sqldb.insertfacility(jsn.getJSONObject(i).getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1), arrayListfacility.get(2),
                                    arrayListfacility.get(3));
                        } else if (arrayListfacility.size() == 3) {

                            sqldb.insertfacility(jsn.getJSONObject(i).getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1), arrayListfacility.get(2));
                        } else if (arrayListfacility.size() == 2) {

                            sqldb.insertfacility(jsn.getJSONObject(i).getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1));
                        } else if (arrayListfacility.size() == 1) {
                            sqldb.insertfacility(jsn.getJSONObject(i).getString("university_name"), arrayListfacility.get(0));

                        } else {
                            sqldb.insertfacility(jsn.getJSONObject(i).getString("university_name"));

                        }


                        JSONArray jsonArray5 = jsn.getJSONObject(i).getJSONArray("university_feed");
                        for (int r = 0; r < jsonArray5.length(); r++) {
                            JSONObject jsonObjectFeed = jsonArray5.getJSONObject(r);
                            sqldb.insert_unv_feed(jsn.getJSONObject(i).getString("university_name"), jsonObjectFeed.getString("feed"), jsonObjectFeed.getString("feed_image"), jsonObjectFeed.getString("youtube"));

                        }


                        JSONArray jsonArray6 = jsn.getJSONObject(i).getJSONArray("university_procedures");
                        // arrayListProcedure=new ArrayList<>();

                        for (int k = 0; k < jsonArray6.length(); k++) {
                            JSONObject jsonObjectProcedure = jsonArray6.getJSONObject(k);
                            sqldb.insert_unv_procedures(jsn.getJSONObject(i).getString("university_name"), jsonObjectProcedure.getString("apply"), jsonObjectProcedure.getString("visa"), jsonObjectProcedure.getString("service"), jsonObjectProcedure.getString("documents"));


                        }


                        try {

                            jsonAccom = jsn.getJSONObject(i).getJSONArray("accommodation");

                            if (jsonAccom.length() != 0) {
                                for (int p = 0; p < jsonAccom.length(); p++) {
                                    jsonObjectAccom = jsonAccom.getJSONObject(p);
                                    jsonInAccom = jsonObjectAccom.getJSONArray("accomadation_details");
                                    for (int q = 0; q < jsonInAccom.length(); q++) {
                                        jsonObjectInAccom = jsonInAccom.getJSONObject(q);
                                        sqldb.insert_un_accomodation(jsn.getJSONObject(i).getString("university_name"), jsonObjectAccom.getString("hst_name"), jsonObjectInAccom.getString("room_type"), jsonObjectInAccom.getString("duration"), jsonObjectInAccom.getString("fee"));
                                    }
                                }
                            } else {
                                Log.w("no value", "nooo value");
                                sqldb.insert_un_accomodation(jsn.getJSONObject(i).getString("university_name"), null, null, null, null);

                            }

                        } catch (Exception e) {
                            Log.w("fffffffffffffffffffff", e);

                        }


//

                        UnvdataClass unvdataClass = new UnvdataClass(jsn.getJSONObject(i).getString("university_name"), jsonObject1.getString("city"), jsonObject1.getString("estd"), jsonObject1.getString("rating"), jsonObject1.getString("logo"));
                        arrayListF.add(unvdataClass);
                    }


                    adapterClassForUniversity=new AdapterClassForUniversity(FirstPageInsideUniversity.this,arrayListF);

                    recyclerView.setAdapter(adapterClassForUniversity);
                    pg1.setVisibility(View.INVISIBLE);


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
                map.put("unv_name", "");
                map.put("country", '"'+country+'"');
                map.put("rating", "");
                map.put("city", "");

                return map;
            }
        };
        que.add(request);


    }



    @SuppressLint("NonConstantResourceId")
    public void checkid(View V) {

        switch (V.getId()) {
            case R.id.indiaflag: {



                selectflag.setImageResource(R.drawable.flag_canada);
                view.setVisibility(View.GONE);
                blurlayout.setAlpha(1);
                flag=0;
                pg1.setVisibility(View.VISIBLE);
                get_filter_country("Canada");
                flagclear=false;
                break;

            }
            case R.id.spainid: {
                view.setVisibility(View.GONE);
                selectflag.setImageResource(R.drawable.flag_sweden);
                blurlayout.setAlpha(1);
                flag=0;
                pg1.setVisibility(View.VISIBLE);
                get_filter_country("Sweden");
                flagclear=false;


                break;

            }

            case R.id.germanyid: {
                view.setVisibility(View.GONE);

                selectflag.setImageResource(R.drawable.flag_latvia);
                blurlayout.setAlpha(1);
                flag=0;
                pg1.setVisibility(View.VISIBLE);
                get_filter_country("Latvia");
                flagclear=false;
                break;

            }

            case R.id.taiwanid: {
                view.setVisibility(View.GONE);

                selectflag.setImageResource(R.drawable.flag_czech_republic);
                blurlayout.setAlpha(1);
                flag=0;
                pg1.setVisibility(View.VISIBLE);
                get_filter_country("Czech Republic");
                flagclear=false;
                break;

            }


            case R.id.egyptid: {
                view.setVisibility(View.GONE);

                selectflag.setImageResource(R.drawable.flag_poland);
                blurlayout.setAlpha(1);
                flag=0;
                pg1.setVisibility(View.VISIBLE);
                get_filter_country("Poland");
                flagclear=false;
                break;

            }


            case R.id.australiid: {
                view.setVisibility(View.GONE);

                selectflag.setImageResource(R.drawable.flag_lithuania);
                blurlayout.setAlpha(1);
                flag=0;
                pg1.setVisibility(View.VISIBLE);
                get_filter_country("Lithuania");
                flagclear=false;
                break;

            }
            default:


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /////////
        setContentView(R.layout.inside_university_first);
        img=findViewById(R.id.first_page_backbtn);
        get_univ_name();
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FirstPageInsideUniversity.this,BottomNavEx.class);
                startActivity(i);
            }
        });
        pg1=findViewById(R.id.progressBar3);
        progressBar= findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        sqldb =new SQLDB(this);
        sqldb.deletetable();

        autoCompleteTextView=findViewById(R.id.search_text);
        Btn6=findViewById(R.id.search_button);
        arrayListF=new ArrayList<>();

        arrayListSearch=sqldb.getuniv_details();
        set = new HashSet<>();
        list= new ArrayList<>();

         adapter
                = new ArrayAdapter<String>(
                this,
                R.layout.autoc_filter,
                list);

        // Give the suggestion after 1 words.
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.w("yoooooooooooooooooo","selecteddddd");

                for(String x:list){
                    Log.w("jooooooooo", x);
                    if(x.equals(autoCompleteTextView.getText().toString())){

                        university_name='"'+x+'"';
                        pg1.setVisibility(View.VISIBLE);
                        get_filter();

                        Log.w("jokkkkkkkkkkk", String.valueOf(count));


                    }

                    Log.w("jo", String.valueOf(count));
                    count= count+1;
                }

                count=0;

                autoCompleteTextView.setText("");

            }


        });

        // Set the adapter for data as a list
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setTextColor(Color.BLACK);



        showfilterpageid=findViewById(R.id.showfilterpageid);
        showfilterpageid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FirstPageInsideUniversity.this,Filterpageinsideunv.class);
                startActivity(i);
            }
        });
















        /////////
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }


       // sqldb.deletetable();

        blurlayout=findViewById(R.id.blurlayout1);
        recyclerView=findViewById(R.id.recycleviewinunv_id);
        arrayList=new ArrayList<>();
        getjsondata();
        sav_unv=findViewById(R.id.save_unv);

        selectflag=findViewById(R.id.selectimage_id1);
        view=findViewById(R.id.include_flag_id1);
        selectflag.setOnClickListener(v -> {
            if(flag==1){

                view.setVisibility(View.GONE);
                flag=0;
                blurlayout.setAlpha(1);
                Log.w("yooo","Inside if");
            }
            else {

                view.setVisibility(View.VISIBLE);

                blurlayout.setAlpha((float) 0.3);
                setFlag();
                Log.w("yooo","Inside else");
            }

        });
        aboutbutton=findViewById(R.id.inbutton);
        swipeRefreshLayout=findViewById(R.id.swipe);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (insidefilter==false){
                if(flagrefresh){
                Totalchild=0;current=0;showing=0;totalget=0;jsonsize=0;
                arrayListF.clear();
              //  sqldb.deletetable();
                adapterClassForUniversity.notifyDataSetChanged();
                set1=false;
                isscrolling=false;
                fill=true;
                progressBar.setVisibility(View.INVISIBLE);
                pg1.setVisibility(View.VISIBLE);

                getjsondata();

                flagrefresh=false;
                swipeRefreshLayout.setRefreshing(false);}
            }
            else{
                flagrefresh=false;
                    swipeRefreshLayout.setRefreshing(false);}}
        });

        linearLayoutManager=new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(linearLayoutManager);
        adapterClassForUniversity=new AdapterClassForUniversity(FirstPageInsideUniversity.this,arrayListF);

        recyclerView.setAdapter(adapterClassForUniversity);
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
                if(isscrolling & (current+showing==Totalchild)&linearLayoutManager.getItemCount()<jsonsize&fill&flagclear){
                    isscrolling=false;

                    fill=false;

                    progressBar.setVisibility(recyclerView.VISIBLE);
                    totalget=linearLayoutManager.getItemCount();
                    Log.w("","entered scroll");

                    new recAsYNC1().execute();


                }}





            }
        });









    }


    public void get_filter() {
        sqldb.deletetable();
        arrayList.clear();
        arrayListF.clear();
        adapterClassForUniversity.notifyDataSetChanged();
        //sqldb.deletetable();
        RequestQueue que = Volley.newRequestQueue(getApplicationContext());

        StringRequest request = new StringRequest(Request.Method.POST, urluvn_filter, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.w("responseeee",response);


                try {
                    JSONObject res = new JSONObject(response);
                    //JSONObject obj=new JSONObject(String.valueOf(response));
                    jsonArray = res.getJSONArray("university");
                    for (int i = 0; i < jsonArray.length(); i++) {


                            //jsonsize=jsonArray.length();
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                            jsonArray1=jsonObject.getJSONArray("university_details");
                            for (int j=0;j<jsonArray1.length();j++){
                                jsonObject1=jsonArray1.getJSONObject(j);

                                sqldb.insertuniv_details(jsonObject.getString("university_name"),jsonObject1.getString("rating"),
                                        jsonObject1.getString("estd"),jsonObject1.getString("status"),jsonObject1.getString("sector"),
                                        jsonObject1.getString("about"),jsonObject1.getString("banner"),jsonObject1.getString("logo"),jsonObject1.getString("location"),jsonObject1.getString("city"),jsonObject1.getString("country"),jsonObject1.getString("contact")
                                        ,jsonObject1.getString("email"),jsonObject1.getString("website"));


                            }
                            jsonArray2= jsonObject.getJSONArray("university_ranking");
                            arrayListRank=new ArrayList<String>();
                            // arrayList=new ArrayList<>();
                            for(int l =0;l<jsonArray2.length();l++){
                                arrayListRank.add(jsonArray2.getJSONObject(l).getString("name"));
                                arrayListRank.add(jsonArray2.getJSONObject(l).getString("ranking"));

                            }

                            if(arrayListRank.size()==12){

                                sqldb.insertrank(jsonArray.getJSONObject(i).getString("university_name"), arrayListRank.get(0), arrayListRank.get(1),arrayListRank.get(2), arrayListRank.get(3),arrayListRank.get(4), arrayListRank.get(5)
                                        ,arrayListRank.get(6), arrayListRank.get(7),arrayListRank.get(8), arrayListRank.get(9),arrayListRank.get(10), arrayListRank.get(11));

                            }
                            else if(arrayListRank.size()==10){

                                sqldb.insertrank(jsonArray.getJSONObject(i).getString("university_name"), arrayListRank.get(0), arrayListRank.get(1),arrayListRank.get(2), arrayListRank.get(3),arrayListRank.get(4), arrayListRank.get(5)
                                        ,arrayListRank.get(6), arrayListRank.get(7),arrayListRank.get(8), arrayListRank.get(9));

                            }

                            else if(arrayListRank.size()==8){

                                sqldb.insertrank(jsonArray.getJSONObject(i).getString("university_name"), arrayListRank.get(0), arrayListRank.get(1),arrayListRank.get(2), arrayListRank.get(3),arrayListRank.get(4), arrayListRank.get(5)
                                        ,arrayListRank.get(6), arrayListRank.get(7));

                            }
                            else  if(arrayListRank.size()==6){

                                sqldb.insertrank(jsonArray.getJSONObject(i).getString("university_name"), arrayListRank.get(0), arrayListRank.get(1),arrayListRank.get(2), arrayListRank.get(3),arrayListRank.get(4), arrayListRank.get(5)
                                );

                            }else if(arrayListRank.size()==4){
                                sqldb.insertrank(jsonArray.getJSONObject(i).getString("university_name"), arrayListRank.get(0), arrayListRank.get(1),arrayListRank.get(2), arrayListRank.get(3));

                            }else if(arrayListRank.size()==2){
                                sqldb.insertrank(jsonArray.getJSONObject(i).getString("university_name"), arrayListRank.get(0), arrayListRank.get(1));

                            }else {
                                sqldb.insertrank(jsonArray.getJSONObject(i).getString("university_name"));

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
                                sqldb.insertaffi(jsonArray.getJSONObject(i).getString("university_name"),arrayListAffliation.get(0),arrayListAffliation.get(1),arrayListAffliation.get(2),arrayListAffliation.get(3)
                                        ,arrayListAffliation.get(4),arrayListAffliation.get(5));
                            }else  if(arrayListAffliation.size()==5){
                                sqldb.insertaffi(jsonArray.getJSONObject(i).getString("university_name"),arrayListAffliation.get(0),arrayListAffliation.get(1),arrayListAffliation.get(2),arrayListAffliation.get(3)
                                        ,arrayListAffliation.get(4));
                            }else  if(arrayListAffliation.size()==4){
                                sqldb.insertaffi(jsonArray.getJSONObject(i).getString("university_name"),arrayListAffliation.get(0),arrayListAffliation.get(1),arrayListAffliation.get(2),arrayListAffliation.get(3));

                            }else  if(arrayListAffliation.size()==3){
                                sqldb.insertaffi(jsonArray.getJSONObject(i).getString("university_name"),arrayListAffliation.get(0),arrayListAffliation.get(1),arrayListAffliation.get(2));
                            }else if(arrayListAffliation.size()==2){
                                sqldb.insertaffi(jsonArray.getJSONObject(i).getString("university_name"),arrayListAffliation.get(0),arrayListAffliation.get(1));

                            }else if(arrayListAffliation.size()==1){
                                sqldb.insertaffi(jsonArray.getJSONObject(i).getString("university_name"),arrayListAffliation.get(0));

                            }else {
                                sqldb.insertaffi(jsonArray.getJSONObject(i).getString("university_name"));

                            }
















                            jsonArray4= jsonObject.getJSONArray("facility");
                            arrayListfacility=new ArrayList<>();
                            for(int m=0;m<jsonArray4.length();m++){
                                arrayListfacility.add(jsonArray4.getJSONObject(m).getString("facilities"));

                            }

                            if (arrayListfacility.size()==6) {

                                sqldb.insertfacility(jsonArray.getJSONObject(i).getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1), arrayListfacility.get(2),
                                        arrayListfacility.get(3), arrayListfacility.get(4), arrayListfacility.get(5));
                            }else if (arrayListfacility.size()==5) {

                                sqldb.insertfacility(jsonArray.getJSONObject(i).getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1), arrayListfacility.get(2),
                                        arrayListfacility.get(3), arrayListfacility.get(4));
                            }else if (arrayListfacility.size()==4) {

                                sqldb.insertfacility(jsonArray.getJSONObject(i).getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1), arrayListfacility.get(2),
                                        arrayListfacility.get(3));
                            }else if (arrayListfacility.size()==3) {

                                sqldb.insertfacility(jsonArray.getJSONObject(i).getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1), arrayListfacility.get(2));
                            }else if (arrayListfacility.size()==2) {

                                sqldb.insertfacility(jsonArray.getJSONObject(i).getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1));
                            }
                            else if(arrayListfacility.size()==1){
                                sqldb.insertfacility(jsonArray.getJSONObject(i).getString("university_name"), arrayListfacility.get(0));

                            }else {
                                sqldb.insertfacility(jsonArray.getJSONObject(i).getString("university_name"));

                            }




                            jsonArray5=jsonObject.getJSONArray("university_feed");
                            for (int r=0;r<jsonArray5.length();r++){
                                jsonObjectFeed=jsonArray5.getJSONObject(r);
                                sqldb.insert_unv_feed(jsonArray.getJSONObject(i).getString("university_name"),jsonObjectFeed.getString("feed"),jsonObjectFeed.getString("feed_image"),jsonObjectFeed.getString("youtube"));

                            }
                            jsonArray6= jsonObject.getJSONArray("university_procedures");
                            // arrayListProcedure=new ArrayList<>();

                            for(int k=0;k<jsonArray6.length();k++){
                                jsonObjectProcedure=jsonArray6.getJSONObject(k);
                                sqldb.insert_unv_procedures(jsonArray.getJSONObject(i).getString("university_name"),jsonObjectProcedure.getString("apply"),jsonObjectProcedure.getString("visa"),jsonObjectProcedure.getString("service"),jsonObjectProcedure.getString("documents"));



                            }




                            try {
                                jsonAccom = jsonObject.getJSONArray("accommodation");

                                if(jsonAccom.length()!=0) {
                                    for (int p = 0; p < jsonAccom.length(); p++) {
                                        jsonObjectAccom = jsonAccom.getJSONObject(p);
                                        jsonInAccom = jsonObjectAccom.getJSONArray("accomadation_details");
                                        for (int q = 0; q < jsonInAccom.length(); q++) {
                                            jsonObjectInAccom = jsonInAccom.getJSONObject(q);
                                            sqldb.insert_un_accomodation(jsonArray.getJSONObject(i).getString("university_name"), jsonObjectAccom.getString("hst_name"), jsonObjectInAccom.getString("room_type"), jsonObjectInAccom.getString("duration"), jsonObjectInAccom.getString("fee"));
                                        }
                                    }
                                }else {
                                    Log.w("no value","nooo value");
                                    sqldb.insert_un_accomodation(jsonArray.getJSONObject(i).getString("university_name"), null, null, null, null);

                                }

                            }catch (Exception e){
                                Log.w("fffffffffffffffffffff",e);

                            }

//



//                            UnvdataClass unvdataClass = new UnvdataClass(jsonObject.getString("university_name"),jsonObject1.getString("rating"),jsonObject1.getString("estd"),jsonObject1.getString("status"),jsonObject1.getString("sector"),jsonObject1.getString("about"), jsonObject1.getString("banner"),jsonObject1.getString("logo"),jsonObject1.getString("location"),jsonObject1.getString("city"),jsonObject1.getString("country"),jsonObject1.getString("contact"),jsonObject1.getString("email"),jsonObject1.getString("website"));
//                            arrayList.add(unvdataClass);
//                            adapterClassForUniversity.notifyDataSetChanged();
//                                    linearLayoutManager=new LinearLayoutManager(getApplicationContext());
//
//                                    recyclerView.setLayoutManager(linearLayoutManager);
//                                    adapterClassForUniversity=new AdapterClassForUniversity(FirstPageInsideUniversity.this,arrayList,jsonArray1,jsonArray,arrayListRank,arrayListAffliation,arrayListfacility,arrayListFeed,arrayListProcedure,arrayListAccomodation);
//                                    recyclerView.setAdapter(adapterClassForUniversity);
//                                    Log.w("keeeepepepepe", String.valueOf(arrayList.size()));



                        pg1.setVisibility(View.INVISIBLE);

                        UnvdataClass unvdataClass = new UnvdataClass(jsonObject.getString("university_name"),jsonObject1.getString("rating"),jsonObject1.getString("estd"),jsonObject1.getString("status"),jsonObject1.getString("sector"),jsonObject1.getString("about"), jsonObject1.getString("banner"),jsonObject1.getString("logo"),jsonObject1.getString("location"),jsonObject1.getString("city"),jsonObject1.getString("country"),jsonObject1.getString("contact"),jsonObject1.getString("email"),jsonObject1.getString("website"));
                        arrayListF.add(unvdataClass);
                        adapterClassForUniversity=new AdapterClassForUniversity(FirstPageInsideUniversity.this,arrayListF);
                        Log.w("keeeepepepepe", String.valueOf(arrayListF.size()));
                        recyclerView.setAdapter(adapterClassForUniversity);

                    }

                    fill=true;
                    progressBar.setVisibility(View.INVISIBLE);

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
                map.put("unv_name",university_name);
                map.put("country","");
                map.put("rating","");
                map.put("city","");

                return map;
            }
        };
        que.add(request);


    }








    private void getjsondata(){
        if(insidefilter==false){

        if (set1){

            Log.w("","entered getdata");
        RequestQueue queue=Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        if(totalget<=jsonsize){

                        try {
                            //JSONObject obj=new JSONObject(String.valueOf(response));
                            jsonArray = response.getJSONArray("university");
                            for (int i = totalget; i < totalget+5; i++) {
                                if(i<=jsonsize-1){

                                    jsonsize=jsonArray.length();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                jsonArray1=jsonObject.getJSONArray("university_details");
                                for (int j=0;j<jsonArray1.length();j++){
                                    jsonObject1=jsonArray1.getJSONObject(j);

                                    sqldb.insertuniv_details(jsonObject.getString("university_name"),jsonObject1.getString("rating"),
                                            jsonObject1.getString("estd"),jsonObject1.getString("status"),jsonObject1.getString("sector"),
                                            jsonObject1.getString("about"),jsonObject1.getString("banner"),jsonObject1.getString("logo"),jsonObject1.getString("location"),jsonObject1.getString("city"),jsonObject1.getString("country"),jsonObject1.getString("contact")
                                            ,jsonObject1.getString("email"),jsonObject1.getString("website"));


                                }
                                    jsonArray2= jsonObject.getJSONArray("university_ranking");
                                    arrayListRank=new ArrayList<String>();
                                    // arrayList=new ArrayList<>();
                                    for(int l =0;l<jsonArray2.length();l++){
                                        arrayListRank.add(jsonArray2.getJSONObject(l).getString("name"));
                                        arrayListRank.add(jsonArray2.getJSONObject(l).getString("ranking"));

                                    }

                                    if(arrayListRank.size()==12){

                                        sqldb.insertrank(jsonArray.getJSONObject(i).getString("university_name"), arrayListRank.get(0), arrayListRank.get(1),arrayListRank.get(2), arrayListRank.get(3),arrayListRank.get(4), arrayListRank.get(5)
                                                ,arrayListRank.get(6), arrayListRank.get(7),arrayListRank.get(8), arrayListRank.get(9),arrayListRank.get(10), arrayListRank.get(11));

                                    }
                                    else if(arrayListRank.size()==10){

                                        sqldb.insertrank(jsonArray.getJSONObject(i).getString("university_name"), arrayListRank.get(0), arrayListRank.get(1),arrayListRank.get(2), arrayListRank.get(3),arrayListRank.get(4), arrayListRank.get(5)
                                                ,arrayListRank.get(6), arrayListRank.get(7),arrayListRank.get(8), arrayListRank.get(9));

                                    }

                                    else if(arrayListRank.size()==8){

                                        sqldb.insertrank(jsonArray.getJSONObject(i).getString("university_name"), arrayListRank.get(0), arrayListRank.get(1),arrayListRank.get(2), arrayListRank.get(3),arrayListRank.get(4), arrayListRank.get(5)
                                                ,arrayListRank.get(6), arrayListRank.get(7));

                                    }
                                    else  if(arrayListRank.size()==6){

                                        sqldb.insertrank(jsonArray.getJSONObject(i).getString("university_name"), arrayListRank.get(0), arrayListRank.get(1),arrayListRank.get(2), arrayListRank.get(3),arrayListRank.get(4), arrayListRank.get(5)
                                                );

                                    }else if(arrayListRank.size()==4){
                                        sqldb.insertrank(jsonArray.getJSONObject(i).getString("university_name"), arrayListRank.get(0), arrayListRank.get(1),arrayListRank.get(2), arrayListRank.get(3));

                                    }else if(arrayListRank.size()==2){
                                        sqldb.insertrank(jsonArray.getJSONObject(i).getString("university_name"), arrayListRank.get(0), arrayListRank.get(1));

                                    }else {
                                        sqldb.insertrank(jsonArray.getJSONObject(i).getString("university_name"));

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
                                        sqldb.insertaffi(jsonArray.getJSONObject(i).getString("university_name"),arrayListAffliation.get(0),arrayListAffliation.get(1),arrayListAffliation.get(2),arrayListAffliation.get(3)
                                                ,arrayListAffliation.get(4),arrayListAffliation.get(5));
                                    }else  if(arrayListAffliation.size()==5){
                                        sqldb.insertaffi(jsonArray.getJSONObject(i).getString("university_name"),arrayListAffliation.get(0),arrayListAffliation.get(1),arrayListAffliation.get(2),arrayListAffliation.get(3)
                                                ,arrayListAffliation.get(4));
                                    }else  if(arrayListAffliation.size()==4){
                                        sqldb.insertaffi(jsonArray.getJSONObject(i).getString("university_name"),arrayListAffliation.get(0),arrayListAffliation.get(1),arrayListAffliation.get(2),arrayListAffliation.get(3));

                                    }else  if(arrayListAffliation.size()==3){
                                        sqldb.insertaffi(jsonArray.getJSONObject(i).getString("university_name"),arrayListAffliation.get(0),arrayListAffliation.get(1),arrayListAffliation.get(2));
                                    }else if(arrayListAffliation.size()==2){
                                        sqldb.insertaffi(jsonArray.getJSONObject(i).getString("university_name"),arrayListAffliation.get(0),arrayListAffliation.get(1));

                                    }else if(arrayListAffliation.size()==1){
                                        sqldb.insertaffi(jsonArray.getJSONObject(i).getString("university_name"),arrayListAffliation.get(0));

                                    }else {
                                        sqldb.insertaffi(jsonArray.getJSONObject(i).getString("university_name"));

                                    }
















                                    jsonArray4= jsonObject.getJSONArray("facility");
                                    arrayListfacility=new ArrayList<>();
                                    for(int m=0;m<jsonArray4.length();m++){
                                        arrayListfacility.add(jsonArray4.getJSONObject(m).getString("facilities"));

                                    }

                                    if (arrayListfacility.size()==6) {

                                        sqldb.insertfacility(jsonArray.getJSONObject(i).getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1), arrayListfacility.get(2),
                                                arrayListfacility.get(3), arrayListfacility.get(4), arrayListfacility.get(5));
                                    }else if (arrayListfacility.size()==5) {

                                        sqldb.insertfacility(jsonArray.getJSONObject(i).getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1), arrayListfacility.get(2),
                                                arrayListfacility.get(3), arrayListfacility.get(4));
                                    }else if (arrayListfacility.size()==4) {

                                        sqldb.insertfacility(jsonArray.getJSONObject(i).getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1), arrayListfacility.get(2),
                                                arrayListfacility.get(3));
                                    }else if (arrayListfacility.size()==3) {

                                        sqldb.insertfacility(jsonArray.getJSONObject(i).getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1), arrayListfacility.get(2));
                                    }else if (arrayListfacility.size()==2) {

                                        sqldb.insertfacility(jsonArray.getJSONObject(i).getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1));
                                    }
                                    else if(arrayListfacility.size()==1){
                                        sqldb.insertfacility(jsonArray.getJSONObject(i).getString("university_name"), arrayListfacility.get(0));

                                    }else {
                                        sqldb.insertfacility(jsonArray.getJSONObject(i).getString("university_name"));

                                    }




                                    jsonArray5=jsonObject.getJSONArray("university_feed");
                                    for (int r=0;r<jsonArray5.length();r++){
                                        jsonObjectFeed=jsonArray5.getJSONObject(r);
                                        sqldb.insert_unv_feed(jsonArray.getJSONObject(i).getString("university_name"),jsonObjectFeed.getString("feed"),jsonObjectFeed.getString("feed_image"),jsonObjectFeed.getString("youtube"));

                                    }
                                    jsonArray6= jsonObject.getJSONArray("university_procedures");
                                    // arrayListProcedure=new ArrayList<>();

                                    for(int k=0;k<jsonArray6.length();k++){
                                        jsonObjectProcedure=jsonArray6.getJSONObject(k);
                                        sqldb.insert_unv_procedures(jsonArray.getJSONObject(i).getString("university_name"),jsonObjectProcedure.getString("apply"),jsonObjectProcedure.getString("visa"),jsonObjectProcedure.getString("service"),jsonObjectProcedure.getString("documents"));



                                    }




                                    try {
                                        jsonAccom = jsonObject.getJSONArray("accommodation");

                                        if(jsonAccom.length()!=0) {
                                            for (int p = 0; p < jsonAccom.length(); p++) {
                                                jsonObjectAccom = jsonAccom.getJSONObject(p);
                                                jsonInAccom = jsonObjectAccom.getJSONArray("accomadation_details");
                                                for (int q = 0; q < jsonInAccom.length(); q++) {
                                                    jsonObjectInAccom = jsonInAccom.getJSONObject(q);
                                                    sqldb.insert_un_accomodation(jsonArray.getJSONObject(i).getString("university_name"), jsonObjectAccom.getString("hst_name"), jsonObjectInAccom.getString("room_type"), jsonObjectInAccom.getString("duration"), jsonObjectInAccom.getString("fee"));
                                                }
                                            }
                                        }else {
                                            Log.w("no value","nooo value");
                                            sqldb.insert_un_accomodation(jsonArray.getJSONObject(i).getString("university_name"), null, null, null, null);

                                        }

                                    }catch (Exception e){
                                        Log.w("fffffffffffffffffffff",e);

                                    }

//



                               UnvdataClass unvdataClass = new UnvdataClass(jsonObject.getString("university_name"),jsonObject1.getString("rating"),jsonObject1.getString("estd"),jsonObject1.getString("status"),jsonObject1.getString("sector"),jsonObject1.getString("about"), jsonObject1.getString("banner"),jsonObject1.getString("logo"),jsonObject1.getString("location"),jsonObject1.getString("city"),jsonObject1.getString("country"),jsonObject1.getString("contact"),jsonObject1.getString("email"),jsonObject1.getString("website"));
                                arrayListF.add(unvdataClass);
                                adapterClassForUniversity.notifyDataSetChanged();
//                                    linearLayoutManager=new LinearLayoutManager(getApplicationContext());
//
//                                    recyclerView.setLayoutManager(linearLayoutManager);
//                                    adapterClassForUniversity=new AdapterClassForUniversity(FirstPageInsideUniversity.this,arrayList,jsonArray1,jsonArray,arrayListRank,arrayListAffliation,arrayListfacility,arrayListFeed,arrayListProcedure,arrayListAccomodation);
//                                    recyclerView.setAdapter(adapterClassForUniversity);
//                                    Log.w("keeeepepepepe", String.valueOf(arrayList.size()));


                                }
                                else{
                                    i=totalget+4;
                                }



                                pg1.setVisibility(View.INVISIBLE);

                            }

                            fill=true;
                            progressBar.setVisibility(View.INVISIBLE);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        }



                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(2000,4,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

// Access the RequestQueue through your singleton class.
        queue.add(jsonObjectRequest);
        }
        else{
            set1=true;

            RequestQueue queue=Volley.newRequestQueue(this);

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {


                                try {
                                    //JSONObject obj=new JSONObject(String.valueOf(response));
                                    jsonArray = response.getJSONArray("university");
                                    for (int i = 0; i < 5; i++) {


                                            jsonsize=jsonArray.length();
                                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                                        jsonArray1=jsonObject.getJSONArray("university_details");
                                        for (int j=0;j<jsonArray1.length();j++){
                                            jsonObject1=jsonArray1.getJSONObject(j);

                                            sqldb.insertuniv_details(jsonObject.getString("university_name"),jsonObject1.getString("rating"),
                                                    jsonObject1.getString("estd"),jsonObject1.getString("status"),jsonObject1.getString("sector"),
                                                    jsonObject1.getString("about"),jsonObject1.getString("banner"),jsonObject1.getString("logo"),jsonObject1.getString("location"),jsonObject1.getString("city"),jsonObject1.getString("country"),jsonObject1.getString("contact")
                                                    ,jsonObject1.getString("email"),jsonObject1.getString("website"));


                                        }









                                        jsonArray2= jsonObject.getJSONArray("university_ranking");
                                        arrayListRank=new ArrayList<String>();
                                        // arrayList=new ArrayList<>();
                                        for(int l =0;l<jsonArray2.length();l++){
                                            arrayListRank.add(jsonArray2.getJSONObject(l).getString("name"));
                                            arrayListRank.add(jsonArray2.getJSONObject(l).getString("ranking"));

                                        }

                                        if(arrayListRank.size()==12){

                                            sqldb.insertrank(jsonArray.getJSONObject(i).getString("university_name"), arrayListRank.get(0), arrayListRank.get(1),arrayListRank.get(2), arrayListRank.get(3),arrayListRank.get(4), arrayListRank.get(5)
                                                    ,arrayListRank.get(6), arrayListRank.get(7),arrayListRank.get(8), arrayListRank.get(9),arrayListRank.get(10), arrayListRank.get(11));

                                        }
                                        else if(arrayListRank.size()==10){

                                            sqldb.insertrank(jsonArray.getJSONObject(i).getString("university_name"), arrayListRank.get(0), arrayListRank.get(1),arrayListRank.get(2), arrayListRank.get(3),arrayListRank.get(4), arrayListRank.get(5)
                                                    ,arrayListRank.get(6), arrayListRank.get(7),arrayListRank.get(8), arrayListRank.get(9));

                                        }

                                        else if(arrayListRank.size()==8){

                                            sqldb.insertrank(jsonArray.getJSONObject(i).getString("university_name"), arrayListRank.get(0), arrayListRank.get(1),arrayListRank.get(2), arrayListRank.get(3),arrayListRank.get(4), arrayListRank.get(5)
                                                    ,arrayListRank.get(6), arrayListRank.get(7));

                                        }
                                        else  if(arrayListRank.size()==6){

                                            sqldb.insertrank(jsonArray.getJSONObject(i).getString("university_name"), arrayListRank.get(0), arrayListRank.get(1),arrayListRank.get(2), arrayListRank.get(3),arrayListRank.get(4), arrayListRank.get(5)
                                            );

                                        }else if(arrayListRank.size()==4){
                                            sqldb.insertrank(jsonArray.getJSONObject(i).getString("university_name"), arrayListRank.get(0), arrayListRank.get(1),arrayListRank.get(2), arrayListRank.get(3));

                                        }else if(arrayListRank.size()==2){
                                            sqldb.insertrank(jsonArray.getJSONObject(i).getString("university_name"), arrayListRank.get(0), arrayListRank.get(1));

                                        }else {
                                            sqldb.insertrank(jsonArray.getJSONObject(i).getString("university_name"));

                                        }

//


//
                                             jsonArray3= jsonObject.getJSONArray("university_affiliation");
                                        arrayListAffliation=new ArrayList<>();
                                            for(int z=0;z<jsonArray3.length();z++){
                                                arrayListAffliation.add(jsonArray3.getJSONObject(z).getString("university_affiliated"));

                                            }


                                        if(arrayListAffliation.size()==6){
                                            sqldb.insertaffi(jsonArray.getJSONObject(i).getString("university_name"),arrayListAffliation.get(0),arrayListAffliation.get(1),arrayListAffliation.get(2),arrayListAffliation.get(3)
                                                    ,arrayListAffliation.get(4),arrayListAffliation.get(5));
                                        }else  if(arrayListAffliation.size()==5){
                                            sqldb.insertaffi(jsonArray.getJSONObject(i).getString("university_name"),arrayListAffliation.get(0),arrayListAffliation.get(1),arrayListAffliation.get(2),arrayListAffliation.get(3)
                                                    ,arrayListAffliation.get(4));
                                        }else  if(arrayListAffliation.size()==4){
                                            sqldb.insertaffi(jsonArray.getJSONObject(i).getString("university_name"),arrayListAffliation.get(0),arrayListAffliation.get(1),arrayListAffliation.get(2),arrayListAffliation.get(3));

                                        }else  if(arrayListAffliation.size()==3){
                                            sqldb.insertaffi(jsonArray.getJSONObject(i).getString("university_name"),arrayListAffliation.get(0),arrayListAffliation.get(1),arrayListAffliation.get(2));
                                        }else if(arrayListAffliation.size()==2){
                                            sqldb.insertaffi(jsonArray.getJSONObject(i).getString("university_name"),arrayListAffliation.get(0),arrayListAffliation.get(1));

                                        }else if(arrayListAffliation.size()==1){
                                            sqldb.insertaffi(jsonArray.getJSONObject(i).getString("university_name"),arrayListAffliation.get(0));

                                        }else {
                                            sqldb.insertaffi(jsonArray.getJSONObject(i).getString("university_name"));

                                        }
















                                        jsonArray4= jsonObject.getJSONArray("facility");
                                        arrayListfacility=new ArrayList<>();
                                        for(int m=0;m<jsonArray4.length();m++){
                                            arrayListfacility.add(jsonArray4.getJSONObject(m).getString("facilities"));

                                        }

                                        if (arrayListfacility.size()==6) {

                                            sqldb.insertfacility(jsonArray.getJSONObject(i).getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1), arrayListfacility.get(2),
                                                    arrayListfacility.get(3), arrayListfacility.get(4), arrayListfacility.get(5));
                                        }else if (arrayListfacility.size()==5) {

                                            sqldb.insertfacility(jsonArray.getJSONObject(i).getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1), arrayListfacility.get(2),
                                                    arrayListfacility.get(3), arrayListfacility.get(4));
                                        }else if (arrayListfacility.size()==4) {

                                            sqldb.insertfacility(jsonArray.getJSONObject(i).getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1), arrayListfacility.get(2),
                                                    arrayListfacility.get(3));
                                        }else if (arrayListfacility.size()==3) {

                                            sqldb.insertfacility(jsonArray.getJSONObject(i).getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1), arrayListfacility.get(2));
                                        }else if (arrayListfacility.size()==2) {

                                            sqldb.insertfacility(jsonArray.getJSONObject(i).getString("university_name"), arrayListfacility.get(0), arrayListfacility.get(1));
                                        }
                                        else if(arrayListfacility.size()==1){
                                            sqldb.insertfacility(jsonArray.getJSONObject(i).getString("university_name"), arrayListfacility.get(0));

                                        }else {
                                            sqldb.insertfacility(jsonArray.getJSONObject(i).getString("university_name"));

                                        }






















                                        jsonArray5=jsonObject.getJSONArray("university_feed");
                                        for (int r=0;r<jsonArray5.length();r++){
                                            jsonObjectFeed=jsonArray5.getJSONObject(r);
                                            sqldb.insert_unv_feed(jsonArray.getJSONObject(i).getString("university_name"),jsonObjectFeed.getString("feed"),jsonObjectFeed.getString("feed_image"),jsonObjectFeed.getString("youtube"));

                                        }




                                        jsonArray6= jsonObject.getJSONArray("university_procedures");
                                       // arrayListProcedure=new ArrayList<>();

                                        for(int k=0;k<jsonArray6.length();k++){
                                            jsonObjectProcedure=jsonArray6.getJSONObject(k);
                                            sqldb.insert_unv_procedures(jsonArray.getJSONObject(i).getString("university_name"),jsonObjectProcedure.getString("apply"),jsonObjectProcedure.getString("visa"),jsonObjectProcedure.getString("service"),jsonObjectProcedure.getString("documents"));



                                        }



                                        try {
                                            jsonAccom = jsonObject.getJSONArray("accommodation");

                                            if(jsonAccom.length()!=0) {
                                                for (int p = 0; p < jsonAccom.length(); p++) {
                                                    jsonObjectAccom = jsonAccom.getJSONObject(p);
                                                    jsonInAccom = jsonObjectAccom.getJSONArray("accomadation_details");
                                                    for (int q = 0; q < jsonInAccom.length(); q++) {
                                                        jsonObjectInAccom = jsonInAccom.getJSONObject(q);
                                                        sqldb.insert_un_accomodation(jsonArray.getJSONObject(i).getString("university_name"), jsonObjectAccom.getString("hst_name"), jsonObjectInAccom.getString("room_type"), jsonObjectInAccom.getString("duration"), jsonObjectInAccom.getString("fee"));
                                                    }
                                                }
                                            }else {
                                                Log.w("no value","nooo value");
                                                sqldb.insert_un_accomodation(jsonArray.getJSONObject(i).getString("university_name"), null, null, null, null);

                                            }

                                        }catch (Exception e){
                                            Log.w("fffffffffffffffffffff",e);

                                        }






                                        UnvdataClass unvdataClass = new UnvdataClass(jsonObject.getString("university_name"),jsonObject1.getString("rating"),jsonObject1.getString("estd"),jsonObject1.getString("status"),jsonObject1.getString("sector"),jsonObject1.getString("about"), jsonObject1.getString("banner"),jsonObject1.getString("logo"),jsonObject1.getString("location"),jsonObject1.getString("city"),jsonObject1.getString("country"),jsonObject1.getString("contact"),jsonObject1.getString("email"),jsonObject1.getString("website"));
                                            //UnvdataClass unvdataClass = new UnvdataClass("university","londan","1893","5","https://gamingcentral.in/wp-content/uploads/2017/07/48c204c6061ab520d665f83ed5c0e6d0_original.png");
                                            arrayListF.add(unvdataClass);
                                            adapterClassForUniversity.notifyDataSetChanged();




                                        pg1.setVisibility(View.INVISIBLE);



                                    }
                                    flagrefresh=true;

                                    swipeRefreshLayout.setRefreshing(false);
                                    fill=true;
                                    progressBar.setVisibility(View.INVISIBLE);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }



                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // TODO: Handle error


                        }
                    });

            jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,3,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

// Access the RequestQueue through your singleton class.
            queue.add(jsonObjectRequest);


    }
        }

    }

    class recAsYNC1 extends AsyncTask<Void,Void,Void> {



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // progressBar.setVisibility(recyclerView.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            getjsondata();

            return null;
        }
        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);



        }


}

}