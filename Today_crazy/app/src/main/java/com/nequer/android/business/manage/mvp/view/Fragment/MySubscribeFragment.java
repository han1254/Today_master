package com.nequer.android.business.manage.mvp.view.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nequer.android.base.mvp.view.BasePresenterFragment;
import com.nequer.android.business.detail.mvp.view.DetailActivity;
import com.nequer.android.business.manage.adapter.MySubscribeAdapter;
import com.nequer.android.business.manage.iconract.IMySubscribeContract;
import com.nequer.android.business.manage.mvp.presenter.MySubscribePresenter;
import com.nequer.android.business.subscribe.mvp.model.CalendarModel;
import com.nequer.android.common.CacheKey;
import com.nequer.android.utils.ToastUtil;
import com.neuqer.android.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MySubscribeFragment extends BasePresenterFragment<IMySubscribeContract.Presenter> implements IMySubscribeContract.View {

    @BindView(R.id.fragment_mysubscribe_refresh)
    SwipeRefreshLayout fragmentMysubscribeRefresh;
    Unbinder unbinder;
    private List<CalendarModel> calendarModelList = new ArrayList<>();
    private MySubscribeAdapter adapter;
    private RecyclerView recyclerView;

    private int itemposition;

    public static MySubscribeFragment getInstance(List<CalendarModel> list) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(CacheKey.KEY_MYSUBSCRIBE_LIST, (Serializable) list);
        MySubscribeFragment fragment = new MySubscribeFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my_subscribe;
    }

    @Override
    protected void initData() {

        mPresenter.getSubscribe();

    }


    @Override
    protected void initValuable() {

    }

    @Override
    protected void initView() {

        fragmentMysubscribeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
    }

    @Override
    protected IMySubscribeContract.Presenter getPresenter() {
        return new MySubscribePresenter();
    }

    @Override
    public void onGetSubscribeSucceed(List<CalendarModel> list) {
        calendarModelList = list;
        adapter = new MySubscribeAdapter(calendarModelList, getActivity(), R.layout.item_my_subscribe);
        adapter.addItems(list);

        recyclerView = getView().findViewById(R.id.fragment_mysubscribe_recycler);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.setOnItemClickListener(new MySubscribeAdapter.onItemClickListener() {
            @Override
            public void onClickItem(int id) {
//                ToastUtil.showToast("该item的id：" + String.valueOf(id));
                Intent intent = new Intent(getContext(), DetailActivity.class);
                intent.putExtra("calendarId",id);
                startActivity(intent);
            }
        });

        adapter.setmOnCancelClickListener(new MySubscribeAdapter.onCancelListener() {
            @Override
            public void onCancelClickItem(int id, int position) {

//                ToastUtil.showToast("点击了取消订阅");

                showCoverDialog(id,position);

            }
        });
    }

    @Override
    public void onGetSubscribeFailed() {

    }

    @Override
    public void onUnSubscribeSucceed() {
        ToastUtil.showToast("取消订阅");
        adapter.removeItem(itemposition);
        fragmentMysubscribeRefresh.setRefreshing(true);
        refresh();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    private void showCoverDialog(int id,int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
        builder.setTitle("提示");
        builder.setMessage("是否取消订阅？");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mPresenter.unSubscribe(id);
                itemposition = position;
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        builder.show();
    }


    private void refresh(){


        adapter.refresh();


//        ToastUtil.showToast("没有数据更新");
        if(fragmentMysubscribeRefresh.isRefreshing()){
            fragmentMysubscribeRefresh.setRefreshing(false);
        }
    }
}
