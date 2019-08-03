package com.nequer.android.business.subscribe.mvp.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.TestLooperManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.nequer.android.App;
import com.nequer.android.base.mvp.view.BasePresenterActivity;
import com.nequer.android.business.account.view.MainActivity;
import com.nequer.android.business.manage.mvp.view.Activity.MangeCalendarActivity;
import com.nequer.android.business.square.mvp.view.SquareActivity;
import com.nequer.android.business.subscribe.adapter.SubFragmentAdapter;
import com.nequer.android.business.subscribe.contract.SubscribeContract;
import com.nequer.android.business.subscribe.fragment.SubscribedFragment;
import com.nequer.android.business.subscribe.mvp.model.CalendarModel;
import com.nequer.android.business.subscribe.mvp.presenter.SubcribePresenter;
import com.nequer.android.utils.CacheUtil;
import com.nequer.android.utils.ToastUtil;
import com.neuqer.android.R;

import java.util.List;

public class SubscribeActivity extends BasePresenterActivity<SubscribeContract.Presenter> implements SubscribeContract.View,View.OnClickListener {

    private DrawerLayout mDrawer;

    SharedPreferences sp = CacheUtil.getSP();
    private TextView textView;
    private ImageView imageView;
    private ImageView imageViewAvatar;
    private TextView textViewName;
    private TextView textViewSignature;
    private NavigationView navigationView;

    private ViewPager viewPager;
    private RelativeLayout relativeLayout_empty_subscribe;
    private TextView tv_calendar_title;
    private ImageView test;

    private SubFragmentAdapter adapter;
    private CalendarModel calendarModel;

    /**
     * 初始化侧边栏
     */
    @Override
    protected void initView(){

        Glide.with(this)
                .load(sp.getString("AVATAR","https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=4113065710,2255729322&fm=26&gp=0.jpg"))
                .into(imageViewAvatar);

        textViewName.setText(sp.getString("NAME","王尼玛"));
        textViewSignature.setText(sp.getString("SIGNATURE","荆轲刺秦王"));

        textView.setText(sp.getString("TOKEN","NULL"));
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_exit:
                        App.getInstance().exitLogin();
                        break;
                    case R.id.nav_square:
                        Intent intent  = new Intent(SubscribeActivity.this, SquareActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_manager:
                        Intent manageIntent = new Intent(SubscribeActivity.this, MangeCalendarActivity.class);
                        startActivity(manageIntent);

                }

                return false;
            }
        });
    }

    @Override
    protected void initValue() {

        mPresenter.getCalendar();


        imageView = (ImageView)findViewById(R.id.img_drawer_menu);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_subscribe);
        textView = (TextView)findViewById(R.id.txt_empty_calendar);
        imageView.setOnClickListener(this);
        navigationView = (NavigationView)findViewById(R.id.nav_view);
        View headView = navigationView.getHeaderView(0);
        imageViewAvatar = (ImageView)headView.findViewById(R.id.nav_avatar);
        textViewName = (TextView) headView.findViewById(R.id.nav_txt_username);
        textViewSignature = (TextView)headView.findViewById(R.id.nav_txt_signature);


        viewPager = (ViewPager)findViewById(R.id.vp_subscribe);
        relativeLayout_empty_subscribe = (RelativeLayout)findViewById(R.id.relative_empty_subscribe);
        tv_calendar_title = (TextView)findViewById(R.id.txt_calendar_title);


    }

    @Override
    protected void loadata() {

    }


    @Override
    public void onClick(View v) {
        mDrawer.openDrawer(Gravity.START);
    }


    @Override
    protected SubscribeContract.Presenter getPresenter() {
        return new SubcribePresenter();
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.activity_subscribe;
    }

    /**
     * 请求成功后初始化界面
     * @param calendarModelList
     */
    @Override
    public void onSubscribedCalendarSuccess(List<CalendarModel> calendarModelList) {
        //ToastUtil.showToast(calendarModelList.get(0).getCalendarName());


        adapter = new SubFragmentAdapter(getSupportFragmentManager(),calendarModelList);

        if(!calendarModelList.isEmpty()){
            relativeLayout_empty_subscribe.setVisibility(View.GONE);
            viewPager.setVisibility(View.VISIBLE);

            tv_calendar_title.setText(calendarModelList.get(0).getCalendarName());
            viewPager.setAdapter(adapter);
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int i, float v, int i1) {

                }

                @Override
                public void onPageSelected(int i) {

                    String msg = String.valueOf(i);
                    tv_calendar_title.setText(calendarModelList.get(i).getCalendarName());
                    ToastUtil.showToast(msg);
                }

                @Override
                public void onPageScrollStateChanged(int i) {

                }
            });
        }

    }
}
