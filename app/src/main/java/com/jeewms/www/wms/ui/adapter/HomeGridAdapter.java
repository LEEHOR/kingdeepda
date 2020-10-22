package com.jeewms.www.wms.ui.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.jeewms.www.wms.bean.HomeBtnBean;
import com.jeewms.www.wms.ui.itemview.HomeGridItemView;

import java.util.ArrayList;

/**
 * Created by 13799 on 2018/6/2.
 */

public class HomeGridAdapter extends BaseAdapter{

    ArrayList<HomeBtnBean> list=new ArrayList<>();

    public void setList(ArrayList<HomeBtnBean> list){
        this.list=list;
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
        HomeGridItemView itemView=null;
        if(view==null){
            itemView=new HomeGridItemView((Activity) viewGroup.getContext());
            view=itemView.getView();
            view.setTag(itemView);
        }else{
            itemView= (HomeGridItemView) view.getTag();
        }
        itemView.bindView(list.get(i));

        return view;
    }
}
