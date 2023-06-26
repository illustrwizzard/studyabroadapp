package com.axis.axistrial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SQLDB extends SQLiteOpenHelper {

    private static int version=25;
    private static String dbname="mydbnew";
    public SQLDB(@Nullable Context context) {
        super(context, dbname, null, version);
    }

    /////afffiliation

    public void insertaffi(String university_name,String aff1,String aff2,String aff3,String aff4,String aff5,String aff6 ){
        SQLiteDatabase db =getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("university_name",university_name);
        contentValues.put("aff1",aff1);
        contentValues.put("aff2",aff2);
        contentValues.put("aff3",aff3);
        contentValues.put("aff4",aff4);
        contentValues.put("aff5",aff5);
        contentValues.put("aff6",aff6);
        db.insert("affiliation",null,contentValues);

    }
    public void insertaffi(String university_name,String aff1,String aff2,String aff3,String aff4,String aff5){
        SQLiteDatabase db =getWritableDatabase();
        Log.w("rrrrrrrrrr","enterd db");
        ContentValues contentValues = new ContentValues();
        contentValues.put("university_name",university_name);
        contentValues.put("aff1",aff1);
        contentValues.put("aff2",aff2);
        contentValues.put("aff3",aff3);
        contentValues.put("aff4",aff4);
        contentValues.put("aff5",aff5);
        db.insert("affiliation",null,contentValues);

    }
    public void insertaffi(String university_name,String aff1,String aff2,String aff3,String aff4){
        SQLiteDatabase db =getWritableDatabase();
        Log.w("rrrrrrrrrr","enterd db");
        ContentValues contentValues = new ContentValues();
        contentValues.put("university_name",university_name);
        contentValues.put("aff1",aff1);
        contentValues.put("aff2",aff2);
        contentValues.put("aff3",aff3);
        contentValues.put("aff4",aff4);
        db.insert("affiliation",null,contentValues);

    }
    public void insertaffi(String university_name,String aff1,String aff2,String aff3){
        SQLiteDatabase db =getWritableDatabase();
        Log.w("rrrrrrrrrr","enterd db");
        ContentValues contentValues = new ContentValues();
        contentValues.put("university_name",university_name);
        contentValues.put("aff1",aff1);
        contentValues.put("aff2",aff2);
        contentValues.put("aff3",aff3);
        db.insert("affiliation",null,contentValues);

    }
    public void insertaffi(String university_name,String aff1,String aff2){
        SQLiteDatabase db =getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("university_name",university_name);
        contentValues.put("aff1",aff1);
        contentValues.put("aff2",aff2);
        db.insert("affiliation",null,contentValues);

    }



    public void insertaffi(String university_name,String aff1){
        SQLiteDatabase db =getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("university_name",university_name);
        contentValues.put("aff1",aff1);
        db.insert("affiliation",null,contentValues);

    }
    public void insertaffi(String university_name) {
        SQLiteDatabase db =getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("university_name",university_name);
        db.insert("affiliation",null,contentValues);

    }



    ////////////////////UNIVERSITY FEED//////////////


    public void insert_unv_feed(String university_name, String feed, String feed_image, String youtube) {


        SQLiteDatabase db =getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("university_name",university_name);
        values.put("feed",feed);
        values.put("feed_image",feed_image);
        values.put("youtube",youtube);
        db.insert("unv_feed",null,values);
    }







    /////university ranking

    public void insertrank(String university_name,String Rname1,String Ranking1,String Rname2,String Ranking2,String Rname3,
                           String Ranking3,String Rname4,String Ranking4,String Rname5,String Ranking5,String Rname6,String Ranking6){
        SQLiteDatabase db =getWritableDatabase();
        Log.w("rrrrrrrrrr","enterd db");
        ContentValues values=new ContentValues();
        values.put("university_name",university_name);
        values.put("Rname1",Rname1);
        values.put("Ranking1",Ranking1);
        values.put("Rname2",Rname2);
        values.put("Ranking2",Ranking2);
        values.put("Rname3",Rname3);
        values.put("Ranking3",Ranking3);
        values.put("Rname4",Rname4);
        values.put("Ranking4",Ranking4);
        values.put("Rname5",Rname5);
        values.put("Ranking5",Ranking5);
        values.put("Rname6",Rname6);
        values.put("Ranking6",Ranking6);
        db.insert("ranking",null,values);

    }

    public void insertrank(String university_name,String Rname1,String Ranking1,String Rname2,String Ranking2,String Rname3,
                           String Ranking3,String Rname4,String Ranking4,String Rname5,String Ranking5){
        SQLiteDatabase db =getWritableDatabase();
        Log.w("rrrrrrrrrr","enterd db");
        ContentValues values=new ContentValues();
        values.put("university_name",university_name);
        values.put("Rname1",Rname1);
        values.put("Ranking1",Ranking1);
        values.put("Rname2",Rname2);
        values.put("Ranking2",Ranking2);
        values.put("Rname3",Rname3);
        values.put("Ranking3",Ranking3);
        values.put("Rname4",Rname4);
        values.put("Ranking4",Ranking4);
        values.put("Rname5",Rname5);
        values.put("Ranking5",Ranking5);
        db.insert("ranking",null,values);

    }

    public void insertrank(String university_name,String Rname1,String Ranking1,String Rname2,String Ranking2,String Rname3,
                           String Ranking3,String Rname4,String Ranking4){
        Log.w("rrrrrrrrrr","enterd db");
        SQLiteDatabase db =getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("university_name",university_name);
        values.put("Rname1",Rname1);
        values.put("Ranking1",Ranking1);
        values.put("Rname2",Rname2);
        values.put("Ranking2",Ranking2);
        values.put("Rname3",Rname3);
        values.put("Ranking3",Ranking3);
        values.put("Rname4",Rname4);
        values.put("Ranking4",Ranking4);

        db.insert("ranking",null,values);

    }

    public void insertrank(String university_name,String Rname1,String Ranking1,String Rname2,String Ranking2,String Rname3,
                           String Ranking3){
        Log.w("rrrrrrrrrr","enterd db");
        SQLiteDatabase db =getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("university_name",university_name);
        values.put("Rname1",Rname1);
        values.put("Ranking1",Ranking1);
        values.put("Rname2",Rname2);
        values.put("Ranking2",Ranking2);
        values.put("Rname3",Rname3);
        values.put("Ranking3",Ranking3);


        db.insert("ranking",null,values);

    }

    public void insertrank(String university_name,String Rname1,String Ranking1,String Rname2,String Ranking2){
        SQLiteDatabase db =getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("university_name",university_name);
        values.put("Rname1",Rname1);
        values.put("Ranking1",Ranking1);
        values.put("Rname2",Rname2);
        values.put("Ranking2",Ranking2);

        db.insert("ranking",null,values);

    }
    public void insertrank(String university_name,String Rname1,String Ranking1){
        SQLiteDatabase db =getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("university_name",university_name);
        values.put("Rname1",Rname1);
        values.put("Ranking1",Ranking1);
        db.insert("ranking",null,values);

    }

    public void insertrank(String university_name){
        SQLiteDatabase db =getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("university_name",university_name);
        db.insert("ranking",null,values);

    }




    //////////

    ////facility

    public void insertfacility(String university_name,String fac1,String fac2,String fac3,String fac4,String fac5,String fac6){

        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("university_name",university_name);
        values.put("fac1",fac1);
        values.put("fac2",fac2);
        values.put("fac3",fac3);
        values.put("fac4",fac4);
        values.put("fac5",fac5);
        values.put("fac6",fac6);
        db.insert("facility",null,values);

    }

    public void insertfacility(String university_name,String fac1,String fac2,String fac3,String fac4,String fac5){

        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("university_name",university_name);
        values.put("fac1",fac1);
        values.put("fac2",fac2);
        values.put("fac3",fac3);
        values.put("fac4",fac4);
        values.put("fac5",fac5);
        db.insert("facility",null,values);


    }
    public void insertfacility(String university_name,String fac1,String fac2,String fac3,String fac4){

        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("university_name",university_name);
        values.put("fac1",fac1);
        values.put("fac2",fac2);
        values.put("fac3",fac3);
        values.put("fac4",fac4);
        db.insert("facility",null,values);

    }

    public void insertfacility(String university_name,String fac1,String fac2,String fac3){

        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("university_name",university_name);
        values.put("fac1",fac1);
        values.put("fac2",fac2);
        values.put("fac3",fac3);
        db.insert("facility",null,values);

    }
    public void insertfacility(String university_name,String fac1,String fac2){

        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("university_name",university_name);
        values.put("fac1",fac1);
        values.put("fac2",fac2);
        db.insert("facility",null,values);


    }


    public void insertfacility(String university_name,String fac1){

        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("university_name",university_name);
        values.put("fac1",fac1);

        db.insert("facility",null,values);


    }
    public void insertfacility(String university_name) {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("university_name",university_name);

        db.insert("facility",null,values);
    }





    /////

    ////university



    public void insertuniv_details(String university_name,String rating,String estd,String status,String sector,String about,
                                   String banner,String logo,String location,String city,String country,String contact,String email,String website){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put("university_name",university_name);
        values.put("rating",rating);
        values.put("estd",estd);
        values.put("status",status);
        values.put("sector",sector);
        values.put("about",about);
        values.put("banner",banner);
        values.put("logo",logo);
        values.put("city",city);
        values.put("location",location);
        values.put("country",country);
        values.put("contact",contact);
        values.put("email",email);
        values.put("website",website);
        db.insert("univ_details",null,values);

    }

    ///////////////////////////Single feed
    public ArrayList<Unv_Feed>get_feed_details(String feed){
        ArrayList<Unv_Feed>arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from unv_feed where feed =?",new String[]{feed});
        res.moveToFirst();
        while(res.isAfterLast() == false){
            arrayList.add(new Unv_Feed(res.getString(1), res.getString(2), res.getString(3), res.getString(4)));
            res.moveToNext();
        }

        return arrayList;
    }




    public ArrayList<Unv_Feed>get_feed_details_bookmark(String feed){
        ArrayList<Unv_Feed>arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from unv_feed_bookmark where feed =?",new String[]{feed});
        res.moveToFirst();
        while(res.isAfterLast() == false){
            arrayList.add(new Unv_Feed(res.getString(1), res.getString(2), res.getString(3), res.getString(4)));
            res.moveToNext();
        }

        return arrayList;


    }



    public ArrayList<Unv_Feed>get_feed_details_bookmark1(String feed){
        ArrayList<Unv_Feed>arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from unv_feed_bookmark1 where feed =?",new String[]{feed});
        res.moveToFirst();
        while(res.isAfterLast() == false){
            arrayList.add(new Unv_Feed(res.getString(1), res.getString(2), res.getString(3), res.getString(4)));
            res.moveToNext();
        }

        return arrayList;


    }

    ////




    //public ArrayList<DataModelClassForCourse>getcourse_details_single_course_name(String  university_name){
    //        ArrayList<DataModelClassForCourse>arrayList = new ArrayList<>();
    //        SQLiteDatabase db = this.getReadableDatabase();
    //        Cursor res =  db.rawQuery( "select * from course_details where course_name =?", new String[]{university_name} );
    //        res.moveToFirst();
    //
    //        while(res.isAfterLast() == false){
    //            arrayList.add(new DataModelClassForCourse(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
    //                    res.getString(5), res.getString(6), res.getString(7), res.getString(8),
    //                    res.getString(9), res.getString(10), res.getString(11), res.getString(12), res.getString(13),
    //                    res.getString(14), res.getString(15), res.getString(16), res.getString(17),
    //                    res.getString(18)));
    //            res.moveToNext();
    //        }
    //        return arrayList;}



    /////////////////////////UNIVERSITY PROCEDURES//////////////////////////
    public void insert_unv_procedures(String university_name, String apply, String visa, String service, String documents) {

        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("university_name",university_name);
        values.put("apply",apply);
        values.put("visa",visa);
        values.put("service",service);
        values.put("documents",documents);
        db.insert("unv_procedure",null,values);
    }









//////////////////UNIVERSITY_ACCOMODATION

    public void insert_un_accomodation(String university_name, String hst_name, String room_type, String duration, String fee) {

        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("university_name",university_name);
        values.put("hst_name",hst_name);
        values.put("room_type",room_type);
        values.put("duration",duration);
        values.put("fee",fee);
        db.insert("unv_accom",null,values);
    }



    public ArrayList<Un_Accomodation>getUnvAccomodation_single(String hst_name){
        ArrayList<Un_Accomodation>arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from unv_accom where hst_name=? ",new String[]{hst_name});
        res.moveToFirst();

        while (res.isAfterLast()==false){
            arrayList.add(new Un_Accomodation(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5)));

            res.moveToNext();
        }
        return arrayList;
    }






