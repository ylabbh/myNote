package 复合模式.演示.第二步_引入鹅演示适配器;

import 复合模式.演示.各种鸭子.Quackable;

/**
 * 我们来一个适配器，适配Quackable接口
 */
public class GooseAdapter implements Quackable {
	Goose goose;
 
	public GooseAdapter(Goose goose) {
		this.goose = goose;
	}

	public void quack() {
		goose.honk();
	}
 
	public String toString() {
		return "Goose pretending to be a Duck";
	}


}