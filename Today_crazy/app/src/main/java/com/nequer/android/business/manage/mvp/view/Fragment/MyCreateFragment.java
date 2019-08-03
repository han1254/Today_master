package com.nequer.android.business.manage.mvp.view.Fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nequer.android.base.adapter.BaseRecyclerViewAdapter;
import com.nequer.android.base.mvp.view.BasePresenterFragment;
import com.nequer.android.business.manage.adapter.MyCreateAdapter;
import com.nequer.android.business.manage.iconract.IMyCreateContract;
import com.nequer.android.business.manage.mvp.model.MyCreateModel;
import com.nequer.android.business.manage.mvp.presenter.MyCreatePresenter;
import com.nequer.android.business.square.adapter.SquareAdapter;
import com.nequer.android.common.CacheKey;
import com.nequer.android.utils.ToastUtil;
import com.neuqer.android.R;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class MyCreateFragment extends BasePresenterFragment<IMyCreateContract.Presenter> implements IMyCreateContract.View {

    @BindView(R.id.fragment_mycreate_recycler)
    RecyclerView mMycreateRecycler;
    @BindView(R.id.fragment_mycreate_fb)
    FloatingActionButton mMycreateFb;
    Unbinder unbinder;

    private MyCreateAdapter adapter;
    private List<MyCreateModel> mCreateModelList;


    public static MyCreateFragment getInstance(List<MyCreateModel> list)
    {
        Bundle bundle = new Bundle();
        bundle.putSerializable(CacheKey.KEY_MYCREATE_LIST, (Serializable) list);
        MyCreateFragment fragment = new MyCreateFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    protected IMyCreateContract.Presenter getPresenter() {
        return new MyCreatePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my_create;
    }

    @Override
    protected void initData() {
        //mPresenter.getCreate();
    }

    @Override
    protected void initValuable() {


    }

    @Override
    protected void initView() {

        Bundle bundle = getArguments();
        mCreateModelList = (List<MyCreateModel>) bundle.getSerializable(CacheKey.KEY_MYCREATE_LIST);
        adapter.addItems(mCreateModelList);
        adapter = new MyCreateAdapter(mCreateModelList,getActivity(),R.layout.item_mycreate);
        adapter.setOnItemClickListener(new MyCreateAdapter.onItemClickListener() {
            @Override
            public void OnClick(int position) {
                ToastUtil.showToast("点击了item");
            }
        });
        adapter.setmOnViewContralClickListener(new MyCreateAdapter.onViewControlClickListener() {
            @Override
            public void OnViewClick(int position, int type) {
                ToastUtil.showToast("编辑");
            }
        }, 1);
//        adapter.setmOnViewContralClickListener(new MyCreateAdapter.onViewControlClickListener() {
//            @Override
//            public void OnViewClick(int position, int type) {
//                ToastUtil.showToast("删除");
//            }
//        }, 2);
        adapter.setmOnDleClickListener(new MyCreateAdapter.onDeleClickListener() {
            @Override
            public void OnDeleClick(int postion, int type) {
                ToastUtil.showToast("删除");
            }
        },2);
        mMycreateRecycler.setAdapter(adapter);
        mMycreateRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    public void onGetCreateSucceed(List<MyCreateModel> list) {
//        adapter.addItems(list);
//        mCreateModelList = list;
//        adapter = new MyCreateAdapter(mCreateModelList,getActivity(),R.layout.item_mycreate);
//        adapter.setOnItemClickListener(new MyCreateAdapter.onItemClickListener() {
//            @Override
//            public void OnClick(int position) {
//                ToastUtil.showToast("点击了item");
//            }
//        });
//        adapter.setmOnViewContralClickListener(new MyCreateAdapter.onViewControlClickListener() {
//            @Override
//            public void OnViewClick(int position, int type) {
//                ToastUtil.showToast("编辑");
//            }
//        }, 1);
////        adapter.setmOnViewContralClickListener(new MyCreateAdapter.onViewControlClickListener() {
////            @Override
////            public void OnViewClick(int position, int type) {
////                ToastUtil.showToast("删除");
////            }
////        }, 2);
//        adapter.setmOnDleClickListener(new MyCreateAdapter.onDeleClickListener() {
//            @Override
//            public void OnDeleClick(int postion, int type) {
//                ToastUtil.showToast("删除");
//            }
//        },2);
//        mMycreateRecycler.setAdapter(adapter);
//        mMycreateRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.getCreate();
    }

    @Override
    public void onGetCreateFailed() {

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

    @OnClick(R.id.fragment_mycreate_fb)
    public void onViewClicked() {
        ToastUtil.showToast("点击了悬浮按钮！");
    }





}