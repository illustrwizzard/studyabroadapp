package com.axis.axistrial;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.axistrial.R;

import java.util.ArrayList;


public class InsideCourseCourseTab extends Fragment {
    ArrayList<DataModelClassForCourse> arrayListtable;
    ArrayList<UCourseeligibilty> arrayListElg;
    ArrayList<UCourse_fee> arrayListfee;
    ArrayList<UCentrance> arrayListEnterance;
    ArrayList<UnvdataClass> arrayList_Unv_details;
    ArrayList<Unv_Procedure>arrayList_Unv_Procedure;
    SQLDB sqldb;
    String Clg_name,course_name;

    String course,location,time,totalfee,syllabus,documents;
    TextView tfee,ttime,tlocation,tsyllabus,tdocuments,coursee,tyear,grandtotal;
    TextView s1,s2,s3,s4,s5,s6,e1,e2,e3,e4,e5,e6;
    CardView ccc1,ccc2,ccc3,ccc4,ccc5,ccc6;
    CardView cc1,cc2,cc3,cc4,cc5,cc6;
    TextView ctext1,ctext2,ctext3,ctext4,ctext5,ctext6;
    TextView term1,term2,term3,term4,term5,term6,term7,term8,term9,term10,tution1,tution2,tution3,tution4,tution5,tution6,tution7,tution8,tution9,tution10,amount1,amount2,amount3,amount4,amount5,amount6,amount7,amount8,amount9,amount10;
    TableRow tablerow1,tablerow2,tablerow3,tablerow4,tablerow5,tablerow6,tablerow7,tablerow8,tablerow9,tablerow10;
    String unv_name;
    String currencysymbol;



    public InsideCourseCourseTab(String course_name, ArrayList<DataModelClassForCourse> arrayListtable, ArrayList<UCourseeligibilty> arrayListElg, ArrayList<UCourse_fee> arrayListfee, ArrayList<UCentrance> arrayListEnterance,String unv_name,ArrayList<UnvdataClass>arrayList_Unv_details,ArrayList<Unv_Procedure>arrayList_Unv_Procedure,String currencysymbol) {
        this.course_name=course_name;
        this.arrayListtable=arrayListtable;
        this.arrayListElg=arrayListElg;
        this.arrayListfee=arrayListfee;
        this.arrayListEnterance=arrayListEnterance;
        this.unv_name=unv_name;
        this.arrayList_Unv_Procedure=arrayList_Unv_Procedure;
        this.arrayList_Unv_details=arrayList_Unv_details;
        this.currencysymbol=currencysymbol;

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.inside_course_course_tab, container, false);
        ///first
        tfee=view.findViewById(R.id.totalfee_in_cctab);
        tlocation=view.findViewById(R.id.location_in_cctab);
        tyear=view.findViewById(R.id.year_in_cctab);

        coursee=view.findViewById(R.id.course_in_cctab);

        ttime=view.findViewById(R.id.time_in_cctab);

        tsyllabus=view.findViewById(R.id.syllabus_in_cctab);
        tdocuments=view.findViewById(R.id.documents_in_cctab);
        grandtotal=view.findViewById(R.id.totalfeeeeeeeee);

        sqldb=new SQLDB(getContext());


        /////////////////////////COURSE DETAILS
        arrayListtable=new ArrayList<>();

        arrayListtable=sqldb.getcourse_details_single_course_name(course_name);



        /////////////////COURSE FEE


        ///////////UNIVERSITY DETAILS//////////////
        arrayList_Unv_details=new ArrayList<>();
        arrayList_Unv_details=sqldb.getuniv_details_single(unv_name);




        //////////UNIVERSITY PROCEDURE///////////

        coursee.setText(arrayListtable.get(0).getCourse());
       // tlocation.setText(arrayList_Unv_details.get(0).getCity());
        ttime.setText(arrayListtable.get(0).getTime());
        tfee.setText(currencysymbol+" "+arrayListtable.get(0).getTotal_fee());
        tyear.setText(arrayListtable.get(0).getYear());
        grandtotal.setText(currencysymbol+" "+arrayListtable.get(0).getTotal_fee());


