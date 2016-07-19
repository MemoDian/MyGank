package com.momo.gank.Adapter;

import java.util.ArrayList;
import java.util.List;

import com.bumptech.glide.Glide;
import com.momo.gank.R;
import com.momo.gank.Entity.PicList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

public class PicAdapter extends RecyclerView.Adapter<PicAdapter.MyViewHolder> {
	private Context context;
	private List<PicList> picList;
	private LayoutInflater inflater;
	private List<Integer> heights;

	public interface OnItemClickListener {
		void onItemClick(View view, int position);

		void onItemLongClick(View view, int position);
	}

	private OnItemClickListener listener;

	public void setOnItemClickListener(OnItemClickListener listener) {
		this.listener = listener;
	}

	public PicAdapter(Context context, List<PicList> picList) {
		super();
		this.context = context;
		this.picList = picList;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getItemCount() {
		return picList.size();
	}

	@Override
	public void onBindViewHolder(final MyViewHolder holderView,
			final int position) {
		LayoutParams lp = holderView.itemView.getLayoutParams();
		lp.height = heights.get(position);
		String time = picList.get(position).getPublishedAt();
		time = time.split("T")[0];
		holderView.tv.setText(time);
		String url = picList.get(position).getUrl();
		Glide.with(context).load(url).into(holderView.iv);
		if (listener != null) {

			holderView.itemView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					listener.onItemClick(holderView.itemView, position);
				}
			});

			holderView.itemView
					.setOnLongClickListener(new OnLongClickListener() {

						@Override
						public boolean onLongClick(View v) {
							listener.onItemClick(holderView.itemView, position);
							return false;
						}
					});
		}
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
		View view = inflater.inflate(R.layout.item_pic, arg0, false);
		MyViewHolder viewHolder = new MyViewHolder(view);
		heights = new ArrayList<Integer>();
		for (int i = 0; i < picList.size(); i++) {
			heights.add((int) (500 + Math.random() * 400));
		}
		return viewHolder;
	}

	class MyViewHolder extends ViewHolder {
		ImageView iv;
		TextView tv;

		public MyViewHolder(View itemView) {
			super(itemView);
			iv = (ImageView) itemView.findViewById(R.id.ivPic);
			tv = (TextView) itemView.findViewById(R.id.tvTime);
		}
	}
}
