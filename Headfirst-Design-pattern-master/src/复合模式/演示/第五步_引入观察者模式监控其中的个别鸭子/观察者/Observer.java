package 复合模式.演示.第五步_引入观察者模式监控其中的个别鸭子.观察者;

import 复合模式.演示.第五步_引入观察者模式监控其中的个别鸭子.主题.QuackSubject;

public interface Observer {
	public void update(QuackSubject duck);
}