package 状态模式.简单实现;
/**
 * 状态模式通过改变对象内部的状态帮助对象控制自己的行为。
 * 状态模式关注两块：1.状态   2.行为。
 *      发生行为---->状态改变。
 *      不发生行为--->状态不变
 *
 * 状态模式：允许对象在内部状态改变时改变它的行为，对象看起来好像修改了它自身的类。
 *	什么意思？看gumballMachine.insertQuarter()被调用了三次。直观的感觉是，三次调用了同一个方法，结果应该是相同的。但是并没有。
 *  由于用State进行了封装和引导，实际指向的方法是不一样的，取决于执行过程中对象自身所处的状态。
 *
 *
 *  和  策略模式  的区别 ：
 *  	1.在于它们“意图”不同。
 *  		状态：封装行为，随时委托到状态对象中的一个。对象内部自动根据自己定义转换行为的规则，根据自己的属性进行调整，客户并不知晓也不关心状态如何改变。
 *  		策略：客户主动指定Context所要组合的策略对象。
 *  	2.用途：
 *  		策略：继承之外的一种弹性替代方案
 *  		状态：防止过多条件判断的替代方案。
 *
 *
 */
public class Test {

	public static void main(String[] args) {
		GumballMachine gumballMachine = new GumballMachine(5);

		System.out.println(gumballMachine);
		System.out.println(	"开始投币。。。");
		gumballMachine.insertQuarter();//1.........
		System.out.println(	"转扭杆。。。");
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();//2..........
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();//3.........
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();//3.........
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();//3.........
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();//3.........
		gumballMachine.turnCrank();
		System.out.println(gumballMachine);
	}


}





