package com.axis.axistrial;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.axistrial.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavEx extends AppCompatActivity {
    TextView appbartext;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    SQLDB sqldb;
    AppBarLayout appBarLayout;
   // CircleImageView circleImageView;


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        closeContextMenu();

                    }
                })
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        finishAffinity();
                    }
                }).create().show();
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_bottom_nav_ex);
        sqldb=new SQLDB(this);
        sqldb.deletetable();
        sqldb.deletetable_bookmark1();


       // circleImageView =findViewById(R.id.circle_imageViewinappbar);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        appbartext=findViewById(R.id.appbarTitle);
        appBarLayout=findViewById(R.id.appbar_id);
        bottomNavigationView=findViewById(R.id.bottomnavigation_id);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_displayhere_id,new CourseFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;
                switch (item.getItemId()){
                    case R.id.home_nav:
                        getSupportActionBar().show();
                        //appbartext.setText("Explore");

                        fragment=new HomeFragment();
                        break;

                    case R.id.course_nav:
                        getSupportActionBar().show();
                        appbartext.setText("Axis");
                        fragment=new CourseFragment();
                        break;

                    case R.id.account_nav:
                        appbartext.setText("");
                        //circleImageView.setVisibility(View.GONE);
                        fragment=new AccountFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_displayhere_id,fragment).commit();
                return true;
            }
        });
    }

}