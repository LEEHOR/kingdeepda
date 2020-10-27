package com.jeewms.www.wms.ui.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.jeewms.www.wms.bean.HomeBtnBean;
import com.jeewms.www.wms.ui.itemview.HomeGridItemView1;

import java.util.ArrayList;

/**
 * Created by 13799 on 2018/6/2.
 */

public class HomeGridAdapter1 extends BaseAdapter{

    ArrayList<HomeBtnBean> list=new ArrayList<>();
    private int mType;
    public void setList(ArrayList<HomeBtnBean> list,int type){
        this.list=list;
        this.mType=type;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        HomeGridItemView1 itemView=null;
        if(view==null){
            itemView=new HomeGridItemView1((Activity) viewGroup.getContext());
            view=itemView.getView();
            view.setTag(itemView);
        }else{
            itemView= (HomeGridItemView1) view.getTag();
        }
        itemView.bindView(list.get(i),mType);

        return view;
    }
}
