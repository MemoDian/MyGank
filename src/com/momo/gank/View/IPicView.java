package com.momo.gank.View;

import java.util.List;

import com.momo.gank.Entity.PicList;

public interface IPicView extends IView{

	/**
	 * ��ʾͼƬ
	 */
	void showPicList(List<PicList> list);
	
	/**
	 * ��������
	 * @param list ���µļ���
	 */
	void updatePicList(List<PicList> list);
}
