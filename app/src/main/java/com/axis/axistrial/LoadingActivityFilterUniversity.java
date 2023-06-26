

package com.axis.axistrial;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.AuthFailureError;
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
import java.util.Map;

public class LoadingActivityFilterUniversity extends AppCompatActivity {


    ArrayList<String> arr, arrayList;
    String urluvn_filter="https://axisoverseascareers.in/api/course/filter";
    String urluvn_filter_course_id="https://axisoverseascareers.in/api/course/course_all";
    SQLDB sqldb;
    String course_id="";
    String unv_name,university_namey;
    JSONArray jsonArray1,jsonArray4,jsonArray5,jsonArray6;
    JSONObject jsonObject1,jsonobject2,jsonobject3,jsonobject4,jsonobject5,jsonobject6,jsonObject7,jsonObjectFeed,jsonObjectProcedure,jsonObjectAccom,jsonObjectInAccom;



    JSONArray jsonArray, jsonArrayunv;
    JSONArray  jsonArrayEnt, jsonArrayElg, jsonArrayCfee;
    JSONObject jsonObjectProcedurey, jsonObject1y;
    JSONArray jsonArray6y, jsonArray1y;
    JSONObject jsonObjectcourse;
    String[]a;
    String Course_Id="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_filter_university);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        }
        sqldb=new SQLDB(this);
        Intent extra=getIntent();
        unv_name=extra.getStringExtra("univ_name");


            Asyncload1 asyncload=new Asyncload1();
            asyncload.execute();


    }


    public void get_filter_course(){
        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        StringRequest request = new StringRequest(Request.Method.POST, urluvn_filter, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);

                    JSONArray jsn =jsonObject.getJSONArray("course");
                    for (int i =0;i<jsn.length();i++){

                        Log.w("adapter course name",jsn.getJSONObject(i).getString("course_id"));
                        course_id = course_id+jsn.getJSONObject(i).getString("course_id")+',';

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.w("full course id",course_id);
                splitmyid();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>map = new HashMap<>();
                Log.w("universityyyyyyyyyyyyyy",unv_name);
                map.put("unv_name",'"'+unv_name+'"');
                map.put("fee_start_price","0");
                map.put("fee_end_price","100000");
                map.put("Course_type","");




                return map;
            }
        };
        queue.add(request);



    }
    public  void  splitmyid(){
        a = course_id.split(",");
        for(int  i =0;i<a.length;i++){
            Course_Id= Course_Id+'"'+a[i]+'"'+',';

        }
        int b = Course_Id.length();

        Course_Id=Course_Id.substring(0,b-1);

        get_filter(Course_Id);



    }
    public void get_filter(String courseid)  {
        RequestQueue que = Volley.newRequestQueue(getApplicationContext());

        StringRequest request = new StringRequest(Request.Method.POST, urluvn_filter_course_id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.w("new responseee",response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    // arrayListcourse = new ArrayList<>();
                    JSONArray jsn =jsonObject.getJSONArray("course");
                    for(int i = 0;i<jsn.length();i++){
                        jsonObjectcourse = jsn.getJSONObject(i);
                        jsonArrayunv= jsonObjectcourse.getJSONArray("university");
                        // jsonArrayunv= jsonObjectcourse.getJSONArray("university");
                        sqldb.insertcourse_details(jsonObjectcourse.getJSONArray("university").getJSONObject(0).getString("university_name"),jsonObjectcourse.getString("course_name"),
                                jsonObjectcourse.getString("course"),jsonObjectcourse.getString("year"),jsonObjectcourse.getString("time"),
                                jsonObjectcourse.getString("total_fee"),jsonObjectcourse.getString("syllabus"));


                        // temp=temp+jsonObjectcourse.getString("course_id")+",";

                        university_namey=jsonObjectcourse.getJSONArray("university").getJSONObject(0).getString("university_name");
                        Log.w("universitynameyyyyy",university_namey);
                        //sendUnvDetails(university_namey);




                        //////// course_feeeee
                        jsonArrayCfee= jsonObjectcourse.getJSONArray("course_fee");
                        arrayList=new ArrayList<>();
                        for(int l =0;l<jsonArrayCfee.length();l++){
                            arrayList.add(jsonArrayCfee.getJSONObject(l).getString("term"));
                            arrayList.add(jsonArrayCfee.getJSONObject(l).getString("fee_head"));
                            arrayList.add(jsonArrayCfee.getJSONObject(l).getString("amount"));

                        }
                        // arrayListUcFee.add(new filterdataClass(arrayList));







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
                        // arrayListUCentrance.add(new filterdataClass(arrayList));


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






                    }





                } catch (JSONException e) {
                    e.printStackTrace();
                }

                // p2.setVisibility(View.GONE);

                // acess=true;
                // Log.w("dfdfdfd",response);



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
        que.add(request);


    }
    class Asyncload1 extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            get_filter_course();
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            Intent i=new Intent(LoadingActivityFilterUniversity.this,InsideUniversity.class);
            i.putExtra("univ_name",unv_name);
            i.putExtra("getfromSecondFilter","secondfilter");
            startActivity(i);
        }
    }

}