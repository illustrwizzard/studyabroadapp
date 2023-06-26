package com.axis.axistrial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.axistrial.R;

import java.util.ArrayList;

public class ApplicationDetailsInApplicationDetails extends AppCompatActivity {
    ImageView backbuttonInApplication;
    String intake_year,intake_month,universityName, intake_mail;
    EditText passportNo,qualification,markobt,markPercent,IELTSmark,TOEFLmark,comm_id;
   String passportNo1,qualification1,markobt1,markPercent1,IELTSmark1,TOEFLmark1,martial_status,visa_reject,comm_medium,com_id;
   ArrayList<ApplicationDetailsDataClass>arrayList;
   RadioGroup martialStatus,VisaRejection,Comm_media;
   RadioButton radioButton,radioButton1,radioButton2;
   String course_name;



//    @Override
//    public void onBackPressed() {
//        Intent i=new Intent(ApplicationDetailsInApplicationDetails.this,BottomSheetOfGetAdmissionEx.class);
//        startActivity(i);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.application_details_in_getadmission);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        arrayList=new ArrayList<>();

        Intent extra=getIntent();
        universityName=extra.getStringExtra("univName");
        course_name=extra.getStringExtra("course_name");
        intake_month=extra.getStringExtra("intake_month");
        intake_year=extra.getStringExtra("intake_year");
        intake_mail=extra.getStringExtra("intake_mail");
        Log.w("llllllllll",universityName);
        Log.w("kkkkkkkkkkk",intake_month);
        Log.w("fffffffff",intake_year);
        Log.w("mmmmmmmmmmm",intake_mail);

    // EditText passportNo,qualification,markobt,markPercent,IELTSmark,TOEFLmark,comm_id;
        //   String passportNo1,qualification1,markobt1,markPercent1,IELTSmark1,TOEFLmark1,martial_status,visa_reject,comm_medium;
        passportNo=findViewById(R.id.passprtNUmber);
        qualification=findViewById(R.id.qualification_id);
        markobt=findViewById(R.id.markObt_id);
        markPercent=findViewById(R.id.markPercent_id);
        IELTSmark=findViewById(R.id.IELTS_id);
        TOEFLmark=findViewById(R.id.TOEFL_id);
        comm_id=findViewById(R.id.commuu_id);



        martialStatus=findViewById(R.id.martial_status_id);
        VisaRejection=findViewById(R.id.visa_rejection_id);
        Comm_media=findViewById(R.id.commu_id);
        martialStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = (RadioButton) findViewById(checkedId);
               martial_status=radioButton.getText().toString();
               Log.w("jssssjjjjjjj",martial_status);
            }
        });

        VisaRejection.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton1 = (RadioButton) findViewById(checkedId);
                visa_reject=radioButton1.getText().toString();
                Log.w("jssssjjjjjjj",visa_reject);
            }
        });

        Comm_media.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton2 = (RadioButton) findViewById(checkedId);
                comm_medium=radioButton2.getText().toString();
                Log.w("jssssjjjjjjj",comm_medium);
            }
        });






        backbuttonInApplication=findViewById(R.id.backbuttonInApplication);
        backbuttonInApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(ApplicationDetailsInApplicationDetails.this,InsideCourseSection.class);
//                startActivity(intent);
                finish();
            }
        });


    }

    public void nexttouploadpage(View view) {
        //   String passportNo1,qualification1,markobt1,markPercent1,IELTSmark1,TOEFLmark1,martial_status,visa_reject,comm_medium;

        if((passportNo.getText() == null || qualification.getText() == null || markobt.getText() == null || markPercent.getText() == null || IELTSmark.getText() == null || TOEFLmark.getText() == null)){
            Toast.makeText(getApplicationContext(), "Field Cannot Be Empty", Toast.LENGTH_SHORT).show();

        }else{
            passportNo1=passportNo.getText().toString();
            qualification1=qualification.getText().toString();
            markobt1=markobt.getText().toString();
            markPercent1=markPercent.getText().toString();
            IELTSmark1=IELTSmark.getText().toString();
            TOEFLmark1=TOEFLmark.getText().toString();
            com_id=comm_id.getText().toString();
            ApplicationDetailsDataClass dataClass=new ApplicationDetailsDataClass(passportNo1,martial_status,visa_reject,qualification1,markobt1,markPercent1,IELTSmark1,TOEFLmark1,comm_medium,com_id);
            arrayList.add(dataClass);




            Intent intent=new Intent(ApplicationDetailsInApplicationDetails.this,UploadFilesInGetAdmission.class);
            intent.putExtra("university_intake",universityName);
            intent.putExtra("course_name",course_name);
            intent.putExtra("intake_month",intake_month);
            intent.putExtra("intake_year",intake_year);
            intent.putExtra("intake_mail",intake_mail);
            intent.putParcelableArrayListExtra("arraylist",arrayList);
            startActivity(intent);

        }





    }
}