package com.axis.axistrial;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.axistrial.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.concurrent.Executor;


public class AccountFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    View view;
    ImageView img1;
    ViewPagerAdapterAccount viewPagerAdapterAccount;
    SQLDB sqldb;
    TextView nameinAccount,mobInAccount;
    ArrayList<StudentDetails>arrayList;
    GoogleSignInClient mGoogleSignInClient;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.account_page, container, false);
        tabLayout=view.findViewById(R.id.tabsaccount);
        viewPager=view.findViewById(R.id.view_pageraccount);
        nameinAccount=view.findViewById(R.id.nameinAccount);
        mobInAccount=view.findViewById(R.id.mobInAccount);
        sqldb=new SQLDB(getContext());
        arrayList=sqldb.getStudent_details();
        nameinAccount.setText(arrayList.get(0).getName());
        mobInAccount.setText(arrayList.get(0).getMob());////////////////////////////////////////////////////////////////////////////////////////////////
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
//        GoogleSignInOptions gso = new GoogleSignInOptions.
//                Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).
//                build();
//
        mGoogleSignInClient = GoogleSignIn.getClient(getContext(), gso);


        img1=view.findViewById(R.id.circle_imageViewinAccountPage);
        String imageUri2 = "https://cdn.icon-icons.com/icons2/1378/PNG/512/avatardefault_92824.png";
        Picasso.get().load(imageUri2).into(img1);
        viewPagerAdapterAccount=new ViewPagerAdapterAccount(getChildFragmentManager());
        viewPager.setAdapter(viewPagerAdapterAccount);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


//       viewPagerAdapter1 = new ViewPagerAdapter1(getSupportFragmentManager(),arrayListtable,arrayListfee,arrayListEnterance,arrayListElg,course_name,unv_name);
//        viewPager1.setAdapter(viewPagerAdapter1);
//        viewPager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));


        // Add Tab


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.option_menu_items,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()){

            case R.id.edtlogout:
                sqldb.Logout();

                Intent i=new Intent(getContext(),LoginPage.class);
                i.putExtra("signout","yes");
                startActivity(i);

                break;


        }
        return super.onOptionsItemSelected(item);
    }
}