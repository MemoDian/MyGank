package com.momo.gank.Activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.momo.gank.R;
import com.momo.gank.Adapter.FragmentAdapter;
import com.momo.gank.Fragment.PicFragemnt;
import com.momo.gank.Fragment.TextFragemnt;

public class MainActivity extends FragmentActivity {
	private ViewPager vpFragment;
	private RadioGroup rgButton;
	private RadioButton rbText;
	private RadioButton rbPic;
	private List<Fragment> fragments;
	private FragmentAdapter fragmentAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// ≥ı ºªØ
		setViews();
		// viewPager  ≈‰
		viewPagerAdapter();
	}

	private void viewPagerAdapter() {
		fragments = new ArrayList<Fragment>();
		fragments.add(new TextFragemnt());
		fragments.add(new PicFragemnt());
		fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),
				fragments);
		vpFragment.setAdapter(fragmentAdapter);
	}

	private void setViews() {
		vpFragment = (ViewPager) findViewById(R.id.vpFragment);
		rgButton = (RadioGroup) findViewById(R.id.rgButton);
		rbText = (RadioButton) findViewById(R.id.rbText);
		rbPic = (RadioButton) findViewById(R.id.rbPic);
	}
}
