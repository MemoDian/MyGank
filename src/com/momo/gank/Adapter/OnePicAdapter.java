package com.momo.gank.Adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.momo.gank.R;
import com.momo.gank.Entity.PicList;

public class OnePicAdapter extends BaseAdapter{
	private Context context;
	private List<PicList> picLists;
	private LayoutInflater inflater;
	
	public OnePicAdapter(Context context, List<PicList> picLists) {
		super();
		this.context = context;
		this.picLists = picLists;
		inflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return picLists.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView==null){
			holder=new ViewHolder();
			convertView=inflater.inflate(R.layout.item_one_pic, null);
			holder.ivOnePic=(ImageView) convertView.findViewById(R.id.ivOnePic);
			convertView.setTag(holder);
		}
		holder=(ViewHolder) convertView.getTag();
		String url=picLists.get(position).getUrl();
		Glide.with(context).load(url).into(holder.ivOnePic);
		return convertView;
	}

	class ViewHolder{
		ImageView ivOnePic;
	}
}
