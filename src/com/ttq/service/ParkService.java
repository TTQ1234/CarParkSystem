package com.ttq.service;

import java.util.ArrayList;

import com.ttq.entity.ParkPlace;

public interface ParkService {

	//停车
	boolean parkCar(int num, String carPlate);

	//拿车
	boolean leaveCar(String carPlate);

	//剩余车位
	ArrayList<Integer> leftPlace();

	//已停
	ArrayList<ParkPlace> usedPlace();

}
