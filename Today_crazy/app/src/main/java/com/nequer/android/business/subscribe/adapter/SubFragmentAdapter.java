package com.nequer.android.business.subscribe.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;

import com.nequer.android.base.fragment.BaseFragment;
import com.nequer.android.business.subscribe.fragment.SubscribedFragment;
import com.nequer.android.business.subscribe.mvp.model.CalendarModel;

import java.util.List;

public class SubFragmentAdapter extends FragmentPagerAdapter {

    private List<CalendarModel> calendarList;
    public SubFragmentAdapter(FragmentManager fm, List<CalendarModel> list) {
        super(fm);
        calendarList = list;
    }

    @Override
    public Fragment getItem(int i) {

        return SubscribedFragment.newInstance(calendarList.get(i));
    }

    @Override
    public int getCount() {
        if(calendarList == null){
           return 0;
        }
         return calendarList.size();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return PagerAdapter.POSITION_NONE;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }


}
