package com.example.dasha.tourgidapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Dasha on 04.09.2017.
 */

public class InstitutionFragmentPagerAdapter extends FragmentPagerAdapter {
    Context mContext;

    final int PAGE_COUNT = 4;

    String mTitle;

    public InstitutionFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new RestaurantsFragment();
        } else if(position == 1) {
            return new NightClubsFragment();
        } else if(position == 2) {
            return new BarsFragment();
        } else {
            return new CoffeesFragment();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                mTitle = mContext.getResources().getString(R.string.restaurants);
                break;
            case 1:
                mTitle = mContext.getResources().getString(R.string.night_clubs);
                break;
            case 2:
                mTitle = mContext.getResources().getString(R.string.bars);
                break;
            case 3:
                mTitle = mContext.getResources().getString(R.string.coffees);
                break;
        }

        return mTitle;
    }
}
