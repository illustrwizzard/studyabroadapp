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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
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
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
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

public class Filterpage_inside_course extends AppCompatActivity {

    String fee_end_values,fee_start_values;
    String University_values="";
    String Course_type_values="";
    String urluvn_filter="https://axisoverseascareers.in/api/course/filter";
    JSONObject jsonObjectcourse;
    ArrayList<DataModelClassForCourse> arrayListcourse;
    JSONArray jsonArray,jsonArrayunv;
    JSONArray jsonArray2,jsonArray3,jsonArray4,jsonArray5,jsonArray6,jsonArrayEnt,jsonArrayElg,jsonArrayCfee;
    JSONObject jsonObjectProcedurey,jsonObject1y;
    JSONArray jsonArray6y,jsonArray1y;
    ArrayList<String > arrayList;
    ArrayList<DataModelClassForCourse>arrayListData;

    private static int SPLASH_SCREEN_TIME_OUT=2000;
    //String url="https://app.axisjobs.in/api/university";
    String url="https://axisoverseascareers.in/api/university";
    JSONArray jsonArraycourse;

    ArrayAdapter baseAdapter2;

    Button applyButton,getfee,getcoursetype,getuniversity;
    SQLDB sqldb;
    int count=0;
    EditText start_price,end_price;
    ArrayAdapter<String> adapter,adapter1,adapter2;
    ArrayList<DataModelClassForCourse> arrayListF;
    ArrayList<DataModelClassForCourse> arraycoursetype;
    ArrayList<String> arrayListUniversity;
    ArrayList<UnvdataClass> arrayListfil;
    ArrayList<String> arrayList1,arrayListcoursetype_string,arrayListuniversity_string,arraylistFilter;
    Set<String> set,set1,set2,setfilter;
    ArrayList<String> list,list1,list2,listAuto;
    ListView listView,listView1,listView2;
    Boolean Rating_bool,Location_bool=false,Country_bool=false;
    LinearLayout lay1,lay2,lay3;
    String temp="";
    List<String> listup;
    int changed_value=0;
    HashMap<String,String>  University_map,Fee_map,Course_type_map;
    String University_temp="",Feetemp="",Course_type_temp="";
    Button applyfilterbutton;
    ArrayList<filterdataClass>arrayListUcFee;
    ArrayList<filterdataClass>arrayListUCentrance;
    ArrayList<filterdataClass>arrayListUCEligibility;
    TextView close_courseFilter;
    ProgressBar progressBarCourseFilter;
    String currencysymbol="$";



//    @Override
//    public void onBackPressed() {
//        Intent i=new Intent(Filterpage_inside_course.this,FirstPageInsideCoursee.class);
//        startActivity(i);
//    }


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
                            jsonArray = response.getJSONArray("university");
                            Log.w("yipppppp", String.valueOf(jsonArray.length()));

                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                jsonObject.getString("university_name");
                                arrayListuniversity_string.add( jsonObject.getString("university_name"));






                            }
                            for(int i = 0;i<arrayListuniversity_string.size();i++){

                                set2.add(arrayListuniversity_string.get(i));

                            }
                            list2.addAll(set2);
                            baseAdapter2.notifyDataSetChanged();

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







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filterpage_inside_course);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }


        sqldb=new SQLDB(this);
        // ctv=findViewById(android.view.text1);
        lay1=findViewById(R.id.layouttC1);
        lay2=findViewById(R.id.layouttC2);
        lay3=findViewById(R.id.layouttC3);
        progressBarCourseFilter=findViewById(R.id.progressBarinCourse);

        close_courseFilter=findViewById(R.id.close_courseFilter);
        close_courseFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(Filterpage_inside_course.this,FirstPageInsideCoursee.class);
                startActivity(j);
            }
        });




        arrayListUcFee=new ArrayList<>();
        arrayListUCentrance=new ArrayList<>();
        arrayListUCEligibility=new ArrayList<>();
        arrayList=new ArrayList<>();


        Fee_map= new HashMap<>();

        Course_type_map =new HashMap<>();

        University_map=new HashMap<>();

        arrayListF=new ArrayList<>();
        arraycoursetype=new ArrayList<>();
        arrayListUniversity=new ArrayList<>();


        getfee=findViewById(R.id.fee_id_id);

        getfee.setBackgroundColor(getResources().getColor(R.color.light_blue));
        arrayListfil=new ArrayList<>();
      //  arrayListfil=sqldb.getuniv_details();
        arrayList1=new ArrayList<>();
        for (int i=0;i<arrayListfil.size();i++){
            arrayList1.add(arrayListfil.get(i).getRating());
        }

        set = new HashSet<>();
        list= new ArrayList<>();

        for(int i = 0;i<arrayList1.size();i++){

            set.add(arrayList1.get(i));

        }
        list.addAll(set);








