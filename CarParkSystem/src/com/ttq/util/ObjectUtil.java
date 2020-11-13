package com.ttq.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * 对象集合写到文件 序列化
 * 文件读取成对象集合 反序列化
 * 实体类要实现序列化接口 implements Serializable
 */
public class ObjectUtil<T> {
	/*
	 * 将ArrayList<T> list写到filename文件中 T泛型 可以用于任何对象
	 */
	public static <T> void objectToFile(ArrayList<T> list, String filename) {
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(filename));
			outputStream.writeObject(list);// 写到文件中
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();// 输出错误信息
				}
			}
		}
	}

	public static <T> ArrayList<T> fileToObject(String filename) {
		ObjectInputStream inputStream = null;
		ArrayList<T> list = new ArrayList<T>();
		try {
			inputStream = new ObjectInputStream(new FileInputStream(filename));
			list = (ArrayList<T>) inputStream.readObject();
		} catch (ClassNotFoundException e) {

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {

				}
			}
		}
		return list;
	}
}
