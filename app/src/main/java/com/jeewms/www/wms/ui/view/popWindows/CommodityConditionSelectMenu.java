package com.jeewms.www.wms.ui.view.popWindows;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeewms.www.wms.R;
import com.jeewms.www.wms.bean.StockClass;
import com.jeewms.www.wms.util.LocalDisplay;
import com.jeewms.www.wms.util.Logutil;

import java.util.List;



/**
 * 自定义popwindows
 */
public class CommodityConditionSelectMenu {


    ConditionAdapter conditionAdapter;

    private View contentView;

    private RecyclerView recyclerView;

    private PopupWindow mPopupWindow;

    private static final int DEFAULT_HEIGHT = RecyclerView.LayoutParams.WRAP_CONTENT;

    private int popHeight = DEFAULT_HEIGHT;

    private static final int DEFAULT_ANIM_STYLE = R.style.pop_animation;

    private OnStateChangeListener onStateChangeListener;

    //private OnMenuItemClickListener onMenuItemClickListener;

    private Context mcontext;

    private LinearLayoutManager linearLayoutManager;

    private boolean isMenuOpen;

    public CommodityConditionSelectMenu(Activity context) {
        mcontext = context;
        init();
    }

    private void init() {
        contentView = LayoutInflater.from(mcontext).inflate(R.layout.commodity_layout, null);
        recyclerView = contentView.findViewById(R.id.commodityMenu_recycler);
        linearLayoutManager = new LinearLayoutManager(mcontext);
        recyclerView.setLayoutManager(linearLayoutManager);
        conditionAdapter=new ConditionAdapter();
        recyclerView.setAdapter(conditionAdapter);
        getPopupWindow();
    }

    public CommodityConditionSelectMenu setContentList(List<StockClass.StockEntity> list, int selectedPosition) {
        conditionAdapter.setData(list,selectedPosition);
        return this;
    }


    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    private PopupWindow getPopupWindow() {
        popHeight= (int) mcontext.getResources().getDimension(R.dimen.condition_popuwindow_height);
        mPopupWindow = new PopupWindow(mcontext);
        mPopupWindow.setContentView(contentView);
        mPopupWindow.setWidth(LocalDisplay.getScreenWidth(mcontext));
        mPopupWindow.setHeight(popHeight);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mPopupWindow.setElevation(3.0f);
        }
        mPopupWindow.setAnimationStyle(DEFAULT_ANIM_STYLE);
        mPopupWindow.setFocusable(true);//外部view在popuwindow show的时候能响应事件
        mPopupWindow.setOutsideTouchable(true);
        ColorDrawable dw = new ColorDrawable(mcontext.getResources().getColor(R.color.transparent));
        mPopupWindow.setBackgroundDrawable(dw);
        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                onStateChangeListener.ondismiss();
                isMenuOpen = false;
            }
        });
        return mPopupWindow;
    }


    public void showAsDropDown(View anchor) {//以类似dropdown形式展示
        if (mPopupWindow != null && !mPopupWindow.isShowing()) {
            int[] location = new int[2];
            anchor.getLocationOnScreen(location);
            int y = location[1];
            //获取屏幕高度
            int maxHeight = LocalDisplay.getScreenHeight(mcontext) -y-anchor.getBottom();
            Logutil.print("高度",LocalDisplay.getScreenHeight(mcontext)+"::"+y+"::"+maxHeight);
            mPopupWindow.setHeight(maxHeight);
            mPopupWindow.update();
            //往下偏移
            mPopupWindow.showAsDropDown(anchor, 0, anchor.getBottom());
            onStateChangeListener.onSpread();
            isMenuOpen = true;
        }
    }


    public CommodityConditionSelectMenu setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        this.onStateChangeListener = onStateChangeListener;
        return this;
    }


    public boolean isMenuOpen() {
        return isMenuOpen;
    }

    public void dismiss() {
        if (isMenuOpen) {
            mPopupWindow.dismiss();
        }
    }

    public CommodityConditionSelectMenu setOnMenuItemClickListener(final OnMenuItemClickListener listener) {
        conditionAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                StockClass.StockEntity stockEntity= (StockClass.StockEntity) adapter.getData().get(position);
                listener.onMenuItemClick(stockEntity,position);
            }
        });
        return this;
    }



}
