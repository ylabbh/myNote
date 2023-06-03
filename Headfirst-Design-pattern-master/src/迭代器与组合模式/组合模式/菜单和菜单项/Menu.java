package 迭代器与组合模式.组合模式.菜单和菜单项;

import 迭代器与组合模式.组合模式.迭代器.CompositeIterator;

import java.util.ArrayList;
import java.util.Iterator;



/**
 * 组合模式中使用了递归。注意关注重点：树形结构。
 *
 * 组合模式下，Menu和MenuItem我们一视同仁。都视为MenuComponent。
 * 组合模式似乎违背了单一责任的原则。既要管理层次结构（ArrayList<MenuComponent>），还要执行菜单遍历（print()）
 *
 */
public class Menu extends MenuComponent {
	//注意看Menu和MenuItem的代码区别。Menu有保留有一个ArrayList<MenuComponent>，既可以存放菜单项MenuItem，也可以存放子菜单Menu。
	ArrayList<MenuComponent> menuComponents = new ArrayList();
	String name;
	String description;
  
	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
	}
 
	public void add(MenuComponent menuComponent) {
		menuComponents.add(menuComponent);
	}
	public void remove(MenuComponent menuComponent) {
		menuComponents.remove(menuComponent);
	}
	public MenuComponent getChild(int i) {
		return (MenuComponent)menuComponents.get(i);
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}


	/**
	 * 这里是内部迭代器，比较好理解，就是迭代器+递归，穷遍所有元素。
	 */
	public void print() {
		System.out.print("\n" + getName());
		System.out.println(", " + getDescription());
		System.out.println("---------------------");
  
		Iterator iterator = menuComponents.iterator();
		/**
		 * （内部迭代器，Menu类自己实现迭代过程）
		 */
		while (iterator.hasNext()) {
			MenuComponent menuComponent = (MenuComponent)iterator.next();
			menuComponent.print();
		}
	}



	/**
	 * 这里是外部迭代器，迭代器+递归+栈结构  不好理解。
	 * @return
	 */
	public Iterator createIterator(){
		return new CompositeIterator(menuComponents.iterator());
	}



}