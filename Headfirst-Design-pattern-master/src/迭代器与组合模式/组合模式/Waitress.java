package 迭代器与组合模式.组合模式;

import 迭代器与组合模式.组合模式.菜单和菜单项.MenuComponent;

import java.util.Iterator;

public class Waitress {
	MenuComponent allMenu;
 
	public Waitress(MenuComponent allMenu) {
		this.allMenu = allMenu;
	}
 
	public void printMenu() {
		allMenu.print();
	}

	/**
	 * 演示外部迭代器的拓展---精细获取指定元素
	 * 现在我可以追踪整个树形结构了。我要打印所有蔬菜类的菜单项
	 */
	public void printVegetarianMenu(){
		//注意，Menu和MenuItem都覆盖了父类的createIterator方法，debug的时候，为什么这边进入的是Menu类的createIterator？因为allMenu在初始化的时候，指向的就是Menu
		//这里的iterator是CompositeIterator，它包含着整个allMenu的迭代器
		Iterator iterator = allMenu.createIterator();
		System.out.println("开始打印所有蔬菜类菜单项。。。。");
		while (iterator.hasNext()){
			MenuComponent menuComponent = (MenuComponent) iterator.next();
			try {
				if (menuComponent.isVegetarian()){
					menuComponent.print();
				}
			} catch (UnsupportedOperationException e){

			}

		}
	}

}