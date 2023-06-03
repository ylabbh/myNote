package 代理模式.二_简单实现.服务器.状态模式中的糖果机.各种状态;

import 代理模式.二_简单实现.服务器.状态模式中的糖果机.GumballMachine;

import java.util.Random;

/**
 * 已投币  状态
 */
public class HasQuarterState implements State {
	/**
	 * transient:短暂的
	 * 对于State的每个实现，都加上这个关键字，告诉JVM不要序列化这个字段。
	 */
	transient GumballMachine gumballMachine;
 	Random random = new Random(System.currentTimeMillis());

	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
  
	public void insertQuarter() {
		System.out.println("已经投币，不能反复投。");
	}
 
	public void ejectQuarter() {
		System.out.println("正在退币...");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}
 
	public void turnCrank() {
		System.out.println("You turned...");
		int winner = random.nextInt(10);
		if (winner == 0 &&  (gumballMachine.getCount()>1)){
			gumballMachine.setState(gumballMachine.getWinnerState());
		}else{
			gumballMachine.setState(gumballMachine.getSoldState());
		}
	}

    public void dispense() {
        System.out.println("No gumball dispensed");
    }
 
	public String toString() {
		return "waiting for turn of crank";
	}

}
