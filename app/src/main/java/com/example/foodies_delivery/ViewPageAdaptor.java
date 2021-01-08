package com.example.foodies_delivery;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPageAdaptor extends FragmentPagerAdapter {

    ArrayList<Fragment> fragment_list = new ArrayList<>();

    public ViewPageAdaptor(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragment_list.get(position);
    }

    @Override
    public int getCount() {
        return fragment_list.size();
    }

    public void addFragment(Fragment fragment) {
        fragment_list.add(fragment);
    }
}
