package com.nequer.android.business.account.view;

import android.content.Intent;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nequer.android.base.activity.ToolBarActivity;
import com.nequer.android.base.mvp.view.BasePresenterActivity;
import com.nequer.android.business.account.contract.RegisterContract;
import com.nequer.android.business.account.model.request.RegisterReqModel;
import com.nequer.android.business.account.model.response.RegisterRspModel;
import com.nequer.android.business.account.presenter.RegisterActivityPresenter;
import com.nequer.android.utils.ToastUtil;
import com.neuqer.android.R;
import com.neuqer.android.network.response.ApiResponse;

public class RegisterActivity extends BasePresenterActivity<RegisterContract.Presenter> implements RegisterContract.View,View.OnClickListener{


    private String name,pwd;
    private EditText edtRgitAccount, edtRgitPwd, edtErgitPwd;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_register;
    }




    @Override
    protected void initView(){
        edtRgitAccount = (EditText) findViewById(R.id.edt_rgit_account);
        edtRgitPwd = (EditText) findViewById(R.id.edt_rgit_pwd);
        edtRgitPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        edtErgitPwd = (EditText) findViewById(R.id.edt_ergit_pwd);
        edtErgitPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        Button btnRgit = (Button) findViewById(R.id.btn_register);

        //mPresenter = new RegisterActivityPresenter();

        btnRgit.setOnClickListener(this);
    }

    @Override
    protected void initValue() {

    }

    @Override
    protected void loadata() {

    }


    @Override
    public void registerSuccess(Long data) {
        Log.d("Activity", "here");
        ToastUtil.showToast("注册成功！您是第"+ data+"个用户");

        Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("pwd",pwd);
        startActivity(intent);
        finish();

    }

    @Override
    public void registerFailed() {
        Log.d("RegisterActivity", "Im here");
    }



    @Override
    public void onClick(View view){
        RegisterReqModel reqModel = new RegisterReqModel();
                reqModel.setName(edtRgitAccount.getText().toString().trim());
                reqModel.setPassword(edtRgitPwd.getText().toString().trim());
                reqModel.setConfirmPassword(edtErgitPwd.getText().toString().trim());

                name = edtRgitAccount.getText().toString().trim();
                pwd = edtRgitPwd.getText().toString().trim();
                mPresenter.register(reqModel);
    }

    @Override
    protected RegisterContract.Presenter getPresenter() {

        return new RegisterActivityPresenter();
    }
}
