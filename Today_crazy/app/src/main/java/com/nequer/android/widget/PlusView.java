package com.nequer.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.neuqer.android.R;

import butterknife.BindView;

public class PlusView extends LinearLayout {

    ImageButton imgSub;

    TextView txtNum;

    ImageButton imgAdd;

    private int MinNum = 2;
    private int MaxNum = 20;
    private int pickNum = 2;

    public PlusView(Context context, AttributeSet attrs) {
        super(context, attrs);

        View view = LayoutInflater.from(context).inflate(R.layout.view_numplus, this);
        imgSub = view.findViewById(R.id.img_sub);
        txtNum = view.findViewById(R.id.txt_num);
        imgAdd = view.findViewById(R.id.img_add);
        imgSub.setVisibility(View.INVISIBLE);
        imgSub.setOnClickListener(v -> onTextChange(--pickNum));

        imgAdd.setOnClickListener(v->onTextChange(++pickNum));
    }

    public PlusView(Context context) {
        super(context);

    }

    private void onTextChange(int number){
        txtNum.setText(String.valueOf(number));
        if(number==MinNum){
            imgSub.setVisibility(View.INVISIBLE);
        }else if(number == MaxNum){
            imgAdd.setVisibility(View.INVISIBLE);
        }else{
            imgAdd.setVisibility(View.VISIBLE);
            imgSub.setVisibility(View.VISIBLE);
        }
    }

    public void setCurrentNumber(int number){
        pickNum = number;
        onTextChange(pickNum);
    }

    public int getNum(){
        return pickNum;
    }

}
