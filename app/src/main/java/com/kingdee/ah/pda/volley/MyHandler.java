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
public class MyHandler extends Handler {
    WeakReference<OnReceiveMessageListener> reference;


    public MyHandler( OnReceiveMessageListener listener) {
        reference = new WeakReference<>(listener);
    }

    @Override
    public void handleMessage(Message msg) {
      //  Logutil.print(msg.what+"/"+msg.obj.toString());
        if (reference != null && reference.get() != null) {
            switch (msg.what) {
                case NetworkUtil.SUCCESS:
                    reference.get().Success(msg);
                    break;
                case NetworkUtil.FAILURE:
                    reference.get().Failure(msg.arg1);
                    break;
                default:
                    reference.get().Complete(msg.what);
                    break;
            }

        }
    }

    public interface OnReceiveMessageListener {
        void Success(Message message);

        void Failure(int arg);

        void Complete(int arg);
    }

}
