package com.axis.axistrial;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
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


public class InsideUniversityCourseTab extends Fragment {
    String Course_id,temp="";
    ArrayList<DataModelClassForCourse> arraylistcourse;
    String urluvn_filter_course_id="https://axisoverseascareers.in/api/course/course_all";
    SQLDB sqldb;
    Boolean isscrolling=false,acess=true;
    LinearLayoutManager linearLayoutManager;
    ArrayList<String>arrayList;
    String from2;
    int current ,Totalchild,showing;
    FragmentTransaction ft;
    String unv_name,university_namey;
    JSONArray jsonArrayunv;
    JSONArray  jsonArrayEnt, jsonArrayElg, jsonArrayCfee;
    JSONObject jsonObjectcourse;
    String[] a;
    NestedScrollView nestedScrollView;
    ProgressBar progressBarLoading;
    boolean checkbookmark;
    String url="https://app.axisjobs.in/api/course";
    RecyclerView recyclerView;
    AdapterforinsideUnivCourse adapterforinsideUnivCourse;
    int countvalue;
    ArrayList<String>currencysymbol1;
    String from4;


    public InsideUniversityCourseTab(String Course_id, String from2,  boolean checkbookmark, int countvalue,String from4) {
        this.Course_id=Course_id;
        this.from2=from2;
        this.checkbookmark=checkbookmark;
        this.countvalue=countvalue;
        this.from4=from4;



    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        arraylistcourse = new ArrayList<>();
        sqldb = new SQLDB(getContext());
        currencysymbol1=new ArrayList<>();
        Course_id=sqldb.getcount_upload();
        Log.w("inside universitycourse",Course_id);
        View V = inflater.inflate(R.layout.inside_university_course_tab, container, false);
        try {
            splitmyid();
        } catch (Exception e) {
            e.printStackTrace();
        }
        linearLayoutManager=new LinearLayoutManager(V.getContext());


        recyclerView=V.findViewById(R.id.univ_course_rec);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapterforinsideUnivCourse= new AdapterforinsideUnivCourse(getContext(),arraylistcourse,from2,checkbookmark,countvalue,currencysymbol1,from4);
        recyclerView.setAdapter(adapterforinsideUnivCourse);
        nestedScrollView=V.findViewById(R.id.nestedscroll);
        nestedScrollView.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener) (v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            if(v.getChildAt(v.getChildCount() - 1) != null) {
                if ((scrollY >= (v.getChildAt(v.getChildCount() - 1).getMeasuredHeight() - v.getMeasuredHeight())) &&
                        scrollY > oldScrollY) {
                    try {
                        splitmyid();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //code to fetch more data for endless scrolling
                }
            }
        });







