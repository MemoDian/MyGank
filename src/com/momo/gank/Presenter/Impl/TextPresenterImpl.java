package com.momo.gank.Presenter.Impl;

import java.util.List;

import com.momo.gank.Entity.Results;
import com.momo.gank.Model.IModel.CallBack;
import com.momo.gank.Model.ITextModel;
import com.momo.gank.Model.Impl.TextModelImpl;
import com.momo.gank.Presenter.ITextPresenter;
import com.momo.gank.View.ITextView;

public class TextPresenterImpl implements ITextPresenter {
	private ITextModel textModel;
	private ITextView textView;
	
	public TextPresenterImpl(ITextView textView) {
		this.textModel = new TextModelImpl();
		this.textView = textView;
	}

	@Override
	public void ObtainText(int i) {
		textModel.loadTextList(i, new CallBack() {
			@Override
			public void onSuccess(Object success) {
				List<Results> list = (List<Results>) success;
				textView.showText(list);
			}
			@Override
			public void onError(Object error) {
			}
		});
	}

}
