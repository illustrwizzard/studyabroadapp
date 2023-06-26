package com.axis.axistrial;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.axistrial.R;

import java.util.ArrayList;


public class InsideCourseVisaProcedureTab extends Fragment {
    String visa;
    TextView visaText;
    ArrayList<Unv_Procedure> arrayList_unv_procedure;
    SQLDB sqldb;
    String university_name;
    String from3;



    public InsideCourseVisaProcedureTab(String course_name,ArrayList<Unv_Procedure> arrayList_unv_procedure, String unv_name,String from3) {
        this.arrayList_unv_procedure=arrayList_unv_procedure;
        visa=course_name;
        this.from3=from3;
        this.university_name=unv_name;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_inside_course_visa_procedure_tab, container, false);
        visaText=view.findViewById(R.id.visatext_id);
        sqldb=new SQLDB(getContext());
        arrayList_unv_procedure=new ArrayList<>();
        if(from3.equals("bookmark")){
            arrayList_unv_procedure=sqldb.getUnv_Procedure_bookmark(university_name);
            if (arrayList_unv_procedure.size()>0){
                visaText=view.findViewById(R.id.visatext_id);
                visaText.setText(Html.fromHtml(arrayList_unv_procedure.get(0).getVisa(),Html.FROM_HTML_MODE_LEGACY));


            }



        }else{
            visaText=view.findViewById(R.id.visatext_id);
            arrayList_unv_procedure=sqldb.getUnv_Procedure(university_name);
            if (arrayList_unv_procedure.size()>0){
                visaText=view.findViewById(R.id.visatext_id);
                visaText.setText(Html.fromHtml(arrayList_unv_procedure.get(0).getVisa(),Html.FROM_HTML_MODE_LEGACY));

            }
        }




        return view;
    }
}