package com.nequer.android.base.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleableRes;
import android.support.v4.app.DialogFragment;

public abstract class AbsBaseDialogFragment extends DialogFragment {

    private Dialog mDialog;

    @StyleableRes
    private int mStyle;
    @Override
    public void onAttach(Context context) {

        if(!(getActivity() instanceof IBaseBEDFragmentCallback)){
            throw new IllegalStateException("DialogFragment 所在的activity必须实现IBaseBEDFragmentCallback接口");
        }
        super.onAttach(context);
    }

    @SuppressLint("ResourceType")
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);


    }


    protected abstract int getDialogStyle();
}