//        /// LOCATION
        lay2.setVisibility(View.GONE);




       // arrayListlocation=sqldb.getcourse_details();
        arrayListcoursetype_string=new ArrayList<>();

            arrayListcoursetype_string.add("UG");
        arrayListcoursetype_string.add("PG");


        set1 = new HashSet<>();
        list1= new ArrayList<>();

        for(int i = 0;i<arrayListcoursetype_string.size();i++){

            set1.add(arrayListcoursetype_string.get(i));

        }
        list1.addAll(set1);


        listView1=findViewById(R.id.listm_id1);

        ArrayAdapter baseAdapter1=new ArrayAdapter(this, R.layout.filter_filter,list1);
        listView1.setAdapter(baseAdapter1);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String location= (String) parent.getItemAtPosition(position);

                Course_type_temp="";

                if(Course_type_map.containsKey(location)){
                    Course_type_map.remove(location);
                }else{
                    String[] loc_spilt=location.split(",");
                    String Loc_splited="";
                    for(int i=0;i<loc_spilt.length;i++){

                        Loc_splited=Loc_splited+loc_spilt[i];
                    }


                    Course_type_map.put(location,Loc_splited +",");}
                Log.w("kssaaaaaaaaaaaaaa", String.valueOf(Course_type_map.size()));
                for(String x:Course_type_map.values()){
                    Course_type_temp=Course_type_temp+x;
                }


                Log.w("kkkkkkkkkkkkkk",Course_type_temp);
            }
        });



