package com.jeewms.www.wms.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jeewms.www.wms.R;
import com.jeewms.www.wms.util.LocalDisplay;
import com.jeewms.www.wms.util.Logutil;

/**
 * Created by 13799 on 2018/5/29.
 */

public  class BaseActivity extends Activity{

    //总布局holder
    protected LinearLayout mLlHolder;
    //titlebarholder
    protected View mTitleBarHolder;
    protected View mBtnLeft;
    protected View mBtnRight;
    protected TextView mTvTitle;
    private boolean mDestory = false;
    private boolean mPaused;
    private Context context;


    @SuppressLint("InlinedApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        LocalDisplay.init(this);
        mLlHolder=new LinearLayout(this);
        mLlHolder.setOrientation(LinearLayout.VERTICAL);
        int titleBarResId=getTitleBarResId();
        if(titleBarResId>0){
            mTitleBarHolder=getLayoutInflater().inflate(titleBarResId,null);
            LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LocalDisplay.dp2px(48));
            Logutil.print(LocalDisplay.dp2px(48));
            mLlHolder.addView(mTitleBarHolder,lp);
            mBtnLeft = mTitleBarHolder.findViewById(R.id.btn_titlebar_left);
            mBtnRight = mTitleBarHolder.findViewById(R.id.btn_titlebar_right);
            mTvTitle = (TextView) mTitleBarHolder.findViewById(R.id.tv_title);
            if(null!=mBtnLeft){
                mBtnLeft.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onLeftButtonClick();
                    }
                });
            }
            if(null!=mBtnRight){
                mBtnRight.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onRightButtonClick();
                    }
                });
            }
            if (mTvTitle != null) {
                int titleResId = getTitleResId();// id == 0
                setTitle(titleResId);
                mTvTitle.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        onTitleTextClick();
                    }
                });
            }
        }
        View content=null;
        int contentResId=getContentResId();
        if(contentResId>0){
            content=getLayoutInflater().inflate(contentResId,null);
        }else{
            content=getContentView();
        }
        if(content!=null){
            LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,1);
            mLlHolder.addView(content,lp);
        }
        setContentView(mLlHolder);
        initView();
    }
    protected void onLeftButtonClick() {
        finish();
    }

    protected void onRightButtonClick() {

    }

    protected void onTitleTextClick() {

    }
    public void setTitle(int resid) {
        if (mTvTitle != null && resid > 0)
            mTvTitle.setText(resid);
    }

    public void setTitle(String title) {
        if (mTvTitle != null)
            mTvTitle.setText(title);
    }
    @Override
    public Resources getResources() {
        // TODO Auto-generated method stub
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }
    protected int getTitleResId() {
        return 0;
    }

    protected int getContentResId() {
        return 0;
    }

    protected View getContentView() {
        return null;
    }

    protected void initView() {}
    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    protected void addContentView(View v) {
        if (v != null)
            mLlHolder.addView(v, LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
    }
    protected int getTitleBarResId(){
        return R.layout.titlebar_default;
    }
    @Override
    protected void onResume() {
        super.onResume();
        mPaused = false;
    }
    public boolean isPaused() {
        return mPaused;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPaused = true;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDestory = true;
    }
    public boolean isDestroy(){
        return mDestory;
    }
    public Context getActivity(){
        return context;
    }
}