//    public ArrayList<Un_Accomodation>getUnvAccomodation(){
//        ArrayList<Un_Accomodation>arrayList=new ArrayList<>();
//        SQLiteDatabase db=this.getReadableDatabase();
//        Cursor res=db.rawQuery("select * from unv_accom ",null);
//        res.moveToFirst();
//
//        while (res.isAfterLast()==false){
//            arrayList.add(new Un_Accomodation(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7)
//                    , res.getString(8), res.getString(9), res.getString(10), res.getString(11), res.getString(12), res.getString(13)
//                    , res.getString(13), res.getString(14), res.getString(15), res.getString(16), res.getString(17), res.getString(18), res.getString(19), res.getString(20), res.getString(21), res.getString(22), res.getString(23), res.getString(24)));
//
//            res.moveToNext();
//        }
//        return arrayList;
//    }



    // ArrayList<UnvdataClass>arrayList= new ArrayList<>();
    //        SQLiteDatabase db = this.getReadableDatabase();
    //        Cursor res =  db.rawQuery( "select * from univ_details  ", null );
    //        res.moveToFirst();
    //
    //        while(res.isAfterLast() == false){
    //            arrayList.add(new UnvdataClass(res.getString(1), res.getString(10), res.getString(3), res.getString(2) ));
    //            res.moveToNext();
    //        }
    //
    //       return arrayList;


