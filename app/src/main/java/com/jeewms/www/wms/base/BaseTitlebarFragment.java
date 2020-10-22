package com.jeewms.www.wms.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jeewms.www.wms.R;


/**
 * Fragment标题栏
 * 
 * @author yj
 *
 */
public abstract class BaseTitlebarFragment extends Fragment {
	
	protected TextView mTvTitle;
	protected View mBtnLeft;
	protected View mBtnRight;
	protected View content = null;
	protected View titlebar;
	private Activity mActivity;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
		LinearLayout holder = new LinearLayout(this.getActivity());
		mActivity=this.getActivity();
		holder.setOrientation(LinearLayout.VERTICAL);
//		int titlebarResId = getTitlebarResId();
//		if (titlebarResId > 0) {
//			titlebar = inflater.inflate(titlebarResId, null);
//			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//					LinearLayout.LayoutParams.MATCH_PARENT, LocalDisplay.dp2px(48));
//			holder.addView(titlebar, lp);
//			mBtnLeft = titlebar.findViewById(R.id.btn_titlebar_left);
//			mBtnRight = titlebar.findViewById(R.id.btn_titlebar_right);
//			mTvTitle = (TextView) titlebar.findViewById(R.id.tv_title);
//
//			if (mBtnLeft != null) {
//				mBtnLeft.setOnClickListener(new OnClickListener() {
//
//					@Override
//					public void onClick(View v) {
//						onLeftButtonClick();
//					}
//
//				});
//			}
//
//			if (mBtnRight != null) {
//				mBtnRight.setOnClickListener(new OnClickListener() {
//
//					@Override
//					public void onClick(View v) {
//						onRightButtonClick();
//					}
//
//				});
//			}
//
//			if (mTvTitle != null) {
//				int titleResId = getTitleResId();
//				setTitle(titleResId);
//				mTvTitle.setOnClickListener(new OnClickListener() {
//
//					@Override
//					public void onClick(View v) {
//						onTitleTextClick();
//					}
//
//				});
//			}
//		}
		
		int contentResId = getContentResId();
		if (contentResId > 0) {
			content = inflater.inflate(contentResId, null);
		} else {
			content = getContentView();
		}
		if (content != null) {
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.MATCH_PARENT);
			holder.addView(content, lp);
		}
		initView();
		return holder;
	}
	
	protected int getTitlebarResId() {
		return R.layout.titlebar_default;
	}

	protected int getTitleResId() {
		return 0;
	}
	
	protected int getContentResId() {
		return 0;
	}
	
	protected View getContentView() {
		return content;
	}
	
	protected void initView() {
		
	}
	
	protected void onLeftButtonClick() {
		
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
	//得到可靠地Activity
	public Activity getMyActivity()
	{
		return mActivity;
	}



}
