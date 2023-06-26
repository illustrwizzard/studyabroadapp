package com.axis.axistrial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.axistrial.R;

import java.util.ArrayList;

public class Adapterfortest extends RecyclerView.Adapter<Adapterfortest.myviewholder>{
    Context context;
    ArrayList<String>arrayList;
    ArrayList<String> arrayList1;
    ArrayList<String> arrayList2;
    ArrayList<String> arrayList3;
    ArrayList<String> arrayList4;
    ArrayList<String> arrayList5;

    public Adapterfortest(Context context, ArrayList<String> arrayList, ArrayList<String> arrayList1, ArrayList<String> arrayList2, ArrayList<String> arrayList3, ArrayList<String> arrayList4, ArrayList<String> arrayList5) {
        this.context = context;
        this.arrayList = arrayList;
        this.arrayList1 = arrayList1;
        this.arrayList2 = arrayList2;
        this.arrayList3 = arrayList3;
        this.arrayList4 = arrayList4;
        this.arrayList5 = arrayList5;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.add_higher_education_details,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.txt1.setText(arrayList.get(position));
        holder.txt2.setText(arrayList1.get(position));
        holder.txt3.setText(arrayList2.get(position));
        holder.txt4.setText(arrayList3.get(position));
        holder.txt5.setText(arrayList4.get(position));
        holder.txt6.setText(arrayList5.get(position));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView txt1,txt2,txt3,txt4,txt5,txt6;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            txt1=itemView.findViewById(R.id.chose_coursetype_in_higereducation);
            txt2=itemView.findViewById(R.id.chose_institue_in_higereducation);
            txt3=itemView.findViewById(R.id.chose_course_in_higereducation);
            txt4=itemView.findViewById(R.id.HighEdustartingDateSpinner);
            txt5=itemView.findViewById(R.id.HigheduendingDateSpinner);
            txt6=itemView.findViewById(R.id.HighSecEnterGrade_id);
        }
    }
}