///Get coursedetails

    public ArrayList<DataModelClassForCourse>getFiltercourse(String course_name){
        ArrayList<DataModelClassForCourse>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from course_details where course_name =?", new String[]{course_name} );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new DataModelClassForCourse(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7)));
            res.moveToNext();
        }

        return arrayList;

    }

    ///get univ_details

    public ArrayList<UnvdataClass>getFilterCountry(String country){
        ArrayList<UnvdataClass>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from univ_details where country in("+country+") ",null);
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnvdataClass(res.getString(1), res.getString(10), res.getString(3), res.getString(2) ));
            res.moveToNext();
        }

        return arrayList;

    }
    public ArrayList<UnvdataClass> getuniv_details_univh(String univ_name){

        ArrayList<UnvdataClass>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from univ_details where university_name in("+ univ_name+")", null);
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnvdataClass(res.getString(1), res.getString(2), res.getString(3), res.getString(4) , res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10), res.getString(11), res.getString(12), res.getString(13), res.getString(14)));
            res.moveToNext();
        }

        return arrayList;

    }

    public ArrayList<UnvdataClass> getuniv_details_single(String univ_name){

        ArrayList<UnvdataClass>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from univ_details where university_name in ("+'"'+univ_name+'"'+") ", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnvdataClass(res.getString(1), res.getString(2), res.getString(3), res.getString(4) , res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10), res.getString(11), res.getString(12), res.getString(13), res.getString(14)));
            res.moveToNext();
        }

        return arrayList;

    }



    public ArrayList<UnvdataClass> getuniv_details_single_bookmark(String univ_name){

        ArrayList<UnvdataClass>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from univ_details_bookmark where university_name in ("+'"'+univ_name+'"'+") ", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnvdataClass(res.getString(1), res.getString(2), res.getString(3), res.getString(4) , res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10), res.getString(11), res.getString(12), res.getString(13), res.getString(14)));
            res.moveToNext();
        }

        return arrayList;

    }

    ///////

    public ArrayList<UnvdataClass> getuniv_details_single_bookmark1(String univ_name){

        ArrayList<UnvdataClass>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from univ_details_bookmark1 where university_name in ("+'"'+univ_name+'"'+") ", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnvdataClass(res.getString(1), res.getString(2), res.getString(3), res.getString(4) , res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10), res.getString(11), res.getString(12), res.getString(13), res.getString(14)));
            res.moveToNext();
        }

        return arrayList;

    }








    public ArrayList<UnvdataClass> getuniv_details(){

        ArrayList<UnvdataClass>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from univ_details  ", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnvdataClass(res.getString(1), res.getString(2), res.getString(3), res.getString(4) , res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10), res.getString(11), res.getString(12), res.getString(13), res.getString(14)));
            res.moveToNext();
        }

        return arrayList;

    }








    public ArrayList<UnvdataClass> getuniv_details_bookmark(){

        ArrayList<UnvdataClass>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from univ_details_bookmark  ", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnvdataClass(res.getString(1), res.getString(2), res.getString(3), res.getString(4) , res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10), res.getString(11), res.getString(12), res.getString(13), res.getString(14)));
            res.moveToNext();
        }

        return arrayList;

    }

    /////////


    public ArrayList<UnvdataClass> getuniv_details_bookmark1(){

        ArrayList<UnvdataClass>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from univ_details_bookmark1  ", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnvdataClass(res.getString(1), res.getString(2), res.getString(3), res.getString(4) , res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10), res.getString(11), res.getString(12), res.getString(13), res.getString(14)));
            res.moveToNext();
        }

        return arrayList;

    }



    ////////




    public ArrayList<UnvdataClass>getUnv_singledetails(String university_name){
        ArrayList<UnvdataClass>arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from univ_details where university_name=?",new String[]{university_name});
        res.moveToFirst();

        while (res.isAfterLast()==false){
            arrayList.add(new UnvdataClass(res.getString(1), res.getString(2), res.getString(3), res.getString(4) , res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10), res.getString(11), res.getString(12), res.getString(13), res.getString(14)));
            res.moveToNext();
        }
        return  arrayList;


    }


    public ArrayList<UnvdataClass>getUnv_singledetails_bookmark(String university_name){
        ArrayList<UnvdataClass>arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from univ_details_bookmark where university_name=?",new String[]{university_name});
        res.moveToFirst();

        while (res.isAfterLast()==false){
            arrayList.add(new UnvdataClass(res.getString(1), res.getString(2), res.getString(3), res.getString(4) , res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10), res.getString(11), res.getString(12), res.getString(13), res.getString(14)));
            res.moveToNext();
        }
        return  arrayList;


    }


    ///////


    public ArrayList<UnvdataClass>getUnv_singledetails_bookmark1(String university_name){
        ArrayList<UnvdataClass>arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from univ_details_bookmark1 where university_name=?",new String[]{university_name});
        res.moveToFirst();

        while (res.isAfterLast()==false){
            arrayList.add(new UnvdataClass(res.getString(1), res.getString(2), res.getString(3), res.getString(4) , res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10), res.getString(11), res.getString(12), res.getString(13), res.getString(14)));
            res.moveToNext();
        }
        return  arrayList;


    }







    ///////////////////// GET UNIVERSITY FEED ///////////////////



    public ArrayList<Unv_Feed>getUnv_Feed(String university_name){
        ArrayList<Unv_Feed>arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from unv_feed group by feed having university_name in("+'"'+university_name+'"'+")",null);
        res.moveToFirst();

        while (res.isAfterLast()==false){
            arrayList.add(new Unv_Feed(res.getString(1),res.getString(2),res.getString(3),res.getString(4)));
            res.moveToNext();
        }
        return  arrayList;


    }


    public ArrayList<Unv_Feed>getUnv_Feed_bookmark(String university_name){
        ArrayList<Unv_Feed>arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from unv_feed_bookmark where university_name=?",new String[]{university_name});
        res.moveToFirst();

        while (res.isAfterLast()==false){
            arrayList.add(new Unv_Feed(res.getString(1),res.getString(2),res.getString(3),res.getString(4)));
            res.moveToNext();
        }
        return  arrayList;


    }



    /////
    public ArrayList<Unv_Feed>getUnv_Feed_bookmark1(String university_name){
        ArrayList<Unv_Feed>arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from unv_feed_bookmark1 where university_name=?",new String[]{university_name});
        res.moveToFirst();

        while (res.isAfterLast()==false){
            arrayList.add(new Unv_Feed(res.getString(1),res.getString(2),res.getString(3),res.getString(4)));
            res.moveToNext();
        }
        return  arrayList;


    }






    ////// GET UNIVERSITY PROCEDURE


    public ArrayList<Unv_Procedure>getUnv_Procedure(String university_name){
        ArrayList<Unv_Procedure>arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from unv_procedure where university_name=?",new String[]{university_name});
        res.moveToFirst();

        while (res.isAfterLast()==false){
            arrayList.add(new Unv_Procedure(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5)));
            res.moveToNext();
        }
        return  arrayList;


    }

    public ArrayList<Unv_Procedure>getUnv_Procedure_bookmark(String university_name){
        ArrayList<Unv_Procedure>arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from unv_procedure_bookmark where university_name=?",new String[]{university_name});
        res.moveToFirst();

        while (res.isAfterLast()==false){
            arrayList.add(new Unv_Procedure(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5)));
            res.moveToNext();
        }
        return  arrayList;


    }

    /////



    public ArrayList<Unv_Procedure>getUnv_Procedure_bookmark1(String university_name){
        ArrayList<Unv_Procedure>arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from unv_procedure_bookmark1 where university_name=?",new String[]{university_name});
        res.moveToFirst();

        while (res.isAfterLast()==false){
            arrayList.add(new Unv_Procedure(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5)));
            res.moveToNext();
        }
        return  arrayList;


    }







    /////get affiliation


    public ArrayList<UnivAff>getaffiliation_single(String univ_name){


        ArrayList<UnivAff>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from affiliation where university_name in("+'"'+univ_name+'"'+")", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnivAff(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5) , res.getString(6), res.getString(7) ));
            res.moveToNext();
        }

        return arrayList;


    }


    public ArrayList<UnivAff>getaffiliation_single_bookmark(String univ_name){


        ArrayList<UnivAff>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from affiliation_bookmark where university_name=?", new String[]{univ_name} );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnivAff(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5) , res.getString(6), res.getString(7) ));
            res.moveToNext();
        }

        return arrayList;


    }

    ///
    public ArrayList<UnivAff>getaffiliation_single_bookmark1(String univ_name){


        ArrayList<UnivAff>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from affiliation_bookmark1 where university_name=?", new String[]{univ_name} );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnivAff(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5) , res.getString(6), res.getString(7) ));
            res.moveToNext();
        }

        return arrayList;


    }




    public ArrayList<UnivAff>getaffiliation(){


        ArrayList<UnivAff>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from affiliation ", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnivAff(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5) , res.getString(6), res.getString(7) ));
            res.moveToNext();
        }

        return arrayList;


    }
    public void deletetable_univ(){

        SQLiteDatabase DB= getWritableDatabase();
        DB.execSQL("delete from affiliation");
        DB.execSQL("delete from ranking ");
        DB.execSQL("delete from facility");
        DB.execSQL("delete from univ_details");
        DB.execSQL("delete from unv_accom");


        DB.execSQL("delete from unv_feed");
        DB.execSQL("delete from unv_procedure");

        DB.execSQL("delete from university_in_course");



        DB.close();



    }
    public void deletetable(){

        SQLiteDatabase DB= getWritableDatabase();
        DB.execSQL("delete from affiliation");
        DB.execSQL("delete from ranking ");
        DB.execSQL("delete from facility");
        DB.execSQL("delete from univ_details");
        DB.execSQL("delete from unv_accom");
        DB.execSQL("delete from coursefee");
        DB.execSQL("delete from course_details");
        DB.execSQL("delete from university_fees");
        DB.execSQL("delete from unv_feed");
        DB.execSQL("delete from unv_procedure");
        DB.execSQL("delete from enterance");
        DB.execSQL("delete from university_in_course");
        DB.execSQL("delete from eligibility");


        DB.close();



    }
    public void deletetable_bookmark(){

        SQLiteDatabase DB= getWritableDatabase();
        DB.execSQL("delete from affiliation_bookmark");
        DB.execSQL("delete from ranking_bookmark ");
        DB.execSQL("delete from facility_bookmark");
        DB.execSQL("delete from univ_details_bookmark");
        DB.execSQL("delete from unv_accom_bookmark");
        DB.execSQL("delete from coursefee_bookmark");
        DB.execSQL("delete from course_details_bookmark");
        DB.execSQL("delete from university_fees_bookmark");
        DB.execSQL("delete from unv_feed_bookmark");
        DB.execSQL("delete from unv_procedure_bookmark");
        DB.execSQL("delete from enterance_bookmark");
        DB.execSQL("delete from university_in_course_bookmark");
        DB.execSQL("delete from eligibility_bookmark");


        DB.close();



    }


    /////



    public void deletetable_bookmark1(){

        SQLiteDatabase DB= getWritableDatabase();
        DB.execSQL("delete from affiliation_bookmark1");
        DB.execSQL("delete from ranking_bookmark1 ");
        DB.execSQL("delete from facility_bookmark1");
        DB.execSQL("delete from univ_details_bookmark1");
        DB.execSQL("delete from unv_accom_bookmark1");
        DB.execSQL("delete from coursefee_bookmark1");
        DB.execSQL("delete from course_details_bookmark1");
        DB.execSQL("delete from university_fees_bookmark1");
        DB.execSQL("delete from unv_feed_bookmark1");
        DB.execSQL("delete from unv_procedure_bookmark1");
        DB.execSQL("delete from enterance_bookmark1");
        DB.execSQL("delete from university_in_course_bookmark1");
        DB.execSQL("delete from eligibility_bookmark1");


        DB.close();



    }

    public void deleteStudentid(){
        SQLiteDatabase DB= getWritableDatabase();
        DB.execSQL("delete from studentData");
        DB.execSQL("delete from login_count");
        DB.close();


    }


    /////get facility


    public ArrayList<UnivFac> getfacility_single(String univ_name){
        ArrayList<UnivFac>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from facility where university_name in ("+'"'+univ_name+'"'+")", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnivFac(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5) , res.getString(6), res.getString(7) ));
            res.moveToNext();
        }

        return arrayList;



    }



    public ArrayList<UnivFac> getfacility_single_bookmark(String univ_name){
        ArrayList<UnivFac>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from facility_bookmark where university_name =?", new String[]{univ_name} );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnivFac(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5) , res.getString(6), res.getString(7) ));
            res.moveToNext();
        }

        return arrayList;



    }




    public ArrayList<UnivFac> getfacility_single_bookmark1(String univ_name){
        ArrayList<UnivFac>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from facility_bookmark1 where university_name =?", new String[]{univ_name} );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnivFac(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5) , res.getString(6), res.getString(7) ));
            res.moveToNext();
        }

        return arrayList;



    }






    public ArrayList<UnivFac> getfacility(){
        ArrayList<UnivFac>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from affiliation ", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnivFac(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5) , res.getString(6), res.getString(7) ));
            res.moveToNext();
        }

        return arrayList;



    }
    //////


    /////////get univ_ranking
    public ArrayList<UnivRank>getUnivRanking_single(String univ_name){

        ArrayList<UnivRank>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from ranking where university_name in("+'"'+univ_name+'"'+") ", null);
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnivRank(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5) , res.getString(6),
                    res.getString(7),res.getString(8),res.getString(9),
                    res.getString(10),res.getString(11),res.getString(12),res.getString(13) ));
            res.moveToNext();
        }

        return arrayList;


    }

    public ArrayList<UnivRank>getUnivRanking_single_bookmark(String univ_name){

        ArrayList<UnivRank>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from ranking_bookmark where university_name = ? ", new String[] {univ_name});
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnivRank(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5) , res.getString(6),
                    res.getString(7),res.getString(8),res.getString(9),
                    res.getString(10),res.getString(11),res.getString(12),res.getString(13) ));
            res.moveToNext();
        }

        return arrayList;


    }



    public ArrayList<UnivRank>getUnivRanking_single_bookmark1(String univ_name){

        ArrayList<UnivRank>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from ranking_bookmark1 where university_name = ? ", new String[] {univ_name});
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnivRank(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5) , res.getString(6),
                    res.getString(7),res.getString(8),res.getString(9),
                    res.getString(10),res.getString(11),res.getString(12),res.getString(13) ));
            res.moveToNext();
        }

        return arrayList;


    }








    //// Get University_fee

    public ArrayList<Unv_fee>getunv_fee(){
        ArrayList<Unv_fee>arrayList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from university_fees",null);
        res.moveToFirst();
        while (res.isAfterLast()==false){
            //arrayList.add(new Unv_fee(res.getString(1),res.getString(2)));
            arrayList.add(new Unv_fee(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5) , res.getString(6),
                    res.getString(7),res.getString(8),res.getString(9),
                    res.getString(10),res.getString(11),res.getString(12),res.getString(13) ));

            res.moveToNext();
        }

        return arrayList;


    }




    //////university Ranking



    public ArrayList<UnivRank>getUnivRanking(){

        ArrayList<UnivRank>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from affiliation ", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnivRank(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5) , res.getString(6),
                    res.getString(7),res.getString(8),res.getString(9),
                    res.getString(10),res.getString(11),res.getString(12),res.getString(13) ));
            res.moveToNext();
        }

        return arrayList;


    }


    /////
    // INSERT COURSE FEE

    public void insertcoursefee(String course_name){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);

        db.insert("coursefee",null,contentValues);
    }



    //////////////////////////////////////////////////////////////
    ///7
    public ArrayList<UnvdataClass>getFilteruniv_rating_location_mul(String rating,String location){
        //Log.w("inside table",estd);
        ArrayList<UnvdataClass>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from univ_details where rating IN ("+rating+") AND location IN("+location+")",null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnvdataClass(res.getString(1), res.getString(10), res.getString(3), res.getString(2) ));
            res.moveToNext();
        }

        return arrayList;
    }

    ////6
    public ArrayList<UnvdataClass>getFilterCountry_rating_Location_mul(String country,String rating,String location){
        Log.w("inside table",rating);
        ArrayList<UnvdataClass>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from univ_details where country IN ("+country+") AND rating IN("+rating+") AND location IN("+location+")",null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnvdataClass(res.getString(1), res.getString(10), res.getString(3), res.getString(2) ));
            res.moveToNext();
        }

        return arrayList;
    }

    //5
    public ArrayList<UnvdataClass>getFilterCountry_rating_mul(String country,String rating){
        //Log.w("inside table",estd);
        ArrayList<UnvdataClass>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from univ_details where country IN ("+country+") AND rating IN("+rating+")",null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnvdataClass(res.getString(1), res.getString(10), res.getString(3), res.getString(2) ));
            res.moveToNext();
        }

        return arrayList;
    }





    //4
    public ArrayList<UnvdataClass>getFilterCountry_location_mul(String country,String location){
        //Log.w("inside table",estd);
        ArrayList<UnvdataClass>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from univ_details where country IN ("+country+") AND location IN("+location+")",null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnvdataClass(res.getString(1), res.getString(10), res.getString(3), res.getString(2) ));
            res.moveToNext();
        }

        return arrayList;
    }

    //3
    public ArrayList<UnvdataClass>getFilter_univ_location(String location){
        //Log.w("inside table",estd);
        ArrayList<UnvdataClass>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from univ_details where  location IN("+location+")",null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnvdataClass(res.getString(1), res.getString(10), res.getString(3), res.getString(2) ));
            res.moveToNext();
        }

        return arrayList;
    }

    //2
    public ArrayList<UnvdataClass>getFilter_univ_rating(String rating){
        //Log.w("inside table",estd);
        ArrayList<UnvdataClass>arrayList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select  * from univ_details where  rating IN("+rating+")",null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UnvdataClass(res.getString(1), res.getString(10), res.getString(3), res.getString(2) ));
            res.moveToNext();
        }

        return arrayList;
    }



    /////COURSE FILTER QUERRY
    //1
    public ArrayList<DataModelClassForCourse>get_mul_course_details_between_fee_university_course_type(String amount,String university,String course_type){
        ArrayList<DataModelClassForCourse>arrayList = new ArrayList<>();
        int a=1000;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from university_in_course  where total_fee  between ("+a+") and ("+amount+") and  university in ("+university+") and  course in ("+course_type+")", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new DataModelClassForCourse(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7)));
            res.moveToNext();
        }
        return arrayList;

    }
    //2
    public ArrayList<DataModelClassForCourse>get_mul_course_details_between_fee_university(String amount,String university){
        ArrayList<DataModelClassForCourse>arrayList = new ArrayList<>();
        int a=1000;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from university_in_course  where total_fee  between ("+a+") and ("+amount+") and university in("+university+") ", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new DataModelClassForCourse(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7)));
            res.moveToNext();
        }
        return arrayList;

    }
    //3
    public ArrayList<DataModelClassForCourse>get_mul_course_details_between_course_type(String amount,String  course_type){
        ArrayList<DataModelClassForCourse>arrayList = new ArrayList<>();
        int a=1000;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from university_in_course  where total_fee  between ("+a+") and ("+amount+") and course in ("+course_type+") ", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new DataModelClassForCourse(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7)));
            res.moveToNext();
        }
        return arrayList;

    }
    //4
    public ArrayList<DataModelClassForCourse>get_mul_course_university_course_Type(String course_type,String university){
        ArrayList<DataModelClassForCourse>arrayList = new ArrayList<>();
        int a=1000;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from university_in_course  where university in ("+university+") and course in ("+course_type+")", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new DataModelClassForCourse(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7)));
            res.moveToNext();
        }
        return arrayList;

    }


    //5
    public ArrayList<DataModelClassForCourse>get_mul_course_details_between_fee(String amount){
        ArrayList<DataModelClassForCourse>arrayList = new ArrayList<>();
        int a=1000;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from university_in_course  where total_fee  between ("+a+") and ("+amount+")", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new DataModelClassForCourse(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7)));
            res.moveToNext();
        }
        return arrayList;

    }
    //6
    public ArrayList<DataModelClassForCourse>get_mul_course_details_university(String university){
        ArrayList<DataModelClassForCourse>arrayList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from university_in_course  where university in ("+university+")", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new DataModelClassForCourse(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7)));
            res.moveToNext();
        }
        return arrayList;

    }
    //7
    public ArrayList<DataModelClassForCourse>get_mul_course_details_course_type(String course_type){
        ArrayList<DataModelClassForCourse>arrayList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from university_in_course  where course in ("+course_type+")", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new DataModelClassForCourse(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7)));
            res.moveToNext();
        }
        return arrayList;

    }












    ////////////////////////




    //////////////////////////////////////////////////////////////////////






    public void insertcoursefee(String course_name,String term1,String fee_head1,String amount1){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("term1",term1);
        contentValues.put("fee_head1",fee_head1);
        contentValues.put("amount1",amount1);
        db.insert("coursefee",null,contentValues);
    }
    public void insertcoursefee(String course_name,String term1,String fee_head1,String amount1,String term2,String fee_head2,String amount2){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("term1",term1);
        contentValues.put("fee_head1",fee_head1);
        contentValues.put("amount1",amount1);
        contentValues.put("term2",term2);
        contentValues.put("fee_head2",fee_head2);
        contentValues.put("amount2",amount2);
        db.insert("coursefee",null,contentValues);
    }
    public void insertcoursefee(String course_name,String term1,String fee_head1,String amount1,String term2,String fee_head2,String amount2,String term3,String fee_head3,String amount3){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("term1",term1);
        contentValues.put("fee_head1",fee_head1);
        contentValues.put("amount1",amount1);
        contentValues.put("term2",term2);
        contentValues.put("fee_head2",fee_head2);
        contentValues.put("amount2",amount2);
        contentValues.put("term3",term3);
        contentValues.put("fee_head3",fee_head3);
        contentValues.put("amount3",amount3);
        db.insert("coursefee",null,contentValues);
    }

    public void insertcoursefee(String course_name,String term1,String fee_head1,String amount1,String term2,String fee_head2,String amount2,String term3,String fee_head3,String amount3,String term4,String fee_head4,String amount4){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("term1",term1);
        contentValues.put("fee_head1",fee_head1);
        contentValues.put("amount1",amount1);
        contentValues.put("term2",term2);
        contentValues.put("fee_head2",fee_head2);
        contentValues.put("amount2",amount2);
        contentValues.put("term3",term3);
        contentValues.put("fee_head3",fee_head3);
        contentValues.put("amount3",amount3);
        contentValues.put("term4",term4);
        contentValues.put("fee_head4",fee_head4);
        contentValues.put("amount4",amount4);
        db.insert("coursefee",null,contentValues);
    }

    public void insertcoursefee(String course_name,String term1,String fee_head1,String amount1,String term2,String fee_head2,String amount2,String term3,String fee_head3,String amount3,String term4,String fee_head4,String amount4,String term5,String fee_head5,String amount5){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("term1",term1);
        contentValues.put("fee_head1",fee_head1);
        contentValues.put("amount1",amount1);
        contentValues.put("term2",term2);
        contentValues.put("fee_head2",fee_head2);
        contentValues.put("amount2",amount2);
        contentValues.put("term3",term3);
        contentValues.put("fee_head3",fee_head3);
        contentValues.put("amount3",amount3);
        contentValues.put("term4",term4);
        contentValues.put("fee_head4",fee_head4);
        contentValues.put("amount4",amount4);
        contentValues.put("term5",term5);
        contentValues.put("fee_head5",fee_head5);
        contentValues.put("amount5",amount5);
        db.insert("coursefee",null,contentValues);
    }

    public void insertcoursefee(String course_name,String term1,String fee_head1,String amount1,String term2,String fee_head2,String amount2,String term3,String fee_head3,String amount3,String term4,String fee_head4,String amount4,String term5,String fee_head5,String amount5,String term6,String fee_head6,String amount6){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("term1",term1);
        contentValues.put("fee_head1",fee_head1);
        contentValues.put("amount1",amount1);
        contentValues.put("term2",term2);
        contentValues.put("fee_head2",fee_head2);
        contentValues.put("amount2",amount2);
        contentValues.put("term3",term3);
        contentValues.put("fee_head3",fee_head3);
        contentValues.put("amount3",amount3);
        contentValues.put("term4",term4);
        contentValues.put("fee_head4",fee_head4);
        contentValues.put("amount4",amount4);
        contentValues.put("term5",term5);
        contentValues.put("fee_head5",fee_head5);
        contentValues.put("amount5",amount5);

        contentValues.put("term6",term6);
        contentValues.put("fee_head6",fee_head6);
        contentValues.put("amount6",amount6);
        db.insert("coursefee",null,contentValues);
    }


    public void insertcoursefee(String course_name,String term1,String fee_head1,String amount1,String term2,String fee_head2,String amount2,String term3,String fee_head3,String amount3,String term4,String fee_head4,String amount4,String term5,String fee_head5,String amount5,String term6,String fee_head6,String amount6,String term7,String fee_head7,String amount7){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("term1",term1);
        contentValues.put("fee_head1",fee_head1);
        contentValues.put("amount1",amount1);
        contentValues.put("term2",term2);
        contentValues.put("fee_head2",fee_head2);
        contentValues.put("amount2",amount2);
        contentValues.put("term3",term3);
        contentValues.put("fee_head3",fee_head3);
        contentValues.put("amount3",amount3);
        contentValues.put("term4",term4);
        contentValues.put("fee_head4",fee_head4);
        contentValues.put("amount4",amount4);
        contentValues.put("term5",term5);
        contentValues.put("fee_head5",fee_head5);
        contentValues.put("amount5",amount5);

        contentValues.put("term6",term6);
        contentValues.put("fee_head6",fee_head6);
        contentValues.put("amount6",amount6);

        contentValues.put("term7",term7);
        contentValues.put("fee_head7",fee_head7);
        contentValues.put("amount7",amount7);



        db.insert("coursefee",null,contentValues);
    }


    public void insertcoursefee(String course_name,String term1,String fee_head1,String amount1,String term2,String fee_head2,String amount2,String term3,String fee_head3,String amount3,String term4,String fee_head4,String amount4,String term5,String fee_head5,String amount5,String term6,String fee_head6,String amount6,String term7,String fee_head7,String amount7,String term8,String fee_head8,String amount8){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("term1",term1);
        contentValues.put("fee_head1",fee_head1);
        contentValues.put("amount1",amount1);
        contentValues.put("term2",term2);
        contentValues.put("fee_head2",fee_head2);
        contentValues.put("amount2",amount2);
        contentValues.put("term3",term3);
        contentValues.put("fee_head3",fee_head3);
        contentValues.put("amount3",amount3);
        contentValues.put("term4",term4);
        contentValues.put("fee_head4",fee_head4);
        contentValues.put("amount4",amount4);
        contentValues.put("term5",term5);
        contentValues.put("fee_head5",fee_head5);
        contentValues.put("amount5",amount5);

        contentValues.put("term6",term6);
        contentValues.put("fee_head6",fee_head6);
        contentValues.put("amount6",amount6);

        contentValues.put("term7",term7);
        contentValues.put("fee_head7",fee_head7);
        contentValues.put("amount7",amount7);

        contentValues.put("term8",term8);
        contentValues.put("fee_head8",fee_head8);
        contentValues.put("amount8",amount8);




        db.insert("coursefee",null,contentValues);
    }



    public void insertcoursefee(String course_name,String term1,String fee_head1,String amount1,String term2,String fee_head2,String amount2,String term3,String fee_head3,String amount3,String term4,String fee_head4,String amount4,String term5,String fee_head5,String amount5,String term6,String fee_head6,String amount6,String term7,String fee_head7,String amount7,String term8,String fee_head8,String amount8,String term9,String fee_head9,String amount9){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("term1",term1);
        contentValues.put("fee_head1",fee_head1);
        contentValues.put("amount1",amount1);
        contentValues.put("term2",term2);
        contentValues.put("fee_head2",fee_head2);
        contentValues.put("amount2",amount2);
        contentValues.put("term3",term3);
        contentValues.put("fee_head3",fee_head3);
        contentValues.put("amount3",amount3);
        contentValues.put("term4",term4);
        contentValues.put("fee_head4",fee_head4);
        contentValues.put("amount4",amount4);
        contentValues.put("term5",term5);
        contentValues.put("fee_head5",fee_head5);
        contentValues.put("amount5",amount5);

        contentValues.put("term6",term6);
        contentValues.put("fee_head6",fee_head6);
        contentValues.put("amount6",amount6);

        contentValues.put("term7",term7);
        contentValues.put("fee_head7",fee_head7);
        contentValues.put("amount7",amount7);

        contentValues.put("term8",term8);
        contentValues.put("fee_head8",fee_head8);
        contentValues.put("amount8",amount8);

        contentValues.put("term9",term9);
        contentValues.put("fee_head9",fee_head9);
        contentValues.put("amount9",amount9);


        db.insert("coursefee",null,contentValues);
    }



    public void insertcoursefee(String course_name,String term1,String fee_head1,String amount1,String term2,String fee_head2,String amount2,String term3,String fee_head3,String amount3,String term4,String fee_head4,String amount4,String term5,String fee_head5,String amount5,String term6,String fee_head6,String amount6,String term7,String fee_head7,String amount7,String term8,String fee_head8,String amount8,String term9,String fee_head9,String amount9,String term10,String fee_head10,String amount10){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("term1",term1);
        contentValues.put("fee_head1",fee_head1);
        contentValues.put("amount1",amount1);
        contentValues.put("term2",term2);
        contentValues.put("fee_head2",fee_head2);
        contentValues.put("amount2",amount2);
        contentValues.put("term3",term3);
        contentValues.put("fee_head3",fee_head3);
        contentValues.put("amount3",amount3);
        contentValues.put("term4",term4);
        contentValues.put("fee_head4",fee_head4);
        contentValues.put("amount4",amount4);
        contentValues.put("term5",term5);
        contentValues.put("fee_head5",fee_head5);
        contentValues.put("amount5",amount5);

        contentValues.put("term6",term6);
        contentValues.put("fee_head6",fee_head6);
        contentValues.put("amount6",amount6);

        contentValues.put("term7",term7);
        contentValues.put("fee_head7",fee_head7);
        contentValues.put("amount7",amount7);

        contentValues.put("term8",term8);
        contentValues.put("fee_head8",fee_head8);
        contentValues.put("amount8",amount8);

        contentValues.put("term9",term9);
        contentValues.put("fee_head9",fee_head9);
        contentValues.put("amount9",amount9);

        contentValues.put("term10",term10);
        contentValues.put("fee_head10",fee_head10);
        contentValues.put("amount10",amount10);
        db.insert("coursefee",null,contentValues);
    }





    // INSERT ELIGIBILITY

    public void inserteligibility(String course_name){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);

        db.insert("eligibility",null,contentValues);

    }




    public void inserteligibility(String course_name,String exam_name1,String score1){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("exam_name1",exam_name1);
        contentValues.put("score1",score1);
        db.insert("eligibility",null,contentValues);

    }


    public void inserteligibility(String course_name,String exam_name1,String score1,String exam_name2,String score2){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("exam_name1",exam_name1);
        contentValues.put("score1",score1);
        contentValues.put("exam_name2",exam_name2);
        contentValues.put("score2",score2);



        db.insert("eligibility",null,contentValues);

    }



    public void inserteligibility(String course_name,String exam_name1,String score1,String exam_name2,String score2,String exam_name3,String score3){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("exam_name1",exam_name1);
        contentValues.put("score1",score1);
        contentValues.put("exam_name2",exam_name2);
        contentValues.put("score2",score2);

        contentValues.put("exam_name3",exam_name3);
        contentValues.put("score3",score3);


        db.insert("eligibility",null,contentValues);

    }



    public void inserteligibility(String course_name,String exam_name1,String score1,String exam_name2,String score2,String exam_name3,String score3,String exam_name4,String score4){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("exam_name1",exam_name1);
        contentValues.put("score1",score1);
        contentValues.put("exam_name2",exam_name2);
        contentValues.put("score2",score2);

        contentValues.put("exam_name3",exam_name3);
        contentValues.put("score3",score3);

        contentValues.put("exam_name4",exam_name4);
        contentValues.put("score4",score4);

        db.insert("eligibility",null,contentValues);

    }


    public void inserteligibility(String course_name,String exam_name1,String score1,String exam_name2,String score2,String exam_name3,String score3,String exam_name4,String score4,String exam_name5,String score5){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("exam_name1",exam_name1);
        contentValues.put("score1",score1);
        contentValues.put("exam_name2",exam_name2);
        contentValues.put("score2",score2);

        contentValues.put("exam_name3",exam_name3);
        contentValues.put("score3",score3);

        contentValues.put("exam_name4",exam_name4);
        contentValues.put("score4",score4);

        contentValues.put("exam_name5",exam_name5);
        contentValues.put("score5",score5);


        db.insert("eligibility",null,contentValues);

    }




    public void inserteligibility(String course_name,String exam_name1,String score1,String exam_name2,String score2,String exam_name3,String score3,String exam_name4,String score4,String exam_name5,String score5,String exam_name6,String score6){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("exam_name1",exam_name1);
        contentValues.put("score1",score1);
        contentValues.put("exam_name2",exam_name2);
        contentValues.put("score2",score2);

        contentValues.put("exam_name3",exam_name3);
        contentValues.put("score3",score3);

        contentValues.put("exam_name4",exam_name4);
        contentValues.put("score4",score4);

        contentValues.put("exam_name5",exam_name5);
        contentValues.put("score5",score5);

        contentValues.put("exam_name6",exam_name6);
        contentValues.put("score6",score6);
        db.insert("eligibility",null,contentValues);

    }

    //ENTERANCE

    public void insertenterance(String course_name,String exam_name1,String exam_name2,String exam_name3,String exam_name4,String exam_name5,String exam_name6){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("exam_name1",exam_name1);
        contentValues.put("exam_name2",exam_name2);
        contentValues.put("exam_name3",exam_name3);
        contentValues.put("exam_name4",exam_name4);
        contentValues.put("exam_name5",exam_name5);
        contentValues.put("exam_name6",exam_name6);
        sqLiteDatabase.insert("enterance",null,contentValues);
    }

    public void insertenterance(String course_name,String exam_name1,String exam_name2,String exam_name3,String exam_name4,String exam_name5){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("exam_name1",exam_name1);
        contentValues.put("exam_name2",exam_name2);
        contentValues.put("exam_name3",exam_name3);
        contentValues.put("exam_name4",exam_name4);
        contentValues.put("exam_name5",exam_name5);

        sqLiteDatabase.insert("enterance",null,contentValues);
    }

    public void insertenterance(String course_name,String exam_name1,String exam_name2,String exam_name3,String exam_name4){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("exam_name1",exam_name1);
        contentValues.put("exam_name2",exam_name2);
        contentValues.put("exam_name3",exam_name3);
        contentValues.put("exam_name4",exam_name4);

        sqLiteDatabase.insert("enterance",null,contentValues);
    }

    public void insertenterance(String course_name,String exam_name1,String exam_name2,String exam_name3){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("exam_name1",exam_name1);
        contentValues.put("exam_name2",exam_name2);
        contentValues.put("exam_name3",exam_name3);

        sqLiteDatabase.insert("enterance",null,contentValues);
    }

    public void insertenterance(String course_name,String exam_name1,String exam_name2){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("exam_name1",exam_name1);
        contentValues.put("exam_name2",exam_name2);
        sqLiteDatabase.insert("enterance",null,contentValues);
    }

    public void insertenterance(String course_name,String exam_name1){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("exam_name1",exam_name1);
        sqLiteDatabase.insert("enterance",null,contentValues);
    }

    public void insertenterance(String course_name){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        sqLiteDatabase.insert("enterance",null,contentValues);
    }











    ////////////////////////INSERT COURSE DETAILS/////////////////

    public void insertcourse_details(String university_name,String course_name,String course,String year,String time,String total_fee,
                                     String syllabus){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("university_name",university_name);
        contentValues.put("course_name",course_name);
        contentValues.put("course",course);
        contentValues.put("year",year);
        contentValues.put("time",time);
        contentValues.put("total_fee",total_fee);
        contentValues.put("syllabus",syllabus);
        db.insert("course_details",null,contentValues);
        db.close();






    }



    //UNIVERSITY IN COURSE

    public void universityincourse(String course_name,String university_name1,String university_name2,String university_name3,String university_name4,String university_name5,String university_name6){

        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("university_name1",university_name1);
        contentValues.put("university_name2",university_name2);
        contentValues.put("university_name3",university_name3);
        contentValues.put("university_name4",university_name4);
        contentValues.put("university_name5",university_name5);
        contentValues.put("university_name6",university_name6);
        sqLiteDatabase.insert("university_in_course",null,contentValues);

    }

    public void universityincourse(String course_name,String university_name1,String university_name2,String university_name3,String university_name4,String university_name5){

        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("university_name1",university_name1);
        contentValues.put("university_name2",university_name2);
        contentValues.put("university_name3",university_name3);
        contentValues.put("university_name4",university_name4);
        contentValues.put("university_name5",university_name5);

        sqLiteDatabase.insert("university_in_course",null,contentValues);

    }

    public void universityincourse(String course_name,String university_name1,String university_name2,String university_name3,String university_name4){

        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("university_name1",university_name1);
        contentValues.put("university_name2",university_name2);
        contentValues.put("university_name3",university_name3);
        contentValues.put("university_name4",university_name4);
        sqLiteDatabase.insert("university_in_course",null,contentValues);

    }

    public void universityincourse(String course_name,String university_name1,String university_name2,String university_name3){

        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("university_name1",university_name1);
        contentValues.put("university_name2",university_name2);
        contentValues.put("university_name3",university_name3);

        sqLiteDatabase.insert("university_in_course",null,contentValues);

    }

    public void universityincourse(String course_name,String university_name1,String university_name2){

        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("university_name1",university_name1);
        contentValues.put("university_name2",university_name2);


        sqLiteDatabase.insert("university_in_course",null,contentValues);

    }

    public void universityincourse(String course_name,String university_name1){

        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("course_name",course_name);
        contentValues.put("university_name1",university_name1);


        sqLiteDatabase.insert("university_in_course",null,contentValues);

    }










    ///Course get fee

    public ArrayList<UCourse_fee>getcourse_fee(){
        ArrayList<UCourse_fee>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from coursefee ", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UCourse_fee(res.getString(2), res.getString(3), res.getString(4), res.getString(5),
                    res.getString(6),res.getString(7), res.getString(8), res.getString(9),res.getString(10)
                    , res.getString(11), res.getString(12), res.getString(13), res.getString(14), res.getString(15),
                    res.getString(16), res.getString(17), res.getString(18), res.getString(19), res.getString(20),
                    res.getString(21), res.getString(22), res.getString(23), res.getString(22), res.getString(23), res.getString(24),
                    res.getString(25), res.getString(26), res.getString(27), res.getString(28), res.getString(29)));
            res.moveToNext();
        }
        return arrayList;

    }






    public ArrayList<UCourse_fee>getcourse_fee_single(String course_name){
        ArrayList<UCourse_fee>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from coursefee where course_name=?", new String[]{course_name} );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UCourse_fee(res.getString(2), res.getString(3), res.getString(4), res.getString(5),
                    res.getString(6),res.getString(7), res.getString(8), res.getString(9),res.getString(10)
                    , res.getString(11), res.getString(12), res.getString(13), res.getString(14), res.getString(15),
                    res.getString(16), res.getString(17), res.getString(18), res.getString(19), res.getString(20),
                    res.getString(21), res.getString(22), res.getString(23), res.getString(22), res.getString(23), res.getString(24),
                    res.getString(25), res.getString(26), res.getString(27), res.getString(28), res.getString(29)));
            res.moveToNext();
        }
        return arrayList;

    }



    public ArrayList<UCourse_fee>getcourse_fee_single_bookmark(String course_name){
        ArrayList<UCourse_fee>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from coursefee_bookmark where course_name=?", new String[]{course_name} );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UCourse_fee(res.getString(2), res.getString(3), res.getString(4), res.getString(5),
                    res.getString(6),res.getString(7), res.getString(8), res.getString(9),res.getString(10)
                    , res.getString(11), res.getString(12), res.getString(13), res.getString(14), res.getString(15),
                    res.getString(16), res.getString(17), res.getString(18), res.getString(19), res.getString(20),
                    res.getString(21), res.getString(22), res.getString(23), res.getString(22), res.getString(23), res.getString(24),
                    res.getString(25), res.getString(26), res.getString(27), res.getString(28), res.getString(29)));
            res.moveToNext();
        }
        return arrayList;

    }




    public ArrayList<UCourse_fee>getcourse_fee_single_bookmark1(String course_name){
        ArrayList<UCourse_fee>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from coursefee_bookmark1 where course_name=?", new String[]{course_name} );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UCourse_fee(res.getString(2), res.getString(3), res.getString(4), res.getString(5),
                    res.getString(6),res.getString(7), res.getString(8), res.getString(9),res.getString(10)
                    , res.getString(11), res.getString(12), res.getString(13), res.getString(14), res.getString(15),
                    res.getString(16), res.getString(17), res.getString(18), res.getString(19), res.getString(20),
                    res.getString(21), res.getString(22), res.getString(23), res.getString(22), res.getString(23), res.getString(24),
                    res.getString(25), res.getString(26), res.getString(27), res.getString(28), res.getString(29)));
            res.moveToNext();
        }
        return arrayList;

    }




    /////


    ///// get course eligibility

    public ArrayList<UCourseeligibilty>geteligibility(){

        ArrayList<UCourseeligibilty>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from coursefee ", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UCourseeligibilty(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10),
                    res.getString(11), res.getString(12), res.getString(13) ));
            res.moveToNext();
        }
        return arrayList;



    }




    public ArrayList<UCourseeligibilty>geteligibility_single(String course_name){

        ArrayList<UCourseeligibilty>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from eligibility where course_name=? ", new String[]{course_name} );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UCourseeligibilty(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10),
                    res.getString(11), res.getString(12), res.getString(13) ));
            res.moveToNext();
        }
        return arrayList;



    }




    public ArrayList<UCourseeligibilty>geteligibility_single_bookmark(String course_name){

        ArrayList<UCourseeligibilty>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from eligibility_bookmark where course_name=? ", new String[]{course_name} );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UCourseeligibilty(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10),
                    res.getString(11), res.getString(12), res.getString(13) ));
            res.moveToNext();
        }
        return arrayList;



    }


    public ArrayList<UCourseeligibilty>geteligibility_single_bookmark1(String course_name){

        ArrayList<UCourseeligibilty>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from eligibility_bookmark1 where course_name=? ", new String[]{course_name} );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UCourseeligibilty(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10),
                    res.getString(11), res.getString(12), res.getString(13) ));
            res.moveToNext();
        }
        return arrayList;



    }





    ////




    ///

    /// get entrance








    public ArrayList<UCentrance>getentrance_single(String course_name){
        ArrayList<UCentrance>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from enterance where course_name=?", new String[]{course_name} );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UCentrance(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6),res.getString(7)));
            res.moveToNext();
        }
        return arrayList;


    }





    public ArrayList<UCentrance>getentrance_single_bookmark(String course_name){
        ArrayList<UCentrance>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from enterance_bookmark where course_name=?", new String[]{course_name} );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UCentrance(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6),res.getString(7)));
            res.moveToNext();
        }
        return arrayList;


    }




    public ArrayList<UCentrance>getentrance_single_bookmark1(String course_name){
        ArrayList<UCentrance>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from enterance_bookmark1 where course_name=?", new String[]{course_name} );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UCentrance(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6),res.getString(7)));
            res.moveToNext();
        }
        return arrayList;


    }





    ///

    ////course university

    public ArrayList<UUnivincourse>getuniv_in_course(){
        ArrayList<UUnivincourse>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from university_in_course ", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UUnivincourse(res.getString(2), res.getString(3), res.getString(4), res.getString(5),
                    res.getString(6), res.getString(7) ));
            res.moveToNext();
        }
        return arrayList;

    }



    public ArrayList<UUnivincourse>getuniv_in_course_course(){
        ArrayList<UUnivincourse>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from university_in_course_bookmark ", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new UUnivincourse(res.getString(2), res.getString(3), res.getString(4), res.getString(5),
                    res.getString(6), res.getString(7) ));
            res.moveToNext();
        }
        return arrayList;



    }






    ///


    //// get COURSE DETAILS

    public ArrayList<DataModelClassForCourse>getcourse_details_country(String  location){
        ArrayList<DataModelClassForCourse>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from course_details where location =?", new String[]{location} );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new DataModelClassForCourse(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7)));
            res.moveToNext();
        }
        return arrayList;}




    public ArrayList<DataModelClassForCourse>getcourse_details_country_bookmark(String  location){
        ArrayList<DataModelClassForCourse>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from course_details_bookmark where location =?", new String[]{location} );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new DataModelClassForCourse(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7)));
            res.moveToNext();
        }
        return arrayList;}


    public ArrayList<DataModelClassForCourse>getcourse_details_country_bookmark1(String  location){
        ArrayList<DataModelClassForCourse>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from course_details_bookmark1 where location =?", new String[]{location} );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new DataModelClassForCourse(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7)));
            res.moveToNext();
        }
        return arrayList;}





    public ArrayList<DataModelClassForCourse>getcourse_details_single_course_name(String  university_name){
        ArrayList<DataModelClassForCourse>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from course_details where course_name =?", new String[]{university_name} );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new DataModelClassForCourse(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7)));
            res.moveToNext();
        }
        return arrayList;}




    public ArrayList<DataModelClassForCourse>getcourse_details_single_course_name_bookmark(String  university_name){
        ArrayList<DataModelClassForCourse>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from course_details_bookmark where course_name =?", new String[]{university_name} );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new DataModelClassForCourse(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7)));
            res.moveToNext();
        }
        return arrayList;}





    public ArrayList<DataModelClassForCourse>getcourse_details_single_course_name_bookmark1(String  university_name){
        ArrayList<DataModelClassForCourse>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from course_details_bookmark1 where course_name =?", new String[]{university_name} );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new DataModelClassForCourse(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7)));
            res.moveToNext();
        }
        return arrayList;}






    public ArrayList<DataModelClassForCourse>getcourse_details_single(String  university_name){
        ArrayList<DataModelClassForCourse>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from course_details where university_name =?", new String[]{university_name} );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new DataModelClassForCourse(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7)));
            res.moveToNext();
        }
        return arrayList;



    }



    public ArrayList<DataModelClassForCourse>getcourse_details_single_bookmark(String  university_name){
        ArrayList<DataModelClassForCourse>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from course_details_bookmark where university_name =?", new String[]{university_name} );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new DataModelClassForCourse(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7)));
            res.moveToNext();
        }
        return arrayList;



    }


    public ArrayList<DataModelClassForCourse>getcourse_details_single_bookmark1(String  university_name){
        ArrayList<DataModelClassForCourse>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from course_details_bookmark1 where university_name =?", new String[]{university_name} );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new DataModelClassForCourse(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7)));
            res.moveToNext();
        }
        return arrayList;



    }














    public ArrayList<DataModelClassForCourse>getcourse_details(){
        ArrayList<DataModelClassForCourse>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from course_details ", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new DataModelClassForCourse(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7)));
            res.moveToNext();
        }
        return arrayList;



    }





    public ArrayList<StudentDetails>getStudent_details(){
        ArrayList<StudentDetails>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from studentData ", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new StudentDetails(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(4)));
            res.moveToNext();
        }
        return arrayList;



    }






    public ArrayList<DataModelClassForCourse>getcourse_details_bookmark(){
        ArrayList<DataModelClassForCourse>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from course_details_bookmark ", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new DataModelClassForCourse(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7)));
            res.moveToNext();
        }
        return arrayList;



    }


    public ArrayList<DataModelClassForCourse>getcourse_details_bookmark1(){
        ArrayList<DataModelClassForCourse>arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from course_details_bookmark1 ", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            arrayList.add(new DataModelClassForCourse(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                    res.getString(5), res.getString(6), res.getString(7)));
            res.moveToNext();
        }
        return arrayList;



    }






    public ArrayList<Un_Accomodation>get_unvAcc(String university_name){
        ArrayList<Un_Accomodation>arrayList=new ArrayList<>();
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from unv_accom where university_name=?",new String[]{university_name});
        res.moveToFirst();
        while (res.isAfterLast()==false){
            arrayList.add(new Un_Accomodation(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5)));
            res.moveToNext();
        }
        return arrayList;

    }




    public ArrayList<Un_Accomodation>get_unvAcc_bookmark(String university_name){
        ArrayList<Un_Accomodation>arrayList=new ArrayList<>();
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from unv_accom_bookmark where university_name=?",new String[]{university_name});
        res.moveToFirst();
        while (res.isAfterLast()==false){
            arrayList.add(new Un_Accomodation(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5)));
            res.moveToNext();
        }
        return arrayList;

    }
