package 复合模式.演示.第三步_工厂模式管理各种鸭子的创建;

import 复合模式.演示.各种鸭子.*;
import 复合模式.演示.第二步_给鸭子添加装饰者.QuackCounter;

/**
 * 引入装饰者后，我们配套   装饰者  的工厂
 */
public class CountingDuckFactory extends AbstractDuckFactory {
  
	public Quackable createMallardDuck() {
		return new QuackCounter(new MallardDuck());
	}
  
	public Quackable createRedheadDuck() {
		return new QuackCounter(new RedheadDuck());
	}
  
	public Quackable createDuckCall() {
		return new QuackCounter(new DuckCall());
	}
   
	public Quackable createRubberDuck() {
		return new QuackCounter(new RubberDuck());
	}
}