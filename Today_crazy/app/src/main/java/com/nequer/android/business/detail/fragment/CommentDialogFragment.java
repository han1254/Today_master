package com.nequer.android.business.detail.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.nequer.android.business.detail.contract.DialogFragmentCallBack;
import com.nequer.android.business.detail.contract.IDetail;
import com.nequer.android.utils.ToastUtil;
import com.neuqer.android.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class CommentDialogFragment extends DialogFragment implements View.OnClickListener {


    @BindView(R.id.comment_dialog_edit)
    EditText commentDialogEdit;
    @BindView(R.id.comment_dialog_img_photo)
    ImageView commentDialogImgPhoto;
    @BindView(R.id.image_btn_at)
    ImageView imageBtnAt;
    @BindView(R.id.image_btn_comment_send)
    ImageView imageBtnCommentSend;
    Unbinder unbinder;
    private Dialog mDialog;
    private InputMethodManager mInputManager;
    private DialogFragmentCallBack mCallBack;

    @Override
    public void onAttach(Context context) {
        if (!(getActivity() instanceof DialogFragmentCallBack)) {
            throw new IllegalStateException("CommentDialogFragment所在的Activity必须实现DialogFragmentCallback接口");
        }
        super.onAttach(context);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        mDialog = new Dialog(getActivity(), R.style.BottomSheetDialog);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.fragment_comment_dialog);
        mDialog.setCanceledOnTouchOutside(true);

        Window window = mDialog.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.gravity = Gravity.BOTTOM;
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(layoutParams);

        fillEditText();
        setSoftKeyboard();

        commentDialogEdit.addTextChangedListener(mTextWatcher);
        commentDialogImgPhoto.setOnClickListener(this);
        imageBtnAt.setOnClickListener(this);
        imageBtnCommentSend.setOnClickListener(this);

        return mDialog;


    }


    private void fillEditText(){
        mCallBack = (DialogFragmentCallBack)getActivity();
        commentDialogEdit.setText(mCallBack.getCommentText());
        commentDialogEdit.setSelection(mCallBack.getCommentText().length());
        if(mCallBack.getCommentText().length() == 0){
            imageBtnCommentSend.setEnabled(false);
            imageBtnCommentSend.setColorFilter(ContextCompat.getColor(getActivity(),R.color.pantone));
        }
    }


    public void setSoftKeyboard(){
        commentDialogEdit.setFocusable(true);
        commentDialogEdit.setFocusableInTouchMode(true);
        commentDialogEdit.requestFocus();

        commentDialogEdit.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mInputManager = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                if(mInputManager.showSoftInput(commentDialogEdit,0)){
                    commentDialogEdit.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }

        });
    }


    private TextWatcher mTextWatcher = new TextWatcher() {

        private CharSequence temp;
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            temp = s;
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            if (temp.length() > 0){
                imageBtnCommentSend.setEnabled(true);
                imageBtnCommentSend.setClickable(true);
                imageBtnCommentSend.setColorFilter(ContextCompat.getColor(getActivity(),R.color.light_sky_blue));
            }else{
                imageBtnCommentSend.setEnabled(false);
                imageBtnCommentSend.setColorFilter(ContextCompat.getColor(getActivity(),R.color.pantone));
            }
        }
    };


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.image_btn_comment_send:
                mCallBack.sendCommentText(commentDialogEdit.getText().toString());
                mCallBack.setCommentText("");
                dismiss();
                break;

            case R.id.comment_dialog_img_photo:
                ToastUtil.showToast("照一张或者选一张");
                break;
            case R.id.image_btn_at:
                ToastUtil.showToast("选你想at的人");
                break;
            default:
                break;
        }

    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        mCallBack.setCommentText(commentDialogEdit.getText().toString());
        super.onDismiss(dialog);
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        mCallBack.setCommentText(commentDialogEdit.getText().toString());
        super.onCancel(dialog);
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
}
