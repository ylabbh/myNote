package 复合模式.演示.第二步_给鸭子添加装饰者;

import 复合模式.演示.各种鸭子.Quackable;

/**
 * 这里开始演示装饰者。
 * 我们希望能够鸭子自己统计叫了几次，又不想修改鸭子的代码（实现什么接口，就意味着希望修饰的是哪些行为（或属性））
 *
 */
public class QuackCounter implements Quackable {
	Quackable duck;
	static int numberOfQuacks;//注意，这里是static的，属于类级别，也就是说，只要用这个类装饰，所有鸭子只要叫过，都会被计数
  
	public QuackCounter (Quackable duck) {
		this.duck = duck;
	}
  
	public void quack() {
		duck.quack();
		numberOfQuacks++;
	}
 
	public static int getQuacks() {
		return numberOfQuacks;
	}
	public String toString() {
		return duck.toString();
	}


}