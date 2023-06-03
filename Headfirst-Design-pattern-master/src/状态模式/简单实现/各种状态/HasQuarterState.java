package 状态模式.简单实现.各种状态;

import 状态模式.简单实现.GumballMachine;

import java.util.Random;

/**
 * 已投币  状态
 */
public class HasQuarterState implements State {
	GumballMachine gumballMachine;
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
