package com.momo.gank.App;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class GankApplication extends Application{
	private static RequestQueue mQueue;
	private static GankApplication app;
	
	public void onCreate() {
		mQueue = Volley.newRequestQueue(this);
		app = this;
	}
	
	public static RequestQueue getQueue(){
		return mQueue;
	}
	
	public static GankApplication getApp(){
		return app;
	}
}
