package com.momo.gank.Adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.momo.gank.R;
import com.momo.gank.Entity.Results;
import com.momo.gank.Util.Share;

public class TextAdapter extends BaseAdapter {
	private Context context;
	private List<Results> list;
	private LayoutInflater inflater;
	
	public TextAdapter(Context context, List<Results> list) {
		super();
		this.context = context;
		this.list = list;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return list.size();
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
	public View getView(final int position, View convertView, ViewGroup parent) {
		viewHolder holder = null;
		if(convertView==null){
			convertView = inflater.inflate(R.layout.item_text, null);
			holder = new viewHolder();
			holder.tvAuthor = (TextView) convertView.findViewById(R.id.tvAuthor);
			holder.tvContent = (TextView) convertView.findViewById(R.id.tvContent);
			holder.btnShare = (Button) convertView.findViewById(R.id.btnShare);
			convertView.setTag(holder);
		}
		holder = (viewHolder) convertView.getTag();
		holder.tvAuthor.setText(list.get(position).getWho());
		holder.tvContent.setText("        "+list.get(position).getDesc());
		holder.btnShare.setTag("btnShare"+position);
		holder.btnShare.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Results results = list.get(position);
				Share.shareMsg(context, results.getWho(), results.getDesc(), results.getUrl(), null);
			}
		});
		return convertView;
	}

	class viewHolder{
		TextView tvAuthor;
		TextView tvContent;
		Button btnShare;
	}
}
