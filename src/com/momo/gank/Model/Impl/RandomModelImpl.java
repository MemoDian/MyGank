package com.momo.gank.Model.Impl;

import java.util.List;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.momo.gank.App.GankApplication;
import com.momo.gank.Entity.Random;
import com.momo.gank.Entity.RandomList;
import com.momo.gank.Model.IRandomModel;
import com.momo.gank.Util.Url;

public class RandomModelImpl implements IRandomModel{

	@Override
	public void loadRandomList(final CallBack callBack) {
		String url = Url.RANDOM;
		StringRequest request = new StringRequest(url, new Listener<String>() {
			@Override
			public void onResponse(String response) {
				Gson gson=new Gson();
				Random random = gson.fromJson(response, Random.class);
				List<RandomList> randomLists=random.getResults();
				callBack.onSuccess(randomLists);
			}
		}, new ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
			}
		});
		GankApplication.getQueue().add(request);
	}
}
