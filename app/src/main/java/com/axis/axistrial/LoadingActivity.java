package com.axis.axistrial;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

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

public class LoadingActivity extends AppCompatActivity {
    ArrayList<String> arr, arrayList;
    String urluvn_filter="https://axisoverseascareers.in/api/course/filter";
    String urluvn_filter_course_id="https://axisoverseascareers.in/api/course/course_all";
    SQLDB sqldb;
    String course_id="";
    Boolean bookmark=false,coursemark=false;
    String unv_name,university_namey;
    JSONArray jsonArrayunv;
    JSONArray  jsonArrayEnt, jsonArrayElg, jsonArrayCfee;
    JSONObject jsonObjectcourse;
    String[]a;
    String Course_Id="";
    ProgressBar progressBarLoading;
    String fromunvfilter,Fromcourse;
    String yesyes="";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        }
        progressBarLoading=findViewById(R.id.progressBarLoading);
        sqldb=new SQLDB(this);
       sqldb.delete_upload_count();
        sqldb=new SQLDB(this);
        Intent extra=getIntent();




            Log.w("inside load univ name","yssssss");

        if(extra.getStringExtra("univ_name_bookmark1")!=null){

            university_namey=extra.getStringExtra("univ_name_bookmark1");


        } else if(extra.getStringExtra("univ_name_bookmark")!=null){

                university_namey=extra.getStringExtra("univ_name_bookmark");

            }

        else if(extra.getStringExtra("univ_name_course")!=null){
            university_namey=extra.getStringExtra("univ_name_course");
        }else {
            university_namey=extra.getStringExtra("univ_name");
        }
        //

            Log.w("university----ytt",university_namey+"fgfdgdf");




            get_filter_course();





    }


    public void get_filter_course(){
        RequestQueue queue= Volley.newRequestQueue(this);
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
                //Log.w("universityyyyyyyyyyyyyy",unv_name);
                map.put("unv_name",'"'+university_namey+'"');
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

        Log.w("splitted course",Course_Id);


        sqldb.insert_uploadcount(Course_Id);
        Intent extra=getIntent();

        if(extra.getStringExtra("univ_name_bookmark")!=null&extra.getStringExtra("deleted_bookmark")!=null){
            Intent i=new Intent(LoadingActivity.this,InsideUniversity.class);
            i.putExtra("univ_name_bookmark",university_namey);
            i.putExtra("univ_name",university_namey);
            i.putExtra("deleted","yppp");
            Log.w("Inside Asynctaskkk",Course_Id);
            i.putExtra("course_id",Course_Id);
            startActivity(i);
        }



         else if(extra.getStringExtra("univ_name_course")!=null){
            Intent i=new Intent(LoadingActivity.this,InsideUniversity.class);
            i.putExtra("univ_name_bookmark",university_namey);
            i.putExtra("univ_name",university_namey);
            Log.w("Inside Asynctaskkk",Course_Id);
            i.putExtra("course_id",Course_Id);
            startActivity(i);
        }
          else if(extra.getStringExtra("univ_name_bookmark")!=null){
            Intent i=new Intent(LoadingActivity.this,InsideUniversity.class);
            i.putExtra("univ_name_bookmark",university_namey);
            i.putExtra("univ_name",university_namey);
            Log.w("Inside Asynctaskkk",Course_Id);
            i.putExtra("course_id",Course_Id);
            startActivity(i);
        }
          else if ((extra.getStringExtra("fromCourseUniv")!=null)){

            Log.w("prblm prblm prblm","prblm rblm prblm");
            Intent i=new Intent(LoadingActivity.this,InsideUniversity.class);
            // i.putExtra("univ_name",university_namey);
            i.putExtra("univ_name_bookmark",university_namey);
            if (yesyes.length()>0){
                i.putExtra("fromBook_course_unvr",Fromcourse);

            }


            Log.w("Inside Asynctaskkk",Course_Id);

            i.putExtra("from_course",Fromcourse);

            i.putExtra("course_id",Course_Id);
            //i.putExtra("getfromFirstFilter","getFromFirst");
            i.putExtra("fromunvfilter",fromunvfilter);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }
        else if(extra.getStringExtra("unv_from_course")!=null){
            Log.w("prblm prblm prblm","prblm rblm 2222222");
            Intent i=new Intent(LoadingActivity.this,InsideUniversity.class);
            i.putExtra("univ_name",university_namey);
            Log.w("Inside Asynctaskkk",Course_Id);
            i.putExtra("course_id",Course_Id);
            i.putExtra("unv_from_course","ypp");
           // i.putExtra("getfromFirstFilter","getFromFirst");
           // i.putExtra("fromunvfilter",fromunvfilter);
            i.putExtra("from_course",Fromcourse);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);


        }


else {
        Intent i=new Intent(LoadingActivity.this,InsideUniversity.class);
            Log.w("prblm prblm prblm","prblm rblm 3333333");
        i.putExtra("univ_name",university_namey);

        Log.w("Inside Asynctaskkk",Course_Id);
        i.putExtra("course_id",Course_Id);
        i.putExtra("getfromFirstFilter","getFromFirst");
        i.putExtra("fromunvfilter",fromunvfilter);
       // i.putExtra("from_course",Fromcourse);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
}




    }

    class Asynload extends AsyncTask<Void,Void,Void>{


        @Override
        protected Void doInBackground(Void... voids) {


            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);



        }
    }


}