package com.axis.axistrial;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.volley.AuthFailureError;
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

public class FromUniversityFilter extends AppCompatActivity {
    SQLDB sqldb;
    boolean insidefilter = false;
    String urluvn_filter="https://axisoverseascareers.in/api/university/filter";
    ArrayList<UnvdataClass> arrayList, arrayListF;
    RecyclerView recyclerView;
    int totalget;
    JSONObject jsonObject1, jsonObjectFeed, jsonObjectProcedure, jsonObjectAccom, jsonObjectInAccom;
    JSONArray jsonAccom, jsonInAccom;
    ImageView img;
    Boolean isscrolling = false, fill = true, set1 = false, flagrefresh = true;
    int Totalchild, current, showing, jsonsize, filtersize;
    JSONArray jsonArray2;
    JSONArray jsonArray;
    ProgressBar pg1;
    View progressBar;
    View view;
    Set<String> set;
    int flag = 0;
    String university_name;
    int count;
    AutoCompleteTextView autoCompleteTextView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<UnvdataClass> arrayListSearch;
    ArrayList<String> arrayListfacility;
    ArrayList<String> arrayListAffliation;
    ArrayList<String> arrayListProcedure;
    ArrayList<String> arrayListFeed;
    ArrayList<String> arrayListRank;
    ArrayList<String> arrayListAccomodation;
    String urluvn_filter1;
    ArrayAdapter<String> adapter;
    ArrayList<String> rankarray;
    JSONArray jsonArray3;
    JSONArray jsonArray1, jsonArray4, jsonArray5, jsonArray6;
    AdapterForUniversityFilter adapterClassForUniversity;
    ArrayList<String> list;
    String url_univ="https://axisoverseascareers.in/api/university/university_name";
    Button showfilterpageid2;
    ImageView first_page_backbtn2;








    @Override
    public void onBackPressed() {
        Intent i=new Intent(FromUniversityFilter.this,FirstPageInsideUniversity.class);

        startActivity(i);



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
    public void get_filter() {
        arrayListF.clear();
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
                        arrayListF.add(unvdataClass);
                        adapterClassForUniversity=new AdapterForUniversityFilter(FromUniversityFilter.this,arrayListF);
                        Log.w("keeeepepepepe", String.valueOf(arrayListF.size()));
                        recyclerView.setAdapter(adapterClassForUniversity);

                    }


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_university_filter);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        first_page_backbtn2=findViewById(R.id.first_page_backbtn2);
        first_page_backbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FromUniversityFilter.this,FirstPageInsideUniversity.class);
                startActivity(i);
            }
        });

        showfilterpageid2=findViewById(R.id.showfilterpageid2);
        showfilterpageid2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FromUniversityFilter.this,Filterpageinsideunv.class);
                startActivity(i);
            }
        });




        autoCompleteTextView=findViewById(R.id.search_text2);
        get_univ_name();
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
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setTextColor(Color.BLACK);

        sqldb = new SQLDB(this);

        recyclerView = findViewById(R.id.recycleviewinunv_id2);


        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterClassForUniversity);



        Intent k = getIntent();

        if (k.getParcelableArrayListExtra("universityfilter_name") != null) {
            Log.w("hhhhhhhhhhh", "inside getstring");
            insidefilter = true;
            arrayListF = k.getParcelableArrayListExtra("universityfilter_name");
            totalget = arrayListF.size();
            Log.w("fffffffffff", String.valueOf(totalget));
            getfilter_data(arrayListF);

        }


    }

    public void getfilter_data(ArrayList<UnvdataClass> arrayListF) {

        adapterClassForUniversity=new AdapterForUniversityFilter(FromUniversityFilter.this, arrayListF);
        recyclerView.setAdapter(adapterClassForUniversity);


    }}


