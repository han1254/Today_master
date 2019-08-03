package com.nequer.android.business.manage.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nequer.android.base.mvp.impl.IBaseContract;
import com.nequer.android.base.mvp.view.BasePresenterFragment;
import com.nequer.android.business.manage.mvp.model.MyCreateModel;
import com.nequer.android.business.manage.mvp.view.Fragment.MyCreateFragment;
import com.nequer.android.business.manage.mvp.view.Fragment.MySubscribeFragment;
import com.nequer.android.business.subscribe.mvp.model.CalendarModel;

import java.util.List;

public class ManagerPagerAdapter extends FragmentPagerAdapter {

    private static List<MyCreateModel> createModelList;
    private static List<CalendarModel> calendarModelList;
    private List<MyCreateModel> myCreateModelList;
    private List<CalendarModel> mySubscribeList;
    private static int number = 0;

    private Fragment fragment;
    private String[] titles = {"我创建的","我订阅的"};

    public ManagerPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public ManagerPagerAdapter(FragmentManager fm, List<MyCreateModel> createModelList,List<CalendarModel> calendarModelList){
        super(fm);
        this.myCreateModelList = createModelList;
        this.mySubscribeList = calendarModelList;

    }

    public static void addCreateList(List<MyCreateModel> list){
        createModelList = list;
        number++;
    }

    public void addCalendarList(List<CalendarModel> list){
        calendarModelList = list;
        number++;
    }
    @Override
    public Fragment getItem(int i) {
        switch (i){

            case 0: fragment = MyCreateFragment.getInstance(myCreateModelList);

            break;
            case 1: fragment = MySubscribeFragment.getInstance(mySubscribeList);
            break;
        }

        return fragment;

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    public int getNumber(){
        return number;
    }
}
