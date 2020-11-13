package com.ttq.client;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.ttq.entity.Admin;
import com.ttq.entity.Order;
import com.ttq.entity.ParkPlace;
import com.ttq.entity.User;
import com.ttq.service.*;
import com.ttq.service.impl.*;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		UserServiceImp1 userService = UserServiceImp1.getUserService();
		AdminServiceImpl adminService = AdminServiceImpl.getAdminService();
		OrderServiceImp1 orderService = OrderServiceImp1.getOrderServiceImp();
		ParkServiceImp1 parkService = ParkServiceImp1.getParkServiceImp();
		HistoryOrderServiceImp1 historyOrderService = HistoryOrderServiceImp1.getHistoryOrderServiceImp();
		System.out.println("欢迎使用停车系统");
		menu(scanner, userService, adminService, orderService, parkService, historyOrderService);
	}

	private static void menu(Scanner scanner, UserService userService, AdminService adminService,
			OrderService orderService, ParkService parkService, HistoryOrderService historyOrderService) {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("1.管理员");
			System.out.println("2.用户");
			System.out.println("3.退出");
			int choice = Integer.parseInt(scanner.nextLine().trim());
			switch (choice) {
			case 1:
				adminMenu(scanner, userService, adminService, orderService, parkService, historyOrderService);
				return;
			case 2:
				userMenu(scanner, userService, adminService, orderService, parkService, historyOrderService);
				return;
			case 3:
				System.exit(0);
				break;

			default:
				System.out.println("您输入的有误");
				break;
			}
		}
	}

	private static void userMenu(Scanner scanner, UserService userService, AdminService adminService,
			OrderService orderService, ParkService parkService, HistoryOrderService historyOrderService) {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("1.登录");
			System.out.println("2.注册");
			System.out.println("3.退出");
			int choice = Integer.parseInt(scanner.nextLine().trim());
			switch (choice) {
			case 1:
				System.out.println("请输入用户名：");
				String username = scanner.nextLine().trim();
				System.out.println("请输入密码：");
				String password = scanner.nextLine().trim();
				User user = userService.login(username, password);
				if (user == null) {
					System.out.println("用户名或密码不正确");
					break;
				}
				parkMenu(scanner, userService, adminService, orderService, parkService, historyOrderService);
				return;
			case 2:
				System.out.println("请输入用户名：");
				username = scanner.nextLine().trim();
				System.out.println("请输入密码：");
				password = scanner.nextLine().trim();
				User userReg = new User(username, password);
				boolean state = userService.register(userReg);
				if (state == false) {
					System.out.println("注册失败");
				}
				System.out.println("注册成功");
				break;
			case 3:
				menu(scanner, userService, adminService, orderService, parkService, historyOrderService);
				return;
			default:
				System.out.println("您输入的有误");
				break;
			}
		}
	}

	private static void parkMenu(Scanner scanner, UserService userService, AdminService adminService,
			OrderService orderService, ParkService parkService, HistoryOrderService historyOrderService) {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("1.停车");
			System.out.println("2.取车");
			System.out.println("3.付款");
			System.out.println("4.停车信息");
			System.out.println("5.退出");
			int choice = Integer.parseInt(scanner.nextLine().trim());
			switch (choice) {
			case 1:
				Random ramRandom = new Random();
				int num = ramRandom.nextInt(10) + 1;
				System.out.println("请输入车牌：");
				String carPlate = scanner.nextLine().trim();
				boolean curr = parkService.parkCar(num, carPlate);
				if (curr == false) {
					System.out.println("该车位已经被使用");
					break;
				}
				System.out.println("停车成功");
				orderService.addOrder(num, carPlate);
				break;
			case 2:
				System.out.println("请输入车牌：");
				carPlate = scanner.nextLine().trim();
				curr = parkService.leaveCar(carPlate);
				if (curr == true) {
					System.out.println("取车成功");
					Order order = orderService.leaveOrder(carPlate);
					historyOrderService.addHistoryOrder(order);
				}
				break;
			case 3:
				System.out.println("请输入车牌");
				carPlate = scanner.nextLine().trim();
				double pay = orderService.pay(carPlate);
				System.out.println("需要缴费：" + pay);
				break;
			case 4:
				System.out.println("请输入车牌");
				carPlate = scanner.nextLine().trim();
				System.out.println("车辆信息如下：");
				orderService.showOrder(carPlate);
				break;
			case 5:
				userMenu(scanner, userService, adminService, orderService, parkService, historyOrderService);
				return;
			default:
				System.out.println("您输入的有误");
				break;
			}
		}
	}

	private static void adminMenu(Scanner scanner, UserService userService, AdminService adminService,
			OrderService orderService, ParkService parkService, HistoryOrderService historyOrderService) {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("1.登录");
			System.out.println("2.注册");
			System.out.println("3.退出");
			int choice = Integer.parseInt(scanner.nextLine().trim());
			switch (choice) {
			case 1:
				System.out.println("请输入用户名：");
				String adminname = scanner.nextLine().trim();
				System.out.println("请输入密码：");
				String password = scanner.nextLine().trim();
				Admin admin = adminService.login(adminname, password);
				if (admin == null) {
					System.out.println("用户名或密码不正确");
					break;
				}
				managerMenu(scanner, userService, adminService, orderService, parkService, historyOrderService);
				return;
			case 2:
				System.out.println("请输入用户名：");
				adminname = scanner.nextLine().trim();
				System.out.println("请输入密码：");
				password = scanner.nextLine().trim();
				Admin adminReg = new Admin(adminname, password);
				boolean state = adminService.register(adminReg);
				if (state == false) {
					System.out.println("注册失败");
				}
				System.out.println("注册成功");
				break;
			case 3:
				menu(scanner, userService, adminService, orderService, parkService, historyOrderService);
				return;
			default:
				System.out.println("您输入的有误");
				break;
			}
		}
	}

	private static void managerMenu(Scanner scanner, UserService userService, AdminService adminService,
			OrderService orderService, ParkService parkService, HistoryOrderService historyOrderService) {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("1.查看剩余车位");
			System.out.println("2.查看已停车车位");
			System.out.println("3.查看历史订单");
			System.out.println("4.退出");
			int choice = Integer.parseInt(scanner.nextLine().trim());
			switch (choice) {
			case 1:
				ArrayList<Integer> pla = parkService.leftPlace();
				System.out.println("空闲车位有：");
				for (int i = 0; i < pla.size(); i++) {
					System.out.print(pla.get(i).toString() + "号  ");
				}
				break;
			case 2:
				ArrayList<ParkPlace> parked = parkService.usedPlace();
				System.out.println("已停车车位：");
				System.out.println(parked);
				break;
			case 3:
				historyOrderService.showOrder();
				break;
			case 4:
				adminMenu(scanner, userService, adminService, orderService, parkService, historyOrderService);
				return;
			default:
				System.out.println("您输入的有误");
				break;
			}
		}
	}

}
