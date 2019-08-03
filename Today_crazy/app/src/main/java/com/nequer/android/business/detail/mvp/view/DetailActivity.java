package com.nequer.android.business.detail.mvp.view;

import android.content.Intent;
import android.media.Image;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.nequer.android.base.mvp.view.BasePresenterActivity;
import com.nequer.android.business.detail.adapter.DetailPagerAdapter;
import com.nequer.android.business.detail.contract.DialogFragmentCallBack;
import com.nequer.android.business.detail.contract.ICommentFragmentContract;
import com.nequer.android.business.detail.contract.IDetail;
import com.nequer.android.business.detail.fragment.CommentDialogFragment;
import com.nequer.android.business.detail.mvp.model.DetailModel;
import com.nequer.android.business.detail.mvp.presenter.DetailPresenter;
import com.nequer.android.utils.ToastUtil;
import com.neuqer.android.R;

import java.util.List;

import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.BlurTransformation;

public class DetailActivity extends BasePresenterActivity<IDetail.Presenter> implements IDetail.View, View.OnClickListener {

    private ViewPager viewPager;
    private TabLayout tabs;
    private DetailPagerAdapter pagerAdapter;
    private DetailModel mDetailModel;
    private ImageView mCalendarAvatar;
    private ImageView mUserAvatar;
    private ImageView mStar;
    private ImageView mIsSubscribe;
    private ImageView mDetailBackground;
    private TextView mCalendarTitle;
    private TextView mUserName;
    private TextView mSubscribeNumber;
    private Boolean isSubscribed = false;
    private RelativeLayout mSubscribeRelaBag;

    private int calendarId;
    private android.support.v7.widget.Toolbar mToolBar;
    private AppBarLayout mAppBarLayout;

   // private DetailPagerAdapter mPagerAdapter;
    private EditText mCommentEdit;
    private ImageView mSendImage;
    private TextView mCommentTxt;



    @Override
    protected IDetail.Presenter getPresenter() {
        return new DetailPresenter();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_detail;
    }

    @Override
    protected void initView() {


        //initViewPager();

        //viewPager.setAdapter(pagerAdapter);

    }

    @Override
    protected void initValue() {



        viewPager = (ViewPager) findViewById(R.id.detail_vp);
        mAppBarLayout = (AppBarLayout)findViewById(R.id.calendar_detail_appbar_layout);
        mToolBar = (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar_calendar_detail);
        initToolBar();


        mCalendarAvatar = (ImageView)findViewById(R.id.calendar_avatar);
        mUserAvatar = (ImageView)findViewById(R.id.image_calendar_detail_useravatar);
        mStar = (ImageView)findViewById(R.id.calendar_detail_imag_subscribe);
        mCalendarTitle = (TextView)findViewById(R.id.txt_calendar_detail_title);
        mUserName = (TextView)findViewById(R.id.txt_calendar_detail_username);
        mSubscribeNumber = (TextView) findViewById(R.id.calendar_detail_txt_subscribe_number);
        mDetailBackground = (ImageView) findViewById(R.id.image_calendar_bg);
        mSubscribeRelaBag = (RelativeLayout) findViewById(R.id.calendar_detail_subscribe_selector);


        mToolBar = (Toolbar)findViewById(R.id.toolbar_calendar_detail);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mSubscribeRelaBag.setOnClickListener(this);
        /*Glide.with(this)
                .load(mDetailModel.getPicture())
                .into(mCalendarAvatar);*/

//        mCommentEdit = (EditText)findViewById(R.id.comment_dialog_edit);
//        mSendImage = (ImageView)findViewById(R.id.image_btn_comment_send);
//        mCommentTxt = (TextView)findViewById(R.id.tv_comment_fake_button);
//
//        mCommentTxt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                CommentDialogFragment commentDialogFragment = new CommentDialogFragment();
//               commentDialogFragment.show(getSupportFragmentManager(),"CommentDialogFragment");
//            }
//        });


    }

    @Override
    protected void loadata() {


        Intent  intent = getIntent();
        calendarId = intent.getIntExtra("calendarId",-1);
        if (calendarId == -1){

        }else{

            mPresenter.getDetail(calendarId);
        }

    }




    @Override
    public void onDetailSucceed(DetailModel detailModel) {

        ToastUtil.showToast("calendarTitle:"+detailModel.getTitle());

        mDetailModel = detailModel;

        Glide.with(this)
                .load(mDetailModel.getCreatorAvatar())
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(mUserAvatar);

        Glide.with(this)
                .load(mDetailModel.getPicture())
                .into(mCalendarAvatar);

        Glide.with(this)
                .load(mDetailModel.getPicture())
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(25,3)))
                .into(mDetailBackground);
        if(mDetailModel.isIsSubscribed()){
            isSubscribed = true;
            mStar.setSelected(true);
            mSubscribeRelaBag.setSelected(true);
            mSubscribeNumber.setTextColor(getResources().getColor(R.color.royalblue));
        }else{
            mStar.setSelected(false);

        }



        mCalendarTitle.setText(mDetailModel.getTitle());
        mUserName.setText(mDetailModel.getCreatorName());
        mSubscribeNumber.setText(String.valueOf(mDetailModel.getSubscribed()));
        //mSubscribeNumber.setText(mDetailModel.getSubscribed());

        initViewPager(detailModel);

    }

    @Override
    public void onCommendSucceed() {

    }

    @Override
    public void onDetailFailed() {
        ToastUtil.showToast("失败了，失败了");
    }

    @Override
    public void onSubscribeSucceed() {

        ToastUtil.showToast("订阅成功！");
        mSubscribeRelaBag.setSelected(true);
        mStar.setSelected(true);
        mSubscribeNumber.setTextColor(getResources().getColor(R.color.royalblue));
        mSubscribeNumber.setText(String.valueOf(mDetailModel.getSubscribed()+1));

    }

    @Override
    public void onSubscribeFailed() {

    }

    @Override
    public void onUnSubscribeSucceed() {
        ToastUtil.showToast("取消订阅！");
        mSubscribeRelaBag.setSelected(false);
        mStar.setSelected(false);
        mSubscribeNumber.setTextColor(getResources().getColor(R.color.white));
        mSubscribeNumber.setText(String.valueOf(mDetailModel.getSubscribed()-1));
    }

    @Override
    public void onUnSubscribeFailed() {

    }


    private void initToolBar(){
       mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.BaseOnOffsetChangedListener() {
           @Override
           public void onOffsetChanged(AppBarLayout appBarLayout, int i) {

           }
       });
    }

    private void initViewPager(DetailModel detailModel){
        //pagerAdapter = new DetailPagerAdapter(getSupportFragmentManager(),mDetailModel);

        pagerAdapter = new DetailPagerAdapter(getSupportFragmentManager(),detailModel);
        viewPager.setAdapter(pagerAdapter);
        tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        tabs.setTabTextColors(R.color.white,R.color.primary_dark);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.calendar_detail_subscribe_selector:
                if(!isSubscribed){
                    mPresenter.toSubscribe(calendarId);
                    isSubscribed = true;
                }else {


                    mPresenter.unSubscribe(calendarId);
                }
        }
    }

//    @Override
//    public String getCommentText() {
//        return mCommentTxt.getText().toString();
//    }
//
//    @Override
//    public void setCommentText(String commentText) {
//        mCommentTxt.setText(commentText);
//    }
//
//    @Override
//    public void sendCommentText(String commentText) {
//        mCommentTxt.setText(commentText);
//        ToastUtil.showToast(commentText);
//    }
}
