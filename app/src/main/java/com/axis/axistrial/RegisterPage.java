package com.axis.axistrial;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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

public class RegisterPage extends AppCompatActivity {
    Button registerbutton;
    String mobile_number;
    EditText Email,Upassword,Uname,mob,confirmpassword;
    String getname,getpassword,getDob,getEmail,getMobile;
    String url_register="https://axisoverseascareers.in/api/student/register";//done
    private DatePickerDialog datePickerDialog;
    private TextView dateButton;
    ImageView showpassword,showpassword1;
    ProgressBar progressBarRegister;

    SQLDB sqldb;



    @Override
    public void onBackPressed() {
        new androidx.appcompat.app.AlertDialog.Builder(this)
                .setTitle("Cancel Register?")
                .setMessage("Are you sure to go back?")
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        closeContextMenu();

                    }
                })
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                      Intent ioioi=new Intent(RegisterPage.this,LoginPage.class);
                      startActivity(ioioi);
                    }
                }).create().show();
    }





    private void sendMail() {
        String email = Email.getText().toString().trim();

        BackgroundTask backgroundTask=new BackgroundTask(this,email,mobile_number,Uname.getText().toString(),getDob);
        backgroundTask.execute();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        sqldb=new SQLDB(this);
        sqldb.deleteStudentid();
        sqldb.deletetable();
        sqldb.deletetable_bookmark();
        progressBarRegister=findViewById(R.id.progressBarRegister);

        Uname=findViewById(R.id.registername);
        Upassword=findViewById(R.id.getpassword);
        dateButton=findViewById(R.id.datepicker_id);
        mob=findViewById(R.id.mobile_register);




        Email=findViewById(R.id.getemail);

        Intent i =getIntent();
        mobile_number=i.getStringExtra("mobile_number");


        showpassword=findViewById(R.id.showpassword);

        showpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Upassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);

            }
        });




        initDatePicker();


        registerbutton=findViewById(R.id.RegisterButton);
        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(!Uname.getText().toString().equals("") && !Email.getText().toString().equals("")
                        && !Upassword.getText().toString().equals("") && !getDob.equals("")) {

                    progressBarRegister.setVisibility(View.VISIBLE);
                    sqldb.insert_username(String.valueOf(Email.getText()));


                    Log.w("UpasswordgetText()",Upassword.getText().toString());
                    Log.w("UpasswordgetText()",Upassword.getText().toString());



                        sendMail();
                        register();


                    }else {
                        Toast.makeText(getApplicationContext(), "Filed cannot Be Empty", Toast.LENGTH_SHORT).show();



                    }





                }




        });
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month=month+1;
                String date=makeDateString(day,month,year);
                dateButton.setText(date);
                getDob= String.valueOf(dateButton.getText());
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
    public void opendatepicker(View view) {
        datePickerDialog.show();
    }


    public void register(){
        StringRequest request=new StringRequest(Request.Method.POST, url_register, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                if (response.equals("successfully register")){
                    Log.w("",response);
                    Intent i =new Intent(RegisterPage.this,BottomNavEx.class);
                    startActivity(i);

                }else if (response.equals("Email already registered")){
                    Log.w("ssssssssss",response);
                    Intent i =new Intent(RegisterPage.this,LoginPage.class);
                    startActivity(i);


                }

                //Toast.makeText(getApplicationContext(),"FileUploaded Successfully", Toast.LENGTH_SHORT).show();
                Log.w("",response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Intent i =new Intent(RegisterPage.this,LoginPage.class);
                startActivity(i);
                Log.w("",error);
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {if(mobile_number==null){
                mobile_number=mob.getText().toString();

            }
                Map<String,String> map=new HashMap<String, String>();
                map.put("Name", String.valueOf(Uname.getText()));
                map.put("User_name", String.valueOf(Email.getText()));
                map.put("Password", String.valueOf(Upassword.getText()));
                map.put("Phone_no", mobile_number);
                map.put("DOB", getDob);

                sqldb.insert_StuReg(String.valueOf(Uname.getText()),mobile_number,getDob,String.valueOf(Email.getText()),String.valueOf(Upassword.getText()));



                return map;
            }
        };


        RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
        queue.add(request);

    }
}