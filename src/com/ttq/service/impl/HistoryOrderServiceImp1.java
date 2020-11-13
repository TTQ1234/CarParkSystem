package com.ttq.service.impl;

import java.util.ArrayList;

import com.ttq.entity.Order;
import com.ttq.service.HistoryOrderService;
import com.ttq.util.ObjectUtil;

public class HistoryOrderServiceImp1 implements HistoryOrderService {
	private ArrayList<Order> HistoryorderList = null;
	public static final HistoryOrderServiceImp1 HistoryorderServiceImp = new HistoryOrderServiceImp1();

	public static HistoryOrderServiceImp1 getHistoryOrderServiceImp() {
		return HistoryorderServiceImp;
	}

	private HistoryOrderServiceImp1() {
		// TODO Auto-generated constructor stub
		HistoryorderList = ObjectUtil.fileToObject("historyorder.txt");
	}

	@Override
	public boolean addHistoryOrder(Order order) {
		// TODO Auto-generated method stub
		HistoryorderList.add(order);
		ObjectUtil.objectToFile(HistoryorderList, "historyorder.txt");
		return false;
	}

	public void showOrder() {
		for (int i = 0; i < HistoryorderList.size(); i++) {
			System.out.println(HistoryorderList.get(i));
		}
	}

	@Override
	public String toString() {
		return HistoryorderList + "";
	}

}