        tsyllabus.setText(Html.fromHtml(arrayListtable.get(0).getSyllabus(),Html.FROM_HTML_MODE_LEGACY));
        //tdocuments.setText(Html.fromHtml(arrayList_Unv_Procedure.get(0).getDocuments(),Html.FROM_HTML_MODE_LEGACY));




        //eligibility

        ccc1=view.findViewById(R.id.ccc1);
        ccc2=view.findViewById(R.id.ccc2);
        ccc3=view.findViewById(R.id.ccc3);
        ccc4=view.findViewById(R.id.ccc4);
        ccc5=view.findViewById(R.id.ccc5);
        ccc6=view.findViewById(R.id.ccc6);


        s1=view.findViewById(R.id.s1);
        s2=view.findViewById(R.id.s2);
        s3=view.findViewById(R.id.s3);
        s4=view.findViewById(R.id.s4);
        s5=view.findViewById(R.id.s5);
        s6=view.findViewById(R.id.s6);


        e1=view.findViewById(R.id.e1);
        e2=view.findViewById(R.id.e2);
        e3=view.findViewById(R.id.e3);
        e4=view.findViewById(R.id.e4);
        e5=view.findViewById(R.id.e5);
        e6=view.findViewById(R.id.e6);

        arrayListElg=new ArrayList<>();
        arrayListElg=sqldb.geteligibility_single(course_name);

        if (arrayListElg.get(0).getScore1()!=null){
            e1.setText(arrayListElg.get(0).getExamname1());
            s1.setText(arrayListElg.get(0).getScore1());

        }else{
            ccc1.setVisibility(View.GONE);
            ccc2.setVisibility(View.GONE);
            ccc3.setVisibility(View.GONE);
            ccc4.setVisibility(View.GONE);
            ccc5.setVisibility(View.GONE);
            ccc6.setVisibility(View.GONE);

        }

        if (arrayListElg.get(0).getScore2()!=null){
            e2.setText(arrayListElg.get(0).getExamname2());
            s2.setText(arrayListElg.get(0).getScore2());

        }else{

            ccc2.setVisibility(View.GONE);
            ccc3.setVisibility(View.GONE);
            ccc4.setVisibility(View.GONE);
            ccc5.setVisibility(View.GONE);
            ccc6.setVisibility(View.GONE);

        }

        if (arrayListElg.get(0).getScore3()!=null){
            e3.setText(arrayListElg.get(0).getExamname3());
            s3.setText(arrayListElg.get(0).getScore3());

        }else{


            ccc3.setVisibility(View.GONE);
            ccc4.setVisibility(View.GONE);
            ccc5.setVisibility(View.GONE);
            ccc6.setVisibility(View.GONE);

        }


        if (arrayListElg.get(0).getScore4()!=null){
            e4.setText(arrayListElg.get(0).getExamname4());
            s4.setText(arrayListElg.get(0).getScore4());

        }else{



            ccc4.setVisibility(View.GONE);
            ccc5.setVisibility(View.GONE);
            ccc6.setVisibility(View.GONE);

        }



        if (arrayListElg.get(0).getScore5()!=null){
            e5.setText(arrayListElg.get(0).getExamname5());
            s5.setText(arrayListElg.get(0).getScore5());

        }else{



            ccc5.setVisibility(View.GONE);
            ccc6.setVisibility(View.GONE);

        }

        if (arrayListElg.get(0).getScore6()!=null){
            e6.setText(arrayListElg.get(0).getExamname6());
            s6.setText(arrayListElg.get(0).getScore6());

        }else{




            ccc6.setVisibility(View.GONE);

        }

        ///entrance
        cc1=view.findViewById(R.id.cc1);
        cc2=view.findViewById(R.id.cc2);
        cc3=view.findViewById(R.id.cc3);
        cc4=view.findViewById(R.id.cc4);
        cc5=view.findViewById(R.id.cc5);
        cc6=view.findViewById(R.id.cc6);

        ctext1=view.findViewById(R.id.ctext1);
        ctext2=view.findViewById(R.id.ctext2);
        ctext3=view.findViewById(R.id.ctext3);
        ctext4=view.findViewById(R.id.ctext4);
        ctext5=view.findViewById(R.id.ctext5);
        ctext6=view.findViewById(R.id.ctext6);

