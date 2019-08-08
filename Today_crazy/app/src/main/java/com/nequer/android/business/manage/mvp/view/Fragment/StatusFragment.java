package com.nequer.android.business.manage.mvp.view.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lwkandroid.imagepicker.ImagePicker;
import com.lwkandroid.imagepicker.data.ImageBean;
import com.lwkandroid.imagepicker.data.ImageContants;
import com.lwkandroid.imagepicker.data.ImagePickType;
import com.lwkandroid.imagepicker.data.ImagePickerOptions;
import com.lwkandroid.imagepicker.ui.grid.view.ImageDataActivity;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.imagepicker.view.CropImageView;
import com.nequer.android.App;
import com.nequer.android.base.mvp.view.BasePresenterFragment;
import com.nequer.android.business.manage.iconract.IStatus;
import com.nequer.android.business.manage.mvp.model.ToCreateCalendarModel;
import com.nequer.android.business.manage.mvp.presenter.StatusPresenter;
import com.nequer.android.business.manage.mvp.view.Activity.ToCreateActivity;
import com.nequer.android.business.manage.mvp.view.onCreateCallback;
import com.nequer.android.common.CacheKey;
import com.nequer.android.common.Config;
import com.nequer.android.utils.ImagePickerUtil;
import com.nequer.android.utils.MatisseGlideEngine;
import com.nequer.android.utils.PiccosoImageLoader;
import com.nequer.android.utils.ToastUtil;
import com.nequer.android.widget.PlusView;
import com.neuqer.android.R;
import com.squareup.picasso.Picasso;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.internal.entity.CaptureStrategy;
import com.neuqer.android.permission.PermissionRequest;
import com.zhihu.matisse.ui.MatisseActivity;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;
import static com.nequer.android.common.Config.FILE_PROVIDER;
import static com.nequer.android.common.Config.REQUEST_CODE_CHOOSE;


public class StatusFragment extends BasePresenterFragment<IStatus.Presenter> implements IStatus.View {


    private ToCreateActivity context;

    @BindView(R.id.fragment_status_imag_upload)
    ImageView mImagUpload;
    @BindView(R.id.fragment_status_tv_title)
    TextView mStatusTvTitle;
    @BindView(R.id.fragment_status_edt_title)
    EditText mStatusEdtTitle;
    @BindView(R.id.fragment_status_relative_title)
    RelativeLayout mStatusRelativeTitle;
    @BindView(R.id.fragment_status_tv_good_number)
    TextView mStatusTvGoodNumber;
    @BindView(R.id.fragment_status_good_pick)
    PlusView mStatusGoodPick;
    @BindView(R.id.fragment_status_relative_good_number)
    RelativeLayout fragmentStatusRelativeGoodNumber;
    @BindView(R.id.fragment_status_tv_bad_number)
    TextView mTvBadNumber;
    @BindView(R.id.fragment_status_bad_pick)
    PlusView mStatusBadPick;
    @BindView(R.id.fragment_status_relative_bad_number)
    RelativeLayout fragmentStatusRelativeBadNumber;
    @BindView(R.id.fragment_status_tv_describe)
    TextView fragmentStatusTvDescribe;
    @BindView(R.id.fragment_status_edt_describe)
    EditText mStatusEdtDescribe;
    Unbinder unbinder;

    private int calendarId;
    private String url;

    private String mPicsPath;
    private ToCreateCalendarModel model;

    private onCreateCallback callback;

    public static StatusFragment getInstance(int calendarId){
        Bundle bundle = new Bundle();
        bundle.putInt(CacheKey.KEY_CALENDAR_ID,calendarId);
        StatusFragment fragment = new StatusFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_status;
    }

    @Override
    protected void initData() {

        Bundle bundle = getArguments();
        calendarId = bundle.getInt(CacheKey.KEY_CALENDAR_ID);


    }

    @Override
    protected void initValuable() {

    }

