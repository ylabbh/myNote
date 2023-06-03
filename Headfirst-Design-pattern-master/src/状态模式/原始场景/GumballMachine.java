package 状态模式.原始场景;

public class GumballMachine {

	/**
	 * 找出所有状态
	 */
	final static int SOLD_OUT = 0;//售罄
	final static int NO_QUARTER = 1;//没有25美分
	final static int HAS_QUARTER = 2;//有25美分
	final static int SOLD = 3;//售卖糖果

	//当前的状态
	int state = SOLD_OUT;

	//当前的数量
	int count = 0;
  
	public GumballMachine(int count) {
		this.count = count;
		if (count > 0) {
			state = NO_QUARTER;
		}
	}

	/**
	 * //---------各种动作，可以看到，每种动作都要针对所有状态做出反应。
	 * 	//那么问题来了，如果我要添加新的动作或者新的状态，我都需要调整所有的代码，这显然是很蛋疼的。
	 * 	//这就说明这个类还没有实现“对修改关闭”
	 *
	 * 	那么思路是什么呢？这里有两个要素。“状态”和“动作”。既然是状态模式，当然是封装状态啦。
	 *  --把一个状态的所有行为放在一个类中。这样就将  行为局部化  了
	 */
	/**
	 * 投入硬币的动作
	 */
	public void insertQuarter() {
		if (state == HAS_QUARTER) {
			System.out.println("You can't insert another quarter");
		} else if (state == NO_QUARTER) {
			state = HAS_QUARTER;
			System.out.println("You inserted a quarter");
		} else if (state == SOLD_OUT) {
			System.out.println("You can't insert a quarter, the machine is sold out");
		} else if (state == SOLD) {
        	System.out.println("Please wait, we're already giving you a gumball");
		}
	}

	/**
	 * 退钱的操作
	 */
	public void ejectQuarter() {
		if (state == HAS_QUARTER) {
			System.out.println("Quarter returned");
			state = NO_QUARTER;
		} else if (state == NO_QUARTER) {
			System.out.println("You haven't inserted a quarter");
		} else if (state == SOLD) {
			System.out.println("Sorry, you already turned the crank");
		} else if (state == SOLD_OUT) {
        	System.out.println("You can't eject, you haven't inserted a quarter yet");
		}
	}

	/**
	 * 转动曲柄的动作
	 */
	public void turnCrank() {
		if (state == SOLD) {
			System.out.println("Turning twice doesn't get you another gumball!");
		} else if (state == NO_QUARTER) {
			System.out.println("You turned but there's no quarter");
		} else if (state == SOLD_OUT) {
			System.out.println("You turned, but there are no gumballs");
		} else if (state == HAS_QUARTER) {
			System.out.println("You turned...");
			state = SOLD;
			dispense();
		}
	}

	/**
	 * 发放糖果的动作
	 */
	public void dispense() {
		if (state == SOLD) {
			System.out.println("A gumball comes rolling out the slot");
			count = count - 1;
			if (count == 0) {
				System.out.println("Oops, out of gumballs!");
				state = SOLD_OUT;
			} else {
				state = NO_QUARTER;
			}
		} else if (state == NO_QUARTER) {
			System.out.println("You need to pay first");
		} else if (state == SOLD_OUT) {
			System.out.println("No gumball dispensed");
		} else if (state == HAS_QUARTER) {
			System.out.println("No gumball dispensed");
		}
	}

	/**
	 * 重新添加糖果
	 * @param numGumBalls
	 */
	public void refill(int numGumBalls) {
		this.count = numGumBalls;
		state = NO_QUARTER;
	}

	/**
	 * 查看当前糖果机状态
	 * @return
	 */
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004\n");
		result.append("Inventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\nMachine is ");
		if (state == SOLD_OUT) {
			result.append("sold out");
		} else if (state == NO_QUARTER) {
			result.append("waiting for quarter");
		} else if (state == HAS_QUARTER) {
			result.append("waiting for turn of crank");
		} else if (state == SOLD) {
			result.append("delivering a gumball");
		}
		result.append("\n");
		return result.toString();
	}


}