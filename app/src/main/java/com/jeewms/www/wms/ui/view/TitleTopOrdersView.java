package com.jeewms.www.wms.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatSpinner;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.jeewms.www.wms.R;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.view
 * @ClassName: TitleTopOrdersView
 * @Description: java类作用描述
 * 新版订单titlebar封装
 * @Author: 作者名
 * @CreateDate: 2020/9/28 10:30
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/9/28 10:30
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class TitleTopOrdersView extends LinearLayout {
    private Context mContext;
    private View inflate;
    private ImageButton btn_back;
    private TextView tex_item,tv_right,tv_right2;
    private ImageButton btn_orders_3;
    private ImageButton btn_orders_2;
    private ImageButton btn_orders_1;
    private Spinner spinner;

    public TitleTopOrdersView(Context context) {
        super(context, null);
        this.mContext = context;
    }

    public TitleTopOrdersView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        LayoutInflater m_inflate = LayoutInflater.from(context);
        inflate = m_inflate.inflate(R.layout.titlebar_top_orders, this, true);
        btn_back = inflate.findViewById(R.id.btn_top_orders_back);
        tex_item = inflate.findViewById(R.id.tex_top_orders_item);
        spinner= inflate.findViewById(R.id.spinner_top_order);
        btn_orders_3 = inflate.findViewById(R.id.btn_top_orders_3);
        btn_orders_2 = inflate.findViewById(R.id.btn_top_orders_2);
        btn_orders_1 = inflate.findViewById(R.id.btn_top_orders_1);
        tv_right=inflate.findViewById(R.id.top_orders_right_tv);
        tv_right2=inflate.findViewById(R.id.top_orders_right_tv2);
    }

    public ImageButton getBtn_back() {
        return btn_back;
    }

    public TextView getTex_item() {
        return tex_item;
    }

    public ImageButton getBtn_orders_3() {
        return btn_orders_3;
    }

    public ImageButton getBtn_orders_2() {
        return btn_orders_2;
    }

    public ImageButton getBtn_orders_1() {
        return btn_orders_1;
    }

    public TextView getTv_right2() {
        return tv_right2;
    }

    public Spinner getSpinner() {
        return spinner;
    }

    public TextView getTv_right() {
        return tv_right;
    }

    public void setViewVisibility(int visible1, int visible2, int visible3, int visible4, int visible5, int visible6,int visible7){
        btn_back.setVisibility(visible1);
        tex_item.setVisibility(visible2);
        spinner.setVisibility(visible3);
        btn_orders_1.setVisibility(visible4);
        btn_orders_2.setVisibility(visible5);
        btn_orders_3.setVisibility(visible6);
        tv_right.setVisibility(visible7);
    }
}
