package com.kingdee.ah.pda.volley;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * @ProjectName: kingdeepda
 * @Package: com.kingdee.ah.pda.volley
 * @ClassName: RequestQueueUtil
 * @Description: java类作用描述
 * 单例获取RequestQueue对象
 * @Author: 李浩
 * @CreateDate: 2020/11/6 11:44
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/11/6 11:44
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class RequestQueueUtil {
    private static RequestQueue sRequestQueue;

    public static RequestQueue getRequestQueue(Context context) {
        if (sRequestQueue == null) {
            synchronized (RequestQueue.class) {
                if (sRequestQueue == null) {
                    sRequestQueue = Volley.newRequestQueue(context);
                }
            }
        }
        return sRequestQueue;
    }
}
