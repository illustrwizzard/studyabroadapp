package com.axis.axistrial;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.axistrial.R;

import java.util.ArrayList;

public class InsideCourseuniversityTab extends Fragment {
    ArrayList<DataModelClassForCourse> arrayListtable;
    String clg_name,rating,location,estd,course_name;
    TextView clgname,loc,rate,est;
    View view;
    Button viewbutton;
    LinearLayout l1,l2;
    SQLDB sqldb;
    String unv_name;
    ArrayList<UnvdataClass>arrayList_Unv_details;
    String from3;
    String from4;

    public InsideCourseuniversityTab(String course_name, ArrayList<DataModelClassForCourse> arrayListtable, String unv_name, ArrayList<UnvdataClass> arrayList_Unv_details,String from3,String from4) {
        this.course_name=course_name;
        this.arrayListtable=arrayListtable;
        this.unv_name=unv_name;
        this.from3=from3;
        this.arrayList_Unv_details=arrayList_Unv_details;
        this.from4=from4;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.inside_course_university_tab, container, false);
        clgname=view.findViewById(R.id.clgname_in_cunvtab);
        loc=view.findViewById(R.id.location_in_cunvtab);
        rate=view.findViewById(R.id.rating_in_cunvtab);
        est=view.findViewById(R.id.estd_in_cunvtab);
        l1=view.findViewById(R.id.inside_univmain);
        l2=view.findViewById(R.id.inside_univmain1);
        viewbutton=view.findViewById(R.id.button_in_unv_in_course);

        sqldb=new SQLDB(getContext());
        arrayListtable=new ArrayList<>();
        arrayListtable=sqldb.getcourse_details_single_course_name(course_name);
        arrayList_Unv_details=new ArrayList<>();
       // bookmark_deleted
        if(from3.equals("bookmark_deleted")) {
            arrayList_Unv_details = sqldb.getUnv_singledetails_bookmark1(unv_name);
            clgname.setText(arrayListtable.get(0).getCourse());
            loc.setText(arrayList_Unv_details.get(0).getCity());
            rate.setText(arrayList_Unv_details.get(0).getRating());
            est.setText(arrayList_Unv_details.get(0).getEstablished());
        }

        else if(from3.equals("bookmark")) {
            arrayList_Unv_details = sqldb.getUnv_singledetails_bookmark(unv_name);
            clgname.setText(arrayListtable.get(0).getCourse());
            loc.setText(arrayList_Unv_details.get(0).getCity());
            rate.setText(arrayList_Unv_details.get(0).getRating());
            est.setText(arrayList_Unv_details.get(0).getEstablished());
        }
//        }else if(from4.equals("book_deleted")){
//            Log.w("im here you....","foooooool");
//            arrayList_Unv_details=sqldb.getUnv_singledetails_bookmark1(unv_name);
//            clgname.setText(arrayListtable.get(0).getCourse());
//            loc.setText(arrayList_Unv_details.get(0).getCity());
//            rate.setText(arrayList_Unv_details.get(0).getRating());
//            est.setText(arrayList_Unv_details.get(0).getEstablished());
//
//        }
       else{
            arrayList_Unv_details=sqldb.getUnv_singledetails(unv_name);
            clgname.setText(arrayListtable.get(0).getCourse());
            loc.setText(arrayList_Unv_details.get(0).getCity());
            rate.setText(arrayList_Unv_details.get(0).getRating());
            est.setText(arrayList_Unv_details.get(0).getEstablished());
        }


        Log.w("mnmnbmnmbmb,", String.valueOf(arrayList_Unv_details.size()));
        //Log.w("xxxxxxxxxxxxxxxxx",arrayList_Unv_details.get(0).getCity());


        viewbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
if(from3.equals("bookmark")){
    Intent i=new Intent(getContext(),LoadingActivity.class);
    i.putExtra("univ_name_course", unv_name);
    i.putExtra("fromCourseUniv","yes");

    startActivity(i);
}
//}else if(from4.equals("book_deleted")){
//    Intent i=new Intent(getContext(),LoadingActivity.class);
//    i.putExtra("univ_name_course", unv_name);
//    i.putExtra("fromCourseUniv","yes");
//
//
//}
 else{
    Intent i=new Intent(getContext(),LoadingActivity.class);
    i.putExtra("univ_name", unv_name);
    i.putExtra("unv_from_course","yes");
    startActivity(i);

}




            }
        });



        if(clgname==null){
            view=null;

        }





        return view;
    }

}