    @Override
    protected void initView() {


        initPermission();

        mImagUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Matisse.from(getActivity())
//                        .choose(MimeType.ofImage())
//                        .countable(true)
//                        .capture(true)
//                        .maxSelectable(1)
//                        .captureStrategy(new CaptureStrategy(true,FILE_PROVIDER))
//                        .gridExpectedSize(getResources().getDimensionPixelSize(R.dimen.product_grid_expected_size))
//                        .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
//                        .thumbnailScale(0.85f)
//                        .imageEngine(new MatisseGlideEngine())
//                        .gridExpectedSize((getActivity().getWindowManager().getDefaultDisplay().getWidth())/3)
//                        .theme(R.style.Matisse_Dracula);

//                ImagePicker imagePicker = ImagePicker.getInstance();
//                imagePicker.setImageLoader(new PiccosoImageLoader());   //设置图片加载器
//                imagePicker.setShowCamera(true);  //显示拍照按钮
//                imagePicker.setCrop(true);        //允许裁剪（单选才有效）
//                imagePicker.setSaveRectangle(true); //是否按矩形区域保存
//                imagePicker.setSelectLimit(1);    //选中数量限制
//                imagePicker.setStyle(CropImageView.Style.RECTANGLE);  //裁剪框的形状
//                imagePicker.setFocusWidth(800);   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
//                imagePicker.setFocusHeight(800);  //裁剪框的高度。单位像素（圆形自动取宽高最小值）
//                imagePicker.setOutPutX(1000);//保存文件的宽度。单位像素
//                imagePicker.setOutPutY(1000);//保存文件的高度。单位像素
//
//
//
//                Intent intent = new Intent(getContext(), ImageGridActivity.class);
//                startActivityForResult(intent,Config.REQUEST_CODE_CHOOSE);
//

                com.lwkandroid.imagepicker.ImagePicker imagePicker = new com.lwkandroid.imagepicker.ImagePicker();
                imagePicker.pickType(ImagePickType.SINGLE)
                        .needCamera(true)
                        .cachePath(App.getInstance().getCachePath())
                        .displayer(new ImagePickerUtil())
                        .doCrop(1,1,480,480)
                        .start(StatusFragment.this,Config.REQUEST_CODE_CHOOSE);
//                Intent intent = new Intent(getContext(), ImageDataActivity.class);
//                startActivityForResult(intent,Config.REQUEST_CODE_CHOOSE);

//                Intent intent = new Intent(getActivity(), ImageDataActivity.class);
//                intent.putExtra(ImageContants.INTENT_KEY_OPTIONS,new ImagePickerOptions());
//                startActivityForResult(intent, Config.REQUEST_CODE_CHOOSE);
            }
        });
    }

    @Override
    public void onUpLoadPicsSucceed(String url) {

        ToastUtil.showToast("图片上传成功！"+url);
        this.url = url;

    }

    @Override
    public void onCreateSucceed(int id) {

        callback.transToAnother();
        ToastUtil.showToast("新建Id:"+id);
        calendarId = id;

    }

    @Override
    protected IStatus.Presenter getPresenter() {
        return new StatusPresenter();
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Config.REQUEST_CODE_CHOOSE && data!=null){
           ArrayList<ImageBean>resultList = data.getParcelableArrayListExtra(ImagePicker.INTENT_RESULT_DATA);
           String url = resultList.get(0).getImagePath();
           Glide.with(Objects.requireNonNull(getContext()))
                   .load(url)
                   .into(mImagUpload);

           mPresenter.upLoadPics(url);
        }

    }

    private void initPermission() {
        new PermissionRequest.Builder(getContext(),Config.REQUEST_PERMISSIONS)
                .request();
    }


    public void ToCreateDescribe(onCreateCallback callback){

        this.callback = callback;

        if(IsEmpty()){
            ToastUtil.showToast("请将信息填写完整");
        }else{
            model = new ToCreateCalendarModel();
            model.setTitle(mStatusEdtTitle.getText().toString().trim());
            model.setGood_pick(mStatusGoodPick.getNum());
            model.setBad_pick(mStatusBadPick.getNum());
            model.setDescription(mStatusEdtDescribe.getText().toString().trim());
            model.setPicture(url);
            model.setIs_public(1);
            mPresenter.toCreateCalendar(model);


        }

    }

    public int getCalendarId(){
        return calendarId;
    }

    public boolean IsEmpty(){
        return (mStatusEdtTitle.getText().toString().trim().equals("") || mStatusEdtDescribe.getText().toString().trim().equals(""));
    }
}
