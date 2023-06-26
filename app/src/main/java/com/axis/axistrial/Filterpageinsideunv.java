package com.axis.axistrial;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Filterpageinsideunv extends AppCompatActivity {
    Button applyButton,getrating,getlocation,getcountry;
    SQLDB sqldb;
    int count=0;
    JSONObject jsonObject1;
    JSONArray jsonArray;
    String Country_values="";
    String Rating_values="";
    String Location_values="";
    String university_name="";
    String urluvn_filter="https://axisoverseascareers.in/api/university/filter";
    ArrayAdapter baseAdapter,baseAdapter1,baseAdapter2;
    String url="https://axisoverseascareers.in/api/university/city";
    String urlC="https://axisoverseascareers.in/api/university/country";
    JSONArray jsonAccom,jsonInAccom;
    JSONObject jsonObjectAccom,jsonObjectInAccom;
    ProgressBar progressBarforfilter;




    ArrayList<String>arrayListlocation;
    ArrayAdapter<String> adapter,adapter1,adapter2;
    ArrayList<UnvdataClass> arrayList;
    ArrayList<String> arrayListcountry;
    ArrayList<UnvdataClass> arrayListfil;
    ArrayList<String> arrayList1,arrayList1location,arrayList1country,arraylistFilter;
    Set<String> set,set1,set2,setfilter;
    ArrayList<String> list,list1,list2,listAuto;
    ListView listView,listView1,listView2;
    Boolean Rating_bool,Location_bool=false,Country_bool=false;
    LinearLayout lay1,lay2,lay3;
    List<String> listup;
    HashMap<String,String> Country_map,Rating_map,Location_map;
    String countrytemp="",ratingtemp="",locationtemp="";
    Button applyfilterbutton;
    ArrayList<UnvdataClass>arrayListup;
    TextView CloseButton;

    @Override
    public void onBackPressed() {
        Intent i=new Intent(Filterpageinsideunv.this,FirstPageInsideUniversity.class);
        startActivity(i);
    }
    public void getcountry(){
        RequestQueue queue= Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, urlC, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            //JSONObject obj=new JSONObject(String.valueOf(response));
                            jsonArray = response.getJSONArray("country");
                            Log.w("yipppppp", String.valueOf(jsonArray.length()));

                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                arrayListcountry.add(  jsonObject.getString("country"));
                                //  arrayList1country.add(jsonObject.getJSONArray("university_details").getJSONObject(0).getString("country"));





                            }
                            for(int i = 0;i<arrayListcountry.size();i++){
                                if(!arrayListcountry.get(i).equals("")){
                                    set2.add(arrayListcountry.get(i));

                                }



                            }
                            list2.addAll(set2);
                            baseAdapter2=new ArrayAdapter(getApplicationContext(),R.layout.filter_filter,list2);
                            listView2.setAdapter(baseAdapter2);



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

        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

// Access the RequestQueue through your singleton class.
        queue.add(jsonObjectRequest);




    }





    public void scrollto_L1(int position){

        listView1.setSelection(position);

    }
    public void scrollto_L2(int position){

        listView2.setSelection(position);

    }

    /////////////////////university jason
    private void getjsondata() {


        RequestQueue queue= Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            //JSONObject obj=new JSONObject(String.valueOf(response));
                            jsonArray = response.getJSONArray("city");
                            Log.w("yipppppp", String.valueOf(jsonArray.length()));

                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                arrayListlocation.add(  jsonObject.getString("city"));
                              //  arrayList1country.add(jsonObject.getJSONArray("university_details").getJSONObject(0).getString("country"));





                            }
                            for(int i = 0;i<arrayListlocation.size();i++){
                                    set1.add(arrayListlocation.get(i));

                            }
                            list1.addAll(set1);
                            baseAdapter1=new ArrayAdapter(getApplicationContext(),R.layout.filter_filter,list1);
                            listView1.setAdapter(baseAdapter1);


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

        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

