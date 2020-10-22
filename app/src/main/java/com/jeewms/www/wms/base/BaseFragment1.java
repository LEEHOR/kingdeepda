package com.jeewms.www.wms.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.base
 * @ClassName: BaseFragment1
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/9/28 11:30
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/9/28 11:30
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public abstract class BaseFragment1 extends Fragment {

    private View mRootView;
    private Unbinder bind;

    protected abstract int getLayoutId();

    protected abstract void initView();

    /*** 初始化数据以及其他请求操作 ***/
    protected abstract void initFunc();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflaterView(inflater,container);
        bind = ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initFunc();
    }

    /**
     * 设置View
     *
     * @param inflater
     * @param container
     */
    private void inflaterView(LayoutInflater inflater, @Nullable ViewGroup container) {
        if (mRootView == null) {
            mRootView = inflater.inflate(getLayoutId(), container, false);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }
}
