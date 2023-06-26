package com.axis.axistrial;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.axistrial.R;

import java.util.ArrayList;

public class AdapterforAccomodationUniversity extends RecyclerView.Adapter<AdapterforAccomodationUniversity.MyviewHolder> {
    Context context;

    TextView txtG;


    ArrayList<Un_Accomodation> accomdationarray;
    public AdapterforAccomodationUniversity(Context insideUniversityAccommodationTab, ArrayList<Un_Accomodation> accomodationarray) {
        context=insideUniversityAccommodationTab;
        Log.w("indide adapter", String.valueOf(accomodationarray.size()));
        this.accomdationarray=accomodationarray;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.w("dddddddddddd","entered1");
      //  txtG=parent.findViewById(R.id.gridtext);


        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_for_accomodationn_tab,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {


            holder.textView1.setText("Room Type");
            holder.textView2.setText("Duration");
            holder.textView3.setText("Fee");
            holder.textView.setText(accomdationarray.get(position).getHst_name());

            holder.textView4.setText(accomdationarray.get(position).getRoom_type());
            holder.textView5.setText(accomdationarray.get(position).getDuration());
            holder.textView6.setText(accomdationarray.get(position).getFee());


//            holder.textView.setText(accomdationarray.get(position).getAccomo_room());
//
//
//
//
//                holder.textView4.setText(accomdationarray.get(position).getAccomo_type());
//                holder.textView5.setText(accomdationarray.get(position).getAccomo_duration());
//                holder.textView6.setText(accomdationarray.get(position).getAccomo_fee());
//

//                holder.textView7.setText(accomdationarray.get(1).getAccomo_type());
//                holder.textView8.setText(accomdationarray.get(1).getAccomo_duration());
//                holder.textView9.setText(accomdationarray.get(1).getAccomo_fee());
//
//                holder.textView10.setText(accomdationarray.get(2).getAccomo_type());
//                holder.textView11.setText(accomdationarray.get(2).getAccomo_duration());
//                holder.textView12.setText(accomdationarray.get(2).getAccomo_fee());
//
//                holder.textView13.setText(accomdationarray.get(3).getAccomo_type());
//                holder.textView14.setText(accomdationarray.get(3).getAccomo_duration());
//                holder.textView15.setText(accomdationarray.get(3).getAccomo_fee());
//
//                holder.textView16.setText(accomdationarray.get(4).getAccomo_type());
//                holder.textView17.setText(accomdationarray.get(4).getAccomo_duration());
//                holder.textView18.setText(accomdationarray.get(4).getAccomo_fee());
//
//
//                holder.textView19.setText(accomdationarray.get(5).getAccomo_type());
//                holder.textView20.setText(accomdationarray.get(5).getAccomo_duration());
//                holder.textView21.setText(accomdationarray.get(5).getAccomo_fee());

//
//        if(accomdationarray.size()==6){
//            holder.textView4.setText("accomdationarray.get(0).getAccomo_type()");
//            holder.textView5.setText(accomdationarray.get(0).getAccomo_duration());
//            holder.textView6.setText(accomdationarray.get(0).getAccomo_fee());
//
//            holder.textView7.setText(accomdationarray.get(1).getAccomo_type());
//            holder.textView8.setText(accomdationarray.get(1).getAccomo_duration());
//            holder.textView9.setText(accomdationarray.get(1).getAccomo_fee());}

//            holder.textView4.setText(accomdationarray.get(position).getAccomo_room());
//            holder.textView5.setText(accomdationarray.get(position).getDuration1());
//            holder.textView6.setText(accomdationarray.get(position).getFee1());
//
//            holder.textView7.setText(accomdationarray.get(position).getRoom_type2());
//            holder.textView8.setText(accomdationarray.get(position).getDuration2());
//            holder.textView9.setText(accomdationarray.get(position).getFee2());
//
//            holder.textView10.setText(accomdationarray.get(position).getRoom_type3());
//            holder.textView11.setText(accomdationarray.get(position).getDuration3());
//            holder.textView12.setText(accomdationarray.get(position).getFee3());
//
//            holder.textView13.setText(accomdationarray.get(position).getRoom_type4());
//            holder.textView14.setText(accomdationarray.get(position).getDuration4());
//            holder.textView15.setText(accomdationarray.get(position).getFee4());
//
//            holder.textView16.setText(accomdationarray.get(position).getRoom_type5());
//            holder.textView17.setText(accomdationarray.get(position).getDuration5());
//            holder.textView18.setText(accomdationarray.get(position).getFee5());
//
//
//            holder.textView19.setText(accomdationarray.get(position).getRoom_type6());
//            holder.textView20.setText(accomdationarray.get(position).getDuration6());
//            holder.textView21.setText(accomdationarray.get(position).getFee6());


//            if (holder.textView4 ==null && holder.textView5 ==null && holder.textView6==null ){
//                holder.textView4.setVisibility(View.GONE);
//                holder.textView5.setVisibility(View.GONE);
//                holder.textView6.setVisibility(View.GONE);
//                holder.textView7.setVisibility(View.GONE);
//                holder.textView8.setVisibility(View.GONE);
//                holder.textView9.setVisibility(View.GONE);
//                holder.textView10.setVisibility(View.GONE);
//                holder.textView11.setVisibility(View.GONE);
//                holder.textView12.setVisibility(View.GONE);
//                holder.textView13.setVisibility(View.GONE);
//                holder.textView14.setVisibility(View.GONE);
//                holder.textView15.setVisibility(View.GONE);
//                holder.textView16.setVisibility(View.GONE);
//                holder.textView17.setVisibility(View.GONE);
//                holder.textView18.setVisibility(View.GONE);
//                holder.textView19.setVisibility(View.GONE);
//                holder.textView20.setVisibility(View.GONE);
//                holder.textView21.setVisibility(View.GONE);
//
//
//            }else if (holder.textView7 ==null && holder.textView8 ==null && holder.textView9==null ){
//            holder.textView7.setVisibility(View.GONE);
//
//            holder.textView8.setVisibility(View.GONE);
//            holder.textView9.setVisibility(View.GONE);
//            holder.textView10.setVisibility(View.GONE);
//            holder.textView11.setVisibility(View.GONE);
//            holder.textView12.setVisibility(View.GONE);
//            holder.textView13.setVisibility(View.GONE);
//            holder.textView14.setVisibility(View.GONE);
//            holder.textView15.setVisibility(View.GONE);
//            holder.textView16.setVisibility(View.GONE);
//            holder.textView17.setVisibility(View.GONE);
//            holder.textView18.setVisibility(View.GONE);
//            holder.textView19.setVisibility(View.GONE);
//            holder.textView20.setVisibility(View.GONE);
//            holder.textView21.setVisibility(View.GONE);
//
//
//        }else if (holder.textView10 ==null && holder.textView11 ==null && holder.textView12==null ){
//
//            holder.textView10.setVisibility(View.GONE);
//            holder.textView11.setVisibility(View.GONE);
//            holder.textView12.setVisibility(View.GONE);
//            holder.textView13.setVisibility(View.GONE);
//            holder.textView14.setVisibility(View.GONE);
//            holder.textView15.setVisibility(View.GONE);
//            holder.textView16.setVisibility(View.GONE);
//            holder.textView17.setVisibility(View.GONE);
//            holder.textView18.setVisibility(View.GONE);
//            holder.textView19.setVisibility(View.GONE);
//            holder.textView20.setVisibility(View.GONE);
//            holder.textView21.setVisibility(View.GONE);
//
//
//        }else if (holder.textView13 ==null && holder.textView14 ==null && holder.textView15==null ){
//
//            holder.textView13.setVisibility(View.GONE);
//            holder.textView14.setVisibility(View.GONE);
//            holder.textView15.setVisibility(View.GONE);
//            holder.textView16.setVisibility(View.GONE);
//            holder.textView17.setVisibility(View.GONE);
//            holder.textView18.setVisibility(View.GONE);
//            holder.textView19.setVisibility(View.GONE);
//            holder.textView20.setVisibility(View.GONE);
//            holder.textView21.setVisibility(View.GONE);
//
//
//        }else if (holder.textView16 ==null && holder.textView17==null && holder.textView18==null ){
//
//
//            holder.textView16.setVisibility(View.GONE);
//            holder.textView17.setVisibility(View.GONE);
//            holder.textView18.setVisibility(View.GONE);
//            holder.textView19.setVisibility(View.GONE);
//            holder.textView20.setVisibility(View.GONE);
//            holder.textView21.setVisibility(View.GONE);
//
//
//        }else   if (holder.textView19 ==null && holder.textView20==null && holder.textView21==null ){
//
//            holder.textView19.setVisibility(View.GONE);
//            holder.textView20.setVisibility(View.GONE);
//            holder.textView21.setVisibility(View.GONE);
//
//
//        }







//                holder.textView.setText(accomdationarray.get(position);
//
//            holder.textView4.setText(accomdationarray.get(position);
//            holder.textView5.setText(accomdationarray.get(position);
//            holder.textView6.setText(accomdationarray.get(position);


       // holder.textView2.setText(accomdationarray.get(position));
       // holder.textView3.setText(accomdationarray.get(position));




    }

    @Override
    public int getItemCount() {
        return accomdationarray.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        GridLayout gridLayout;
        TextView textView,textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView10,textView11,textView12,textView13,textView14,textView15,textView16,textView17,textView18,textView19,textView20,textView21;
        public MyviewHolder(@NonNull View itemView) {

            super(itemView);
            textView=itemView.findViewById(R.id.university_hostalname_in_universityaccomodation_page);


            textView1=itemView.findViewById(R.id.gridlay1);
            textView2=itemView.findViewById(R.id.gridlay2);
            textView3=itemView.findViewById(R.id.gridlay3);
            textView4=itemView.findViewById(R.id.gridlay4);
            textView5=itemView.findViewById(R.id.gridlay5);
            textView6=itemView.findViewById(R.id.gridlay6);

            gridLayout=itemView.findViewById(R.id.gridlayout_in_acc_university);



        }
    }
}