        arrayListEnterance=new ArrayList<>();
        arrayListEnterance=sqldb.getentrance_single(course_name);


        if (arrayListEnterance.get(0).getExam_name1()!=null){
            ctext1.setText(arrayListEnterance.get(0).getExam_name1());

        }else{
            cc1.setVisibility(View.GONE);
            cc2.setVisibility(View.GONE);
            cc3.setVisibility(View.GONE);
            cc4.setVisibility(View.GONE);
            cc5.setVisibility(View.GONE);
            cc6.setVisibility(View.GONE);

        }
        if (arrayListEnterance.get(0).getExam_name2()!=null){
            ctext2.setText(arrayListEnterance.get(0).getExam_name2());

        }else{

            cc2.setVisibility(View.GONE);
            cc3.setVisibility(View.GONE);
            cc4.setVisibility(View.GONE);
            cc5.setVisibility(View.GONE);
            cc6.setVisibility(View.GONE);

        }
        if (arrayListEnterance.get(0).getExam_name3()!=null){
            ctext3.setText(arrayListEnterance.get(0).getExam_name3());

        }else{


            cc3.setVisibility(View.GONE);
            cc4.setVisibility(View.GONE);
            cc5.setVisibility(View.GONE);
            cc6.setVisibility(View.GONE);

        }
        if (arrayListEnterance.get(0).getExam_name4()!=null){
            ctext3.setText(arrayListEnterance.get(0).getExam_name4());

        }else{



            cc4.setVisibility(View.GONE);
            cc5.setVisibility(View.GONE);
            cc6.setVisibility(View.GONE);

        }

        if (arrayListEnterance.get(0).getExam_name5()!=null){
            ctext5.setText(arrayListEnterance.get(0).getExam_name5());

        }else{




            cc5.setVisibility(View.GONE);
            cc6.setVisibility(View.GONE);

        }

        if (arrayListEnterance.get(0).getExam_name6()!=null){
            ctext5.setText(arrayListEnterance.get(0).getExam_name6());

        }else{

            cc6.setVisibility(View.GONE);

        }

        ///corsefee
        term1=view.findViewById(R.id.term1);
        term2=view.findViewById(R.id.term2);
        term3=view.findViewById(R.id.term3);
        term4=view.findViewById(R.id.term4);
        term5=view.findViewById(R.id.term5);
        term6=view.findViewById(R.id.term6);
        term7=view.findViewById(R.id.term7);
        term8=view.findViewById(R.id.term8);
        term9=view.findViewById(R.id.term9);
        term10=view.findViewById(R.id.term10);

        amount1=view.findViewById(R.id.amount1);
        amount2=view.findViewById(R.id.amount2);
        amount3=view.findViewById(R.id.amount3);
        amount4=view.findViewById(R.id.amount4);
        amount5=view.findViewById(R.id.amount5);
        amount6=view.findViewById(R.id.amount6);
        amount7=view.findViewById(R.id.amount7);
        amount8=view.findViewById(R.id.amount8);
        amount9=view.findViewById(R.id.amount9);
        amount10=view.findViewById(R.id.amount10);

        tution1=view.findViewById(R.id.tutionfee1);
        tution2=view.findViewById(R.id.tutionfee2);
        tution3=view.findViewById(R.id.tutionfee3);
        tution4=view.findViewById(R.id.tutionfee4);
        tution5=view.findViewById(R.id.tutionfee5);
        tution6=view.findViewById(R.id.tutionfee6);
        tution7=view.findViewById(R.id.tutionfee7);
        tution8=view.findViewById(R.id.tutionfee8);
        tution9=view.findViewById(R.id.tutionfee9);
        tution10=view.findViewById(R.id.tutionfee10);


        tablerow1=view.findViewById(R.id.tablerow1);
        tablerow2=view.findViewById(R.id.tablerow2);
        tablerow3=view.findViewById(R.id.tablerow3);
        tablerow4=view.findViewById(R.id.tablerow4);
        tablerow5=view.findViewById(R.id.tablerow5);
        tablerow6=view.findViewById(R.id.tablerow6);
        tablerow7=view.findViewById(R.id.tablerow7);
        tablerow8=view.findViewById(R.id.tablerow8);
        tablerow9=view.findViewById(R.id.tablerow9);
        tablerow10=view.findViewById(R.id.tablerow10);

