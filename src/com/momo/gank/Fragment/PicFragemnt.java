package com.momo.gank.Fragment;

import java.io.Serializable;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.momo.gank.R;
import com.momo.gank.Activity.OnePicActivity;
import com.momo.gank.Adapter.PicAdapter;
import com.momo.gank.Adapter.PicAdapter.OnItemClickListener;
import com.momo.gank.Entity.PicList;
import com.momo.gank.Presenter.IPicPresenter;
import com.momo.gank.Presenter.Impl.PicpresenterImpl;
import com.momo.gank.View.IPicView;

public class PicFragemnt extends Fragment implements IPicView {
	private PicAdapter picAdapter;
	private IPicPresenter picPresenter;
	private List<PicList> picLists;
	private int n = 1;
	private TextView tvXiala;
	private RecyclerView recyclerView;
	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 1:
				n++;
				picPresenter.addPic(n);
				picAdapter.notifyDataSetChanged();
				break;
			case 2:
				setPiclist();
				break;
			}
		};
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_pic, null);
		// 控件初始化
		setViews(view);
		picPresenter.loadPic(n);
		return view;
	}

	private void setLvpicOnScroll() {
		// 点击放大监听
		picAdapter.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemLongClick(View view, int position) {

			}

			@Override
			public void onItemClick(View view, int position) {
				Intent intent = new Intent(getActivity(), OnePicActivity.class);
				intent.putExtra("picLists", (Serializable) picLists);
				intent.putExtra("position", position);
				startActivity(intent);
			}
		});

		/**
		 * 上啦刷新
		 */
		recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
			@Override
			public void onScrollStateChanged(RecyclerView rView, int newState) {
				super.onScrollStateChanged(rView, newState);
				Log.i("dabao", "一直在移动？？？？" + rView + "555555==" + newState);
			}

			@Override
			public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
				super.onScrolled(recyclerView, dx, dy);
				if (isSlideToBottom(recyclerView)) {
					tvXiala.setVisibility(View.VISIBLE);
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
		});
	}

	/**
	 * 上啦刷新的判断条件
	 * 
	 * @param rView
	 * @return
	 */
	public boolean isSlideToBottom(RecyclerView rView) {
		if (rView == null)
			return false;
		if (rView.computeVerticalScrollExtent()
				+ rView.computeVerticalScrollOffset() >= rView
					.computeVerticalScrollRange())
			return true;
		return false;
	}

	private void setViews(View view) {
		tvXiala = (TextView) view.findViewById(R.id.tvXiala);
		recyclerView = (RecyclerView) view.findViewById(R.id.rv_Pic_List);
		picPresenter = new PicpresenterImpl(this);
	}

	@Override
	public void showPicList(List<PicList> list) {
		picLists = list;
		picAdapter = new PicAdapter(getActivity(), picLists);
		Message msg = new Message();
		msg.what=2;
		handler.sendMessage(msg);
	}

	@Override
	public void updatePicList(List<PicList> list) {
		picLists = list;
		tvXiala.setVisibility(View.GONE);
	}
	
	public void setPiclist(){
		recyclerView.setAdapter(picAdapter);
		StaggeredGridLayoutManager staggeredLayoutManager = new StaggeredGridLayoutManager(
				2, StaggeredGridLayoutManager.VERTICAL);
		recyclerView.setLayoutManager(staggeredLayoutManager);
		// 图片列表监听
		setLvpicOnScroll();
	}
}
