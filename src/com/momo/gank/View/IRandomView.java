package com.momo.gank.View;

import java.util.List;

import com.momo.gank.Entity.RandomList;

public interface IRandomView {
	
	/**
	 * 显示随机文本列表
	 * @param randomLists
	 */
	void showRandomList(List<RandomList> randomLists);
}
