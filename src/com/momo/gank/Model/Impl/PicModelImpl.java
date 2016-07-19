package com.momo.gank.Model.Impl;

import java.util.List;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.momo.gank.App.GankApplication;
import com.momo.gank.Entity.Pic;
import com.momo.gank.Entity.PicList;
import com.momo.gank.Model.IPicModel;
import com.momo.gank.Util.Url;

public class PicModelImpl implements IPicModel {
	private List<PicList> picLists;

	@Override
	public void loadPicList(int n, final CallBack callBack) {
		String url = Url.PIC_URL+n;
		StringRequest request = new StringRequest(url, new Listener<String>() {
			@Override
			public void onResponse(String response) {
				Gson gson = new Gson();
				Pic pic = gson.fromJson(response, Pic.class);
				picLists = pic.getResults();
				callBack.onSuccess(picLists);
			}
		}, new ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
			}
		});
		GankApplication.getQueue().add(request);
	}

	@Override
	public void addPicList(int n, final CallBack callBack) {
		String url = Url.PIC_URL+n;
		StringRequest request = new StringRequest(url, new Listener<String>() {
			@Override
			public void onResponse(String response) {
				Gson gson = new Gson();
				Pic pic = gson.fromJson(response, Pic.class);
				List<PicList> list=pic.getResults();
				for(int i=0;i<list.size();i++){
					picLists.add(list.get(i));
				}
				callBack.onSuccess(picLists);
			}
		}, new ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
			}
		});
		GankApplication.getQueue().add(request);
	}
}
