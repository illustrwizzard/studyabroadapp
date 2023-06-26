package com.axis.axistrial;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.axistrial.R;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class WorkDetailsInAbout extends AppCompatActivity {
    EditText organisationName_id,JobRole_id,CityName_id;
    private DatePickerDialog datePickerDialog,datePickerDialog1;
 TextView EndWorking;
    String getStartworkingDate,getEndWorkingdate;
    CheckBox checkBox;
    LinearLayout Linearlay_gone;
    TextView Startworking;
    ImageView backbuttoninwork;
    Button saveWorkDetails,cancelWorkDetails;
    String urlWork="https://axisoverseascareers.in/api/student/student_work";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_details_in_about);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        saveWorkDetails=findViewById(R.id.saveWorkDetails);
        cancelWorkDetails=findViewById(R.id.cancelWorkDetails);
        backbuttoninwork=findViewById(R.id.backbuttoninwork);
        backbuttoninwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(WorkDetailsInAbout.this,BottomNavEx.class);
                startActivity(i);
            }
        });
        Linearlay_gone=findViewById(R.id.Linearlay_gone);

        checkBox=findViewById(R.id.checkBox);
        if (checkBox.isChecked()){
            Linearlay_gone.setVisibility(View.GONE);

        }else{
            Linearlay_gone.setVisibility(View.VISIBLE);

        }
        organisationName_id=findViewById(R.id.organisationName_id);
        JobRole_id=findViewById(R.id.JobRole_id);
        CityName_id=findViewById(R.id.CityName_id);
        EndWorking=findViewById(R.id.EndyearinWorkDetails);
        initDatePicker();
        initDatePicker1();
        Startworking=findViewById(R.id.startyearinWorkDetails);
        Startworking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();

            }
        });



        EndWorking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog1.show();
            }
        });




        saveWorkDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

                StringRequest request =new StringRequest(Request.Method.POST, urlWork, new Response.Listener<String>() {
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
                        map.put("organisation_name",organisationName_id.getText().toString());
                        map.put("Job_name",JobRole_id.getText().toString());
                        map.put("city_name",CityName_id.getText().toString());
                        map.put("start_date",getStartworkingDate);
                        map.put("end_date",getEndWorkingdate);

                        return  map;

                    }
                };
                queue.add(request);









                Toast.makeText(getApplicationContext(), "Data Uploaded SuccessFully", Toast.LENGTH_SHORT).show();
                Intent inm=new Intent(WorkDetailsInAbout.this,BottomNavEx.class);
                startActivity(inm);
            }
        });

        cancelWorkDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                organisationName_id.setText("");
                JobRole_id.setText("");
                CityName_id.setText("");
                Startworking.setText("");
                EndWorking.setText("");



                Intent inm=new Intent(WorkDetailsInAbout.this,BottomNavEx.class);
                startActivity(inm);
            }
        });




    }
    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month=month+1;
                String date=makeDateString(day,month,year);
                Startworking.setText(date);
                getStartworkingDate= String.valueOf(Startworking.getText());
            }
        };
        Calendar cal= Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        int style= AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog=new DatePickerDialog(this,style,dateSetListener,year,month,day);
    }
    private String makeDateString(int day, int month, int year) {
        return getMonthFormat(month) + "/" + day + "/" + year;
    }

    private String getMonthFormat(int month) {
        if (month == 1)
            return "JAN";
        if (month == 2)
            return "FEB";
        if (month == 3)
            return "MAR";
        if (month == 4)
            return "APR";
        if (month == 5)
            return "MAY";
        if (month == 6)
            return "JUN";
        if (month == 7)
            return "JUL";
        if (month == 8)
            return "AUG";
        if (month == 9)
            return "SEP";
        if (month == 10)
            return "OCT";
        if (month == 11)
            return "NOV";
        if (month == 12)
            return "DEC";

        return  "JAN";

    }



    private void initDatePicker1() {
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month=month+1;
                String date=makeDateString1(day,month,year);
                EndWorking.setText(date);
                getEndWorkingdate= String.valueOf(EndWorking.getText());
            }
        };
        Calendar cal= Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        int style= AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog1=new DatePickerDialog(this,style,dateSetListener,year,month,day);
    }
    private String makeDateString1(int day, int month, int year) {
        return getMonthFormat1(month) + "/" + day + "/" + year;
    }

    private String getMonthFormat1(int month) {
        if (month == 1)
            return "JAN";
        if (month == 2)
            return "FEB";
        if (month == 3)
            return "MAR";
        if (month == 4)
            return "APR";
        if (month == 5)
            return "MAY";
        if (month == 6)
            return "JUN";
        if (month == 7)
            return "JUL";
        if (month == 8)
            return "AUG";
        if (month == 9)
            return "SEP";
        if (month == 10)
            return "OCT";
        if (month == 11)
            return "NOV";
        if (month == 12)
            return "DEC";

        return  "JAN";

    }

}