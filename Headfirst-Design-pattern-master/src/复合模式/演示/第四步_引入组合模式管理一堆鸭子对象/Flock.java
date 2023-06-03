package 复合模式.演示.第四步_引入组合模式管理一堆鸭子对象;

import 复合模式.演示.各种鸭子.Quackable;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 组合什么？组合某个接口的一堆实现。
 *
 * 注意，每个Flock下面都挂着一个Quackable集合，所以Flock是枝，Quackable是叶
 */
public class Flock implements Quackable {
	ArrayList quackers = new ArrayList();

	/**
	 * Duck并没有add方法，这里子叶节点没有统一方法，失去了一些透明性(客户需要关心添加的是枝还是叶)，但是更安全。
	 * @param quacker
	 */
	public void add(Quackable quacker) {
		quackers.add(quacker);
	}
 
	public void quack() {
		Iterator iterator = quackers.iterator();
		while (iterator.hasNext()) {
			Quackable quacker = (Quackable)iterator.next();
			quacker.quack();
		}
	}

	public String toString() {
		return "Flock of Quackers";
	}

}