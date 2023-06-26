package com.axis.axistrial;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter1 extends FragmentPagerAdapter {
    ArrayList<DataModelClassForCourse> arrayListtable;
    ArrayList<UCourse_fee> arrayListfee;
    ArrayList<UCentrance> arrayListEnterance;
    ArrayList<UCourseeligibilty> arrayListElg;
    ArrayList<UnvdataClass>arrayList_Unv_details;
    ArrayList<Unv_Procedure>arrayList_Unv_Procedure;
    String course_name;
    String unv_name;
    String from3;
    String from4;
    String currencysymbol;

    public ViewPagerAdapter1(@NonNull FragmentManager fm,ArrayList<DataModelClassForCourse> arrayListtable, ArrayList<UCourse_fee> arrayListfee, ArrayList<UCentrance> arrayListEnterance, ArrayList<UCourseeligibilty> arrayListElg,String course_name,String unv_name,ArrayList<UnvdataClass>arrayList_Unv_details,ArrayList<Unv_Procedure>arrayList_Unv_Procedure,String from3,String currencysymbol,String from4)
    {

        super(fm);
        this.arrayListElg=arrayListElg;
        this.arrayListEnterance=arrayListEnterance;
        this.arrayListfee=arrayListfee;
        this.arrayListtable=arrayListtable;
        this.course_name=course_name;
        this.unv_name=unv_name;
        this.from3=from3;
        this.arrayList_Unv_details=arrayList_Unv_details;
        this.arrayList_Unv_Procedure=arrayList_Unv_Procedure;
        this.currencysymbol=currencysymbol;
        this.from4=from4;
    }



    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        Fragment fragment = null;
        if (position == 0)
            fragment = new InsideCourseCourseTab(course_name,arrayListtable,arrayListElg,arrayListfee,arrayListEnterance,unv_name,arrayList_Unv_details,arrayList_Unv_Procedure,currencysymbol);
        else if (position == 1)
            fragment = new InsideCourseuniversityTab(course_name,arrayListtable,unv_name,arrayList_Unv_details,from3,from4);
        else if (position == 2)
            fragment = new InsideCourseHowtoapplyTab(course_name,arrayList_Unv_Procedure,unv_name,from3);
        else if(position == 3)
            fragment = new InsideCourseVisaProcedureTab(course_name,arrayList_Unv_Procedure,unv_name,from3);
        else if(position == 4)
            fragment = new InsideCourseServiceTab(course_name,arrayList_Unv_Procedure,unv_name,from3);

        return fragment;
    }

    @Override
    public int getCount()
    {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        String title = null;
        if (position == 0)
            title = "Course";
        else if (position == 1)
            title = "University";
        else if (position == 2)
            title = "How to apply";
        else if(position == 3)
            title = "Visa Procedure";
        else if(position == 4)
            title = "Services";
        return title;
    }
}
