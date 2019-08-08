package com.nequer.android.business.manage.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nequer.android.base.activity.AbsBaseFragment;
import com.nequer.android.base.fragment.BaseFragment;
import com.nequer.android.business.manage.mvp.model.MyCreateModel;
import com.nequer.android.business.manage.mvp.view.Fragment.MyCreateFragment;
import com.nequer.android.business.manage.mvp.view.Fragment.MySubscribeFragment;
import com.nequer.android.business.subscribe.mvp.model.CalendarModel;

import java.util.ArrayList;
import java.util.List;

public class MangerFragmentAdapter extends FragmentPagerAdapter {

    private MySubscribeFragment subscribeFragment = new MySubscribeFragment();
    private MyCreateFragment createFragment = new MyCreateFragment();
    private List<AbsBaseFragment> fragmentLists = new ArrayList<>();
    private Fragment fragment;
    private String[] titles = {"我创建的","我订阅的"};

    public MangerFragmentAdapter(FragmentManager fm) {
        super(fm);
        init();
    }

    private void init(){
        fragmentLists.add(createFragment);
        fragmentLists.add(subscribeFragment);

    }

    @Override
    public Fragment getItem(int i) {
        switch(i){
            case 0:
                try {
                    fragment = MyCreateFragment.class.newInstance();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
                break;
            case 1:
                try {
                    fragment = MySubscribeFragment.class.newInstance();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
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
