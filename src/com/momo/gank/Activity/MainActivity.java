package com.momo.gank.Activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.momo.gank.R;
import com.momo.gank.Adapter.FragmentAdapter;
import com.momo.gank.Fragment.PicFragemnt;
import com.momo.gank.Fragment.RandomFragemnt;
import com.momo.gank.Fragment.TextFragemnt;

public class MainActivity extends FragmentActivity {
	private ViewPager vpFragment;
	private RadioGroup rgButton;
	private RadioButton rbText;
	private RadioButton rbPic;
	private RadioButton rbRandom;
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
		//º‡Ã˝
		setOnClick();
	}

	private void setOnClick() {
		rbText.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				vpFragment.setCurrentItem(0);
			}
		});
		rbPic.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				vpFragment.setCurrentItem(1);
			}
		});
		rbRandom.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				vpFragment.setCurrentItem(2);
			}
		});
		
		vpFragment.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				switch (position) {
				case 0:
					rbText.setChecked(true);
					break;
				case 1:
					rbPic.setChecked(true);
					break;
				case 2:
					rbRandom.setChecked(true);
					break;
				default:
					break;
				}
			}
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}
			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}

	private void viewPagerAdapter() {
		fragments = new ArrayList<Fragment>();
		fragments.add(new TextFragemnt());
		fragments.add(new PicFragemnt());
		fragments.add(new RandomFragemnt());
		fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),
				fragments);
		vpFragment.setAdapter(fragmentAdapter);
	}

	private void setViews() {
		vpFragment = (ViewPager) findViewById(R.id.vpFragment);
		rgButton = (RadioGroup) findViewById(R.id.rgButton);
		rbText = (RadioButton) findViewById(R.id.rbText);
		rbPic = (RadioButton) findViewById(R.id.rbPic);
		rbRandom = (RadioButton) findViewById(R.id.rbRandom);
	}
}
