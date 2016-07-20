package com.momo.gank.Presenter.Impl;

import java.util.List;

import com.momo.gank.Entity.RandomList;
import com.momo.gank.Model.IModel.CallBack;
import com.momo.gank.Model.IRandomModel;
import com.momo.gank.Model.Impl.RandomModelImpl;
import com.momo.gank.Presenter.IRandomPresenter;
import com.momo.gank.View.IRandomView;

public class RandomPresenterImpl implements IRandomPresenter{
	private IRandomView iRandomView;
	private IRandomModel irandomModel;

	public RandomPresenterImpl(IRandomView iRandomView) {
		this.irandomModel=new RandomModelImpl();
		this.iRandomView=iRandomView;
	}
	
	@Override
	public void loadRandomList() {
		irandomModel.loadRandomList(new CallBack() {
			@Override
			public void onSuccess(Object success) {
				List<RandomList> randomLists=(List<RandomList>) success;
				iRandomView.showRandomList(randomLists);
			}
			@Override
			public void onError(Object error) {
			}
		});
	}
}