        arrayListfee=new ArrayList<>();
        arrayListfee=sqldb.getcourse_fee_single(course_name);

        if (arrayListfee.get(0).getTerm1()!=null){
            term1.setText(arrayListfee.get(0).getTerm1());
            tution1.setText(arrayListfee.get(0).getFee_head1());
            amount1.setText(arrayListfee.get(0).getAmaount1());

        }else{
            tablerow1=view.findViewById(R.id.tablerow1);
            tablerow2=view.findViewById(R.id.tablerow2);
            tablerow3=view.findViewById(R.id.tablerow3);
            tablerow4=view.findViewById(R.id.tablerow4);
            tablerow5=view.findViewById(R.id.tablerow5);
            tablerow6=view.findViewById(R.id.tablerow6);
            tablerow7=view.findViewById(R.id.tablerow7);
            tablerow8=view.findViewById(R.id.tablerow8);
            tablerow9=view.findViewById(R.id.tablerow9);
            tablerow10=view.findViewById(R.id.tablerow10);

            tablerow1.setVisibility(View.GONE);
            tablerow2.setVisibility(View.GONE);
            tablerow3.setVisibility(View.GONE);
            tablerow4.setVisibility(View.GONE);
            tablerow5.setVisibility(View.GONE);
            tablerow6.setVisibility(View.GONE);
            tablerow7.setVisibility(View.GONE);
            tablerow8.setVisibility(View.GONE);
            tablerow9.setVisibility(View.GONE);
            tablerow10.setVisibility(View.GONE);

        }


        if (arrayListfee.get(0).getTerm2()!=null){
            term2.setText(arrayListfee.get(0).getTerm2());
            tution2.setText(arrayListfee.get(0).getFee_head2());
            amount2.setText(arrayListfee.get(0).getAmaount2());




        }else{
            tablerow1=view.findViewById(R.id.tablerow1);
            tablerow2=view.findViewById(R.id.tablerow2);
            tablerow3=view.findViewById(R.id.tablerow3);
            tablerow4=view.findViewById(R.id.tablerow4);
            tablerow5=view.findViewById(R.id.tablerow5);
            tablerow6=view.findViewById(R.id.tablerow6);
            tablerow7=view.findViewById(R.id.tablerow7);
            tablerow8=view.findViewById(R.id.tablerow8);
            tablerow9=view.findViewById(R.id.tablerow9);
            tablerow10=view.findViewById(R.id.tablerow10);


            tablerow2.setVisibility(View.GONE);
            tablerow3.setVisibility(View.GONE);
            tablerow4.setVisibility(View.GONE);
            tablerow5.setVisibility(View.GONE);
            tablerow6.setVisibility(View.GONE);
            tablerow7.setVisibility(View.GONE);
            tablerow8.setVisibility(View.GONE);
            tablerow9.setVisibility(View.GONE);
            tablerow10.setVisibility(View.GONE);

        }




        if (arrayListfee.get(0).getTerm3()!=null){
            term3.setText(arrayListfee.get(0).getTerm3());
            tution3.setText(arrayListfee.get(0).getFee_head3());
            amount3.setText(arrayListfee.get(0).getAmaount3());




        }else{



            tablerow1=view.findViewById(R.id.tablerow1);
            tablerow2=view.findViewById(R.id.tablerow2);
            tablerow3=view.findViewById(R.id.tablerow3);
            tablerow4=view.findViewById(R.id.tablerow4);
            tablerow5=view.findViewById(R.id.tablerow5);
            tablerow6=view.findViewById(R.id.tablerow6);
            tablerow7=view.findViewById(R.id.tablerow7);
            tablerow8=view.findViewById(R.id.tablerow8);
            tablerow9=view.findViewById(R.id.tablerow9);
            tablerow10=view.findViewById(R.id.tablerow10);


            tablerow3.setVisibility(View.GONE);
            tablerow4.setVisibility(View.GONE);
            tablerow5.setVisibility(View.GONE);
            tablerow6.setVisibility(View.GONE);
            tablerow7.setVisibility(View.GONE);
            tablerow8.setVisibility(View.GONE);
            tablerow9.setVisibility(View.GONE);
            tablerow10.setVisibility(View.GONE);

        }




