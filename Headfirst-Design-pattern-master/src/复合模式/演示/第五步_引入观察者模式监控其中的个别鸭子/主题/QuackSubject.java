package 复合模式.演示.第五步_引入观察者模式监控其中的个别鸭子.主题;


import 复合模式.演示.第五步_引入观察者模式监控其中的个别鸭子.观察者.Observer;

/**
 * 1任何想要被观察的Observable都必须实现这个接口
 */
public interface QuackSubject {
	public void registerObserver(Observer observer);
	public void notifyObservers();
}