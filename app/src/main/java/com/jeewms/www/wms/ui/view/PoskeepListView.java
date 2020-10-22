package com.jeewms.www.wms.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by 13799 on 2018/6/7.
 * 保持光标
 */

public class PoskeepListView extends ListView

{

    public PoskeepListView(Context context)

    {

        super(context);

    }



    public PoskeepListView(Context context, AttributeSet attrs)

    {

        super(context, attrs);

    }



    public PoskeepListView(Context context, AttributeSet attrs, int defStyle)

    {
        super(context, attrs, defStyle);


    }



    @Override

    protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld)

    {

        super.onSizeChanged(xNew, yNew, xOld, yOld);



        setSelection(getCount());

    }

}
