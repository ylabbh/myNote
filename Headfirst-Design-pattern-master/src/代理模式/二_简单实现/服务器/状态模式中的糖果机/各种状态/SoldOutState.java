package 代理模式.二_简单实现.服务器.状态模式中的糖果机.各种状态;

import 代理模式.二_简单实现.服务器.状态模式中的糖果机.GumballMachine;

/**
 * 售空后，所有状态都诶有效果。
 */
public class SoldOutState implements State {
	/**
	 * transient:短暂的
	 * 对于State的每个实现，都加上这个关键字，告诉JVM不要序列化这个字段。
	 */
	transient GumballMachine gumballMachine;
 
    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
	public void insertQuarter() {
		System.out.println("You can't insert a quarter, the machine is sold out");
	}
 
	public void ejectQuarter() {
		System.out.println("You can't eject, you haven't inserted a quarter yet");
	}
 
	public void turnCrank() {
		System.out.println("You turned, but there are no gumballs");
	}
 
	public void dispense() {
		System.out.println("No gumball dispensed");
	}
 
	public String toString() {
		return "sold out";
	}
}
