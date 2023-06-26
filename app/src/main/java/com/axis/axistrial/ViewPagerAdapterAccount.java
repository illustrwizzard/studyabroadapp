package com.axis.axistrial;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapterAccount
        extends FragmentPagerAdapter {





    public ViewPagerAdapterAccount(
            @NonNull FragmentManager fm)
    {
        super(fm);

    }


    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        Fragment fragment = null;
        if (position == 0)
            fragment = new AboutpageInAbout();

        else if (position == 1)
            fragment = new FavoritePageInAbout();


        return fragment;
    }

    @Override
    public int getCount()
    {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        String title = null;
        if (position == 0)
            title = "About";
        else if (position == 1)
            title = "Favourites";
        return title;
    }


}
