package 复合模式.演示.第三步_工厂模式管理各种鸭子的创建;

import 复合模式.演示.各种鸭子.*;

public class DuckFactory extends AbstractDuckFactory {

	/**
	 * 注意返回值，用户将只会知道这个工厂产生的是实现了Quackable的对象，具体是哪个对象，并不清楚
	 * @return
	 */
	public Quackable createMallardDuck() {
		return new MallardDuck();
	}
  
	public Quackable createRedheadDuck() {
		return new RedheadDuck();
	}
  
	public Quackable createDuckCall() {
		return new DuckCall();
	}
   
	public Quackable createRubberDuck() {
		return new RubberDuck();
	}
}