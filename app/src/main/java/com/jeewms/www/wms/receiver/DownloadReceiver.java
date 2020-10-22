package com.jeewms.www.wms.receiver;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;

import java.io.File;

/**
 * @ProjectName: kingdeepda
 * @Package: com.jeewms.www.wms.receiver
 * @ClassName: DownloadReceiver
 * @Description: java类作用描述
 * apk更新的广播接收
 * @Author: 作者名
 * @CreateDate: 2020/10/10 11:14
 * @UpdateUser: 更新者：
 * @UpdateDate: 2020/10/10 11:14
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class DownloadReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(intent.getAction())){
            long downloadId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
            if (downloadId == -1){
                return;
            }
            DownloadManager downloadManager = (DownloadManager) context.getApplicationContext().getSystemService(Context.DOWNLOAD_SERVICE);
            Uri uri = downloadManager.getUriForDownloadedFile(downloadId);//获取下载完成文件uri
            if (uri == null){
                return;
            }
            installApk(context, uri);
        }
    }


    /**
     * 安装apk方法
     * @param context
     * @param uri
     */
    private void installApk(Context context, Uri uri) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            File file=new File(uri.toString());
            Uri apkUri = FileProvider.getUriForFile(context, "com.jeewms.www.wms"+".fileprovider", file);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        } else {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(uri, "application/vnd.android.package-archive");

        }
        context.startActivity(intent);
    }

}
