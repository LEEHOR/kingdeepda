package com.kingdee.ah.pda.ui.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.util.StringUtil;


/**
 * Author： hengzwd on 2018/6/26.
 * Email：hengzwdhengzwd@qq.com
 */
public class CommodityCountView extends LinearLayout {

    private int count = 0;

    private boolean isCanEditable = true;

    private onCountChangeListener onCountChangeListener;
    ImageView tv_msubduction;
    ImageView tv_addition;
    EditText tv_count;

    public CommodityCountView(Context context) {
        this(context, null);
    }

    public CommodityCountView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommodityCountView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.view_commodity_count, this, true);
        tv_msubduction = view.findViewById(R.id.tv_subduction);
        tv_addition = view.findViewById(R.id.tv_addition);
        tv_count = view.findViewById(R.id.tv_count);
        tv_msubduction.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isCanEditable) {
                    return;
                }
                if (count > 1) {
                    count--;
                    tv_count.setText(String.valueOf(count));
                    if (onCountChangeListener != null) {
                        onCountChangeListener.onCountChange(count);
                    }
                }
            }
        });

        tv_addition.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isCanEditable) {
                    return;
                }
                count++;
                tv_count.setText(String.valueOf(count));
                if (onCountChangeListener != null) {
                    onCountChangeListener.onCountChange(count);
                }
            }
        });
    }


    public void setEditAble(boolean isCanEditable) {
        this.isCanEditable = isCanEditable;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
        tv_count.setText(String.valueOf(count));
        if (onCountChangeListener != null) {
            onCountChangeListener.onCountChange(count);
        }
    }

    public void setOnCountChangeListener(onCountChangeListener countChangeListener) {
        this.onCountChangeListener = countChangeListener;
    }

    public interface onCountChangeListener {
        void onCountChange(int count);
    }
}
