package com.axis.axistrial;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.axistrial.R;

import java.util.ArrayList;


public class InsideUniversityAboutTabb extends Fragment {


    ArrayList<UnvdataClass>accomdationarray;

    //about university

    TextView abouttext;
    //

    ///ranking

    TextView copletetext,copletetext1,copletetext2,copletetext4,copletetext5,copletetext6;

    ///


    ////university affiliation


    TextView affi1,affi2,affi3,affi4,affi5,affi6;


    ////

    /// UNIVERSITY FACILITY
    TextView TXT1,TXT2,TXT3, nameinranking,rankinrank,affilitaion, complete1,complete2,complete3,complete4,complete5,complete6,rank1,rank2,rank3,rank4,rank5,rank6;
    CardView c1,c2,c3,c4,c5,c6;
    TextView af1,af2,af3,af4,af5,af6;
    TextView ft1,ft2,ft3,ft4,ft5,ft6;
    LinearLayout gone1,gone2,gone3,gone4,gone5,gone6,f1,f2,f3,f4,f5,f6;

    TextView fac1,fac2,fac3,fac4,fac5,fac6;
    ArrayList<UnvdataClass> arraydetails;
    ArrayList<UnivFac> arrayfacility;
    ArrayList<UnivRank> arrayListRanking;
    ArrayList<UnivAff> arrayListaffli;
    String university_name;
    SQLDB sqldb;
    String from;


    public InsideUniversityAboutTabb(ArrayList<UnvdataClass> arraydetails, ArrayList<UnivFac> arrayfacility, ArrayList<UnivRank> arrayListRanking, ArrayList<UnivAff> arrayListaffli, String university_name,String from) {
//,String from

        this.arraydetails=arraydetails;
        this.arrayfacility=arrayfacility;
        this.arrayListaffli=arrayListaffli;
        this.arrayListRanking=arrayListRanking;
        this.university_name=university_name;
        this.from=from;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.inside_uniersity_about_tab1, container, false);
        sqldb=new SQLDB(getContext());
        arraydetails=new ArrayList<>();
        arrayListRanking=new ArrayList<>();
        arrayListaffli=new ArrayList<>();
        arrayfacility=new ArrayList<>();
if(from.equals("book_mark")){
    Log.w("enterd boook","ypp");
            arraydetails=sqldb.getuniv_details_single_bookmark(university_name);
            arrayListRanking=sqldb.getUnivRanking_single_bookmark(university_name);
            arrayListaffli=sqldb.getaffiliation_single_bookmark(university_name);
            arrayfacility=sqldb.getfacility_single_bookmark(university_name);

        }else if(from.equals("book_mark_deleted")){
    Log.w("enterd boook","ypp");
    arraydetails=sqldb.getuniv_details_single_bookmark1(university_name);
    arrayListRanking=sqldb.getUnivRanking_single_bookmark1(university_name);
    arrayListaffli=sqldb.getaffiliation_single_bookmark1(university_name);
    arrayfacility=sqldb.getfacility_single_bookmark1(university_name);


}
        else{
    Log.w("enterd elseeeee","ypp");
            arraydetails=sqldb.getuniv_details_single(university_name);
            arrayListRanking=sqldb.getUnivRanking_single(university_name);
            arrayListaffli=sqldb.getaffiliation_single(university_name);
            arrayfacility=sqldb.getfacility_single(university_name);
        }








        ///about university


        abouttext=view.findViewById(R.id.aboutuniversity_in_university);
        abouttext.setText(Html.fromHtml(arraydetails.get(0).getAbout(),Html.FROM_HTML_MODE_LEGACY));



        gone1=view.findViewById(R.id.ranklay1);
        gone2=view.findViewById(R.id.ranklay2);
        gone3=view.findViewById(R.id.ranklay3);
        gone4=view.findViewById(R.id.ranklay4);
        gone5=view.findViewById(R.id.ranklay5);
        gone6=view.findViewById(R.id.ranklay6);


        c1=view.findViewById(R.id.aflilay1);
        c2=view.findViewById(R.id.aflilay2);
        c3=view.findViewById(R.id.aflilay3);
        c4=view.findViewById(R.id.aflilay4);
        c5=view.findViewById(R.id.aflilay5);
        c6=view.findViewById(R.id.aflilay6);

        af1=view.findViewById(R.id.afli1);
        af2=view.findViewById(R.id.afli2);
        af3=view.findViewById(R.id.afli3);
        af4=view.findViewById(R.id.afli4);
        af5=view.findViewById(R.id.afli5);
        af6=view.findViewById(R.id.afli6);


        f1=view.findViewById(R.id.faclay1);
        f2=view.findViewById(R.id.faclay2);
        f3=view.findViewById(R.id.faclay3);
        f4=view.findViewById(R.id.faclay4);
        f5=view.findViewById(R.id.faclay5);
        f6=view.findViewById(R.id.faclay6);


