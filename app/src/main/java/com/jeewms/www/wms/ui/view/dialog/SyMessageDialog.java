package com.jeewms.www.wms.ui.view.dialog;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jeewms.www.wms.R;
import com.jeewms.www.wms.ui.view.ProgressWheel;


public class SyMessageDialog extends SyCustomDialog implements View.OnClickListener {
	
	public static final int TYPE_NORMAL = 0;
	public static final int TYPE_INFORMATION = 1;
	public static final int TYPE_CONFIRMATION = 2;
	public static final int TYPE_SUCCESS = 3;
    public static final int TYPE_ERROR = 4;
    public static final int TYPE_WARNING = 5;
    public static final int TYPE_LOADING = 6;
    public static final int TYPE_PROGRESS = 7;
    public static final int TYPE_QD = 8;
    
    private View mTopHolder;
    private ImageView mIvIcon;
    private ProgressWheel mPwProgress;
    private TextView mTvTitle;
    private View mMsgHolder;
    private TextView mTvMessage;
    private FrameLayout mCustomHolder;
    private View mBtnHolder;
    private Button mBtnNegative;
    private ImageView div_cancle;
    private Button mBtnNeutral;
    private Button mBtnPositive;
	private Button mBtnLinaerPositive;
	private LinearLayout linearPositive;
    private View mCustomView;
    private View mCustomViewTop;
    
    private int mIconResId;
    private float mProgress;
    private String mTitleText;
    private String mMessageText;
    private String mNegativeText;
    private String mNeutralText;
    private String mPositiveText;
	private String mLinearPositiveText;
    
    private boolean mCreated = false;
    private boolean mColseable = true;
    private int mDialogType;
    private int mBtnCount;
    private OnClickListener mNegativeClickListener;
    private OnClickListener mNeutralClickListener;
    private OnClickListener mPositiveClickListener;
	private View div;
	private FrameLayout mCustom_holderTop;
	private boolean IsCancleable;
	private boolean showBulleCancle;
    
    public static interface OnClickListener {
        public void onClick(SyMessageDialog dialog);
    }
    public SyMessageDialog(Context context) {
        this(context, TYPE_NORMAL);
    }

	public void setDivVisibility() {
		div.setVisibility(View.VISIBLE);
	}


	public SyMessageDialog(Context context, int dialogType) {
        super(context);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        mDialogType = dialogType;
    }
	public SyMessageDialog(Context context, int dialogType, boolean IsCancleable) {
		super(context);
		setCancelable(false);
		setCanceledOnTouchOutside(false);
		this.IsCancleable=IsCancleable;
		mDialogType = dialogType;
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sy_dialog);

        mDialogView = getWindow().getDecorView().findViewById(android.R.id.content);
        mTopHolder = findViewById(R.id.sy_dlg_top_holder);
        mIvIcon = (ImageView) findViewById(R.id.iv_sy_dlg_icon);
        mMsgHolder = findViewById(R.id.sy_dlg_msg_holder);
        mTvTitle = (TextView) findViewById(R.id.tv_sy_dlg_title);
        mTvMessage = (TextView) findViewById(R.id.tv_sy_dlg_msg);
        mPwProgress = (ProgressWheel) findViewById(R.id.pw_sy_dlg_progress);
        mCustomHolder = (FrameLayout) findViewById(R.id.sy_dlg_custom_holder);
        mCustom_holderTop = (FrameLayout) findViewById(R.id.sy_dlg_custom_holderTop);
        mBtnHolder = findViewById(R.id.sy_dlg_btn_holder);
        mBtnNegative = (Button) findViewById(R.id.sy_dlg_btn_negative);
		div_cancle = (ImageView) findViewById(R.id.div_cancle);
        mBtnNeutral = (Button) findViewById(R.id.sy_dlg_btn_neutral);
        div = findViewById(R.id.div);
        mBtnPositive = (Button) findViewById(R.id.sy_dlg_btn_positive);
		mBtnLinaerPositive = (Button) findViewById(R.id.sy_dlg_btn_positive2);
		linearPositive = (LinearLayout) findViewById(R.id.ll_linear_positive);

