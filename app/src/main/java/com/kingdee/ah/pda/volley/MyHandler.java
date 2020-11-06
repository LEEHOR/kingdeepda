package com.kingdee.ah.pda.volley;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import com.kingdee.ah.pda.ui.activity.materialList.MaterialListActivity;
import com.kingdee.ah.pda.util.Logutil;

import java.lang.ref.WeakReference;

/**
 * @ProjectName: kingdeepda
 * @Package: com.kingdee.ah.pda.volley
 * @ClassName: MyHandler
 * @Description: java类作用描述
 * @Author: 李浩
 * @CreateDate: 2020/11/6 11:46
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/11/6 11:46
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class MyHandler<T> extends Handler {
    WeakReference<OnReceiveMessageListener> reference;
    WeakReference<T> activityWeakReference;

    public MyHandler(T activity, OnReceiveMessageListener listener) {
        reference = new WeakReference<>(listener);
        activityWeakReference = new WeakReference<>(activity);
    }

    @Override
    public void handleMessage(Message msg) {
        if (activityWeakReference != null && activityWeakReference.get() != null &&
                reference != null && reference.get() != null) {
            Logutil.print(activityWeakReference.get().toString());
            switch (msg.what) {
                case NetworkUtil.SUCCESS:
                    reference.get().Success(msg);
                    break;
                case NetworkUtil.FAILURE:
                    reference.get().Failure();
                    break;
                case NetworkUtil.COMPLETE:
                    reference.get().Complete();
                    break;
            }

        }
    }

    public interface OnReceiveMessageListener {
        void Success(Message message);

        void Failure();

        void Complete();
    }

}
