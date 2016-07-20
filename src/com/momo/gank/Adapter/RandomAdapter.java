package com.momo.gank.Adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.momo.gank.R;
import com.momo.gank.Entity.RandomList;

public class RandomAdapter extends BaseAdapter{
	private Context context;
	private List<RandomList> randomlists;
	private LayoutInflater infalter;

	public RandomAdapter(Context context, List<RandomList> randomlists) {
		super();
		this.context = context;
		this.randomlists = randomlists;
		infalter=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return randomlists.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView==null){
			holder=new ViewHolder();
			convertView = infalter.inflate(R.layout.item_random, null);
			holder.tvType = (TextView) convertView.findViewById(R.id.tvType);
			holder.tvDesc = (TextView) convertView.findViewById(R.id.tvDesc);
			holder.tvWho = (TextView) convertView.findViewById(R.id.tvWho);
			convertView.setTag(holder);
		}
		holder=(ViewHolder) convertView.getTag();
		holder.tvType.setText(randomlists.get(position).getType());
		holder.tvDesc.setText("        "+randomlists.get(position).getDesc());
		holder.tvWho.setText("зїеп:"+randomlists.get(position).getWho());
		return convertView;
	}

	class ViewHolder{
		TextView tvType;
		TextView tvDesc;
		TextView tvWho;
	}
}
