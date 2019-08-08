package com.nequer.android.business.manage.mvp.view.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.nequer.android.base.mvp.view.BasePresenterActivity;
import com.nequer.android.business.manage.adapter.ManagerPagerAdapter;
import com.nequer.android.business.manage.adapter.MangerFragmentAdapter;
import com.nequer.android.business.manage.iconract.IManageContract;
import com.nequer.android.business.manage.mvp.model.MyCreateModel;
import com.nequer.android.business.manage.mvp.presenter.ManagerPresenter;
import com.nequer.android.business.subscribe.mvp.model.CalendarModel;
import com.nequer.android.utils.ToastUtil;
import com.neuqer.android.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MangeCalendarActivity extends BasePresenterActivity<IManageContract.Presenter> implements IManageContract.View {


    private MangerFragmentAdapter fragmentAdapter;
    private ManagerPagerAdapter pagerAdapter;
    @BindView(R.id.manage_toolbar)
    Toolbar manageToolbar;
    @BindView(R.id.manage_tab)
    TabLayout manageTab;
    @BindView(R.id.manage_vp)
    ViewPager manageVp;

    private static List<MyCreateModel> myCreateList = new ArrayList<>();
    private static List<CalendarModel> mySubscribeList = new ArrayList<>();

    @Override
    protected IManageContract.Presenter getPresenter() {
        return new ManagerPresenter();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_mange_calendar;
    }


    @Override
    protected void initValue() {


    }

    @Override
    protected void loadata() {
//        mPresenter.getSubscribe();
//        mPresenter.getCreate();
    }

    @Override
    public void onGetCreateSucceed(List<MyCreateModel> list) {
        myCreateList = list;

//        pagerAdapter.addCreateList(list);
//        if (pagerAdapter.getNumber() == 2){
//            manageVp.setAdapter(pagerAdapter);
//            manageTab.setupWithViewPager(manageVp);
//        }

    }

    @Override
    public void onGetCreateFailed() {

    }

    @Override
    public void onGetSubscribeSucceed(List<CalendarModel> list) {
        mySubscribeList = list;

//        pagerAdapter.addCalendarList(list);

    }

    @Override
    public void onGetSubscribeFailed() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {


        fragmentAdapter = new MangerFragmentAdapter(getSupportFragmentManager());
        manageVp.setAdapter(fragmentAdapter);
        manageTab.setupWithViewPager(manageVp);

        manageToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }


}