        if (arrayListfee.get(0).getTerm4()!=null){
            term4.setText(arrayListfee.get(0).getTerm4());
            tution4.setText(arrayListfee.get(0).getFee_head4());
            amount4.setText(arrayListfee.get(0).getAmaount4());
        }else{
            tablerow1=view.findViewById(R.id.tablerow1);
            tablerow2=view.findViewById(R.id.tablerow2);
            tablerow3=view.findViewById(R.id.tablerow3);
            tablerow4=view.findViewById(R.id.tablerow4);
            tablerow5=view.findViewById(R.id.tablerow5);
            tablerow6=view.findViewById(R.id.tablerow6);
            tablerow7=view.findViewById(R.id.tablerow7);
            tablerow8=view.findViewById(R.id.tablerow8);
            tablerow9=view.findViewById(R.id.tablerow9);
            tablerow10=view.findViewById(R.id.tablerow10);


            tablerow4.setVisibility(View.GONE);
            tablerow5.setVisibility(View.GONE);
            tablerow6.setVisibility(View.GONE);
            tablerow7.setVisibility(View.GONE);
            tablerow8.setVisibility(View.GONE);
            tablerow9.setVisibility(View.GONE);
            tablerow10.setVisibility(View.GONE);

        }
        if (arrayListfee.get(0).getTerm5()!=null){
            term5.setText(arrayListfee.get(0).getTerm5());
            tution5.setText(arrayListfee.get(0).getFee_head5());
            amount5.setText(arrayListfee.get(0).getAmaount5());
        }else{
            tablerow1=view.findViewById(R.id.tablerow1);
            tablerow2=view.findViewById(R.id.tablerow2);
            tablerow3=view.findViewById(R.id.tablerow3);
            tablerow4=view.findViewById(R.id.tablerow4);
            tablerow5=view.findViewById(R.id.tablerow5);
            tablerow6=view.findViewById(R.id.tablerow6);
            tablerow7=view.findViewById(R.id.tablerow7);
            tablerow8=view.findViewById(R.id.tablerow8);
            tablerow9=view.findViewById(R.id.tablerow9);
            tablerow10=view.findViewById(R.id.tablerow10);

            tablerow5.setVisibility(View.GONE);
            tablerow6.setVisibility(View.GONE);
            tablerow7.setVisibility(View.GONE);
            tablerow8.setVisibility(View.GONE);
            tablerow9.setVisibility(View.GONE);
            tablerow10.setVisibility(View.GONE);
        }
        if (arrayListfee.get(0).getTerm6()!=null){
            term6.setText(arrayListfee.get(0).getTerm6());
            tution6.setText(arrayListfee.get(0).getFee_head6());
            amount6.setText(arrayListfee.get(0).getAmaount6());
        }else{
            tablerow1=view.findViewById(R.id.tablerow1);
            tablerow2=view.findViewById(R.id.tablerow2);
            tablerow3=view.findViewById(R.id.tablerow3);
            tablerow4=view.findViewById(R.id.tablerow4);
            tablerow5=view.findViewById(R.id.tablerow5);
            tablerow6=view.findViewById(R.id.tablerow6);
            tablerow7=view.findViewById(R.id.tablerow7);
            tablerow8=view.findViewById(R.id.tablerow8);
            tablerow9=view.findViewById(R.id.tablerow9);
            tablerow10=view.findViewById(R.id.tablerow10);


            tablerow6.setVisibility(View.GONE);
            tablerow7.setVisibility(View.GONE);
            tablerow8.setVisibility(View.GONE);
            tablerow9.setVisibility(View.GONE);
            tablerow10.setVisibility(View.GONE);
        }
        if (arrayListfee.get(0).getTerm7()!=null){
            term7.setText(arrayListfee.get(0).getTerm7());
            tution7.setText(arrayListfee.get(0).getFee_head7());
            amount7.setText(arrayListfee.get(0).getAmaount7());
        }else{
            tablerow1=view.findViewById(R.id.tablerow1);
            tablerow2=view.findViewById(R.id.tablerow2);
            tablerow3=view.findViewById(R.id.tablerow3);
            tablerow4=view.findViewById(R.id.tablerow4);
            tablerow5=view.findViewById(R.id.tablerow5);
            tablerow6=view.findViewById(R.id.tablerow6);
            tablerow7=view.findViewById(R.id.tablerow7);
            tablerow8=view.findViewById(R.id.tablerow8);
            tablerow9=view.findViewById(R.id.tablerow9);
            tablerow10=view.findViewById(R.id.tablerow10);


            tablerow7.setVisibility(View.GONE);
            tablerow8.setVisibility(View.GONE);
            tablerow9.setVisibility(View.GONE);
            tablerow10.setVisibility(View.GONE);
        }
        if (arrayListfee.get(0).getTerm8()!=null){
            term8.setText(arrayListfee.get(0).getTerm8());
            tution8.setText(arrayListfee.get(0).getFee_head8());
            amount8.setText(arrayListfee.get(0).getAmaount8());
        }else{
            tablerow1=view.findViewById(R.id.tablerow1);
            tablerow2=view.findViewById(R.id.tablerow2);
            tablerow3=view.findViewById(R.id.tablerow3);
            tablerow4=view.findViewById(R.id.tablerow4);
            tablerow5=view.findViewById(R.id.tablerow5);
            tablerow6=view.findViewById(R.id.tablerow6);
            tablerow7=view.findViewById(R.id.tablerow7);
            tablerow8=view.findViewById(R.id.tablerow8);
            tablerow9=view.findViewById(R.id.tablerow9);
            tablerow10=view.findViewById(R.id.tablerow10);


            tablerow8.setVisibility(View.GONE);
            tablerow9.setVisibility(View.GONE);
            tablerow10.setVisibility(View.GONE);
        }
        if (arrayListfee.get(0).getTerm9()!=null){
            term9.setText(arrayListfee.get(0).getTerm9());
            tution9.setText(arrayListfee.get(0).getFee_head9());
            amount9.setText(arrayListfee.get(0).getAmaount9());
        }else{
            tablerow1=view.findViewById(R.id.tablerow1);
            tablerow2=view.findViewById(R.id.tablerow2);
            tablerow3=view.findViewById(R.id.tablerow3);
            tablerow4=view.findViewById(R.id.tablerow4);
            tablerow5=view.findViewById(R.id.tablerow5);
            tablerow6=view.findViewById(R.id.tablerow6);
            tablerow7=view.findViewById(R.id.tablerow7);
            tablerow8=view.findViewById(R.id.tablerow8);
            tablerow9=view.findViewById(R.id.tablerow9);
            tablerow10=view.findViewById(R.id.tablerow10);

            tablerow9.setVisibility(View.GONE);
            tablerow10.setVisibility(View.GONE);

        }
        if (arrayListfee.get(0).getTerm10()!=null){
            term10.setText(arrayListfee.get(0).getTerm10());
            tution10.setText(arrayListfee.get(0).getFee_head10());
            amount10.setText(arrayListfee.get(0).getAmaount10());
        }else{
            tablerow1=view.findViewById(R.id.tablerow1);
            tablerow2=view.findViewById(R.id.tablerow2);
            tablerow3=view.findViewById(R.id.tablerow3);
            tablerow4=view.findViewById(R.id.tablerow4);
            tablerow5=view.findViewById(R.id.tablerow5);
            tablerow6=view.findViewById(R.id.tablerow6);
            tablerow7=view.findViewById(R.id.tablerow7);
            tablerow8=view.findViewById(R.id.tablerow8);
            tablerow9=view.findViewById(R.id.tablerow9);
            tablerow10=view.findViewById(R.id.tablerow10);


            tablerow10.setVisibility(View.GONE);

        }
        if (arrayListfee.get(0).getTerm1()==null){
            tablerow1.setVisibility(View.GONE);
            tablerow2.setVisibility(View.GONE);
            tablerow3.setVisibility(View.GONE);
            tablerow4.setVisibility(View.GONE);
            tablerow5.setVisibility(View.GONE);
            tablerow6.setVisibility(View.GONE);
            tablerow7.setVisibility(View.GONE);
            tablerow8.setVisibility(View.GONE);
            tablerow9.setVisibility(View.GONE);
            tablerow10.setVisibility(View.GONE);
        }
       return view;
    }
}