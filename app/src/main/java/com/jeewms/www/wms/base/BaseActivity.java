package com.jeewms.www.wms.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.base
 * @ClassName: BaseActivity1
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/9/28 10:54
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/9/28 10:54
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public abstract class BaseActivity extends Activity {

    private Unbinder bind;

    protected abstract int getContentResId();

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initfun();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(getContentResId());
        bind = ButterKnife.bind(this);
        initView(savedInstanceState);
        initfun();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