        mBtnNegative.setOnClickListener(this);
        mBtnNeutral.setOnClickListener(this);
        mBtnPositive.setOnClickListener(this);
		mBtnLinaerPositive.setOnClickListener(this);

        mCreated = true;
        changeAlertType(mDialogType);
    }

    public int getAlerType () {
        return mDialogType;
    }

    public SyMessageDialog changeAlertType(int dialogType) {
    	mDialogType = dialogType;
    	int icon = 0;
    	if (mDialogType == TYPE_NORMAL || mDialogType == TYPE_LOADING ||
    			mDialogType == TYPE_PROGRESS)
    		icon = 0;
    	else if (mDialogType == TYPE_INFORMATION)
    		icon = R.drawable.ic_sy_info;
    	else if (mDialogType == TYPE_CONFIRMATION)
    		icon = R.drawable.ic_sy_confirm;
    	else if (mDialogType == TYPE_SUCCESS)
    		icon = R.drawable.ic_sy_ok;
    	else if (mDialogType == TYPE_ERROR)
    		icon = R.drawable.ic_sy_error;
    	else if (mDialogType == TYPE_WARNING)
    		icon = R.drawable.ic_sy_warn;
    	else if (mDialogType == TYPE_QD)
    		icon = R.drawable.qiangdan_dialog;
    	setMessageIcon(icon);
    	if (mDialogType == TYPE_LOADING) {
    		mPwProgress.setVisibility(View.VISIBLE);
    		mPwProgress.spin();
    	} else if (mDialogType == TYPE_PROGRESS) {
    		mPwProgress.setVisibility(View.VISIBLE);
    		setProgress(mProgress);
    	} else
    		mPwProgress.setVisibility(View.GONE);
    	setTitleText(mTitleText);
    	setMessageText(mMessageText);
    	setCustomView(mCustomView);
    	setCustomViewTop(mCustomViewTop);
    	updateTop();
    	updateButton();
    	boolean cancelable = false;
    	if (mBtnCount == 0 && mDialogType != TYPE_LOADING && mDialogType != TYPE_PROGRESS)
    		cancelable = true;
    	else
    		cancelable = mBtnNegative.getVisibility() == View.VISIBLE ||
    				(mBtnPositive.getVisibility() == View.VISIBLE && mPositiveClickListener == null);
    	if (cancelable)
    		cancelable=IsCancleable;
    	setCancelable(cancelable);
    	setCanceledOnTouchOutside(cancelable);
    	return this;
    }

    public SyMessageDialog setMessageIcon (int resid) {
    	mIconResId = resid;
    	if (mIvIcon != null) {
    		if (mIconResId > 0) {
    			if (mDialogType != TYPE_QD){
    				mIvIcon.setPadding(0, 10, 0, 0);
    			}
    			mIvIcon.setImageResource(mIconResId);
    			mIvIcon.setVisibility(View.VISIBLE);
    		} else
    			mIvIcon.setVisibility(View.GONE);
    	}
        return this;
    }

    public String getTitleText() {
        return mTitleText;
    }

    public SyMessageDialog setTitleText(String text) {
        mTitleText = text;
        if (mTvTitle != null) {
        	if (TextUtils.isEmpty(mTitleText)) {
        		mTvTitle.setVisibility(View.GONE);
        	} else {
        		mTvTitle.setText(mTitleText);
        		mTvTitle.setVisibility(View.VISIBLE);
        	}
        }
        return this;
    }

    public String getMessageText() {
        return mMessageText;
    }

    public SyMessageDialog setMessageText(String text) {
    	mMessageText = text;
        if (mTvMessage != null) {
        	if (TextUtils.isEmpty(mMessageText)) {
        		mMsgHolder.setVisibility(View.GONE);
        	} else {
        		mTvMessage.setText(mMessageText);
        		mMsgHolder.setVisibility(View.VISIBLE);
        	}
        }
        return this;
    }
    
    public SyMessageDialog setProgress(float progress) {
    	mProgress = progress;
    	if (mPwProgress != null) {
    		if (mPwProgress.isSpinning())
    			mPwProgress.stopSpinning();
    		mPwProgress.setProgress(mProgress);
    	}
    	return this;
    }
    
    public SyMessageDialog setCustomView(View view) {
    	mCustomView = view;
    	if (mCustomHolder != null) {
    		mCustomHolder.removeAllViews();
    		if (mCustomView != null) {
    			mCustomHolder.addView(mCustomView);
    			mCustomHolder.setVisibility(View.VISIBLE);
    		} else
    			mCustomHolder.setVisibility(View.GONE);
    	}
    	return this;
    }
    public SyMessageDialog setCustomViewTop(View view) {
    	mCustomViewTop=view;
    	if (mCustom_holderTop != null) {
    		mCustom_holderTop.removeAllViews();
    		if (mCustomViewTop != null) {
    			mCustom_holderTop.addView(mCustomViewTop);
    			mCustom_holderTop.setVisibility(View.VISIBLE);
    		} else
    			mCustom_holderTop.setVisibility(View.GONE);
    	}
    	return this;
    }
    
    private void updateTop() {
    	if (mIvIcon.getVisibility() == View.VISIBLE ||
    			mPwProgress.getVisibility() == View.VISIBLE ||
    			mTvTitle.getVisibility() == View.VISIBLE ||
    			mMsgHolder.getVisibility() == View.VISIBLE)
    		mTopHolder.setVisibility(View.VISIBLE);
    	else
    		mTopHolder.setVisibility(View.GONE);
    }
    
    private void updateButton() {
    	if (!mCreated) return;
    	mBtnCount = 0;

    	if (mNegativeText != null) {
    		mBtnNegative.setText(mNegativeText);
    		mBtnNegative.setVisibility(View.VISIBLE);
    		mBtnCount++;
    	} else {
			mBtnNegative.setVisibility(View.GONE);
		}

    	if (mNeutralText != null) {
    		mBtnNeutral.setText(mNeutralText);
    		mBtnNeutral.setVisibility(View.VISIBLE);
    		mBtnCount++;
    	} else
    		mBtnNeutral.setVisibility(View.GONE);
    	if (mPositiveText != null) {
    		mBtnPositive.setText(mPositiveText);
    		mBtnPositive.setVisibility(View.VISIBLE);
    		mBtnCount++;
    	} else
    		mBtnPositive.setVisibility(View.GONE);
    	if(mLinearPositiveText!=null){
			mBtnLinaerPositive.setText(mLinearPositiveText);
			linearPositive.setVisibility(View.VISIBLE);
			mBtnNegative.setTextColor(Color.rgb(0,121,255));
		}else{
			linearPositive.setVisibility(View.GONE);
		}
		if(showBulleCancle){
			mBtnNegative.setTextColor(Color.rgb(0,121,255));
			div_cancle.setVisibility(View.VISIBLE);
		}else{
			div_cancle.setVisibility(View.GONE);
		}

    	mBtnHolder.setVisibility(mBtnCount > 0 ? View.VISIBLE : View.GONE);
    	
    	if (mBtnCount == 1) {
    		if (mBtnNegative.getVisibility() == View.VISIBLE)
    			mBtnNegative.setBackgroundResource(R.drawable.sy_dialog_button);
    		if (mBtnNeutral.getVisibility() == View.VISIBLE)
    			mBtnNeutral.setBackgroundResource(R.drawable.sy_dialog_button);
    		if (mBtnPositive.getVisibility() == View.VISIBLE)
    			mBtnPositive.setBackgroundResource(R.drawable.sy_dialog_button);
    	} else if (mBtnCount == 2) {
    		if (mBtnNegative.getVisibility() == View.VISIBLE)
    			mBtnNegative.setBackgroundResource(R.drawable.sy_dialog_button_left);
    		if (mBtnNeutral.getVisibility() == View.VISIBLE) {
    			if (mBtnNegative.getVisibility() == View.VISIBLE)
    				mBtnNeutral.setBackgroundResource(R.drawable.sy_dialog_button_right);
    			else
    				mBtnNeutral.setBackgroundResource(R.drawable.sy_dialog_button_left);
    		}
    		if (mBtnPositive.getVisibility() == View.VISIBLE)
    			mBtnPositive.setBackgroundResource(R.drawable.sy_dialog_button_right);
    	}  else if (mBtnCount == 3) {
    		if (mBtnNegative.getVisibility() == View.VISIBLE)
    			mBtnNegative.setBackgroundResource(R.drawable.sy_dialog_button_left);
    		if (mBtnNeutral.getVisibility() == View.VISIBLE)
    			mBtnNeutral.setBackgroundResource(R.drawable.sy_dialog_button_middle);
    		if (mBtnPositive.getVisibility() == View.VISIBLE)
    			mBtnPositive.setBackgroundResource(R.drawable.sy_dialog_button_right);
    	}
    }
    
    public SyMessageDialog setNegativeButton(int textId, OnClickListener listener) {
    	String text = null;
    	if (textId > 0)
    		text = getContext().getResources().getString(textId);
    	return setNegativeButton(text, listener);
    }
	public SyMessageDialog setNegativeButton(String text) {
		mNegativeText = text;
		showBulleCancle=true;
		updateButton();
		return this;
	}
    public SyMessageDialog setNegativeButton(String text, OnClickListener listener) {
    	mNegativeText = text;
    	mNegativeClickListener = listener;
    	updateButton();
    	return this;
    }
    public Button getNegativeButton() {
    	return mBtnNegative;
    }
     

    public SyMessageDialog setNeutralButton(int textId, OnClickListener listener) {
    	String text = null;
    	if (textId > 0)
    		text = getContext().getResources().getString(textId);
    	return setNeutralButton(text, listener);
    }
    
    public SyMessageDialog setNeutralButton(String text, OnClickListener listener) {
    	mNeutralText = text;
    	mNeutralClickListener = listener;
    	updateButton();
    	return this;
    }
    
    public Button getNeutralButton() {
    	return mBtnNeutral;
    }
    
    public SyMessageDialog setPositiveButton(int textId, OnClickListener listener) {
    	String text = null;
    	if (textId > 0)
    		text = getContext().getResources().getString(textId);
    	return setPositiveButton(text, listener);
    }
    
    public SyMessageDialog setPositiveButton(String text, OnClickListener listener) {
    	mPositiveText = text;
    	mPositiveClickListener = listener;
    	updateButton();
    	return this;
    }

	public SyMessageDialog setLinearButton(String text, OnClickListener listener) {
		mLinearPositiveText = text;
		mPositiveClickListener = listener;
		updateButton();
		return this;
	}
    public Button getPositiveButton() {
    	return mBtnPositive;
    }
    
    public boolean isColseable() {
		return mColseable;
	}

	public SyMessageDialog setColseable(boolean colseable) {
		mColseable = colseable;
		return this;
	}

    @Override
    public void onClick(View v) {
        if (v == mBtnNegative) {
            if (mNegativeClickListener != null) {
                mNegativeClickListener.onClick(SyMessageDialog.this);
                if (mColseable)
                	dismissWithAnimation();
            } else {
                dismissWithAnimation();
            }
        } else if (v == mBtnNeutral) {
            if (mNeutralClickListener != null) {
                mNeutralClickListener.onClick(SyMessageDialog.this);
                if (mColseable)
                	dismissWithAnimation();
            } else {
                dismissWithAnimation();
            }
        } else if (v == mBtnPositive) {
            if (mPositiveClickListener != null) {
                mPositiveClickListener.onClick(SyMessageDialog.this);
                if (mColseable)
                	dismissWithAnimation();
            } else {
                dismissWithAnimation();
            }
        } else if (v == mBtnLinaerPositive) {
            if (mPositiveClickListener != null) {
                mPositiveClickListener.onClick(SyMessageDialog.this);
                if (mColseable)
                	dismissWithAnimation();
            } else {
                dismissWithAnimation();
            }
        }
    }

}