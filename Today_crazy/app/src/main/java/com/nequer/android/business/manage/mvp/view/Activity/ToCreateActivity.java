package com.nequer.android.business.manage.mvp.view.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.nequer.android.base.activity.AbsBaseFragment;
import com.nequer.android.base.activity.NoBarActivity;
import com.nequer.android.base.fragment.BaseFragment;
import com.nequer.android.business.manage.mvp.view.Fragment.CreateCalendarFragment;
import com.nequer.android.business.manage.mvp.view.Fragment.StatusFragment;
import com.nequer.android.business.manage.mvp.view.onCreateCallback;
import com.nequer.android.common.CacheKey;
import com.nequer.android.utils.FragmentUtil;
import com.nequer.android.utils.ToastUtil;
import com.neuqer.android.R;
import com.neuqer.android.runtime.base.fragment.AbsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ToCreateActivity extends NoBarActivity implements onCreateCallback {


    public final int TO_RE_EDIT = 0;
    public final int TO_CREATE = 1;
    public final int OPEN_STATUS = 0;
    public final int OPEN_CONTENT = 1;
    public final int OPEN_RECOMMEND = 2;

    private int type;
    private int open_type;
    private int calendarId;

    private  StatusFragment statusFragment;


    private static int newId = -1;
    @BindView(R.id.to_create_img_back)
    ImageView mImgCreateBack;
    @BindView(R.id.to_create_tv_title)
    TextView mTvCreateTitle;
    @BindView(R.id.to_create_tv_next)
    TextView mTvCreateNext;
    @BindView(R.id.to_create_frame)
    FrameLayout mFrameCreate;



    public void startCreate(){

    }

    public static void startToCreateActivity(Context context,int type, int openType,int calendarId){

        Intent intent = new Intent(context,ToCreateActivity.class);
        intent.putExtra(CacheKey.KEY_START_TYPE,type);
        intent.putExtra(CacheKey.KEY_OPEN_TYPE,openType);
        intent.putExtra(CacheKey.KEY_CALENDAR_ID,calendarId);
        context.startActivity(intent);

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_to_create;
    }

    @Override
    protected void initView() {
        super.initView();

        switch(type){
            case TO_RE_EDIT:
                mTvCreateTitle.setText("修改日历");
                mTvCreateNext.setText("完成");
                break;
            case TO_CREATE:
                mTvCreateTitle.setText("创建日历");
                creatCalendar();
                break;
        }




    }

    @Override
    protected void initValue() {
        super.initValue();
    }

    @Override
    protected void loadata() {
        super.loadata();
        Intent intent = getIntent();
        type = intent.getIntExtra(CacheKey.KEY_START_TYPE,1);
        open_type = intent.getIntExtra(CacheKey.KEY_OPEN_TYPE,0);
        calendarId = intent.getIntExtra(CacheKey.KEY_CALENDAR_ID,-1);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.to_create_img_back, R.id.to_create_tv_title})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.to_create_img_back:
                finish();
                break;
            case R.id.to_create_tv_title:
                break;

        }
    }


    private void replaceFragment(AbsBaseFragment fragment){
        FragmentUtil.replace(this,R.id.to_create_frame,fragment,null);
    }

    private void hideFragment(AbsBaseFragment fragment){
        FragmentUtil.hideFragment(this,fragment);
    }
    private void creatCalendar(){
        mTvCreateNext.setClickable(true);
        statusFragment = StatusFragment.getInstance(calendarId);

        replaceFragment(statusFragment);
        mTvCreateNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (statusFragment.IsEmpty()){
                    return;
                }
                if (statusFragment.isResumed()){
                    statusFragment.ToCreateDescribe(ToCreateActivity.this);

                }
            }
        });
    }


    @Override
    public void transToAnother() {
        newId = statusFragment.getCalendarId();
        hideFragment(statusFragment);
        CreateCalendarFragment createCalendarFragment = new CreateCalendarFragment();
        replaceFragment(createCalendarFragment);
    }
}
