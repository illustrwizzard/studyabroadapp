package com.axis.axistrial;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.axistrial.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class LocationFilter extends Fragment {
    ListView listView;
    ArrayAdapter<String> adapter2;
    String[] array1={"a","b","c","d","e","f","g","h","i","j","k","l","da","adda","addad"};
    ArrayList<UnvdataClass> arrayList;
    ArrayList<String>a;
    Set<String> set;
    ArrayList<String> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_location_filter, container, false);
        SQLDB sqldb=new SQLDB(getContext());
        arrayList=new ArrayList<>();
        arrayList=sqldb.getuniv_details();





        listView=v.findViewById(R.id.listview_filter2);
        a=new ArrayList<>();
        for (int i=0;i<arrayList.size();i++) {

          a.add(arrayList.get(i).getLocation());



            Log.w("sdddsdsddd", arrayList.get(i).getLocation());}

        set = new HashSet<>();
        list= new ArrayList<>();

        for(int i = 0;i<a.size();i++){

            set.add(a.get(i));

        }
        list.addAll(set);


            adapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_multiple_choice, list);

        listView.setAdapter(adapter2);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                String s= (String) parent.getItemAtPosition(position);


                Toast.makeText(getContext(),s, Toast.LENGTH_SHORT).show();
//                Intent i=new Intent();
//                i.putExtra()
            }
        });
        //setHasOptionsMenu(true);

        return v;
    }
}