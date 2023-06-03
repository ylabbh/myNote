package 代理模式.二_简单实现.服务器.状态模式中的糖果机;

import 代理模式.二_简单实现.服务器.状态模式中的糖果机.各种状态.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 看这里的Context和状态。我们这里状态的转换是由状态自行完成，这里并不关心。
 *
 * 我们也可以让状态转换在这里进行。
 *
 */
public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {

    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    State state = soldOutState;
    int count = 0;
    String location;
    public GumballMachine(int numberGumballs,String location) throws RemoteException {
        super();
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        this.count = numberGumballs;
        this.location = location;
        if (numberGumballs > 0) {
            state = noQuarterState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    /**
     * 如果将来设计的时候，我需要状态对象获取 这里Context中的方法或变量，就在每个行为中传入context的引用。
     */
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }

    //初始化
    public void refill(int count) {
        this.count = count;
        state = noQuarterState;
    }


    public int getCount() {
        return count;
    }


    public String getLocation(){
        return this.location;
    }

    public State getState() {
        return state;
    }
    public State getSoldOutState() {
        return soldOutState;
    }
    public State getNoQuarterState() {
        return noQuarterState;
    }
    public State getHasQuarterState() {
        return hasQuarterState;
    }
    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004");
        result.append("\n剩余: " + count + " 糖果");
        if (count != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("当前状态： " + state + "\n");
        return result.toString();
    }
}
