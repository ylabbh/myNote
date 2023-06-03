package 代理模式.二_简单实现.服务器.状态模式中的糖果机.各种状态;

import 代理模式.二_简单实现.服务器.状态模式中的糖果机.GumballMachine;

/**
 * 没有25美分  等待投币状态
 */
public class NoQuarterState implements State {
	/**
	 * transient:短暂的
	 * 对于State的每个实现，都加上这个关键字，告诉JVM不要序列化这个字段。
	 */
    transient GumballMachine gumballMachine;
 
    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
	public void insertQuarter() {
		System.out.println("投入了一枚硬币..");
        /**
         * 更改状态
         */
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}
 
	public void ejectQuarter() {
		System.out.println("还未投币...");
	}
 
	public void turnCrank() {
		System.out.println("扭了一下，但还未投币...");
	 }
 
	public void dispense() {
		System.out.println("你必须投币....");
	} 
 
	public String toString() {
		return "等待投币";
	}
}
