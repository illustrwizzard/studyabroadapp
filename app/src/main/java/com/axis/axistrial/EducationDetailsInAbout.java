package com.axis.axistrial;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.axistrial.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EducationDetailsInAbout extends AppCompatActivity {

    ImageView arrowback_in_educationDetails;

    LinearLayout layoutedu;
    ListView listView;
    EditText text1,text2,text3,text4,text5,text6;

    Spinner sp,sp1,sp2,sp3,sp4,sp5,sp6,sp7,sp8;
    String intake_year="",intake_year1="",intake_year2="",intake_year3="",intake_year4="",
            intake_year5="",intake_year6="",intake_year7="",intake_year8="";

    ArrayList<User_details_Secondary_edu>Seconedulist;
    ArrayList<User_details_Higher_Secondary_edu>HighSeconedulist;
    ArrayList<User_details_Higher_edu>Higheredulist;





    RecyclerView rec;
    Button btn,submit_in_educationdetails;
    EditText edt;
    ArrayList<String> arrayList,arrayList1,arrayList2,arrayList3,arrayList4,arrayList5;
    LinearLayoutManager linearLayoutManager;
    Adapterfortest adapterfortest;
    String url="https://axisoverseascareers.in/api/student/student_prof";






    public void upload_education_details(){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        StringRequest request =new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("secondary_board",Seconedulist.get(0).getSecondary_board());
                map.put("secondary_start_year",Seconedulist.get(0).getSecondary_start_year());
                map.put("secondary_end_year",Seconedulist.get(0).getSecondary_end_year());
                map.put("secondary_board_grade",Seconedulist.get(0).getSecondary_grade());
                map.put("higher_secondary_board",HighSeconedulist.get(0).getHigher_Secondary_board());
                map.put("higher_secondary_start_year",HighSeconedulist.get(0).getHigher_secondary_start_year());
                map.put("higher_secondary_end_year",HighSeconedulist.get(0).getHigher_secondary_end_year());
                map.put("higher_secondary_board_grade",HighSeconedulist.get(0).getHigher_secondary_grade());
                map.put("size_of_higher_education", String.valueOf(Higheredulist.size()));
                for (int i=0;i<Higheredulist.size();i++){

                    map.put("higher_edu_course_type"+i+"", Higheredulist.get(i).Higher_education_course_type);
                    map.put("higher_edu_Institute"+i+"", Higheredulist.get(i).Higher_education_Institute);
                    map.put("higher_edu_Courses"+i+"", Higheredulist.get(i).Higher_education_Courses);
                    map.put("higher_edu_start_year"+i+"", Higheredulist.get(i).Higher_education_start_year);
                    map.put("higher_edu_end_year"+i+"", Higheredulist.get(i).Higher_education_end_year);
                    map.put("higher_edu_grade"+i+"", Higheredulist.get(i).Higher_education_grade);

                }


                return  map;

            }
        };
        queue.add(request);






    }


    





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_details_in_about);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        }


        arrowback_in_educationDetails=findViewById(R.id.arrowback_in_educationDetails);
        arrowback_in_educationDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        listView=findViewById(R.id.listitems_in_educationdetails);
        listView=findViewById(R.id.listitems_in_educationdetails);


        text1=findViewById(R.id.enterGrade_id);
        text2=findViewById(R.id.HighSecEnterGrade_id1);
        text3=findViewById(R.id.chose_institue_in_higereducation);
        text4=findViewById(R.id.chose_course_in_higereducation);
        text5=findViewById(R.id.HighSecEnterGrade_id);
        //text6=findViewById(R.id.HighSecEnterGrade_id);
        submit_in_educationdetails=findViewById(R.id.submit_in_educationdetails);

        sp =findViewById(R.id.selectBoard);
        sp1=findViewById(R.id.startingDateSpinner);
        sp2=findViewById(R.id.endingDateSpinner);



        sp3=findViewById(R.id.HighersecBoardSpinner);
        sp4=findViewById(R.id.HighsecstartingDateSpinner);
        sp5=findViewById(R.id.HighsecEndDateSpinner);


        sp6=findViewById(R.id.chose_coursetype_in_higereducation);
        sp7=findViewById(R.id.HighEdustartingDateSpinner);
        sp8=findViewById(R.id.HigheduendingDateSpinner);

        Seconedulist=new ArrayList<>();
        HighSeconedulist=new ArrayList<>();
        Higheredulist= new ArrayList<>();


        //Secondary education add in arrray



        submit_in_educationdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upload_education_details();
                Toast.makeText(getApplicationContext(), "Uploaded Sucessfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });




        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.ChooseBoard,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                intake_year= String.valueOf(adapterView.getItemAtPosition(i));
                Log.w("selected month",intake_year);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getApplicationContext(),R.array.Start_year,
                android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter1);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                intake_year1= String.valueOf(adapterView.getItemAtPosition(i));
                Log.w("selected month",intake_year1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getApplicationContext(),R.array.Start_year,
                android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adapter2);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                intake_year2= String.valueOf(adapterView.getItemAtPosition(i));
                Log.w("selected month",intake_year2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getApplicationContext(),R.array.ChooseBoard,
                android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp3.setAdapter(adapter3);
        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                intake_year3= String.valueOf(adapterView.getItemAtPosition(i));
                Log.w("selected month",intake_year3);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(getApplicationContext(),R.array.Start_year,
                android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp4.setAdapter(adapter4);
        sp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                intake_year4= String.valueOf(adapterView.getItemAtPosition(i));
                Log.w("selected month",intake_year4);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(getApplicationContext(),R.array.Start_year,
                android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp5.setAdapter(adapter5);
        sp5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                intake_year5= String.valueOf(adapterView.getItemAtPosition(i));
                Log.w("selected month",intake_year5);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(getApplicationContext(),R.array.Choose_course_type,
                android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp6.setAdapter(adapter6);
        sp6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                intake_year6= String.valueOf(adapterView.getItemAtPosition(i));
                Log.w("selected month",intake_year6);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(getApplicationContext(),R.array.Start_year,
                android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp7.setAdapter(adapter7);
        sp7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                intake_year7= String.valueOf(adapterView.getItemAtPosition(i));
                Log.w("selected month",intake_year7);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(getApplicationContext(),R.array.Start_year,
                android.R.layout.simple_spinner_item);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp8.setAdapter(adapter8);
        sp8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                intake_year8= String.valueOf(adapterView.getItemAtPosition(i));
                Log.w("selected month",intake_year8);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        Seconedulist.add(new User_details_Secondary_edu(intake_year,intake_year1,intake_year2,text1.getText().toString()));
        HighSeconedulist.add(new User_details_Higher_Secondary_edu(intake_year3,intake_year4,intake_year5,text2.getText().toString()));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);


        }
        arrayList=new ArrayList<>();
        arrayList1=new ArrayList<>();
        arrayList2=new ArrayList<>();
        arrayList3=new ArrayList<>();
        arrayList4=new ArrayList<>();
        arrayList5=new ArrayList<>();

        rec= findViewById(R.id.repeatEdu);
        linearLayoutManager=new LinearLayoutManager(this);
        rec.setLayoutManager(linearLayoutManager);
        adapterfortest = new Adapterfortest(this,arrayList,arrayList1,arrayList2,arrayList3,arrayList4,arrayList5);
        rec.setAdapter(adapterfortest);



    }

    public void add_higher_edu(View view) {
        arrayList.add(intake_year6);
        arrayList1.add(text3.getText().toString());
        arrayList2.add(text4.getText().toString());
        arrayList3.add(intake_year7);
        arrayList4.add(intake_year8);
        arrayList5.add(text5.getText().toString());
        adapterfortest.notifyDataSetChanged();

        Higheredulist.add(new User_details_Higher_edu(intake_year6,text3.getText().toString(),
                text4.getText().toString(),intake_year7,intake_year8,text5.getText().toString()));


       // text1.setText("");
        //text2.setText("");
        text3.setText("");
        text4.setText("");
        text5.setText("");
        //text6.setText("");





    }



}