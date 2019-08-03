package com.nequer.android.business.detail.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.nequer.android.base.mvp.view.BasePresenterFragment;
import com.nequer.android.business.detail.adapter.DetailCommentAdapter;
import com.nequer.android.business.detail.contract.ICommentFragmentContract;
import com.nequer.android.business.detail.mvp.model.DetailCommentModel;
import com.nequer.android.business.detail.mvp.presenter.CalendarCommentPresenter;
import com.nequer.android.utils.ToastUtil;
import com.neuqer.android.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class CalendarCommentFragment extends BasePresenterFragment<ICommentFragmentContract.ICommentPresenter> implements ICommentFragmentContract.ICommentView {


    @BindView(R.id.detail_comment_edit)
    EditText detailCommentEdit;
    @BindView(R.id.detail_comment_photo)
    ImageView detailCommentPhoto;
    @BindView(R.id.image_btn_at)
    ImageView imageBtnAt;
    @BindView(R.id.detail_comment_send)
    ImageView detailCommentSend;
    @BindView(R.id.detail_comment_input)
    RelativeLayout detailCommentInput;
    private int mCalendarId;
    private int page = 1;
    private DetailCommentAdapter mCommentAdapter;

    private List<DetailCommentModel> mCommentList = new ArrayList<>();
    private boolean isLastPge = false;

    @BindView(R.id.detail_comment_recycler)
    RecyclerView detailCommentRecycler;

    Unbinder unbinder;

    public static CalendarCommentFragment getInstance(int calendarId) {

        Bundle bundle = new Bundle();
        bundle.putInt("calendarId", calendarId);
        CalendarCommentFragment calendarCommentFragment = new CalendarCommentFragment();
        calendarCommentFragment.setArguments(bundle);
        return calendarCommentFragment;
    }


    @Override
    protected ICommentFragmentContract.ICommentPresenter getPresenter() {
        return new CalendarCommentPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_calendar_comment;
    }

    @Override
    protected void initData() {

        Bundle bundle = getArguments();
        mCalendarId = bundle.getInt("calendarId");


//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mPresenter.getComment(mCalendarId,page++);
//            }
//        },1000);

        mPresenter.getComment(mCalendarId, page++);
    }

    @Override
    protected void initValuable() {
        mCommentAdapter = new DetailCommentAdapter(mCommentList, getContext(), R.layout.item_detail_comment);
        detailCommentSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(detailCommentEdit.getText().toString().equals("")){
                    ToastUtil.showToast("请输入评论内容");
                }else{
                    mPresenter.sendComment(detailCommentEdit.getText().toString().trim(),mCalendarId);
                }

            }
        });
    }

    @Override
    protected void initView() {
        detailCommentRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!isLastPge) {
                    mPresenter.getComment(mCalendarId, page++);
                }
            }
        });

        detailCommentRecycler.setAdapter(mCommentAdapter);

        detailCommentRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

//        tvCommentFakeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                CommentDialogFragment commentDialogFragment = new CommentDialogFragment();
//                commentDialogFragment.show(getFragmentManager(),"CommentDialogFragment");
//            }
//        });

        detailCommentEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(detailCommentEdit.getText().toString().equals("")){
                    detailCommentSend.setImageResource(R.drawable.ic_plane_unsend);
                }else{
                    detailCommentSend.setImageResource(R.drawable.ic_plane_send);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(detailCommentEdit.getText().toString().equals("")){
                    detailCommentSend.setImageResource(R.drawable.ic_plane_unsend);
                }else{
                    detailCommentSend.setImageResource(R.drawable.ic_plane_send);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void getCommentSuccess(List<DetailCommentModel> list) {

        mCommentAdapter.addItems(list);
    }

    @Override
    public void toLastPage() {
        isLastPge = true;
    }

    @Override
    public void onSendCommentSucceed() {
        detailCommentEdit.setText("");
        ToastUtil.showToast("评论成功！");


       mCommentAdapter.removeAllItem();
        page = 1;
        isLastPge = false;
        mCommentAdapter.refresh();
        //mPresenter.getComment(mCalendarId,page);

    }

    @Override
    public void onSendCommentFailed() {

        ToastUtil.showToast("评论失败！");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        assert rootView != null;
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

//    @Override
//    public String getCommentText() {
//        return tvCommentFakeButton.getText().toString();
//    }
//
//    @Override
//    public void setCommentText(String commentText) {
//        tvCommentFakeButton.setText(commentText);
//    }
//
//    @Override
//    public void sendCommentText(String commentText) {
//
//        ToastUtil.showToast(commentText);
//    }
}