// Access the RequestQueue through your singleton class.
        queue.add(jsonObjectRequest);

    }

    public void get_filter() {
        if (Country_values.length() > 0 || Rating_values.length() > 0 || Location_values.length() > 0) {


        RequestQueue que = Volley.newRequestQueue(getApplicationContext());

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
                        arrayList.add(unvdataClass);
                    }


                    Intent i = new Intent(Filterpageinsideunv.this, FromUniversityFilter.class);
                    i.putExtra("universityfilter_name", arrayList);
                    i.putExtra("arraysize", arrayList.size());
                    //i.putExtra("univ_name",university_name);
                    startActivity(i);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Intent i = new Intent(Filterpageinsideunv.this, ErrorFilterPage.class);
                i.putExtra("ErrorFromUniversity", "unv");
                startActivity(i);
                Rating_values = "";

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> map = new HashMap<String, String>();
                map.put("unv_name", university_name);
                map.put("country", Country_values);
                map.put("rating", Rating_values);
                map.put("city", Location_values);

                return map;
            }
        };
        que.add(request);
    }
        else{
            progressBarforfilter.setVisibility(View.GONE);
            Toast.makeText(getApplicationContext(), "Select a Field", Toast.LENGTH_SHORT).show();
        }


    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filterpageinsideunv);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        }
        sqldb=new SQLDB(this);
        sqldb.deletetable();
        // ctv=findViewById(android.view.text1);
        lay1=findViewById(R.id.layoutt1);
        lay2=findViewById(R.id.layoutt2);
        lay3=findViewById(R.id.layoutt3);

        Rating_map= new HashMap<>();

        Location_map =new HashMap<>();

        Country_map=new HashMap<>();

        arrayList=new ArrayList<>();








        getrating=findViewById(R.id.rating_id_id);
        progressBarforfilter=findViewById(R.id.progressBarforfilter);
        //     arrayListfil=new ArrayList<>();
        //   arrayListfil=sqldb.getuniv_details();
        arrayList1=new ArrayList<>();


        getrating.setBackgroundColor(getResources().getColor(R.color.light_blue));


        set = new HashSet<>();
        list= new ArrayList<>();

        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");
        list.addAll(set);



        listView=findViewById(R.id.listm_id);
        baseAdapter=new ArrayAdapter(this, R.layout.filter_filter,list);
        listView.setAdapter(baseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String rating= (String) parent.getItemAtPosition(position);
                ratingtemp="";

                if(Rating_map.containsKey(rating)){
                    Rating_map.remove(rating);
                }else{

                    Rating_map.put(rating,rating +",");}
                Log.w("kssaaaaaaaaaaaaaa", String.valueOf(Rating_map.size()));
                for(String x:Rating_map.values()){
                    ratingtemp=ratingtemp+x;
                }


                Log.w("kkkkkkkkkkkkkk",ratingtemp);


            }
        });






//        /// LOCATION
        lay2.setVisibility(View.GONE);
        CloseButton=findViewById(R.id.close_filter_id);
        CloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inn=new Intent(Filterpageinsideunv.this,FirstPageInsideUniversity.class);
                startActivity(inn);
            }
        });



        arrayListlocation=new ArrayList<>();
        //arrayListlocation=sqldb.getuniv_details();
        arrayList1location=new ArrayList<>();


        set1 = new HashSet<>();
        list1= new ArrayList<>();




        listView1=findViewById(R.id.listm_id1);

        //baseAdapter1=new ArrayAdapter(this, R.layout.filter_filter,list1);
        //listView1.setAdapter(baseAdapter1);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String location= (String) parent.getItemAtPosition(position);

                locationtemp="";

                if(Location_map.containsKey(location)){
                    Location_map.remove(location);
                }else{



                    Location_map.put(location,location +",");}
                Log.w("kssaaaaaaaaaaaaaa", String.valueOf(Location_map.size()));
                for(String x:Location_map.values()){
                    locationtemp=locationtemp+x;
                }


                Log.w("kkkkkkkkkkkkkk",locationtemp);
            }
        });


