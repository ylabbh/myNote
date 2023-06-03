package 代理模式.二_简单实现.服务器.状态模式中的糖果机;

import 代理模式.二_简单实现.服务器.状态模式中的糖果机.各种状态.State;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 在真正的使用中，我们要写的其实只是这个接口。
 */
public interface GumballMachineRemote extends Remote {
	public int getCount() throws RemoteException;
	public String getLocation() throws RemoteException;
	public State getState() throws RemoteException;
}