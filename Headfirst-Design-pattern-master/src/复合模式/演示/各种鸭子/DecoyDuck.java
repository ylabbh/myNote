package 复合模式.演示.各种鸭子;

/**
 * 诱捕器，不会叫
 */
public class DecoyDuck implements Quackable {
	public void quack() {
		System.out.println("<< Silence >>");
	}


}