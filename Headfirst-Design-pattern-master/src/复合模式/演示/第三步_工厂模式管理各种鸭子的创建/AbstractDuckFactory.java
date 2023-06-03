package 复合模式.演示.第三步_工厂模式管理各种鸭子的创建;

import 复合模式.演示.各种鸭子.Quackable;

/**
 * 因为我们有各种鸭子，因此使用工厂，负责创建各种类型不同的 鸭子
 */
public abstract class AbstractDuckFactory {
 
	public abstract Quackable createMallardDuck();
	public abstract Quackable createRedheadDuck();
	public abstract Quackable createDuckCall();
	public abstract Quackable createRubberDuck();
}