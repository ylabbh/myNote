package 迭代器与组合模式.二_迭代器模式;

import 迭代器与组合模式.二_迭代器模式.两个不同的餐厅.各种菜单.CafeMenu;
import 迭代器与组合模式.二_迭代器模式.两个不同的餐厅.各种菜单.DinerMenu;
import 迭代器与组合模式.二_迭代器模式.两个不同的餐厅.各种菜单.Menu;
import 迭代器与组合模式.二_迭代器模式.两个不同的餐厅.各种菜单.PancakeHouseMenu;

import java.util.ArrayList;

public class MenuTestDrive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Menu pancakeHouseMenu = new PancakeHouseMenu();
		Menu dinerMenu = new DinerMenu();
		Menu cafeMenu = new CafeMenu();
		ArrayList<Menu> menus = new ArrayList<>();
		menus.add(pancakeHouseMenu);
		menus.add(dinerMenu);
		menus.add(cafeMenu);
		Alice waitress = new Alice(menus);
		waitress.printMenu();

	}

}