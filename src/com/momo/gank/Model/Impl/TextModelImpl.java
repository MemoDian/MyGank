package com.momo.gank.Model.Impl;

import java.util.List;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.momo.gank.App.GankApplication;
import com.momo.gank.Entity.Results;
import com.momo.gank.Entity.Text;
import com.momo.gank.Model.ITextModel;
import com.momo.gank.Util.Url;

public class TextModelImpl implements ITextModel {

	@Override
	public void loadTextList(int i, final CallBack callBack) {
		String url = Url.TEXT_URL + i;
		StringRequest request = new StringRequest(url, new Listener<String>() {
			@Override
			public void onResponse(String response) {
				Gson gson = new Gson();
				Text text = gson.fromJson(response, Text.class);
				List<Results> list = text.getResults();
				callBack.onSuccess(list);
			}
		}, new ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
			}
		});
		GankApplication.getQueue().add(request);
	}

}
