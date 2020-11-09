package com.kingdee.ah.pda.base;

import android.app.Dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kingdee.ah.pda.App;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.base
 * @ClassName: BaseDailogFragment
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/10/9 10:14
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/9 10:14
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public abstract class BaseDialogFragment extends AppCompatDialogFragment {
    private Unbinder bind;
    private View rootview;

    protected abstract int getLayoutId();

    protected abstract void initView();

    /*** 初始化数据以及其他请求操作 ***/
    protected abstract void initFunc();

    public abstract void initAnimate();

    public abstract void iniWidow(Dialog dialog);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(getLayoutId(), container, false);
        bind = ButterKnife.bind(this, rootview);
        initView();
        initFunc();
      //  return super.onCreateView(inflater, container, savedInstanceState);
        return rootview;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        iniWidow(getDialog());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }
}
