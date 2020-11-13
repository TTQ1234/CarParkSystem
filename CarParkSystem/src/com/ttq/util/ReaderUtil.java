package com.ttq.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class ReaderUtil {
	//从Socket中读取并输出（多行）
	public static void readShow(BufferedReader reader, int num) throws IOException {
		for (int i = 0; i < num; i++) {
			System.out.println(reader.readLine());
		}
	}

	//从Socket读取字符串（单行）
	public static String read(BufferedReader reader) throws IOException {
		return reader.readLine();
	}

	public static Integer readInt(BufferedReader reader) throws IOException {
		return reader.read();
	}

	//写到Socket中
	public static void write(BufferedWriter writer, String line) throws IOException {
		writer.write(line);
		writer.flush();//刷新
	}

	public static void write(BufferedWriter writer, int length) throws IOException {
		// TODO Auto-generated method stub
		writer.write(length);
		writer.flush();
	}

}
