package com.axis.axistrial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.axistrial.R;

public class GetAdmissionEx extends AppCompatActivity {
    private Spinner spinner, sp1;
    Button getadmissionSubmitButton;
    String[] year = { "2022", "2023", "2024", "2025","2026"};
    String unv_name;
    String intake_year="",intake_month="",intake_mail="";
    EditText intakeMmail;
    String course_name;
    int [] startyear={};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_admission_ex);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        }
        Intent extra=getIntent();
        course_name=extra.getStringExtra("coursename");
        unv_name=extra.getStringExtra("unvname");



        intakeMmail=findViewById(R.id.intake_mail);
        spinner = findViewById(R.id.month_spinner);
        Log.w("ssssssss",unv_name);
        sp1 = findViewById(R.id.year_spinner);
        getadmissionSubmitButton=findViewById(R.id.getadmission_submit_button);
        getadmissionSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intake_mail=intakeMmail.getText().toString();
                Intent intent=new Intent(GetAdmissionEx.this,ApplicationDetailsInApplicationDetails.class);
                intent.putExtra("univName",unv_name);
                intent.putExtra("course_name",course_name);
                intent.putExtra("intake_year",intake_year);
                intent.putExtra("intake_month",intake_month);
                intent.putExtra("intake_mail",intake_mail);
                startActivity(intent);


            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.month,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                intake_month= String.valueOf(parent.getItemAtPosition(position));

                Log.w("selected month",intake_month);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        ArrayAdapter aa = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_item, year);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(aa);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                intake_year= String.valueOf(parent.getItemAtPosition(position));
                Log.w("selected year",intake_year);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }
}