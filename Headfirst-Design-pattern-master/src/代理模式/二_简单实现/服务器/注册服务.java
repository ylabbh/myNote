package 代理模式.二_简单实现.服务器;

import 代理模式.二_简单实现.服务器.状态模式中的糖果机.GumballMachine;
import 代理模式.二_简单实现.服务器.状态模式中的糖果机.GumballMachineRemote;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class 注册服务 {

    public static void main(String[] args) {
        GumballMachineRemote gumballMachine1 = null;

        try {
            //MyRemote service = new MyRemoteImpl();
            gumballMachine1 = new GumballMachine(1000, "中山公园门口");

            LocateRegistry.createRegistry(8888);
            //Naming.bind("rmi://localhost:8888/RemoteHello", service);Naming.bind("rmi://localhost:8888/RemoteHello", service);
            Naming.bind("rmi://localhost:8888/GumballMachineRemote", gumballMachine1);
            System.out.println("远程服务绑定成功！！gumballmachine");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