        // Inflate the layout for this fragment
        return V;
    }

    public void splitmyid() throws Exception {
        if(Course_id.length()>1) {
            try {
                if (Course_id.length() > 7) {

                    a = Course_id.split(",", 7);
                    Log.w("hereeeee", a[0]);
                    Log.w("hereeeee12", a[1]);
                    Log.w("hereeeee12", a[2]);
                    Log.w("hereeeee12", a[3]);
                    Log.w("hereeeee12", a[4]);
                    Log.w("hereeeee23", a[5]);
String temp="";

                    for(int i =0 ;i<a.length-1;i++){
                        temp=temp+a[i]+',';
                    }
                    int b = Course_id.indexOf(a[6]);
                    Course_id = Course_id.substring(b);
                    Log.w("ypppp", Course_id);
                    temp= temp.substring(0,temp.length()-1);
                    Log.w("temppppppppppppp",temp);
                    get_filter(temp);

                  //  temp="";


                }
                else if (Course_id.length() > 6) {

                    a = Course_id.split(",", 7);
                    Log.w("hereeeee", a[0]);
                    Log.w("hereeeee12", a[1]);
                    Log.w("hereeeee12", a[2]);
                    Log.w("hereeeee12", a[3]);
                    Log.w("hereeeee12", a[4]);
                    Log.w("hereeeee23", a[5]);
                    String temp="";

                    for(int i =0 ;i<a.length-1;i++){
                       temp=temp+a[i]+',';
                    }
                    int b = Course_id.indexOf(a[5]);
                    Course_id = Course_id.substring(b);
                    Log.w("ypppp", Course_id);
                    temp= temp.substring(0,temp.length()-1);
                    Log.w("temppppppppppppp",temp);
                    get_filter(temp);

                    temp="";


                } else if (Course_id.length() > 5) {
                    a = Course_id.split(",", 7);
                    Log.w("hereeeee", a[0]);
                    Log.w("hereeeee12", a[1]);
                    Log.w("hereeeee12", a[2]);
                    Log.w("hereeeee12", a[3]);
                    Log.w("hereeeee12", a[4]);

                    String temp="";
                    for(int i =0 ;i<a.length-1;i++){
                        temp=temp+a[i]+',';
                    }
                    temp= temp.substring(0,temp.length()-1);
                    Log.w("temppppppppppppp",temp);
                    int b = Course_id.indexOf(a[4]);
                    Course_id =  Course_id.substring(b);
                    Log.w("ypppp", Course_id);
                    get_filter(temp);





                } else if ( Course_id.length() > 4) {
                    a =  Course_id.split(",", 7);
                    Log.w("hereeeee", a[0]);
                    Log.w("hereeeee12", a[1]);
                    Log.w("hereeeee12", a[2]);
                    Log.w("hereeeee12", a[3]);
                    String temp="";
                    for(int i =0 ;i<a.length-1;i++){
                        temp=temp+a[i]+',';
                    }
                    temp= temp.substring(0,temp.length()-1);
                    Log.w("temppppppppppppp",temp);
                    int b =  Course_id.indexOf(a[3]);
                    Course_id =  Course_id.substring(b);
                    Log.w("ypppp",  Course_id);
                    get_filter(temp);





                } else if ( Course_id.length() > 3) {
                    a =  Course_id.split(",", 7);
                    Log.w("hereeeee", a[0]);
                    Log.w("hereeeee12", a[1]);
                    Log.w("hereeeee12", a[2]);
                    temp="";
                    for(int i =0 ;i<a.length-1;i++){
                        temp=temp+a[i]+',';
                    }
                    temp= temp.substring(0,temp.length()-1);
                    Log.w("temppppppppppppp",temp);
                    int b =  Course_id.indexOf(a[2]);
                    Course_id =  Course_id.substring(b);
                    Log.w("ypppp", Course_id);
                    get_filter(temp);






                } else if ( Course_id.length() > 2) {
                    a =  Course_id.split(",", 7);
                    Log.w("hereeeee", a[0]);
                    Log.w("hereeeee12", a[1]);
                    temp="";
                    for(int i =0 ;i<a.length-1;i++){
                        temp=temp+a[i]+',';
                    }
                    temp= temp.substring(0,temp.length()-1);
                    Log.w("temppppppppppppp",temp);
                    int b =  Course_id.indexOf(a[1]);
                    Course_id =  Course_id.substring(b);
                    Log.w("ypppp",  Course_id);
                    get_filter(temp);






                } else if ( Course_id.length() > 1) {
                    a =  Course_id.split(",", 7);
                    Log.w("hereeeee", a[0]);
                    temp="";
                    for(int i =0 ;i<a.length-1;i++){
                        temp=temp+a[i]+',';
                    }
                    temp= temp.substring(0,temp.length()-1);
                    Log.w("temppppppppppppp",temp);
                    int b =  Course_id.indexOf(a[0]);
                    Course_id =  Course_id.substring(b);
                    Log.w("ypppp",  Course_id);
                    get_filter(temp);




                } else if (Course_id.length()==1) {
                    Log.w("fgfgf", "lenth small");
                    get_filter(Course_id);
                    Course_id="";
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                Log.w("fgfgfg", e);
                temp="";
                Log.w("final  aspilt", String.valueOf(a.length));
                for(int i =0 ;i<a.length;i++){
                    temp=temp+a[i]+',';
                }
                temp= temp.substring(0,temp.length()-1);
                Course_id="";
                Log.w("final temp",temp);

              get_filter(temp);


                //p2.setVisibility(View.GONE);
            }


        }
    }

    public void get_filter(String courseid)  {
        RequestQueue que = Volley.newRequestQueue(getContext());

        StringRequest request = new StringRequest(Request.Method.POST, urluvn_filter_course_id, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //arraylistcourse=new ArrayList<>();
                Log.w("new responseee",response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsn =jsonObject.getJSONArray("course");
                    for(int i = 0;i<jsn.length();i++){
                        Log.w("jsn array lenght", String.valueOf(jsn.length()));
                        jsonObjectcourse = jsn.getJSONObject(i);
                        jsonArrayunv= jsonObjectcourse.getJSONArray("university");
                        sqldb.insertcourse_details(jsonObjectcourse.getJSONArray("university").getJSONObject(0).getString("university_name"),jsonObjectcourse.getString("course_name"),
                                jsonObjectcourse.getString("course"),jsonObjectcourse.getString("year"),jsonObjectcourse.getString("time"),
                                jsonObjectcourse.getString("total_fee"),jsonObjectcourse.getString("syllabus"));


                        // temp=temp+jsonObjectcourse.getString("course_id")+",";

                        university_namey=jsonObjectcourse.getJSONArray("university").getJSONObject(0).getString("university_name");
                        Log.w("universitynameyyyyy",university_namey);




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
                        currencysymbol1.add(jsonObjectcourse.getJSONObject("currency").getString("symbol"));



                        arraylistcourse.add(new DataModelClassForCourse(jsonArrayunv.getJSONObject(0).getString("university_name"),
                                jsonObjectcourse.getString("course_name"),jsonObjectcourse.getString("course"),jsonObjectcourse.getString("year")
                                ,jsonObjectcourse.getString("time"),jsonObjectcourse.getString("total_fee"),jsonObjectcourse.getString("syllabus")));



                        Log.w("arraylistcourse size", arraylistcourse.get(i).getCourse_name());


                    }



                adapterforinsideUnivCourse.notifyDataSetChanged();

                acess=true;


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



                Map<String,String> map=new HashMap<String, String>();
                map.put("course_id", courseid);


                return map;
            }
        };
        que.add(request);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}