///////

    public ArrayList<Un_Accomodation>get_unvAcc_bookmark1(String university_name){
        ArrayList<Un_Accomodation>arrayList=new ArrayList<>();
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from unv_accom_bookmark1 where university_name=?",new String[]{university_name});
        res.moveToFirst();
        while (res.isAfterLast()==false){
            arrayList.add(new Un_Accomodation(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5)));
            res.moveToNext();
        }
        return arrayList;

    }





    ///GET COURSENAME
    public ArrayList<DataModelClassForCourse>getcoursename(String university_name) {
        ArrayList<DataModelClassForCourse> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from course_details where university_name=?", new String[]{university_name});
        res.moveToFirst();
        arrayList.add(new DataModelClassForCourse(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                res.getString(5), res.getString(6), res.getString(7)));
        res.moveToNext();

        return arrayList;

    }



    public ArrayList<DataModelClassForCourse>getcoursename_bookmark(String university_name) {
        ArrayList<DataModelClassForCourse> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from course_details_bookmark where university_name=?", new String[]{university_name});
        res.moveToFirst();
        arrayList.add(new DataModelClassForCourse(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                res.getString(5), res.getString(6), res.getString(7)));
        res.moveToNext();

        return arrayList;

    }


    public ArrayList<DataModelClassForCourse>getcoursename_bookmark1(String university_name) {
        ArrayList<DataModelClassForCourse> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from course_details_bookmark1 where university_name=?", new String[]{university_name});
        res.moveToFirst();
        arrayList.add(new DataModelClassForCourse(res.getString(1), res.getString(2), res.getString(3), res.getString(4),
                res.getString(5), res.getString(6), res.getString(7)));
        res.moveToNext();

        return arrayList;

    }















    public int count_UniversityDetails(String university_name){
        SQLiteDatabase db=getReadableDatabase();
        // String count_string=" SELECT * FROM " + login_hold;
        Cursor c=db.rawQuery(" select * from univ_details where university_name=?",new String[]{university_name});
        int count=c.getCount();
        return count;
    }



    public int count_UniversityDetails_bookmark(String university_name){
        SQLiteDatabase db=getReadableDatabase();
        // String count_string=" SELECT * FROM " + login_hold;
        Cursor c=db.rawQuery(" select * from univ_details_bookmark where university_name=?",new String[]{university_name});
        int count=c.getCount();
        return count;
    }


    public int count_UniversityDetails_bookmark1(String university_name){
        SQLiteDatabase db=getReadableDatabase();
        // String count_string=" SELECT * FROM " + login_hold;
        Cursor c=db.rawQuery(" select * from univ_details_bookmark1 where university_name=?",new String[]{university_name});
        int count=c.getCount();
        return count;
    }









    ///Login userInsert

    public void insert_username(String username){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        sqLiteDatabase.insert("login_count",null,contentValues);

    }

    ////Login Count
    public int count_login(){
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("select * from login_count",null);
        int count=c.getCount();
        return count;

    }

    ///STUDENT DATABASE

    public void insert_StuReg(String name,String mobile,String dob,String mail,String password){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("mobile",mobile);
        contentValues.put("dob",dob);
        contentValues.put("mail",mail);
        contentValues.put("password",password);
        sqLiteDatabase.insert("studentData",null,contentValues);

    }


    ////GET ADMISSION COUNT
    public void insert_uploadcount(String yes){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("yes",yes);

        sqLiteDatabase.insert("countUpload",null,contentValues);

    }


    public void  delete_upload_count(){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.execSQL("delete from countUpload  ");
        sqLiteDatabase.close();


    }
    public String getcount_upload(){
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from countUpload",null);
        res.moveToFirst();

        String course_id = res.getString(1);

        return course_id;




    }





    public int count_upload(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from countUpload",null);
        int count=c.getCount();
        return count;

    }

    //DELETE SPECIFIC TABLE

    public void Logout() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from login_count");
        db.close();
    }

    public void deletetable(String course_name){
        SQLiteDatabase db = getReadableDatabase();



    }







    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.w("rrrrrrrrrr","enterd1111 db");
        String querry_for_all_course="create table course_details(id integer primary key,university_name text,course_name text," +
                "course text,year text,time text,total_fee int,syllabus text)";

        String querry="create table affiliation(id integer primary key autoincrement,university_name text ,aff1 text,aff2 text,aff3 text,aff4 text,aff5 text,aff6 text)";
        String querry1="create table ranking(id integer primary key autoincrement,university_name text ,Rname1 text,Ranking1 text,Rname2 text,Ranking2 text,Rname3 text," +
                "Ranking3 text,Rname4 text,Ranking4 text,Rname5 text,Ranking5 text,Rname6 text,Ranking6 text)";
        String querry2="create table facility(id integer primary key autoincrement,university_name text ,fac1 text,fac2 text,fac3 text,fac4 text,fac5 text,fac6 text)";
        String querry3="create table univ_details(id integer primary key autoincrement,university_name text ,rating text,estd text,status text,sector text,about text," +
                "banner text,logo text,location text,city text,country text,contact text,email text,website text)";





        /////////////////course_fee
        String querry_for_coursefee="create table coursefee(id integer primary key autoincrement,course_name text ,term1 text,fee_head1 text,amount1 text," +
                "term2 text,fee_head2 text,amount2 text,term3 text,fee_head3 text,amount3 text,term4 text,fee_head4 text,amount4 text," +
                "term5 text,fee_head5 text,amount5 text,term6 text,fee_head6 text,amount6 text," +
                "term7 text,fee_head7 text,amount7 text,term8 text,fee_head8 text,amount8 text,term9 text,fee_head9 text,amount9 text,term10 text,fee_head10 text,amount10 text)";

        String querry_for_eligiblity="create table eligibility(id integer primary key autoincrement,course_name text ,exam_name1 text,score1 text," +
                "exam_name2 text,score2 text,exam_name3 text,score3 text,exam_name4 text,score4 text,exam_name5 text,score5 text,exam_name6 text,score6 text)";



        ////////////ENTRANCE
        String querry_for_enterance="create table enterance(id integer primary key autoincrement,course_name text ,exam_name1 text,exam_name2 text,exam_name3 text,exam_name4 text,exam_name5 text,exam_name6 text)";


        ////////////////UNIVERSITY_IN COURSE
        String querry_for_university_in_course="create table university_in_course(id integer primary key autoincrement,course_name text ,university_name1 text,university_name2 text,university_name3 text3," +
                "university_name4 text,university_name5 text,university_name6 text )";





        String query_for_un_fee="create table university_fees(id integer primary key autoincrement,university_name text,coursename1 text,coursefee1 text,coursename2 text,coursefee2 text,coursename3 text,coursefee3 text,coursename4 text,coursefee4 text,coursename5 text,coursefee5 text,coursename6 text,coursefee6 text)";




        ///////////////ACCOMODATION

        String querry_for_unv_accomodation="create table unv_accom(id integer primary key autoincrement, university_name text," +
                "hst_name text,room_type text,duration text,fee text)";



        /////////////////////////  UNIVERSITY_FEED  ///////////////////////////////////////
        String query_for_unv_feed="create table unv_feed(id integer primary key autoincrement,university_name text,feed text,feed_image text,youtube text)";


        /////////////////////////// UNIVERSITY PROCEDURE //////////////////
        String query_for_un_procedure="create table unv_procedure(id integer primary key autoincrement,university_name text,apply text,visa text,service text,documents text)";


        ///STUDENT REGISTER DATABASE

        String query_for_login="create table login_count(id integer primary key autoincrement,username text)";


        String query_for_registerStudent="create table studentData(id integer primary key autoincrement,name text,mobile text,dob text,mail text,password text)";


