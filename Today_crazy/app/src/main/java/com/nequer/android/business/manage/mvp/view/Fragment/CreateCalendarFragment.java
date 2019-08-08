package com.nequer.android.business.manage.mvp.view.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nequer.android.base.mvp.view.BasePresenterFragment;
import com.nequer.android.business.manage.iconract.ICreateCalendar;
import com.neuqer.android.R;



public class CreateCalendarFragment extends BasePresenterFragment<ICreateCalendar.Presenter> implements ICreateCalendar.View {

    @Override
    protected ICreateCalendar.Presenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_create_calendar;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initValuable() {

    }

    @Override
    protected void initView() {

    }
}
