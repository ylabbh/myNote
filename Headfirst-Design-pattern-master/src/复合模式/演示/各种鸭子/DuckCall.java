package 复合模式.演示.各种鸭子;

/**
 * 仿鸭叫的一个鸣叫器
 */
public class DuckCall implements Quackable {

	public void quack() {
		System.out.println("Kwak");
	}

}