//
//
//        public void insert_StuReg(String name,String mobile,String dob,String mail,String password){
//            SQLiteDatabase sqLiteDatabase=getWritableDatabase();
//            ContentValues contentValues=new ContentValues();
//            contentValues.put("name",name);
//            contentValues.put("mobile",mobile);
//            contentValues.put("dob",dob);
//            contentValues.put("mail",mail);
//            contentValues.put("password",password);
//            sqLiteDatabase.insert("studentData",null,contentValues);
//
//        }




        String query_for_uploadfile="create table countUpload(id integer primary key autoincrement,yes text)";






//NEW DATABASE

//        String querry_for_all_course_bookmark="create table course_details_bookmark(university_name text,course_name text," +
//                "course text,year text,time text,total_fee int,syllabus text)";
//
//
//
//        String querry_for_affliation_bookmark="create table affiliation_bookmark(university_name text ,aff1 text,aff2 text,aff3 text,aff4 text,aff5 text,aff6 text)";
//
//
//        String querry_for_Ranking_Bookmark="create table ranking_bookmark(university_name text ,Rname1 text,Ranking1 text,Rname2 text,Ranking2 text,Rname3 text," +
//                "Ranking3 text,Rname4 text,Ranking4 text,Rname5 text,Ranking5 text,Rname6 text,Ranking6 text)";
//
//
//        String querry_for_facility_bookmark="create table facility_bookmark(university_name text ,fac1 text,fac2 text,fac3 text,fac4 text,fac5 text,fac6 text)";
//
//
//
//
//        String querry_for_university_book="create table univ_details_bookmark(university_name text ,rating text,estd text,status text,sector text,about text," +
//                "banner text,logo text,location text,city text,country text,contact text,email text,website text)";
//
//
//
//
//
//        /////////////////course_fee
//        String querry_for_coursefee_bookmark="create table coursefee_bookmark(course_name text ,term1 text,fee_head1 text,amount1 text," +
//                "term2 text,fee_head2 text,amount2 text,term3 text,fee_head3 text,amount3 text,term4 text,fee_head4 text,amount4 text," +
//                "term5 text,fee_head5 text,amount5 text,term6 text,fee_head6 text,amount6 text," +
//                "term7 text,fee_head7 text,amount7 text,term8 text,fee_head8 text,amount8 text,term9 text,fee_head9 text,amount9 text,term10 text,fee_head10 text,amount10 text)";
//
//
//
//        String querry_for_eligiblity_bookmark="create table eligibility_bookmark(course_name text ,exam_name1 text,score1 text," +
//                "exam_name2 text,score2 text,exam_name3 text,score3 text,exam_name4 text,score4 text,exam_name5 text,score5 text,exam_name6 text,score6 text)";
//
//
//
//        ////////////ENTRANCE
//        String querry_for_enterance_bookmark="create table enterance_bookmark(course_name text ,exam_name1 text,exam_name2 text,exam_name3 text,exam_name4 text,exam_name5 text,exam_name6 text)";
//
//
//        ////////////////UNIVERSITY_IN COURSE
//        String querry_for_university_in_course_bookmark="create table university_in_course_bookmark(course_name text ,university_name1 text,university_name2 text,university_name3 text3," +
//                "university_name4 text,university_name5 text,university_name6 text )";
//
//
//
//
//
//        String query_for_un_fee_bookmark="create table university_fees_bookmark(university_name text,coursename1 text,coursefee1 text,coursename2 text,coursefee2 text,coursename3 text,coursefee3 text,coursename4 text,coursefee4 text,coursename5 text,coursefee5 text,coursename6 text,coursefee6 text)";
//
//
//
//
//        ///////////////ACCOMODATION
//
//        String querry_for_unv_accomodation_bookmark="create table unv_accom_bookmark(university_name text," +
//                "hst_name text,room_type text,duration text,fee text)";
//
//
//
//        /////////////////////////  UNIVERSITY_FEED  ///////////////////////////////////////
//        String query_for_unv_feed_bookmark="create table unv_feed_bookmark(university_name text,feed text,feed_image text,youtube text)";
//
//
//        /////////////////////////// UNIVERSITY PROCEDURE //////////////////
//        String query_for_un_procedure_bookmark="create table unv_procedure_bookmark(university_name text,apply text,visa text,service text,documents text)";



        String querry_for_all_course_bookmark="create table course_details_bookmark(id integer ,university_name text,course_name text," +
                "course text,year text,time text,total_fee int,syllabus text)";



        String querry_for_affliation_bookmark="create table affiliation_bookmark(id integer ,university_name text ,aff1 text,aff2 text,aff3 text,aff4 text,aff5 text,aff6 text)";


        String querry_for_Ranking_Bookmark="create table ranking_bookmark(id integer ,university_name text ,Rname1 text,Ranking1 text,Rname2 text,Ranking2 text,Rname3 text," +
                "Ranking3 text,Rname4 text,Ranking4 text,Rname5 text,Ranking5 text,Rname6 text,Ranking6 text)";


        String querry_for_facility_bookmark="create table facility_bookmark(id integer ,university_name text ,fac1 text,fac2 text,fac3 text,fac4 text,fac5 text,fac6 text)";




        String querry_for_university_book="create table univ_details_bookmark(id integer ,university_name text ,rating text,estd text,status text,sector text,about text," +
                "banner text,logo text,location text,city text,country text,contact text,email text,website text)";





        /////////////////course_fee
        String querry_for_coursefee_bookmark="create table coursefee_bookmark(id integer ,course_name text ,term1 text,fee_head1 text,amount1 text," +
                "term2 text,fee_head2 text,amount2 text,term3 text,fee_head3 text,amount3 text,term4 text,fee_head4 text,amount4 text," +
                "term5 text,fee_head5 text,amount5 text,term6 text,fee_head6 text,amount6 text," +
                "term7 text,fee_head7 text,amount7 text,term8 text,fee_head8 text,amount8 text,term9 text,fee_head9 text,amount9 text,term10 text,fee_head10 text,amount10 text)";



        String querry_for_eligiblity_bookmark="create table eligibility_bookmark(id integer ,course_name text ,exam_name1 text,score1 text," +
                "exam_name2 text,score2 text,exam_name3 text,score3 text,exam_name4 text,score4 text,exam_name5 text,score5 text,exam_name6 text,score6 text)";



        ////////////ENTRANCE
        String querry_for_enterance_bookmark="create table enterance_bookmark(id integer ,course_name text ,exam_name1 text,exam_name2 text,exam_name3 text,exam_name4 text,exam_name5 text,exam_name6 text)";


        ////////////////UNIVERSITY_IN COURSE
        String querry_for_university_in_course_bookmark="create table university_in_course_bookmark(id integer ,course_name text ,university_name1 text,university_name2 text,university_name3 text3," +
                "university_name4 text,university_name5 text,university_name6 text )";





        String query_for_un_fee_bookmark="create table university_fees_bookmark(id integer ,university_name text,coursename1 text,coursefee1 text,coursename2 text,coursefee2 text,coursename3 text,coursefee3 text,coursename4 text,coursefee4 text,coursename5 text,coursefee5 text,coursename6 text,coursefee6 text)";




        ///////////////ACCOMODATION

        String querry_for_unv_accomodation_bookmark="create table unv_accom_bookmark(id integer, university_name text," +
                "hst_name text,room_type text,duration text,fee text)";



        /////////////////////////  UNIVERSITY_FEED  ///////////////////////////////////////
        String query_for_unv_feed_bookmark="create table unv_feed_bookmark(id integer,university_name text,feed text,feed_image text,youtube text)";


        /////////////////////////// UNIVERSITY PROCEDURE //////////////////
        String query_for_un_procedure_bookmark="create table unv_procedure_bookmark(id integer,university_name text,apply text,visa text,service text,documents text)";



