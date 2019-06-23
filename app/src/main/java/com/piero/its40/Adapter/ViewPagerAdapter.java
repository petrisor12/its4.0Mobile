package com.piero.its40.Adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {


   private final List<String> listFragmentTitle=new ArrayList<>();
   private final List<Fragment> listFragment=new ArrayList<>();


    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {

        return listFragment.size();
    }

    public void addFragment(String title, Fragment fragment){
        listFragmentTitle.add(title);
        listFragment.add(fragment);

    }


    @Override
    public CharSequence getPageTitle(int position) {
        return listFragmentTitle.get(position);
    }
}
