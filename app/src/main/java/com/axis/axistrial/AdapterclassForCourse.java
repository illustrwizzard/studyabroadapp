package com.axis.axistrial;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.axistrial.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterclassForCourse extends RecyclerView.Adapter<AdapterclassForCourse.myviewholder> {

    Context context;
    ArrayList<DataModelClassForCourse> arrayListcourse;
    ArrayList<UnvdataClass>arrayListUnv;
    ArrayList<String>currencyval;





    public AdapterclassForCourse(FirstPageInsideCoursee mainActivity, ArrayList<DataModelClassForCourse> arrayListcourse,ArrayList<UnvdataClass>arrayListUnv,ArrayList<String>currencyval) {


        context=mainActivity;
        this.arrayListUnv=arrayListUnv;
        this.arrayListcourse=arrayListcourse;
        this.currencyval=currencyval;
    }


    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewfor_course,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, @SuppressLint("RecyclerView") int position) {

        holder.textView1.setText(arrayListcourse.get(position).getCourse_name());
        holder.textView2.setText(arrayListcourse.get(position).getUniversity_name());
       //holder.textView3.setText(arrayListcourse.get(position).ge());
        holder.textView4.setText(arrayListcourse.get(position).getTime());
        holder.textView5.setText(arrayListcourse.get(position).getCourse());
        holder.textView6.setText("Total fee"+"\n"+currencyval.get(position)+" "+arrayListcourse.get(position).getTotal_fee());
       Glide.with(context).load("https://media-exp1.licdn.com/dms/image/C4D0BAQH1WPAYy209hA/company-logo_200_200/0/1592584270579?e=2147483647&v=beta&t=3MLf7Yd59Ii37F1547dXM9SM25VPw0xOv7RA5AtfT44").into(holder.circleImageView);
        //Log.w(".....................",arrayListUnv.get(0).getLogo());



//        holder.textView2.setTag(arrayListcourse.get(position).getCourse_name());
//        holder.textView1.setTag(arrayListcourse.get(position).getCourse_name());
//        holder.textView3.setTag(arrayListcourse.get(position).getCourse_name());
//        holder.textView4.setTag(arrayListcourse.get(position).getCourse_name());
//        holder.textView5.setTag(arrayListcourse.get(position).getCourse_name());
//        holder.textView6.setTag(arrayListcourse.get(position).getCourse_name());
//        holder.circleImageView.setTag(arrayListcourse.get(position).getCourse_name());
//        holder.l1.setTag(arrayListcourse.get(position).getCourse_name());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,InsideCourseSection.class);
                i.putExtra("course_name",arrayListcourse.get(position).getCourse_name());
                i.putExtra("currencysymbol1",currencyval.get(position));
                i.putExtra("from_first_page","ypp");
                v.getContext().startActivity(i);
            }


        });




    }

    @Override
    public int getItemCount() {
        return arrayListcourse.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView textView1,textView2,textView3,textView4,textView5,textView6;
        CircleImageView circleImageView;
        LinearLayout l1;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.courseheading_id);
            textView2=itemView.findViewById(R.id.collegename_id);
            textView3=itemView.findViewById(R.id.location_in_course);
            textView4=itemView.findViewById(R.id.time_in_course);
            textView5=itemView.findViewById(R.id.course_in_course);
            textView6=itemView.findViewById(R.id.totalfee_in_course);
            circleImageView=itemView.findViewById(R.id.circleimage11_in_course);
            l1=itemView.findViewById(R.id.maincourselayout);


        }


}
}