////NEW DATABSAE FOR FAV

        String querry_for_all_course_bookmark1="create table course_details_bookmark1(id integer ,university_name text,course_name text," +
                "course text,year text,time text,total_fee int,syllabus text)";



        String querry_for_affliation_bookmark1="create table affiliation_bookmark1(id integer ,university_name text ,aff1 text,aff2 text,aff3 text,aff4 text,aff5 text,aff6 text)";


        String querry_for_Ranking_Bookmark1="create table ranking_bookmark1(id integer ,university_name text ,Rname1 text,Ranking1 text,Rname2 text,Ranking2 text,Rname3 text," +
                "Ranking3 text,Rname4 text,Ranking4 text,Rname5 text,Ranking5 text,Rname6 text,Ranking6 text)";


        String querry_for_facility_bookmark1="create table facility_bookmark1(id integer ,university_name text ,fac1 text,fac2 text,fac3 text,fac4 text,fac5 text,fac6 text)";




        String querry_for_university_book1="create table univ_details_bookmark1(id integer ,university_name text ,rating text,estd text,status text,sector text,about text," +
                "banner text,logo text,location text,city text,country text,contact text,email text,website text)";





        /////////////////course_fee
        String querry_for_coursefee_bookmark1="create table coursefee_bookmark1(id integer ,course_name text ,term1 text,fee_head1 text,amount1 text," +
                "term2 text,fee_head2 text,amount2 text,term3 text,fee_head3 text,amount3 text,term4 text,fee_head4 text,amount4 text," +
                "term5 text,fee_head5 text,amount5 text,term6 text,fee_head6 text,amount6 text," +
                "term7 text,fee_head7 text,amount7 text,term8 text,fee_head8 text,amount8 text,term9 text,fee_head9 text,amount9 text,term10 text,fee_head10 text,amount10 text)";



        String querry_for_eligiblity_bookmark1="create table eligibility_bookmark1(id integer ,course_name text ,exam_name1 text,score1 text," +
                "exam_name2 text,score2 text,exam_name3 text,score3 text,exam_name4 text,score4 text,exam_name5 text,score5 text,exam_name6 text,score6 text)";



        ////////////ENTRANCE
        String querry_for_enterance_bookmark1="create table enterance_bookmark1(id integer ,course_name text ,exam_name1 text,exam_name2 text,exam_name3 text,exam_name4 text,exam_name5 text,exam_name6 text)";


        ////////////////UNIVERSITY_IN COURSE
        String querry_for_university_in_course_bookmark1="create table university_in_course_bookmark1(id integer ,course_name text ,university_name1 text,university_name2 text,university_name3 text3," +
                "university_name4 text,university_name5 text,university_name6 text )";





        String query_for_un_fee_bookmark1="create table university_fees_bookmark1(id integer ,university_name text,coursename1 text,coursefee1 text,coursename2 text,coursefee2 text,coursename3 text,coursefee3 text,coursename4 text,coursefee4 text,coursename5 text,coursefee5 text,coursename6 text,coursefee6 text)";




        ///////////////ACCOMODATION

        String querry_for_unv_accomodation_bookmark1="create table unv_accom_bookmark1(id integer, university_name text," +
                "hst_name text,room_type text,duration text,fee text)";



        /////////////////////////  UNIVERSITY_FEED  ///////////////////////////////////////
        String query_for_unv_feed_bookmark1="create table unv_feed_bookmark1(id integer,university_name text,feed text,feed_image text,youtube text)";


        /////////////////////////// UNIVERSITY PROCEDURE //////////////////
        String query_for_un_procedure_bookmark1="create table unv_procedure_bookmark1(id integer,university_name text,apply text,visa text,service text,documents text)";










        db.execSQL(query_for_uploadfile);
        db.execSQL(query_for_registerStudent);
        db.execSQL(query_for_login);
        db.execSQL(querry_for_coursefee);
        db.execSQL(querry_for_eligiblity);
        db.execSQL(querry_for_enterance);
        db.execSQL(querry_for_university_in_course);
        db.execSQL(querry_for_all_course);
        db.execSQL(query_for_un_fee);
        db.execSQL(querry_for_unv_accomodation);
        db.execSQL(query_for_unv_feed);
        db.execSQL(query_for_un_procedure);



        db.execSQL(querry);
        db.execSQL(querry1);
        db.execSQL(querry2);
        db.execSQL(querry3);




        db.execSQL(querry_for_eligiblity_bookmark);
        db.execSQL(querry_for_enterance_bookmark);
        db.execSQL(querry_for_university_in_course_bookmark);
        db.execSQL(querry_for_all_course_bookmark);
        db.execSQL(query_for_un_fee_bookmark);
        db.execSQL(querry_for_unv_accomodation_bookmark);
        db.execSQL(query_for_unv_feed_bookmark);
        db.execSQL(query_for_un_procedure_bookmark);



        db.execSQL(querry_for_coursefee_bookmark);
        db.execSQL(querry_for_university_book);
        db.execSQL(querry_for_facility_bookmark);
        db.execSQL(querry_for_Ranking_Bookmark);
        db.execSQL(querry_for_affliation_bookmark);




        /////////////
       db.execSQL(querry_for_eligiblity_bookmark1);
        db.execSQL(querry_for_enterance_bookmark1);
        db.execSQL(querry_for_university_in_course_bookmark1);
        db.execSQL(querry_for_all_course_bookmark1);
        db.execSQL(query_for_un_fee_bookmark1);
        db.execSQL(querry_for_unv_accomodation_bookmark1);
        db.execSQL(query_for_unv_feed_bookmark1);
        db.execSQL(query_for_un_procedure_bookmark1);



        db.execSQL(querry_for_coursefee_bookmark1);
        db.execSQL(querry_for_university_book1);
        db.execSQL(querry_for_facility_bookmark1);
        db.execSQL(querry_for_Ranking_Bookmark1);
        db.execSQL(querry_for_affliation_bookmark1);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS affiliation");
        db.execSQL("DROP TABLE IF EXISTS ranking");
        db.execSQL("DROP TABLE IF EXISTS facility");
        db.execSQL("DROP TABLE IF EXISTS univ_details");
        db.execSQL("DROP TABLE IF EXISTS university_fees");
        db.execSQL("DROP TABLE IF EXISTS unv_accom");
        db.execSQL("DROP TABLE IF EXISTS unv_feed");
        db.execSQL("DROP TABLE IF EXISTS unv_procedure");

        db.execSQL("DROP TABLE IF EXISTS course_details");
        db.execSQL("DROP TABLE IF EXISTS coursefee");
        db.execSQL("DROP TABLE IF EXISTS eligibility");
        db.execSQL("DROP TABLE IF EXISTS enterance");
        db.execSQL("DROP TABLE IF EXISTS university_in_course");
        db.execSQL("DROP TABLE IF EXISTS studentData");
        db.execSQL("DROP TABLE IF EXISTS login_count");
        db.execSQL("DROP TABLE IF EXISTS countUpload");




        db.execSQL("DROP TABLE IF EXISTS affiliation_bookmark");
        db.execSQL("DROP TABLE IF EXISTS ranking_bookmark");
        db.execSQL("DROP TABLE IF EXISTS facility_bookmark");
        db.execSQL("DROP TABLE IF EXISTS univ_details_bookmark");
        db.execSQL("DROP TABLE IF EXISTS university_fees_bookmark");
        db.execSQL("DROP TABLE IF EXISTS unv_accom_bookmark");
        db.execSQL("DROP TABLE IF EXISTS unv_feed_bookmark");
        db.execSQL("DROP TABLE IF EXISTS unv_procedure_bookmark");

        db.execSQL("DROP TABLE IF EXISTS course_details_bookmark");
        db.execSQL("DROP TABLE IF EXISTS coursefee_bookmark");
        db.execSQL("DROP TABLE IF EXISTS eligibility_bookmark");
        db.execSQL("DROP TABLE IF EXISTS enterance_bookmark");
        db.execSQL("DROP TABLE IF EXISTS university_in_course_bookmark");


        //////




        db.execSQL("DROP TABLE IF EXISTS affiliation_bookmark1");
        db.execSQL("DROP TABLE IF EXISTS ranking_bookmark1");
        db.execSQL("DROP TABLE IF EXISTS facility_bookmark1");
        db.execSQL("DROP TABLE IF EXISTS univ_details_bookmark1");
        db.execSQL("DROP TABLE IF EXISTS university_fees_bookmark1");
        db.execSQL("DROP TABLE IF EXISTS unv_accom_bookmark1");
        db.execSQL("DROP TABLE IF EXISTS unv_feed_bookmark1");
        db.execSQL("DROP TABLE IF EXISTS unv_procedure_bookmark1");

        db.execSQL("DROP TABLE IF EXISTS course_details_bookmark1");
        db.execSQL("DROP TABLE IF EXISTS coursefee_bookmark1");
        db.execSQL("DROP TABLE IF EXISTS eligibility_bookmark1");
        db.execSQL("DROP TABLE IF EXISTS enterance_bookmark1");
        db.execSQL("DROP TABLE IF EXISTS university_in_course_bookmark1");


        onCreate(db);

    }



}