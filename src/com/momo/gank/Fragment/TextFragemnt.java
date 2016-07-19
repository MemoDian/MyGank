package com.momo.gank.Fragment;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.momo.gank.R;
import com.momo.gank.Activity.WebpageActivity;
import com.momo.gank.Adapter.TextAdapter;
import com.momo.gank.Entity.Results;
import com.momo.gank.Presenter.ITextPresenter;
import com.momo.gank.Presenter.Impl.TextPresenterImpl;
import com.momo.gank.View.ITextView;

public class TextFragemnt extends Fragment implements ITextView {
	private ListView lvText;
	private int i=1;
	private ITextPresenter textPresenter;
	private TextAdapter textAdapter;
	private Button btnLast;
	private Button btnNext;
	private List<Results> lists;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_text, null);
		//��ʼ��
		setViews(view);
		//������ũ�����б�
		deTextList(i);
		//��ť����
		setOnClicks();
		//�ı��б����
		setTextList();
		return view;
	}

	private void setTextList() {
		lvText.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				Intent intent=new Intent(getActivity(), WebpageActivity.class);
				intent.putExtra("url", lists.get(position).getUrl());
				startActivity(intent);
			}
		});
	}

	private void setOnClicks() {
		btnLast.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(i!=1){
					i=i-1;
					deTextList(i);
				}
			}
		});
		btnNext.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
					i=i+1;
					deTextList(i);
			}
		});
	}

	private void deTextList(int k) {
		textPresenter.ObtainText(k);
	}

	private void setViews(View view) {
		lvText = (ListView) view.findViewById(R.id.lvText);
		textPresenter = new TextPresenterImpl(this);
		btnNext = (Button) view.findViewById(R.id.btnNext);
		btnLast = (Button) view.findViewById(R.id.btnLast);
	}

	@Override
	public void showText(List<Results> lists) {
		this.lists=lists;
		textAdapter = new TextAdapter(getActivity(), lists);
		lvText.setAdapter(textAdapter);
	}
}
