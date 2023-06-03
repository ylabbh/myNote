package 复合模式.演示;

import 复合模式.演示.各种鸭子.*;
import 复合模式.演示.第三步_工厂模式管理各种鸭子的创建.CountingDuckFactory;
import 复合模式.演示.第三步_工厂模式管理各种鸭子的创建.GooseFactory;
import 复合模式.演示.第二步_引入鹅演示适配器.Goose;
import 复合模式.演示.第二步_引入鹅演示适配器.GooseAdapter;
import 复合模式.演示.第二步_给鸭子添加装饰者.QuackCounter;
import 复合模式.演示.第四步_引入组合模式管理一堆鸭子对象.Flock;

/**
 * 鸭子模拟器，演示我们的鸭子
 */
public class DuckSimulator {
	public static void main(String[] args) {
		DuckSimulator simulator = new DuckSimulator();
		simulator.simulate();
	}

	/**
	 * 创建实例，让所有鸭子叫一便。
	 */
	void simulate() {
		Quackable mallardDuck = new MallardDuck();
		Quackable redheadDuck = new RedheadDuck();
		Quackable duckCall = new DuckCall();
		Quackable rubberDuck = new RubberDuck();
 		Quackable gooseDuck = new GooseAdapter(new Goose());//这里出现适配器模式
		System.out.println("\nDuck Simulator");
 
		simulate(mallardDuck);
		simulate(redheadDuck);
		simulate(duckCall);
		simulate(rubberDuck);
		simulate(gooseDuck);
		System.out.println("----------------1上面演示了适配器模式，下面加入  装饰者  模式");

		Quackable mallardDuck1 = new QuackCounter(new MallardDuck());
		Quackable duckCall1 = new QuackCounter(new DuckCall());
		Quackable redheadDuck1 = new QuackCounter(new RedheadDuck());
		Quackable rubberDuck1 = new QuackCounter(new RubberDuck());
		Quackable gooseDuck1 = new GooseAdapter(new Goose());//这里出现适配器模式

		simulate(mallardDuck1);
		simulate(mallardDuck1);
		simulate(mallardDuck1);
		simulate(redheadDuck1);
		simulate(duckCall1);
		simulate(rubberDuck1);

		simulate(gooseDuck1);
		System.out.println("鸭子们总共叫了："+QuackCounter.getQuacks() + " 次。");
		System.out.println("--------------2.接下来引入工厂模式，把对象创建交给工厂完成");
		CountingDuckFactory factory = new CountingDuckFactory();
		Quackable duckCall2 = factory.createDuckCall();
		Quackable mallardDuck2 = factory.createMallardDuck();
		Quackable redheadDuck2 = factory.createRedheadDuck();
		Quackable rubberDuck2 = factory.createRubberDuck();
		//演示适配器+工厂的实现
		Quackable duck_goose = GooseFactory.createGooseAdapter();
		simulate(duck_goose);
		simulate(mallardDuck2);
		simulate(mallardDuck2);
		simulate(mallardDuck2);
		simulate(redheadDuck2);
		simulate(duckCall2);
		simulate(rubberDuck2);
		System.out.println("鸭子们总共叫了："+QuackCounter.getQuacks() + " 次。");
		System.out.println("--------------3.可以看到，1和2，无论有没有工厂，我们都需要管理一堆对象，这显然不好。下面演示组合模式");
		Flock flockOfDucks = new Flock();
		//先管理一些种类不同的鸭子
		flockOfDucks.add(duckCall2);
		flockOfDucks.add(mallardDuck2);
		flockOfDucks.add(redheadDuck2);
		flockOfDucks.add(rubberDuck2);
		//再建立一个分支，管理一些同种鸭子
		Flock flockOfrubberDucks = new Flock();
		Quackable rubberDuck3 = factory.createRubberDuck();
		Quackable rubberDuck4 = factory.createRubberDuck();
		Quackable rubberDuck5 = factory.createRubberDuck();
		Quackable rubberDuck6 = factory.createRubberDuck();
		flockOfrubberDucks.add(rubberDuck3);
		flockOfrubberDucks.add(rubberDuck4);
		flockOfrubberDucks.add(rubberDuck5);
		flockOfrubberDucks.add(rubberDuck6);
		flockOfDucks.add(flockOfrubberDucks);

		System.out.println("---//现在，我已经把一堆对象整理到树形结构中，调用这个树就可以：");
		simulate(flockOfDucks);
		System.out.println("鸭子们总共叫了："+QuackCounter.getQuacks() + " 次。");

	}
   
	void simulate(Quackable duck) {//多态
		duck.quack();
	}
}