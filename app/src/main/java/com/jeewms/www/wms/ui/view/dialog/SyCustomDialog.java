package com.jeewms.www.wms.ui.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;

import com.jeewms.www.wms.R;


public class SyCustomDialog extends Dialog {

	protected View mDialogView;

	private AnimationSet mModalInAnim;
	private AnimationSet mModalOutAnim;

	private Float mWidthRatio;
	private Float mHeightRatio;
	private boolean mCanceled = false;

	public SyCustomDialog(Context context) {
		super(context, R.style.sy_dialog);
		mModalInAnim = (AnimationSet) AnimationUtils.loadAnimation(
				getContext(), R.anim.modal_in);
		mModalOutAnim = (AnimationSet) AnimationUtils.loadAnimation(
				getContext(), R.anim.modal_out);
		mModalOutAnim.setAnimationListener(new Animation.AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				mDialogView.setVisibility(View.GONE);
				mDialogView.post(new Runnable() {
					@Override
					public void run() {
						if (mCanceled)
							SyCustomDialog.super.cancel();
						else
							SyCustomDialog.super.dismiss();
					}
				});
			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}

		});
	}

	@Override
	protected void onStart() {
		super.onStart();
		mDialogView = getWindow().getDecorView().findViewById(android.R.id.content);
		mDialogView.startAnimation(mModalInAnim);
	}
	
	@Override
	public void setContentView(int layoutResID) {
		if (mWidthRatio != null || mHeightRatio != null) {
			View v = getLayoutInflater().inflate(layoutResID, null);
			setContentView(v);
        } else
        	super.setContentView(layoutResID);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void setContentView(View view) {
        if (mWidthRatio != null || mHeightRatio != null) {
        	WindowManager wm = getWindow().getWindowManager();
    		Display d = wm.getDefaultDisplay();
    		ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
    				ViewGroup.LayoutParams.MATCH_PARENT,
    				ViewGroup.LayoutParams.WRAP_CONTENT);
    		if (mWidthRatio != null)
    			lp.width = (int) (d.getWidth() * mWidthRatio);
    		if (mHeightRatio != null)
    			lp.height = (int) (d.getHeight() * mHeightRatio);
    		super.setContentView(view, lp);
        } else
        	super.setContentView(view);
    }

	@Override
	public void cancel() {
		dismissWithAnimation(true);
	}

	public void dismissWithAnimation() {
		dismissWithAnimation(false);
	}

	public void dismissWithAnimation(boolean canceled) {
		mCanceled = canceled;
		mDialogView.startAnimation(mModalOutAnim);
	}

	public Float getWidthRatio() {
		return mWidthRatio;
	}

	public void setWidthRatio(Float wRatio) {
		this.mWidthRatio = wRatio;
	}

	public Float getHeightRatio() {
		return mHeightRatio;
	}

	public void setHeightRatio(Float hRatio) {
		this.mHeightRatio = hRatio;
	}

}