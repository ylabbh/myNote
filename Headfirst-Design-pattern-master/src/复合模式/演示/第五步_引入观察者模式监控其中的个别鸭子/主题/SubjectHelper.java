package 复合模式.演示.第五步_引入观察者模式监控其中的个别鸭子.主题;

import 复合模式.演示.第五步_引入观察者模式监控其中的个别鸭子.观察者.Observer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 辅助类：这里使用另一种方式建立观察者模式。
 * 由于到第五步，我们的系统已经成型，有一定复杂度，我有一堆种类不同的鸭子，它们都是被观察对象（主题），我不希望做太大的改动来实现观察。
 *
 * 那么我把观察工作抽离出来，交给单独一个类。
 *
 * 主题的辅助类
 */
public class SubjectHelper implements QuackSubject {
	/**
	 * 在之前的例子中，主题类持有observerList，用于通知每一个 观察者。而观察者不知道主题的存在。
	 * 使用了辅助类，主题不再持有 observers，而是这里辅助类。相当于 主题 和 观察者 的交流地。
	 */
	ArrayList observers = new ArrayList();
	QuackSubject duck;
 
	public SubjectHelper(QuackSubject duck) {
		this.duck = duck;
	}
  
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}
  
	public void notifyObservers() {
		Iterator iterator = observers.iterator();
		while (iterator.hasNext()) {
			Observer observer = (Observer)iterator.next();
			observer.update(duck);
		}
	}
 
	public Iterator getObservers() {
		return observers.iterator();
	}
}