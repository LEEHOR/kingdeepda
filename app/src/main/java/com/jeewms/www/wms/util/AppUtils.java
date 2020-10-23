package com.jeewms.www.wms.util;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.jeewms.www.wms.App;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.util
 * @ClassName: AppUtils
 * @Description: java类作用描述
 *          appUtils获取apk的包名和版本号
 * @Author: 作者名
 * @CreateDate: 2020/10/10 11:52
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/10 11:52
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class AppUtils {
    public static String getAppPackageName() {
       return App.mContext.getPackageName();
    }

    public static String getVersionName() {
        String versionName = "";
        try {
            PackageManager pm = App.mContext.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(getAppPackageName(), 0);
            versionName = pi.versionName;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionName;
    }

    /**
     * get int app version
     */
    public static int getVersionCode() {
        int versioncode = 0;
        try {
            PackageManager pm = App.mContext.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(getAppPackageName(), 0);
            versioncode = pi.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versioncode;
    }

}