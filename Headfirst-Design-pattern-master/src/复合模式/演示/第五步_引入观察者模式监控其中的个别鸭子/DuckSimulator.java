package 复合模式.演示.第五步_引入观察者模式监控其中的个别鸭子;

import 复合模式.演示.各种鸭子.Quackable;
import 复合模式.演示.第三步_工厂模式管理各种鸭子的创建.AbstractDuckFactory;
import 复合模式.演示.第三步_工厂模式管理各种鸭子的创建.DuckFactory;
import 复合模式.演示.第二步_引入鹅演示适配器.Goose;
import 复合模式.演示.第二步_引入鹅演示适配器.GooseAdapter;
import 复合模式.演示.第二步_给鸭子添加装饰者.QuackCounter;
import 复合模式.演示.第五步_引入观察者模式监控其中的个别鸭子.观察者.Quackologist;

/**
 * 观察者
 */
public class DuckSimulator {
	public static void main(String[] args) {
		DuckSimulator simulator = new DuckSimulator();
		AbstractDuckFactory duckFactory = new DuckFactory();
 
		simulator.simulate(duckFactory);
	}
  
	void simulate(AbstractDuckFactory duckFactory) {
  
		Quackable redheadDuck = duckFactory.createRedheadDuck();
		Quackable duckCall = duckFactory.createDuckCall();
		Quackable rubberDuck = duckFactory.createRubberDuck();
		Quackable gooseDuck = new GooseAdapter(new Goose());
 
		/*Flock flockOfDucks = new Flock();
 
		flockOfDucks.add(redheadDuck);
		flockOfDucks.add(duckCall);
		flockOfDucks.add(rubberDuck);
		flockOfDucks.add(gooseDuck);
 
		Flock flockOfMallards = new Flock();
 
		Quackable mallardOne = duckFactory.createMallardDuck();
		Quackable mallardTwo = duckFactory.createMallardDuck();
		Quackable mallardThree = duckFactory.createMallardDuck();
		Quackable mallardFour = duckFactory.createMallardDuck();

		flockOfMallards.add(mallardOne);
		flockOfMallards.add(mallardTwo);
		flockOfMallards.add(mallardThree);
		flockOfMallards.add(mallardFour);

		flockOfDucks.add(flockOfMallards);

		System.out.println("\nDuck Simulator: With Observer");*/

		Quackologist quackologist = new Quackologist();
		//redheadDuck.registerObserver(quackologist);

		redheadDuck.quack();

		System.out.println("\nThe ducks quacked " + 
		                   QuackCounter.getQuacks() +
		                   " times");
	}
 
	void simulate(Quackable duck) {
		duck.quack();
	}
}