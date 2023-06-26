package com.axis.axistrial;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewpagerAdapterforFilter extends FragmentPagerAdapter {

    public ViewpagerAdapterforFilter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
            fragment = new Rankfilter();

        else if (position == 1)
            fragment = new LocationFilter();
        else if (position == 2)
            fragment = new CountryFilter();



        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public CharSequence getPageTitle(int position)
    {
        String title = null;
        if (position == 0)
            title = "Rank";
        else if (position == 1)
            title = "Location";
        else if (position == 2)
            title = "Country";
        return title;
    }
}
