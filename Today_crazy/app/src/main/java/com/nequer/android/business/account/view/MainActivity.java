/*
 * Copyright 2019. techflowing
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nequer.android.business.account.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nequer.android.App;
import com.nequer.android.base.activity.BaseActivity;
import com.nequer.android.base.activity.ToolBarActivity;
import com.nequer.android.base.mvp.view.BasePresenterActivity;
import com.nequer.android.business.account.contract.LoginContract;
import com.nequer.android.business.account.model.UserInfo;
import com.nequer.android.business.account.model.request.LoginReqModel;
import com.nequer.android.business.account.model.response.LoginResponseModel;
import com.nequer.android.business.account.model.response.LoginRspModel;
import com.nequer.android.business.account.presenter.LoginActivityPresenter;
import com.nequer.android.business.subscribe.mvp.view.SubscribeActivity;
import com.nequer.android.network.response.ApiResponse;
import com.nequer.android.utils.CacheUtil;
import com.nequer.android.utils.ToastUtil;
import com.neuqer.android.R;

import static android.support.v4.media.session.MediaSessionCompat.KEY_TOKEN;

/**
 * 示例类
 *
 * @author techflowing
 * @since 2019/4/21 11:42 PM
 */
public class MainActivity extends BasePresenterActivity<LoginContract.Presenter> implements LoginContract.View,View.OnClickListener{


    private boolean mIsRegister = false;
    private Button btnTest;
    private EditText edtLoginAccount,edtLoginPassword;
    private Button btnLogin;
    private LinearLayout linerRegsiter;
    private String name;
    private String pwd;

    SharedPreferences sp = CacheUtil.getSP();

    public void initVlaule(){
        if(sp.getString("TOKEN","") != ""){
            Intent intent = new Intent(MainActivity.this,SubscribeActivity.class);
            startActivity(intent);

        }
    }


    @Override
    protected LoginContract.Presenter getPresenter() {
        return new LoginActivityPresenter();
    }

    @Override
    public void loginSuccess(LoginResponseModel responseModel) {


        Log.d("login_s","here");

        ToastUtil.showToast(responseModel.getData().getToken()+"你好");
        Intent intent = new Intent(MainActivity.this,SubscribeActivity.class);
        startActivity(intent);
        finish();


    }

    @Override
    public void loginFailed() {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }


    @Override
    protected void initView() {

        initVlaule();

        edtLoginAccount = (EditText) findViewById(R.id.edt_account);
        edtLoginPassword = (EditText) findViewById(R.id.edt_pwd);
        btnLogin = (Button) findViewById(R.id.btn_login);


        linerRegsiter = (LinearLayout)findViewById(R.id.linearLayout_register);

        edtLoginAccount.setTextColor(getResources().getColor(R.color.white));
        edtLoginPassword.setTextColor(getResources().getColor(R.color.white));
        edtLoginPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());

        btnLogin.setOnClickListener(this);
        linerRegsiter.setOnClickListener(this);
    }

    @Override
    protected void initValue() {

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        pwd = intent.getStringExtra("pwd");
        LoginReqModel loginReqModel = new LoginReqModel();
        loginReqModel .setName(name);
        loginReqModel.setPassword(pwd);
        loginReqModel.setClient(0);
        mPresenter.login(loginReqModel);
    }

    @Override
    protected void loadata() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                /*Toast.makeText(getApplicationContext(),"登陆登陆登陆登陆登陆登陆",Toast.LENGTH_SHORT).show();*/
                LoginReqModel loginReqModel = new LoginReqModel();
                loginReqModel.setName(edtLoginAccount.getText().toString().trim());
                loginReqModel.setPassword(edtLoginPassword.getText().toString().trim());
                loginReqModel.setClient(0);
                mPresenter.login(loginReqModel);

                break;

            case R.id.linearLayout_register:
                Intent  intent2 = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }

    }




}


