package 复合模式.演示.各种鸭子;

/**
 * 塑料鸭，“吱吱”叫
 */
public class RubberDuck implements Quackable {

	public void quack() {
		System.out.println("Squeak");
	}


}