package com.ttq.service.impl;

import java.util.ArrayList;

import com.ttq.entity.ParkPlace;
import com.ttq.service.ParkService;
import com.ttq.util.ObjectUtil;

public class ParkServiceImp1 implements ParkService {

	private ArrayList<ParkPlace> parkPlaceList = null;

	public static final ParkServiceImp1 parkServiceImp = new ParkServiceImp1();

	public static ParkServiceImp1 getParkServiceImp() {
		return parkServiceImp;
	}

	private ParkServiceImp1() {
		// TODO Auto-generated constructor stub

		parkPlaceList = ObjectUtil.fileToObject("parkPlace.txt");
	}

	@Override
	public boolean parkCar(int num, String carPlate) {
		// TODO Auto-generated method stub
		for (int i = 0; i < parkPlaceList.size(); i++) {
			if (num == parkPlaceList.get(i).getCarPlace()) {
				return false;
			}
		}
		ParkPlace parkPlace = new ParkPlace(num, carPlate);
		parkPlaceList.add(parkPlace);
		ObjectUtil.objectToFile(parkPlaceList, "parkPlace.txt");
		return true;

	}

	@Override
	public boolean leaveCar(String carPlate) {
		// TODO Auto-generated method stub
		for (int i = 0; i < parkPlaceList.size(); i++) {
			if (parkPlaceList.get(i).getCurrentCar().equals(carPlate)) {
				parkPlaceList.remove(i);
				ObjectUtil.objectToFile(parkPlaceList, "parkPlace.txt");
				return true;
			}
		}
		System.out.println("没有找到该车辆");
		return false;

	}

	@Override
	public ArrayList<Integer> leftPlace() {
		// TODO Auto-generated method stub
		boolean flag = false;
		int n = 1;
		ArrayList<Integer> pla = new ArrayList<Integer>();
		for (int i = 1; i < 101; i++) {
			for (int j = 0; j < parkPlaceList.size(); j++) {
				if (i == parkPlaceList.get(j).getCarPlace()) {
					flag = true;
				}
			}
			if (flag == false) {
				pla.add(i);
			}
			flag = false;
		}
		return pla;

	}

	@Override
	public ArrayList<ParkPlace> usedPlace() {
		// TODO Auto-generated method stub
		ArrayList<ParkPlace> pla1 = new ArrayList<ParkPlace>();
		for (int i = 1; i < 101; i++) {
			for (int j = 0; j < parkPlaceList.size(); j++) {
				if (i == parkPlaceList.get(j).getCarPlace()) {
					pla1.add(parkPlaceList.get(j));
				}
			}

		}
		return pla1;
	}

}
