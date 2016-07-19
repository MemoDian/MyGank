package com.momo.gank.Presenter.Impl;

import java.util.List;

import com.momo.gank.Entity.PicList;
import com.momo.gank.Model.IModel.CallBack;
import com.momo.gank.Model.IPicModel;
import com.momo.gank.Model.Impl.PicModelImpl;
import com.momo.gank.Presenter.IPicPresenter;
import com.momo.gank.View.IPicView;

public class PicpresenterImpl implements IPicPresenter{
	private IPicView iPicView;
	private IPicModel iPicModel;
	private List<PicList> list;
	
	public PicpresenterImpl(IPicView iPicView) {
		this.iPicView=iPicView;
		this.iPicModel=new PicModelImpl();
	}

	@Override
	public void loadPic(int n) {
		iPicModel.loadPicList(n, new CallBack() {
			@Override
			public void onSuccess(Object success) {
				list =(List<PicList>) success;
				iPicView.showPicList(list);
			}
			@Override
			public void onError(Object error) {
			}
		});
	}

	@Override
	public void addPic(int n) {
		iPicModel.addPicList(n, new CallBack() {
			@Override
			public void onSuccess(Object success) {
				list=(List<PicList>) success;
				iPicView.updatePicList(list);
			}
			@Override
			public void onError(Object error) {
			}
		});
	}
}
