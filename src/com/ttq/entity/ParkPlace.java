package com.ttq.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ParkPlace implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int carPlace;
	private String currentCar;

	{
		this.currentCar = null;
	}

	@Override
	public String toString() {
		return carPlace + "\t" + currentCar;
	}

}
