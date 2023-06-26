package com.axis.axistrial;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.axistrial.R;


public class HomeFragment extends Fragment {
    ImageView imageInHomeFragment,imageInHomeFragment1,imageInHomeFragment2,imageInHomeFragment3,imageInHomeFragment4;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_home, container, false);
        imageInHomeFragment=view.findViewById(R.id.imageInHomeFragment);
        imageInHomeFragment1=view.findViewById(R.id.imageInHomeFragment1);
        imageInHomeFragment2=view.findViewById(R.id.imageInHomeFragment2);
        imageInHomeFragment3=view.findViewById(R.id.imageInHomeFragment3);
        imageInHomeFragment4=view.findViewById(R.id.imageInHomeFragment4);
        Glide.with(getActivity()).load("https://img.freepik.com/free-vector/abstract-coming-soon-halftone-style-background-design_1017-27282.jpg?size=626&ext=jpg").into(imageInHomeFragment);
        Glide.with(getActivity()).load("https://img.freepik.com/free-vector/abstract-coming-soon-halftone-style-background-design_1017-27282.jpg?size=626&ext=jpg").into(imageInHomeFragment1);
        Glide.with(getActivity()).load("https://img.freepik.com/free-vector/abstract-coming-soon-halftone-style-background-design_1017-27282.jpg?size=626&ext=jpg").into(imageInHomeFragment2);
        Glide.with(getActivity()).load("https://img.freepik.com/free-vector/abstract-coming-soon-halftone-style-background-design_1017-27282.jpg?size=626&ext=jpg").into(imageInHomeFragment3);
        Glide.with(getActivity()).load("https://img.freepik.com/free-vector/abstract-coming-soon-halftone-style-background-design_1017-27282.jpg?size=626&ext=jpg").into(imageInHomeFragment4);
        return view;
    }
}