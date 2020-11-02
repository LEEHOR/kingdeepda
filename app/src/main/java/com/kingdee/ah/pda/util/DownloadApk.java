package com.kingdee.ah.pda.util;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;

import com.kingdee.ah.pda.R;

import java.io.File;

import static android.content.Context.DOWNLOAD_SERVICE;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.util
 * @ClassName: checkVersion
 * @Description: java类作用描述
 *          apk本地更新
 * @Author: 作者名
 * @CreateDate: 2020/10/10 11:02
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/10 11:02
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class DownloadApk {

    public  static void startDownload(Context context,String downUrl){
        //删除已经存在的apk包
        File apkFile = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), context.getResources().getString(R.string.updateVersion));
        if (apkFile.exists()) {
            apkFile.delete();
        }
        //初始化DownloadManager并开始下载
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downUrl));
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS),context.getResources().getString(R.string.updateVersion));
        request.setTitle(context.getResources().getString(R.string.updateVersion1));//updateVersion1
        request.setDescription(context.getResources().getString(R.string.updateVersion2));//updateVersion2
        request.setDestinationUri(Uri.fromFile(file));
        DownloadManager mDownloadManager = (DownloadManager) context.getSystemService(DOWNLOAD_SERVICE);
        mDownloadManager.enqueue(request);
    }
}