        ft1=view.findViewById(R.id.fac1);
        ft2=view.findViewById(R.id.fac2);
        ft3=view.findViewById(R.id.fac3);
        ft4=view.findViewById(R.id.fac4);
        ft5=view.findViewById(R.id.fac5);
        ft6=view.findViewById(R.id.fac6);


        complete1=view.findViewById(R.id.competetext);
        complete2=view.findViewById(R.id.competetext1);
        complete3=view.findViewById(R.id.competetext2);
        complete4=view.findViewById(R.id.competetext4);
        complete5=view.findViewById(R.id.competetext5);
        complete6=view.findViewById(R.id.competetext6);


        rank1=view.findViewById(R.id.rank);
        rank2=view.findViewById(R.id.rank1);
        rank3=view.findViewById(R.id.rank2);
        rank4=view.findViewById(R.id.rank3);
        rank5=view.findViewById(R.id.rank4);
        rank6=view.findViewById(R.id.rank5);




        /////University Ranking



        if(arrayListRanking.get(0).getRname1()!=null){
            complete1.setText((CharSequence) arrayListRanking.get(0).getRname1());
            rank1.setText((CharSequence) arrayListRanking.get(0).getRanking1());
        }else{

            gone1=view.findViewById(R.id.ranklay1);
            gone2=view.findViewById(R.id.ranklay2);
            gone3=view.findViewById(R.id.ranklay3);
            gone4=view.findViewById(R.id.ranklay4);
            gone5=view.findViewById(R.id.ranklay5);
            gone6=view.findViewById(R.id.ranklay6);

            gone1.setVisibility(View.GONE);
            gone2.setVisibility(View.GONE);
            gone3.setVisibility(View.GONE);
            gone4.setVisibility(View.GONE);
            gone5.setVisibility(View.GONE);
            gone6.setVisibility(View.GONE);

        }
        if(arrayListRanking.get(0).getRname2()!=null){

            complete2.setText((CharSequence) arrayListRanking.get(0).getRname2());
            rank2.setText((CharSequence) arrayListRanking.get(0).getRanking2());
        }else{

            gone1=view.findViewById(R.id.ranklay1);
            gone2=view.findViewById(R.id.ranklay2);
            gone3=view.findViewById(R.id.ranklay3);
            gone4=view.findViewById(R.id.ranklay4);
            gone5=view.findViewById(R.id.ranklay5);
            gone6=view.findViewById(R.id.ranklay6);

            gone2.setVisibility(View.GONE);
            gone3.setVisibility(View.GONE);
            gone4.setVisibility(View.GONE);
            gone5.setVisibility(View.GONE);
            gone6.setVisibility(View.GONE);

        }

        if(arrayListRanking.get(0).getRname3()!=null){

            complete3.setText((CharSequence) arrayListRanking.get(0).getRname3());
            rank3.setText((CharSequence) arrayListRanking.get(0).getRanking3());
        }else{

            gone1=view.findViewById(R.id.ranklay1);
            gone2=view.findViewById(R.id.ranklay2);
            gone3=view.findViewById(R.id.ranklay3);
            gone4=view.findViewById(R.id.ranklay4);
            gone5=view.findViewById(R.id.ranklay5);
            gone6=view.findViewById(R.id.ranklay6);

            gone3.setVisibility(View.GONE);
            gone4.setVisibility(View.GONE);
            gone5.setVisibility(View.GONE);
            gone6.setVisibility(View.GONE);

        }

        if(arrayListRanking.get(0).getRname4()!=null){

            complete4.setText((CharSequence) arrayListRanking.get(0).getRname4());
            rank4.setText((CharSequence) arrayListRanking.get(0).getRanking4());
        }else{

            gone1=view.findViewById(R.id.ranklay1);
            gone2=view.findViewById(R.id.ranklay2);
            gone3=view.findViewById(R.id.ranklay3);
            gone4=view.findViewById(R.id.ranklay4);
            gone5=view.findViewById(R.id.ranklay5);
            gone6=view.findViewById(R.id.ranklay6);

            gone4.setVisibility(View.GONE);
            gone5.setVisibility(View.GONE);
            gone6.setVisibility(View.GONE);

        }

        if(arrayListRanking.get(0).getRname5()!=null){

            complete5.setText((CharSequence) arrayListRanking.get(0).getRname5());
            rank5.setText((CharSequence) arrayListRanking.get(0).getRanking5());
        }else{

            gone1=view.findViewById(R.id.ranklay1);
            gone2=view.findViewById(R.id.ranklay2);
            gone3=view.findViewById(R.id.ranklay3);
            gone4=view.findViewById(R.id.ranklay4);
            gone5=view.findViewById(R.id.ranklay5);
            gone6=view.findViewById(R.id.ranklay6);

            gone5.setVisibility(View.GONE);
            gone6.setVisibility(View.GONE);

        }

