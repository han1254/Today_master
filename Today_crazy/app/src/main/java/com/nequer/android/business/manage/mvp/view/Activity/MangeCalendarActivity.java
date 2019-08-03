package com.nequer.android.business.manage.mvp.view.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;

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
        mPresenter.getSubscribe();
        mPresenter.getCreate();
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


        /**
         * id : 157
         * title : 没啥好说的
         * description : nothing
         * creatorId : 0
         * subscribed : 2
         * picture : http://cdn.marklux.cn/0233f76c-4e13-41ba-9e6c-4b85a8fc87bd
         * createdAt : 111111111111110
         * updatedAt : 22222222220
         * isPublic : 0
         * password : null
         * goodPick : 0
         * badPick : 0
         * isSubscribed : false
         */

        MyCreateModel createModel1 = new MyCreateModel();
        createModel1.setId(157);
        createModel1.setTitle("没啥好说的");
        createModel1.setCreatorId(0);
        createModel1.setSubscribed(2);
        createModel1.setIsSubscribed(false);
        createModel1.setPicture("http://cdn.marklux.cn/0233f76c-4e13-41ba-9e6c-4b85a8fc87bd");
        createModel1.setIsPublic(0);
        createModel1.setPassword(null);
        createModel1.setGoodPick(0);
        createModel1.setBadPick(0);
       for(int i = 0; i < 10; i++){
           myCreateList.add(createModel1);
       }



        CalendarModel calendarModel1 = new CalendarModel();
        calendarModel1.setCalendarName("拆迁⑥黄历");
        calendarModel1.setCalendarId(149);
        calendarModel1.setCalendarPicture("http://cdn.marklux.cn/08404141-5447-42a4-9e43-3ed7ce7a0871");
        calendarModel1.setGood(null);
        calendarModel1.setBad(null);
        calendarModel1.setRecommend(null);
        for(int i = 0; i < 10; i++){
            mySubscribeList.add(calendarModel1);
        }

            pagerAdapter = new ManagerPagerAdapter(getSupportFragmentManager(),myCreateList,mySubscribeList);

            manageVp.setAdapter(pagerAdapter);
            manageTab.setupWithViewPager(manageVp);




    }


}
