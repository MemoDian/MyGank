package com.momo.gank.Model;

public interface IPicModel extends IModel {

	/**
	 * ���ͼƬ����
	 * @param n ͼƬ����
	 * @param callBack
	 */
	void loadPicList(int n, CallBack callBack);
	
	/**
	 * ��������
	 * @param n
	 * @param callBack
	 */
	void addPicList(int n,CallBack callBack);
}
