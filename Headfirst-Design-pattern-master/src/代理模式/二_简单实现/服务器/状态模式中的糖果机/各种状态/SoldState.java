package 代理模式.二_简单实现.服务器.状态模式中的糖果机.各种状态;

import 代理模式.二_简单实现.服务器.状态模式中的糖果机.GumballMachine;

/**
 * 准备售卖..
 */
public class SoldState implements State {

	/**
	 * transient:短暂的
	 * 对于State的每个实现，都加上这个关键字，告诉JVM不要序列化这个字段。
	 */
	transient GumballMachine gumballMachine;
 
    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    //---------对于此状态来说，这些动作都是不恰当的
	public void insertQuarter() {
		System.out.println("Please wait, we're already giving you a gumball");
	}
	public void ejectQuarter() {
		System.out.println("Sorry, you already turned the crank");
	}
	public void turnCrank() {
		System.out.println("Turning twice doesn't get you another gumball!");
	}
	//------------------------------------

	public void dispense() {
		gumballMachine.releaseBall();
		if (gumballMachine.getCount() > 0) {
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		} else {
			System.out.println("Oops, out of gumballs!");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}
 
	public String toString() {
		return "dispensing a gumball";
	}
}


