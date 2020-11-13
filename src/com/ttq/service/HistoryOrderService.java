package com.ttq.service;

import com.ttq.entity.Order;

public interface HistoryOrderService {
	//添加历史订单
	boolean addHistoryOrder(Order order);

	public void showOrder();

}
