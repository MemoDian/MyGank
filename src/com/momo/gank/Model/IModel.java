package com.momo.gank.Model;

public interface IModel {

	public interface CallBack{
		/**
		 * �ɹ�
		 * @param success
		 */
		void onSuccess(Object success);
		
		/**
		 * ʧ��
		 */
		void onError(Object error);
	}
}
