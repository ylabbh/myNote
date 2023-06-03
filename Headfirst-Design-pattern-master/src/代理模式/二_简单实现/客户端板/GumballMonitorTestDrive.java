package 代理模式.二_简单实现.客户端板;

import 代理模式.二_简单实现.服务器.状态模式中的糖果机.GumballMachineRemote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class GumballMonitorTestDrive {
 
	public static void main(String[] args) {
		try {
			/**
			 * 注意，这个GumballMachineRemote就是远程对象的本地代表，我调用的是GumballMachineRemote，实际上它会把请求转发到远程对象GumballMachine。
			 */
			GumballMachineRemote lookup = (GumballMachineRemote)Naming.lookup("rmi://test:8888/GumballMachineRemote");
			System.out.println(lookup.getCount());
			System.out.println(lookup.getLocation());
			System.out.println(lookup.getState());

		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}
}