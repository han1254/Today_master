package com.nequer.android.business.detail.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nequer.android.business.detail.fragment.CalendarCommentFragment;
import com.nequer.android.business.detail.fragment.CalendarDetailFragment;
import com.nequer.android.business.detail.mvp.model.DetailModel;

import java.util.ArrayList;
import java.util.List;

public class DetailPagerAdapter extends FragmentPagerAdapter {

    private String[] titles = new String[]{"预览","评论"};

    private DetailModel detailModel;
    private Fragment fragment = new Fragment();
    public DetailPagerAdapter(FragmentManager fm, DetailModel detailModel) {
        super(fm);
        this.detailModel = detailModel;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){
            case 0:fragment = CalendarDetailFragment.getInstance(detailModel);
            break;
            case 1:fragment = CalendarCommentFragment.getInstance(detailModel.getId());
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
}
