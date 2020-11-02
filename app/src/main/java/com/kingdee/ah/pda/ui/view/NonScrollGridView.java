package com.kingdee.ah.pda.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.ui.view
 * @ClassName: NonScrollGridView
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/27 18:28
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/27 18:28
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class NonScrollGridView extends GridView {
    public NonScrollGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NonScrollGridView(Context context) {
        super(context);
    }

    public NonScrollGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
