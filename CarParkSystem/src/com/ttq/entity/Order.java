package com.ttq.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int place;
	private Date parkTime;
	private Date leaveTime;
	private String carPlate;

	@Override
	public String toString() {
		return place + "\t" + parkTime + "\t" + leaveTime + "\t" + carPlate;
	}

}