        if(arrayListRanking.get(0).getRname6()!=null){



            complete6.setText((CharSequence) arrayListRanking.get(0).getRname6());
            rank6.setText((CharSequence) arrayListRanking.get(0).getRanking6());
        }else{

            gone1=view.findViewById(R.id.ranklay1);
            gone2=view.findViewById(R.id.ranklay2);
            gone3=view.findViewById(R.id.ranklay3);
            gone4=view.findViewById(R.id.ranklay4);
            gone5=view.findViewById(R.id.ranklay5);
            gone6=view.findViewById(R.id.ranklay6);

            gone6.setVisibility(View.GONE);

        }
        if (arrayListRanking.get(0)==null){
            gone1=view.findViewById(R.id.ranklay1);
            gone2=view.findViewById(R.id.ranklay2);
            gone3=view.findViewById(R.id.ranklay3);
            gone4=view.findViewById(R.id.ranklay4);
            gone5=view.findViewById(R.id.ranklay5);
            gone6=view.findViewById(R.id.ranklay6);

            gone1.setVisibility(View.GONE);
            gone2.setVisibility(View.GONE);
            gone3.setVisibility(View.GONE);
            gone4.setVisibility(View.GONE);
            gone5.setVisibility(View.GONE);
            gone6.setVisibility(View.GONE);


        }
//
//
        ///////UNIVERSITY AFFLIATION


