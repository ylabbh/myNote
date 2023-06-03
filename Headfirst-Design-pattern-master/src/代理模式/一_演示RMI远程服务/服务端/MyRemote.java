package 代理模式.一_演示RMI远程服务.服务端;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 一：制作远程接口----远程调用中的服务端（服务辅助对象 RMI STUB）
 */
//1.继承java.rmi.Remote，表示此接口用来支持远程调用
public interface MyRemote extends Remote {

    //2.开始定义提供服务的方法
    //3.注意，Remote底层用到了  网络和I/O，这很容易出现各种异常，客户端必须认识到风险，因此这里作为服务端，所有提供的远程方法都必须抛异常。
    //4.看返回值：String ----远程方法的变量和返回值，必须属于  原语类型、字符串和许多API中内定的类型（包括数组和集合），如果传送的是自己定义的类，就必须保证你的类实现了  Serializable！！
    //      因为：远程方法的变量必须被打包并通过网络运送，这要靠序列化来完成。
    public String sayHello() throws RemoteException;
}
