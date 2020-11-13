package com.ttq.service;

import com.ttq.entity.Order;

public interface OrderService {
	//增加订单
	boolean addOrder(int place, String carPlate);

	//拿车订单
	Order leaveOrder(String carPlate);

	void showOrder(String carPlate);

	double pay(String carPlate);
}
