package com.momo.gank.Activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.momo.gank.R;

public class WebpageActivity extends Activity{
	private WebView webView;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webpage);
		Intent intent=getIntent();
		String url=intent.getStringExtra("url");
		
		webView = (WebView) findViewById(R.id.webView);
		WebSettings webSettings = webView.getSettings();  
        //����WebView���ԣ��ܹ�ִ��Javascript�ű�    
        webSettings.setJavaScriptEnabled(true);    
        //���ÿ��Է����ļ�  
        webSettings.setAllowFileAccess(true);  
         //����֧������  
        webSettings.setBuiltInZoomControls(true);  
        //������Ҫ��ʾ����ҳ    
        webView.loadUrl(url);    
        //����Web��ͼ    
        webView.setWebViewClient(new webViewClient ());
	}

    @Override   
    //���û���    
    //����Activity���onKeyDown(int keyCoder,KeyEvent event)����    
    public boolean onKeyDown(int keyCode, KeyEvent event) {    
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {    
            webView.goBack(); //goBack()��ʾ����WebView����һҳ��    
            return true;    
        }    
        finish();//�����˳�����  
        return false;    
    } 
    
    //Web��ͼ    
    private class webViewClient extends WebViewClient {    
        public boolean shouldOverrideUrlLoading(WebView view, String url) {    
            view.loadUrl(url);    
            return true;    
        }    
    }
}