//
////        COUNTRY
//
        lay3.setVisibility(View.GONE);
        AutoCompleteTextView auto =findViewById(R.id.filter_search);
        arraylistFilter=new ArrayList<>();


        arrayListUniversity=new ArrayList<>();
       // arrayListcountry=sqldb.getcourse_details();
        arrayListuniversity_string=new ArrayList<>();
        for (int i=0;i<arrayListUniversity.size();i++){
            arrayListuniversity_string.add(arrayListUniversity.get(i));
        }

        set2 = new HashSet<>();
        list2= new ArrayList<>();
        getjsondata();

        for(int i = 0;i<arrayListuniversity_string.size();i++){

            set2.add(arrayListuniversity_string.get(i));

        }
        list2.addAll(set2);


        listView2=findViewById(R.id.listm_id2);
         baseAdapter2=new ArrayAdapter(this,R.layout.filter_filter,list2);
        listView2.setAdapter(baseAdapter2);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String country= (String) parent.getItemAtPosition(position);

                University_temp="";

                if(University_map.containsKey(country)){
                    University_map.remove(country);
                }else{

                    University_map.put(country,country +",");}
                Log.w("kssaaaaaaaaaaaaaa", String.valueOf(University_map.size()));
                for(String x:University_map.values()){
                    University_temp=University_temp+x;
                }

                Log.w("kkkkkkkkkkkkkk",University_temp);
            }
        });







        auto.setVisibility(View.GONE);


        ////////////AUTOCOMPLETE




        CrystalRangeSeekbar seekBar=findViewById(R.id.PRICEseekBarID);

        start_price=findViewById(R.id.start);
        end_price=findViewById(R.id.end);



        seekBar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                Log.w("seeeek","minimum value"+minValue.toString()+"maximum value"+maxValue.toString());
                start_price.setText(minValue.toString());
                end_price.setText(maxValue.toString());

            }
        });






        getfee.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                getfee.setBackgroundColor(getResources().getColor(R.color.light_blue));
                getcoursetype.setBackgroundColor(getResources().getColor(R.color.grey));
                getuniversity.setBackgroundColor(getResources().getColor(R.color.grey));

                lay1=findViewById(R.id.layouttC1);
                lay2=findViewById(R.id.layouttC2);
                lay3=findViewById(R.id.layouttC3);
                lay1.setVisibility(View.VISIBLE);
                auto.setVisibility(View.GONE);
                lay2.setVisibility(View.GONE);
                lay3.setVisibility(View.GONE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    // seekBar.setMin(1000);
                    // seekBar.setMax(10000000);
                }


            }});




        getcoursetype=findViewById(R.id.course_type_id_id);
        getcoursetype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getcoursetype.setBackgroundColor(getResources().getColor(R.color.light_blue));
                getuniversity.setBackgroundColor(getResources().getColor(R.color.grey));
                getfee.setBackgroundColor(getResources().getColor(R.color.grey));
                lay1=findViewById(R.id.layouttC1);
                lay2=findViewById(R.id.layouttC2);
                lay3=findViewById(R.id.layouttC3);
                auto.setVisibility(View.GONE);
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


        getuniversity=findViewById(R.id.Uuniversity_id_id);
        getuniversity.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {

                getuniversity.setBackgroundColor(getResources().getColor(R.color.light_blue));
                getfee.setBackgroundColor(getResources().getColor(R.color.grey));
                getcoursetype.setBackgroundColor(getResources().getColor(R.color.grey));
                lay1=findViewById(R.id.layouttC1);
                lay2=findViewById(R.id.layouttC2);
                lay3=findViewById(R.id.layouttC3);
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
                        R.layout.autoc_filter,
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

                        for(String x:list2){
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


        applyfilterbutton=findViewById(R.id.applyfilterbuttonincourse);
        applyfilterbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBarCourseFilter.setVisibility(View.VISIBLE);
                filterset();

            }
        });








    }

    private void filterset() {

        Intent intent=new Intent(getApplicationContext(),FirstPageInsideCoursee.class);

        fee_start_values=start_price.getText().toString();//
        fee_end_values=end_price.getText().toString();//

        String university_name="";




        ////////country querry

        if(University_temp.length()>1){

            String[] test= University_temp.split(",");



            Log.w("university_temp", String.valueOf(test.length));
            for(int i = 0;i< test.length;i++){

                University_values=University_values+'"'+test[i]+'"'+',';

            }
            int b= University_values.length();
            University_values=University_values.substring(0,b-1);}

        Log.w("splitF",University_values);



        ///// location querry
        if(Course_type_temp.length()>1){
            String[] test= Course_type_temp.split(",");
            for(int i = 0;i< test.length;i++){

                Course_type_values =Course_type_values+'"'+test[i]+'"'+',';

            }
            int f= Course_type_values.length();
            Course_type_values=Course_type_values.substring(0,f-1);
        }

        Log.w("splitF",Course_type_values);


        /////////////
        try {
            get_filter();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void get_filter() throws Exception {
        RequestQueue que = Volley.newRequestQueue(getApplicationContext());

     StringRequest request = new StringRequest(Request.Method.POST, urluvn_filter, new Response.Listener<String>() {
         @Override
         public void onResponse(String response) {

             Log.w("dfdfdfd",response);

             try {
                 JSONObject jsonObject = new JSONObject(response);
                 arrayListcourse = new ArrayList<>();
                 JSONArray jsn =jsonObject.getJSONArray("course");
                 for(int i = 0;i<jsn.length();i++){
                     jsonObjectcourse = jsn.getJSONObject(i);



                     temp=temp+jsonObjectcourse.getString("course_id")+",";





                 }





             } catch (JSONException e) {
                 e.printStackTrace();
             }
             Intent i = new Intent(getApplicationContext(),FromFilterTo.class);

             temp=temp.substring(0,temp.length()-1);
             Log.w("ooooooooooooppppp",temp);
             i.putExtra("arrayList",temp);

             startActivity(i);

         }
     }, new Response.ErrorListener() {
         @Override
         public void onErrorResponse(VolleyError error) {
             Intent i=new Intent(Filterpage_inside_course.this,ErrorFilterPage.class);
             i.putExtra("ErrorFromCourse","crs");
             startActivity(i);

         }
     }){
             @Override
    protected Map<String, String> getParams() throws AuthFailureError
    {

        Map<String,String> map=new HashMap<String, String>();
        map.put("unv_name",University_values);
        map.put("fee_start_price",fee_start_values);
        map.put("fee_end_price",fee_end_values);
        map.put("Course_type",Course_type_values);

        return map;
    }
     };
     que.add(request);


    }
}

