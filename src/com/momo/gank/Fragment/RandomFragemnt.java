package com.momo.gank.Fragment;

import java.util.List;

import com.momo.gank.R;
import com.momo.gank.Activity.WebpageActivity;
import com.momo.gank.Adapter.RandomAdapter;
import com.momo.gank.Entity.RandomList;
import com.momo.gank.Presenter.IRandomPresenter;
import com.momo.gank.Presenter.Impl.RandomPresenterImpl;
import com.momo.gank.View.IRandomView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class RandomFragemnt extends Fragment implements IRandomView{
	private ListView lvRandom;
	private IRandomPresenter iRandomPresenter;
	private RandomAdapter randomAdapter;
	private TextView tvTitle;
	private List<RandomList> randomLists;
	private Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 1:
				tvTitle.setVisibility(View.GONE);
				iRandomPresenter.loadRandomList();
				randomAdapter.notifyDataSetChanged();
				break;
			default:
				break;
			}
		};
	};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_random, null);
		
		initViews(view);
		
		setListClick();
		
		return view;
	}
	
	

	private void setListClick() {
		lvRandom.setOnScrollListener(new OnScrollListener() {
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				if(scrollState==SCROLL_STATE_IDLE){
					if(lvRandom.getFirstVisiblePosition()==0){
						tvTitle.setVisibility(View.VISIBLE);
						new Thread(new Runnable() {
							public void run() {
								try {
									Thread.sleep(3000);
									Message msg = new Message();
									msg.what=1;
									handler.sendMessage(msg);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}).start();
					}
				}
			}
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
			}
		});
		
		lvRandom.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				Intent intent=new Intent(getActivity(), WebpageActivity.class);
				intent.putExtra("url", randomLists.get(position).getUrl());
				startActivity(intent);
			}
		});
	}

	private void initViews(View view) {
		lvRandom = (ListView) view.findViewById(R.id.lvRandom);
		tvTitle = (TextView) view.findViewById(R.id.tvTitle);
		iRandomPresenter=new RandomPresenterImpl(this);
		iRandomPresenter.loadRandomList();
	}

	@Override
	public void showRandomList(List<RandomList> randomLists) {
		this.randomLists=randomLists;
		randomAdapter=new RandomAdapter(getActivity(), randomLists);
		lvRandom.setAdapter(randomAdapter);
	}
}
