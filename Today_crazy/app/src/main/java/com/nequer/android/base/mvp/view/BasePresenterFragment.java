package com.nequer.android.base.mvp.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nequer.android.base.activity.AbsBaseFragment;
import com.nequer.android.base.mvp.impl.IBaseContract;
import com.nequer.android.base.mvp.presenter.BasePresenter;

public abstract class BasePresenterFragment<P extends IBaseContract.IBasePresenter> extends AbsBaseFragment implements IBaseContract.IBaseView {

    View rootView = null;
    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        initPresenter();

        return super.onCreateView(inflater, container, savedInstanceState);
    }


    protected abstract P getPresenter();

    protected void initPresenter(){
        mPresenter = getPresenter();
        if(mPresenter != null){
            mPresenter.bindView(this);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (mPresenter != null){
            mPresenter.unBindView();
        }
    }
}
