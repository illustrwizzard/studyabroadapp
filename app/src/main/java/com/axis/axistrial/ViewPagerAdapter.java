package com.axis.axistrial;


import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter
        extends FragmentPagerAdapter {



    ArrayList<UnvdataClass> arraydetails;
 String from;
    ArrayList<UnivAff> arrayListaffli;
    ArrayList<UnivRank> arrayListRanking;
    ArrayList<UnivFac> arrayfacility;
    String university_name,Course_id;
    ArrayList<Unv_Feed>arrayListFeed;
    String from2;
    int countvalue;
    boolean checkbookmark;
    String from4;


    public ViewPagerAdapter(@NonNull FragmentManager fm, ArrayList<UnvdataClass> arraydetails, ArrayList<UnivAff> arrayListaffli, ArrayList<UnivRank> arrayListRanking, ArrayList<UnivFac> arrayfacility, String university_name,ArrayList<Unv_Feed>arrayListFeed,String from,String from2, boolean checkbookmark,int countvalue,String from4)
    {
        super(fm);
        this.arraydetails=arraydetails;
        this.arrayListaffli=arrayListaffli;
        this.arrayListRanking=arrayListRanking;
        this.arrayfacility=arrayfacility;
        this.university_name=university_name;
        this.arrayListFeed=arrayListFeed;
        this.from=from;
        this.countvalue=countvalue;
        this.checkbookmark=checkbookmark;
        this.from2=from2;
        this.from4=from4;
       //Log.w("INSIDE VIEW PAGE",Course_id);this.Course_id=Course_id;
        Log.w("logggggggggg.........",university_name);
    }


    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        Fragment fragment = null;
        if (position == 0)
            fragment = new InsideUniversityAboutTabb(arraydetails,arrayfacility,arrayListRanking,arrayListaffli,university_name,from);

        else if (position == 1)
            fragment = new InsideUniversityFeedTab(arrayListFeed,university_name,from);
        else if (position == 2)
            fragment = new InsideUniversityCourseTab(Course_id,from2,checkbookmark,countvalue,from4);
        else if (position == 3)
            fragment=new InsideUniversityAccommodationTab(university_name,from);
            else if(position ==4)
            fragment=new InsideUniversityContactInfoTab(arraydetails,university_name,from);


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
            title = "About";
        else if (position == 1)
            title = "Feed";
        else if (position == 2)
            title = "Courses";
        else if (position == 3)
            title = "Accommodation";
        else if (position == 4)
            title = "Contact info";
        return title;
    }


}
