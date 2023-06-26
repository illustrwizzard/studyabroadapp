package com.axis.axistrial;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.CursorIndexOutOfBoundsException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.axistrial.R;

import java.util.ArrayList;

public class AdapterforinsideUnivCourse extends RecyclerView.Adapter<AdapterforinsideUnivCourse.myviewholder> {

    ArrayList<DataModelClassForCourse>arrayList;
   // RecyclerviewClickcourse listnerc;
    Context context;
    String from2;
    boolean checkbookmark;
    int countvalue;
    SQLDB sqldb;
    String delete;
    ArrayList<DataModelClassForCourse> arrayListcourse_name;
    ArrayList<String> currencysymbol1;
    String from4;

    public AdapterforinsideUnivCourse(Context context, ArrayList<DataModelClassForCourse> arrayList, String from2,boolean checkbookmark,int countvalue,ArrayList<String> currencysymbol1,String from4) {
       this.from2=from2;
        this.arrayList=arrayList;
        this.context=context;

        this.checkbookmark=checkbookmark;
        this.countvalue=countvalue;
        this.currencysymbol1=currencysymbol1;
        this.from4=from4;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       sqldb=new SQLDB(context);
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_inisde_univ_course,parent,false);
        return new myviewholder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, @SuppressLint("RecyclerView") int position) {
        holder.TXT1.setText(currencysymbol1.get(position)+" "+arrayList.get(position).getTotal_fee());

        holder.rr.setTag(arrayList.get(position).getCourse_name());
        holder.TXT.setText(arrayList.get(position).getCourse_name());
        holder.TXT.setTag(arrayList.get(position).getCourse_name());
        holder.TXT1.setTag(arrayList.get(position).getCourse_name());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("checkbooook", String.valueOf(checkbookmark));
                Log.w("checkbooook cont", String.valueOf(countvalue));
                Log.w("checkbooook cont name",arrayList.get(position).getUniversity_name() );
                countvalue= sqldb.count_UniversityDetails_bookmark(arrayList.get(position).getUniversity_name());
//                if((checkbookmark==false)&&(countvalue>0)){
//                    Log.w("insiddeee condition","yppppppppppppp");
//                    delete="yes";
//                   // delete_unique_bookmark(arrayList.get(position).getUniversity_name());
//
//
//                }

//                if(from4.equals("book_deleted")){
//                    Intent i = new Intent(context,InsideCourseSection.class);
//                    Log.w("....Enterd here.....","hereee32323232");
//                    i.putExtra("book_deleted","from4");
//                    i.putExtra("course_name_2",arrayList.get(position).getCourse_name());
//                    i.putExtra("currencysymbol1",currencysymbol1.get(position));
//                    v.getContext().startActivity(i);
//                }
//                book_mark_deleted
                if(from2.equals("book_mark_deleted")){

                    Intent i = new Intent(context,InsideCourseSection.class);
                    Log.w("....Enterd here.....","hereee11111111");
                    i.putExtra("book_mark_deleted","");
                    i.putExtra("book_mark",from2);
                    i.putExtra("course_name_2",arrayList.get(position).getCourse_name());
                    i.putExtra("currencysymbol1",currencysymbol1.get(position));
                    v.getContext().startActivity(i);



                }
                else
                if(from2.equals("book_mark")){

                    Intent i = new Intent(context,InsideCourseSection.class);
                    Log.w("....Enterd here.....","hereee11111111");
                    i.putExtra("book_mark",from2);
                    i.putExtra("course_name_2",arrayList.get(position).getCourse_name());
                    i.putExtra("currencysymbol1",currencysymbol1.get(position));
                    v.getContext().startActivity(i);



                }



                else{
                    Intent i = new Intent(context,InsideCourseSection.class);
                    i.putExtra("course",from2);
                    i.putExtra("from_unv_course","yppp");
                    i.putExtra("course_name",arrayList.get(position).getCourse_name());
                    i.putExtra("currencysymbol1",currencysymbol1.get(position));
                    v.getContext().startActivity(i);

                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder{
        TextView TXT,TXT1;
        LinearLayout rr;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            TXT=itemView.findViewById(R.id.textViewUnivCourse);
            TXT1=itemView.findViewById(R.id.cost_in_university_coursetab);
            rr=itemView.findViewById(R.id.relativecourse);
        }

//        @Override
//        public void onClick(View v) {
//            listnerc.onClick(v,getAdapterPosition());
//
//        }

    }
//    public interface RecyclerviewClickcourse{
//        void onClick(View v,int position);
//    }
}
