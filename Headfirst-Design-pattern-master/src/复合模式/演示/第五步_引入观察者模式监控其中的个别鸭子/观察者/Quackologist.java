package 复合模式.演示.第五步_引入观察者模式监控其中的个别鸭子.观察者;

import 复合模式.演示.第五步_引入观察者模式监控其中的个别鸭子.主题.QuackSubject;
import 复合模式.演示.第五步_引入观察者模式监控其中的个别鸭子.观察者.Observer;

public class Quackologist implements Observer {
 
	public void update(QuackSubject duck) {
		System.out.println("Quackologist: " + duck + " just quacked.");
	}
 
	public String toString() {
		return "Quackologist";
	}
}