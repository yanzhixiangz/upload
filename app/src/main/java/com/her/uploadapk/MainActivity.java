package com.her.uploadapk;

import androidx.appcompat.app.AppCompatActivity;

import com.her.uploadapk.DownloadManager;
import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private boolean isForce = true;
    private DownloadManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean finalIsForce = isForce;
//        /*
//         * 整个库允许配置的内容
//         * 非必选
//         */
//
        UpdateConfiguration configuration = new UpdateConfiguration()
                //输出错误日志
                .setEnableLog(true)
                //设置自定义的下载
                //.setHttpManager()
                //下载完成自动跳动安装页面
                .setJumpInstallPage(false)
                //设置对话框背景图片 (图片规范参照demo中的示例图)
                //.setDialogImage(R.mipmap.ic_logo)
                //设置按钮的颜色
                //.setDialogButtonColor(Color.parseColor("#E743DA"))
                //设置对话框强制更新时进度条和文字的颜色
                .setDialogProgressBarColor(Color.parseColor("#E743DA"))
                //设置按钮的文字颜色
                .setDialogButtonTextColor(Color.WHITE)
                //设置是否显示通知栏进度
                .setShowNotification(true)
                //设置是否提示后台下载toast
                .setShowBgdToast(false)
                //设置强制更新
                .setForcedUpgrade(isForce);

        manager = DownloadManager.getInstance(this);
        manager.setApkName("app.apk")
                .setApkUrl("https://app.dingshengjituan.cn/apk/app-release.apk")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setShowNewerToast(true)
                .setConfiguration(configuration)
                .setApkVersionCode(Integer.parseInt(2+""))
                .setApkVersionName("1.0.0")
                .setApkSize("40.17")
                .setApkDescription("上线")
                .download();

    }
}