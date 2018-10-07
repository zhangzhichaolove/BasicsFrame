package com.peak.chao.basicsframe.simple.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import static android.view.KeyEvent.KEYCODE_BACK;

/**
 * Created by Chao  2018/3/15 on 15:13
 * description
 */

public class WebActivity extends Activity {
    private WebView web;
    public static final String WEB_URL = "url";
    public static final String APP_CACAHE_DIRNAME = "webCache";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        web = new WebView(getApplicationContext());
        setContentView(web);
        WebSettings webSettings = web.getSettings();
        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);

        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
        if (isNetAvailable(this)) {
            webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);//根据cache-control决定是否从网络上取数据。
        } else {
            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);//没网，则从本地获取，即离线加载
        }
        webSettings.setDomStorageEnabled(true); // 开启 DOM storage API 功能
        webSettings.setDatabaseEnabled(true);  //开启 database storage API 功能
        webSettings.setAppCacheEnabled(true);//开启 Application Caches 功能

        String cacheDirPath = getFilesDir().getAbsolutePath() + APP_CACAHE_DIRNAME;
        webSettings.setAppCachePath(cacheDirPath); //设置  Application Caches 缓存目录

        web.addJavascriptInterface(new AndroidtoJs(), "android");

        web.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                return true;
            }

            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                String url = request.getUrl().toString();
                if (url.startsWith("http:") || url.startsWith("https:")) {
                    view.loadUrl(url);
                } else {
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
        });


        String url = getIntent().getStringExtra("url");
        if (!TextUtils.isEmpty(url)) {
            web.loadUrl(url);
        }
    }

    private Boolean isNetAvailable(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        return info != null && info.isAvailable();
    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KEYCODE_BACK && web.canGoBack()) {
            web.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void onDestroy() {
        super.onDestroy();
        //清除网页访问留下的缓存 由于内核缓存是全局的因此这个方法不仅仅针对webview而是针对整个应用程序.
        //web!!.clearCache(true)

        //清除当前webview访问的历史记录 只会webview访问历史记录里的所有记录除了当前访问记录
        //web!!.clearHistory()

        //这个api仅仅清除自动完成填充的表单数据，并不会清除WebView存储到本地的数据
        web.clearFormData();
        web = null;
    }

    // 继承自Object类
    class AndroidtoJs {
        @JavascriptInterface
        void gotoGoods() {
            Toast.makeText(getBaseContext(), "前端调用了方法", Toast.LENGTH_LONG).show();
        }
    }
}
