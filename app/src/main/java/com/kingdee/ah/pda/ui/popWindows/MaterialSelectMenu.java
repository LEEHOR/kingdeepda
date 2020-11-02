package com.kingdee.ah.pda.ui.popWindows;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import com.ajguan.library.EasyRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kingdee.ah.pda.R;
import com.kingdee.ah.pda.dataBase.BdMaterial;
import com.kingdee.ah.pda.util.LitepalSelect;
import com.kingdee.ah.pda.util.LocalDisplay;
import com.kingdee.ah.pda.util.decoration.SpacesItemDecoration;

import java.util.List;


/**
 * 自定义popwindows
 */
public class MaterialSelectMenu {


    MaterialAdapter materialAdapter;

    private View contentView;

    private RecyclerView recyclerView;
    private EasyRefreshLayout refreshLayout;

    private PopupWindow mPopupWindow;

    private static final int DEFAULT_HEIGHT = RecyclerView.LayoutParams.WRAP_CONTENT;

    private int popHeight = DEFAULT_HEIGHT;

    private static final int DEFAULT_ANIM_STYLE = R.style.pop_animation;

    private OnStateChangeListener onStateChangeListener;

    //private OnMenuItemClickListener onMenuItemClickListener;

    private Context mcontext;

    private LinearLayoutManager linearLayoutManager;

    private boolean isMenuOpen;
    private int OFFSET=0;
    public MaterialSelectMenu(Activity context) {
        mcontext = context;
        init();
    }

    private void init() {
        contentView = LayoutInflater.from(mcontext).inflate(R.layout.commodity_layout, null);
        refreshLayout= contentView.findViewById(R.id.refresh);
        recyclerView = contentView.findViewById(R.id.commodityMenu_recycler);
        linearLayoutManager = new LinearLayoutManager(mcontext);
        recyclerView.setLayoutManager(linearLayoutManager);
        materialAdapter =new MaterialAdapter(mcontext);
        recyclerView.setAdapter(materialAdapter);
        recyclerView.addItemDecoration(new SpacesItemDecoration(LocalDisplay.designedDP2px(0), LocalDisplay.designedDP2px(3), mcontext.getResources().getColor(R.color.actions_background_light)));

        materialAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                materialAdapter.setSelectedPosition(position);
                materialAdapter.notifyDataSetChanged();
               BdMaterial bdMaterial= (BdMaterial) adapter.getItem(position);
                if (onStateChangeListener != null) {
                    onStateChangeListener.onSelect(bdMaterial.getFname(),bdMaterial.getFnumber());
                }
            }
        });
        initfun();
        getPopupWindow();
    }

    private void initfun(){
        getBdStock(0);
        refreshLayout.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {
                getBdStock(1);
            }

            @Override
            public void onRefreshing() {
                getBdStock(0);
            }
        });
    }
    //获取计量单位
    private void getBdStock(final int type) {
        if (type==0) {
            this.OFFSET=0;
            materialAdapter.getData().clear();
            materialAdapter.notifyDataSetChanged();
        }
        List<BdMaterial> byAll = LitepalSelect.findByAll(BdMaterial.class, OFFSET);
        BdMaterial bdMaterial=new BdMaterial();
        bdMaterial.setFname("全部");
        if (byAll != null) {
            OFFSET+=10;
            if (type==0){
                byAll.add(0,bdMaterial);
                materialAdapter.setData(byAll, type);
                refreshLayout.refreshComplete();
            } else {
                refreshLayout.loadMoreComplete();
                if (byAll.size() > 0) {
                    materialAdapter.setData(byAll, type);
                }
            }
        } else {
            if (type==0){
                refreshLayout.refreshComplete();
            } else {
                refreshLayout.loadMoreComplete();
            }
        }

    }
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
                if (onStateChangeListener != null) {
                    onStateChangeListener.ondismiss();
                }
                isMenuOpen = false;
            }
        });
        return mPopupWindow;
    }


    public void showAsDropDown(View anchor) {//以类似dropdown形式展示
        if (mPopupWindow != null && !mPopupWindow.isShowing()) {
            int bottom = anchor.getBottom();
            //获取屏幕高度
            int screenHeight = LocalDisplay.getScreenHeight(mcontext);
            int maxHeight = screenHeight-bottom;
            mPopupWindow.setHeight(maxHeight);
            mPopupWindow.update();
            if (onStateChangeListener != null) {
                onStateChangeListener.onSpread();
            }
            //往下偏移
            mPopupWindow.showAtLocation(anchor, Gravity.BOTTOM, 0, 0);
            isMenuOpen = true;
        }
    }


    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        this.onStateChangeListener = onStateChangeListener;
    }

    public boolean isMenuOpen() {
        return isMenuOpen;
    }

    public void dismiss() {
        if (isMenuOpen) {
            mPopupWindow.dismiss();
        }
    }

}
