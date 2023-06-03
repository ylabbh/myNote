package 迭代器与组合模式.组合模式.迭代器;

import 迭代器与组合模式.组合模式.菜单和菜单项.Menu;
import 迭代器与组合模式.组合模式.菜单和菜单项.MenuComponent;

import java.util.Iterator;
import java.util.Stack;

/**
 * 注意和Menu的print方法的区别。Menu中我们实现的是内部迭代器，即目标自己完成迭代工作。
 * 而这里我们实现的是外部迭代器。需要跟踪更多东西。必须维护它在遍历中的位置。
 *
 * 外部迭代器为什么又多一个栈结构？通过栈，我们在深入树形结构过程中，栈保存所有还未遍历结束的树分支。这样我们就能切实地获取每一个值。
 *
 * 外部迭代器的好处很明显。可以到处使用。迭代器暴露出来可以让其它类进行控制。而内部迭代器并不提供这种支持
 */
public class CompositeIterator implements Iterator {
	Stack stack = new Stack();
   
	public CompositeIterator(Iterator iterator) {
		stack.push(iterator);
	}
    //好了，当客户想要取得下一个元素的时候，我们先调用hasNext()来确定是否还有下一个
	public Object next() {
		if (hasNext()) {
			Iterator iterator = (Iterator) stack.peek();
			MenuComponent component = (MenuComponent) iterator.next();
			if (component instanceof Menu) {
				stack.push(component.createIterator());
			} 
			return component;
		} else {
			return null;
		}
	}
  
	public boolean hasNext() {
		if (stack.empty()) {
			return false;
		} else {
			//第一次取出：整个allMenu的迭代器（java.util.Iterator）
			//第二次：取出第一个Menu
			Iterator iterator = (Iterator) stack.peek();
			if (iterator.hasNext()) {
				return true;
			} else {
				stack.pop();
				return hasNext();
			}
		}
	}
   
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