//
//
//
//
//
////        COUNTRY
//
        lay3.setVisibility(View.GONE);
        AutoCompleteTextView auto =findViewById(R.id.filter_search);
        arraylistFilter=new ArrayList<>();


        arrayListcountry=new ArrayList<String>();
        arrayList1country=new ArrayList<>();


        set2 = new HashSet<>();
        list2= new ArrayList<>();




        listView2=findViewById(R.id.listm_id2);
        //  baseAdapter2=new ArrayAdapter(this,R.layout.filter_filter,list2);
        //listView2.setAdapter(baseAdapter2);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String country= (String) parent.getItemAtPosition(position);

                countrytemp="";

                if(Country_map.containsKey(country)){
                    Country_map.remove(country);
                }else{

                    Country_map.put(country,country +",");}
                Log.w("kssaaaaaaaaaaaaaa", String.valueOf(Country_map.size()));
                for(String x:Country_map.values()){
                    countrytemp=countrytemp+x;
                }

                Log.w("kkkkkkkkkkkkkk",countrytemp);
            }
        });













        auto.setVisibility(View.GONE);


        ////////////AUTOCOMPLETE
        getjsondata();
        getcountry();


























        //////


























        getrating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getcountry.setBackgroundColor(getResources().getColor(R.color.grey));
                getrating.setBackgroundColor(getResources().getColor(R.color.light_blue));
                getlocation.setBackgroundColor(getResources().getColor(R.color.grey));


                lay1=findViewById(R.id.layoutt1);
                lay2=findViewById(R.id.layoutt2);
                lay3=findViewById(R.id.layoutt3);
                lay1.setVisibility(View.VISIBLE);
                auto.setVisibility(View.GONE);
                lay2.setVisibility(View.GONE);
                lay3.setVisibility(View.GONE);





            }});




        getlocation=findViewById(R.id.location_id_id);
        getlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                getcountry.setBackgroundColor(getResources().getColor(R.color.grey));
                getrating.setBackgroundColor(getResources().getColor(R.color.grey));
                getlocation.setBackgroundColor(getResources().getColor(R.color.light_blue));
                lay1=findViewById(R.id.layoutt1);
                lay2=findViewById(R.id.layoutt2);
                lay3=findViewById(R.id.layoutt3);
                auto.setVisibility(View.VISIBLE);
                lay1.setVisibility(View.GONE);
                lay2.setVisibility(View.VISIBLE);
                lay3.setVisibility(View.GONE);
                Location_bool=true;
                setfilter = new HashSet<>();
                listAuto= new ArrayList<>();

                for(int i = 0;i<list1.size();i++){

                    setfilter.add(list1.get(i));

                }
                listAuto.addAll(setfilter);


                ArrayAdapter<String> adapter
                        = new ArrayAdapter<String>(
                        getApplicationContext(),
                        R.layout.autoc_filter,
                        listAuto);

                // Give the suggestion after 1 words.
                auto.setThreshold(2);


                // Set the adapter for data as a list
                auto.setAdapter(adapter);
                auto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Log.w("yoooooooooooooooooo","selecteddddd");

                        for(String x:list1){
                            Log.w("jooooooooo", x);
                            if(x.equals(auto.getText().toString())){
                                scrollto_L1(count);
                                Log.w("jokkkkkkkkkkk", String.valueOf(count));

                            }

                            Log.w("jo", String.valueOf(count));
                            count= count+1;
                        }

                        count=0;

                        auto.setText("");

                    }
                });
                auto.setTextColor(Color.BLACK);







            }
        });


        getcountry=findViewById(R.id.country_id_id);
        getcountry.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {

                getcountry.setBackgroundColor(getResources().getColor(R.color.light_blue));
                getrating.setBackgroundColor(getResources().getColor(R.color.grey));
                getlocation.setBackgroundColor(getResources().getColor(R.color.grey));
                lay1=findViewById(R.id.layoutt1);
                lay2=findViewById(R.id.layoutt2);
                lay3=findViewById(R.id.layoutt3);
                lay1.setVisibility(View.GONE);
                auto.setVisibility(View.VISIBLE);
                lay2.setVisibility(View.GONE);
                lay3.setVisibility(View.VISIBLE);
                Country_bool=true;
                setfilter = new HashSet<>();
                listAuto= new ArrayList<>();

                for(int i = 0;i<list2.size();i++){

                    setfilter.add(list2.get(i));

                }
                listAuto.addAll(setfilter);


                ArrayAdapter<String> adapter
                        = new ArrayAdapter<String>(
                        getApplicationContext(),
                        android.R.layout.select_dialog_item,
                        listAuto);

                // Give the suggestion after 1 words.
                auto.setThreshold(2);
                auto.getAutofillHints();



                // Set the adapter for data as a list
                auto.setAdapter(adapter);
                auto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Log.w("yoooooooooooooooooo","selecteddddd");

                        for(String x:list1){
                            Log.w("jooooooooo", x);
                            if(x.equals(auto.getText().toString())){
                                scrollto_L2(count);
                                Log.w("jokkkkkkkkkkk", String.valueOf(count));

                            }

                            Log.w("jo", String.valueOf(count));
                            count= count+1;
                        }

                        count=0;

                        auto.setText("");
                    }
                });
                auto.setTextColor(Color.BLACK);









            }
        });


        applyfilterbutton=findViewById(R.id.applyfilterbutton);
        applyfilterbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    progressBarforfilter.setVisibility(View.VISIBLE);
                    filterset();


//                Intent in=new Intent(Filterpageinsideunv.this,FirstPageInsideUniversity.class);
//                startActivity(in);
            }
        });














    }

    private void filterset() {






//        for(String x:Country_map.values()){
//            countrytemp=countrytemp+x;
//        }



        ////////country querry

        if(countrytemp.length()>1){
            String[] test= countrytemp.split(",");
            for(int i = 0;i< test.length;i++){

                Country_values =Country_values+'"'+test[i]+'"'+',';

            }
            int b= Country_values.length();
            Country_values=Country_values.substring(0,b-1);}

        Log.w("splitF",Country_values);


        ///////



        ////// rating querry

        if(ratingtemp.length()>1){
            String[] test= ratingtemp.split(",");
            for(int i = 0;i< test.length;i++){

                Rating_values =Rating_values+'"'+test[i]+'"'+',';

            }
            int c= Rating_values.length();
            Rating_values=Rating_values.substring(0,c-1);


        }
        Log.w("kksksksksks",university_name);



        Log.w("splitF",Rating_values);


        /////////



        ///// location querry
        if(locationtemp.length()>1){
            String[] test= locationtemp.split(",");
            for(int i = 0;i< test.length;i++){

                Location_values =Location_values+'"'+test[i]+'"'+',';

            }
            int f= Location_values.length();
            Location_values=Location_values.substring(0,f-1);
        }

        Log.w("splitF",Location_values);


        /////////////



        Country_map.clear();
        Rating_map.clear();
        Location_map.clear();
        countrytemp="";
        ratingtemp="";
        locationtemp="";
        get_filter();



    }



}