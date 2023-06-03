
package 迭代器与组合模式.二_迭代器模式.两个不同的餐厅.对应的迭代器;

import 迭代器与组合模式.二_迭代器模式.两个不同的餐厅.各种菜单.菜单项.MenuItem;
import java.util.Iterator;


/**
 * 餐厅的迭代器，餐厅的菜单使用数组【】,数组不想Arraylist，map等，没有java自带的迭代器，因此这里我们实现自己的迭代器
 *
 * 同时也能够更好地理解迭代器的工作模式，注意这里position这个指针的概念
 *
 * 迭代器要素：1.持有需要迭代的 集合 2.指针
 */
public class DinerMenuIterator implements Iterator {
	MenuItem[] items;
	//记录当前数组遍历的位置--指针
	int position = 0;

	public DinerMenuIterator(MenuItem[] items) {
		this.items = items;
	}

	@Override
	public boolean hasNext() {
		if(position >= items.length || items[position] == null){//因为是定长的数组，如果是null，同样说明没有元素了
			return false;
		}else{
			return true;
		}
	}

	@Override
	public Object next() {
		MenuItem menuItem = items[position];
		position = position + 1;
		return menuItem;
	}

	public void remove(){
		if (position <= 0){
			throw new IllegalStateException("无法移除，因为没有更多元素");
		}
		if (items[position - 1] != null){
			for (int i = position - 1; i < items.length - 1; i++) {
				items[i] = items[i+1];
			}
			items[items.length-1] = null;
		}
	}

}