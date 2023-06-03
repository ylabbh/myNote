package 迭代器与组合模式.组合模式.菜单和菜单项;

import java.util.Iterator;

/**
 * 叶节点的菜单项
 */
public class NullIterator implements Iterator {
   
	public Object next() {
		return null;
	}
  
	public boolean hasNext() {
		return false;
	}
   
	public void remove() {
		throw new UnsupportedOperationException();
	}
}