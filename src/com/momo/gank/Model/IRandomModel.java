package com.momo.gank.Model;

public interface IRandomModel extends IModel{

	/**
	 * 加载随机数据
	 * @param callBack
	 */
	void loadRandomList(CallBack callBack);
}
