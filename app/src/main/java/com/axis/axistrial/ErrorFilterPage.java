package com.axis.axistrial;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.axistrial.R;

public class ErrorFilterPage extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        Intent extra=getIntent();
        if (extra.getStringExtra("ErrorFromUniversity")!=null){
            Intent i=new Intent(ErrorFilterPage.this,Filterpageinsideunv.class);
            startActivity(i);

        }else if (extra.getStringExtra("ErrorFromCourse")!=null){
            Intent i=new Intent(ErrorFilterPage.this,Filterpage_inside_course.class);
            startActivity(i);

        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_filter_page);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }



    }
}