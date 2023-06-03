package 状态模式.简单实现.各种状态;

import 状态模式.简单实现.GumballMachine;

/**
 * 没有25美分  等待投币状态
 */
public class NoQuarterState implements State {
    GumballMachine gumballMachine;
 
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