        if(arrayListaffli.get(0).getAff1()!=null){
            af1=view.findViewById(R.id.afli1);
            af2=view.findViewById(R.id.afli2);
            af3=view.findViewById(R.id.afli3);
            af4=view.findViewById(R.id.afli4);
            af5=view.findViewById(R.id.afli5);
            af6=view.findViewById(R.id.afli6);
            af1.setText(arrayListaffli.get(0).getAff1());


        }else
        {

            c1=view.findViewById(R.id.aflilay1);
            c2=view.findViewById(R.id.aflilay2);
            c3=view.findViewById(R.id.aflilay3);
            c4=view.findViewById(R.id.aflilay4);
            c5=view.findViewById(R.id.aflilay5);
            c6=view.findViewById(R.id.aflilay6);

            c1.setVisibility(View.GONE);
            c2.setVisibility(View.GONE);
            c3.setVisibility(View.GONE);
            c4.setVisibility(View.GONE);
            c5.setVisibility(View.GONE);
            c6.setVisibility(View.GONE);
        }if(arrayListaffli.get(0).getAff2()!=null){
            af1=view.findViewById(R.id.afli1);
            af2=view.findViewById(R.id.afli2);
            af3=view.findViewById(R.id.afli3);
            af4=view.findViewById(R.id.afli4);
            af5=view.findViewById(R.id.afli5);
            af6=view.findViewById(R.id.afli6);
            af2.setText(arrayListaffli.get(0).getAff2());


        }else
        {


            c2=view.findViewById(R.id.aflilay2);
            c3=view.findViewById(R.id.aflilay3);
            c4=view.findViewById(R.id.aflilay4);
            c5=view.findViewById(R.id.aflilay5);
            c6=view.findViewById(R.id.aflilay6);


            c2.setVisibility(View.GONE);
            c3.setVisibility(View.GONE);
            c4.setVisibility(View.GONE);
            c5.setVisibility(View.GONE);
            c6.setVisibility(View.GONE);
        }if(arrayListaffli.get(0).getAff3()!=null){

            af3=view.findViewById(R.id.afli3);
            af4=view.findViewById(R.id.afli4);
            af5=view.findViewById(R.id.afli5);
            af6=view.findViewById(R.id.afli6);
            af3.setText(arrayListaffli.get(0).getAff3());


        }else
        {


            c3=view.findViewById(R.id.aflilay3);
            c4=view.findViewById(R.id.aflilay4);
            c5=view.findViewById(R.id.aflilay5);
            c6=view.findViewById(R.id.aflilay6);


            c3.setVisibility(View.GONE);
            c4.setVisibility(View.GONE);
            c5.setVisibility(View.GONE);
            c6.setVisibility(View.GONE);
        }if(arrayListaffli.get(0).getAff4()!=null){


            af4=view.findViewById(R.id.afli4);
            af5=view.findViewById(R.id.afli5);
            af6=view.findViewById(R.id.afli6);
            af4.setText(arrayListaffli.get(0).getAff4());


        }else
        {



            c4=view.findViewById(R.id.aflilay4);
            c5=view.findViewById(R.id.aflilay5);
            c6=view.findViewById(R.id.aflilay6);


            c4.setVisibility(View.GONE);
            c5.setVisibility(View.GONE);
            c6.setVisibility(View.GONE);
        }if(arrayListaffli.get(0).getAff5()!=null){


            af5=view.findViewById(R.id.afli5);
            af6=view.findViewById(R.id.afli6);
            af5.setText(arrayListaffli.get(0).getAff5());


        }else
        {



            c5=view.findViewById(R.id.aflilay5);
            c6=view.findViewById(R.id.aflilay6);


            c5.setVisibility(View.GONE);
            c6.setVisibility(View.GONE);
        }if(arrayListaffli.get(0).getAff6()!=null){



            af6=view.findViewById(R.id.afli6);
            af6.setText(arrayListaffli.get(0).getAff6());


        }else
        {




            c6=view.findViewById(R.id.aflilay6);



            c6.setVisibility(View.GONE);
        }

//
//
//
//        ///////FACILITY///////
//
//
//
        if (arrayfacility.get(0).getFac1()!=null){

            ft1=view.findViewById(R.id.fac1);
            ft2=view.findViewById(R.id.fac2);
            ft3=view.findViewById(R.id.fac3);
            ft4=view.findViewById(R.id.fac4);
            ft5=view.findViewById(R.id.fac5);
            ft6=view.findViewById(R.id.fac6);

            ft1.setText(arrayfacility.get(0).getFac1());


        }else{

            f1=view.findViewById(R.id.faclay1);
            f2=view.findViewById(R.id.faclay2);
            f3=view.findViewById(R.id.faclay3);
            f4=view.findViewById(R.id.faclay4);
            f5=view.findViewById(R.id.faclay5);
            f6=view.findViewById(R.id.faclay6);

            f1.setVisibility(View.GONE);
            f2.setVisibility(View.GONE);
            f3.setVisibility(View.GONE);
            f4.setVisibility(View.GONE);
            f5.setVisibility(View.GONE);
            f6.setVisibility(View.GONE);

        }if (arrayfacility.get(0).getFac2()!=null){


            ft2=view.findViewById(R.id.fac2);
            ft3=view.findViewById(R.id.fac3);
            ft4=view.findViewById(R.id.fac4);
            ft5=view.findViewById(R.id.fac5);
            ft6=view.findViewById(R.id.fac6);

            ft2.setText(arrayfacility.get(0).getFac2());


        }else{


            f2=view.findViewById(R.id.faclay2);
            f3=view.findViewById(R.id.faclay3);
            f4=view.findViewById(R.id.faclay4);
            f5=view.findViewById(R.id.faclay5);
            f6=view.findViewById(R.id.faclay6);


            f2.setVisibility(View.GONE);
            f3.setVisibility(View.GONE);
            f4.setVisibility(View.GONE);
            f5.setVisibility(View.GONE);
            f6.setVisibility(View.GONE);

        }if (arrayfacility.get(0).getFac3()!=null){


            ft3=view.findViewById(R.id.fac3);
            ft4=view.findViewById(R.id.fac4);
            ft5=view.findViewById(R.id.fac5);
            ft6=view.findViewById(R.id.fac6);

            ft3.setText(arrayfacility.get(0).getFac3());


        }else{


            f3=view.findViewById(R.id.faclay3);
            f4=view.findViewById(R.id.faclay4);
            f5=view.findViewById(R.id.faclay5);
            f6=view.findViewById(R.id.faclay6);


            f3.setVisibility(View.GONE);
            f4.setVisibility(View.GONE);
            f5.setVisibility(View.GONE);
            f6.setVisibility(View.GONE);

        }if (arrayfacility.get(0).getFac4()!=null){


            ft4=view.findViewById(R.id.fac4);
            ft5=view.findViewById(R.id.fac5);
            ft6=view.findViewById(R.id.fac6);

            ft4.setText(arrayfacility.get(0).getFac4());


        }else{


            f4=view.findViewById(R.id.faclay4);
            f5=view.findViewById(R.id.faclay5);
            f6=view.findViewById(R.id.faclay6);

            f4.setVisibility(View.GONE);
            f5.setVisibility(View.GONE);
            f6.setVisibility(View.GONE);

        }if (arrayfacility.get(0).getFac5()!=null){


            ft5=view.findViewById(R.id.fac5);
            ft6=view.findViewById(R.id.fac6);

            ft5.setText(arrayfacility.get(0).getFac5());


        }else{


            f5=view.findViewById(R.id.faclay5);
            f6=view.findViewById(R.id.faclay6);


            f5.setVisibility(View.GONE);
            f6.setVisibility(View.GONE);

        }if (arrayfacility.get(0).getFac6()!=null){


            ft6=view.findViewById(R.id.fac6);

            ft6.setText(arrayfacility.get(0).getFac6());


        }else{


            f6=view.findViewById(R.id.faclay6);


            f6.setVisibility(View.GONE);

        }


        /////////





















        // Inflate the layout for this fragment





        return view;
    }
}