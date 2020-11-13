package com.ttq.service.impl;

import java.util.ArrayList;
import java.util.Date;

import com.ttq.entity.Order;
import com.ttq.service.OrderService;
import com.ttq.util.ObjectUtil;

public class OrderServiceImp1 implements OrderService {
	private ArrayList<Order> orderList = null;
	public static final OrderServiceImp1 orderServiceImp = new OrderServiceImp1();

	public static OrderServiceImp1 getOrderServiceImp() {
		return orderServiceImp;
	}

	private OrderServiceImp1() {
		// TODO Auto-generated constructor stub
		orderList = ObjectUtil.fileToObject("order.txt");
	}

	@Override
	public boolean addOrder(int place, String carPlate) {
		// TODO Auto-generated method stub
		Order order = new Order(place, new Date(), null, carPlate);
		orderList.add(order);
		ObjectUtil.objectToFile(orderList, "order.txt");
		return true;
	}

	@Override
	public void showOrder(String carPlate) {
		for (int i = 0; i < orderList.size(); i++) {
			if (orderList.get(i).getCarPlate().equals(carPlate)) {
				System.out.println(orderList.get(i));
			}
		}
	}

	@Override
	public Order leaveOrder(String carPlate) {
		// TODO Auto-generated method stub
		for (int i = 0; i < orderList.size(); i++) {
			if (orderList.get(i).getCarPlate().equals(carPlate)) {
				orderList.get(i).setLeaveTime(new Date());
				return orderList.get(i);
			}
		}
		return null;
	}

	@Override
	public double pay(String carPlate) {
		// TODO Auto-generated method stub
		for (int i = 0; i < orderList.size(); i++) {
			if (orderList.get(i).getCarPlate().equals(carPlate)) {
				if (orderList.get(i).getLeaveTime() == null) {
					System.out.println("该车辆未还");
					return -1;
				}
				long pay = (orderList.get(i).getLeaveTime().getTime() - orderList.get(i).getParkTime().getTime())
						/ (60 * 60 * 1000);
				if (pay < 3) {
					System.out.println("免费");
					return 0;
				} else if (pay > 3 && pay <= 10) {
					return (pay - 3) * 2;
				} else {
					return 20;
				}
			}
		}
		System.out.println("没有找到该车辆");
		return -1;
	}

}
