package 代理模式.一_演示RMI远程服务.服务端;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * 二.制作远程实现
 */
//1.实现远程接口，扩展UnicastRemoteObject（为了使远程服务对象具备“远程”的功能。）
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    //2.设计一个不带变量的构造器，声明RemoteException（由扩展UnicastRemoteObject 构造器抛出的异常，WHY要这样？！！当类被实例化的时候，超累的构造器总是会被调用。如果超累的构造器抛异常，子类也必须抛异常。）
    protected MyRemoteImpl() throws RemoteException { }

    @Override
    public String sayHello() {
        return "服务端：“你好！！”";
    }


}
